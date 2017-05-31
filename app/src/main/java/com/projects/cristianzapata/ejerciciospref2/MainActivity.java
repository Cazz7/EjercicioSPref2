package com.projects.cristianzapata.ejerciciospref2;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText1, editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1=(EditText)findViewById(R.id.nombre);
        editText2=(EditText)findViewById(R.id.datos);
    }

    public void grabar (View v){
        String nombre=editText1.getText().toString();
        String datos=editText2.getText().toString();

        SharedPreferences pref=getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        editor.putString(nombre,datos);
        editor.commit();

        Toast.makeText(this,"Grabado con éxito",Toast.LENGTH_LONG).show();
    }

    public void recuperar (View v){
        String nombre=editText1.getText().toString();
        SharedPreferences prefe=getSharedPreferences("agenda",Context.MODE_PRIVATE);
        String d=prefe.getString(nombre,"");
        if(d.length()==0){
            Toast.makeText(this,"No existe dicho nombre en la agenda", Toast.LENGTH_LONG).show();
        }
        else{
            editText2.setText(d);
        }
    }
}
