package tdt4145.project.Entities;

public class Sjanger {
    private int SjangerID;
    private String sjanger;

    public Sjanger(int sjangerID, String sjanger) {
        SjangerID = sjangerID;
        this.sjanger = sjanger;
    }

    public int getSjangerID() {
        return SjangerID;
    }

    public void setSjangerID(int sjangerID) {
        SjangerID = sjangerID;
    }

    public String getSjanger() {
        return sjanger;
    }

    public void setSjanger(String sjanger) {
        this.sjanger = sjanger;
    }

    @Override
    public String toString() {
        return "Sjanger{" +
                "SjangerID=" + SjangerID +
                ", sjanger='" + sjanger + '\'' +
                '}';
    }
}
