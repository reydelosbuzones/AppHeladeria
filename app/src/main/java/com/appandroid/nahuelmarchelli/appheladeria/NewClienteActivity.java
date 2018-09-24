package com.appandroid.nahuelmarchelli.appheladeria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.appandroid.nahuelmarchelli.appheladeria.data.Cliente;
import com.appandroid.nahuelmarchelli.appheladeria.database.HeladeriaDbHelper;

public class NewClienteActivity extends AppCompatActivity {

    Button btnCancelar, btnConfirmar;
    EditText sNombre, sDireccion, sTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_cliente);

        sNombre = findViewById(R.id.etNombreCli);
        sDireccion = findViewById(R.id.etDireccionCli);
        sTelefono = findViewById(R.id.etTelefonoCli);

        btnCancelar = findViewById(R.id.btnCancelar);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnConfirmar = findViewById(R.id.btnConfirmaCliente);
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkData()) {
                    // guardo la data
                    Cliente cliente = new Cliente(
                            sNombre.getText().toString(),
                            sDireccion.getText().toString(),
                            sTelefono.getText().toString());

                    HeladeriaDbHelper db = new HeladeriaDbHelper(getApplicationContext());
                    if (db.saveCliente(cliente) == -1) {
                        String msj = "Datos guardados.";
                        Toast.makeText(getApplicationContext(), msj, Toast.LENGTH_SHORT).show();
                    } else {
                        String msj = "Hubo un error al guardar los datos.";
                        Toast.makeText(getApplicationContext(), msj, Toast.LENGTH_SHORT).show();
                    }
                    clearAll();
                    finish();
                }
            }
        });
    }

    private boolean isEmpty(EditText editText) {
        return editText.getText().toString().isEmpty();
    }

    void clearAll() {
        sNombre.setText("");
        sDireccion.setText("");
        sTelefono.setText("");
    }

    Boolean checkData() {
        String msj;

        if (isEmpty(sNombre)) {
            msj = "Debes completar el nombre del cliente";
            sNombre.requestFocus();
            Toast.makeText(getApplicationContext(), msj, Toast.LENGTH_SHORT).show();
            return false;
        } else if (isEmpty(sDireccion)) {
            msj = "La dirección es obligatoria";
            sDireccion.requestFocus();
            Toast.makeText(getApplicationContext(), msj, Toast.LENGTH_SHORT).show();
            return false;
        } else if (isEmpty(sTelefono)) {
            msj = "Debes ingresar el teléfono del cliente";
            sTelefono.requestFocus();
            Toast.makeText(getApplicationContext(), msj, Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
}
