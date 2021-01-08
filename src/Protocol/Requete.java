package Protocol;

import Serveur.ListeSocket;

import javax.crypto.SecretKey;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.PublicKey;
import java.sql.SQLException;
import java.util.ArrayList;

public interface Requete {

    public void createRunnable(Socket s, ListeSocket listeSocket, DataInputStream dis, DataOutputStream dos, ArrayList<String> listConWait) throws SQLException;
}
