package controleur;

import vue.VueConnexionDistante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.swing.JOptionPane;
import chiffrage.Encryptage;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.dao.DaoUtilisateur;
import modele.metier.Utilisateur;

public class CtrlConnexionDistante implements WindowListener, ActionListener {

    VueConnexionDistante vue = new VueConnexionDistante();
    private CtrlPrincipal ctrlPrincipal;

    public CtrlConnexionDistante(VueConnexionDistante vue, CtrlPrincipal ctrl) {

        this.vue = vue;
        this.vue.addWindowListener(this);
        vue.getjTextFieldUtil().addActionListener(this);
        vue.getjTextFieldMdp().addActionListener(this);
        vue.getjButtonRetour().addActionListener(this);
        vue.getjButtonValider().addActionListener(this);
        this.ctrlPrincipal = ctrl;
    }

    /**
     * Quitter l'application, après demande de confirmation
     */
    private void quitter() {
        // Confirmer avant de quitter
        int rep = JOptionPane.showConfirmDialog(getVue(), "Quitter l'application\nEtes-vous sûr(e) ?", "Representation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (rep == JOptionPane.YES_OPTION) {
            // mettre fin à l'application
            System.exit(0);
        }
    }

    public VueConnexionDistante getVue() {
        return vue;
    }

    public void setVue(VueConnexionDistante vue) {
        this.vue = vue;
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
        vue.getjTextFieldUtil().setText("");
        vue.getjTextFieldMdp().setText("");
        vue.getjLabelConnexionReussie().setText("");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vue.getjButtonRetour())) {
            ctrlPrincipal.afficherLeMenu();
        }
        if ((e.getSource().equals(vue.getjButtonValider()) || e.getSource().equals(vue.getjTextFieldUtil())
                || e.getSource().equals(vue.getjTextFieldMdp()))) {
            //if (e.getSource().equals(vue.getjButtonValider()) 
            //|| e.getSource().equals(vue.getjTextFieldUtil())
            //|| e.getSource().equals(vue.getjTextFieldMdp())) {

            String util = vue.getjTextFieldUtil().getText();
            String mdp = vue.getjTextFieldMdp().getText();
            util = Encryptage.encrypt(util, "b");
            mdp = Encryptage.encrypt(mdp, "f");
            boolean connexion = false;
            try {
                List<Utilisateur> lesUtilisateurs = new ArrayList<Utilisateur>();
                lesUtilisateurs = DaoUtilisateur.selectAll();
                for(Utilisateur unUtilisateur : lesUtilisateurs){
                if (util.equals(unUtilisateur.getLogin()) && mdp.equals(unUtilisateur.getPassword())) {
                    connexion = true;
                    break;
                }
                }
                if (connexion) {
                    vue.getjLabelConnexionReussie().setText("Connexion réussie");
                    util = vue.getjTextFieldUtil().getText();
                    ctrlPrincipal.setConnecter(util);
                } else {
                    vue.getjLabelConnexionReussie().setText("Utilisateur ou mot de passe incorrect");
                }
            } catch (SQLException ex) {
                Logger.getLogger(CtrlConnexionDistante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
