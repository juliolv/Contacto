package com.juliolv.contacto;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvFechaNacimiento;
    private TextView tvTelefono;
    private TextView tvEmail;
    private  TextView tvDescripcion;

    static final int CONTACT_REQUEST = 1;  // The request code

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);
        setTitle(getResources().getString(R.string.titulo_confirmar_datos));

        Bundle parametros = getIntent().getExtras();

        String nombre = parametros.getString(getResources().getString(R.string.nombre_editar_contacto));
        String fechaNacimiento = parametros.getString(getResources().getString(R.string.fecha_nacimiento_editar_contacto));
        String telefono = parametros.getString(getResources().getString(R.string.telefono_editar_contacto));
        String email = parametros.getString(getResources().getString(R.string.email_editar_contacto));
        String descripcion = parametros.getString(getResources().getString(R.string.descripcion_editar_contacto));

        tvNombre = (TextView) findViewById(R.id.tvNombreConfirmar);
        tvFechaNacimiento = (TextView) findViewById(R.id.tvFechaNacimientoConfirmar);
        tvTelefono = (TextView) findViewById(R.id.tvTelefonoConfirmar);
        tvEmail = (TextView) findViewById(R.id.tvEmailConfirmar);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcionContactoConfirmar);

        tvNombre.setText(nombre);
        tvFechaNacimiento.setText(fechaNacimiento);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);

        Button btnEditarDatos = (Button) findViewById(R.id.btnEditarDatos);
        btnEditarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView tvNombre = (TextView) findViewById(R.id.tvNombreConfirmar);
                TextView tvFechaNacimiento = (TextView) findViewById(R.id.tvFechaNacimientoConfirmar);
                TextView tvTelefono = (TextView) findViewById(R.id.tvTelefonoConfirmar);
                TextView tvEmail = (TextView) findViewById(R.id.tvEmailConfirmar);
                TextView tvDescripcion = (TextView) findViewById(R.id.tvDescripcionContactoConfirmar);

                Intent intent = new Intent(ConfirmarDatos.this, MainActivity.class);
                intent.putExtra(getResources().getString(R.string.nombre_editar_contacto), tvNombre.getText().toString());
                intent.putExtra(getResources().getString(R.string.fecha_nacimiento_editar_contacto), tvFechaNacimiento.getText().toString());
                intent.putExtra(getResources().getString(R.string.telefono_editar_contacto), tvTelefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.email_editar_contacto), tvEmail.getText().toString());
                intent.putExtra(getResources().getString(R.string.descripcion_editar_contacto), tvDescripcion.getText().toString());
                startActivity(intent);
                finish();

                /*Intent intent = new Intent(ConfirmarDatos.this, MainActivity.class);
                intent.putExtra(getResources().getString(R.string.nombre_editar_contacto), tvNombre.getText().toString());
                setResult(ConfirmarDatos.RESULT_OK, intent);
                finish();*/


            }
        });


    }

    @Override
    public  boolean onKeyDown(int keyCode, KeyEvent event){

        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(ConfirmarDatos.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}
