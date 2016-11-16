package com.hayukleung.grandet.ui;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Grandet
 * com.hayukleung.grandet.ui
 * BaseActivity.java
 *
 * by hayukleung
 * at 2016-11-16 12:55
 */

public class BaseActivity extends AppCompatActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // https://www.aswifter.com/2015/12/24/android-m-change-statusbar-textcolor/
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      getWindow().getDecorView()
          .setSystemUiVisibility(
              View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
      getWindow().setStatusBarColor(Color.WHITE);
    }
  }
}
