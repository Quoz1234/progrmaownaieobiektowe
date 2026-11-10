public class Main {

    public static void main(String[] args) {
    Konto k1 = new Konto("Anna Kowalska", 1000.0);
        Konto k2 = new Konto("Jan Nowak", 0.0);
        Konto k3 = new Konto("    ", -50.0);


        System.out.println(k1);
        System.out.println(k2);
        System.out.println(k3);

        wykonajWplate(k2, 200, 2);
        wykonajWyplate(k1, 300, 1);
        wykonajWyplate(k2, 500, 2);
        wykonajWplate(k2, -50, 2);
        wykonajWplate(k1, 6000, 1);
        wykonajWyplate(k1, 6000, 1);
        wykonajWyplate(k1, 5000, 1);

        System.out.println(k1);
        System.out.println(k2);
        System.out.println(k3);
        System.out.println("Konta: " + Konto.getLiczbaKont());
        System.out.println("konto nr1 ma wiecej niz konto nr2: "+(k1.maWiecejNiz(k2)? "TAK" : "NIE"));
    }
    public static void wykonajWplate(Konto k, double kwota, int nrKonta){
        boolean success = k.wplac(kwota);
        System.out.println("Wplacasz "+ (int)kwota+ " na konto "+nrKonta +(success ? "OK" : "Odmowa"));
    }
    public static void wykonajWyplate(Konto k, double kwota, int nrKonta){
        boolean success = k.wyplac(kwota);
        System.out.println("Wyplata "+ (int)kwota+ " z konto "+nrKonta +(success ? "OK" : "Odmowa"));
    }
}
