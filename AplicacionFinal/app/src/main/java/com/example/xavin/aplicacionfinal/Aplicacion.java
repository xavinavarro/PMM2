package com.example.xavin.aplicacionfinal;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;

public class Aplicacion extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.new_item:
                Intent acerca = new Intent(Aplicacion.this, AcercaDe.class);
                startActivity(acerca);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

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