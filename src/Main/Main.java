package Main;

import modele.dao.Jdbc;
import vue.*;
import controleur.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author mlopes
 */

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CtrlPrincipal ctrlPrincipal;    
        Jdbc.creer("com.mysql.jdbc.Driver", "jdbc:mysql:", "//localhost/", "festivalbilleterie", "festival", "secret");
        try {
            Jdbc.getInstance().connecter();
        } catch (ClassNotFoundException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage(), "Lanceur Main - connexion à la BDD - pilote JDBC non trouvé", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage(), "Lanceur Main - connexion à la BDD", JOptionPane.ERROR_MESSAGE);
        }
        
        // Pour lancer l'application, instancier le contrôleur principal
        ctrlPrincipal = new CtrlPrincipal();
        ctrlPrincipal.action();
    }
}