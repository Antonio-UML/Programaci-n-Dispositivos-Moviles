package com.example.mytanda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etNumero, etNombre, etCantidad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumero = findViewById(R.id.etNumero);
        etNombre = findViewById(R.id.etNombre);
        etCantidad = findViewById(R.id.etCantidad);
    }

    //Registro en la base de datos
    public void Registrar (View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion",  null,  1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String numero = etNumero.getText().toString();
        String nombre = etNombre.getText().toString();
        String cantidad = etCantidad.getText().toString();

        if(!numero.isEmpty() || !nombre.isEmpty() || !cantidad.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("idp",numero);
            registro.put("nombre",nombre);
            registro.put("cantidad",cantidad);

            BaseDeDatos.insert("participantes", null,registro);
            BaseDeDatos.close();

            etNumero.setText("");
            etNombre.setText("");
            etCantidad.setText("");
            Toast.makeText(this,"Registro Exitoso",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Debes de ingresar todo los datos", Toast.LENGTH_SHORT).show();
        }
    }

    //Metodo para consultar participante
    public void Buscar(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String numero = etNumero.getText().toString();

        if(!numero.isEmpty()){
            Cursor fila = BaseDeDatos.rawQuery("select nombre, cantidad from participantes where idp = "+numero,null);
            if(fila.moveToFirst()){
                etNombre.setText(fila.getString(0));
                etCantidad.setText(fila.getString(1));
            }else{
                Toast.makeText(this,"El participante no esta registrado", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this,"El participante no esta registrado", Toast.LENGTH_SHORT).show();
        }
    }

    //Metodo para eliminar
    public void Eliminar (View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String numero = etNumero.getText().toString();

        if(!numero.isEmpty()){
            int numeroRegistro = BaseDeDatos.delete("participantes", "idp ="+numero,null);
            BaseDeDatos.close();
            etNumero.setText("");
            etNombre.setText("");
            etCantidad.setText("");
            if(numeroRegistro == 1){
                Toast.makeText(this,"Participante borrado", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"El participante no esta registrado", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this,"El participante no esta registrado", Toast.LENGTH_SHORT).show();
        }
    }

    //metodo para editar un registro
    public void Modificar (View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String numero = etNumero.getText().toString();
        String nombre = etNombre.getText().toString();
        String cantidad = etCantidad.getText().toString();

        if(!numero.isEmpty() || !nombre.isEmpty() || !cantidad.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("idp",numero);
            registro.put("nombre",nombre);
            registro.put("cantidad",cantidad);

            int numeroRegistro = BaseDeDatos.update( "participantes",registro, "idp ="+numero,null);

            BaseDeDatos.close();

            if(numeroRegistro == 1){
                Toast.makeText(this,"Participante modificado", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"El participante no esta registrado", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this,"Debes de poner todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
}