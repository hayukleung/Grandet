package com.hayukleung.grandet.ui.view;

import java.util.Stack;

/**
 * Grandet
 * com.hayukleung.grandet.ui.view
 * IKeyboard.java
 *
 * by hayukleung
 * at 2016-11-17 11:17
 */

interface IKeyboard extends Key {

  /**
   * 条件过滤
   *
   * @return
   */
  boolean acceptKeySkip();

  void acceptKey0();

  void acceptKey1();

  void acceptKey2();

  void acceptKey3();

  void acceptKey4();

  void acceptKey5();

  void acceptKey6();

  void acceptKey7();

  void acceptKey8();

  void acceptKey9();

  void acceptKeyDot();

  void acceptKeyDel();

  void acceptKeyDelLong();

  void acceptKeyEnter();

  void acceptSuccessfully();

  /**
   * 小于等于0表示对输入字数无限制
   *
   * @return
   */
  int getLimit();

  Stack<String> getContentStack();

  /**
   * 接收键盘输入值
   *
   * @param key
   */
  void acceptCode(int key);
}
