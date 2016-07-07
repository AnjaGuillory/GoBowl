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


    @Nullable
    private SQLiteDatabase createDB(File dbfile) {

        try {
            //  This is required to ensure that the directories leading down to our database
            //  actually exist before we create it...
            dbfile.getParentFile().mkdirs();

            db = SQLiteDatabase.openOrCreateDatabase(dbname, null);
            db.execSQL("create table customers (id PRIMARY KEY, first, last, email, vip, ytd)");
            db.execSQL("insert into customers values('86ff', 'Ralph', 'Hapschatt', 'Hapschatt@email.fake', 'true', '100.00')");
            db.execSQL("insert into customers values('9441', 'Betty', 'Monroe', 'Monroe@email.fake', 'false', '10.00')");
            db.execSQL("insert into customers values('0f0e', 'Everett', 'Scott', 'Scott@email.fake', 'true', '200.00')");

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
        try {
            db = SQLiteDatabase.openDatabase(dbname,  null, SQLiteDatabase.OPEN_READWRITE);
        } catch (SQLiteException e) {
            // No Database ....
            db = createDB(dbFile);
        }
    }

    public HashMap<String, String> getRecord(String table, String id) {
        String [] args = { id };
        Cursor cursor = db.query(false, table, null, "id = ?",args, null, null, null, null);
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
