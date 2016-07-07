package gobowl.seclass.gatech.edu.gobowl.System;

import android.database.Cursor;
import 	android.database.sqlite.*;
import android.support.annotation.Nullable;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by charles on 7/6/16.
 */
public class Persistence {
    private static Persistence ourInstance = new Persistence();

    public static Persistence getInstance() {
        return ourInstance;
    }

    private String dbname = null;

    private SQLiteDatabase db = null;

    //  If we have changed the database schema in some fashion, this is used
    //  to flag the change so we know to drop the tables and recreate them
    private static final int DATABASE_VERSION = 1;


    @Nullable
    private SQLiteDatabase createDB(File dbfile) {

        try {
            //  This is required to ensure that the directories leading down to our database
            //  actually exist before we create it...
            dbfile.getParentFile().mkdirs();
            dbfile.delete();

            db = SQLiteDatabase.openOrCreateDatabase(dbname, null);

            //  Create the version number ...
            db.execSQL("create table schemaversion (version)");
            db.execSQL(String.format("insert into schemaversion values(%d)", DATABASE_VERSION));

            //  Create the customer table with the same data as in the stub library provided...
            db.execSQL("create table customers (id PRIMARY KEY, first, last, email, vip, ytd)");
            db.execSQL("insert into customers values('86ff', 'Ralph', 'Hapschatt', 'Hapschatt@email.fake', 'true', '100.00')");
            db.execSQL("insert into customers values('9441', 'Betty', 'Monroe', 'Monroe@email.fake', 'false', '10.00')");
            db.execSQL("insert into customers values('0f0e', 'Everett', 'Scott', 'Scott@email.fake', 'true', '200.00')");

            //  Create the lane data
            db.execSQL("create table lanes (id, lanestatus)");
            db.execSQL("insert into lanes values('1', '0')");


            return db;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }

    private Persistence() {
    }

    public void initDB(File dbFile) {
        dbname = dbFile.getAbsolutePath();
        boolean needToCreateDB = false;
        try {
            db = SQLiteDatabase.openDatabase(dbname,  null, SQLiteDatabase.OPEN_READWRITE);
            Cursor c;
            c = db.rawQuery("SELECT count(*) FROM sqlite_master WHERE type='table' AND name='schemaversion'", null);
            c.moveToFirst();
            if (c.getInt(0) == 0) {
                needToCreateDB = true;
                c.close();
            } else {
                c.close();
                c = db.rawQuery("SELECT version FROM schemaversion", null);
                c.moveToFirst();
                if (c.getInt(0) != DATABASE_VERSION) {
                    needToCreateDB = true;
                }
                c.close();
            }
        } catch (SQLiteException e) {
            // No Database ....
            needToCreateDB = true;
        }

        if (needToCreateDB) {
            db = createDB(dbFile);
        }
    }

    public HashMap<String, String> getRecordbySQL(String sql) {
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor.getCount() == 0) {
            return null;    // Did not find!
        }

        cursor.moveToFirst();

        HashMap<String, String> columns = new HashMap<>();

        for (int i=0;i<cursor.getColumnCount();i++) {
            columns.put(cursor.getColumnName(i), cursor.getString(i));
        }

        cursor.close();

        return columns;
    }

    public HashMap<String, String> getRecordById(String table, String id) {
        String sql = String.format("SELECT * FROM %s WHERE %s='%s'", table, "id", id);
        return getRecordbySQL(sql);
    }

    public HashMap<String, String> getRecordByColumn(String table, String colname, String colval) {
        String sql = String.format("SELECT * FROM %s WHERE %s='%s'", table, colname, colval);
        return getRecordbySQL(sql);
    }



    /*
        Retrieve all id values for a table...
     */
    public ArrayList<String> allIds(String table) {
        Cursor cursor = db.query(false, table, null, null, null, null, null, null, null);
        if (cursor.getCount() == 0) {
            return null;    // Did not find!
        }

        cursor.moveToFirst();

        ArrayList<String> ids = new ArrayList<>();

        while (!cursor.isAfterLast()) {
            ids.add(cursor.getString(cursor.getColumnIndex("id")));
            cursor.moveToNext();
        }

        cursor.close();

        return ids;
    }

    public void doInsertorUpdate(String sql) {
        db.execSQL(sql);
    }

}
