package Reseau;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Reseau {



    public static void msgSend (String msg, DataOutputStream dos)
    {
        msg = msg + "\r\n";
        try {
            dos.writeBytes(msg);dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static StringBuffer msgRecv( DataInputStream dis)
    {
        StringBuffer message = new StringBuffer();
        byte b=0;
        byte preb = 0;
        message.setLength(0);

        try
        {
            while ( preb != (byte)'\r' & b != (byte)'\n'   )
            {
                b = dis.readByte();
                message.append((char) b);
            }

        }
        catch (IOException e)
        {
            System.out.println("Erreur de lecture = " + e.getMessage());
        }

        return message;

    }


}

