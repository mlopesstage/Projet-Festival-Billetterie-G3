/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author ychantreau
 */
public class Representation {
    
    private int id;
    
    private int idLieu;
    
    private String idGroupe;
    
    private Date dateRep;
    
    private Time heureDebut;
    
    private Time heureFin;
    
    public Representation (int id,int idLieu,String idGroupe,Date dateRep,Time heureDebut,Time heureFin){
        this.id=id;
        this.idLieu=idLieu;
        this.idGroupe=idGroupe;
        this.dateRep=dateRep;
        this.heureDebut=heureDebut;
        this.heureFin=heureFin;        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdLieu() {
        return idLieu;
    }

    public void setIdLieu(int idLieu) {
        this.idLieu = idLieu;
    }

    public String getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(String idGroupe) {
        this.idGroupe = idGroupe;
    }

    public Date getDateRep() {
        return dateRep;
    }

    public void setDateRep(Date dateRep) {
        this.dateRep = dateRep;
    }

    public Time getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(Time heureDebut) {
        this.heureDebut = heureDebut;
    }

    public Time getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(Time heureFin) {
        this.heureFin = heureFin;
    }

    @Override
    public String toString() {
        return "Representation{" + "id=" + id + ", idLieu=" + idLieu + ", idGroupe=" + idGroupe + ", dateRep=" + dateRep + ", heureDebut=" + heureDebut + ", heureFin=" + heureFin + '}';
    }
    
    
}
