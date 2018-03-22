/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;
import vue.VueConnexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static jdk.nashorn.tools.ShellFunctions.input;

/**
 *
 * @author btssio
 */
public class CtrlConnexion implements WindowListener, ActionListener {
    
    VueConnexion vue = new VueConnexion();
    private CtrlPrincipal ctrlPrincipal;
    
    public CtrlConnexion(VueConnexion vue,CtrlPrincipal ctrl) {
        this.vue = vue;
        this.vue.addWindowListener(this);
        vue.getjTextFieldUtil().addActionListener(this);
        vue.getjTextFieldMdp().addActionListener(this);
        vue.getjButtonRetour().addActionListener(this);
        vue.getjButtonValider().addActionListener(this);        
        this.ctrlPrincipal = ctrl;
    }
    
    final Properties prop = new Properties();
    InputStream input = null;
    
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

    public VueConnexion getVue() {
        return vue;
    }

    public void setVue(VueConnexion vue) {
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
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vue.getjButtonRetour())) {
            ctrlPrincipal.afficherLeMenu();
        } else if (e.getSource().equals(vue.getjButtonValider())) {
            String util = vue.getjTextFieldUtil().getText();
            String mdp = vue.getjTextFieldMdp().getText();
            try {
                input = new FileInputStream("src/domaine/properties/util.properties");
                prop.load(input);
                
                if (util.equals(prop.getProperty("util1")) && mdp.equals(prop.getProperty("mdp1"))) {
                    vue.getjLabelConnexionReussie().setText("Connexion réussie");
                } else {
                    vue.getjLabelConnexionReussie().setText("Utilisateur ou mot de passe incorrect");
                }
            } catch (final IOException ex) {
                ex.printStackTrace();              
            }
            
        }
    
    }
}
