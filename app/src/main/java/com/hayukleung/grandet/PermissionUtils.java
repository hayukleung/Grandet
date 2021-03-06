package com.hayukleung.grandet;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;

/**
 * Grandet
 * com.hayukleung.grandet
 * PermissionUtils.java
 *
 * by hayukleung
 * at 2016-11-17 16:01
 */

/**
 * 权限检查
 *
 * https://github.com/hayukleung/app/blob/master/appMice/src/main/java/com/hayukleung/permissions/PermissionsUtils.java
 */
public class PermissionUtils {

  public static boolean lacksPermissions(Context context, String... permissions) {
    for (String permission : permissions) {
      if (lacksPermission(context, permission)) {
        return true;
      }
    }
    return false;
  }

  private static boolean lacksPermission(Context context, String permission) {
    return ContextCompat.checkSelfPermission(context, permission)
        == PackageManager.PERMISSION_DENIED;
  }
}

