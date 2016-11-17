package com.hayukleung.grandet.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.UiThread;
import android.util.AttributeSet;

/**
 * Grandet
 * com.hayukleung.grandet.ui.view
 * Password.java
 *
 * by hayukleung
 * at 2016-11-15 19:01
 */

/**
 * PIN Code 输入框
 */
public class Password extends KeyboardView {

  private int mUnitSize;
  private Paint mPaint;
  private RectF mRectF1;
  private RectF mRectF2;
  private RectF mRectF3;
  private RectF mRectF4;

  private PasswordHelper mPasswordHelper;

  public Password(Context context) {
    this(context, null);
  }

  public Password(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public Password(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  /**
   * Compare to: {@link android.view.View#getDefaultSize(int, int)}
   * If mode is AT_MOST, return the child size instead of the parent size
   * (unless it is too big).
   */
  private static int getDefaultSize2(int size, int measureSpec) {
    int result = size;
    int specMode = MeasureSpec.getMode(measureSpec);
    int specSize = MeasureSpec.getSize(measureSpec);

    switch (specMode) {
      case MeasureSpec.UNSPECIFIED:
        result = size;
        break;
      case MeasureSpec.AT_MOST:
        result = Math.min(size, specSize);
        break;
      case MeasureSpec.EXACTLY:
        result = specSize;
        break;
    }
    return result;
  }

  /**
   * 清除密码
   */
  public void clear() {
    getContentStack().clear();
    invalidate();
  }

  public void setPasswordHelper(PasswordHelper passwordHelper) {
    mPasswordHelper = passwordHelper;
  }

  private void init() {

  }

  @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    setMeasuredDimension(getDefaultSize2(getSuggestedMinimumWidth(), widthMeasureSpec),
        getDefaultSize2(getSuggestedMinimumHeight(), heightMeasureSpec));
    int width = getMeasuredWidth();
    int height = (int) (width / 3.7f);
    mUnitSize = height;
    widthMeasureSpec = MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY);
    heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
  }

