package com.smaboy.pc120.xiuxiu.m.domain;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CONTACT".
*/
public class ContactDao extends AbstractDao<Contact, Long> {

    public static final String TABLENAME = "CONTACT";

    /**
     * Properties of entity Contact.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property UserId = new Property(1, String.class, "userId", false, "USERUD");
        public final static Property UserPwd = new Property(2, String.class, "userPwd", false, "USERPWD");
        public final static Property UserHead = new Property(3, String.class, "userHead", false, "USERHEAD");
        public final static Property UserNick = new Property(4, String.class, "userNick", false, "USERNICK");
    }


    public ContactDao(DaoConfig config) {
        super(config);
    }
    
    public ContactDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CONTACT\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"USERUD\" TEXT," + // 1: userId
                "\"USERPWD\" TEXT," + // 2: userPwd
                "\"USERHEAD\" TEXT," + // 3: userHead
                "\"USERNICK\" TEXT);"); // 4: userNick
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CONTACT\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Contact entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String userId = entity.getUserId();
        if (userId != null) {
            stmt.bindString(2, userId);
        }
 
        String userPwd = entity.getUserPwd();
        if (userPwd != null) {
            stmt.bindString(3, userPwd);
        }
 
        String userHead = entity.getUserHead();
        if (userHead != null) {
            stmt.bindString(4, userHead);
        }
 
        String userNick = entity.getUserNick();
        if (userNick != null) {
            stmt.bindString(5, userNick);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Contact entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String userId = entity.getUserId();
        if (userId != null) {
            stmt.bindString(2, userId);
        }
 
        String userPwd = entity.getUserPwd();
        if (userPwd != null) {
            stmt.bindString(3, userPwd);
        }
 
        String userHead = entity.getUserHead();
        if (userHead != null) {
            stmt.bindString(4, userHead);
        }
 
        String userNick = entity.getUserNick();
        if (userNick != null) {
            stmt.bindString(5, userNick);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Contact readEntity(Cursor cursor, int offset) {
        Contact entity = new Contact( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // userId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // userPwd
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // userHead
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4) // userNick
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Contact entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setUserId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setUserPwd(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setUserHead(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setUserNick(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Contact entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Contact entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Contact entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
