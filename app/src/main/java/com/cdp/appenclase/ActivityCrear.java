package com.cdp.appenclase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cdp.appenclase.Procesos.SQLiteConexion;
import com.cdp.appenclase.Procesos.Transacciones;

public class ActivityCrear extends AppCompatActivity {

    Button btnagregar;
    EditText txtnombreAC, txtapellidoAC, txtedadAC, txtcorreoAC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);

        init();

        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AgregarEmpleado(); //Selecciona la segunda opcion para que cree una clase privada

            }
        });

    }

    private void  init()
    {
        btnagregar = (Button) findViewById(R.id.btnagregar);
        txtnombreAC = (EditText) findViewById(R.id.txtnombreAC);
        txtapellidoAC = (EditText) findViewById(R.id.txtapellidoAC);
        txtedadAC = (EditText) findViewById(R.id.txtedadAC);
        txtcorreoAC = (EditText) findViewById(R.id.txtcorreoAC);

    }

    private void AgregarEmpleado()
    {
        // Toda la conexion o insercion a la base de datos
        SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.NameDataBase, null, 1);
        //conexion hacia la base de datos (modo escritura)
        SQLiteDatabase db = conexion.getWritableDatabase();

        //Contenedor de informacion donde nosotros podamos pasar una estructura similar al Bundle
        ContentValues valores = new ContentValues();
        valores.put(Transacciones.nombre, txtnombreAC.getText().toString());
        valores.put(Transacciones.apellido, txtapellidoAC.getText().toString());
        valores.put(Transacciones.edad, txtedadAC.getText().toString());
        valores.put(Transacciones.correo, txtcorreoAC.getText().toString());

        Long resultado = db.insert(Transacciones.tablaEmpleados, Transacciones.id, valores);

        // Mensaje a traves de Toast para confirmar el resultado.
        Toast.makeText(getApplicationContext(), "Registro Ingresado", Toast.LENGTH_LONG).show();

        //Cerrar la conexion a nuestra base de datos.
        db.close();

        //Limpiar la pantalla
        ClearScreen();

    }

    private void ClearScreen()
    {
        txtnombreAC.setText("");
        txtapellidoAC.setText("");
        txtedadAC.setText("");
        txtcorreoAC.setText("");
    }
}