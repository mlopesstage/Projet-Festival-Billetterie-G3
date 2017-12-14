package Main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import modele.dao.Jdbc;
import vue.*;
import controleur.*;
import java.sql.SQLException;
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
        Jdbc.creer("com.mysql.jdbc.Driver", "jdbc:mysql:", "//localhost/", "festival2", "root", "joliverie");
        try {
            Jdbc.getInstance().connecter();
            VueRepresentation uneVue = new VueRepresentation();
            //VueLesClients vueClient = new VueLesClients();
            CtrlLesRepresentations unControleur = new CtrlLesRepresentations(uneVue);
            //CtrlLesClients controleurClient = new CtrlLesClients(vueClient);
            VueMenu vuMenu = new VueMenu();
            CtrlPrincipal unCtrlPrincipal = new CtrlPrincipal(vuMenu);
            // afficher la vue
            vuMenu.setVisible(true);
            uneVue.setVisible(false);
            //vueClient.setVisible(true);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Main - classe JDBC non trouvée");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Main - échec de connexion");
        }

        }
        
    }
