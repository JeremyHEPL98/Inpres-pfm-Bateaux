package DAL.mouvement;

public class Societes {
    private String id;
    private String contact_nom;
    private String contact_email;
    private String contact_telephone;
    private String adresse;

    public Societes()
    {
    }

    public Societes(String id, String contact_nom, String contact_email, String contact_telephone, String adresse) {
        setId(id);
        setContact_nom(contact_nom);
        setContact_email(contact_email);
        setContact_telephone(contact_telephone);
        setAdresse(adresse);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContact_nom() {
        return contact_nom;
    }

    public void setContact_nom(String contact_nom) {
        this.contact_nom = contact_nom;
    }

    public String getContact_email() {
        return contact_email;
    }

    public void setContact_email(String contact_email) {
        this.contact_email = contact_email;
    }

    public String getContact_telephone() {
        return contact_telephone;
    }

    public void setContact_telephone(String contact_telephone) {
        this.contact_telephone = contact_telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString()
    {
        return "Societes{" +
                "id='" + id + '\'' +
                ", contact_nom='" + contact_nom + '\'' +
                ", contact_email='" + contact_email + '\'' +
                ", contact_telephone='" + contact_telephone + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}