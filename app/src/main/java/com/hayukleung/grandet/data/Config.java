package com.hayukleung.grandet.data;

import com.hayukleung.grandet.data.bean.BaseBean;

/**
 * Grandet
 * com.hayukleung.grandet.data
 * Config.java
 *
 * by hayukleung
 * at 2016-11-15 18:17
 */

public class Config {

  public static class Type extends BaseBean {
    public static final int TYPE_OUTCOME = 0x1000;
    public static final int TYPE_INCOME = 0x2000;
  }

  public static class Category extends BaseBean {
    public static final int cate_clothes = 0x0001;
    public static final int cate_foods = 0x0002;
    public static final int cate_house = 0x0003;
    public static final int cate_traffic = 0x0004;
    public static final int cate_borrow = 0x0005;
    public static final int cate_mobile = 0x0006;
    public static final int cate_other = 0x0007;
  }

  //  public static class Category extends BaseBean {
  //    public static final int cate_salary = 0x0001;
  //    public static final int cate_borrow = 0x0002;
  //    public static final int cate_interest = 0x0003;
  //    public static final int cate_red = 0x0004;
  //    public static final int cate_back = 0x0005;
  //    public static final int cate_other = 0x0006;
  //  }
}
