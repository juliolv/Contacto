package com.juliolv.contacto;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextInputEditText tilNombre = (TextInputEditText) findViewById(R.id.nombreContacto);
                DatePicker dpFechaNacimiento = (DatePicker) findViewById(R.id.fechaNacimiento);
                TextInputEditText tilTelefono = (TextInputEditText) findViewById(R.id.telefonoContacto);
                TextInputEditText tilEmail = (TextInputEditText) findViewById(R.id.emailContacto);
                TextInputEditText tilDescripcion = (TextInputEditText) findViewById(R.id.descripcionContacto);

                String fechaNacimiento = dpFechaNacimiento.getDayOfMonth() + "/" + dpFechaNacimiento.getMonth() + "/" + dpFechaNacimiento.getYear();

                Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class);
                intent.putExtra(getResources().getString(R.string.nombre_editar_contacto), tilNombre.getText().toString());
                intent.putExtra(getResources().getString(R.string.fecha_nacimiento_editar_contacto), fechaNacimiento);
                intent.putExtra(getResources().getString(R.string.telefono_editar_contacto), tilTelefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.email_editar_contacto), tilEmail.getText().toString());
                intent.putExtra(getResources().getString(R.string.descripcion_editar_contacto), tilDescripcion.getText().toString());
                //startActivity(intent);
                startActivityForResult(intent, 1);
                finish();

            }
        });
    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == ConfirmarDatos.RESULT_OK){

                Bundle parametros = getIntent().getExtras();
                String nombre = parametros.getString(getResources().getString(R.string.nombre_editar_contacto));

                TextInputEditText tilNombre = (TextInputEditText) findViewById(R.id.nombreContacto);

                tilNombre.setText(nombre, TextView.BufferType.EDITABLE);

            }
            if (resultCode == ConfirmarDatos.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }//onActivityResult*/
}
