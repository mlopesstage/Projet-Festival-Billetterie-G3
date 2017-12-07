package controleur;

/**
 *
 * @author mlopes
 */

import static controleur.EnumAction.*;
import javax.swing.JOptionPane;
import modele.dao.Jdbc;

public class CtrlPrincipal {
    
    private CtrlRepresentation ctrlRepresentation = null;
    private CtrlMenu ctrlMenu = null;
    
    public void action(){
        if(ctrlMenu == null){
            ctrlMenu = new CtrlMenu(this);
        }
        ctrlMenu.getVue().setEnabled(true);
        ctrlMenu.getVue().setVisible(true);
    }

    public void action(EnumAction action) {
        switch (action) {
            case MENU_REPRESENTATION: // activation de vuePresence depuis vueMenu
                MenuRepresentation();
                break;
            case MENU_REPRESENTATION_QUITTER:    // retour à vueMenu depuis la vuePresence
                menuQuitterRepresentation();
                break;
            case MENU_QUITTER: // fin de l'application depuis vueMenu
                menuQuitter();
                break;
        }

    }
    
    private void menuQuitter(){
        try{
            Jdbc.getInstance().deconnecter();    
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "CtrlPrincipal - fermeture connexion BD", JOptionPane.ERROR_MESSAGE);
        }finally{
            System.exit(0);
        }
    }

    private void MenuRepresentation(){
        if(ctrlRepresentation == null){
            ctrlRepresentation = new CtrlRepresentation(this);
        }else{
            //ctrlLesRepresentations.actualiser(); Methode de la classe DaoRepresentation
        }
        ctrlMenu.getVue().setEnabled(false);
        ctrlRepresentation.getVue().setEnabled(true);
    }
    
    private void menuQuitterRepresentation(){
        if(ctrlMenu == null){
            ctrlMenu = new CtrlMenu(this);
        }
        ctrlRepresentation.getVue().setVisible(false);
        ctrlMenu.getVue().setEnabled(true);
        ctrlMenu.getVue().setVisible(true);
    }
}