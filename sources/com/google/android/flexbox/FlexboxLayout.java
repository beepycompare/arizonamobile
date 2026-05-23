package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.google.android.flexbox.FlexboxHelper;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class FlexboxLayout extends ViewGroup implements FlexContainer {
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    private int mAlignContent;
    private int mAlignItems;
    private Drawable mDividerDrawableHorizontal;
    private Drawable mDividerDrawableVertical;
    private int mDividerHorizontalHeight;
    private int mDividerVerticalWidth;
    private int mFlexDirection;
    private List<FlexLine> mFlexLines;
    private FlexboxHelper.FlexLinesResult mFlexLinesResult;
    private int mFlexWrap;
    private FlexboxHelper mFlexboxHelper;
    private int mJustifyContent;
    private int mMaxLine;
    private SparseIntArray mOrderCache;
    private int[] mReorderedIndices;
    private int mShowDividerHorizontal;
    private int mShowDividerVertical;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface DividerMode {
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getDecorationLengthCrossAxis(View view) {
        return 0;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void updateViewCache(int position, View view) {
    }

    public FlexboxLayout(Context context) {
        this(context, null);
    }

    public FlexboxLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlexboxLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mMaxLine = -1;
        this.mFlexboxHelper = new FlexboxHelper(this);
        this.mFlexLines = new ArrayList();
        this.mFlexLinesResult = new FlexboxHelper.FlexLinesResult();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.FlexboxLayout, defStyleAttr, 0);
        this.mFlexDirection = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_flexDirection, 0);
        this.mFlexWrap = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_flexWrap, 0);
        this.mJustifyContent = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_justifyContent, 0);
        this.mAlignItems = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_alignItems, 0);
        this.mAlignContent = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_alignContent, 0);
        this.mMaxLine = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_maxLine, -1);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawable);
        if (drawable != null) {
            setDividerDrawableHorizontal(drawable);
            setDividerDrawableVertical(drawable);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawableHorizontal);
        if (drawable2 != null) {
            setDividerDrawableHorizontal(drawable2);
        }
        Drawable drawable3 = obtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawableVertical);
        if (drawable3 != null) {
            setDividerDrawableVertical(drawable3);
        }
        int i = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDivider, 0);
        if (i != 0) {
            this.mShowDividerVertical = i;
            this.mShowDividerHorizontal = i;
        }
        int i2 = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDividerVertical, 0);
        if (i2 != 0) {
            this.mShowDividerVertical = i2;
        }
        int i3 = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDividerHorizontal, 0);
        if (i3 != 0) {
            this.mShowDividerHorizontal = i3;
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.mOrderCache == null) {
            this.mOrderCache = new SparseIntArray(getChildCount());
        }
        if (this.mFlexboxHelper.isOrderChangedFromLastMeasurement(this.mOrderCache)) {
            this.mReorderedIndices = this.mFlexboxHelper.createReorderedIndices(this.mOrderCache);
        }
        int i = this.mFlexDirection;
        if (i == 0 || i == 1) {
            measureHorizontal(widthMeasureSpec, heightMeasureSpec);
        } else if (i == 2 || i == 3) {
            measureVertical(widthMeasureSpec, heightMeasureSpec);
        } else {
            throw new IllegalStateException("Invalid value for the flex direction is set: " + this.mFlexDirection);
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexItemCount() {
        return getChildCount();
    }

    @Override // com.google.android.flexbox.FlexContainer
    public View getFlexItemAt(int index) {
        return getChildAt(index);
    }

    public View getReorderedChildAt(int index) {
        if (index >= 0) {
            int[] iArr = this.mReorderedIndices;
            if (index >= iArr.length) {
                return null;
            }
            return getChildAt(iArr[index]);
        }
        return null;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public View getReorderedFlexItemAt(int index) {
        return getReorderedChildAt(index);
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if (this.mOrderCache == null) {
            this.mOrderCache = new SparseIntArray(getChildCount());
        }
        this.mReorderedIndices = this.mFlexboxHelper.createReorderedIndices(child, index, params, this.mOrderCache);
        super.addView(child, index, params);
    }

    private void measureHorizontal(int widthMeasureSpec, int heightMeasureSpec) {
        this.mFlexLines.clear();
        this.mFlexLinesResult.reset();
        this.mFlexboxHelper.calculateHorizontalFlexLines(this.mFlexLinesResult, widthMeasureSpec, heightMeasureSpec);
        this.mFlexLines = this.mFlexLinesResult.mFlexLines;
        this.mFlexboxHelper.determineMainSize(widthMeasureSpec, heightMeasureSpec);
        if (this.mAlignItems == 3) {
            for (FlexLine flexLine : this.mFlexLines) {
                int i = Integer.MIN_VALUE;
                for (int i2 = 0; i2 < flexLine.mItemCount; i2++) {
                    View reorderedChildAt = getReorderedChildAt(flexLine.mFirstIndex + i2);
                    if (reorderedChildAt != null && reorderedChildAt.getVisibility() != 8) {
                        LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                        if (this.mFlexWrap != 2) {
                            i = Math.max(i, reorderedChildAt.getMeasuredHeight() + Math.max(flexLine.mMaxBaseline - reorderedChildAt.getBaseline(), layoutParams.topMargin) + layoutParams.bottomMargin);
                        } else {
                            i = Math.max(i, reorderedChildAt.getMeasuredHeight() + layoutParams.topMargin + Math.max((flexLine.mMaxBaseline - reorderedChildAt.getMeasuredHeight()) + reorderedChildAt.getBaseline(), layoutParams.bottomMargin));
                        }
                    }
                }
                flexLine.mCrossSize = i;
            }
        }
        this.mFlexboxHelper.determineCrossSize(widthMeasureSpec, heightMeasureSpec, getPaddingTop() + getPaddingBottom());
        this.mFlexboxHelper.stretchViews();
        setMeasuredDimensionForFlex(this.mFlexDirection, widthMeasureSpec, heightMeasureSpec, this.mFlexLinesResult.mChildState);
    }

    private void measureVertical(int widthMeasureSpec, int heightMeasureSpec) {
        this.mFlexLines.clear();
        this.mFlexLinesResult.reset();
        this.mFlexboxHelper.calculateVerticalFlexLines(this.mFlexLinesResult, widthMeasureSpec, heightMeasureSpec);
        this.mFlexLines = this.mFlexLinesResult.mFlexLines;
        this.mFlexboxHelper.determineMainSize(widthMeasureSpec, heightMeasureSpec);
        this.mFlexboxHelper.determineCrossSize(widthMeasureSpec, heightMeasureSpec, getPaddingLeft() + getPaddingRight());
        this.mFlexboxHelper.stretchViews();
        setMeasuredDimensionForFlex(this.mFlexDirection, widthMeasureSpec, heightMeasureSpec, this.mFlexLinesResult.mChildState);
    }

    private void setMeasuredDimensionForFlex(int flexDirection, int widthMeasureSpec, int heightMeasureSpec, int childState) {
        int sumOfCrossSize;
        int largestMainSize;
        int resolveSizeAndState;
        int resolveSizeAndState2;
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        if (flexDirection == 0 || flexDirection == 1) {
            sumOfCrossSize = getSumOfCrossSize() + getPaddingTop() + getPaddingBottom();
            largestMainSize = getLargestMainSize();
        } else if (flexDirection == 2 || flexDirection == 3) {
            sumOfCrossSize = getLargestMainSize();
            largestMainSize = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
        } else {
            throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < largestMainSize) {
                childState = View.combineMeasuredStates(childState, 16777216);
            } else {
                size = largestMainSize;
            }
            resolveSizeAndState = View.resolveSizeAndState(size, widthMeasureSpec, childState);
        } else if (mode == 0) {
            resolveSizeAndState = View.resolveSizeAndState(largestMainSize, widthMeasureSpec, childState);
        } else if (mode == 1073741824) {
            if (size < largestMainSize) {
                childState = View.combineMeasuredStates(childState, 16777216);
            }
            resolveSizeAndState = View.resolveSizeAndState(size, widthMeasureSpec, childState);
        } else {
            throw new IllegalStateException("Unknown width mode is set: " + mode);
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < sumOfCrossSize) {
                childState = View.combineMeasuredStates(childState, 256);
            } else {
                size2 = sumOfCrossSize;
            }
            resolveSizeAndState2 = View.resolveSizeAndState(size2, heightMeasureSpec, childState);
        } else if (mode2 == 0) {
            resolveSizeAndState2 = View.resolveSizeAndState(sumOfCrossSize, heightMeasureSpec, childState);
        } else if (mode2 == 1073741824) {
            if (size2 < sumOfCrossSize) {
                childState = View.combineMeasuredStates(childState, 256);
            }
            resolveSizeAndState2 = View.resolveSizeAndState(size2, heightMeasureSpec, childState);
        } else {
            throw new IllegalStateException("Unknown height mode is set: " + mode2);
        }
        setMeasuredDimension(resolveSizeAndState, resolveSizeAndState2);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getLargestMainSize() {
        int i = Integer.MIN_VALUE;
        for (FlexLine flexLine : this.mFlexLines) {
            i = Math.max(i, flexLine.mMainSize);
        }
        return i;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getSumOfCrossSize() {
        int i;
        int i2;
        int size = this.mFlexLines.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            FlexLine flexLine = this.mFlexLines.get(i4);
            if (hasDividerBeforeFlexLine(i4)) {
                if (isMainAxisDirectionHorizontal()) {
                    i2 = this.mDividerHorizontalHeight;
                } else {
                    i2 = this.mDividerVerticalWidth;
                }
                i3 += i2;
            }
            if (hasEndDividerAfterFlexLine(i4)) {
                if (isMainAxisDirectionHorizontal()) {
                    i = this.mDividerHorizontalHeight;
                } else {
                    i = this.mDividerVerticalWidth;
                }
                i3 += i;
            }
            i3 += flexLine.mCrossSize;
        }
        return i3;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public boolean isMainAxisDirectionHorizontal() {
        int i = this.mFlexDirection;
        return i == 0 || i == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        boolean z;
        FlexboxLayout flexboxLayout;
        int i;
        int i2;
        int i3;
        int i4;
        boolean z2;
        FlexboxLayout flexboxLayout2;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z3;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int i9 = this.mFlexDirection;
        if (i9 == 0) {
            if (layoutDirection == 1) {
                z = true;
                flexboxLayout = this;
                i = left;
                i4 = top;
                i3 = bottom;
                i2 = right;
            } else {
                z = false;
                flexboxLayout = this;
                i = left;
                i2 = right;
                i3 = bottom;
                i4 = top;
            }
            flexboxLayout.layoutHorizontal(z, i, i4, i2, i3);
        } else if (i9 != 1) {
            if (i9 == 2) {
                z3 = layoutDirection == 1;
                if (this.mFlexWrap == 2) {
                    z3 = !z3;
                }
                layoutVertical(z3, false, left, top, right, bottom);
            } else if (i9 == 3) {
                z3 = layoutDirection == 1;
                if (this.mFlexWrap == 2) {
                    z3 = !z3;
                }
                layoutVertical(z3, true, left, top, right, bottom);
            } else {
                throw new IllegalStateException("Invalid flex direction is set: " + this.mFlexDirection);
            }
        } else {
            if (layoutDirection != 1) {
                z2 = true;
                flexboxLayout2 = this;
                i5 = left;
                i8 = top;
                i7 = bottom;
                i6 = right;
            } else {
                z2 = false;
                flexboxLayout2 = this;
                i5 = left;
                i6 = right;
                i7 = bottom;
                i8 = top;
            }
            flexboxLayout2.layoutHorizontal(z2, i5, i8, i6, i7);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void layoutHorizontal(boolean isRtl, int left, int top, int right, int bottom) {
        float f;
        int i;
        float f2;
        float f3;
        int i2;
        boolean z;
        int i3;
        int i4;
        int i5;
        int i6;
        View view;
        FlexLine flexLine;
        int itemCountNotGone;
        int itemCountNotGone2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i7 = right - left;
        int paddingBottom = (bottom - top) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int size = this.mFlexLines.size();
        for (int i8 = 0; i8 < size; i8++) {
            FlexLine flexLine2 = this.mFlexLines.get(i8);
            if (hasDividerBeforeFlexLine(i8)) {
                int i9 = this.mDividerHorizontalHeight;
                paddingBottom -= i9;
                paddingTop += i9;
            }
            int i10 = paddingBottom;
            int i11 = this.mJustifyContent;
            char c = 4;
            int i12 = 2;
            boolean z2 = true;
            if (i11 == 0) {
                f = paddingLeft;
                i = i7 - paddingRight;
            } else if (i11 == 1) {
                f = (i7 - flexLine2.mMainSize) + paddingRight;
                i = flexLine2.mMainSize - paddingLeft;
            } else if (i11 == 2) {
                f = paddingLeft + ((i7 - flexLine2.mMainSize) / 2.0f);
                f2 = (i7 - paddingRight) - ((i7 - flexLine2.mMainSize) / 2.0f);
                f3 = 0.0f;
                float max = Math.max(f3, 0.0f);
                i2 = 0;
                while (i2 < flexLine2.mItemCount) {
                }
                paddingTop += flexLine2.mCrossSize;
                paddingBottom = i10 - flexLine2.mCrossSize;
            } else {
                if (i11 == 3) {
                    f = paddingLeft;
                    f3 = (i7 - flexLine2.mMainSize) / (flexLine2.getItemCountNotGone() != 1 ? itemCountNotGone - 1 : 1.0f);
                    f2 = i7 - paddingRight;
                } else if (i11 == 4) {
                    int itemCountNotGone3 = flexLine2.getItemCountNotGone();
                    float f4 = itemCountNotGone3 != 0 ? (i7 - flexLine2.mMainSize) / itemCountNotGone3 : 0.0f;
                    float f5 = f4 / 2.0f;
                    f = paddingLeft + f5;
                    float f6 = (i7 - paddingRight) - f5;
                    f3 = f4;
                    f2 = f6;
                } else if (i11 == 5) {
                    f3 = flexLine2.getItemCountNotGone() != 0 ? (i7 - flexLine2.mMainSize) / (itemCountNotGone2 + 1) : 0.0f;
                    f = paddingLeft + f3;
                    f2 = (i7 - paddingRight) - f3;
                } else {
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.mJustifyContent);
                }
                float max2 = Math.max(f3, 0.0f);
                i2 = 0;
                while (i2 < flexLine2.mItemCount) {
                    int i13 = flexLine2.mFirstIndex + i2;
                    View reorderedChildAt = getReorderedChildAt(i13);
                    char c2 = c;
                    if (reorderedChildAt != null) {
                        boolean z3 = z2;
                        if (reorderedChildAt.getVisibility() == 8) {
                            z = z3;
                        } else {
                            LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                            float f7 = f + layoutParams.leftMargin;
                            float f8 = f2 - layoutParams.rightMargin;
                            if (hasDividerBeforeChildAtAlongMainAxis(i13, i2)) {
                                int i14 = this.mDividerVerticalWidth;
                                float f9 = i14;
                                f7 += f9;
                                f8 -= f9;
                                i6 = i14;
                            } else {
                                i6 = 0;
                            }
                            float f10 = f8;
                            int i15 = (i2 != flexLine2.mItemCount + (-1) || (this.mShowDividerVertical & 4) <= 0) ? 0 : this.mDividerVerticalWidth;
                            if (this.mFlexWrap == i12) {
                                int i16 = i12;
                                FlexboxHelper flexboxHelper = this.mFlexboxHelper;
                                if (isRtl) {
                                    i4 = i16;
                                    i5 = i2;
                                    view = reorderedChildAt;
                                    z = z3;
                                    flexboxHelper.layoutSingleChildHorizontal(view, flexLine2, Math.round(f10) - reorderedChildAt.getMeasuredWidth(), i10 - reorderedChildAt.getMeasuredHeight(), Math.round(f10), i10);
                                } else {
                                    i5 = i2;
                                    view = reorderedChildAt;
                                    z = z3;
                                    i4 = i16;
                                    flexboxHelper.layoutSingleChildHorizontal(view, flexLine2, Math.round(f7), i10 - view.getMeasuredHeight(), Math.round(f7) + view.getMeasuredWidth(), i10);
                                }
                                i3 = i10;
                            } else {
                                i5 = i2;
                                view = reorderedChildAt;
                                z = z3;
                                i4 = i12;
                                i3 = i10;
                                FlexboxHelper flexboxHelper2 = this.mFlexboxHelper;
                                if (isRtl) {
                                    flexboxHelper2.layoutSingleChildHorizontal(view, flexLine2, Math.round(f10) - view.getMeasuredWidth(), paddingTop, Math.round(f10), paddingTop + view.getMeasuredHeight());
                                } else {
                                    int i17 = paddingTop;
                                    flexboxHelper2.layoutSingleChildHorizontal(view, flexLine2, Math.round(f7), i17, view.getMeasuredWidth() + Math.round(f7), i17 + view.getMeasuredHeight());
                                    paddingTop = i17;
                                }
                            }
                            f = f7 + view.getMeasuredWidth() + max2 + layoutParams.rightMargin;
                            float measuredWidth = f10 - ((view.getMeasuredWidth() + max2) + layoutParams.leftMargin);
                            if (isRtl) {
                                flexLine = flexLine2;
                                flexLine.updatePositionFromView(view, i15, 0, i6, 0);
                            } else {
                                flexLine = flexLine2;
                                flexLine.updatePositionFromView(view, i6, 0, i15, 0);
                            }
                            flexLine2 = flexLine;
                            f2 = measuredWidth;
                            i2 = i5 + 1;
                            c = c2;
                            i12 = i4;
                            z2 = z;
                            i10 = i3;
                        }
                    } else {
                        z = z2;
                    }
                    i4 = i12;
                    i5 = i2;
                    i3 = i10;
                    i2 = i5 + 1;
                    c = c2;
                    i12 = i4;
                    z2 = z;
                    i10 = i3;
                }
                paddingTop += flexLine2.mCrossSize;
                paddingBottom = i10 - flexLine2.mCrossSize;
            }
            f2 = i;
            f3 = 0.0f;
            float max22 = Math.max(f3, 0.0f);
            i2 = 0;
            while (i2 < flexLine2.mItemCount) {
            }
            paddingTop += flexLine2.mCrossSize;
            paddingBottom = i10 - flexLine2.mCrossSize;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void layoutVertical(boolean isRtl, boolean fromBottomToTop, int left, int top, int right, int bottom) {
        float f;
        int i;
        float f2;
        float f3;
        int i2;
        char c;
        int i3;
        int i4;
        int i5;
        int i6;
        FlexLine flexLine;
        int itemCountNotGone;
        int itemCountNotGone2;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i7 = bottom - top;
        int i8 = (right - left) - paddingRight;
        int size = this.mFlexLines.size();
        for (int i9 = 0; i9 < size; i9++) {
            FlexLine flexLine2 = this.mFlexLines.get(i9);
            if (hasDividerBeforeFlexLine(i9)) {
                int i10 = this.mDividerVerticalWidth;
                paddingLeft += i10;
                i8 -= i10;
            }
            int i11 = i8;
            int i12 = this.mJustifyContent;
            char c2 = 4;
            int i13 = 1;
            if (i12 == 0) {
                f = paddingTop;
                i = i7 - paddingBottom;
            } else if (i12 == 1) {
                f = (i7 - flexLine2.mMainSize) + paddingBottom;
                i = flexLine2.mMainSize - paddingTop;
            } else if (i12 == 2) {
                f = paddingTop + ((i7 - flexLine2.mMainSize) / 2.0f);
                f2 = (i7 - paddingBottom) - ((i7 - flexLine2.mMainSize) / 2.0f);
                f3 = 0.0f;
                float max = Math.max(f3, 0.0f);
                i2 = 0;
                while (i2 < flexLine2.mItemCount) {
                }
                paddingLeft += flexLine2.mCrossSize;
                i8 = i11 - flexLine2.mCrossSize;
            } else {
                if (i12 == 3) {
                    f = paddingTop;
                    f3 = (i7 - flexLine2.mMainSize) / (flexLine2.getItemCountNotGone() != 1 ? itemCountNotGone - 1 : 1.0f);
                    f2 = i7 - paddingBottom;
                } else if (i12 == 4) {
                    int itemCountNotGone3 = flexLine2.getItemCountNotGone();
                    f3 = itemCountNotGone3 != 0 ? (i7 - flexLine2.mMainSize) / itemCountNotGone3 : 0.0f;
                    float f4 = f3 / 2.0f;
                    f = paddingTop + f4;
                    f2 = (i7 - paddingBottom) - f4;
                } else if (i12 == 5) {
                    f3 = flexLine2.getItemCountNotGone() != 0 ? (i7 - flexLine2.mMainSize) / (itemCountNotGone2 + 1) : 0.0f;
                    f = paddingTop + f3;
                    f2 = (i7 - paddingBottom) - f3;
                } else {
                    throw new IllegalStateException("Invalid justifyContent is set: " + this.mJustifyContent);
                }
                float max2 = Math.max(f3, 0.0f);
                i2 = 0;
                while (i2 < flexLine2.mItemCount) {
                    int i14 = flexLine2.mFirstIndex + i2;
                    int i15 = i13;
                    View reorderedChildAt = getReorderedChildAt(i14);
                    if (reorderedChildAt != null) {
                        c = c2;
                        if (reorderedChildAt.getVisibility() != 8) {
                            LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                            float f5 = f + layoutParams.topMargin;
                            float f6 = f2 - layoutParams.bottomMargin;
                            if (hasDividerBeforeChildAtAlongMainAxis(i14, i2)) {
                                i6 = this.mDividerHorizontalHeight;
                                float f7 = i6;
                                f5 += f7;
                                f6 -= f7;
                            } else {
                                i6 = 0;
                            }
                            float f8 = f6;
                            int i16 = (i2 != flexLine2.mItemCount - i15 || (this.mShowDividerHorizontal & 4) <= 0) ? 0 : this.mDividerHorizontalHeight;
                            if (isRtl) {
                                int i17 = i2;
                                FlexboxHelper flexboxHelper = this.mFlexboxHelper;
                                if (fromBottomToTop) {
                                    i4 = i15;
                                    i3 = i17;
                                    flexboxHelper.layoutSingleChildVertical(reorderedChildAt, flexLine2, true, i11 - reorderedChildAt.getMeasuredWidth(), Math.round(f8) - reorderedChildAt.getMeasuredHeight(), i11, Math.round(f8));
                                } else {
                                    i3 = i17;
                                    i4 = i15;
                                    flexboxHelper.layoutSingleChildVertical(reorderedChildAt, flexLine2, true, i11 - reorderedChildAt.getMeasuredWidth(), Math.round(f5), i11, Math.round(f5) + reorderedChildAt.getMeasuredHeight());
                                }
                                i5 = i11;
                            } else {
                                i3 = i2;
                                i4 = i15;
                                i5 = i11;
                                FlexboxHelper flexboxHelper2 = this.mFlexboxHelper;
                                if (fromBottomToTop) {
                                    flexboxHelper2.layoutSingleChildVertical(reorderedChildAt, flexLine2, false, paddingLeft, Math.round(f8) - reorderedChildAt.getMeasuredHeight(), paddingLeft + reorderedChildAt.getMeasuredWidth(), Math.round(f8));
                                } else {
                                    int i18 = paddingLeft;
                                    flexboxHelper2.layoutSingleChildVertical(reorderedChildAt, flexLine2, false, i18, Math.round(f5), i18 + reorderedChildAt.getMeasuredWidth(), Math.round(f5) + reorderedChildAt.getMeasuredHeight());
                                    paddingLeft = i18;
                                }
                            }
                            f = f5 + reorderedChildAt.getMeasuredHeight() + max2 + layoutParams.bottomMargin;
                            float measuredHeight = f8 - ((reorderedChildAt.getMeasuredHeight() + max2) + layoutParams.topMargin);
                            if (fromBottomToTop) {
                                flexLine = flexLine2;
                                flexLine.updatePositionFromView(reorderedChildAt, 0, i16, 0, i6);
                            } else {
                                flexLine = flexLine2;
                                flexLine.updatePositionFromView(reorderedChildAt, 0, i6, 0, i16);
                            }
                            flexLine2 = flexLine;
                            f2 = measuredHeight;
                            i2 = i3 + 1;
                            c2 = c;
                            i13 = i4;
                            i11 = i5;
                        }
                    } else {
                        c = c2;
                    }
                    i3 = i2;
                    i4 = i15;
                    i5 = i11;
                    i2 = i3 + 1;
                    c2 = c;
                    i13 = i4;
                    i11 = i5;
                }
                paddingLeft += flexLine2.mCrossSize;
                i8 = i11 - flexLine2.mCrossSize;
            }
            f2 = i;
            f3 = 0.0f;
            float max22 = Math.max(f3, 0.0f);
            i2 = 0;
            while (i2 < flexLine2.mItemCount) {
            }
            paddingLeft += flexLine2.mCrossSize;
            i8 = i11 - flexLine2.mCrossSize;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mDividerDrawableVertical == null && this.mDividerDrawableHorizontal == null) {
            return;
        }
        if (this.mShowDividerHorizontal == 0 && this.mShowDividerVertical == 0) {
            return;
        }
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int i = this.mFlexDirection;
        if (i == 0) {
            drawDividersHorizontal(canvas, layoutDirection == 1, this.mFlexWrap == 2);
        } else if (i == 1) {
            drawDividersHorizontal(canvas, layoutDirection != 1, this.mFlexWrap == 2);
        } else if (i == 2) {
            boolean z = layoutDirection == 1;
            if (this.mFlexWrap == 2) {
                z = !z;
            }
            drawDividersVertical(canvas, z, false);
        } else if (i != 3) {
        } else {
            boolean z2 = layoutDirection == 1;
            if (this.mFlexWrap == 2) {
                z2 = !z2;
            }
            drawDividersVertical(canvas, z2, true);
        }
    }

    private void drawDividersHorizontal(Canvas canvas, boolean isRtl, boolean fromBottomToTop) {
        int i;
        int i2;
        int right;
        int left;
        int paddingLeft = getPaddingLeft();
        int max = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.mFlexLines.size();
        for (int i3 = 0; i3 < size; i3++) {
            FlexLine flexLine = this.mFlexLines.get(i3);
            for (int i4 = 0; i4 < flexLine.mItemCount; i4++) {
                int i5 = flexLine.mFirstIndex + i4;
                View reorderedChildAt = getReorderedChildAt(i5);
                if (reorderedChildAt != null && reorderedChildAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                    if (hasDividerBeforeChildAtAlongMainAxis(i5, i4)) {
                        if (isRtl) {
                            left = reorderedChildAt.getRight() + layoutParams.rightMargin;
                        } else {
                            left = (reorderedChildAt.getLeft() - layoutParams.leftMargin) - this.mDividerVerticalWidth;
                        }
                        drawVerticalDivider(canvas, left, flexLine.mTop, flexLine.mCrossSize);
                    }
                    if (i4 == flexLine.mItemCount - 1 && (this.mShowDividerVertical & 4) > 0) {
                        if (isRtl) {
                            right = (reorderedChildAt.getLeft() - layoutParams.leftMargin) - this.mDividerVerticalWidth;
                        } else {
                            right = reorderedChildAt.getRight() + layoutParams.rightMargin;
                        }
                        drawVerticalDivider(canvas, right, flexLine.mTop, flexLine.mCrossSize);
                    }
                }
            }
            if (hasDividerBeforeFlexLine(i3)) {
                if (fromBottomToTop) {
                    i2 = flexLine.mBottom;
                } else {
                    i2 = flexLine.mTop - this.mDividerHorizontalHeight;
                }
                drawHorizontalDivider(canvas, paddingLeft, i2, max);
            }
            if (hasEndDividerAfterFlexLine(i3) && (this.mShowDividerHorizontal & 4) > 0) {
                if (fromBottomToTop) {
                    i = flexLine.mTop - this.mDividerHorizontalHeight;
                } else {
                    i = flexLine.mBottom;
                }
                drawHorizontalDivider(canvas, paddingLeft, i, max);
            }
        }
    }

    private void drawDividersVertical(Canvas canvas, boolean isRtl, boolean fromBottomToTop) {
        int i;
        int i2;
        int bottom;
        int top;
        int paddingTop = getPaddingTop();
        int max = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.mFlexLines.size();
        for (int i3 = 0; i3 < size; i3++) {
            FlexLine flexLine = this.mFlexLines.get(i3);
            for (int i4 = 0; i4 < flexLine.mItemCount; i4++) {
                int i5 = flexLine.mFirstIndex + i4;
                View reorderedChildAt = getReorderedChildAt(i5);
                if (reorderedChildAt != null && reorderedChildAt.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) reorderedChildAt.getLayoutParams();
                    if (hasDividerBeforeChildAtAlongMainAxis(i5, i4)) {
                        if (fromBottomToTop) {
                            top = reorderedChildAt.getBottom() + layoutParams.bottomMargin;
                        } else {
                            top = (reorderedChildAt.getTop() - layoutParams.topMargin) - this.mDividerHorizontalHeight;
                        }
                        drawHorizontalDivider(canvas, flexLine.mLeft, top, flexLine.mCrossSize);
                    }
                    if (i4 == flexLine.mItemCount - 1 && (this.mShowDividerHorizontal & 4) > 0) {
                        if (fromBottomToTop) {
                            bottom = (reorderedChildAt.getTop() - layoutParams.topMargin) - this.mDividerHorizontalHeight;
                        } else {
                            bottom = reorderedChildAt.getBottom() + layoutParams.bottomMargin;
                        }
                        drawHorizontalDivider(canvas, flexLine.mLeft, bottom, flexLine.mCrossSize);
                    }
                }
            }
            if (hasDividerBeforeFlexLine(i3)) {
                if (isRtl) {
                    i2 = flexLine.mRight;
                } else {
                    i2 = flexLine.mLeft - this.mDividerVerticalWidth;
                }
                drawVerticalDivider(canvas, i2, paddingTop, max);
            }
            if (hasEndDividerAfterFlexLine(i3) && (this.mShowDividerVertical & 4) > 0) {
                if (isRtl) {
                    i = flexLine.mLeft - this.mDividerVerticalWidth;
                } else {
                    i = flexLine.mRight;
                }
                drawVerticalDivider(canvas, i, paddingTop, max);
            }
        }
    }

    private void drawVerticalDivider(Canvas canvas, int left, int top, int length) {
        Drawable drawable = this.mDividerDrawableVertical;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(left, top, this.mDividerVerticalWidth + left, length + top);
        this.mDividerDrawableVertical.draw(canvas);
    }

    private void drawHorizontalDivider(Canvas canvas, int left, int top, int length) {
        Drawable drawable = this.mDividerDrawableHorizontal;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(left, top, length + left, this.mDividerHorizontalHeight + top);
        this.mDividerDrawableHorizontal.draw(canvas);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams lp) {
        if (lp instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) lp);
        }
        if (lp instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) lp);
        }
        return new LayoutParams(lp);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexDirection() {
        return this.mFlexDirection;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setFlexDirection(int flexDirection) {
        if (this.mFlexDirection != flexDirection) {
            this.mFlexDirection = flexDirection;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getFlexWrap() {
        return this.mFlexWrap;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setFlexWrap(int flexWrap) {
        if (this.mFlexWrap != flexWrap) {
            this.mFlexWrap = flexWrap;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getJustifyContent() {
        return this.mJustifyContent;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setJustifyContent(int justifyContent) {
        if (this.mJustifyContent != justifyContent) {
            this.mJustifyContent = justifyContent;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getAlignItems() {
        return this.mAlignItems;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setAlignItems(int alignItems) {
        if (this.mAlignItems != alignItems) {
            this.mAlignItems = alignItems;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getAlignContent() {
        return this.mAlignContent;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setAlignContent(int alignContent) {
        if (this.mAlignContent != alignContent) {
            this.mAlignContent = alignContent;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getMaxLine() {
        return this.mMaxLine;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setMaxLine(int maxLine) {
        if (this.mMaxLine != maxLine) {
            this.mMaxLine = maxLine;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public List<FlexLine> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.mFlexLines.size());
        for (FlexLine flexLine : this.mFlexLines) {
            if (flexLine.getItemCountNotGone() != 0) {
                arrayList.add(flexLine);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getDecorationLengthMainAxis(View view, int index, int indexInFlexLine) {
        int i;
        int i2;
        if (isMainAxisDirectionHorizontal()) {
            i = hasDividerBeforeChildAtAlongMainAxis(index, indexInFlexLine) ? this.mDividerVerticalWidth : 0;
            if ((this.mShowDividerVertical & 4) <= 0) {
                return i;
            }
            i2 = this.mDividerVerticalWidth;
        } else {
            i = hasDividerBeforeChildAtAlongMainAxis(index, indexInFlexLine) ? this.mDividerHorizontalHeight : 0;
            if ((this.mShowDividerHorizontal & 4) <= 0) {
                return i;
            }
            i2 = this.mDividerHorizontalHeight;
        }
        return i + i2;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void onNewFlexLineAdded(FlexLine flexLine) {
        if (isMainAxisDirectionHorizontal()) {
            if ((this.mShowDividerVertical & 4) > 0) {
                flexLine.mMainSize += this.mDividerVerticalWidth;
                flexLine.mDividerLengthInMainSize += this.mDividerVerticalWidth;
            }
        } else if ((this.mShowDividerHorizontal & 4) > 0) {
            flexLine.mMainSize += this.mDividerHorizontalHeight;
            flexLine.mDividerLengthInMainSize += this.mDividerHorizontalHeight;
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getChildWidthMeasureSpec(int widthSpec, int padding, int childDimension) {
        return getChildMeasureSpec(widthSpec, padding, childDimension);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public int getChildHeightMeasureSpec(int heightSpec, int padding, int childDimension) {
        return getChildMeasureSpec(heightSpec, padding, childDimension);
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void onNewFlexItemAdded(View view, int index, int indexInFlexLine, FlexLine flexLine) {
        if (hasDividerBeforeChildAtAlongMainAxis(index, indexInFlexLine)) {
            if (isMainAxisDirectionHorizontal()) {
                flexLine.mMainSize += this.mDividerVerticalWidth;
                flexLine.mDividerLengthInMainSize += this.mDividerVerticalWidth;
                return;
            }
            flexLine.mMainSize += this.mDividerHorizontalHeight;
            flexLine.mDividerLengthInMainSize += this.mDividerHorizontalHeight;
        }
    }

    @Override // com.google.android.flexbox.FlexContainer
    public void setFlexLines(List<FlexLine> flexLines) {
        this.mFlexLines = flexLines;
    }

    @Override // com.google.android.flexbox.FlexContainer
    public List<FlexLine> getFlexLinesInternal() {
        return this.mFlexLines;
    }

    public Drawable getDividerDrawableHorizontal() {
        return this.mDividerDrawableHorizontal;
    }

    public Drawable getDividerDrawableVertical() {
        return this.mDividerDrawableVertical;
    }

    public void setDividerDrawable(Drawable divider) {
        setDividerDrawableHorizontal(divider);
        setDividerDrawableVertical(divider);
    }

    public void setDividerDrawableHorizontal(Drawable divider) {
        if (divider == this.mDividerDrawableHorizontal) {
            return;
        }
        this.mDividerDrawableHorizontal = divider;
        if (divider != null) {
            this.mDividerHorizontalHeight = divider.getIntrinsicHeight();
        } else {
            this.mDividerHorizontalHeight = 0;
        }
        setWillNotDrawFlag();
        requestLayout();
    }

    public void setDividerDrawableVertical(Drawable divider) {
        if (divider == this.mDividerDrawableVertical) {
            return;
        }
        this.mDividerDrawableVertical = divider;
        if (divider != null) {
            this.mDividerVerticalWidth = divider.getIntrinsicWidth();
        } else {
            this.mDividerVerticalWidth = 0;
        }
        setWillNotDrawFlag();
        requestLayout();
    }

    public int getShowDividerVertical() {
        return this.mShowDividerVertical;
    }

    public int getShowDividerHorizontal() {
        return this.mShowDividerHorizontal;
    }

    public void setShowDivider(int dividerMode) {
        setShowDividerVertical(dividerMode);
        setShowDividerHorizontal(dividerMode);
    }

    public void setShowDividerVertical(int dividerMode) {
        if (dividerMode != this.mShowDividerVertical) {
            this.mShowDividerVertical = dividerMode;
            requestLayout();
        }
    }

    public void setShowDividerHorizontal(int dividerMode) {
        if (dividerMode != this.mShowDividerHorizontal) {
            this.mShowDividerHorizontal = dividerMode;
            requestLayout();
        }
    }

    private void setWillNotDrawFlag() {
        if (this.mDividerDrawableHorizontal == null && this.mDividerDrawableVertical == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private boolean hasDividerBeforeChildAtAlongMainAxis(int index, int indexInFlexLine) {
        return allViewsAreGoneBefore(index, indexInFlexLine) ? isMainAxisDirectionHorizontal() ? (this.mShowDividerVertical & 1) != 0 : (this.mShowDividerHorizontal & 1) != 0 : isMainAxisDirectionHorizontal() ? (this.mShowDividerVertical & 2) != 0 : (this.mShowDividerHorizontal & 2) != 0;
    }

    private boolean allViewsAreGoneBefore(int index, int indexInFlexLine) {
        for (int i = 1; i <= indexInFlexLine; i++) {
            View reorderedChildAt = getReorderedChildAt(index - i);
            if (reorderedChildAt != null && reorderedChildAt.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private boolean hasDividerBeforeFlexLine(int flexLineIndex) {
        if (flexLineIndex >= 0 && flexLineIndex < this.mFlexLines.size()) {
            if (allFlexLinesAreDummyBefore(flexLineIndex)) {
                return isMainAxisDirectionHorizontal() ? (this.mShowDividerHorizontal & 1) != 0 : (this.mShowDividerVertical & 1) != 0;
            } else if (isMainAxisDirectionHorizontal()) {
                return (this.mShowDividerHorizontal & 2) != 0;
            } else if ((this.mShowDividerVertical & 2) != 0) {
                return true;
            }
        }
        return false;
    }

    private boolean allFlexLinesAreDummyBefore(int flexLineIndex) {
        for (int i = 0; i < flexLineIndex; i++) {
            if (this.mFlexLines.get(i).getItemCountNotGone() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean hasEndDividerAfterFlexLine(int flexLineIndex) {
        if (flexLineIndex >= 0 && flexLineIndex < this.mFlexLines.size()) {
            for (int i = flexLineIndex + 1; i < this.mFlexLines.size(); i++) {
                if (this.mFlexLines.get(i).getItemCountNotGone() > 0) {
                    return false;
                }
            }
            if (isMainAxisDirectionHorizontal()) {
                return (this.mShowDividerHorizontal & 4) != 0;
            } else if ((this.mShowDividerVertical & 4) != 0) {
                return true;
            }
        }
        return false;
    }

    /* loaded from: classes4.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new Parcelable.Creator<LayoutParams>() { // from class: com.google.android.flexbox.FlexboxLayout.LayoutParams.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LayoutParams createFromParcel(Parcel source) {
                return new LayoutParams(source);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LayoutParams[] newArray(int size) {
                return new LayoutParams[size];
            }
        };
        private int mAlignSelf;
        private float mFlexBasisPercent;
        private float mFlexGrow;
        private float mFlexShrink;
        private int mMaxHeight;
        private int mMaxWidth;
        private int mMinHeight;
        private int mMinWidth;
        private int mOrder;
        private boolean mWrapBefore;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public LayoutParams(Context context, AttributeSet attrs) {
            super(context, attrs);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.FlexboxLayout_Layout);
            this.mOrder = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_Layout_layout_order, 1);
            this.mFlexGrow = obtainStyledAttributes.getFloat(R.styleable.FlexboxLayout_Layout_layout_flexGrow, 0.0f);
            this.mFlexShrink = obtainStyledAttributes.getFloat(R.styleable.FlexboxLayout_Layout_layout_flexShrink, 1.0f);
            this.mAlignSelf = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_Layout_layout_alignSelf, -1);
            this.mFlexBasisPercent = obtainStyledAttributes.getFraction(R.styleable.FlexboxLayout_Layout_layout_flexBasisPercent, 1, 1, -1.0f);
            this.mMinWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_minWidth, -1);
            this.mMinHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_minHeight, -1);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_maxWidth, 16777215);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_maxHeight, 16777215);
            this.mWrapBefore = obtainStyledAttributes.getBoolean(R.styleable.FlexboxLayout_Layout_layout_wrapBefore, false);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(LayoutParams source) {
            super((ViewGroup.MarginLayoutParams) source);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            this.mOrder = source.mOrder;
            this.mFlexGrow = source.mFlexGrow;
            this.mFlexShrink = source.mFlexShrink;
            this.mAlignSelf = source.mAlignSelf;
            this.mFlexBasisPercent = source.mFlexBasisPercent;
            this.mMinWidth = source.mMinWidth;
            this.mMinHeight = source.mMinHeight;
            this.mMaxWidth = source.mMaxWidth;
            this.mMaxHeight = source.mMaxHeight;
            this.mWrapBefore = source.mWrapBefore;
        }

        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(int width, int height) {
            super(new ViewGroup.LayoutParams(width, height));
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams source) {
            super(source);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return this.width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setWidth(int width) {
            this.width = width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return this.height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setHeight(int height) {
            this.height = height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return this.mOrder;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setOrder(int order) {
            this.mOrder = order;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexGrow() {
            return this.mFlexGrow;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexGrow(float flexGrow) {
            this.mFlexGrow = flexGrow;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexShrink() {
            return this.mFlexShrink;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexShrink(float flexShrink) {
            this.mFlexShrink = flexShrink;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getAlignSelf() {
            return this.mAlignSelf;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setAlignSelf(int alignSelf) {
            this.mAlignSelf = alignSelf;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinWidth() {
            return this.mMinWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinWidth(int minWidth) {
            this.mMinWidth = minWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinHeight() {
            return this.mMinHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinHeight(int minHeight) {
            this.mMinHeight = minHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxWidth() {
            return this.mMaxWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMaxWidth(int maxWidth) {
            this.mMaxWidth = maxWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxHeight() {
            return this.mMaxHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMaxHeight(int maxHeight) {
            this.mMaxHeight = maxHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public boolean isWrapBefore() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setWrapBefore(boolean wrapBefore) {
            this.mWrapBefore = wrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexBasisPercent() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexBasisPercent(float flexBasisPercent) {
            this.mFlexBasisPercent = flexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return this.leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginTop() {
            return this.topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return this.rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginBottom() {
            return this.bottomMargin;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.mOrder);
            dest.writeFloat(this.mFlexGrow);
            dest.writeFloat(this.mFlexShrink);
            dest.writeInt(this.mAlignSelf);
            dest.writeFloat(this.mFlexBasisPercent);
            dest.writeInt(this.mMinWidth);
            dest.writeInt(this.mMinHeight);
            dest.writeInt(this.mMaxWidth);
            dest.writeInt(this.mMaxHeight);
            dest.writeByte(this.mWrapBefore ? (byte) 1 : (byte) 0);
            dest.writeInt(this.bottomMargin);
            dest.writeInt(this.leftMargin);
            dest.writeInt(this.rightMargin);
            dest.writeInt(this.topMargin);
            dest.writeInt(this.height);
            dest.writeInt(this.width);
        }

        protected LayoutParams(Parcel in) {
            super(0, 0);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            this.mOrder = in.readInt();
            this.mFlexGrow = in.readFloat();
            this.mFlexShrink = in.readFloat();
            this.mAlignSelf = in.readInt();
            this.mFlexBasisPercent = in.readFloat();
            this.mMinWidth = in.readInt();
            this.mMinHeight = in.readInt();
            this.mMaxWidth = in.readInt();
            this.mMaxHeight = in.readInt();
            this.mWrapBefore = in.readByte() != 0;
            this.bottomMargin = in.readInt();
            this.leftMargin = in.readInt();
            this.rightMargin = in.readInt();
            this.topMargin = in.readInt();
            this.height = in.readInt();
            this.width = in.readInt();
        }
    }
}
