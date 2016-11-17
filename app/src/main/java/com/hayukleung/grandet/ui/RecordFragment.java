package com.hayukleung.grandet.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.hayukleung.grandet.R;
import com.hayukleung.grandet.data.Config;
import com.hayukleung.grandet.data.bean.Category;
import com.hayukleung.grandet.ui.view.AccountTextView;
import com.hayukleung.grandet.ui.view.Keyboard;
import java.util.ArrayList;
import java.util.List;

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
  private RadioGroup mRadioGroup;
  private RadioButton mOutcome, mIncome;
  private RecyclerView mRecyclerView;
  private List<Category> mCategoryList = new ArrayList<>(8);

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
    mRadioGroup = (RadioGroup) view.findViewById(R.id.radio_group);
    mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
      @Override public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        if (checkedId == mOutcome.getId()) {
          mCategoryList.clear();
          mCategoryList.addAll(Config.LIST_OUTCOME);
          mRecyclerView.getAdapter().notifyDataSetChanged();
          return;
        }
        if (checkedId == mIncome.getId()) {
          mCategoryList.clear();
          mCategoryList.addAll(Config.LIST_INCOME);
          mRecyclerView.getAdapter().notifyDataSetChanged();
          return;
        }
      }
    });
    mOutcome = (RadioButton) view.findViewById(R.id.outcome);
    mIncome = (RadioButton) view.findViewById(R.id.income);
    mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
    mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
    mRecyclerView.setAdapter(new CategoryAdapter(getActivity(), mCategoryList));

    mOutcome.setChecked(true);
  }
}
