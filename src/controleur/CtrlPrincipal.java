/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;
import modele.dao.DaoRepresentation;
import modele.metier.Representation;
import vue.VueRepresentation;
/**
 *
 * @author ychantreau
 */
public class CtrlPrincipal {
    private CtrlLesRepresentations ctrlLesRepresentations = null;
    VueRepresentation vueRepresentation = new VueRepresentation();
    CtrlLesRepresentations unControleur = new CtrlLesRepresentations(vueRepresentation);
    
    public void afficherLesRepresentations(){
        vueRepresentation.setVisible(true);
    }
    
    
    public CtrlLesRepresentations getCtrlLesRepresentations() {
        return ctrlLesRepresentations;
    }

    public void setCtrlLesRepresentations(CtrlLesRepresentations ctrlLesRepresentations) {
        this.ctrlLesRepresentations = ctrlLesRepresentations;
    }
    
}
