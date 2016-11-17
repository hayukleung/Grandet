package com.hayukleung.grandet.ui.view;

import android.app.Service;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Grandet
 * com.hayukleung.grandet.ui.view
 * Keyboard.java
 *
 * by hayukleung
 * at 2016-11-15 18:57
 */

public class Keyboard extends View implements Key {

  private Rect mRect0, mRect1, mRect2, mRect3, mRect4, mRect5, mRect6, mRect7, mRect8, mRect9,
      mRectDot, mRectDel, mRectEnter;

  private int mUnitWidth, mUnitHeight;
  private Paint mPaint;
  private int mCurrentKey = KEY_INVALID;

  private KeyboardHelper mKeyboardHelper;

  private Vibrator mVibrator;

  /**
   * 是否可以长按
   */
  private boolean mLongClickable = false;
  /**
   * 是否捕获了长按事件
   */
  private boolean mLongClicked = false;

  public Keyboard(Context context) {
    this(context, null);
  }

  public Keyboard(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public Keyboard(Context context, AttributeSet attrs, int defStyleAttr) {
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

  public void refresh() {
    mCurrentKey = KEY_INVALID;
    invalidate();
  }

  public void setKeyboardHelper(KeyboardHelper keyboardHelper) {
    mKeyboardHelper = keyboardHelper;
  }

  private void init() {
  }

  private void vibrate() {
    if (null == mVibrator) {
      mVibrator = (Vibrator) getContext().getSystemService(Service.VIBRATOR_SERVICE);
    }
    mVibrator.vibrate(20);
  }

  @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    setMeasuredDimension(getDefaultSize2(getSuggestedMinimumWidth(), widthMeasureSpec),
        getDefaultSize2(getSuggestedMinimumHeight(), heightMeasureSpec));
    int width = getMeasuredWidth();
    int height = width / 4 * 3;
    mUnitWidth = width / 4;
    mUnitHeight = height / 4;
    widthMeasureSpec = MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY);
    heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
  }

  @Override protected void onLayout(boolean changed, int l, int t, int r, int b) {
    super.onLayout(changed, l, t, r, b);
  }

  @Override protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    if (null == mPaint) {
      mPaint = new Paint();
    }

    mPaint.setAntiAlias(true);
    mPaint.setStyle(Paint.Style.FILL);

    canvas.drawColor(Color.argb(0xff, 0xff, 0xff, 0xff));

    mPaint.setColor(Color.argb(0x3f, 0xaf, 0xaf, 0xaf));

