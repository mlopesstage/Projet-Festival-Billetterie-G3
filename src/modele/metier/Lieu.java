package modele.metier;

public class Lieu {  
    
    private int id;
    
    private String nom;
    
    private String adr;
    
    private int capacite;

    public Lieu(int id, String nom, String adr, int capacite) {
        this.id = id;
        this.nom = nom;
        this.adr = adr;
        this.capacite = capacite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    @Override
    public String toString() {
        return "Lieu{" + "id=" + id + ", nom=" + nom + ", adr=" + adr + ", capacite=" + capacite + '}';
    }
}