package tdt4145.project.Entities;

import tdt4145.project.DBConn;

public class Bruker extends DBConn {
    private int BrukerID;
    private String brukernavn;

    public Bruker(int brukerID, String brukernavn) {
        BrukerID = brukerID;
        this.brukernavn = brukernavn;
    }

    public int getBrukerID() {
        return BrukerID;
    }

    public void setBrukerID(int brukerID) {
        BrukerID = brukerID;
    }

    public String getBrukernavn() {
        return brukernavn;
    }

    public void setBrukernavn(String brukernavn) {
        this.brukernavn = brukernavn;
    }

    @Override
    public String toString() {
        return "Bruker{" +
                "BrukerID=" + BrukerID +
                ", brukernavn='" + brukernavn + '\'' +
                '}';
    }
}
