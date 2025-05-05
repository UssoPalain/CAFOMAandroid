package com.example.cafoma_1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cafoma_1.controleur.Controleur;
import com.example.cafoma_1.rest.AccesDistant;
import com.example.cafoma_1.rest.RequeteHttp;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private ImageButton btnFormationListImg;
    private static String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Controleur.getInstance();
        initialisationIhm();
        /*
        AccesDistant accesDistant = new AccesDistant();
        // action=FormationByID
        Map<String, String> params = new HashMap<>();
        params.put("id", "1");
        accesDistant.envoyerRequete("FormationByID", params);
        params = new HashMap<>();
        params.put("id", "1");
        accesDistant.envoyerRequete("DocumentationByID", params);

         */
        /*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

         */
    }
    private void initialisationIhm() {
        btnFormationListImg = (ImageButton)findViewById(R.id.btnFormationListImg);
        ecouterFormationListImg();

    }
    private void ecouterFormationListImg(){
        btnFormationListImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"Evt ecouterFormationListImg");
                Intent intent = new Intent(MainActivity.this, FormationListActivity.class);
                startActivity(intent);
            }
        });
    }
}