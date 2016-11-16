package com.hayukleung.grandet.ui;

import android.content.Intent;
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
 * 设置密码
 */
public class SettingPasswordActivity extends BaseActivity {

  private TextView mHint;
  private Password mPassword;
  private Keyboard mKeyboard;

  private int mTypeIndex = 0;
  private String mPassword1, mPassword2;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_setting_password);

    mHint = (TextView) findViewById(R.id.hint);
    mPassword = (Password) findViewById(R.id.password);
    mPassword.setPasswordHelper(new Password.PasswordHelper() {
      @Override public void onPasswordTyped(String password) {
        Log.e(SettingPasswordActivity.class.getSimpleName(), "password --> " + password);
        mTypeIndex++;
        switch (mTypeIndex) {
          case 1: {
            // 完成第一次录入
            mPassword1 = password;
            mHint.setText(R.string.pin_code_setup_again);
            mPassword.clear();
            break;
          }
          default: {
            // 完成第二次录入
            mPassword2 = password;
            if (mPassword1.equals(mPassword2)) {
              // 两次密码一致
              // 保存密码
              com.hayukleung.grandet.data.bean.Password pwd =
                  new com.hayukleung.grandet.data.bean.Password();
              pwd.setPassword(password);
              getDatabase().insert(pwd);
              // 跳转主界面
              startActivity(
                  new Intent(SettingPasswordActivity.this, AccountingPagerActivity.class));
              SettingPasswordActivity.this.finish();
            } else {
              // 两次密码不一致
              mHint.setText(R.string.pin_code_setup_error);
              mTypeIndex--;
              mPassword.clear();
            }
          }
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
}
