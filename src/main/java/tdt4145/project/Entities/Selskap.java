package tdt4145.project.Entities;

public class Selskap {
    private int SelskapID;
    private String url;
    private String land;
    private String addresse;

    public Selskap(int selskapID, String url, String land, String addresse) {
        SelskapID = selskapID;
        this.url = url;
        this.land = land;
        this.addresse = addresse;
    }

    public int getSelskapID() {
        return SelskapID;
    }

    public void setSelskapID(int selskapID) {
        SelskapID = selskapID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    @Override
    public String toString() {
        return "Selskap{" +
                "SelskapID=" + SelskapID +
                ", url='" + url + '\'' +
                ", land='" + land + '\'' +
                ", addresse='" + addresse + '\'' +
                '}';
    }
}
