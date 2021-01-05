package Serveur;


import java.io.*;
import java.net.Socket;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.sql.SQLException;
import Protocol.RequeteIOBREP;
import Reseau.Reseau;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class ThreadClient extends Thread
{
    private String nom;
    private ListeSocket listeSocket;
    private Socket socket;


    public ThreadClient(ListeSocket list, String n)
    {
        listeSocket = list;
        nom = n;
    }

    @Override
    public void run()
    {
        boolean connected;
        int indiceCourant;

        try
        {
            while (!isInterrupted())
            {
                System.out.println(nom + " : Tread client avant get");
                socket = listeSocket.getSocket();
                DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                indiceCourant = listeSocket.getIndiceCourant(socket);
                System.out.println("\nConnexion etablie avec le client " + indiceCourant);
                connected = true;

                while (connected)
                {
                    try
                    {
                        StringBuffer message = new StringBuffer();
                        RequeteIOBREP requeteIOBREP = new RequeteIOBREP(0, "");
                        message = Reseau.msgRecv(dis);
                        System.out.println(nom + " : Message reçu = " + message.toString());

                        if(!message.toString().equals("") || !message.toString().equals("\r\n"))
                        {
                            int type = Integer.parseInt(message.substring(0, 1));
                            String chargeUtile = message.substring(1).replace("\r\n", "");

                            System.out.println(" type = " + type);
                            System.out.println(" ChargeUtile = " + chargeUtile);


                            requeteIOBREP.setType(type);
                            requeteIOBREP.setChargeUtile(chargeUtile);
                            requeteIOBREP.setSocketClient(socket);
                            requeteIOBREP.createRunnable(socket, listeSocket, dis, dos);
                            System.out.println("Client IP: " + socket.getInetAddress());

                            if (type == 5)
                            {
                                connected = false;
                            }
                        }
                    } catch (IOException e)
                    {
                        System.err.println("Erreur: " + e.getMessage());

                    }
                }
            }

        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (InstantiationException e)
        {
            e.printStackTrace();
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}