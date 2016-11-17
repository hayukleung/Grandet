package com.hayukleung.grandet.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hayukleung.grandet.R;
import com.hayukleung.grandet.ui.view.AccountTextView;
import com.hayukleung.grandet.ui.view.Keyboard;

/**
 * Grandet
 * com.hayukleung.grandet.ui
 * RecordFragment.java
 *
 * by hayukleung
 * at 2016-11-16 16:57
 */

public class RecordFragment extends Fragment {

  private Keyboard mKeyboard;
  private AccountTextView mAccountTextView;

  public void refreshKeyboard() {
    mKeyboard.refresh();
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_record, container, false);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    mAccountTextView = (AccountTextView) view.findViewById(R.id.account_text_view);
    mKeyboard = (Keyboard) view.findViewById(R.id.keyboard);
    mKeyboard.setKeyboardHelper(new Keyboard.KeyboardHelper() {
      @Override public void onKeySure(int key) {
        mAccountTextView.acceptCode(key);
      }
    });
  }
}