  @Override protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
    super.onLayout(changed, left, top, right, bottom);
  }

  @Override protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    if (null == mPaint) {
      mPaint = new Paint();
    }

    mPaint.setAntiAlias(true);
    mPaint.setStyle(Paint.Style.STROKE);

    mPaint.setColor(Color.argb(0xff, 0x8f, 0x8f, 0x8f));

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      canvas.drawRoundRect(mUnitSize * 0.1f, mUnitSize * 0.1f, mUnitSize * 0.9f, mUnitSize * 0.9f,
          mUnitSize * 0.1f, mUnitSize * 0.1f, mPaint);
      canvas.drawRoundRect(mUnitSize, mUnitSize * 0.1f, mUnitSize * 1.8f, mUnitSize * 0.9f,
          mUnitSize * 0.1f, mUnitSize * 0.1f, mPaint);
      canvas.drawRoundRect(mUnitSize * 1.9f, mUnitSize * 0.1f, mUnitSize * 2.7f, mUnitSize * 0.9f,
          mUnitSize * 0.1f, mUnitSize * 0.1f, mPaint);
      canvas.drawRoundRect(mUnitSize * 2.8f, mUnitSize * 0.1f, mUnitSize * 3.6f, mUnitSize * 0.9f,
          mUnitSize * 0.1f, mUnitSize * 0.1f, mPaint);
    } else {
      if (null == mRectF1) {
        mRectF1 = new RectF(mUnitSize * 0.1f, mUnitSize * 0.1f, mUnitSize * 0.9f, mUnitSize * 0.9f);
      }
      canvas.drawRoundRect(mRectF1, mUnitSize * 0.1f, mUnitSize * 0.1f, mPaint);
      if (null == mRectF2) {
        mRectF2 = new RectF(mUnitSize, mUnitSize * 0.1f, mUnitSize * 0.8f, mUnitSize * 0.9f);
      }
      canvas.drawRoundRect(mRectF2, mUnitSize * 0.1f, mUnitSize * 0.1f, mPaint);
      if (null == mRectF3) {
        mRectF3 = new RectF(mUnitSize * 1.9f, mUnitSize * 0.1f, mUnitSize * 2.7f, mUnitSize * 0.9f);
      }
      canvas.drawRoundRect(mRectF3, mUnitSize * 0.1f, mUnitSize * 0.1f, mPaint);
      if (null == mRectF4) {
        mRectF4 = new RectF(mUnitSize * 2.8f, mUnitSize * 0.1f, mUnitSize * 3.6f, mUnitSize * 0.9f);
      }
      canvas.drawRoundRect(mRectF4, mUnitSize * 0.1f, mUnitSize * 0.1f, mPaint);
    }

    mPaint.setColor(Color.argb(0xff, 0x00, 0x00, 0x00));
    mPaint.setStyle(Paint.Style.FILL);

    switch (getContentStack().size()) {
      case 0: {
        break;
      }
      case 1: {
        canvas.drawCircle(mUnitSize * 0.5f, mUnitSize * 0.5f, dp2px(10), mPaint);
        break;
      }
      case 2: {
        canvas.drawCircle(mUnitSize * 0.5f, mUnitSize * 0.5f, dp2px(10), mPaint);
        canvas.drawCircle(mUnitSize * 1.4f, mUnitSize * 0.5f, dp2px(10), mPaint);
        break;
      }
      case 3: {
        canvas.drawCircle(mUnitSize * 0.5f, mUnitSize * 0.5f, dp2px(10), mPaint);
        canvas.drawCircle(mUnitSize * 1.4f, mUnitSize * 0.5f, dp2px(10), mPaint);
        canvas.drawCircle(mUnitSize * 2.3f, mUnitSize * 0.5f, dp2px(10), mPaint);
        break;
      }
      case 4: {
        canvas.drawCircle(mUnitSize * 0.5f, mUnitSize * 0.5f, dp2px(10), mPaint);
        canvas.drawCircle(mUnitSize * 1.4f, mUnitSize * 0.5f, dp2px(10), mPaint);
        canvas.drawCircle(mUnitSize * 2.3f, mUnitSize * 0.5f, dp2px(10), mPaint);
        canvas.drawCircle(mUnitSize * 3.2f, mUnitSize * 0.5f, dp2px(10), mPaint);
        break;
      }
      default: {
        throw new RuntimeException("Password Length Exception.");
      }
    }
  }

  @Override public int getLimit() {
    return 4;
  }

  @Override public boolean acceptKeySkip() {
    return 0 < getLimit() && getLimit() == getContentStack().size();
  }

  @Override public void acceptKey0() {
    getContentStack().push("0");
  }

  @Override public void acceptKey1() {
    getContentStack().push("1");
  }

  @Override public void acceptKey2() {
    getContentStack().push("2");
  }

  @Override public void acceptKey3() {
    getContentStack().push("3");
  }

  @Override public void acceptKey4() {
    getContentStack().push("4");
  }

  @Override public void acceptKey5() {
    getContentStack().push("5");
  }

  @Override public void acceptKey6() {
    getContentStack().push("6");
  }

  @Override public void acceptKey7() {
    getContentStack().push("7");
  }

  @Override public void acceptKey8() {
    getContentStack().push("8");
  }

  @Override public void acceptKey9() {
    getContentStack().push("9");
  }

  @Override public void acceptKeyDot() {
  }

  @Override public void acceptKeyDel() {
  }

  @Override public void acceptKeyDelLong() {
  }

  @Override public void acceptKeyEnter() {
  }

  @Override public void acceptSuccessfully() {
    invalidate();

    postDelayed(new Runnable() {
      @Override public void run() {
        if (getLimit() == getContentStack().size()) {
          // 密码录入完成
          if (null != mPasswordHelper) {

            String p4 = getContentStack().pop();
            String p3 = getContentStack().pop();
            String p2 = getContentStack().pop();
            String p1 = getContentStack().pop();

            mPasswordHelper.onPasswordTyped(p1 + p2 + p3 + p4);
          }
        }
      }
    }, 200);
  }

  /**
   * 根据设备屏幕密度将dp转换为px
   *
   * @param valueDp
   * @return
   */
  public int dp2px(float valueDp) {
    return (int) (valueDp * getResources().getDisplayMetrics().density + 0.5f);
  }

  public interface PasswordHelper {
    @UiThread void onPasswordTyped(String password);
  }
}
