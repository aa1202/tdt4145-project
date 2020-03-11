package tdt4145.project.Entities;

public class Musikk {
    private int MusikkID;
    private String tittel;

    public Musikk(int musikkID, String tittel) {
        MusikkID = musikkID;
        this.tittel = tittel;
    }

    public int getMusikkID() {
        return MusikkID;
    }

    public void setMusikkID(int musikkID) {
        MusikkID = musikkID;
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    @Override
    public String toString() {
        return "Musikk{" +
                "MusikkID=" + MusikkID +
                ", tittel='" + tittel + '\'' +
                '}';
    }
}
