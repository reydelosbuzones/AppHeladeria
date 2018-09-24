package com.appandroid.nahuelmarchelli.appheladeria.data;

import java.util.UUID;

/**
 * Entiedad Recipiente
 */

public class Recipiente {
    private String id;
    private String nombre;
    private int precio;

    public Recipiente(String name, int price) {
        this.id = UUID.randomUUID().toString();
        this.nombre = name;
        this.precio = price;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }
}
