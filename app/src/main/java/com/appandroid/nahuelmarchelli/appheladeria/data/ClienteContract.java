package com.appandroid.nahuelmarchelli.appheladeria.data;

import android.provider.BaseColumns;

/**
 * Esquema de la DB para clientes
 */

public class ClienteContract {
    public static abstract class ClienteEntry implements BaseColumns {
        public static final String TABLE_NAME = "clientes";

        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String ADDRESS = "address";
        public static final String TELEPHONE = "telephone";
    }
}
