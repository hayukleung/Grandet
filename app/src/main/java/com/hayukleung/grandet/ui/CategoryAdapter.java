package com.hayukleung.grandet.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hayukleung.grandet.R;
import com.hayukleung.grandet.data.bean.Category;
import java.util.List;

/**
 * Grandet
 * com.hayukleung.grandet.ui
 * CategoryAdapter.java
 *
 * by hayukleung
 * at 2016-11-17 16:41
 */

class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {

  private Context mContext;
  private List<Category> mCategoryList;

  public CategoryAdapter(Context context, List<Category> categoryList) {
    mContext = context;
    mCategoryList = categoryList;
  }

  @Override public CategoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new CategoryHolder(
        LayoutInflater.from(mContext).inflate(R.layout.item_category, parent, false));
  }

  @Override public void onBindViewHolder(CategoryHolder holder, int position) {
    final Category category = mCategoryList.get(position);
    holder.category.setText(category.getName());
    holder.category.setSelected(category.isChecked());
    holder.category.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        for (Category c : mCategoryList) {
          c.setChecked(false);
        }
        category.setChecked(true);
        notifyDataSetChanged();
      }
    });
  }

  @Override public int getItemCount() {
    return null == mCategoryList ? 0 : mCategoryList.size();
  }

  static class CategoryHolder extends RecyclerView.ViewHolder {

    TextView category;

    public CategoryHolder(View itemView) {
      super(itemView);
      category = (TextView) itemView.findViewById(R.id.category);
    }
  }
}
