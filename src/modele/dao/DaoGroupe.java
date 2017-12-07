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
import modele.metier.Groupe;

/**
 *
 * @author ychantreau
 */
public class DaoGroupe {
    /**
     * Extraction d'une representation, sur son identifiant
     * @param idGroupe identifiant
     * @return objet Groupe
     * @throws SQLException 
     */
    public static Groupe selectOne(String idGroupe) throws SQLException {
        Groupe unGroupe = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM Groupe WHERE ID= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, idGroupe);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            String id = rs.getString("id");
            String nom = rs.getString("nom");
            String identiteResponsable = rs.getString("identiteResponsable");
            String adresse = rs.getString("adressePostale");
            int nbPersonne = rs.getInt("nombrePersonnes");
            String nomPays = rs.getString("nomPays");
            String hebergement =rs.getString("hebergement");
            unGroupe = new Groupe(id, nom, identiteResponsable, adresse, nbPersonne, nomPays, hebergement);
        }
        return unGroupe;
    }
    /**
     * Extraction de toutes les representations
     * @return collection d'representations
     * @throws SQLException 
     */
    public static List<Groupe> selectAll() throws SQLException {
        List<Groupe> lesGroupes = new ArrayList<Groupe>();
        Groupe unGroupe;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM Groupe";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            String id = rs.getString("id");
            String nom = rs.getString("nom");
            String identiteResponsable = rs.getString("identiteResponsable");
            String adresse = rs.getString("adressePostale");
            int nbPersonne = rs.getInt("nombrePersonnes");
            String nomPays = rs.getString("nomPays");
            String hebergement =rs.getString("hebergement");
            unGroupe = new Groupe(id, nom, identiteResponsable, adresse, nbPersonne, nomPays, hebergement);
            lesGroupes.add(unGroupe);
        }
        return lesGroupes;
    }
    
        /**
     * Extraction de toutes les representations dont le nom de ville contient la chaîne recherchée
     * @param extraitNomVille
     * @return collection d'representations
     * @throws SQLException 
     *
    public static List<Groupe> selectAllByVille(String extraitNomVille) throws SQLException {
        List<Groupe> lesGroupes = new ArrayList<Groupe>();
        Groupe uneGroupe;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM Groupe WHERE ville LIKE ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, "%"+extraitNomVille+"%");
        rs = pstmt.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("ID");
            String rue = rs.getString("RUE");
            String cdp = rs.getString("CDP");
            String ville = rs.getString("VILLE");
            uneGroupe = new Groupe(id, rue, cdp, ville);
            lesGroupes.add(uneGroupe);
        }
        return lesGroupes;
    }    
    /**
     * Extraction de toutes les representations, ordonnées
     * @param cleTri 1=>ID ; 2=>VILLE
     * @param ordreTri 1=>ASC ; 2=>DESC
     * @return collection de representations
     * @throws SQLException 
     *
    public static List<Groupe> selectAll(int cleTri, int ordreTri) throws SQLException {
        List<Groupe> lesGroupes = new ArrayList<Groupe>();
        Groupe uneGroupe;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM Groupe";
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
            uneGroupe = new Groupe(id, rue, cdp, ville);
            lesGroupes.add(uneGroupe);
        }
        return lesGroupes;
    }
    public static int insert(int idGroupe, Groupe uneGroupe) throws SQLException {
        int nb;
        Jdbc jdbc = Jdbc.getInstance();
        String requete;
        ResultSet rs;
        PreparedStatement pstmt;
        requete = "INSERT INTO Groupe (ID, RUE, CDP , VILLE) VALUES (?, ?, ?, ?)";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, idGroupe);
        pstmt.setString(2, uneGroupe.getRue());
        pstmt.setString(3, uneGroupe.getCp());
        pstmt.setString(4, uneGroupe.getVille());
        nb = pstmt.executeUpdate();
        return nb;
    }
    public static int update(int idGroupe, Groupe uneGroupe) throws SQLException {
        int nb;
        Jdbc jdbc = Jdbc.getInstance();
        String requete;
        ResultSet rs;
        PreparedStatement pstmt;
        requete = "UPDATE Groupe SET RUE = ? , CDP = ? , VILLE = ? WHERE ID = ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, uneGroupe.getRue());
        pstmt.setString(2, uneGroupe.getCp());
        pstmt.setString(3, uneGroupe.getVille());
        pstmt.setInt(4, idGroupe);
        nb = pstmt.executeUpdate();
        return nb;
    }
    public static int delete(int idGroupe) throws SQLException {
        int nb;
        Jdbc jdbc = Jdbc.getInstance();
        String requete;
        ResultSet rs;
        PreparedStatement pstmt;
        requete = "DELETE  FROM Groupe WHERE ID = ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, idGroupe);
        nb = pstmt.executeUpdate();
        return nb;
    }*/
}