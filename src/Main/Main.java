package Main;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import modele.dao.Jdbc;
import vue.*;
import controleur.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author ychantreau
 */
public class Main {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
//        Jdbc.creer("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:", "@localhost:1521:XE", "", "btssio", "btssio");
        final Properties prop = new Properties();
	InputStream input = null;
        
        try {
          
            //input = new FileInputStream("src/config.properties");
            input = Main.class.getResourceAsStream( "config.properties" );


            // load a properties file
            prop.load(input);

            // get the property value and print it out
            String pilote = prop.getProperty("pilote");
            String protocole = prop.getProperty("protocole");
            String serveur = prop.getProperty("serveur");
            String base = prop.getProperty("base");
            String login = prop.getProperty("login");
            String mdp = prop.getProperty("mdp");
            Jdbc.creer(pilote, protocole, serveur, base, login, mdp);
            try {
                Jdbc.getInstance().connecter();
                CtrlPrincipal leControleurPrincipal = new CtrlPrincipal();
                VueMenu leMenu = new VueMenu();
                CtrlMenu ctrlLeMenu = new CtrlMenu(leMenu, leControleurPrincipal);
                VueRepresentation vueRepresentation = new VueRepresentation();
                CtrlLesRepresentations ctrlLesRepresentations = new CtrlLesRepresentations(vueRepresentation, leControleurPrincipal);
                VueVente laVente = new VueVente();
                CtrlVente ctrlLaVente = new CtrlVente(laVente, leControleurPrincipal);
                VueConnexionLocal laConnexionLocal = new VueConnexionLocal();
                CtrlConnexionLocal ctrlLaConnexionLocal = new CtrlConnexionLocal(laConnexionLocal, leControleurPrincipal);
                leControleurPrincipal.setCtrlMenu(ctrlLeMenu);
                leControleurPrincipal.setCtrlConnexionLocal(ctrlLaConnexionLocal);
                leControleurPrincipal.setCtrlLesRepresentations(ctrlLesRepresentations);
                leControleurPrincipal.setCtrlVente(ctrlLaVente);
                leMenu.setVisible(true);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Main - classe JDBC non trouvée");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Main - échec de connexion");
            }

        } catch (final IOException ex) {
            ex.printStackTrace();
	} finally {
            if (input != null) {
		try {
                    input.close();
		} catch (final IOException e) {
                    e.printStackTrace();
		}
            }
        }
    }
}
