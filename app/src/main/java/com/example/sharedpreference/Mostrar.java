package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Mostrar extends AppCompatActivity {
    TextView tvnombre,tvApellidoP,tvApellidoM,tvEdad,tvUsuario,tvEmail,tvPassword;
    Button btnRegresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        tvnombre=(TextView)findViewById(R.id.tvNombre);
        tvApellidoP=(TextView) findViewById(R.id.tvapellidoP);
        tvApellidoM=(TextView)findViewById(R.id.tvApellidoM);
        tvEdad=(TextView)findViewById(R.id.tvEdad);
        tvUsuario=(TextView)findViewById(R.id.tvUsuario);
        tvEmail=(TextView)findViewById(R.id.tvEmail);
        tvPassword=(TextView)findViewById(R.id.tvPassword);


        mostrar();
    }

    private void mostrar()
    {
        SharedPreferences preferences= getSharedPreferences("datos", Context.MODE_PRIVATE);

        String nombre=preferences.getString("nombre","");
        String aPaterno=preferences.getString("aPaterno","");
        String aMaterno=preferences.getString("aMaterno","");
        String edad=preferences.getString("edad","");
        String usuario=preferences.getString("usuario","");
        String email=preferences.getString("email","");
        String password=preferences.getString("password","");

        tvnombre.setText(nombre);
        tvApellidoP.setText(aPaterno);
        tvApellidoM.setText(aMaterno);
        tvEdad.setText(edad);
        tvEmail.setText(email);
        tvUsuario.setText(usuario);
        tvPassword.setText(password);
    }
}