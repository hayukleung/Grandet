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

  private int id;
  private String name;
  private boolean checked;

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
}
