package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modele.metier.Representation;

/**
 *
 * @author mlopes
 */

public class DaoVenteDePlaces {
    public static int update(int idRepresentation, Representation uneRepresentation) throws SQLException {
        int nb;
        Jdbc jdbc = Jdbc.getInstance();
        String requete;
        ResultSet rs;
        PreparedStatement pstmt;
        requete = "UPDATE Lieu SET capaciteAccueil = capaciteAccueil - rs INNER JOIN Representation WHERE Representation.id = Lieu.id";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setString(1, uneRepresentation.getRue());
        pstmt.setString(2, uneRepresentation.getCp());
        pstmt.setString(3, uneRepresentation.getVille());
        pstmt.setInt(4, idRepresentation);
        nb = pstmt.executeUpdate();
        return nb;
    }
}