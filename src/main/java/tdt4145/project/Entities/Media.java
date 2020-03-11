package tdt4145.project.Entities;

public class Media  {
    private String MediaID;
    private String tittel;
    private String utgivelsesår;
    private String lanseringsdato;
    private String beskrivelse;
    private int lengde;
    private Selskap selskap;

    public Media(String mediaID, String tittel, String utgivelsesår, String lanseringsdato, String beskrivelse, int lengde, Selskap selskap) {
        MediaID = mediaID;
        this.tittel = tittel;
        this.utgivelsesår = utgivelsesår;
        this.lanseringsdato = lanseringsdato;
        this.beskrivelse = beskrivelse;
        this.lengde = lengde;
        this.selskap = selskap;
    }

    public String getMediaID() {
        return MediaID;
    }

    public void setMediaID(String mediaID) {
        MediaID = mediaID;
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public String getUtgivelsesår() {
        return utgivelsesår;
    }

    public void setUtgivelsesår(String utgivelsesår) {
        this.utgivelsesår = utgivelsesår;
    }

    public String getLanseringsdato() {
        return lanseringsdato;
    }

    public void setLanseringsdato(String lanseringsdato) {
        this.lanseringsdato = lanseringsdato;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public int getLengde() {
        return lengde;
    }

    public void setLengde(int lengde) {
        this.lengde = lengde;
    }

    public Selskap getSelskap() {
        return selskap;
    }

    public void setSelskap(Selskap selskap) {
        this.selskap = selskap;
    }

    @Override
    public String toString() {
        return "Media{" +
                "MediaID='" + MediaID + '\'' +
                ", tittel='" + tittel + '\'' +
                ", utgivelsesår='" + utgivelsesår + '\'' +
                ", lanseringsdato='" + lanseringsdato + '\'' +
                ", beskrivelse='" + beskrivelse + '\'' +
                ", lengde=" + lengde +
                ", selskap=" + selskap +
                '}';
    }
}
