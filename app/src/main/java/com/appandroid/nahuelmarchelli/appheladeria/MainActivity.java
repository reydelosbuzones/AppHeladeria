package com.appandroid.nahuelmarchelli.appheladeria;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnIngresar, btnRegistrar;
    EditText sUser, sPassword;
    ImageView imgLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SQLiteDatabase HeladeriaDB = openOrCreateDatabase("HeladeriaDB",MODE_PRIVATE,null);

        final String sUsuario = "nawe";
        final String sContraseña = "1234";

        sUser = findViewById(R.id.txtUsername);
        sPassword = findViewById(R.id.txtPassword);

        btnIngresar = findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msj;
                if (!isEmpty(sUser)) {
                    if (sUser.getText().toString().equals(sUsuario)) {
                        if (sPassword.getText().toString().equals(sContraseña)) {
                            Intent intent = new Intent(MainActivity.this, StartActivity.class);
                            startActivity(intent);
                            sPassword.setText("");
                        } else {
                            msj = "Contraseña incorrecta";
                            Toast.makeText(getApplicationContext(), msj, Toast.LENGTH_SHORT).show();
                            sPassword.setText("");
                        }
                    } else {
                        msj = "Usuario incorrecto";
                        Toast.makeText(getApplicationContext(), msj, Toast.LENGTH_SHORT).show();
                        sUser.setText("");
                        sPassword.setText("");
                    }
                } else {
                    msj = "Ingresa usuario para loguear";
                    Toast.makeText(getApplicationContext(), msj, Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegistrar=findViewById(R.id.btnRegistrar);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterUsuarioActivity.class);
                startActivity(intent);
            }
        });

        imgLogo = findViewById(R.id.logo);
        imgLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msj = "Usuario: " + sUsuario + " - Contraseña: " + sContraseña;
                Toast.makeText(getApplicationContext(), msj, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean isEmpty(EditText editText) {
        return editText.getText().toString().isEmpty();
    }
}
