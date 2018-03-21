package controleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modele.dao.DaoRepresentation;
import modele.metier.Representation;
import vue.VueMenu;
import vue.VueRepresentation;
/**
 *
 * @author mlopes
 */


public class CtrlMenu implements WindowListener, ActionListener {
    
    VueMenu vue = new VueMenu();
    private CtrlPrincipal ctrlPrincipal;


    
    public CtrlMenu(VueMenu vue,CtrlPrincipal ctrl) {
        this.vue = vue;
        this.vue.addWindowListener(this);
        vue.getjButtonRepresentations().addActionListener(this);
        this.ctrlPrincipal = ctrl;
    }
    
    private void quitter() {
        // Confirmer avant de quitter
        int rep = JOptionPane.showConfirmDialog(getVue(), "Quitter l'application\nEtes-vous sûr(e) ?", "Menu", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (rep == JOptionPane.YES_OPTION) {
            // mettre fin à l'application
            System.exit(0);
        }
    }
    
    public VueMenu getVue() {
        return vue;
    }

    public void setVue(VueMenu vue) {
        this.vue = vue;
    }
    
    // REACTIONS EVENEMENTIELLES
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
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vue.getjButtonRepresentations())) {
            ctrlPrincipal.afficherLesRepresentations();
        }
    }
    
}
