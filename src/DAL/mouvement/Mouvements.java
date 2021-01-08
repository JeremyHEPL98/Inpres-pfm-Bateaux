package DAL.mouvement;

import java.util.Date;

public class Mouvements
{
    private int id;
    private String id_container;
    private String id_transporteur_entrant;
    private String date_arrivee;
    private String id_transpoorteur_sortant;
    private float poids; // contenant + contenu
    private String date_depart;
    private String destination;

    public Mouvements()
    {
    }

    public Mouvements(int id, String id_container, String id_transporteur_entrant, String date_arrivee, String id_transpoorteur_sortant, float poids, String date_depart, String destination)
    {
        this.id = id;
        this.id_container = id_container;
        this.id_transporteur_entrant = id_transporteur_entrant;
        this.date_arrivee = date_arrivee;
        this.id_transpoorteur_sortant = id_transpoorteur_sortant;
        this.poids = poids;
        this.date_depart = date_depart;
        this.destination = destination;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getId_container()
    {
        return id_container;
    }

    public void setId_container(String id_container)
    {
        this.id_container = id_container;
    }

    public String getId_transporteur_entrant()
    {
        return id_transporteur_entrant;
    }

    public void setId_transporteur_entrant(String id_transporteur_entrant)
    {
        this.id_transporteur_entrant = id_transporteur_entrant;
    }

    public String getDate_arrivee()
    {
        return date_arrivee;
    }

    public void setDate_arrivee(String date_arrivee)
    {
        this.date_arrivee = date_arrivee;
    }

    public String getId_transpoorteur_sortant()
    {
        return id_transpoorteur_sortant;
    }

    public void setId_transpoorteur_sortant(String id_transpoorteur_sortant)
    {
        this.id_transpoorteur_sortant = id_transpoorteur_sortant;
    }

    public float getPoids()
    {
        return poids;
    }

    public void setPoids(float poids)
    {
        this.poids = poids;
    }

    public String getDate_depart()
    {
        return date_depart;
    }

    public void setDate_depart(String date_depart)
    {
        this.date_depart = date_depart;
    }

    public String getDestination()
    {
        return destination;
    }

    public void setDestination(String destination)
    {
        this.destination = destination;
    }

    @Override
    public String toString()
    {
        return "Mouvements{" +
                "id=" + id +
                ", id_container='" + id_container + '\'' +
                ", id_transporteur_entrant='" + id_transporteur_entrant + '\'' +
                ", date_arrivee='" + date_arrivee + '\'' +
                ", id_transpoorteur_sortant='" + id_transpoorteur_sortant + '\'' +
                ", poids=" + poids +
                ", date_depart='" + date_depart + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }
}
