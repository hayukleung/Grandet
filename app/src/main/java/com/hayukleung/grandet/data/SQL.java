package com.hayukleung.grandet.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.hayukleung.grandet.data.bean.Password;

/**
 * Grandet
 * com.hayukleung.grandet.data
 * SQL.java
 *
 * by hayukleung
 * at 2016-11-16 14:29
 */

abstract class SQL {

  private static final String COL_ID = "_id";

  // ----------------------------------------------------------------------------------------------
  private static final String TB_PASSWORD = "grandet_password";
  static final StringBuilder sqlPasswordDrop =
      new StringBuilder("drop table if exists ").append(TB_PASSWORD).append(";");
  private static final String COL_PASSWORD = "_password";
  static final StringBuilder sqlPasswordCreate =
      new StringBuilder("create table if not exists ").append(TB_PASSWORD)
          .append("(")
          .append(COL_ID)
          .append(" integer primary key autoincrement, ")
          .append(COL_PASSWORD)
          .append(" text")
          .append(");");

  public long insert(Password password) {
    // 键值对
    ContentValues values = new ContentValues();
    values.put(COL_PASSWORD, password.getPassword());
    getSQLiteDatabase().execSQL("delete from " + TB_PASSWORD);
    return getSQLiteDatabase().insert(TB_PASSWORD, COL_ID, values);
  }

  public Password queryPassword() {
    Cursor cursor = null;
    String pwd = null;
    try {
      cursor =
          getSQLiteDatabase().rawQuery("select " + COL_PASSWORD + " from " + TB_PASSWORD, null);
      if (null != cursor && cursor.moveToFirst()) {
        do {
          pwd = cursor.getString(0);
        } while (cursor.moveToNext());
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (null != cursor) {
        cursor.close();
      }
    }
    if (null != pwd) {
      Password password = new Password();
      password.setPassword(pwd);

      return password;
    } else {
      return null;
    }
  }

  // ----------------------------------------------------------------------------------------------
  abstract SQLiteDatabase getSQLiteDatabase();
}
