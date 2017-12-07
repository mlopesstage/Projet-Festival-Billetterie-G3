/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.modele.metier;

import java.time.LocalTime;
import java.util.Date;
import modele.metier.Representation;

/**
 *
 * @author ychantreau
 */
public class TestRepresentation {
        public static void main(String[] args) {
        Representation rp;
        System.out.println("\nTest n°1 : instanciation et accesseurs");
        Date uneDate = new Date(2017,07,11);
        LocalTime heureD = LocalTime.of(19,0,0,0);
        LocalTime heureF = LocalTime.of(20,0,0,0);
        rp = new Representation(3,2,"g024",uneDate, heureD, heureF);
        System.out.println(rp);
    }
}
