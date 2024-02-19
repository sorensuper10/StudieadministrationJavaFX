package Studieadministration;

public class StudFag {

    private int stdnr;

    private int fagnr;

    private int karakter;

    public StudFag() {
    }

    public StudFag(int stdnr, int fagnr, int karakter) {
        this.stdnr = stdnr;
        this.fagnr = fagnr;
        this.karakter = karakter;
    }

    public int getStdnr() {
        return stdnr;
    }

    public void setStdnr(int stdnr) {
        this.stdnr = stdnr;
    }

    public int getFagnr() {
        return fagnr;
    }

    public void setFagnr(int fagnr) {
        this.fagnr = fagnr;
    }

    public int getKarakter() {
        return karakter;
    }

    public void setKarakter(int karakter) {
        this.karakter = karakter;
    }

    @Override
    public String toString() {
        return "StudFag{" +
                "stdnr=" + stdnr +
                ", fagnr=" + fagnr +
                ", karakter=" + karakter +
                '}';
    }
}
