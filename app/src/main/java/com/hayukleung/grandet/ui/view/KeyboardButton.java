package com.hayukleung.grandet.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.Button;

/**
 * Grandet
 * com.hayukleung.grandet.ui.view
 * KeyboardButton.java
 *
 * by hayukleung
 * at 2016-11-15 18:30
 */

/**
 * 键盘按钮
 *
 * 0 1 2 3 4 5 6 7 8 9 . DEL ENTER
 */
public class KeyboardButton extends Button {

  public KeyboardButton(Context context) {
    this(context, null);
  }

  public KeyboardButton(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public KeyboardButton(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  private void init() {
    setGravity(Gravity.CENTER);
    setPadding(0, 10, 0, 10);
  }

  private static class Config {

    public static final int KEY_0 = 0;
    public static final int KEY_1 = 1;
    public static final int KEY_2 = 2;
    public static final int KEY_3 = 3;
    public static final int KEY_4 = 4;
    public static final int KEY_5 = 5;
    public static final int KEY_6 = 6;
    public static final int KEY_7 = 7;
    public static final int KEY_8 = 8;
    public static final int KEY_9 = 9;
    public static final int KEY_DOT = 10;
    public static final int KEY_DEL = 11;
    public static final int KEY_ENTER = 12;
  }
}
