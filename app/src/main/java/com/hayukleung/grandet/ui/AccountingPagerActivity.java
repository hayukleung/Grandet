package com.hayukleung.grandet.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import com.hayukleung.grandet.R;

/**
 * Grandet
 * com.hayukleung.grandet.ui
 * AccountingPagerActivity.java
 *
 * by hayukleung
 * at 2016-11-16 16:27
 */

public class AccountingPagerActivity extends BaseActivity {

  private ViewPager mViewPager;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_accounting);

    mViewPager = (ViewPager) findViewById(R.id.view_pager);
    mViewPager.setAdapter(new AccountingPagerAdapter(getSupportFragmentManager()));
    mViewPager.setCurrentItem(1);
    mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
      @Override
      public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

      }

      @Override public void onPageSelected(int position) {

      }

      @Override public void onPageScrollStateChanged(int state) {

        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
          if (fragment instanceof RecordFragment) {
            ((RecordFragment) fragment).refreshKeyboard();
            break;
          }
        }
      }
    });
  }
}
