package com.forzafootball.assignment.dbdata.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.forzafootball.assignment.dbdata.db.TeamDB;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TEAM_DB".
*/
public class TeamDBDao extends AbstractDao<TeamDB, Long> {

    public static final String TABLENAME = "TEAM_DB";

    /**
     * Properties of entity TeamDB.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property National = new Property(2, Boolean.class, "national", false, "NATIONAL");
        public final static Property Country_name = new Property(3, String.class, "country_name", false, "COUNTRY_NAME");
    }


    public TeamDBDao(DaoConfig config) {
        super(config);
    }
    
    public TeamDBDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TEAM_DB\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"NAME\" TEXT," + // 1: name
                "\"NATIONAL\" INTEGER," + // 2: national
                "\"COUNTRY_NAME\" TEXT);"); // 3: country_name
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TEAM_DB\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, TeamDB entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        Boolean national = entity.getNational();
        if (national != null) {
            stmt.bindLong(3, national ? 1L: 0L);
        }
 
        String country_name = entity.getCountry_name();
        if (country_name != null) {
            stmt.bindString(4, country_name);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, TeamDB entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        Boolean national = entity.getNational();
        if (national != null) {
            stmt.bindLong(3, national ? 1L: 0L);
        }
 
        String country_name = entity.getCountry_name();
        if (country_name != null) {
            stmt.bindString(4, country_name);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public TeamDB readEntity(Cursor cursor, int offset) {
        TeamDB entity = new TeamDB( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getShort(offset + 2) != 0, // national
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // country_name
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, TeamDB entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setNational(cursor.isNull(offset + 2) ? null : cursor.getShort(offset + 2) != 0);
        entity.setCountry_name(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(TeamDB entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(TeamDB entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(TeamDB entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
