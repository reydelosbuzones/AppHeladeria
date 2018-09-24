package com.appandroid.nahuelmarchelli.appheladeria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    Button btnNuevoCliente, btnNuevoSabor, btnNuevoRecipiente, btnVolver;
    Button btnListCliente, btnListSabor, btnListRecipiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        btnNuevoCliente = findViewById(R.id.btnNuevoCliente);
        btnNuevoCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, NewClienteActivity.class);
                startActivity(intent);
            }
        });

        btnListCliente = findViewById(R.id.btnListCliente);
        btnListCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, ListClienteActivity.class);
                startActivity(intent);
            }
        });

        btnNuevoSabor = findViewById(R.id.btnNuevoSabor);
        btnNuevoSabor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, NewSaborActivity.class);
                startActivity(intent);
            }
        });


        btnNuevoRecipiente = findViewById(R.id.btnNuevoRecipiente);
        btnNuevoRecipiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, NewRecipienteActivity.class);
                startActivity(intent);
            }
        });

        btnVolver = findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
