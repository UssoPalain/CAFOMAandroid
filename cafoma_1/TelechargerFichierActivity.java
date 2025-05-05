package com.example.cafoma_1;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class TelechargerFichierActivity extends AppCompatActivity {
    private String TAG = "TelechargerFichierActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telecharger_fichier);
        //String urlPdf = "http://10.0.2.2/afnd/minerve-2.2/public/ressource/pdf/and10-1-introduction.pdf";
        String urlPdf = "http://10.0.2.2/CAFOMA/public/documentation/M2I.pdf";
        Log.i(TAG,"pdf");
        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(urlPdf);
        Log.i(TAG,"uri="+uri);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
        long reference = manager.enqueue(request);
        Log.i(TAG,"reference=" + reference);
    }
}