package Paiement;
public class Main {
    public static void main(String[] args) {
        
        Paiement wave = new PaiementWave();
        Paiement orangeMoney = new PaiementOrangeMoney();
        Paiement paypal = new PaiementPaypal();

        
        wave.effectuerPaiement(3000);
        orangeMoney.effectuerPaiement(10000);
        paypal.effectuerPaiement(2000);
    }
}
