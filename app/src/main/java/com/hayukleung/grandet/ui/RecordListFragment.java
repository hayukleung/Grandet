package com.hayukleung.grandet.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hayukleung.grandet.R;
import com.hayukleung.grandet.data.bean.Record;
import com.hayukleung.grandet.ui.view.EndlessScrollListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Grandet
 * com.hayukleung.grandet.ui
 * RecordListFragment.java
 *
 * by hayukleung
 * at 2016-11-16 16:58
 */

public class RecordListFragment extends BaseFragment {

  private SwipeRefreshLayout mSwipeRefreshLayout;
  private RecyclerView mRecyclerView;

  private List<Record> mRecordList = new ArrayList<>();

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_record_list, container, false);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
    mSwipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorAccent));
    mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
      @Override public void onRefresh() {
        // TODO
      }
    });
    mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
    mRecyclerView.addOnScrollListener(new EndlessScrollListener(new EndlessScrollListener.IMore() {
      @Override public boolean canLoad() {
        return false;
      }

      @Override public boolean canShow() {
        return false;
      }

      @Override public boolean hasMore() {
        return false;
      }

      @Override public boolean isLoading() {
        return false;
      }

      @Override public void loadMore() {

      }
    }));
    mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    mRecyclerView.setAdapter(new RecordListAdapter(getActivity(), mRecordList));
  }
}
