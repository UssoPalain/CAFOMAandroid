package com.example.cafoma_1;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cafoma_1.controleur.Controleur;
import com.example.cafoma_1.entite.Documentation;

public class AfficherVideoActivity extends AppCompatActivity {
    private static String TAG = "AfficherVideoActivity";
    private WebView wvVideo;
    private String urlVideo;
    private Documentation documentation;
    private Controleur controleur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher_video);
        controleur = Controleur.getInstance();
        documentation = controleur.getDocumentation();
        urlVideo = "http://10.0.2.2/CAFOMA/public/documentation/" + documentation.getTitre();
        Log.i(TAG,"onCreate");
        init(urlVideo);
    }

    private void init(String urlVideo){
        if(urlVideo!=null) {
            wvVideo = findViewById(R.id.wvVideoId);
            wvVideo.getSettings().setJavaScriptEnabled(true);
            wvVideo.setWebViewClient(new WebViewClient());
            wvVideo.loadUrl(urlVideo);
        }
    }

    @Override
    protected void onStop() {
        // call the superclass method first
        super.onStop();
        Log.i(TAG,"onStop");
        wvVideo.destroy();
    }


}