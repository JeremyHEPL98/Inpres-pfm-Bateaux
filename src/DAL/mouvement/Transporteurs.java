package DAL.mouvement;

public class Transporteurs {
    private String id;
    private String id_societe;
    private int capacite;
    private String caracteristiques;

    public Transporteurs() {
    }

    public Transporteurs(String id, String id_societe, int capacite, String caracteristiques)
    {
        this.id = id;
        this.id_societe = id_societe;
        this.capacite = capacite;
        this.caracteristiques = caracteristiques;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId_societe()
    {
        return id_societe;
    }

    public void setId_societe(String id_societe)
    {
        this.id_societe = id_societe;
    }

    public int getCapacite()
    {
        return capacite;
    }

    public void setCapacite(int capacite)
    {
        this.capacite = capacite;
    }

    public String getCaracteristiques()
    {
        return caracteristiques;
    }

    public void setCaracteristiques(String caracteristiques)
    {
        this.caracteristiques = caracteristiques;
    }

    @Override
    public String toString()
    {
        return "Transporteurs{" +
                "id='" + id + '\'' +
                ", id_societe='" + id_societe + '\'' +
                ", capacite=" + capacite +
                ", caracteristiques='" + caracteristiques + '\'' +
                '}';
    }
}