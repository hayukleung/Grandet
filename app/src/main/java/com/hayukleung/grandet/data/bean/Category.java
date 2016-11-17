package com.hayukleung.grandet.data.bean;

import android.widget.Checkable;

/**
 * Grandet
 * com.hayukleung.grandet.data.bean
 * Category.java
 *
 * by hayukleung
 * at 2016-11-16 18:42
 */

public class Category extends BaseBean implements Checkable {

  public static final int CATE_ALL____________ = 0x0000;

  public static final int CATE_OUTCOME________ = 0x1000;

  public static final int CATE_OUTCOME_CLOTHES = 0x0001 | CATE_OUTCOME________;
  public static final int CATE_OUTCOME_FOODS__ = 0x0002 | CATE_OUTCOME________;
  public static final int CATE_OUTCOME_HOUSE__ = 0x0003 | CATE_OUTCOME________;
  public static final int CATE_OUTCOME_TRAFFIC = 0x0004 | CATE_OUTCOME________;
  public static final int CATE_OUTCOME_BORROW_ = 0x0005 | CATE_OUTCOME________;
  public static final int CATE_OUTCOME_MOBILE_ = 0x0006 | CATE_OUTCOME________;
  public static final int CATE_OUTCOME_OTHER__ = 0x0007 | CATE_OUTCOME________;

  public static final int CATE_INCOME_________ = 0x2000;

  public static final int CATE_INCOME_SALARY__ = 0x0001 | CATE_INCOME_________;
  public static final int CATE_INCOME_BORROW__ = 0x0002 | CATE_INCOME_________;
  public static final int CATE_INCOME_INTEREST = 0x0003 | CATE_INCOME_________;
  public static final int CATE_INCOME_RED_____ = 0x0004 | CATE_INCOME_________;
  public static final int CATE_INCOME_BACK____ = 0x0005 | CATE_INCOME_________;
  public static final int CATE_INCOME_OTHER___ = 0x0006 | CATE_INCOME_________;

  private int id;
  private String name;
  private boolean checked = false;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override public boolean isChecked() {
    return checked;
  }

  @Override public void setChecked(boolean checked) {
    this.checked = checked;
  }

  @Override public void toggle() {
    this.checked = !this.checked;
  }

  @Override public boolean equals(Object obj) {
    return !(null == obj || !(obj instanceof Category)) && this.id == ((Category) obj).id;
  }

  @Override public int hashCode() {
    return this.id;
  }
}
