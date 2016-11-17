package com.hayukleung.grandet.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Grandet
 * com.hayukleung.grandet.data
 * Database.java
 *
 * by hayukleung
 * at 2016-11-16 14:22
 */

public class Database extends SQL {

  private SQLiteDatabase mSQLiteDatabase;
  private Helper mHelper;

  public Database(Context context) {
    mHelper = new Helper(context);
    mSQLiteDatabase = mHelper.getWritableDatabase();
  }

  public void close() {
    try {
      mSQLiteDatabase.close();
      mSQLiteDatabase = null;
      mHelper.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * 判断数据库是否已打开
   */
  public boolean isOpen() {
    return null != mSQLiteDatabase && mSQLiteDatabase.isOpen();
  }

  @Override public SQLiteDatabase getSQLiteDatabase() {
    return mSQLiteDatabase;
  }

  private static class Helper extends SQLiteOpenHelper {

    Helper(Context context) {
      super(context, "grandet.db", null, 1);
    }

    @Override public void onCreate(SQLiteDatabase db) {
      db.execSQL(sqlPasswordCreate.toString());
      db.execSQL(sqlRecordCreate.toString());
    }

    @Override public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
      db.execSQL(sqlPasswordDrop.toString());
      db.execSQL(sqlRecordDrop.toString());
      onCreate(db);
    }
  }
}
