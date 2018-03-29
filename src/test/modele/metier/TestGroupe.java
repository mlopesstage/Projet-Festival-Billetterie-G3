package test.modele.metier;

import modele.metier.Groupe;

/**
 * Test unitaire de la classe Groupe
 */
public class TestGroupe {

    public static void main(String[] args) {
        Groupe grp;
        System.out.println("\nTest n°1 : instanciation et accesseurs");
        grp = new Groupe("g300", "Groupe de test","Responsable test", "44230", 10,"France","N");
        System.out.println(grp);
    }
}