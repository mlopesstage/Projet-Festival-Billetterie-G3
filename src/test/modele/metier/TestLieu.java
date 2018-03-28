package test.modele.metier;

import modele.metier.Lieu;

public class TestLieu {
        public static void main(String[] args) {
        Lieu lieu;
        System.out.println("\nTest n°1 : instanciation et accesseurs");
        lieu = new Lieu(5, "Lieu de test","Adresse de test", 44230);
        System.out.println(lieu);
    }
}