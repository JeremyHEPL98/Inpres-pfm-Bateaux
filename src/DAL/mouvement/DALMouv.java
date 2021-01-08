package DAL.mouvement;

import BeansDB.BeanCRUD;

import java.beans.Beans;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public class DALMouv
{
    public BeanCRUD crud;

    public DALMouv() throws IOException, ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {

        crud = (BeanCRUD) Beans.instantiate(null, "BeansDB.BeanCRUD");
        //dal.crud = (BeanCRUD) Beans.instantiate(null, "InterfaceBD.Beans.BeanCRUD");
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        crud.setAddress("jdbc:mysql://quackula.duckdns.org:33006/rti");
        crud.setUsername("rti");
        crud.setPassword("rti");
        crud.ConnectToDB();
        crud.setInstruction(crud.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE));
        crud.getConnection().setAutoCommit(false);
    }

    public Vector<Parc> loadListValidateSal(String dest, String typeOrdre)
    {
        String instructionS = "SELECT * from Parc where status = 2  and destination = " + "'" + dest + "'" ;//+ "ORDER BY";
        ResultSet rs;
        Parc p ;
        Vector<Parc> liste = new Vector<>() ;

        try
        {
            System.out.println( "On envoie: " + instructionS);
            rs = crud.Select(instructionS);
            int cpt = 0;
            while (rs.next())
            {
                System.out.println("Ajout d'une facture dans la liste: " + cpt++);
                p =  new Parc();
                p.setX(rs.getInt(1));
                p.setY(rs.getInt(2));
                p.setId_container(rs.getString(3));
                p.setStatut(rs.getInt(4));
                p.setNum_reservation(rs.getString(5));
                p.setDate_reservation(rs.getString(6));
                p.setDate_arrivee(rs.getString(7));
                p.setPoids(rs.getFloat(8));
                p.setDestination(rs.getString(9));
                p.setType_transport(rs.getString(10));

                liste.add(p);
            }

            return liste;
        }
        catch (SQLException ex)
        {
            System.err.println("SQLError: " + ex.getMessage());
            return null;
        }
        catch (Exception ex)
        {
            System.err.println("Error: " + ex.getMessage());
            return null;
        }
    }

    public boolean setContainer(ArrayList<String> list) {
        try
        {
            for (String s: list)
            {
                String instruction = "UPDATE Parc SET id_container = null, status = 0, num_reservation = null, date_reservation = null, date_arrivee = null, poids = null, destination = null, type_transport = null WHERE id_container = '" + s + "'";
                System.out.println("On envoie: " + instruction);
                crud.Update(instruction);
            }
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
    public boolean setBat(String id, String dest) {

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateS = formatter.format(date);
        try
        {
            String instruction = "INSERT INTO Transporteurs  VALUES ('" + id + "', 'MPLO', '500', 'Bateau' )";
            crud.Insert(instruction);

            String instruction1 = "Select Max(id) from Mouvements";
            ResultSet rs;
            rs = crud.Select(instruction1);

            int idold = rs.getInt(0);

            String instruction2 = "INSERT INTO Mouvements  VALUES (" + idold + 1 + ", null, '" + id + "', " + "'" + dateS + "'" + ", null, 10, 10/01/2021," + "'"  + dest + "' )";
            crud.Insert(instruction2);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
}