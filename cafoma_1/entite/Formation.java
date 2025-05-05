package com.example.cafoma_1.entite;

import java.util.List;

public class Formation {
    private int idFormation;
    private String nom;
    private String description;
    private int age;
    private String niveau;
    private String image;
    private String createur;
    private List<Formation> formationList;

    public Formation(int idFormation, String nom, String description, int age, String niveau, String image, String createur) {
        this.idFormation = idFormation;
        this.nom = nom;
        this.description = description;
        this.age = age;
        this.niveau = niveau;
        this.image = image;
        this.createur = createur;
    }

    @Override
    public String toString() {
        return "Formation{" +
                "idFormation=" + idFormation +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", age='" + age + '\'' +
                ", niveau='" + niveau + '\'' +
                ", image='" + image + '\'' +
                ", createur='" + createur + '\'' +
                ", formationList=" + formationList +
                '}';
    }

    public Integer getIdFormation() {
        return idFormation;
    }
    public void setIdFormation(Integer idFormation) {
        this.idFormation = idFormation;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNiveau() {
        return niveau;
    }
    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public String getCreateur() {
        return createur;
    }
    public void setCreateur(String createur) {
        this.createur = createur;
    }

    public List<Formation> getFormationList() {
        return formationList;
    }
    public void setFormationList(List<Formation> formationList) {this.formationList = formationList;}
}
