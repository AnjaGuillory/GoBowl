package edu.gatech.seclass.gobowl.models;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by charles on 7/6/16.
 */
abstract class DatabaseEntity {
    /*
        This implements the logic for a generic database entity that can
        be inherited by other persistent objects
     */

    //  These need to all be filled in before calling super()
    ArrayList<String> listOfColumns;
    String tableName;

    // This is the current instance's data
    HashMap<String, String> instanceData;
    boolean dirty;  // Do we need to write data back out?
    boolean newRecord;  // Is this a brand new record?

    public DatabaseEntity() {
        listOfColumns = null;
        tableName = null;
        instanceData = null;
        dirty = false;
        newRecord = false;
        instanceData = new HashMap<>();
    }

    //  Create this instance by selecting by id
    protected void fetchById(String id) {
        instanceData = Persistence.getInstance().getRecordById(tableName, id);
    }

    //  Create this instance by selecting by id
    protected void fetchByColumn(String colname, String colval) {
        instanceData = Persistence.getInstance().getRecordByColumn(tableName, colname, colval);
    }


    public String getString(String colname) {
        return instanceData.get(colname);
    }
    public void setString(String colname, String value) {
        instanceData.put(colname, value);
        dirty = true;
    }

    public Integer getInteger(String colname) {
        return Integer.valueOf(instanceData.get(colname));
    }
    public void setInteger(String colname, Integer value) {
        instanceData.put(colname, value.toString());
        dirty = true;
    }

    public Double getDouble(String colname) {
        return Double.valueOf(instanceData.get(colname));
    }
    public void setDouble(String colname, Double value) {
        instanceData.put(colname, value.toString());
        dirty = true;
    }

    public Boolean getBoolean(String colname) {
        return Boolean.valueOf(instanceData.get(colname));
    }
    public void setBoolean(String colname, Boolean value) {
        instanceData.put(colname, value.toString());
        dirty = true;
    }

    public String generateId() {
        //  Generate a new, unique id.  Normally we'd allow the database to do this,
        //  But since the libraries have canned data with sparse ids, we cannot

        int iNewId = -1;
        String newId;

        ArrayList<String> currentIds = Persistence.getInstance().allIds(tableName);

        if (currentIds == null) {   // Empty table, start at 0!
            iNewId = 0;
            newId = String.format("%04x", iNewId);
        } else {
            for (; ; ) {
                iNewId++;
                newId = String.format("%04x", iNewId);
                if (!currentIds.contains(newId)) {
                    break;
                }
            }
        }

        instanceData.put("id", newId);
        return newId;

    }

    public void saveRecord() {
        if (! dirty && ! newRecord) {
            return;     // Nothing to do!
        }

        String id = instanceData.get("id");

        //  Do we need to insert this record?
        if (newRecord || id == null || id.length() == 0) {
            generateId();

            String sql = "insert into " + tableName + " values (";
            String comma = "";
            for (String col: listOfColumns) {
                String coldata = instanceData.get(col);
                if (coldata == null) {
                    coldata = "";
                }
                sql += comma + "\"" + coldata + "\"";
                comma = ",";
            }
            sql += ")";

            Persistence.getInstance().doInsertorUpdate(sql);

            dirty = false;
            newRecord = false;

            return;
        }

        // Just update the record
        String sql = "update " + tableName + " SET ";
        String comma = "";
        for (String col: listOfColumns) {
            String coldata = instanceData.get(col);
            if (coldata == null) {
                coldata = "";
            }
            sql += String.format("%s %s = \"%s\"", comma, col, coldata);
            comma = ",";
        }
        sql += String.format(" WHERE id=\"%s\"", id);

        Persistence.getInstance().doInsertorUpdate(sql);

        dirty = false;

    }

}
