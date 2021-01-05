package Serveur;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadServeur  extends Thread
{
    public static int NB_MAX_CLIENTS = 3;//Integer.valueOf(LoginProperties.nomFichier = ConfigProperties.GetValue("nb-threads"));
    private final int port = 50010; //Integer.valueOf(LoginProperties.nomFichier = ConfigProperties.GetValue("port_mouv"));
    public static int NB_MAX_CLIENTS_SALARY= 3;//Integer.valueOf(LoginProperties.nomFichier = ConfigProperties.GetValue("nb-threads"));
    private ServerSocket SSocket = null;
    Socket CSocket;
    private ListeSocket listeSocket = new ListeSocket();



    @Override
    public void run()
    {
        try
        {
            SSocket = new ServerSocket(port);
        }
        catch (IOException e)
        {
            System.err.println("Erreur de port d'écoute ! ? [" + e + "]"); System.exit(1);
        }

        listeSocket.initListe(NB_MAX_CLIENTS);


        for (int i=0; i< NB_MAX_CLIENTS; i++)
        {
            ThreadClient thr = new ThreadClient (listeSocket, "ThreadBATEAU du pool n°" + String.valueOf(i));
            thr.start();
        }

        while (!isInterrupted())
        {
            try
            {
                System.out.println("************ Serveur en attente");
                CSocket = SSocket.accept();
                int j;
                for ( j = 0; j < NB_MAX_CLIENTS && listeSocket.getIndice(j) != null ; j++)
                    ; // empty, that's normal it's how it's supposed to be

                if(j == NB_MAX_CLIENTS )
                {
                    System.out.println("Plus de connexion disponible");
                    CSocket.close();
                }
                else
                {
                    int nbr = listeSocket.getSize();
                    listeSocket.addSocket(CSocket, j);
                }
            }
            catch (IOException e)
            {
                System.err.println("Erreur d'accept ! ? [" + e.getMessage() + "]");
                System.exit(1);
            }
        }

    }
}
