package test.modele.dao;

import java.sql.*;
import java.util.List;
import modele.dao.DaoGroupe;
import modele.dao.Jdbc;
import modele.metier.Groupe;

public class TestDaoGroupe {

    public static void main(String[] args) {

        java.sql.Connection cnx = null;

        try {
            test0_Connexion();
            System.out.println("Test0 effectué : connexion\n");
            test1_SelectUnique("g001");
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
     * @param idGroupe
     * @throws SQLException
     */
    public static void test1_SelectUnique(String idGroupe) throws SQLException {
        Groupe ceGroupe = DaoGroupe.selectOne(idGroupe);
        System.out.println("Groupe d'identifiant : "+ idGroupe +" : "+ceGroupe.toString());
    }

    /**
     * Affiche toutes les representations
     * @throws SQLException
     */
    public static void test2_SelectMultiple() throws SQLException {
        List<Groupe> desGroupes = DaoGroupe.selectAll();
        System.out.println("Les groupes lus : "+desGroupes.toString());
    }
}