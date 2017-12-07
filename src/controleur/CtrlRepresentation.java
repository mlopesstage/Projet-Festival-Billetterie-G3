package controleur;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modele.dao.DaoRepresentation;
import modele.metier.Representation;
import vue.VueRepresentation;

/**
 *
 * @author mlopes
 */

public class CtrlRepresentation extends CtrlGenerique implements WindowListener{
    
    private final DaoRepresentation daoRepresentation = new DaoRepresentation();
    private ArrayList<Representation> lesRepresentations;
   
    public CtrlRepresentation(CtrlPrincipal ctrlPrincipal) {
        super(ctrlPrincipal);
        vue = new VueRepresentation();
        representationAfficher();
        vue.addWindowListener(this);
    }
    
    public void  representationQuitter(){
        this.getCtrlPrincipal().action(EnumAction.MENU_REPRESENTATION_QUITTER);
    }
    
    public void representationAfficher() {
        String msg = ""; // message à afficher en cas d'erreur
        ((VueRepresentation) vue).getModeleTableEquipier().setRowCount(0);
        String[] titresColonnes = {"Nom", "Prenom", "Volontaire"};
        ((VueEquipiers) vue).getModeleTableEquipier().setColumnIdentifiers(titresColonnes);
        try {
            String[] ligneDonnees = new String[3];
            lesRepresentations = DaoRepresentation.selectAll();
            for (Representation representation : lesRepresentations) {
                ligneDonnees[0] = representation.getNom();
                ligneDonnees[1] = representation.getPrenom();
                ligneDonnees[2] = (representation.getWouf();
                ((VueEquipiers) vue).getModeleTableEquipier().addRow(ligneDonnees);
            }
        } catch (Exception ex) {
            msg = "CtrlEquipiers - equipiersAfficher() - " + ex.getMessage();
            JOptionPane.showMessageDialog(vue, msg, "Affichage des équipiers", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosed(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}