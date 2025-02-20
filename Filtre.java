
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Filtre {

    public static void main(String[] args) {

        // Chemin du fichier d'entrée et du fichier de sortie
        String cheminFichierEntree = "fichierEntree.txt"; 
        String cheminFichierSortie = "fichierSortie.txt";
        
        // Appeler la fonction pour filtrer les lignes
        filtrerLignes(cheminFichierEntree, cheminFichierSortie);
    }

    public static void filtrerLignes(String cheminEntree, String cheminSortie) {
        try (BufferedReader lecteur = new BufferedReader(new FileReader(cheminEntree));
             BufferedWriter ecrivain = new BufferedWriter(new FileWriter(cheminSortie))) {

            String ligne;
            while ((ligne = lecteur.readLine()) != null) {
                // Vérifier si la ligne commence par 'N' en majuscule
                if (ligne.startsWith("N")) {
                    ecrivain.write(ligne); 
                    ecrivain.newLine(); 
                }
            }

            System.out.println("Filtrage effectué avec succès.");
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture ou de l'écriture des fichiers.");
            e.printStackTrace();
        }
    }
}
