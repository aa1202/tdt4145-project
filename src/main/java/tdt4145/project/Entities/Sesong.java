package tdt4145.project.Entities;

public class Sesong {
    private int nummer;
    private Serie serie;

    public Sesong(int nummer, Serie serie) {
        this.nummer = nummer;
        this.serie = serie;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    @Override
    public String toString() {
        return "Sesong{" +
                "nummer=" + nummer +
                ", serie=" + serie +
                '}';
    }
}
