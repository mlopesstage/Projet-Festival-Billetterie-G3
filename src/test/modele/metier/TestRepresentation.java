/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.modele.metier;

import java.time.LocalDate;
import java.time.LocalTime;
import modele.metier.Groupe;
import modele.metier.Lieu;
import modele.metier.Representation;

/**
 *
 * @author ychantreau
 */
public class TestRepresentation {
        public static void main(String[] args) {
        Representation rp;
        System.out.println("\nTest n°1 : instanciation et accesseurs");
        Lieu lieu = new Lieu(5, "Lieu de test","Adresse de test", 44230);
        Groupe grp = new Groupe("g300", "Groupe de test","Responsable test", "44230", 10,"France","N");
        LocalDate uneDate = LocalDate.of(2017,12,11);
        LocalTime heureD = LocalTime.of(19,0,0,0);
        LocalTime heureF = LocalTime.of(20,0,0,0);
        rp = new Representation(3,lieu,grp,uneDate, heureD, heureF,0);
        System.out.println(rp);
    }
}
