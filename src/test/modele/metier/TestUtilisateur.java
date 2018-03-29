package test.modele.metier;

import modele.metier.Utilisateur;

/**
 * Test unitaire de la classe Utilisateur
 */
public class TestUtilisateur {

    public static void main(String[] args) {
        Utilisateur grp;
        System.out.println("\nTest n°1 : instanciation et accesseurs");
        grp = new Utilisateur(3, "loginUtil","passwordUtil", "nomUtil", "prenomUtil");
        System.out.println(grp);
    }
}