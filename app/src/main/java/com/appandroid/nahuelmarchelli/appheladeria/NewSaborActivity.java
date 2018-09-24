package com.appandroid.nahuelmarchelli.appheladeria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewSaborActivity extends AppCompatActivity {

    Button btnConfirmar, btnCancelar;
    EditText sNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_sabor);

        sNombre = findViewById(R.id.etNombreSabor);

        btnCancelar = findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnConfirmar = findViewById(R.id.btnConfirmaSabor);
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msj;
                if (!isEmpty(NewSaborActivity.this.sNombre)) {
                    // guardar data

                    msj = "Datos guardados.";
                    Toast.makeText(getApplicationContext(), msj, Toast.LENGTH_SHORT).show();
                    NewSaborActivity.this.sNombre.setText("");
                    finish();
                } else {
                    msj = "Completa los campos vacíos.";
                    Toast.makeText(getApplicationContext(), msj, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private boolean isEmpty(EditText editText) {
        return editText.getText().toString().isEmpty();
    }
}
