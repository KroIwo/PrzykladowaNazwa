public class Account {
    protected String numer;
    protected double saldo;

    public Account(String numer, double saldo) {
        this.numer = numer;
        this.saldo = saldo;
    }

    public void deposytuj(double ilosc) {
        saldo = saldo + ilosc;
        System.out.println("Zdepotyzowano " + ilosc + " na konto " + numer);
    }

    public void withdraw(long ilosc) {
        if (saldo >= ilosc) {
            saldo = saldo - ilosc;
            System.out.println("Saldo po wypłacie: " + saldo);
        } else {
            System.out.println("Twoje saldo jest mniejsze niż " + ilosc + " Transakcja nieudana >:)");
        }
    }
    public double getSaldo(){
        return saldo;
    }
    public String getNumer(){
        return numer;
    }
}
