package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import modele.dao.DaoRepresentation;
import modele.metier.Groupe;
import modele.metier.Lieu;
import modele.metier.Representation;
import vue.VueMenu;
import vue.VueVente;

public class CtrlVente implements WindowListener, ActionListener {
    
    VueVente vue = new VueVente();
    private CtrlPrincipal ctrlPrincipal;

    public CtrlVente(VueVente vue,CtrlPrincipal ctrl) {
        this.vue = vue;
        // le contrôleur écoute la vue
        this.vue.addWindowListener((WindowListener) this);
        this.vue.getjButtonAnnuler().addActionListener(this);
        this.vue.getjButtonValider().addActionListener(this);
        this.ctrlPrincipal = ctrl;
    }

    public VueVente getVue() {
        return vue;
    }

    public void setVue(VueVente vue) {
        this.vue = vue;
    }
    
    public void afficherLaRepresentation(int idRep){
        Representation laRepresentation = null;
        Lieu leLieu = null;
        Groupe leGroupe = null;
        try {
            laRepresentation = DaoRepresentation.selectOne(idRep);
            leLieu = laRepresentation.getLieu();
            leGroupe = laRepresentation.getGroupe();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(getVue(), "Échec de sélection de la representation");
        }
        String label = "N°" + idRep + " lieu : " + leLieu.getNom() + " groupe : " + leGroupe.getNom();
        String label2 = "Le " + laRepresentation.getDateRep() + " entre " + laRepresentation.getHeureDebut() + " et " + laRepresentation.getHeureFin();
        String label3 = "Nombre de places restantes : " + (leLieu.getCapacite()-laRepresentation.getNbPlacesVendues());
        vue.getjLabelLaRepresentation().setText(label);
        vue.getjLabelLaRepresentation2().setText(label2);
        vue.getjLabelLaRepresentation3().setText(label3);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vue.getjButtonAnnuler())) {
            ctrlPrincipal.afficherLesRepresentations();
        }else if (e.getSource().equals(vue.getjButtonValider())){
            Representation laRepresentation = null;
            try {
                laRepresentation = DaoRepresentation.selectOne(ctrlPrincipal.getIdRep());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(getVue(), "Échec de sélection de la representation");
            }
            int nbPlacesVendues = Integer.parseInt(vue.getjTextFieldNbPlace().getText());
            vendreDesPlaces(ctrlPrincipal.getIdRep(),laRepresentation.getNbPlacesVendues() + nbPlacesVendues);
            afficherLaRepresentation(ctrlPrincipal.getIdRep());
        }
    }

    public void vendreDesPlaces(int idRep,int nbPlacesVendues){
        Representation laRepresentation = null;
        Lieu leLieu = null;
        try {
            laRepresentation = DaoRepresentation.selectOne(idRep);
            leLieu = laRepresentation.getLieu();
            if((leLieu.getCapacite() - laRepresentation.getNbPlacesVendues()) < nbPlacesVendues){
                JOptionPane.showMessageDialog(getVue(), "Il n'y a pas assez de places disponibles");
            }else{
                DaoRepresentation.vendreRepresentation(idRep,nbPlacesVendues);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(getVue(), "Échec de sélection de la representation");
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
        ctrlPrincipal.quitter();
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
        afficherLaRepresentation(ctrlPrincipal.getIdRep());
    }

    @Override
        public void windowDeactivated(WindowEvent e) {
    }
}