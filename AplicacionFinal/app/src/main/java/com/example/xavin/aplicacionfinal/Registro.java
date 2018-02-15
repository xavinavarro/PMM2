package com.example.xavin.aplicacionfinal;

    import android.content.Intent;
    import android.database.sqlite.SQLiteDatabase;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.Menu;
    import android.view.MenuInflater;
    import android.view.MenuItem;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;

public class Registro extends AppCompatActivity {
    private UsuarioSQLiteHelper usuarioSQLiteHelper;

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
                Intent acerca = new Intent(Registro.this, AcercaDe.class);
                startActivity(acerca);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_registro);

        final Button BotonRegistro = (Button) findViewById(R.id.BotonRegistrar);
        final Button BotonVolver= (Button) findViewById(R.id.BotonVolver);
        final EditText RegistroNombre = (EditText) findViewById(R.id.RegistroNombre);
        final EditText RegistroPassword = (EditText) findViewById(R.id.RegistroPassword);

        usuarioSQLiteHelper = new UsuarioSQLiteHelper(this, "BDUsuario", null, 1);
        BotonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase bd = usuarioSQLiteHelper.getWritableDatabase();
                bd.execSQL("INSERT INTO Usuarios(nombre, password) values('"+RegistroNombre.getText().toString()+"','"+RegistroPassword.getText().toString()+"')");
                bd.close();
                Intent volver = new Intent(Registro.this, MainActivity.class);
                startActivity(volver);
            }
        });
        BotonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volver = new Intent(Registro.this, MainActivity.class);
                startActivity(volver);
            }
        });
    }
}
