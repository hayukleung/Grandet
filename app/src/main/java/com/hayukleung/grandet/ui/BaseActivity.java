package com.hayukleung.grandet.ui;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.hayukleung.grandet.PermissionUtils;
import com.hayukleung.grandet.R;
import com.hayukleung.grandet.data.Database;

/**
 * Grandet
 * com.hayukleung.grandet.ui
 * BaseActivity.java
 *
 * by hayukleung
 * at 2016-11-16 12:55
 */

public class BaseActivity extends AppCompatActivity {

  public static final int PERMISSIONS_GRANTED = 0;
  public static final int PERMISSIONS_DENIED = 1;
  private static final int PERMISSION_REQUEST_CODE = 0;
  private static final String EXTRA_PERMISSIONS = "com.hayukleung.mice.EXTRA_PERMISSIONS";
  private static final String PACKAGE_URL_SCHEME = "package:";
  private Database mDatabase;
  private boolean mRequiresCheck;

  protected Database getDatabase() {
    if (null == mDatabase || !mDatabase.isOpen()) {
      this.mDatabase = new Database(this);
    }
    return this.mDatabase;
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    // https://www.aswifter.com/2015/12/24/android-m-change-statusbar-textcolor/
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      getWindow().getDecorView()
          .setSystemUiVisibility(
              View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
      getWindow().setStatusBarColor(Color.WHITE);
    }

    mDatabase = new Database(this);

    mRequiresCheck = true;
  }

  @Override protected void onResume() {
    super.onResume();
    if (mRequiresCheck) {
      String[] permissions = new String[] { Manifest.permission.VIBRATE };

      if (PermissionUtils.lacksPermissions(BaseActivity.this, permissions)) {
        requestPermissions(permissions);
      } else {
        allPermissionsGranted();
      }
    } else {
      mRequiresCheck = true;
    }
  }

  @Override protected void onPause() {
    mDatabase.close();
    super.onPause();
  }

  @Override public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
      @NonNull int[] grantResults) {
    if (requestCode == PERMISSION_REQUEST_CODE && hasAllPermissionsGranted(grantResults)) {
      mRequiresCheck = true;
      allPermissionsGranted();
    } else {
      mRequiresCheck = false;
      showMissingPermissionDialog();
    }
  }

  private void requestPermissions(String... permissions) {
    ActivityCompat.requestPermissions(this, permissions, PERMISSION_REQUEST_CODE);
  }

  private void allPermissionsGranted() {
    setResult(PERMISSIONS_GRANTED);
  }

  private boolean hasAllPermissionsGranted(@NonNull int[] grantResults) {
    for (int grantResult : grantResults) {
      if (grantResult == PackageManager.PERMISSION_DENIED) {
        return false;
      }
    }
    return true;
  }

  private void showMissingPermissionDialog() {
    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(BaseActivity.this);
    dialogBuilder.setTitle(R.string.help);
    dialogBuilder.setMessage(R.string.string_help_text);
    dialogBuilder.setNegativeButton(R.string.quit, new DialogInterface.OnClickListener() {
      @Override public void onClick(DialogInterface dialog, int which) {
        setResult(PERMISSIONS_DENIED);
        finish();
      }
    });
    dialogBuilder.setPositiveButton(R.string.settings, new DialogInterface.OnClickListener() {
      @Override public void onClick(DialogInterface dialog, int which) {
        startAppSettings();
      }
    });
    dialogBuilder.show();
  }

  private void startAppSettings() {
    Intent intent = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
    intent.setData(Uri.parse(PACKAGE_URL_SCHEME + getPackageName()));
    startActivity(intent);
  }
}
