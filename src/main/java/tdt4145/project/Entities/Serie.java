package tdt4145.project.Entities;

public class Serie {
    private int SerieID;
    private String tittel;

    public Serie(int serieID, String tittel) {
        SerieID = serieID;
        this.tittel = tittel;
    }

    public int getSerieID() {
        return SerieID;
    }

    public void setSerieID(int serieID) {
        SerieID = serieID;
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "SerieID=" + SerieID +
                ", tittel='" + tittel + '\'' +
                '}';
    }
}
