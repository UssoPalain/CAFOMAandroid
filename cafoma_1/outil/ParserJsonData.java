package com.example.cafoma_1.outil;

import android.util.Log;

//import com.ep.facture_rest.entite.Client;
//import com.ep.facture_rest.entite.Facture;

import com.example.cafoma_1.entite.Formation;
import com.example.cafoma_1.entite.Documentation;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ParserJsonData {
    private final static String TAG = "ParserJsonData";
    public static List<Formation> parserFormationJsonTab(JSONArray formationJsonTab) {
        List<Formation> formationList = new ArrayList<>();
        try {
            for (int i=0; i<formationJsonTab.length(); i++) {
                formationList.add(parserFormationJson(formationJsonTab.getJSONObject(i),true));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return formationList;
    }
    public static Formation parserFormationJson(JSONObject formationJson, boolean lazyMode) {
        Log.i(TAG, "parserFormationJson");
        Formation formation = null;
        int idFormation = 0;
        String nom = null;
        String description = null;
        int age = 0;
        String niveau = null;
        String image = null;
        String createur = null;
        try {
            idFormation = formationJson.getInt("idFormation");
            nom = formationJson.getString("nom");
            description = formationJson.getString("description");
            age = formationJson.getInt("age");
            niveau = formationJson.getString("niveau");
            image = formationJson.getString("image");
            createur = formationJson.getString("createur");
            formation = new Formation(idFormation,nom,description,age,niveau,image,createur);
            if(!lazyMode) {
                Log.i(TAG, "lazyMode=" + lazyMode);
                JSONArray formationJsonTab = formationJson.getJSONArray("formationList");
                Log.i(TAG, "formationJsonTab=" + formationJsonTab);
                List<Formation> formationList = parserFormationJsonTab(formationJsonTab);
                formation.setFormationList(formationList);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return formation;
    }
    public static List<Documentation> parserDocumentationJsonTab(JSONArray documentationJsonTab) {
        List<Documentation> documentationList = new ArrayList<>();
        try {
            for (int i=0; i<documentationJsonTab.length(); i++) {
                documentationList.add(parserDocumentationJson(documentationJsonTab.getJSONObject(i),true));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return documentationList;
    }
    public static Documentation parserDocumentationJson(JSONObject documentationJson, boolean lazyMode) {
        Log.i(TAG, "parserDocumentationJson");
        Documentation documentation = null;
        int idDocumentation = 0;
        int idFormation = 0;
        String titre = null;
        String type = null;
        try {
            idDocumentation = documentationJson.getInt("idDocumentation");
            idFormation = documentationJson.getInt("idFormation");
            titre = documentationJson.getString("titre");
            type = documentationJson.getString("type");
            documentation = new Documentation(idDocumentation,idFormation,titre,type);
            if(!lazyMode) {
                Log.i(TAG, "lazyMode=" + lazyMode);
                JSONArray documentationJsonTab = documentationJson.getJSONArray("documentationList");
                Log.i(TAG, "documentationJsonTab=" + documentationJsonTab);
                List<Documentation> documentationList = parserDocumentationJsonTab(documentationJsonTab);
                documentation.setDocumentationList(documentationList);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return documentation;
    }
    /*
    public static List<Facture> parserFactureJsonTab(JSONArray factureJsonTab) {
        List<Facture> factureList = new ArrayList<>();
        String nom = null;
        String prenom = null;
        try {
            for (int i=0; i<factureJsonTab.length(); i++) {
                factureList.add(parserFactureJson(factureJsonTab.getJSONObject(i)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return factureList;
    }
    public static Facture parserFactureJson(JSONObject factureJson) {
        Facture facture = null;
        Long id = null;
        double montant;
        String description = null;


        try {
            id = factureJson.getLong("id");
            montant = factureJson.getDouble("montant");
            description = factureJson.getString("description");
            facture = new Facture(id,montant,description);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return facture;
    }*/

}
