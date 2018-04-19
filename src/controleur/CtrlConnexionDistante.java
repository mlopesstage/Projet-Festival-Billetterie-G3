package controleur;

import Main.Main;
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
import java.security.MessageDigest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modele.dao.DaoUtilisateur;
import modele.metier.Utilisateur;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import static jdk.nashorn.tools.ShellFunctions.input;
import modele.dao.Jdbc;
import modele.dao.JdbcDistant;

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
            Properties prop = new Properties();
            InputStream input = null;

            //input = new FileInputStream("src/config.properties");
            input = Main.class.getResourceAsStream("config.properties");

            try {
                // load a properties file
                prop.load(input);

                // get the property value and print it out
                String pilote = prop.getProperty("piloteDist");
                String protocole = prop.getProperty("protocoleDist");
                String serveur = prop.getProperty("serveurDist");
                String base = prop.getProperty("baseDist");
                String login = prop.getProperty("loginDist");
                String mdpCon = prop.getProperty("mdpDist");
                JdbcDistant.creer(pilote, protocole, serveur, base, login, mdpCon);

                try {
                    JdbcDistant.getInstance().connecter();
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

                        boolean connexion = false;
                        try {
                            Utilisateur unUtilisateur;
                            unUtilisateur = DaoUtilisateur.selectOneByLoginMdp(sbUtil.toString(),sbMdp.toString());
                           
                            connexion = unUtilisateur != null;
                            
                            if (connexion) {
                                vue.getjLabelConnexionReussie().setText("Connexion réussie : "+unUtilisateur.getNom());
                                util = vue.getjTextFieldUtil().getText();
                                ctrlPrincipal.setConnecter(util);
                            } else {
                                vue.getjLabelConnexionReussie().setText("Utilisateur ou mot de passe incorrect");
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(CtrlConnexionDistante.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(CtrlConnexionDistante.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CtrlConnexionDistante.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(CtrlConnexionDistante.class.getName()).log(Level.SEVERE, null, ex);
                }

            } catch (IOException ex) {
                Logger.getLogger(CtrlConnexionDistante.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
