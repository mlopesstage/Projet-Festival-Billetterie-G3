/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.modele.metier;

import modele.metier.Lieu;

/**
 *
 * @author ychantreau
 */
public class TestLieu {
        public static void main(String[] args) {
        Lieu lieu;
        System.out.println("\nTest n°1 : instanciation et accesseurs");
        lieu = new Lieu(5, "Lieu de test","Adresse de test", 44230);
        System.out.println(lieu);
    }
}
