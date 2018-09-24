package com.appandroid.nahuelmarchelli.appheladeria;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.appandroid.nahuelmarchelli.appheladeria.data.Cliente;
import com.appandroid.nahuelmarchelli.appheladeria.database.HeladeriaDbHelper;

public class ListClienteActivity extends AppCompatActivity {

    ListView listViewClientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_cliente);

        listViewClientes = findViewById(R.id.listClientes);
        HeladeriaDbHelper dbHelper = new HeladeriaDbHelper(getApplicationContext());
        Cursor cursor = dbHelper.listClientes();

        if (cursor.moveToNext()) {
            ClienteCursorAdapter cursorAdapter = new ClienteCursorAdapter(getApplicationContext(), cursor);
            listViewClientes.setAdapter(cursorAdapter);
        } else {
            Toast.makeText(getApplicationContext(), "No hay datos", Toast.LENGTH_SHORT).show();
        }

        listViewClientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                // TODO - ver como verga pasar de Object a Cliente.
                //Cliente cliente = (Cliente) listViewClientes.getItemAtPosition(pos);
                Intent intent = new Intent(ListClienteActivity.this, DetailsClienteActivity.class);
                startActivity(intent);
            }
        });

        /*
        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                dbHelper.listViewClientes(),
                new String[]{"name"},
                new int[]{android.R.id.text1});
        listViewClientes.setAdapter(cursorAdapter);
        */
    }
}
