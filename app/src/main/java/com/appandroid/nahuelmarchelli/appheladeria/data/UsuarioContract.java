package com.appandroid.nahuelmarchelli.appheladeria.data;

import android.provider.BaseColumns;

/**
 * Esquema de la DB para usuarios
 */

public class UsuarioContract {
    public static abstract class UsuarioEntry implements BaseColumns {
        public static final String TABLE_NAME = "usuarios";

        public static final String ID = "id";
        public static final String USERNAME = "username";
        public static final String MAIL = "mail";
        public static final String PASSWORD = "password";
    }
}
