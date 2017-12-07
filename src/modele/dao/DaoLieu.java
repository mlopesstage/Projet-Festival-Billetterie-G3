/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modele.metier.Lieu;

/**
 *
 * @author ychantreau
 */
public class DaoLieu {
    /**
     * Extraction d'une representation, sur son identifiant
     * @param idLieu identifiant
     * @return objet Lieu
     * @throws SQLException 
     */
    public static Lieu selectOne(int idLieu) throws SQLException {
        Lieu unLieu = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM Lieu WHERE ID= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, idLieu);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("id");
            String nomLieu = rs.getString("nomLieu");
            String adresseLieu = rs.getString("adresseLieu");
            int capacite = rs.getInt("capaciteAccueil");
            unLieu = new Lieu(id, nomLieu, adresseLieu, capacite);
        }
        return unLieu;
    }
    /**
     * Extraction de toutes les representations
     * @return collection d'representations
     * @throws SQLException 
     */
    public static List<Lieu> selectAll() throws SQLException {
        List<Lieu> lesLieus = new ArrayList<Lieu>();
        Lieu unLieu;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM Lieu";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String nomLieu = rs.getString("nomLieu");
            String adresseLieu = rs.getString("adresseLieu");
            int capacite = rs.getInt("capaciteAccueil");
            unLieu = new Lieu(id, nomLieu, adresseLieu, capacite);
            lesLieus.add(unLieu);
        }
        return lesLieus;
    }
    
        /**
     * Extraction de toutes les representations dont le nom de ville contient la chaîne recherchée
     * @param extraitNomVille
     * @return collection d'representations
     * @throws SQLException 
     *
    public static List<Lieu> selectAllByVille(String extraitNomVille) throws SQLException {
        List<Lieu> lesLieus = new ArrayList<Lieu>();
        Lieu uneLieu;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM Lieu WHERE ville LIKE ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, "%"+extraitNomVille+"%");
        rs = pstmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("ID");
            String rue = rs.getString("RUE");
            String cdp = rs.getString("CDP");
            String ville = rs.getString("VILLE");
            uneLieu = new Lieu(id, rue, cdp, ville);
            lesLieus.add(uneLieu);
        }
        return lesLieus;
    }    
    /**
     * Extraction de toutes les representations, ordonnées
     * @param cleTri 1=>ID ; 2=>VILLE
     * @param ordreTri 1=>ASC ; 2=>DESC
     * @return collection de representations
     * @throws SQLException 
     *
    public static List<Lieu> selectAll(int cleTri, int ordreTri) throws SQLException {
        List<Lieu> lesLieus = new ArrayList<Lieu>();
        Lieu uneLieu;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM Lieu";
        switch (cleTri) {
            case 1: // Tri par Id
                requete += " ORDER BY ID";
                break;
            case 2: // Tri par ville
                requete += " ORDER BY VILLE";
                break;
        }
        if (cleTri == 1 || cleTri == 2) {
            switch (ordreTri) {
                case 1: // Tri croissant
                    requete += " ASC";
                    break;
                case 2: // Tri décroissant
                    requete += " DESC";
                    break;
            }
        }
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("ID");
            String rue = rs.getString("RUE");
            String cdp = rs.getString("CDP");
            String ville = rs.getString("VILLE");
            uneLieu = new Lieu(id, rue, cdp, ville);
            lesLieus.add(uneLieu);
        }
        return lesLieus;
    }
    public static int insert(int idLieu, Lieu uneLieu) throws SQLException {
        int nb;
        Jdbc jdbc = Jdbc.getInstance();
        String requete;
        ResultSet rs;
        PreparedStatement pstmt;
        requete = "INSERT INTO Lieu (ID, RUE, CDP , VILLE) VALUES (?, ?, ?, ?)";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, idLieu);
        pstmt.setString(2, uneLieu.getRue());
        pstmt.setString(3, uneLieu.getCp());
        pstmt.setString(4, uneLieu.getVille());
        nb = pstmt.executeUpdate();
        return nb;
    }
    public static int update(int idLieu, Lieu uneLieu) throws SQLException {
        int nb;
        Jdbc jdbc = Jdbc.getInstance();
        String requete;
        ResultSet rs;
        PreparedStatement pstmt;
        requete = "UPDATE Lieu SET RUE = ? , CDP = ? , VILLE = ? WHERE ID = ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, uneLieu.getRue());
        pstmt.setString(2, uneLieu.getCp());
        pstmt.setString(3, uneLieu.getVille());
        pstmt.setInt(4, idLieu);
        nb = pstmt.executeUpdate();
        return nb;
    }
    public static int delete(int idLieu) throws SQLException {
        int nb;
        Jdbc jdbc = Jdbc.getInstance();
        String requete;
        ResultSet rs;
        PreparedStatement pstmt;
        requete = "DELETE  FROM Lieu WHERE ID = ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, idLieu);
        nb = pstmt.executeUpdate();
        return nb;
    }*/
}