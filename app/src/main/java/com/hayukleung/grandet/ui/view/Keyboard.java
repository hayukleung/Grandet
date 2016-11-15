package com.hayukleung.grandet.ui.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.hayukleung.grandet.R;

/**
 * Grandet
 * com.hayukleung.grandet.ui.view
 * Keyboard.java
 *
 * by hayukleung
 * at 2016-11-15 18:57
 */

public class Keyboard extends LinearLayoutCompat {

  public Keyboard(Context context) {
    this(context, null);
  }

  public Keyboard(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public Keyboard(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  private void init() {
    LayoutInflater.from(getContext()).inflate(R.layout.layout_keyboard, null, false);
  }
}
