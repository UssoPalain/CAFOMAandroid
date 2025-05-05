package com.example.cafoma_1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cafoma_1.controleur.Controleur;
import com.example.cafoma_1.entite.Formation;

import java.util.ArrayList;
import java.util.List;

public class FormationListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private String TAG = "FormationListActivity";
    private Controleur controleur;
    private Button ajouterBtn;
    private ArrayAdapter<String> adapter;
    private ListView liste;
    private List<Formation> formationList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setContentView(R.layout.activity_formation_list);
        controleur = Controleur.getInstance();
        liste = (ListView)findViewById(R.id.listView);
        liste.setTextFilterEnabled(true);
        formationList = controleur.getFormationList();
        List<String> chainePromotions = new ArrayList<>();
        for(int i = 0; i< formationList.size(); i++){
            chainePromotions.add(formationList.get(i).getIdFormation()+
                    " - "+ formationList.get(i).getNom()); /* +" - "+ formationList.get(i).getDescription()
                    +" - "+ formationList.get(i).getAge()+" - "+ formationList.get(i).getNiveau()
                    +" - "+ formationList.get(i).getImage()+" - "+ formationList.get(i).getCreateur()); */
        }
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                chainePromotions);
        liste.setAdapter(adapter);
        liste.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // TODO Auto-generated method stub
        Log.i(TAG,"onItemClick position=" + position);
        Formation formation = formationList.get(position);
        controleur.lireFormation(formation.getIdFormation());
        Toast.makeText(getApplicationContext(),
                formation.toString(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(FormationListActivity.this, FormationActivity.class);
        startActivity(intent);
    }


}