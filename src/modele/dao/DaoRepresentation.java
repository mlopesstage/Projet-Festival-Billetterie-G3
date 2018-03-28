package modele.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modele.metier.Groupe;
import modele.metier.Lieu;
import modele.metier.Representation;

public class DaoRepresentation {
    /**
     * Extraction d'une representation, sur son identifiant
     * @param idRepresentation identifiant
     * @return objet Representation
     * @throws SQLException 
     */
    public static Representation selectOne(int idRepresentation) throws SQLException {
        Representation uneRepresentation = null;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM Representation WHERE ID= ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, idRepresentation);
        rs = pstmt.executeQuery();
        if (rs.next()) {      
            uneRepresentation = representationFromResultSet(rs);
        }
        return uneRepresentation;
    }

    /**
     * Extraction de toutes les representations
     * @return collection d'representations
     * @throws SQLException 
     */
    public static List<Representation> selectAll() throws SQLException {
        List<Representation> lesRepresentations = new ArrayList<Representation>();
        Representation uneRepresentation;
        ResultSet rs;
        PreparedStatement pstmt;
        Jdbc jdbc = Jdbc.getInstance();
        // préparer la requête
        String requete = "SELECT * FROM Representation ";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            uneRepresentation =  representationFromResultSet(rs);
            lesRepresentations.add(uneRepresentation);
        }
        return lesRepresentations;
    }
    
        private static Representation representationFromResultSet(ResultSet rs) throws SQLException {
        Representation rp = null;
        
        int id = rs.getInt("id");
        int idLieu = rs.getInt("idLieu");
        String idGroupe = rs.getString("idGroupe");
        Date date= rs.getDate("dateRep");
        Time heureD = rs.getTime("heureDebut");
        Time heureF = rs.getTime("heureFin");
        int nbPlacesVendues = rs.getInt("nbPlacesVendues");

        LocalTime heureDebut = LocalTime.of(heureD.getHours(),heureD.getMinutes(), heureD.getSeconds(),0);
        LocalTime heureFin = LocalTime.of(heureF.getHours(),heureF.getMinutes(), heureF.getSeconds(),0);
        LocalDate dateRep = LocalDate.of(date.getYear()+1900,date.getMonth()+1, date.getDate());
        Lieu lieu = DaoLieu.selectOne(idLieu);
        Groupe groupe = DaoGroupe.selectOne(idGroupe);
        
        rp = new Representation(id, lieu, groupe, dateRep,heureDebut,heureFin,nbPlacesVendues);
        
        return rp;
    }
        
    public static int vendreRepresentation(int idRepresentation,int nbPlacesVendues) throws SQLException {
        int nb;
        Jdbc jdbc = Jdbc.getInstance();
        String requete;
        ResultSet rs;
        PreparedStatement pstmt;
        requete = "UPDATE Representation SET nbPlacesVendues = ? WHERE ID = ?";
        pstmt = jdbc.getConnexion().prepareStatement(requete);
        pstmt.setInt(1, nbPlacesVendues);
        pstmt.setInt(2, idRepresentation);
        nb = pstmt.executeUpdate();
        System.out.println(nbPlacesVendues + " places vendues");
        return nb;
    }
}