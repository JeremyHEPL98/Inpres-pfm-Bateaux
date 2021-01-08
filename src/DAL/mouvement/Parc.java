package DAL.mouvement;

import java.util.Date;

public class Parc
{
    private int x;
    private int y;
    private String id_container;
    private int statut;
    private String num_reservation;
    private String date_reservation;
    private String date_arrivee;
    private float poids;
    private String destination;
    private String type_transport;

    public Parc()
    {
    }

    public Parc(int x, int y, String id_container, int statut, String num_reservation, String date_reservation, String date_arrivee, float poids, String destination, String type_transport)
    {
        this.x = x;
        this.y = y;
        this.id_container = id_container;
        this.statut = statut;
        this.num_reservation = num_reservation;
        this.date_reservation = date_reservation;
        this.date_arrivee = date_arrivee;
        this.poids = poids;
        this.destination = destination;
        this.type_transport = type_transport;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public String getId_container()
    {
        return id_container;
    }

    public void setId_container(String id_container)
    {
        this.id_container = id_container;
    }

    public int getStatut()
    {
        return statut;
    }

    public void setStatut(int statut)
    {
        this.statut = statut;
    }

    public String getNum_reservation()
    {
        return num_reservation;
    }

    public void setNum_reservation(String num_reservation)
    {
        this.num_reservation = num_reservation;
    }

    public String getDate_reservation()
    {
        return date_reservation;
    }

    public void setDate_reservation(String date_reservation)
    {
        this.date_reservation = date_reservation;
    }

    public String getDate_arrivee()
    {
        return date_arrivee;
    }

    public void setDate_arrivee(String date_arrivee)
    {
        this.date_arrivee = date_arrivee;
    }

    public float getPoids() {
        return poids;
    }
    public void setPoids(float poids)
    {
        this.poids = poids;
    }

    public String getDestination()
    {
        return destination;
    }

    public void setDestination(String destination)
    {
        this.destination = destination;
    }

    public String getType_transport()
    {
        return type_transport;
    }

    public void setType_transport(String type_transport)
    {
        this.type_transport = type_transport;
    }

    @Override
    public String toString()
    {
        return "Parc{" +
                "x=" + x +
                ", y=" + y +
                ", id_container='" + id_container + '\'' +
                ", statut=" + statut +
                ", num_reservation='" + num_reservation + '\'' +
                ", date_reservation='" + date_reservation + '\'' +
                ", date_arrivee='" + date_arrivee + '\'' +
                ", poids=" + poids +
                ", destination='" + destination + '\'' +
                ", type_transport='" + type_transport + '\'' +
                '}';
    }
}