    switch (mCurrentKey) {
      case KEY_0: {
        if (null == mRect0) {
          mRect0 = new Rect(mUnitWidth, mUnitHeight * 3, mUnitWidth * 2, mUnitHeight * 4);
        }
        canvas.drawRect(mRect0, mPaint);
        break;
      }
      case KEY_1: {
        if (null == mRect1) {
          mRect1 = new Rect(0, 0, mUnitWidth, mUnitHeight);
        }
        canvas.drawRect(mRect1, mPaint);
        break;
      }
      case KEY_2: {
        if (null == mRect2) {
          mRect2 = new Rect(mUnitWidth, 0, mUnitWidth * 2, mUnitHeight);
        }
        canvas.drawRect(mRect2, mPaint);
        break;
      }
      case KEY_3: {
        if (null == mRect3) {
          mRect3 = new Rect(mUnitWidth * 2, 0, mUnitWidth * 3, mUnitHeight);
        }
        canvas.drawRect(mRect3, mPaint);
        break;
      }
      case KEY_4: {
        if (null == mRect4) {
          mRect4 = new Rect(0, mUnitHeight, mUnitWidth, mUnitHeight * 2);
        }
        canvas.drawRect(mRect4, mPaint);
        break;
      }
      case KEY_5: {
        if (null == mRect5) {
          mRect5 = new Rect(mUnitWidth, mUnitHeight, mUnitWidth * 2, mUnitHeight * 2);
        }
        canvas.drawRect(mRect5, mPaint);
        break;
      }
      case KEY_6: {
        if (null == mRect6) {
          mRect6 = new Rect(mUnitWidth * 2, mUnitHeight, mUnitWidth * 3, mUnitHeight * 2);
        }
        canvas.drawRect(mRect6, mPaint);
        break;
      }
      case KEY_7: {
        if (null == mRect7) {
          mRect7 = new Rect(0, mUnitHeight * 2, mUnitWidth, mUnitHeight * 3);
        }
        canvas.drawRect(mRect7, mPaint);
        break;
      }
      case KEY_8: {
        if (null == mRect8) {
          mRect8 = new Rect(mUnitWidth, mUnitHeight * 2, mUnitWidth * 2, mUnitHeight * 3);
        }
        canvas.drawRect(mRect8, mPaint);
        break;
      }
      case KEY_9: {
        if (null == mRect9) {
          mRect9 = new Rect(mUnitWidth * 2, mUnitHeight * 2, mUnitWidth * 3, mUnitHeight * 3);
        }
        canvas.drawRect(mRect9, mPaint);
        break;
      }
      case KEY_DOT: {
        if (null == mRectDot) {
          mRectDot = new Rect(0, mUnitHeight * 3, mUnitWidth, mUnitHeight * 4);
        }
        canvas.drawRect(mRectDot, mPaint);
        break;
      }
      case KEY_DEL: {
        if (null == mRectDel) {
          mRectDel = new Rect(mUnitWidth * 3, 0, mUnitWidth * 4, mUnitHeight * 3);
        }
        canvas.drawRect(mRectDel, mPaint);
        break;
      }
      case KEY_ENTER: {
        if (null == mRectEnter) {
          mRectEnter = new Rect(mUnitWidth * 2, mUnitHeight * 3, mUnitWidth * 4, mUnitHeight * 4);
        }
        canvas.drawRect(mRectEnter, mPaint);
        break;
      }
      case KEY_INVALID:
      default: {

        break;
      }
    }

    mPaint.setTextAlign(Paint.Align.CENTER);
    mPaint.setFakeBoldText(true);
    mPaint.setTextSize(sp2px(28));
    mPaint.setColor(Color.argb(0xaf, 0x22, 0x22, 0x22));

    canvas.drawText("1", mUnitWidth * 0.5f, mUnitHeight * 0.6f, mPaint);
    canvas.drawText("2", mUnitWidth * 1.5f, mUnitHeight * 0.6f, mPaint);
    canvas.drawText("3", mUnitWidth * 2.5f, mUnitHeight * 0.6f, mPaint);

    canvas.drawText("4", mUnitWidth * 0.5f, mUnitHeight * 1.6f, mPaint);
    canvas.drawText("5", mUnitWidth * 1.5f, mUnitHeight * 1.6f, mPaint);
    canvas.drawText("6", mUnitWidth * 2.5f, mUnitHeight * 1.6f, mPaint);

    canvas.drawText("7", mUnitWidth * 0.5f, mUnitHeight * 2.6f, mPaint);
    canvas.drawText("8", mUnitWidth * 1.5f, mUnitHeight * 2.6f, mPaint);
    canvas.drawText("9", mUnitWidth * 2.5f, mUnitHeight * 2.6f, mPaint);

    canvas.drawText(".", mUnitWidth * 0.5f, mUnitHeight * 3.6f, mPaint);
    canvas.drawText("0", mUnitWidth * 1.5f, mUnitHeight * 3.6f, mPaint);

    mPaint.setTextSize(sp2px(22));

