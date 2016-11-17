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

/**
 * 键盘接收插口
 */
public abstract class KeyboardView extends View implements IKeyboard {

  private Stack<String> mContentStack = new Stack<>();

  public KeyboardView(Context context) {
    super(context);
  }

  public KeyboardView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public KeyboardView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override public Stack<String> getContentStack() {
    return mContentStack;
  }

  /**
   * 接收键盘输入值
   *
   * @param key
   */
  @Override public void acceptCode(int key) {

    if (acceptKeySkip()) {
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
      case KEY_DEL_LONG: {
        mContentStack.clear();
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
