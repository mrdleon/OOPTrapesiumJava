package trapesium.oop;

public class LimasTrapesium extends Trapesium {

    private double vTinggiLimas;

    public LimasTrapesium(Perhitungan vPht) {
        super(vPht);
    }

    public double getTinggiLimas() {
        return vTinggiLimas;
    }

    public void setTinggiLimas(double vTinggiLimas) {
        this.vTinggiLimas = vTinggiLimas;
    }

    public double hitungVolume() {

        if (vTinggiLimas <= 0) {

            throw new TrapesiumNotValidException(
                    "Tinggi limas harus lebih besar dari 0."
            );
        }

        return (hitungLuas() * vTinggiLimas) / 3.0;
    }

    public double hitungLuasPermukaan() {

        double vLuasSelimut =
                0.5 * hitungKeliling() * vTinggiLimas;

        return hitungLuas() + vLuasSelimut;
    }

    // OVERRIDING
    @Override
    public void tampilkanInfo() {

        System.out.println("=== LIMAS TRAPESIUM ===");

        System.out.println("Luas Alas = " + hitungLuas());

        System.out.println("Keliling Alas = " + hitungKeliling());

        System.out.println("Volume = " + hitungVolume());

        System.out.println("Luas Permukaan = " +
                hitungLuasPermukaan());
    }

    @Override
    public void run() {

        for (int vI = 0; vI < 100000; vI++) {

            vPht.jalankanPerhitunganLimas(vI + 1);

        }
    }
}