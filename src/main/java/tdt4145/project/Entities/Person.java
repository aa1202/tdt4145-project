package tdt4145.project.Entities;

/**
 * Person
 */
public class Person {
    private int fnr;
    private String navn;
    private int tlf;
    private String fødselsår;
    private String fødselsland;

    public Person(int fnr, String navn, int tlf, String fødselsår, String fødselsland) {
        this.fnr = fnr;
        this.navn = navn;
        this.tlf = tlf;
        this.fødselsår = fødselsår;
        this.fødselsland = fødselsland;
    }

    public int getFnr() {
        return fnr;
    }

    public void setFnr(int fnr) {
        this.fnr = fnr;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getTlf() {
        return tlf;
    }

    public void setTlf(int tlf) {
        this.tlf = tlf;
    }

    public String getFødselsår() {
        return fødselsår;
    }

    public void setFødselsår(String fødselsår) {
        this.fødselsår = fødselsår;
    }

    public String getFødselsland() {
        return fødselsland;
    }

    public void setFødselsland(String fødselsland) {
        this.fødselsland = fødselsland;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fnr=" + fnr +
                ", navn='" + navn + '\'' +
                ", tlf=" + tlf +
                ", fødselsår='" + fødselsår + '\'' +
                ", fødselsland='" + fødselsland + '\'' +
                '}';
    }
}