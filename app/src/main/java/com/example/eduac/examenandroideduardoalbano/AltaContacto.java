package com.example.eduac.examenandroideduardoalbano;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AltaContacto extends AppCompatActivity implements View.OnClickListener {
    private Contacto contacto;
    private AlertDialog ventana;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_contacto);
        Button btnAceptar = (Button) findViewById(R.id.btnAlta);
        if (getIntent().hasExtra("alta")) {
            btnAceptar.setText("añadir");
        }else
        {
            btnAceptar.setText("borrar");
        }
        btnAceptar.setOnClickListener(this);
        Button btnCancelar = (Button) findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAlta:
                crearContacto(view);
                if (contacto != null) {
                    Intent intent = new Intent();
                    intent.putExtra("contacto", contacto);
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }

                break;
            case R.id.btnCancelar:
                if (ventana == null) {
                    ventana = mostrarDialogo();
                }
                ventana.show();
                break;
        }
    }

    public void crearContacto(View view) {

        EditText edtNombre = (EditText) findViewById(R.id.nombre);
        EditText edtEmail = (EditText) findViewById(R.id.email);
        EditText edtEdad = (EditText) findViewById(R.id.edad);
        String nombre = edtNombre.getText().toString();
        String email = edtEmail.getText().toString();
        Integer edad = Integer.parseInt(edtEdad.getText().toString());
        contacto = new Contacto(nombre, email, edad);

    }

    public AlertDialog mostrarDialogo() {

        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setMessage("¿Quieres salir?");
        alerta.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int id) {
                AltaContacto.this.finish();
            }
        });
        alerta.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int id) {

            }
        });
        return alerta.create();
    }
}