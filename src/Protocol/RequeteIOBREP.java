package Protocol;

import DAL.compta.DALCompta;
import DAL.compta.Personnel;
import DAL.mouvement.DALMouv;
import DAL.mouvement.Parc;
import Reseau.Reseau;
import Serveur.ListeSocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.Security;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.Vector;

public class RequeteIOBREP implements Requete {
    public static final int REQUEST_LOGIN = 1;
    public static final int REQUEST_GET_CONTAINERS  = 2;
    public static final int REQUEST_HANDLE_CONTAINER_OUT  = 3;
    public static final int REQUEST_END_CONTAINER_OUT = 4;
    public static final int REQUEST_BOAT_ARRIVED  = 5;
    public static final int REQUEST_HANDLE_CONTAINER_IN  = 6;
    public static final int REQUEST_END_CONTAINER_IN  = 7;
    private static DALCompta dalC;
    private static DALMouv dalM;


    private int type;
    private String chargeUtile;
    private Socket socketClient;
    ListeSocket listeSocket;


    public RequeteIOBREP(int t, String chu) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        type = t;
        setChargeUtile(chu);
        dalC = new DALCompta();
        dalM = new DALMouv();

    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getChargeUtile() {
        return chargeUtile;
    }

    public void setChargeUtile(String chargeUtile) {
        this.chargeUtile = chargeUtile;
    }

    public Socket getSocketClient() {
        return socketClient;
    }

    public void setSocketClient(Socket socketClient) {
        this.socketClient = socketClient;
    }

    @Override
    public void createRunnable(Socket s, ListeSocket listeSocket, DataInputStream dis, DataOutputStream dos, ArrayList<String> listConWait){

        listeSocket = listeSocket;
        switch (type) {
            case REQUEST_LOGIN:
                traiterRequete_LOGIN(s, dos, dis);
                break;
            case REQUEST_GET_CONTAINERS:
                traiterRequete_GET_CONTAINERS(s, dos, dis);
                break;
            case REQUEST_HANDLE_CONTAINER_OUT:

                traiterRequete_HANDLE_CONTAINER_OUT(s, dos, dis, listConWait);
                break;
            case REQUEST_END_CONTAINER_OUT:
                traiterRequete_END_CONTAINER_OUT(s, dos, dis, listConWait);
                break;
            case REQUEST_BOAT_ARRIVED:
                traiterRequete_BOAT_ARRIVED(s, dos, dis);
                break;
            case REQUEST_HANDLE_CONTAINER_IN:
                traiterRequete_HANDLE_CONTAINER_IN(s, dos, dis);
                break;
            case REQUEST_END_CONTAINER_IN:
                traiterRequete_END_CONTAINER_IN(s, dos, dis);
                break;
            default:
                break;
        }

    }

    private void traiterRequete_LOGIN(Socket socket, DataOutputStream dos, DataInputStream dis){
        System.out.println("LOGIN");
        StringTokenizer tokenizer = new StringTokenizer(getChargeUtile(), ";");
        String username = tokenizer.nextToken();
        String password = tokenizer.nextToken();

        Personnel p = chercheMotDePasse(username,password);

        if(p != null)
        {
            Reseau.msgSend("201Login successful", dos);
        }
        else
        {
            Reseau.msgSend("501Login failed", dos);
        }

    }

    private void traiterRequete_GET_CONTAINERS(Socket socket, DataOutputStream dos, DataInputStream dis){
        System.out.println("GET_CONTAINERS");
        Vector<Parc> listParc;
        StringTokenizer tokenizer = new StringTokenizer(getChargeUtile(), ";");
        String dest = tokenizer.nextToken();
        String ordre = tokenizer.nextToken();
        listParc = dalM.loadListValidateSal(dest, ordre);

        String reponse = "";
        if (listParc.isEmpty())
        {
            reponse = "502" + "Not containers wait";

        }
        else
        {
            reponse = "202";
            for (Parc p : listParc) {
                //ajouter l'objet au message
                reponse = reponse + p.toString();
                //ajouter le ";" au message
                reponse = reponse + "$";
            }
        }

        Reseau.msgSend(reponse,dos);

    }

    private void traiterRequete_HANDLE_CONTAINER_OUT(Socket socket, DataOutputStream dos, DataInputStream dis , ArrayList<String> listConWait){
        System.out.println("HANDLE_CONTAINER_OUT");
        System.out.println("Container memorise");
        listConWait.add(getChargeUtile());

        Reseau.msgSend("203",dos);

    }
    private void traiterRequete_END_CONTAINER_OUT(Socket socket, DataOutputStream dos, DataInputStream dis, ArrayList<String> listConWait) {
        System.out.println("END_CONTAINER_OUT");
        boolean ok;
        String msgSend = "";

            ok = dalM.setContainer(listConWait);

            if(ok)
            {
                msgSend = "204";
            }
            else
            {
                msgSend = "504Update failed";
            }
            Reseau.msgSend(msgSend,dos);
    }

    private void traiterRequete_BOAT_ARRIVED(Socket socket, DataOutputStream dos, DataInputStream dis){
        System.out.println("BOAT_ARRIVED");

        StringTokenizer tokenizer = new StringTokenizer(getChargeUtile(), ";");
        String id = tokenizer.nextToken();
        String dest = tokenizer.nextToken();
        boolean ok;
        String msgSend = "";

        ok = dalM.setBat(id, dest);

        if(ok)
        {
            msgSend = "205";
        }
        else
        {
            msgSend = "505Ajout bateau failed";
        }
        Reseau.msgSend(msgSend,dos);
    }

    private void traiterRequete_HANDLE_CONTAINER_IN(Socket socket, DataOutputStream dos, DataInputStream dis){
        System.out.println("HANDLE_CONTAINER_I");
    }

    private void traiterRequete_END_CONTAINER_IN(Socket socket, DataOutputStream dos, DataInputStream dis){
        System.out.println("END_CONTAINER_IN");
    }

    protected static Personnel chercheMotDePasse (String user, String pwd) {
        String pwdDB;
        Personnel p = dalC.getPersonnelName(user);
        if(p != null)
        {
            pwdDB = p.getPassword();
            if(pwdDB.equals(pwd))
            {
                return p;
            }
            else
            {
                return null;
            }
        }
        {
            return null;
        }
    }

}
