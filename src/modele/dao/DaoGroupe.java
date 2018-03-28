package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modele.metier.Groupe;

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
}