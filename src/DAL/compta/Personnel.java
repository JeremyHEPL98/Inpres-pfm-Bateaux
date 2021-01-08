package DAL.compta;

public class Personnel
{
    public static final String manutentionnaire =  "manutentionnaire";
    public static final String chef_equipe =  "chef d'équipe";
    public static final String preposé =  "préposé";
    public static final String chef_de_poste =  "chef de poste";
    public static final String comptable =  "comptable";
    public static final String chef_comptable =  "chef-comptable";
    public static final String directeur =  "directeur";

    private int id;
    private String nom;
    private String prenom;
    private String login;
    private String password;
    private String email;
    private String function;

    public Personnel()
    {

    }

    public Personnel(int id, String nom, String prenom, String login, String password, String email, String function)
    {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
        this.email = email;
        this.function = function;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public String getPrenom()
    {
        return prenom;
    }

    public void setPrenom(String prenom)
    {
        this.prenom = prenom;
    }

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getFunction()
    {
        return function;
    }

    public void setFunction(String function)
    {
        this.function = function;
    }
}
