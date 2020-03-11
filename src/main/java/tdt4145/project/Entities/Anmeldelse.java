package tdt4145.project.Entities;

import tdt4145.project.DBConn;

public class Anmeldelse extends DBConn {
    private int AnmeldelseID;
    private String tekst;
    private int rating;
    private Bruker bruker;
    private Media media;
    private int nummer;
    private Serie serie;

    public Anmeldelse(int anmeldelseID, String tekst, int rating, Bruker bruker, Media media, int nummer, Serie serie) {
        AnmeldelseID = anmeldelseID;
        this.tekst = tekst;
        this.rating = rating;
        this.bruker = bruker;
        this.media = media;
        this.nummer = nummer;
        this.serie = serie;
    }

    public int getAnmeldelseID() {
        return AnmeldelseID;
    }

    public void setAnmeldelseID(int anmeldelseID) {
        AnmeldelseID = anmeldelseID;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Bruker getBruker() {
        return bruker;
    }

    public void setBruker(Bruker bruker) {
        this.bruker = bruker;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
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
        return "Anmeldelse{" +
                "AnmeldelseID=" + AnmeldelseID +
                ", tekst='" + tekst + '\'' +
                ", rating=" + rating +
                ", bruker=" + bruker +
                ", media=" + media +
                ", nummer=" + nummer +
                ", serie=" + serie +
                '}';
    }
}
