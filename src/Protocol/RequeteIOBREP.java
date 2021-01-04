package Protocol;

import Serveur.ListeSocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.Security;
import java.sql.SQLException;
import java.util.Hashtable;

public class RequeteIOBREP implements Requete {
    public static final int REQUEST_LOGIN = 1;
    public static final int REQUEST_GET_CONTAINERS  = 2;
    public static final int REQUEST_HANDLE_CONTAINER_OUT  = 3;
    public static final int REQUEST_END_CONTAINER_OUT = 4;
    public static final int REQUEST_BOAT_ARRIVED  = 5;
    public static final int REQUEST_HANDLE_CONTAINER_IN  = 6;
    public static final int REQUEST_END_CONTAINER_IN  = 7;

    private int type;
    private String chargeUtile;
    private Socket socketClient;
    ListeSocket listeSocket;
    //public DALCompta dal;

    public RequeteIOBREP(int t, String chu) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        type = t;
        setChargeUtile(chu);
        //dal = new DALCompta();

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
    public void createRunnable(Socket s, ListeSocket listeSocket, DataInputStream dis, DataOutputStream dos) {

        listeSocket = listeSocket;
        switch (type) {
            case REQUEST_LOGIN:
                traiterRequete_LOGIN(s, dos, dis);
                break;
            case REQUEST_GET_CONTAINERS:
                traiterRequete_GET_CONTAINERS(s, dos, dis);
                break;
            case REQUEST_HANDLE_CONTAINER_OUT:

                traiterRequete_HANDLE_CONTAINER_OUT(s, dos, dis);
                break;
            case REQUEST_END_CONTAINER_OUT:
                traiterRequete_END_CONTAINER_OUT(s, dos, dis);
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

    }

    private void traiterRequete_GET_CONTAINERS(Socket socket, DataOutputStream dos, DataInputStream dis){
        System.out.println("GET_CONTAINERS");
    }

    private void traiterRequete_HANDLE_CONTAINER_OUT(Socket socket, DataOutputStream dos, DataInputStream dis){
        System.out.println("HANDLE_CONTAINER_OUT");
    }
    private void traiterRequete_END_CONTAINER_OUT(Socket socket, DataOutputStream dos, DataInputStream dis){
        System.out.println("END_CONTAINER_OUT");
    }

    private void traiterRequete_BOAT_ARRIVED(Socket socket, DataOutputStream dos, DataInputStream dis){
        System.out.println("BOAT_ARRIVED");
    }

    private void traiterRequete_HANDLE_CONTAINER_IN(Socket socket, DataOutputStream dos, DataInputStream dis){
        System.out.println("HANDLE_CONTAINER_I");
    }

    private void traiterRequete_END_CONTAINER_IN(Socket socket, DataOutputStream dos, DataInputStream dis){
        System.out.println("END_CONTAINER_IN");
    }



}
