package com.hayukleung.grandet.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Grandet
 * com.hayukleung.grandet.ui
 * AccountingPagerAdapter.java
 *
 * by hayukleung
 * at 2016-11-16 16:53
 */

public class AccountingPagerAdapter extends FragmentPagerAdapter {

  public AccountingPagerAdapter(FragmentManager fm) {
    super(fm);
  }

  @Override public Fragment getItem(int position) {
    Fragment fragment = null;
    switch (position) {
      case 0: {
        fragment = new SettingFragment();
        break;
      }
      case 1: {
        fragment = new RecordFragment();
        break;
      }
      case 2: {
        fragment = new RecordListFragment();
        break;
      }
    }
    return fragment;
  }

  @Override public int getCount() {
    return 3;
  }
}
