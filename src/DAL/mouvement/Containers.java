package DAL.mouvement;

public class Containers {
    private String id;
    private String id_societe;
    private String nature_contenu;
    private float capacite;
    private String dangers_particuliers;

    public Containers()
    {
    }

    public Containers(String id, String id_societe, float capacite, String dangers_particuliers)
    {
        setId(id);
        setId_societe(id_societe);
        setCapacite(capacite);
        setDangers_particuliers(dangers_particuliers);
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

    public String getNature_contenu()
    {
        return nature_contenu;
    }

    public void setNature_contenu(String nature_contenu)
    {
        this.nature_contenu = nature_contenu;
    }

    public float getCapacite()
    {
        return capacite;
    }

    public void setCapacite(float capacite)
    {
        this.capacite = capacite;
    }

    public String getDangers_particuliers()
    {
        return dangers_particuliers;
    }

    public void setDangers_particuliers(String dangers_particuliers)
    {
        this.dangers_particuliers = dangers_particuliers;
    }

    @Override
    public String toString()
    {
        return "Containers{" +
                "id='" + id + '\'' +
                ", id_societe='" + id_societe + '\'' +
                ", nature_contenu='" + nature_contenu + '\'' +
                ", capacite=" + capacite +
                ", dangers_particuliers='" + dangers_particuliers + '\'' +
                '}';
    }
}