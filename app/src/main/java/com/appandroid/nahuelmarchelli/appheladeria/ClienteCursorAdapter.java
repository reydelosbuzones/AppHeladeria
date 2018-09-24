package com.appandroid.nahuelmarchelli.appheladeria;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ClienteCursorAdapter extends CursorAdapter {
    public ClienteCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.row, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvName = view.findViewById(R.id.itemCliente);
        TextView tvTel = view.findViewById(R.id.telCliente);

        String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
        String tel = cursor.getString(cursor.getColumnIndexOrThrow("telephone"));

        tvName.setText(name);
        tvTel.setText(tel);
    }
}
