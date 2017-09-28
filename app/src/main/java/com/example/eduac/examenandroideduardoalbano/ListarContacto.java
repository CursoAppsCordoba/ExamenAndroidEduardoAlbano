package com.example.eduac.examenandroideduardoalbano;

import android.content.DialogInterface;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;




public class ListarContacto extends AppCompatActivity implements View.OnClickListener{

    ListView listView;
    ArrayAdapter adapter;
    ArrayList<String> list_view;
    private AlertDialog ventana;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_contacto);
        listView=(ListView) findViewById(R.id.list_view);
        final ArrayList<String> list_view = (ArrayList<String>) getIntent().getSerializableExtra("lista");
        adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Log.i("Click", "click en el elemento " + position + " de mi ListView");
                mostrarDialogo();
            }
        });
        Button button4=(Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {

        if (ventana == null) {
            ventana = CreateDialog(v);
        }
        ventana.show();




    }
    private void mostrarDialogo(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿Deseas editar el contacto?")
                .setCancelable(false)
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent=new Intent(ListarContacto.this, modificarContacto.class);

                        startActivityForResult(intent,0);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
    public AlertDialog CreateDialog(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿Quieres ir al menu?");
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ListarContacto.this.finish();
            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        });
        return builder.create();
    }

}