package com.tecmilenio.actividad3;

import android.os.Bundle;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imagen;
    private Button botonMas, botonMenos;
    private float factorDeEscala = 1.0f;
    private boolean primerClick = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagen = findViewById(R.id.imagen);
        botonMas = findViewById(R.id.boton_mas);
        botonMenos = findViewById(R.id.boton_menos);

        botonMas.setOnClickListener(v -> {
            interaccionToast();
            tamañoImagen(1.1f);
        });

        botonMas.setOnLongClickListener(v -> {
            interaccionToast();
            tamañoImagen(1.3f);
            return true;
        });

        botonMenos.setOnClickListener(v -> {
            interaccionToast();
            tamañoImagen(0.9f);
        });

        botonMenos.setOnLongClickListener(v -> {
            interaccionToast();
            tamañoImagen(0.7f);
            return true;
        });
    }

    // Metodo para cambiar el tamaño de la imagen
    private void tamañoImagen(float factor) {
        factorDeEscala *= factor;
        imagen.setScaleX(factorDeEscala);
        imagen.setScaleY(factorDeEscala);
    }

    // Metodo para mostrar el Toast solo la primera vez que se hace click a uno de los botones
    private void interaccionToast() {
        if (primerClick) {
            Toast.makeText(MainActivity.this, "Hay interacciones para onClick y onLongClick", Toast.LENGTH_SHORT).show();
            primerClick = false;
        }
    }
}