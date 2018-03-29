package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modele.metier.Lieu;

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
}