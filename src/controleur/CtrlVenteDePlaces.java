/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import vue.VueVenteDePlaces;

/**
 *
 * @author mlopes
 */
public class CtrlVenteDePlaces {
    
    
    /*private VueVenteDePlaces vue; // LA VUE

    public CtrlVenteDePlaces(VueVenteDePlaces vue) {
        this.vue = vue;
        // le contrôleur écoute la vue
        this.vue.addWindowListener((WindowListener) this);
        vue.getjTableVenteDePlaces().addMouseListener(this);
        // préparer l'état initial de la vue
        List<VenteDePlaces> laVenteDePlaces = null;
        try {
            laVenteDePlaces = DaoVenteDePlaces.selectAll();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(getVue(), "CtrlLesRepresentations - échec de sélection des representations");
        }
        afficherLesRepresentations(laVenteDePlaces);

        JFrame2.getJTextField2().setText(getJTextField1().getText());
    }
    
    
    public void actionPerformed(ActionEvent e) {
        /*if (e.getSource().equals(vue.getjTableRepresentation())){
                //List<Representation> mesRepresentations = DaoRepresentation.selectAllByVille(vue.getjTextFieldVille().getText());
               // afficherLesRepresentations(mesRepresentations);
               JOptionPane.showConfirmDialog(getVue(), "MDR ?", "AGENCEB", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    }*/
}

    /*public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1) {
            //Si nb place vide alors erreur
            JOptionPane.showConfirmDialog(getVue(), "Aucune vente n’est possible : Le nombre de place n'à pas était remplis.", JOptionPane.PLAIN_MESSAGE);
        }
    }*/
