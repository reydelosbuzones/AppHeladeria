package com.appandroid.nahuelmarchelli.appheladeria.data;

import android.provider.BaseColumns;

/**
 * Esquema de la DB para recipientes
 */

public class RecipienteContract {
    public static abstract class RecipienteEntry implements BaseColumns{
        public static final String TABLE_NAME="recipientes";

        public static final String ID="id";
        public static final String NAME="name";
        public static final String PRICE="price";
    }
}
