package Paiement;
public class PaiementOrangeMoney implements Paiement{
    public void effectuerPaiement(double montant) {
        System.out.println("Paiement de " + montant + " effectué avec Orange Money.");
    }
}
