package com.appandroid.nahuelmarchelli.appheladeria.data;

import java.util.UUID;

/**
 * Created by nahuel.marchelli on 9/17/2018.
 */

public class Sabor {
    private String id;
    private String nombre;

    public Sabor(String name) {
        this.id = UUID.randomUUID().toString();
        this.nombre = name;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
