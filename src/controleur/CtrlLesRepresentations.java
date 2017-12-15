package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modele.dao.DaoRepresentation;
import modele.metier.Representation;
import vue.VueMenu;
import vue.VueRepresentation;

/**
 * @author ychantreau
 *
 */
public class CtrlLesRepresentations implements WindowListener, ActionListener, MouseListener {

    private VueRepresentation vue; // LA VUE
    VueMenu vueMenu = new VueMenu();

    public CtrlLesRepresentations(VueRepresentation vue) {
        this.vue = vue;
        // le contrôleur écoute la vue
        this.vue.addWindowListener(this);
        vue.getjTableRepresentation().addMouseListener(this);
        //vue.getjTextFieldVille().addActionListener(this);
        // préparer l'état iniitial de la vue
        List<Representation> lesRepresentations = null;
        try {
            lesRepresentations = DaoRepresentation.selectAll();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(getVue(), "CtrlLesRepresentations - échec de sélection des representations");
        }
        afficherLesRepresentations(lesRepresentations);
    }
    
    public void afficherLeMenu(){
        vueMenu.setVisible(true);
        vue.setVisible(false);
        
    }

    // contrôle de la vue
    /**
     * Remplir le composant JTable avec les respresentations
     *
     * @param desRepresentations liste des representations à afficher
     */
    private final void afficherLesRepresentations(List<Representation> desRepresentations) {
        getVue().getModeleTableRepresentation().setRowCount(0);
        String[] titresColonnes = {"ID", "LIEU", "GROUPE", "DATE", "DEBUT", "FIN"};
        getVue().getModeleTableRepresentation().setColumnIdentifiers(titresColonnes);
        String[] ligneDonnees = new String[6];
        for (Representation uneRepresentation : desRepresentations) {
            ligneDonnees[0] = String.valueOf(uneRepresentation.getId());
            ligneDonnees[1] = uneRepresentation.getLieu().getNom();
            ligneDonnees[2] = uneRepresentation.getGroupe().getNom();
            ligneDonnees[3] = String.valueOf(uneRepresentation.getDateRep());
            ligneDonnees[4] = String.valueOf(uneRepresentation.getHeureDebut());
            ligneDonnees[5] = String.valueOf(uneRepresentation.getHeureFin());
            getVue().getModeleTableRepresentation().addRow(ligneDonnees);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vue.getjButtonAnnuler())) {
            afficherLeMenu();
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1) {
            int row = vue.getjTableRepresentation().getSelectedRow();
            // do some stuff
            List<String> numdata = new ArrayList<String>();

            LocalTime debut = LocalTime.parse(vue.getModeleTableRepresentation().getValueAt(row, 4).toString());
            LocalTime fin = LocalTime.parse(vue.getModeleTableRepresentation().getValueAt(row, 5).toString());
            LocalDate dateRep = LocalDate.parse(vue.getModeleTableRepresentation().getValueAt(row, 3).toString());
            numdata.add(vue.getModeleTableRepresentation().getValueAt(row, 1).toString());

            LocalTime now = LocalTime.now();
            debut = debut.plus(30, ChronoUnit.MINUTES);
            LocalDate date = LocalDate.now();


            //if (date.isAfter(dateRep)) {
            if (now.isBefore(fin) && now.isAfter(debut)) {
                JOptionPane.showConfirmDialog(getVue(), "Aucune vente n’est possible : la représentation a commencé depuis plus de 30 mn", "Representation", JOptionPane.PLAIN_MESSAGE);
            } else if (now.isAfter(fin)) {
                JOptionPane.showConfirmDialog(getVue(), "Aucune vente n’est possible : la représentation est terminée", "Representation", JOptionPane.PLAIN_MESSAGE);
            } else {
                String id = vue.getModeleTableRepresentation().getValueAt(row, 0).toString();
                String lieu = vue.getModeleTableRepresentation().getValueAt(row, 1).toString();
                String groupe = vue.getModeleTableRepresentation().getValueAt(row, 2).toString();
                String dateS = vue.getModeleTableRepresentation().getValueAt(row, 3).toString();
                String heureD = vue.getModeleTableRepresentation().getValueAt(row, 4).toString();
                String heureF = vue.getModeleTableRepresentation().getValueAt(row, 5).toString();
                
                String label = "N°" + id + " lieu : " + lieu + " groupe : " + groupe;
                String label2 = "Le " + dateS + " entre " + heureD + " et " + heureF;
                System.out.println(label);
                vue.getjLabelLaRepresentation().setText(label);
                vue.getjLabelLaRepresentation2().setText(label2);
                
            }
            //JOptionPane.showConfirmDialog(getVue(), row, "AGENCEB", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        }
        //}
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

    // ACCESSEURS et MUTATEURS
    public VueRepresentation getVue() {
        return vue;
    }

    public void setVue(VueRepresentation vue) {
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
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
