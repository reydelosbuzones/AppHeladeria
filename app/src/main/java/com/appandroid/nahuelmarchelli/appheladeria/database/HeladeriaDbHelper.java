package com.appandroid.nahuelmarchelli.appheladeria.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.appandroid.nahuelmarchelli.appheladeria.data.Cliente;
import com.appandroid.nahuelmarchelli.appheladeria.data.Usuario;
import com.appandroid.nahuelmarchelli.appheladeria.data.UsuarioContract.UsuarioEntry;
import com.appandroid.nahuelmarchelli.appheladeria.data.ClienteContract.ClienteEntry;
import com.appandroid.nahuelmarchelli.appheladeria.data.SaborContract.SaborEntry;
import com.appandroid.nahuelmarchelli.appheladeria.data.RecipienteContract.RecipienteEntry;

import static android.content.Context.MODE_PRIVATE;

public class HeladeriaDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Heladeria.db";

    Context context;

    private String sqlUsuariosTable = "CREATE TABLE " +
            UsuarioEntry.TABLE_NAME + "(" +
            UsuarioEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            UsuarioEntry.ID + " TEXT NOT NULL, " +
            UsuarioEntry.USERNAME + " TEXT NOT NULL, " +
            UsuarioEntry.MAIL + " TEXT NOT NULL, " +
            UsuarioEntry.PASSWORD + " TEXT NOT NULL" + ");";

    private String sqlClientesTable = "CREATE TABLE " +
            ClienteEntry.TABLE_NAME + "(" +
            ClienteEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            ClienteEntry.ID + " TEXT NOT NULL, " +
            ClienteEntry.NAME + " TEXT NOT NULL, " +
            ClienteEntry.ADDRESS + " TEXT NOT NULL, " +
            ClienteEntry.TELEPHONE + " TEXT NOT NULL " + ");";

    private String sqlSaboresTable = "CREATE TABLE " +
            SaborEntry.TABLE_NAME + " (" +
            SaborEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            SaborEntry.ID + " TEXT NOT NULL, " +
            SaborEntry.NAME + " TEXT NOT NULL " + ");";

    private String sqlRecipientesTable = "CREATE TABLE " +
            RecipienteEntry.TABLE_NAME + " (" +
            RecipienteEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            RecipienteEntry.ID + " TEXT NOT NULL, " +
            RecipienteEntry.NAME + " TEXT NOT NULL, " +
            RecipienteEntry.PRICE + " INT NOT NULL " + ");";

    public HeladeriaDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // la data se guarda en /data/data/<paquete>/databases/Heladeria.db


        db.execSQL(sqlUsuariosTable);
        db.execSQL(sqlClientesTable);
        db.execSQL(sqlSaboresTable);
        db.execSQL(sqlRecipientesTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // No hay operaciones
        db.execSQL("DROP TABLE IF EXISTS " + UsuarioEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ClienteEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + SaborEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + RecipienteEntry.TABLE_NAME);

        onCreate(db);
    }

    public long saveUsuario(Usuario usuario) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(UsuarioEntry.USERNAME, usuario.getUsername());
        values.put(UsuarioEntry.MAIL, usuario.getMail());
        values.put(UsuarioEntry.PASSWORD, usuario.getPassword());

        long id = db.insert(UsuarioEntry.TABLE_NAME, null, values);
        db.close();
        return id;
    }

    public Cursor getClienteByTel(String tel) {
        SQLiteDatabase db = getReadableDatabase();
        String selectQuery = "SELECT * FROM " + ClienteEntry.TABLE_NAME +
                " WHERE " + ClienteEntry.TELEPHONE + " = '" + tel + "'";
        return db.rawQuery(selectQuery, null);
    }

    public long saveCliente(Cliente cliente) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(ClienteEntry.NAME, cliente.getNombre());
        values.put(ClienteEntry.ADDRESS, cliente.getDireccion());
        values.put(ClienteEntry.TELEPHONE, cliente.getTelefono());

        long id = db.insert(ClienteEntry.TABLE_NAME, null, values);
        db.close();
        return id;
    }

    public Cursor listClientes() {
        SQLiteDatabase db = getReadableDatabase();
        String selectQuery = "SELECT * FROM " + ClienteEntry.TABLE_NAME;
        return db.rawQuery(selectQuery, null);
    }
}
