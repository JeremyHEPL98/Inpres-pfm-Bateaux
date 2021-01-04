package Serveur;

import java.net.Socket;
import java.util.LinkedList;

public class ListeSocket {

    private LinkedList<Socket> socketList;
    public ListeSocket()
    {
        socketList = new LinkedList<>();
    }
    int indiceCourant = -1;
    int nbrListe;

    public void initListe(int nbr)
    {
        nbrListe = nbr;
        for (int i = 0; i < nbr ;i++)
        {
            socketList.add(null);
        }
    }
    public synchronized void addSocket(Socket s, int nCourant)
    {
        indiceCourant = nCourant;

        socketList.set(nCourant,s);
        notify();
    }

    public synchronized Socket getSocket() throws InterruptedException
    {

        wait();
        Socket s = socketList.get(indiceCourant);

        indiceCourant = -1;
        return s;
    }

    public int getSize ()
    {
        return socketList.size();
    }

    public Socket getIndice(int n)
    {
        return socketList.get(n);
    }

    public int getIndiceCourant(Socket socket)
    {
        int i = 0;
        while(socket != getIndice(i) && i<nbrListe)
        {
            i++;
        }
        return i;
    }

    public void setValeur(int val, Socket socket)
    {
        socketList.set(val, socket);
    }
}
