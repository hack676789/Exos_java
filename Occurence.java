import java.util.HashMap;
import java.util.Map;

public class Occurence {

    public static Map<Character, Integer> compterCaracteres(String phrase) {
        Map<Character, Integer> compteur = new HashMap<>();

        for (char c : phrase.toLowerCase().toCharArray()) { 
            if (Character.isLetter(c)) { 
                compteur.put(c, compteur.getOrDefault(c, 0) + 1);
            }
        }
        return compteur;
    }

    public static void main(String[] args) {
        String phrase = " Tout marche ";
        System.out.println(compterCaracteres(phrase)); 
    }

}
