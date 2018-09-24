package com.appandroid.nahuelmarchelli.appheladeria.data;

import android.content.ContentValues;
import com.appandroid.nahuelmarchelli.appheladeria.data.UsuarioContract.UsuarioEntry;

import java.util.UUID;

/**
 * Entidad Usuario
 */

public class Usuario {
    private String id;
    private String username;
    private String mail;
    private String password;

    public Usuario(String name, String mail, String password) {
        this.id = UUID.randomUUID().toString();
        this.username = name;
        this.mail = mail;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(UsuarioEntry.ID, id);
        values.put(UsuarioEntry.USERNAME, username);
        values.put(UsuarioEntry.MAIL, mail);
        values.put(UsuarioEntry.PASSWORD, password);
        return values;
    }
}
