package com.example.xavin.aplicacionfinal;

    import android.database.Cursor;
    import android.database.sqlite.SQLiteDatabase;
    import android.support.v7.app.AppCompatActivity;
    import android.content.Intent;
    import android.os.Bundle;
    import android.view.ContextMenu;
    import android.view.Menu;
    import android.view.MenuInflater;
    import android.view.MenuItem;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private UsuarioSQLiteHelper usuarioCli;

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
                Intent acerca = new Intent(MainActivity.this, AcercaDe.class);
                startActivity(acerca);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button BotonRegistro = (Button) findViewById(R.id.BotonRegistro);
        final Button BotonAceptar = (Button) findViewById(R.id.BotonAceptar);
        final EditText EntradaNombre = (EditText) findViewById(R.id.EntradaNombre);
        final EditText EntradaPassword = (EditText) findViewById(R.id.EntradaPassword);

        usuarioCli = new UsuarioSQLiteHelper(this, "BDUsuario", null, 1);
        BotonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //crear el enlace que al pulsar el boton vaya a registro
                Intent irRegistro = new Intent(MainActivity.this,Registro.class);
                startActivity(irRegistro);
            }
        });
        BotonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            //dame lo que esta escrito en la bd
            public void onClick(View view) {
                SQLiteDatabase bd = usuarioCli.getWritableDatabase();

                String nombre = EntradaNombre.getText().toString();
                String password = EntradaPassword.getText().toString();

                Cursor cursor = bd.rawQuery("SELECT nombre, password FROM Usuarios WHERE nombre='"+nombre+"'and password='"+password+"'",null);

                //Si existe valor en la bd
                if(cursor.moveToFirst()){
                    String nom = cursor.getString(0);
                    String pass = cursor.getString(1);

                    if (nombre.equals(nom)&&password.equals(pass)){
                        Intent irAplicacion = new Intent(MainActivity.this,Aplicacion.class);
                        startActivity(irAplicacion);
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"ERROR en la base de datos", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}