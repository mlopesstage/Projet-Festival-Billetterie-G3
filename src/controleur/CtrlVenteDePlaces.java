/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import vue.VueMenu;
import vue.VueVenteDePlaces;

/**
 *
 * @author mlopes
 */
public class CtrlVenteDePlaces implements WindowListener, ActionListener {
    
    
    VueVenteDePlaces vue; // LA VUE
    //VueMenu vueMenu = new VueMenu();

    public CtrlVenteDePlaces(VueVenteDePlaces vue) {
        this.vue = vue;
        // le contrôleur écoute la vue
        this.vue.addWindowListener((WindowListener) this);
        this.vue.getjButtonAnnuler().addActionListener(this);
//        vue.getjTableVenteDePlaces().addMouseListener(this);
        // préparer l'état initial de la vue
//        try {
//            laVenteDePlaces = DaoVenteDePlaces.selectAll();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(getVue(), "CtrlLesRepresentations - échec de sélection des representations");
        }
//        afficherLesRepresentations(laVenteDePlaces);

//        JFrame2.getJTextField2().setText(getJTextField1().getText());
//    }
    
    public void afficherLeMenu(){
        vue.setVisible(false);
        
    }
    
    
    public void actionPerformed(ActionEvent e) {
//        if (e.getSource().equals(/*vue.getjTableRepresentation()*/null)){
                //List<Representation> mesRepresentations = DaoRepresentation.selectAllByVille(vue.getjTextFieldVille().getText());
               // afficherLesRepresentations(mesRepresentations);
//               JOptionPane.showConfirmDialog(getVue(), "MDR ?", "AGENCEB", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        /*} else */if (e.getSource().equals(vue.getjButtonAnnuler())) {
            afficherLeMenu();
        }
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1) {
            //Si nb place vide alors erreur
//            JOptionPane.showConfirmDialog(getVue(), "Aucune vente n’est possible : Le nombre de place n'à pas était remplis.", JOptionPane.PLAIN_MESSAGE);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        
    }

    @Override
    public void windowClosed(WindowEvent e) {
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }
}