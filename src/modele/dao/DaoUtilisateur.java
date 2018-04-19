package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modele.metier.Utilisateur;

public class DaoUtilisateur {
    /**
     * Extraction d'un utilisateur, sur son identifiant
     * @param id identifiant
     * @return objet Utilisateur
     * @throws SQLException 
     */
    public static Utilisateur selectOne(int id) throws SQLException {
        Utilisateur unUtilisateur = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM Utilisateur WHERE ID= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, id);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            int idUtil = rs.getInt("id");
            String login = rs.getString("login");
            String password = rs.getString("password");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            unUtilisateur = new Utilisateur(idUtil, login, password, nom, prenom);
        }
        return unUtilisateur;
    }
    
        /**
     * Extraction d'un utilisateur, sur son identifiant
     * @param id identifiant
     * @return objet Utilisateur
     * @throws SQLException 
     */
    public static Utilisateur selectOneByLoginMdp(String login, String mdp) throws SQLException {
        Utilisateur unUtilisateur = null;
        ResultSet rs;
        PreparedStatement pstmt;
        JdbcDistant jdbcDistant = JdbcDistant.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM Utilisateur WHERE login= ? AND password=?";
        pstmt = jdbcDistant.getConnexion().prepareStatement(requete);
        pstmt.setString(1, login);
        pstmt.setString(2, mdp);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            int idUtil = rs.getInt("id");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            unUtilisateur = new Utilisateur(idUtil, login, mdp, nom, prenom);
        }
        return unUtilisateur;
    }

    /**
     * Extraction de tout les utilisateurs
     * @return collection d'utilisateurs
     * @throws SQLException 
     */
    public static List<Utilisateur> selectAll() throws SQLException {
        List<Utilisateur> lesUtilisateurs = new ArrayList<Utilisateur>();
        Utilisateur unUtilisateur;
        ResultSet rs;
        PreparedStatement pstmt;
        JdbcDistant jdbcDistant = JdbcDistant.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM Utilisateur";
        pstmt = jdbcDistant.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            int idUtil = rs.getInt("id");
            String login = rs.getString("login");
            String password = rs.getString("password");
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            unUtilisateur = new Utilisateur(idUtil, login, password, nom, prenom);
            lesUtilisateurs.add(unUtilisateur);
        }
        return lesUtilisateurs;
    }
}