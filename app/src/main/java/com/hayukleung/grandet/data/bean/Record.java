package com.hayukleung.grandet.data.bean;

/**
 * Grandet
 * com.hayukleung.grandet.data.bean
 * Record.java
 *
 * by hayukleung
 * at 2016-11-16 18:31
 */

/**
 * 一笔记录
 */
public class Record extends BaseBean {

  /**
   * 时间戳
   */
  private long timestamp;
  /**
   * 支出|收入
   */
  private int type;
  /**
   * 归类
   */
  private int category;
}
