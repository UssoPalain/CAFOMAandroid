package com.example.cafoma_1.entite;

import java.util.List;

public class Documentation {
    private int idDocumentation;
    private int idFormation;
    private String titre;
    private String type;
    private List<Documentation> documentationList;

    public Documentation(int idDocumentation, int idFormation, String titre, String type) {
        this.idDocumentation = idDocumentation;
        this.idFormation = idFormation;
        this.titre = titre;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Documentation{" +
                "idDocumentation=" + idDocumentation +
                ", idFormation='" + idFormation + '\'' +
                ", titre='" + titre + '\'' +
                ", type='" + type + '\'' +
                ", documentationList=" + documentationList +
                '}';
    }

    public Integer getIdDocumentation() {
        return idDocumentation;
    }
    public void setIdDocumentation(int idDocumentation) {
        this.idDocumentation = idDocumentation;
    }

    public Integer getIdFormation() {
        return idFormation;
    }
    public void setIdFormation(int idFormation) {
        this.idFormation = idFormation;
    }

    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public List<Documentation> getDocumentationList() {
        return documentationList;
    }
    public void setDocumentationList(List<Documentation> documentationList) {this.documentationList = documentationList;}
}
