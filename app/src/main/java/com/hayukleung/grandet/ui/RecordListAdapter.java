package com.hayukleung.grandet.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hayukleung.grandet.R;
import com.hayukleung.grandet.data.bean.Record;
import java.util.List;

/**
 * Grandet
 * com.hayukleung.grandet.ui
 * CategoryAdapter.java
 *
 * by hayukleung
 * at 2016-11-17 16:41
 */

class RecordListAdapter extends RecyclerView.Adapter<RecordListAdapter.RecordListHolder> {

  private Context mContext;
  private List<Record> mRecordList;

  public RecordListAdapter(Context context, List<Record> recordList) {
    mContext = context;
    mRecordList = recordList;
  }

  @Override public RecordListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new RecordListHolder(
        LayoutInflater.from(mContext).inflate(R.layout.item_record_list, parent, false));
  }

  @Override public void onBindViewHolder(RecordListHolder holder, int position) {
  }

  @Override public int getItemCount() {
    return null == mRecordList ? 0 : mRecordList.size();
  }

  static class RecordListHolder extends RecyclerView.ViewHolder {

    RecordListHolder(View itemView) {
      super(itemView);
    }
  }
}
