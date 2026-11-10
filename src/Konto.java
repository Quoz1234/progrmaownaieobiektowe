public class Konto {
    public final double MAKS_WYPLATA=5000.0;
    private final int Numer;
    private final String wlasciciel;
    private double saldo;
    private int liczbaOperacji;
    private static int liczbaKont;
    public Konto(String wlasciciel) {
        this.saldo = 0.0;
        this.liczbaOperacji = 0;

        liczbaKont++;
        this.Numer = liczbaKont;
        if(wlasciciel.isBlank()) {
            this.wlasciciel = "nieznane";
        }
        else {
            this.wlasciciel = wlasciciel;
        }
    }
    public Konto(String wlasciciel, double saldoPoczatkowe) {
        this(wlasciciel);
        if(saldoPoczatkowe < 0.0) {
            this.saldo = 0.0;
        } else {
            this.saldo = saldoPoczatkowe;
        }
    }
    public int getNumer() {
        return Numer;
    }
    public String getWlasciciel() {
        return wlasciciel;
    }
    public double getSaldo() {
        return saldo;
    }
    public int getLiczbaOperacji() {
        return liczbaOperacji;
    }
    public static int getLiczbaKont() {
        return liczbaKont;
    }
    public boolean wplac(double kwota){
        if(kwota <= 0.0) {
            return false;
        }
        else {
            this.saldo+=kwota;
            this.liczbaOperacji++;
            return true;
        }

    }
    public boolean CzyMozeWyplacic(double kwota) {
        return kwota > 0.0 && kwota <=saldo && kwota<=MAKS_WYPLATA;
    }
    public boolean wyplac (double kwota) {
        if(!CzyMozeWyplacic(kwota)) {
            return false;
        }
        this.saldo -= kwota;
        this.liczbaOperacji++;
        return true;
    }
    public boolean maWiecejNiz(Konto inneKonto){
        if(inneKonto==null) {
            return false;
        }
        else {
            return this.saldo>inneKonto.saldo;
        }
    }
    @Override
    public String toString() {
        return String.format("Konto nr %d [%s] saldo: %.2f | operacji : %d", Numer, wlasciciel, saldo, liczbaOperacji );

    }
    protected ustawSaldo(double noweSaldo){
        return this.saldo = noweSaldo;
    }
}





