package com.cdp.appenclase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cdp.appenclase.Procesos.Empleados;
import com.cdp.appenclase.Procesos.SQLiteConexion;
import com.cdp.appenclase.Procesos.Transacciones;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ActivityList extends AppCompatActivity {

    SQLiteConexion conexion;
    ListView listemple;
    ArrayList<Empleados> listaempleados;
    ArrayList<String> ArregloEmpleados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listemple = (ListView) findViewById(R.id.listviewEmple);
        conexion = new SQLiteConexion(this, Transacciones.NameDataBase, null, 1);
        ObtenerListaEmpleados();

        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1,ArregloEmpleados);

        listemple.setAdapter(adp);

        listemple.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                String Info = "ID : " + listaempleados.get(i).getId() + "\n"
                        + listaempleados.get(i).getNombre();

                Snackbar.make(view, Info, Snackbar.LENGTH_LONG).show();

                // intent para mandar un texto plano
                Intent intentShare = new Intent();
                intentShare.setAction(Intent.ACTION_SEND);
                intentShare.putExtra(Intent.EXTRA_TEXT, Info);
                intentShare.setType("text/plain");

                // Intent para que nos muestre por que medio podemos compartir el texto
                Intent Share = Intent.createChooser(intentShare, null);
                startActivity(Share);


            }
        });
    }

    private void ObtenerListaEmpleados()
    {
        SQLiteDatabase db = conexion.getReadableDatabase();
        Empleados empleado = null;
        listaempleados = new ArrayList<Empleados>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + Transacciones.tablaEmpleados, null);

        while (cursor.moveToNext())
        {
            empleado = new Empleados();
            empleado.setId(cursor.getInt(0));
            empleado.setNombre(cursor.getString(1));
            empleado.setApellido(cursor.getString(2));
            empleado.setEdad(cursor.getInt(3));
            empleado.setCorreo(cursor.getString(4));
            listaempleados.add(empleado);
        }

        cursor.close();

        fllList();


    }

    private void fllList()
    {
        ArregloEmpleados = new ArrayList<String>();
        for (int i=0; i<listaempleados.size(); i++)
        {
            ArregloEmpleados.add(listaempleados.get(i).getId() + " + "
            + listaempleados.get(i).getNombre() +" + "
            + listaempleados.get(i).getApellido());
        }
    }
}