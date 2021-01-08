package DAL.mouvement;

public class Destinations {
    private String ville;
    private int distance_bateau;
    private int distance_train;
    private int distance_route;

    public Destinations() {
    }

    public Destinations(String ville, int distance_bateau, int distance_train, int distance_route) {
        this.ville = ville;
        this.distance_bateau = distance_bateau;
        this.distance_train = distance_train;
        this.distance_route = distance_route;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getDistance_bateau() {
        return distance_bateau;
    }

    public void setDistance_bateau(int distance_bateau) {
        this.distance_bateau = distance_bateau;
    }

    public int getDistance_train() {
        return distance_train;
    }

    public void setDistance_train(int distance_train) {
        this.distance_train = distance_train;
    }

    public int getDistance_route() {
        return distance_route;
    }

    public void setDistance_route(int distance_route) {
        this.distance_route = distance_route;
    }

    @Override
    public String toString()
    {
        return "Destinations{" +
                "ville='" + ville + '\'' +
                ", distance_bateau=" + distance_bateau +
                ", distance_train=" + distance_train +
                ", distance_route=" + distance_route +
                '}';
    }
}