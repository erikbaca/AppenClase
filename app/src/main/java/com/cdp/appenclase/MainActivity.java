package com.cdp.appenclase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtnombre, txtapellido;
    Button btnmostrar, btnsecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtnombre = (EditText) findViewById(R.id.txtnombre);
        txtapellido = (EditText) findViewById(R.id.txtapellido);
        btnmostrar = (Button) findViewById(R.id.btnmostrar);
        btnsecond = (Button) findViewById(R.id.btnsecond);

        btnmostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Nombre " + txtnombre.getText().toString(), Toast.LENGTH_LONG).show();

            }
        });

        btnsecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                intent.putExtra("Nombre ", txtnombre.getText().toString());
                intent.putExtra("Apellido ", txtapellido.getText().toString());
                startActivity(intent);
            }
        });
    }
}