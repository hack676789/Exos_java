
public class Calculatrice {
    // Méthode pour additionner deux entiers
    public int addition(int a, int b) {
        return a + b;
    }

    // Méthode pour diviser deux entiers avec gestion de la division par zéro
    public int division(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Erreur : Division par zéro !");
        }
        return a / b; // Résultat entier (division entière)
    }


    public static void main(String[] args) {
        
        Calculatrice calc = new Calculatrice();

      
        int somme = calc.addition(3, 2);
        System.out.println("Addition : 3 + 2 = " + somme); 

      
        try {
            int resultatDivision = calc.division(4, 0);
            System.out.println("Division : 4 / 0 = " + resultatDivision);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

  
        //try {
            //int erreur = calc.division(2, 0);
            //System.out.println("Division : 2 / 0 = " + erreur);
        //} catch (ArithmeticException e) {
          //  System.out.println(e.getMessage()); 
        //}
    }
}
