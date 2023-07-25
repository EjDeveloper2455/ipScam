package com.softs.hn.ip.ipscam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.os.Bundle;

import com.softs.hn.ip.ipscam.databinding.ActivityMenuReconocimientoBinding;

public class MenuReconocimiento extends AppCompatActivity {

    private ImageView imageView;
    private ActivityMenuReconocimientoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMenuReconocimientoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        if (intent.hasExtra("placa")){
            String placa = intent.getStringExtra("placa");
            //Toast.makeText(this,placa,Toast.LENGTH_LONG).show();
            runOnUiThread(() -> {
                try {
                    new HttpGetRequest(binding).execute("http://34.125.242.85:8080/api/consultar/"+placa);
                    //
                } catch (Exception e) {
                    throw new RuntimeException(e);
                };
            });
        }
        // Obtener la URI de la imagen seleccionada desde el Intent
        String imageUriString = getIntent().getStringExtra("image_uri");
        if (imageUriString != null) {
            // Convertir la URI nuevamente a un objeto Uri
            Uri imageUri = Uri.parse(imageUriString);

            // Mostrar la imagen en el ImageView utilizando Glide

        }
    }
}