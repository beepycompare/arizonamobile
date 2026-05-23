package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
/* loaded from: classes4.dex */
public class FlexboxItemDecoration extends RecyclerView.ItemDecoration {
    public static final int BOTH = 3;
    public static final int HORIZONTAL = 1;
    private static final int[] LIST_DIVIDER_ATTRS = {16843284};
    public static final int VERTICAL = 2;
    private Drawable mDrawable;
    private int mOrientation;

    public FlexboxItemDecoration(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(LIST_DIVIDER_ATTRS);
        this.mDrawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        setOrientation(3);
    }

    public void setDrawable(Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("Drawable cannot be null.");
        }
        this.mDrawable = drawable;
    }

    public void setOrientation(int orientation) {
        this.mOrientation = orientation;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        drawHorizontalDecorations(canvas, parent);
        drawVerticalDecorations(canvas, parent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        if (childAdapterPosition == 0) {
            return;
        }
        if (!needsHorizontalDecoration() && !needsVerticalDecoration()) {
            outRect.set(0, 0, 0, 0);
            return;
        }
        FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) parent.getLayoutManager();
        List<FlexLine> flexLines = flexboxLayoutManager.getFlexLines();
        setOffsetAlongMainAxis(outRect, childAdapterPosition, flexboxLayoutManager, flexLines, flexboxLayoutManager.getFlexDirection());
        setOffsetAlongCrossAxis(outRect, childAdapterPosition, flexboxLayoutManager, flexLines);
    }

    private void setOffsetAlongCrossAxis(Rect outRect, int position, FlexboxLayoutManager layoutManager, List<FlexLine> flexLines) {
        if (flexLines.size() == 0 || layoutManager.getPositionToFlexLineIndex(position) == 0) {
            return;
        }
        if (layoutManager.isMainAxisDirectionHorizontal()) {
            if (!needsHorizontalDecoration()) {
                outRect.top = 0;
                outRect.bottom = 0;
                return;
            }
            outRect.top = this.mDrawable.getIntrinsicHeight();
            outRect.bottom = 0;
        } else if (needsVerticalDecoration()) {
            boolean isLayoutRtl = layoutManager.isLayoutRtl();
            Drawable drawable = this.mDrawable;
            if (isLayoutRtl) {
                outRect.right = drawable.getIntrinsicWidth();
                outRect.left = 0;
                return;
            }
            outRect.left = drawable.getIntrinsicWidth();
            outRect.right = 0;
        }
    }

    private void setOffsetAlongMainAxis(Rect outRect, int position, FlexboxLayoutManager layoutManager, List<FlexLine> flexLines, int flexDirection) {
        if (isFirstItemInLine(position, flexLines, layoutManager)) {
            return;
        }
        if (layoutManager.isMainAxisDirectionHorizontal()) {
            if (!needsVerticalDecoration()) {
                outRect.left = 0;
                outRect.right = 0;
                return;
            }
            boolean isLayoutRtl = layoutManager.isLayoutRtl();
            Drawable drawable = this.mDrawable;
            if (isLayoutRtl) {
                outRect.right = drawable.getIntrinsicWidth();
                outRect.left = 0;
                return;
            }
            outRect.left = drawable.getIntrinsicWidth();
            outRect.right = 0;
        } else if (!needsHorizontalDecoration()) {
            outRect.top = 0;
            outRect.bottom = 0;
        } else {
            Drawable drawable2 = this.mDrawable;
            if (flexDirection == 3) {
                outRect.bottom = drawable2.getIntrinsicHeight();
                outRect.top = 0;
                return;
            }
            outRect.top = drawable2.getIntrinsicHeight();
            outRect.bottom = 0;
        }
    }

    private void drawVerticalDecorations(Canvas canvas, RecyclerView parent) {
        int left;
        int intrinsicWidth;
        int max;
        int bottom;
        int i;
        int i2;
        if (needsVerticalDecoration()) {
            FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) parent.getLayoutManager();
            int top = parent.getTop() - parent.getPaddingTop();
            int bottom2 = parent.getBottom() + parent.getPaddingBottom();
            int childCount = parent.getChildCount();
            int flexDirection = flexboxLayoutManager.getFlexDirection();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = parent.getChildAt(i3);
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                if (flexboxLayoutManager.isLayoutRtl()) {
                    intrinsicWidth = childAt.getRight() + layoutParams.rightMargin;
                    left = this.mDrawable.getIntrinsicWidth() + intrinsicWidth;
                } else {
                    left = childAt.getLeft() - layoutParams.leftMargin;
                    intrinsicWidth = left - this.mDrawable.getIntrinsicWidth();
                }
                if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
                    max = childAt.getTop() - layoutParams.topMargin;
                    bottom = childAt.getBottom();
                    i = layoutParams.bottomMargin;
                } else if (flexDirection == 3) {
                    int min = Math.min(childAt.getBottom() + layoutParams.bottomMargin + this.mDrawable.getIntrinsicHeight(), bottom2);
                    max = childAt.getTop() - layoutParams.topMargin;
                    i2 = min;
                    this.mDrawable.setBounds(intrinsicWidth, max, left, i2);
                    this.mDrawable.draw(canvas);
                } else {
                    max = Math.max((childAt.getTop() - layoutParams.topMargin) - this.mDrawable.getIntrinsicHeight(), top);
                    bottom = childAt.getBottom();
                    i = layoutParams.bottomMargin;
                }
                i2 = bottom + i;
                this.mDrawable.setBounds(intrinsicWidth, max, left, i2);
                this.mDrawable.draw(canvas);
            }
        }
    }

    private void drawHorizontalDecorations(Canvas canvas, RecyclerView parent) {
        int top;
        int intrinsicHeight;
        int left;
        int right;
        int i;
        int i2;
        int i3;
        if (needsHorizontalDecoration()) {
            FlexboxLayoutManager flexboxLayoutManager = (FlexboxLayoutManager) parent.getLayoutManager();
            int flexDirection = flexboxLayoutManager.getFlexDirection();
            int left2 = parent.getLeft() - parent.getPaddingLeft();
            int right2 = parent.getRight() + parent.getPaddingRight();
            int childCount = parent.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = parent.getChildAt(i4);
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                if (flexDirection == 3) {
                    intrinsicHeight = childAt.getBottom() + layoutParams.bottomMargin;
                    top = this.mDrawable.getIntrinsicHeight() + intrinsicHeight;
                } else {
                    top = childAt.getTop() - layoutParams.topMargin;
                    intrinsicHeight = top - this.mDrawable.getIntrinsicHeight();
                }
                if (flexboxLayoutManager.isMainAxisDirectionHorizontal()) {
                    if (flexboxLayoutManager.isLayoutRtl()) {
                        i2 = Math.min(childAt.getRight() + layoutParams.rightMargin + this.mDrawable.getIntrinsicWidth(), right2);
                        i3 = childAt.getLeft() - layoutParams.leftMargin;
                        this.mDrawable.setBounds(i3, intrinsicHeight, i2, top);
                        this.mDrawable.draw(canvas);
                    } else {
                        left = Math.max((childAt.getLeft() - layoutParams.leftMargin) - this.mDrawable.getIntrinsicWidth(), left2);
                        right = childAt.getRight();
                        i = layoutParams.rightMargin;
                    }
                } else {
                    left = childAt.getLeft() - layoutParams.leftMargin;
                    right = childAt.getRight();
                    i = layoutParams.rightMargin;
                }
                int i5 = left;
                i2 = right + i;
                i3 = i5;
                this.mDrawable.setBounds(i3, intrinsicHeight, i2, top);
                this.mDrawable.draw(canvas);
            }
        }
    }

    private boolean needsHorizontalDecoration() {
        return (this.mOrientation & 1) > 0;
    }

    private boolean needsVerticalDecoration() {
        return (this.mOrientation & 2) > 0;
    }

    private boolean isFirstItemInLine(int position, List<FlexLine> flexLines, FlexboxLayoutManager layoutManager) {
        int positionToFlexLineIndex = layoutManager.getPositionToFlexLineIndex(position);
        if ((positionToFlexLineIndex == -1 || positionToFlexLineIndex >= layoutManager.getFlexLinesInternal().size() || layoutManager.getFlexLinesInternal().get(positionToFlexLineIndex).mFirstIndex != position) && position != 0) {
            return flexLines.size() != 0 && flexLines.get(flexLines.size() - 1).mLastIndex == position - 1;
        }
        return true;
    }
}
