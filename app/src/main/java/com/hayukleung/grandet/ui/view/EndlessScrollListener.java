//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.hayukleung.grandet.ui.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;

public class EndlessScrollListener extends OnScrollListener {
  private int visibleThreshold;
  private OnScrollListener mOnScrollListener;
  private EndlessScrollListener.IMore mMore;

  public EndlessScrollListener(EndlessScrollListener.IMore more) {
    this(3, more);
  }

  public EndlessScrollListener(int visibleThreshold, EndlessScrollListener.IMore more) {
    this.visibleThreshold = 3;
    this.visibleThreshold = visibleThreshold;
    this.mMore = more;
  }

  public void setOnScrollListener(OnScrollListener onScrollListener) {
    this.mOnScrollListener = onScrollListener;
  }

  public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
    if (this.mOnScrollListener != null) {
      this.mOnScrollListener.onScrollStateChanged(recyclerView, newState);
    }

    if (newState == 0
        && this.mMore.hasMore()
        && !this.mMore.isLoading()
        && this.mMore.canLoad()
        && ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition()
        >= recyclerView.getAdapter().getItemCount() - this.visibleThreshold) {
      this.mMore.loadMore();
    }
  }

  public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
    if (this.mOnScrollListener != null) {
      this.mOnScrollListener.onScrolled(recyclerView, dx, dy);
    }
  }

  public interface IMore {
    boolean canLoad();

    boolean canShow();

    boolean hasMore();

    boolean isLoading();

    void loadMore();
  }
}
