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
   * 归类
   */
  private int category;
  /**
   * 金额
   */
  private double account;

  public long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }

  public int getCategory() {
    return category;
  }

  public void setCategory(int category) {
    this.category = category;
  }

  public double getAccount() {
    return account;
  }

  public void setAccount(double account) {
    this.account = account;
  }
}
