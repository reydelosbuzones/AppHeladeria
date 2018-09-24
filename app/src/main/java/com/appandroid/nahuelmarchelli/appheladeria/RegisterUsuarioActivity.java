package com.appandroid.nahuelmarchelli.appheladeria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.appandroid.nahuelmarchelli.appheladeria.data.Usuario;
import com.appandroid.nahuelmarchelli.appheladeria.database.HeladeriaDbHelper;

import java.util.ArrayList;
import java.util.List;

public class RegisterUsuarioActivity extends AppCompatActivity {

    Button btnRegistrar, btnCancelar;
    EditText sNombreUsuario, sMailUsuario, sPassword, sPassword2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_usuario);

        sNombreUsuario = findViewById(R.id.etNewNombreUser);
        sMailUsuario = findViewById(R.id.etNewUserMail);
        sPassword = findViewById(R.id.etNewUserPassword);
        sPassword2 = findViewById(R.id.etNewUserPassword2);

        btnCancelar = findViewById(R.id.btnCancelaNewUsuario);
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                clearAll();
            }
        });

        btnRegistrar = findViewById(R.id.btnConfirmaNewUsuario);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkDataEntered()) {
                    //GUARDAR DATA
                    String msj;
                    Usuario usuario = new Usuario(
                            sNombreUsuario.getText().toString(),
                            sMailUsuario.getText().toString(),
                            sPassword.getText().toString());

                    HeladeriaDbHelper db = new HeladeriaDbHelper(getApplicationContext());
                    long insert = db.saveUsuario(usuario);
                    if (insert != -1) {
                        msj = "Usuario registrado con éxito";
                        Toast.makeText(getApplicationContext(), msj, Toast.LENGTH_SHORT).show();
                    } else {
                        msj = "Hubo un error al guardar";
                        Toast.makeText(getApplicationContext(), msj, Toast.LENGTH_SHORT).show();
                    }
                    clearAll();
                    finish();
                }
            }
        });
    }

    void clearAll() {
        sNombreUsuario.setText("");
        sMailUsuario.setText("");
        sPassword.setText("");
        sPassword2.setText("");
    }

    Boolean isEmail(EditText editText) {
        CharSequence email = editText.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    Boolean isEmpty(EditText editText) {
        CharSequence str = editText.getText().toString();
        return TextUtils.isEmpty(str);
    }

    Boolean checkDataEntered() {
        /*
        List<EditText> list = new ArrayList<>();
        list.add(sNombreUsuario);
        list.add(sMailUsuario);
        list.add(sPassword);
        list.add(sPassword2);
        */
        String p1 = sPassword.getText().toString();
        String p2 = sPassword2.getText().toString();
        String msj;

        if (isEmpty(sNombreUsuario)) {
            msj = "Debes ingresar el nombre de usuario";
            sNombreUsuario.requestFocus();
            Toast.makeText(getApplicationContext(), msj, Toast.LENGTH_SHORT).show();
            return false;
        } else if (isEmpty(sMailUsuario)) {
            msj = "Debes ingresar el mail";
            sMailUsuario.requestFocus();
            Toast.makeText(getApplicationContext(), msj, Toast.LENGTH_SHORT).show();
            return false;
        } else if (isEmail(sMailUsuario)) {
            msj = "El mail ingresado no es válido";
            sMailUsuario.requestFocus();
            Toast.makeText(getApplicationContext(), msj, Toast.LENGTH_SHORT).show();
            return false;
        } else if (isEmpty(sPassword)) {
            msj = "Debes ingresar la contraseña";
            sPassword.requestFocus();
            Toast.makeText(getApplicationContext(), msj, Toast.LENGTH_SHORT).show();
            sPassword2.setText("");
            return false;
        } else if (!p1.equals(p2)) {
            msj = "Las contraseñas no coinciden";
            sPassword.requestFocus();
            Toast.makeText(getApplicationContext(), msj, Toast.LENGTH_SHORT).show();
            sPassword2.setText("");
            return false;
        } else {
            return true;
        }
    }
}
