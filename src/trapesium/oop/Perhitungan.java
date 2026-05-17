package trapesium.oop;

import java.util.Random; // Library(kelas) bawaan Java. deret angka pseudo-random (acak semu)

public class Perhitungan {

    private Trapesium vTrapesium;
    private LimasTrapesium vLimas;
    private PrismaTrapesium vPrisma;

    private final Random vRand = new Random(); // final: nilainya tidak dapat diganti lagi

    // TOTAL DATA BESAR UNTUK MULTITHREADING
    private static final int V_TOTAL_DATA = 100000;

    private enum Giliran {
        TRAPESIUM,
        LIMAS,
        PRISMA
    }

    private Giliran vGiliran = Giliran.TRAPESIUM;

    public void setTrapesium(Trapesium vTrapesium) {
        this.vTrapesium = vTrapesium;
    }

    public void setLimas(LimasTrapesium vLimas) {
        this.vLimas = vLimas;
    }

    public void setPrisma(PrismaTrapesium vPrisma) {
        this.vPrisma = vPrisma;
    }

    public synchronized void jalankanPerhitunganTrapesium(int vIndex) {

        while (vGiliran != Giliran.TRAPESIUM) {

            try {

                wait();

            } catch (InterruptedException vE) {

                Thread.currentThread().interrupt();
            }
        }

        double vAtas = bangkitkanRandom();
        double vBawah = bangkitkanRandom();
        double vKiri = bangkitkanRandom();
        double vKanan = bangkitkanRandom();
        double vTinggi = bangkitkanRandom();

        vTrapesium.setSisiAtas(vAtas);
        vTrapesium.setSisiBawah(vBawah);
        vTrapesium.setSisiMiringKiri(vKiri);
        vTrapesium.setSisiMiringKanan(vKanan);
        vTrapesium.setTinggi(vTinggi);

        vLimas.setSisiAtas(vAtas);
        vLimas.setSisiBawah(vBawah);
        vLimas.setSisiMiringKiri(vKiri);
        vLimas.setSisiMiringKanan(vKanan);
        vLimas.setTinggi(vTinggi);

        vPrisma.setSisiAtas(vAtas);
        vPrisma.setSisiBawah(vBawah);
        vPrisma.setSisiMiringKiri(vKiri);
        vPrisma.setSisiMiringKanan(vKanan);
        vPrisma.setTinggi(vTinggi);

        try {

            // HANYA TAMPILKAN 5 DATA PERTAMA
            if (vIndex <= 5) {

                System.out.println(
                        "\n===== TRAPESIUM " + vIndex + " ====="
                );

                System.out.printf(
                        "a (Sisi Atas)          = %.2f\n", vAtas
                );

                System.out.printf(
                        "b (Sisi Bawah)         = %.2f\n", vBawah
                );

                System.out.printf(
                        "c (Sisi Miring Kiri)   = %.2f\n", vKiri
                );

                System.out.printf(
                        "d (Sisi Miring Kanan)  = %.2f\n", vKanan
                );

                System.out.printf(
                        "t (Tinggi Trapesium)   = %.2f\n", vTinggi
                );

                System.out.println(
                        "Jenis Trapesium        = "
                                + vTrapesium.tentukanJenisTrapesium()
                );

                System.out.printf(
                        "Luas Trapesium         = %.2f\n",
                        vTrapesium.hitungLuas()
                );

                System.out.printf(
                        "Keliling Trapesium     = %.2f\n",
                        vTrapesium.hitungKeliling()
                );
            }

            // DATA TERAKHIR
            if (vIndex == V_TOTAL_DATA) {

                System.out.println(
                        "\n===================================="
                );

                System.out.println(
                        "SEMUA DATA TRAPESIUM BERHASIL DIPROSES"
                );

                System.out.println(
                        "Total Data = " + V_TOTAL_DATA
                );

                System.out.println(
                        "===================================="
                );
            }

        } catch (TrapesiumNotValidException vE) {

            System.out.println(vE.getMessage());
        }

        vGiliran = Giliran.LIMAS;

        notifyAll(); // Membangunkan/mengabarkan thread lain.
    }

    public synchronized void jalankanPerhitunganLimas(int vIndex) {

        while (vGiliran != Giliran.LIMAS) {

            try {

                wait();

            } catch (InterruptedException vE) {

                Thread.currentThread().interrupt();
            }
        }

        vLimas.setTinggiLimas(bangkitkanRandom());

        try {

            // HANYA TAMPILKAN 5 DATA PERTAMA
            if (vIndex <= 5) {

                System.out.println(
                        "\n===== LIMAS " + vIndex + " ====="
                );

                System.out.printf(
                        "Tinggi Limas           = %.2f\n",
                        vLimas.getTinggiLimas()
                );

                System.out.printf(
                        "Volume Limas           = %.2f\n",
                        vLimas.hitungVolume()
                );

                System.out.printf(
                        "Luas Permukaan Limas   = %.2f\n",
                        vLimas.hitungLuasPermukaan()
                );
            }

            // DATA TERAKHIR
            if (vIndex == V_TOTAL_DATA) {

                System.out.println(
                        "\n===================================="
                );

                System.out.println(
                        "SEMUA DATA LIMAS BERHASIL DIPROSES"
                );

                System.out.println(
                        "Total Data = " + V_TOTAL_DATA
                );

                System.out.println(
                        "===================================="
                );
            }

        } catch (TrapesiumNotValidException vE) {

            System.out.println(vE.getMessage());
        }

        vGiliran = Giliran.PRISMA;

        notifyAll();
    }

    public synchronized void jalankanPerhitunganPrisma(int vIndex) {

        while (vGiliran != Giliran.PRISMA) {

            try {

                wait();

            } catch (InterruptedException vE) {

                Thread.currentThread().interrupt();
            }
        }

        vPrisma.setTinggiPrisma(bangkitkanRandom());

        try {

            // HANYA TAMPILKAN 5 DATA PERTAMA
            if (vIndex <= 5) {

                System.out.println(
                        "\n===== PRISMA " + vIndex + " ====="
                );

                System.out.printf(
                        "Tinggi Prisma          = %.2f\n",
                        vPrisma.getTinggiPrisma()
                );

                System.out.printf(
                        "Volume Prisma          = %.2f\n",
                        vPrisma.hitungVolume()
                );

                System.out.printf(
                        "Luas Permukaan Prisma  = %.2f\n",
                        vPrisma.hitungLuasPermukaan()
                );
            }

            // DATA TERAKHIR
            if (vIndex == V_TOTAL_DATA) {

                System.out.println(
                        "\n===================================="
                );

                System.out.println(
                        "SEMUA DATA PRISMA BERHASIL DIPROSES"
                );

                System.out.println(
                        "Total Data = " + V_TOTAL_DATA
                );

                System.out.println(
                        "===================================="
                );
            }

        } catch (TrapesiumNotValidException vE) {

            System.out.println(vE.getMessage());
        }

        vGiliran = Giliran.TRAPESIUM;

        notifyAll();
    }

    // RANDOM DOUBLE 0 - 100
    private double bangkitkanRandom() {

        return vRand.nextDouble() * 100; // contoh vRand.nextDouble menghasilkan 0.73, maka 0.73 * 100 = 73.0
    }
}

// generate random data
// menyimpan object bangun
// mengatur giliran thread
// sinkronisasi multithreading
// menjalankan simulasi perhitungan
// menghubungkan semua class.