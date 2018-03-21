/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author ychantreau
 */
public class Representation {
    
   private int id;
    
    private Lieu lieu;
    
    private Groupe groupe;
    
    private LocalDate dateRep;
    
    private LocalTime heureDebut;
    
    private LocalTime heureFin;
    
    private int nbPlacesVendues;

    public Representation(int id, Lieu lieu, Groupe groupe, LocalDate dateRep, LocalTime heureDebut, LocalTime heureFin,int nbPlacesVendues) {
        this.id = id;
        this.lieu = lieu;
        this.groupe = groupe;
        this.dateRep = dateRep;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.nbPlacesVendues = nbPlacesVendues;
    }

    public int getNbPlacesVendues() {
        return nbPlacesVendues;
    }

    public void setNbPlacesVendues(int nbPlacesVendues) {
        this.nbPlacesVendues = nbPlacesVendues;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Lieu getLieu() {
        return lieu;
    }

    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public LocalDate getDateRep() {
        return dateRep;
    }

    public void setDateRep(LocalDate dateRep) {
        this.dateRep = dateRep;
    }

    public LocalTime getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(LocalTime heureDebut) {
        this.heureDebut = heureDebut;
    }

    public LocalTime getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(LocalTime heureFin) {
        this.heureFin = heureFin;
    }

    @Override
    public String toString() {
        return "Representation_1{" + "id=" + id + ", lieu=" + lieu + ", groupe=" + groupe + ", dateRep=" + dateRep + ", heureDebut=" + heureDebut + ", heureFin=" + heureFin + '}';
    }
    
   
}

