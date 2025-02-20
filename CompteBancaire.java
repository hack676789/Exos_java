// Exception personnalisée pour un solde insuffisant
class SoldeInsuffisantException extends Exception {
    public SoldeInsuffisantException(String message) {
        super(message);
    }
}

// Exception personnalisée pour un montant invalide
class MontantInvalideException extends Exception {
    public MontantInvalideException(String message) {
        super(message);
    }
}

public class CompteBancaire {
    private double solde;

    public CompteBancaire(double soldeInitial) {
        this.solde = soldeInitial;
    }

    public void retirer(double montant) throws SoldeInsuffisantException, MontantInvalideException {
        if (montant <= 0) {
            throw new MontantInvalideException("Merci de donner un montant correct");
        }
        if (montant > solde) {
            throw new SoldeInsuffisantException("Solde insuffisant.");
        }
        solde = solde - montant;
    }

    public double getSolde() {
        return solde;
    }

    public static void main(String[] args) {
        CompteBancaire compte = new CompteBancaire(7000);
        try {
            compte.retirer(100); 
            System.out.println("Solde après retrait: " + compte.getSolde());
        } catch (MontantInvalideException e) {
            System.out.println("Erreur : " + e.getMessage());
        } catch (SoldeInsuffisantException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
