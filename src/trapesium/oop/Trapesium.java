package trapesium.oop;

public class Trapesium extends BangunDatar
        implements LuasCalculatable, KelilingCalculatable, Runnable {

    protected Perhitungan vPht;

    private double vSisiAtas;
    private double vSisiBawah;
    private double vSisiMiringKiri;
    private double vSisiMiringKanan;
    private double vTinggi;

    public Trapesium(Perhitungan vPht) {
        this.vPht = vPht;
    }

    // OVERLOADING CONSTRUCTOR
    public Trapesium(Perhitungan vPht,
            double vSisiAtas,
            double vSisiBawah,
            double vSisiMiringKiri,
            double vSisiMiringKanan,
            double vTinggi) {

        this.vPht = vPht;
        this.vSisiAtas = vSisiAtas;
        this.vSisiBawah = vSisiBawah;
        this.vSisiMiringKiri = vSisiMiringKiri;
        this.vSisiMiringKanan = vSisiMiringKanan;
        this.vTinggi = vTinggi;
    }

    public double getSisiAtas() {
        return vSisiAtas;
    }

    public void setSisiAtas(double vSisiAtas) {
        this.vSisiAtas = vSisiAtas;
    }

    public double getSisiBawah() {
        return vSisiBawah;
    }

    public void setSisiBawah(double vSisiBawah) {
        this.vSisiBawah = vSisiBawah;
    }

    public double getSisiMiringKiri() {
        return vSisiMiringKiri;
    }

    public void setSisiMiringKiri(double vSisiMiringKiri) {
        this.vSisiMiringKiri = vSisiMiringKiri;
    }

    public double getSisiMiringKanan() {
        return vSisiMiringKanan;
    }

    public void setSisiMiringKanan(double vSisiMiringKanan) {
        this.vSisiMiringKanan = vSisiMiringKanan;
    }

    public double getTinggi() {
        return vTinggi;
    }

    public void setTinggi(double vTinggi) {
        this.vTinggi = vTinggi;
    }

    protected void lakukanValidasiTrapesium() {

        if (vSisiAtas <= 0 ||
                vSisiBawah <= 0 ||
                vSisiMiringKiri <= 0 ||
                vSisiMiringKanan <= 0 ||
                vTinggi <= 0) {

            throw new TrapesiumNotValidException(
                    "Semua nilai trapesium harus lebih besar dari 0."
            );
        }
    }

    @Override
    public double hitungLuas() {

        lakukanValidasiTrapesium();

        return 0.5 * (vSisiAtas + vSisiBawah) * vTinggi;
    }

    @Override
    public double hitungKeliling() {

        lakukanValidasiTrapesium();

        return vSisiAtas + vSisiBawah +
                vSisiMiringKiri + vSisiMiringKanan;
    }

    @Override
    public String tentukanJenisTrapesium() {

        if (vSisiMiringKiri == vSisiMiringKanan) {
            return "Trapesium Sama Kaki";
        }

        return "Trapesium Sembarang";
    }

    // OVERLOADING METHOD
    public void tampilkanInfo() {

        System.out.println("Jenis = " + tentukanJenisTrapesium());
    }

    // OVERLOADING METHOD
    public void tampilkanInfo(String vJudul) {

        System.out.println(vJudul);
        tampilkanInfo();
    }

    // OVERRIDING
    @Override
    public void run() {

        for (int vI = 0; vI < 100000; vI++) {

            vPht.jalankanPerhitunganTrapesium(vI + 1);

        }
    }
}