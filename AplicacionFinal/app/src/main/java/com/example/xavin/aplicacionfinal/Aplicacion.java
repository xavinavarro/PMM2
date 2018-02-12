package com.example.xavin.aplicacionfinal;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

public class Aplicacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aplicacion);

        final Button BotonDC = (Button) findViewById(R.id.BotonDC);
        final Button BotonMarvel = (Button) findViewById(R.id.BotonMarvel);
        final Button BotonManga = (Button) findViewById(R.id.BotonManga);
        final Button BotonClasicos = (Button) findViewById(R.id.BotonClasicos);
        final Button BotonWeb = (Button) findViewById(R.id.BotonWeb);

        BotonDC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irDC = new Intent(Aplicacion.this, DetectiveComics.class);
                startActivity(irDC);

            }
        });
        BotonMarvel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irMarvel = new Intent(Aplicacion.this, Marvel.class);
                startActivity(irMarvel);

            }
        });
        BotonManga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irManga = new Intent(Aplicacion.this, Mangas.class);
                startActivity(irManga);

            }
        });

        BotonWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irWeb = new Intent(Aplicacion.this, Web.class);
                startActivity(irWeb);

            }
        });
        BotonClasicos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent irClasicos = new Intent(Aplicacion.this, ComicsClasicos.class);
                startActivity(irClasicos);

            }
        });
    }
}