package com.hayukleung.grandet.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;
import com.hayukleung.grandet.R;
import com.hayukleung.grandet.ui.view.Keyboard;
import com.hayukleung.grandet.ui.view.Password;

/**
 * Grandet
 * com.hayukleung.grandet.ui
 * SettingPasswordActivity.java
 *
 * by hayukleung
 * at 2016-11-15 18:21
 */

/**
 * 密码把守
 */
public class GuardActivity extends BaseActivity {

  private TextView mHint;
  private Password mPassword;
  private Keyboard mKeyboard;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_guard);

    mHint = (TextView) findViewById(R.id.hint);
    mPassword = (Password) findViewById(R.id.password);
    mPassword.setPasswordHelper(new Password.PasswordHelper() {
      @Override public void onPasswordTyped(String password) {
        Log.e(GuardActivity.class.getSimpleName(), "password --> " + password);
        if (getDatabase().queryPassword().getPassword().equals(password)) {
          GuardActivity.this.finish();
        } else {
          mHint.setText(R.string.pin_code_error);
          mPassword.clear();
        }
      }
    });
    mKeyboard = (Keyboard) findViewById(R.id.keyboard);
    mKeyboard.setKeyboardHelper(new Keyboard.KeyboardHelper() {

      @Override public void onKeySure(int key) {
        mPassword.acceptCode(key);
      }
    });
  }

  @Override public void onBackPressed() {
  }
}
