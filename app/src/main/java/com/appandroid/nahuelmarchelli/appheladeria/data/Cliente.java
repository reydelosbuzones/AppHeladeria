package com.appandroid.nahuelmarchelli.appheladeria.data;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.UUID;

/**
 * Entidad Cliente
 */

public class Cliente {
    private String id;
    private String nombre;
    private String direccion;
    private String telefono;

    public Cliente(String name, String address, String telephone) {
        this.id = UUID.randomUUID().toString();
        this.nombre = name;
        this.direccion = address;
        this.telefono = telephone;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String toJSON() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("id", getId());
            jsonObject.put("name", getNombre());
            jsonObject.put("address", getDireccion());
            jsonObject.put("tel", getTelefono());

            return jsonObject.toString();
        } catch (JSONException ex) {
            ex.printStackTrace();
            return "";
        }
    }
}
