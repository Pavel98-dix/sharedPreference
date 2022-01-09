package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnEnviar, btnMostrar;
    EditText etNombre,etApellidoP,etApellidoM,etEdad,etUsuario,etEmail,etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNombre=(EditText) findViewById(R.id.etNombre);
        etApellidoP=(EditText)findViewById(R.id.etApellidoP);
        etApellidoM=(EditText)findViewById(R.id.etApellidoM);
        etEdad=(EditText)findViewById(R.id.etEdad);
        etUsuario=(EditText)findViewById(R.id.etUsuario);
        etEmail=(EditText)findViewById(R.id.etEmail);
        etPassword=(EditText)findViewById(R.id.etPassword);
        
        btnEnviar=(Button)findViewById(R.id.btnEnviar);
        btnMostrar=(Button)findViewById(R.id.btnMostrar); 

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviar();
            }
        });
        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrar();
            }
        });

    }

    private void mostrar()
    {
        Intent intent= new Intent(this,Mostrar.class);
        startActivity(intent);
    }

    private void enviar()
    {
        SharedPreferences preferences= getSharedPreferences("datos", Context.MODE_PRIVATE);

        String nombre=etNombre.getText().toString();
        String aPaterno=etApellidoP.getText().toString();
        String aMaterno=etApellidoM.getText().toString();
        String edad=etEdad.getText().toString();
        String email=etEmail.getText().toString();
        String usuario=etUsuario.getText().toString();
        String password=etPassword.getText().toString();

        SharedPreferences.Editor obj_editor= preferences.edit();

        obj_editor.putString("nombre",nombre);
        obj_editor.putString("aPaterno",aPaterno);
        obj_editor.putString("aMaterno",aMaterno);
        obj_editor.putString("edad",edad);
        obj_editor.putString("usuario",usuario);
        obj_editor.putString("email",email);
        obj_editor.putString("password",password);

        obj_editor.commit();

        Toast.makeText(getApplicationContext(),"El usuario ha sido registrado exitosamente",Toast.LENGTH_SHORT).show();

    }
}