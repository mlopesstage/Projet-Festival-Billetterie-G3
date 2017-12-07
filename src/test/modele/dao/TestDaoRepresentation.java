package test.modele.dao;

import java.sql.*;
import java.util.List;
import modele.dao.DaoRepresentation;
import modele.dao.Jdbc;
import modele.metier.Representation;

/**
 *
 * @author btssio
 */
public class TestDaoRepresentation {

    public static void main(String[] args) {

        java.sql.Connection cnx = null;

        try {
            test0_Connexion();
            System.out.println("Test0 effectué : connexion\n");
            test1_SelectUnique(3);
            System.out.println("Test1 effectué : sélection unique\n");
            test2_SelectMultiple();
            System.out.println("Test2 effectué : sélection multiple\n");
        } catch (ClassNotFoundException e) {
            System.err.println("Erreur de pilote JDBC : " + e);
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e);
        } finally {
            try {
                if (cnx != null) {
                    cnx.close();
                }
            } catch (SQLException e) {
                System.err.println("Erreur de fermeture de la connexion JDBC : " + e);
            }
        }

    }

    /**
     * Vérifie qu'une connexion peut être ouverte sur le SGBD
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void test0_Connexion() throws ClassNotFoundException, SQLException {
        Jdbc.creer("com.mysql.jdbc.Driver", "jdbc:mysql://", "localhost/", "festival2", "root", "joliverie");
//        Jdbc.creer("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:", "@localhost:1521:XE", "", "btssio", "btssio");
        Jdbc.getInstance().connecter();
        Connection cnx = Jdbc.getInstance().getConnexion();
    }

    /**
     * Affiche une adresse d'après son identifiant
     * @param idRepresentation
     * @throws SQLException
     */
    public static void test1_SelectUnique(int idRepresentation) throws SQLException {
        Representation cetteRepresentation = DaoRepresentation.selectOne(idRepresentation);
        System.out.println("Representation d'identifiant : "+ idRepresentation +" : "+cetteRepresentation.toString());
    }

    /**
     * Affiche toutes les representations
     * @throws SQLException
     */
    public static void test2_SelectMultiple() throws SQLException {
        List<Representation> desRepresentations = DaoRepresentation.selectAll();
        System.out.println("Les representations lues : "+desRepresentations.toString());
    }
}