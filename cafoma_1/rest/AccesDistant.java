package com.example.cafoma_1.rest;

import android.util.Log;

import com.example.cafoma_1.entite.Documentation;
import com.example.cafoma_1.entite.Formation;
import com.example.cafoma_1.controleur.Controleur;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

import com.example.cafoma_1.outil.ParserJsonData;

public class AccesDistant implements CallBackResponseHttpItf {
    private final static String TAG = "AccesDistant";
    private static final String SERVERADDR = "http://10.0.2.2/CAFOMA/serveur.php";
    private Controleur controleur;

    public AccesDistant(){
        controleur = Controleur.getInstance();
    }
    @Override
    public void reponseRequeteCallBack(String reponse) {
        Log.i(TAG, "reponse=" + reponse);
        String[] message = reponse.split("#");
        Log.i(TAG, "message[0]=" + message[0]);
        if(message.length > 1) {
            try {
                if (message[0].equals("allFormations")) {
                    JSONArray formationJsonTab = new JSONArray(message[1]);
                    List<Formation> formationList = ParserJsonData.parserFormationJsonTab(formationJsonTab);
                    Log.i(TAG, "formationList=" + formationList);
                    controleur.setFormationList(formationList);
                }
                if (message[0].equals("Formation")) {
                    JSONObject formationJson = new JSONObject(message[1]);
                    Formation formation = ParserJsonData.parserFormationJson(formationJson,false);
                    Log.i(TAG, "formation=" + formation);
                    controleur.setFormation(formation);
                }
                if (message[0].equals("Documentations")) {
                    JSONArray documentationJson = new JSONArray(message[1]);
                    List<Documentation> documentationList = ParserJsonData.parserDocumentationJsonTab(documentationJson);
                    Log.i(TAG, "documentationList=" + documentationList);
                    controleur.setDocumentation(documentationList);
                }

                else if (message[0].equals("erreur")) {
                    Log.i(TAG,"Erreur : " + message[1]);
                }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
        }


    }
    public void envoyerRequete(String operation, Map<String,String> parametres){
        RequeteHttp requeteHttp = new RequeteHttp();
        requeteHttp.callBackResponseHttp = this;
        // action=FormationByID
        requeteHttp.addParamUrl("action", operation);
        if(parametres != null){
            for(String cle : parametres.keySet()){
                requeteHttp.addParamUrl(cle, parametres.get(cle));
            }
        }
        requeteHttp.execute(SERVERADDR);
    }
}
