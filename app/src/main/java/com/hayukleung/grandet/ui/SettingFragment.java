package com.hayukleung.grandet.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hayukleung.grandet.R;

/**
 * Grandet
 * com.hayukleung.grandet.ui
 * SettingFragment.java
 *
 * by hayukleung
 * at 2016-11-16 16:56
 */

public class SettingFragment extends BaseFragment {

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_setting, container, false);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    view.findViewById(R.id.modify_pin_code).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        startActivityForResult(new Intent(getActivity(), GuardActivity.class), 0x0001);
      }
    });
  }

  @Override public void onActivityResult(int requestCode, int resultCode, Intent data) {
    switch (requestCode) {
      case 0x0001: {
        if (Activity.RESULT_OK == resultCode) {
          startActivity(new Intent(getActivity(), SettingPasswordActivity.class));
        }
        break;
      }
    }
  }
}
