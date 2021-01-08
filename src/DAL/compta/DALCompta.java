package DAL.compta;

import BeansDB.BeanCRUD;

import java.beans.Beans;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DALCompta
{
    public BeanCRUD crud;


    public DALCompta() throws IOException, ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException
    {
        crud = (BeanCRUD) Beans.instantiate(null, "BeansDB.BeanCRUD");
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        crud.setAddress("jdbc:mysql://quackula.duckdns.org:33006/BD_Compta");
        //crud.setAddress("jdbc:mysql://192.168.1.10:3306/BD_Compta");
        crud.setUsername("compta");
        crud.setPassword("compta");
        crud.ConnectToDB();
        crud.setInstruction(crud.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY));
        crud.getConnection().setAutoCommit(true);

    }

    //region Dal SAMOP
    public Personnel getPersonnel(int id_personnel) throws SQLException
    {
        ResultSet rs;
        Personnel p = new Personnel();
        rs = crud.Select("SELECT * FROM Personnel WHERE id = " + id_personnel);
        rs.next();
        p.setId(rs.getInt(1));
        p.setNom(rs.getString(2));
        p.setPrenom(rs.getString(3));
        p.setLogin(rs.getString(4));
        p.setPassword(rs.getString(5));
        p.setEmail(rs.getString(6));
        p.setFunction(rs.getString(7));

        return p;
    }

    public Personnel getPersonnelName(String username)
    {
        try
        {

            ResultSet rs;
            Personnel p = new Personnel();
            rs = crud.Select("SELECT * FROM Personnel WHERE login = " + "'" + username + "'");
            rs.next();
            p.setId(rs.getInt(1));
            p.setNom(rs.getString(2));
            p.setPrenom(rs.getString(3));
            p.setLogin(rs.getString(4));
            p.setPassword(rs.getString(5));
            p.setEmail(rs.getString(6));
            p.setFunction(rs.getString(7));

            return p;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return  null;
        }
    }
}
