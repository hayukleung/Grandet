package com.hayukleung.grandet.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Grandet
 * com.hayukleung.grandet.ui.view
 * AccountTextView.java
 *
 * by hayukleung
 * at 2016-11-17 11:29
 */

public class AccountTextView extends KeyboardTextView {

  public AccountTextView(Context context) {
    this(context, null);
  }

  public AccountTextView(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public AccountTextView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  private void init() {
  }

  @Override public boolean acceptKeySkip() {
    Pattern pattern = Pattern.compile("^(([1-9]\\d{0,9})|0)((\\.\\d{1})?|\\.)$");
    Matcher matcher = pattern.matcher(getText());
    return (0 < getLimit() && getLimit() == getContentStack().size()) || (0 < getText().length()
        && !matcher.matches());
  }

  @Override public void acceptKey0() {
    if ("0".equals(getText())) {
      return;
    }
    getContentStack().push("0");
    setText(String.format("%s%s", getText(), "0"));
  }

  @Override public void acceptKey1() {
    if ("0".equals(getText())) {
      getContentStack().pop();
      setText("");
    }
    getContentStack().push("1");
    setText(String.format("%s%s", getText(), "1"));
  }

  @Override public void acceptKey2() {
    if ("0".equals(getText())) {
      getContentStack().pop();
      setText("");
    }
    getContentStack().push("2");
    setText(String.format("%s%s", getText(), "2"));
  }

  @Override public void acceptKey3() {
    if ("0".equals(getText())) {
      getContentStack().pop();
      setText("");
    }
    getContentStack().push("3");
    setText(String.format("%s%s", getText(), "3"));
  }

  @Override public void acceptKey4() {
    if ("0".equals(getText())) {
      getContentStack().pop();
      setText("");
    }
    getContentStack().push("4");
    setText(String.format("%s%s", getText(), "4"));
  }

  @Override public void acceptKey5() {
    if ("0".equals(getText())) {
      getContentStack().pop();
      setText("");
    }
    getContentStack().push("5");
    setText(String.format("%s%s", getText(), "5"));
  }

  @Override public void acceptKey6() {
    if ("0".equals(getText())) {
      getContentStack().pop();
      setText("");
    }
    getContentStack().push("6");
    setText(String.format("%s%s", getText(), "6"));
  }

  @Override public void acceptKey7() {
    if ("0".equals(getText())) {
      getContentStack().pop();
      setText("");
    }
    getContentStack().push("7");
    setText(String.format("%s%s", getText(), "7"));
  }

  @Override public void acceptKey8() {
    if ("0".equals(getText())) {
      getContentStack().pop();
      setText("");
    }
    getContentStack().push("8");
    setText(String.format("%s%s", getText(), "8"));
  }

  @Override public void acceptKey9() {
    if ("0".equals(getText())) {
      getContentStack().pop();
      setText("");
    }
    getContentStack().push("9");
    setText(String.format("%s%s", getText(), "9"));
  }

  @Override public void acceptKeyDot() {
    if (0 == getText().length()) {
      getContentStack().push("0");
      setText(String.format("%s%s", getText(), "0"));
    }
    if (".".equals(getContentStack().peek())) {
      return;
    }
    getContentStack().push(".");
    setText(String.format("%s%s", getText(), "."));
  }

  @Override public void acceptKeyDel() {
    if (0 < getContentStack().size()) {
      getContentStack().pop();
      setText(getText().subSequence(0, getText().length() - 1));
    }
  }

  @Override public void acceptKeyDelLong() {
    getContentStack().clear();
    setText("");
  }

  @Override public void acceptKeyEnter() {
  }

  @Override public void acceptSuccessfully() {
  }
}
