/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele.metier;

/**
 *
 * @author ychantreau
 */
public class Groupe {
    /**
     * identifiant du groupe ("gxxx")
     * @var string
     */
    private String id;
    /**
     * nom du groupe
     * @var string
     */
    private String nom;
    /**
     * nom du responsable du groupe
     * @var string 
     */
    private String identite;
    /**
     * adresse du groupe
     * @var string
     */
    private String adresse;
    /**
     * effectif du groupe
     * @var integer
     */
    private int nbPers;
    /**
     * nom du pays d'origine
     * @var string 
     */
    private String nomPays;
    /**
     * Souhaite un hébergement (O/N)
     * @var char 
     */
    private char hebergement;

    public Groupe(String id, String nom, String identite, String adresse, int nbPers, String nomPays, char hebergement) {
        this.id = id;
        this.nom = nom;
        this.identite = identite;
        this.adresse = adresse;
        this.nbPers = nbPers;
        this.nomPays = nomPays;
        this.hebergement = hebergement;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getIdentite() {
        return identite;
    }

    public void setIdentite(String identite) {
        this.identite = identite;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNbPers() {
        return nbPers;
    }

    public void setNbPers(int nbPers) {
        this.nbPers = nbPers;
    }

    public String getNomPays() {
        return nomPays;
    }

    public void setNomPays(String nomPays) {
        this.nomPays = nomPays;
    }

    public char getHebergement() {
        return hebergement;
    }

    public void setHebergement(char hebergement) {
        this.hebergement = hebergement;
    }

}
