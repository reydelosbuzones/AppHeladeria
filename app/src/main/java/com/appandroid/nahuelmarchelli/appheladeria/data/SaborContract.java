package com.appandroid.nahuelmarchelli.appheladeria.data;

import android.provider.BaseColumns;

/**
 *  Esquema de la DB para sabores
 */

public class SaborContract {
    public static abstract class SaborEntry implements BaseColumns{
        public static final String TABLE_NAME = "sabores";

        public static final String ID="id";
        public static final String NAME="name";
    }
}
