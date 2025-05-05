package com.example.cafoma_1.controleur;

import com.example.cafoma_1.entite.Formation;
import com.example.cafoma_1.entite.Documentation;
import com.example.cafoma_1.rest.AccesDistant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controleur {
    private String TAG = "Controleur";
    private static Controleur instance = null;
    private List<Formation> formationList;
    private Formation formation;
    private List<Documentation> documentationList;
    private static AccesDistant accesDistant;
    private Documentation documentation;

    private Controleur(){}
    public static Controleur getInstance(){
        if(instance == null) {
            instance = new Controleur();
            accesDistant = new AccesDistant();
            accesDistant.envoyerRequete("allFormations", null);
        }
        return instance;
    }
    public void lireFormation(Integer idFormation) {
        Map<String,String> parametres = new HashMap<>();
        parametres.put("id",idFormation.toString());
        accesDistant.envoyerRequete("FormationByID", parametres);
        accesDistant.envoyerRequete("DocumentationByID", parametres);
    }

    public List<Formation> getFormationList() {
        return formationList;
    }

    public void setFormationList(List<Formation> formationList) {this.formationList = formationList;}

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public List<Documentation> getDocumentationList() {return documentationList;}

    public void setDocumentation(List<Documentation> documentationList) {this.documentationList = documentationList;}

    public void setDocumentation(Documentation documentation) {this.documentation = documentation;}
    public Documentation getDocumentation() { return documentation; }
}
