package com.hayukleung.grandet.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

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
public class Password extends View {

  private int mUnitSize;
  private Paint mPaint;
  private RectF mRectF1;
  private RectF mRectF2;
  private RectF mRectF3;
  private RectF mRectF4;

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
  }
}
