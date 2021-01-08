package BeansDB;
import java.io.Serializable;
import java.sql.*;

public class BeanConnection implements Serializable
{
    private Connection connection;
    private String address;
    private String username;
    private String password;

    public BeanConnection()
    {
        // empty
    }

    public void ConnectToDB() throws ClassNotFoundException, SQLException, SQLException {
        setConnection(DriverManager.getConnection(getAddress(), getUsername(), getPassword()));
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connnection) {
        this.connection = connnection;
    }

}