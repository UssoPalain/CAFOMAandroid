package com.example.cafoma_1;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cafoma_1.controleur.Controleur;
import com.example.cafoma_1.entite.Documentation;
import com.example.cafoma_1.entite.Formation;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FormationActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private String TAG = "PromotionActivity";
    private Formation formation;
    private Button ajouterBtn;
    private ArrayAdapter<String> adapter;
    private ListView liste;
    private ImageView iwImage;
    private Controleur controleur;
    List<Documentation> documentationList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formation);
        Log.i(TAG, "onCreate");
        controleur = Controleur.getInstance();
        formation = controleur.getFormation();
        Log.i(TAG,"formation=" + formation);
        initialisationIhm();
    }
    private void initialisationIhm() {
        iwImage = findViewById(R.id.image);
        iwImage.setVisibility(View.VISIBLE);
        loadImageView(iwImage,"http://10.0.2.2/CAFOMA/public/images/" + formation.getImage());
        TextView titreVw = findViewById(R.id.nom);
        titreVw.setText("Formation : " + formation.getNom());
        TextView descriptionTw = findViewById(R.id.description);
        descriptionTw.setText("Description : " + formation.getDescription());
        TextView ageTw = findViewById(R.id.age);
        ageTw.setText("Age Min : " + formation.getAge());
        TextView niveauTw = findViewById(R.id.niveau);
        niveauTw.setText("Niveau Requis : " + formation.getNiveau());
        TextView createurTw = findViewById(R.id.createur);
        createurTw.setText("Createur : " + formation.getCreateur());
        documentationList = controleur.getDocumentationList();
        liste = (ListView)findViewById(R.id.listView);
        List<String> documentationListStr = new ArrayList<>();
        for(int i=0;i<documentationList.size();i++){
            documentationListStr.add(documentationList.get(i).getTitre()+" - "+documentationList.get(i).getType());
        }
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                documentationListStr);
        liste.setAdapter(adapter);
        liste.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i(TAG,"onItemClick");
        Documentation documentation = documentationList.get(position);
        controleur.setDocumentation(documentation);
        Toast.makeText(getApplicationContext(),
                documentation.toString(), Toast.LENGTH_SHORT).show();
        if (documentation.getType().equals("mp4") ) {
            Intent intent = new Intent(FormationActivity.this, AfficherVideoActivity.class);
            startActivity(intent);
        }
        if (documentation.getType().equals("pdf") ) {
            Log.i(TAG,"telecharger fichier");
            Intent intent = new Intent(FormationActivity.this, TelechargerFichierActivity.class);
            startActivity(intent);
        }
    }

    private void loadImageView (ImageView img, String url) {
        Log.i("loadImageView",url);
        new Thread(new Runnable() {
            public void run(){
                try {
                    Log.i(TAG, "loadImageView thread");
                    final Drawable drawable = Drawable.createFromStream((InputStream) new URL(url).getContent(), "src");
                    Log.i(TAG, "loadImageView dawable");
                    // Thread.sleep(100); // Pour serveur local
                    img.post(new Runnable() {
                        public void run() {
                            Log.i(TAG,"setImageDrawable");
                            img.setImageDrawable(drawable);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}