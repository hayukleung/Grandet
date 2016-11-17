package com.hayukleung.grandet.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import java.util.Stack;

/**
 * Grandet
 * com.hayukleung.grandet.ui.view
 * KeyboardTextView.java
 *
 * by hayukleung
 * at 2016-11-17 11:23
 */

public abstract class KeyboardTextView extends TextView implements IKeyboard {

  private Stack<String> mContentStack = new Stack<>();

  public KeyboardTextView(Context context) {
    super(context);
  }

  public KeyboardTextView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public KeyboardTextView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override public int getLimit() {
    return 0;
  }

  @Override public Stack<String> getContentStack() {
    return this.mContentStack;
  }

  @Override public void acceptCode(int key) {

    if (KEY_DEL != key && KEY_DEL_LONG != key && KEY_ENTER != key && acceptKeySkip()) {
      return;
    }

    switch (key) {
      case KEY_0: {
        acceptKey0();
        break;
      }
      case KEY_1: {
        acceptKey1();
        break;
      }
      case KEY_2: {
        acceptKey2();
        break;
      }
      case KEY_3: {
        acceptKey3();
        break;
      }
      case KEY_4: {
        acceptKey4();
        break;
      }
      case KEY_5: {
        acceptKey5();
        break;
      }
      case KEY_6: {
        acceptKey6();
        break;
      }
      case KEY_7: {
        acceptKey7();
        break;
      }
      case KEY_8: {
        acceptKey8();
        break;
      }
      case KEY_9: {
        acceptKey9();
        break;
      }
      case KEY_DOT: {
        acceptKeyDot();
        break;
      }
      case KEY_DEL: {
        acceptKeyDel();
        break;
      }
      case KEY_DEL_LONG: {
        acceptKeyDelLong();
        break;
      }
      case KEY_ENTER: {
        acceptKeyEnter();
        break;
      }
      case KEY_INVALID:
      default: {
        break;
      }
    }

    acceptSuccessfully();
  }
}
