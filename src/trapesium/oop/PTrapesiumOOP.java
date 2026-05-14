package trapesium.oop;

public class PTrapesiumOOP {

    public static void main(String[] vArgs) {

        Perhitungan vPht = new Perhitungan();

        Trapesium vTrapesium =
                new Trapesium(vPht);

        LimasTrapesium vLimas =
                new LimasTrapesium(vPht);

        PrismaTrapesium vPrisma =
                new PrismaTrapesium(vPht);

        vPht.setTrapesium(vTrapesium);

        vPht.setLimas(vLimas);

        vPht.setPrisma(vPrisma);

        // POLYMORPHISM
        Trapesium vObj1 = vLimas;

        Trapesium vObj2 = vPrisma;

        Thread vThread1 =
                new Thread(vTrapesium, "Trapesium");

        Thread vThread2 =
                new Thread(vObj1, "Limas");

        Thread vThread3 =
                new Thread(vObj2, "Prisma");

        vThread1.start();

        vThread2.start();

        vThread3.start();
    }
}