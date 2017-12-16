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
import vue.VueVenteDePlaces;
/**
 *
 * @author mlopes
 */


public class CtrlPrincipal implements WindowListener, ActionListener {
    
    VueMenu vue = new VueMenu();
    VueVenteDePlaces vueVentes = new VueVenteDePlaces();

    VueRepresentation vueRepresentation = new VueRepresentation();
    CtrlLesRepresentations ctrlRep = new CtrlLesRepresentations(vueRepresentation);
    CtrlVenteDePlaces ctrlVentes = new CtrlVenteDePlaces(vueVentes);


    
    public CtrlPrincipal(VueMenu vue) {
        this.vue = vue;
        this.vue.addWindowListener(this);
        vue.getjButton1().addActionListener(this);
        vue.getjButton2().addActionListener(this);
        vue.getjButton3().addActionListener(this);
    }
    
    public void afficherLesRepresentations(){
        vueRepresentation.setVisible(true);    
    }
    
     public void afficherVentes(){
        vueVentes.setVisible(true);
    }
    
    
    public CtrlLesRepresentations getCtrlLesRepresentations() {
        return ctrlRep;
    }

    public void setCtrlLesRepresentations(CtrlLesRepresentations ctrlRep) {
        this.ctrlRep = ctrlRep;
    }
    
    public CtrlVenteDePlaces getCtrlVentes() {
        return ctrlVentes;
    }

    public void setCtrlVentes(CtrlVenteDePlaces ctrlVentes) {
        this.ctrlVentes = ctrlVentes;
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
        quitter();
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
        if (e.getSource().equals(vue.getjButton1())) {
            afficherLesRepresentations();
        } else if (e.getSource().equals(vue.getjButton2())) {
            afficherVentes();
        }
    }
    
}
