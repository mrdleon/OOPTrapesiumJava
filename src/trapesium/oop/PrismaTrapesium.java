package trapesium.oop;

public class PrismaTrapesium extends Trapesium {

    private double vTinggiPrisma;

    public PrismaTrapesium(Perhitungan vPht) {
        super(vPht);
    }

    public double getTinggiPrisma() {
        return vTinggiPrisma;
    }

    public void setTinggiPrisma(double vTinggiPrisma) {
        this.vTinggiPrisma = vTinggiPrisma;
    }

    public double hitungVolume() {

        if (vTinggiPrisma <= 0) {

            throw new TrapesiumNotValidException(
                    "Tinggi prisma harus lebih besar dari 0."
            );
        }

        return hitungLuas() * vTinggiPrisma;
    }

    public double hitungLuasPermukaan() {

        return (2 * hitungLuas()) +
                (hitungKeliling() * vTinggiPrisma);
    }

    // OVERRIDING
    @Override
    public void tampilkanInfo() {

        System.out.println("=== PRISMA TRAPESIUM ===");

        System.out.println("Luas Alas = " + hitungLuas());

        System.out.println("Keliling Alas = " + hitungKeliling());

        System.out.println("Volume = " + hitungVolume());

        System.out.println("Luas Permukaan = " +
                hitungLuasPermukaan());
    }

    @Override
    public void run() {

        for (int vI = 0; vI < 100000; vI++) {

            vPht.jalankanPerhitunganPrisma(vI + 1);

        }
    }
}