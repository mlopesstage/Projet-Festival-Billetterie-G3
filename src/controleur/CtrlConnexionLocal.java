package controleur;

import vue.VueConnexionLocal;
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
import java.security.MessageDigest;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.dao.DaoUtilisateur;
import modele.metier.Utilisateur;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CtrlConnexionLocal implements WindowListener, ActionListener {
    
    VueConnexionLocal vue = new VueConnexionLocal();
    private CtrlPrincipal ctrlPrincipal;
    
    public CtrlConnexionLocal(VueConnexionLocal vue,CtrlPrincipal ctrl) {
        
        
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

    public VueConnexionLocal getVue() {
        return vue;
    }

    public void setVue(VueConnexionLocal vue) {
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
            try {           
                //if (e.getSource().equals(vue.getjButtonValider())
                //|| e.getSource().equals(vue.getjTextFieldUtil())
                //|| e.getSource().equals(vue.getjTextFieldMdp())) {
                
                String util = vue.getjTextFieldUtil().getText();
                String mdp = vue.getjTextFieldMdp().getText();
                
                MessageDigest mdUtil = MessageDigest.getInstance("MD5");
                mdUtil.update(util.getBytes());
                byte[] digestUtil = mdUtil.digest();
                StringBuffer sbUtil = new StringBuffer();
                for (byte b : digestUtil) {
                    sbUtil.append(String.format("%02x", b & 0xff));
                }
                
                MessageDigest mdMdp = MessageDigest.getInstance("MD5");
                mdMdp.update(mdp.getBytes());
                byte[] digestMdp = mdMdp.digest();
                StringBuffer sbMdp = new StringBuffer();
                for (byte b : digestMdp) {
                    sbMdp.append(String.format("%02x", b & 0xff));
                }
                
                //util = Encryptage.encrypt(util, "b");
                //mdp = Encryptage.encrypt(mdp, "f");
                try {
                    input = CtrlConnexionLocal.class.getResourceAsStream("util.properties");
                    prop.load(input);
                    if (sbUtil.toString().equals(prop.getProperty("util1")) && sbMdp.toString().equals(prop.getProperty("mdp1"))) {
                        vue.getjLabelConnexionReussie().setText("Connexion réussie");
                        util = vue.getjTextFieldUtil().getText();
                        ctrlPrincipal.setConnecter(util);
                        ctrlPrincipal.afficherLeMenu();
                    } else {
                        vue.getjLabelConnexionReussie().setText("Utilisateur ou mot de passe incorrect");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(CtrlConnexionLocal.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(CtrlConnexionLocal.class.getName()).log(Level.SEVERE, null, ex);
            }            
        } 

    }
    
}
