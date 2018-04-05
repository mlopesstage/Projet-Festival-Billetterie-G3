package controleur;

import javax.swing.JOptionPane;

public class CtrlPrincipal {
    
    private CtrlLesRepresentations ctrlLesRepresentations;
    private CtrlMenu ctrlMenu;
    private CtrlVente ctrlVente;
    private CtrlConnexionLocal ctrlConnexionLocal;
    private CtrlConnexionDistante ctrlConnexionDistante;
    private int idRep;
    private String connecter = null;
    
    public void afficherLeMenu() {
        this.ctrlLesRepresentations.getVue().setVisible(false);
        this.ctrlVente.getVue().setVisible(false);
        this.ctrlMenu.getVue().setVisible(true);
        this.ctrlConnexionLocal.getVue().setVisible(false);
        this.ctrlConnexionDistante.getVue().setVisible(false);
    }
    
    public void afficherLesRepresentations() {
        this.ctrlLesRepresentations.getVue().setVisible(true);
        this.ctrlVente.getVue().setVisible(false);
        this.ctrlMenu.getVue().setVisible(false);
        this.ctrlConnexionLocal.getVue().setVisible(false);
        this.ctrlConnexionDistante.getVue().setVisible(false);
    }
    
    public void afficherVente(int idRep) {
        this.ctrlLesRepresentations.getVue().setVisible(false);
        this.ctrlVente.getVue().setVisible(true);
        this.ctrlMenu.getVue().setVisible(false);
        this.ctrlConnexionLocal.getVue().setVisible(false);
        this.idRep = idRep;
        this.ctrlConnexionDistante.getVue().setVisible(false);
    }
    
    public void afficherConnexion() {
        this.ctrlLesRepresentations.getVue().setVisible(false);
        this.ctrlVente.getVue().setVisible(false);
        this.ctrlMenu.getVue().setVisible(false);
        this.ctrlConnexionLocal.getVue().setVisible(true);
        this.ctrlConnexionDistante.getVue().setVisible(false);
    }
    public void afficherConnexionDistante() {
        this.ctrlLesRepresentations.getVue().setVisible(false);
        this.ctrlVente.getVue().setVisible(false);
        this.ctrlMenu.getVue().setVisible(false);
        this.ctrlConnexionLocal.getVue().setVisible(false);
        this.ctrlConnexionDistante.getVue().setVisible(true);
    }
    
    public void quitter() {
        // Confirmer avant de quitter
        int rep = JOptionPane.showConfirmDialog(null, "Quitter l'application\nEtes-vous sûr(e) ?", "Menu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (rep == JOptionPane.YES_OPTION) {
            // mettre fin à l'application
            System.exit(0);
        }else {
            return;
        }
    }

    public int getIdRep() {
        return idRep;
    }

    public void setIdRep(int idRep) {
        this.idRep = idRep;
    }

    public CtrlLesRepresentations getCtrlLesRepresentations() {
        return ctrlLesRepresentations;
    }

    public void setCtrlLesRepresentations(CtrlLesRepresentations ctrlLesRepresentations) {
        this.ctrlLesRepresentations = ctrlLesRepresentations;
    }

    public CtrlMenu getCtrlMenu() {
        return ctrlMenu;
    }

    public void setCtrlMenu(CtrlMenu ctrlMenu) {
        this.ctrlMenu = ctrlMenu;
    }

    public CtrlVente getCtrlVente() {
        return ctrlVente;
    }

    public void setCtrlVente(CtrlVente ctrlVente) {
        this.ctrlVente = ctrlVente;
    }

    public CtrlConnexionLocal getCtrlConnexionLocal() {
        return ctrlConnexionLocal;
    }

    public void setCtrlConnexionLocal(CtrlConnexionLocal ctrlConnexionLocal) {
        this.ctrlConnexionLocal = ctrlConnexionLocal;
    }

    public String getConnecter() {
        return connecter;
    }

    public void setConnecter(String connecter) {
        this.connecter = connecter;
    }

    public CtrlConnexionDistante getCtrlConnexionDistante() {
        return ctrlConnexionDistante;
    }

    public void setCtrlConnexionDistante(CtrlConnexionDistante ctrlConnexionDistante) {
        this.ctrlConnexionDistante = ctrlConnexionDistante;
    }
    
}