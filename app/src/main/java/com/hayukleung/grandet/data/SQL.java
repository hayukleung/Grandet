package com.hayukleung.grandet.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.hayukleung.grandet.data.bean.Password;
import com.hayukleung.grandet.data.bean.Record;
import java.util.ArrayList;
import java.util.List;

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
  private static final String SQL_CREATE_TABLE = "create table if not exists ";
  private static final String SQL_DROP_TABLE = "drop table if exists ";
  private static final String SQL_ID = " integer primary key autoincrement, ";

  // ----------------------------------------------------------------------------------------------
  private static final String TB_PASSWORD = "grandet_password";
  static final StringBuilder sqlPasswordDrop =
      new StringBuilder(SQL_DROP_TABLE).append(TB_PASSWORD).append(";");
  private static final String COL_PASSWORD = "_password";
  static final StringBuilder sqlPasswordCreate =
      new StringBuilder(SQL_CREATE_TABLE).append(TB_PASSWORD)
          .append("(")
          .append(COL_ID).append(SQL_ID)
          .append(COL_PASSWORD)
          .append(" text")
          .append(");");
  // ----------------------------------------------------------------------------------------------
  private static final String TB_RECORD = "grandet_record";
  static final StringBuilder sqlRecordDrop =
      new StringBuilder(SQL_DROP_TABLE).append(TB_RECORD).append(";");
  private static final String COL_TIMESTAMP = "_timestamp";
  private static final String COL_CATEGORY = "_category";
  private static final String COL_ACCOUNT = "_account";
  static final StringBuilder sqlRecordCreate = new StringBuilder(SQL_CREATE_TABLE).append(TB_RECORD)
      .append("(")
      .append(COL_ID)
      .append(SQL_ID)
      .append(COL_TIMESTAMP)
      .append(" integer, ")
      .append(COL_CATEGORY)
      .append(" integer, ")
      .append(COL_ACCOUNT)
      .append(" real")
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

  public long insert(Record record) {
    // 键值对
    ContentValues values = new ContentValues();
    values.put(COL_TIMESTAMP, record.getTimestamp());
    values.put(COL_CATEGORY, record.getCategory());
    values.put(COL_ACCOUNT, record.getAccount());
    return getSQLiteDatabase().insert(TB_RECORD, COL_ID, values);
  }

  public List<Record> query(int category, long fromTS, long toTS, int limit, int offset) {
    String sql = "select * from "
        + TB_RECORD
        + " where ("
        + COL_CATEGORY
        + " & "
        + category
        + ") = "
        + category
        + " and "
        + COL_TIMESTAMP
        + " >= "
        + fromTS
        + " and "
        + COL_TIMESTAMP
        + " < "
        + toTS
        + " order by "
        + COL_TIMESTAMP
        + " desc limit "
        + limit
        + " offset "
        + offset
        + ";";
    Cursor cursor = null;
    List<Record> recordList = new ArrayList<>(limit);
    try {
      cursor = getSQLiteDatabase().rawQuery(sql, null);
      while (cursor != null && cursor.moveToNext()) {
        Record record = new Record();
        record.setTimestamp(cursor.getLong(cursor.getColumnIndex(COL_TIMESTAMP)));
        record.setCategory(cursor.getInt(cursor.getColumnIndex(COL_CATEGORY)));
        record.setAccount(cursor.getDouble(cursor.getColumnIndex(COL_ACCOUNT)));
        recordList.add(record);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (cursor != null) {
        cursor.close();
      }
    }
    return recordList;
  }

  // ----------------------------------------------------------------------------------------------
  abstract SQLiteDatabase getSQLiteDatabase();
}
