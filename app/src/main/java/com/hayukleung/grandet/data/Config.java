package com.hayukleung.grandet.data;

import com.hayukleung.grandet.data.bean.Category;
import java.util.ArrayList;
import java.util.List;

/**
 * Grandet
 * com.hayukleung.grandet.data
 * Config.java
 *
 * by hayukleung
 * at 2016-11-15 18:17
 */

/**
 * 数据驱动
 */
public class Config {

  public static final List<Category> LIST_OUTCOME = new ArrayList<>(7);
  public static final List<Category> LIST_INCOME = new ArrayList<>(6);

  static {
    Category category;

    category = new Category();
    category.setId(Category.CATE_OUTCOME_CLOTHES);
    category.setName("衣");
    LIST_OUTCOME.add(category);

    category = new Category();
    category.setId(Category.CATE_OUTCOME_FOODS__);
    category.setName("食");
    LIST_OUTCOME.add(category);

    category = new Category();
    category.setId(Category.CATE_OUTCOME_HOUSE__);
    category.setName("住");
    LIST_OUTCOME.add(category);

    category = new Category();
    category.setId(Category.CATE_OUTCOME_TRAFFIC);
    category.setName("行");
    LIST_OUTCOME.add(category);

    category = new Category();
    category.setId(Category.CATE_OUTCOME_BORROW_);
    category.setName("借");
    LIST_OUTCOME.add(category);

    category = new Category();
    category.setId(Category.CATE_OUTCOME_MOBILE_);
    category.setName("通");
    LIST_OUTCOME.add(category);

    category = new Category();
    category.setId(Category.CATE_OUTCOME_OTHER__);
    category.setName("它");
    LIST_OUTCOME.add(category);
  }

  static {
    Category category;

    category = new Category();
    category.setId(Category.CATE_INCOME_SALARY__);
    category.setName("薪");
    LIST_INCOME.add(category);

    category = new Category();
    category.setId(Category.CATE_INCOME_BORROW__);
    category.setName("借");
    LIST_INCOME.add(category);

    category = new Category();
    category.setId(Category.CATE_INCOME_INTEREST);
    category.setName("息");
    LIST_INCOME.add(category);

    category = new Category();
    category.setId(Category.CATE_INCOME_RED_____);
    category.setName("红");
    LIST_INCOME.add(category);

    category = new Category();
    category.setId(Category.CATE_INCOME_BACK____);
    category.setName("返");
    LIST_INCOME.add(category);

    category = new Category();
    category.setId(Category.CATE_INCOME_OTHER___);
    category.setName("它");
    LIST_INCOME.add(category);
  }
}