    canvas.drawText("DONE", mUnitWidth * 3, mUnitHeight * 3.6f, mPaint);
    canvas.drawText("BACK", mUnitWidth * 3.5f, mUnitHeight * 1.6f, mPaint);
  }

  @Override public boolean onTouchEvent(MotionEvent event) {

    switch (event.getAction()) {
      case MotionEvent.ACTION_DOWN: {

        mCurrentKey = getCurrentKey(event);
        invalidate();

        if (KEY_DEL == mCurrentKey) {
          mLongClickable = true;
          postDelayed(new Runnable() {
            @Override public void run() {
              if (KEY_DEL == mCurrentKey && mLongClickable) {
                // 长按事件生效
                mLongClickable = false;
                mCurrentKey = KEY_DEL_LONG;
                vibrate();
                mKeyboardHelper.onKeySure(mCurrentKey);
                mLongClicked = true;
              }
            }
          }, 600);
        }
        break;
      }
      case MotionEvent.ACTION_MOVE: {
        if (mCurrentKey != getCurrentKey(event)) {
          mLongClickable = false;
        }
        mCurrentKey = getCurrentKey(event);
        invalidate();
        break;
      }
      case MotionEvent.ACTION_UP: {
        mLongClickable = false;
        if (null != mKeyboardHelper) {
          if (KEY_DEL_LONG == mCurrentKey) {
          } else {
            if (mLongClicked) {
              mLongClicked = false;
            } else {
              vibrate();
              mKeyboardHelper.onKeySure(getCurrentKey(event));
            }
          }
        }
        mCurrentKey = KEY_INVALID;
        invalidate();
        break;
      }
    }
    return true;
  }

  private int getCurrentKey(MotionEvent event) {
    int currentKey;
    int px, py;

    if (event.getX() < 0 || event.getY() < 0) {
      return mCurrentKey;
    }

    px = ((int) event.getX()) / mUnitWidth;
    py = ((int) event.getY()) / mUnitHeight;

    // Log.e("", "eX --> " + event.getX());
    // Log.e("", "eY --> " + event.getY());
    // Log.e("", "pX --> " + px);
    // Log.e("", "pY --> " + py);
    // Log.e("", "");

    switch (px) {
      case 0: {
        switch (py) {
          case 0: {
            currentKey = KEY_1;
            break;
          }
          case 1: {
            currentKey = KEY_4;
            break;
          }
          case 2: {
            currentKey = KEY_7;
            break;
          }
          case 3: {
            currentKey = KEY_DOT;
            break;
          }
          default: {
            currentKey = mCurrentKey;
            break;
          }
        }
        break;
      }
      case 1: {
        switch (py) {
          case 0: {
            currentKey = KEY_2;
            break;
          }
          case 1: {
            currentKey = KEY_5;
            break;
          }
          case 2: {
            currentKey = KEY_8;
            break;
          }
          case 3: {
            currentKey = KEY_0;
            break;
          }
          default: {
            currentKey = mCurrentKey;
            break;
          }
        }
        break;
      }
      case 2: {
        switch (py) {
          case 0: {
            currentKey = KEY_3;
            break;
          }
          case 1: {
            currentKey = KEY_6;
            break;
          }
          case 2: {
            currentKey = KEY_9;
            break;
          }
          case 3: {
            currentKey = KEY_ENTER;
            break;
          }
          default: {
            currentKey = mCurrentKey;
            break;
          }
        }
        break;
      }
      case 3: {
        switch (py) {
          case 0:
          case 1:
          case 2: {
            currentKey = KEY_DEL;
            break;
          }
          case 3: {
            currentKey = KEY_ENTER;
            break;
          }
          default: {
            currentKey = mCurrentKey;
            break;
          }
        }
        break;
      }
      default: {
        currentKey = mCurrentKey;
        break;
      }
    }
    return currentKey;
  }

  /**
   * 根据设备屏幕密度将sp转换为px
   *
   * @param valueSp
   * @return
   */
  public int sp2px(float valueSp) {
    return (int) (valueSp * getResources().getDisplayMetrics().scaledDensity + 0.5f);
  }

  public interface KeyboardHelper {
    void onKeySure(int key);
  }
}
