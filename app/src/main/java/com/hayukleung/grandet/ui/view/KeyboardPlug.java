package com.hayukleung.grandet.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import java.util.Stack;

/**
 * Grandet
 * com.hayukleung.grandet.ui.view
 * KeyboardPlug.java
 *
 * by hayukleung
 * at 2016-11-17 10:50
 */

public abstract class KeyboardPlug extends View implements Key {

  private Stack<String> mContentStack = new Stack<>();

  public KeyboardPlug(Context context) {
    super(context);
  }

  public KeyboardPlug(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public KeyboardPlug(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  protected abstract void acceptKey0();

  protected abstract void acceptKey1();

  protected abstract void acceptKey2();

  protected abstract void acceptKey3();

  protected abstract void acceptKey4();

  protected abstract void acceptKey5();

  protected abstract void acceptKey6();

  protected abstract void acceptKey7();

  protected abstract void acceptKey8();

  protected abstract void acceptKey9();

  protected abstract void acceptKeyDot();

  protected abstract void acceptKeyDel();

  protected abstract void acceptKeyEnter();

  protected abstract void acceptSuccessfully();

  /**
   * 小于等于0表示对输入字数无限制
   *
   * @return
   */
  protected abstract int getLimit();

  protected Stack<String> getContentStack() {
    return mContentStack;
  }

  /**
   * 接收键盘输入值
   *
   * @param key
   */
  public void acceptCode(int key) {

    if (0 < getLimit() && getLimit() == mContentStack.size()) {
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
        if (0 < mContentStack.size()) {
          mContentStack.pop();
        }
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
