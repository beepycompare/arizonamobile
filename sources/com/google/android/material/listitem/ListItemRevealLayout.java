package com.google.android.material.listitem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class ListItemRevealLayout extends ViewGroup implements RevealableListItem {
    private static final int UNSET = -1;
    private int intrinsicHeight;
    private int intrinsicWidth;
    private int minChildWidth;
    private int[] originalChildHeights;
    private int[] originalChildWidths;
    private int originalHeightMeasureSpec;
    private int originalWidthMeasureSpec;
    private int primaryActionSwipeMode;
    private int revealedWidth;
    private WeakReference<View> siblingSwipeableView;

    public ListItemRevealLayout(Context context) {
        this(context, null);
    }

    public ListItemRevealLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listItemRevealLayoutStyle);
    }

    public ListItemRevealLayout(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, R.style.Widget_Material3_ListItemRevealLayout);
    }

    public ListItemRevealLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, i2), attributeSet, i);
        this.intrinsicWidth = -1;
        this.intrinsicHeight = -1;
        this.revealedWidth = 0;
        this.originalWidthMeasureSpec = -1;
        this.originalHeightMeasureSpec = -1;
        Context context2 = getContext();
        setClipToPadding(false);
        TintTypedArray obtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, R.styleable.ListItemRevealLayout, i, i2, new int[0]);
        this.minChildWidth = obtainTintedStyledAttributes.getDimensionPixelSize(R.styleable.ListItemRevealLayout_minChildWidth, getResources().getDimensionPixelSize(R.dimen.m3_list_reveal_min_child_width));
        this.primaryActionSwipeMode = obtainTintedStyledAttributes.getInt(R.styleable.ListItemRevealLayout_primaryActionSwipeMode, 0);
        obtainTintedStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        if (shouldRemeasureIntrinsicSizes(this.originalHeightMeasureSpec, i2, this.intrinsicHeight) || shouldRemeasureIntrinsicSizes(this.originalWidthMeasureSpec, i, this.intrinsicWidth)) {
            this.originalHeightMeasureSpec = i2;
            this.originalWidthMeasureSpec = i;
            measureIntrinsicSize(i, i2);
            saveOriginalChildSizes(childCount);
        }
        WeakReference<View> weakReference = this.siblingSwipeableView;
        if (weakReference == null || weakReference.get() == null) {
            this.siblingSwipeableView = new WeakReference<>(findSiblingSwipeableView());
        }
        int swipeMaxOvershoot = this.siblingSwipeableView.get() != null ? ((SwipeableListItem) this.siblingSwipeableView.get()).getSwipeMaxOvershoot() : 0;
        int calculateFullRevealableWidth = calculateFullRevealableWidth();
        setVisibility(this.revealedWidth == 0 ? 4 : 0);
        int i3 = this.revealedWidth;
        if (i3 == 0) {
            setMeasuredDimension(0, this.intrinsicHeight);
        } else if (childCount == 0) {
            setMeasuredDimension(i3, this.intrinsicHeight);
        } else {
            if (this.primaryActionSwipeMode != 0) {
                int i4 = this.intrinsicWidth;
                if (i3 > swipeMaxOvershoot + i4 && calculateFullRevealableWidth > i4) {
                    measureByGrowingPrimarySwipeAction(calculateFullRevealableWidth);
                    return;
                }
            }
            measureByPreservingSwipeActionRatios(childCount);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6 = this.revealedWidth;
        int i7 = this.intrinsicWidth;
        float f = i6 >= i7 ? 1.0f : i6 / i7;
        int paddingLeft = (int) (getPaddingLeft() * f);
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        int i8 = 1;
        if (getLayoutDirection() == 1) {
            i5 = childCount - 1;
            i8 = -1;
        } else {
            i5 = 0;
        }
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt((i8 * i9) + i5);
            if (childAt.getVisibility() != 8) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i10 = marginLayoutParams.topMargin + paddingTop;
                int i11 = (int) (marginLayoutParams.leftMargin * f);
                int i12 = paddingLeft + i11;
                childAt.layout(i12, i10, i12 + measuredWidth, measuredHeight + i10);
                paddingLeft += i11 + measuredWidth + ((int) (marginLayoutParams.rightMargin * f));
            }
        }
    }

    private boolean shouldRemeasureIntrinsicSizes(int i, int i2, int i3) {
        int mode;
        if (i3 == -1) {
            return true;
        }
        return (i == i2 || (mode = View.MeasureSpec.getMode(i2)) == 0 || (mode == 1073741824 && View.MeasureSpec.getSize(i2) == i3)) ? false : true;
    }

    void measureIntrinsicSize(int i, int i2) {
        ListItemRevealLayout listItemRevealLayout;
        int i3;
        int i4;
        int childCount = getChildCount();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i5 < childCount) {
            View childAt = this.getChildAt(i5);
            if (childAt.getVisibility() == 8) {
                listItemRevealLayout = this;
                i3 = i;
                i4 = i2;
            } else {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                listItemRevealLayout = this;
                i3 = i;
                i4 = i2;
                listItemRevealLayout.measureChildWithMargins(childAt, i3, i6, i4, 0);
                i6 += childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                i7 = Math.max(i7, childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
                i8 = combineMeasuredStates(i8, childAt.getMeasuredState());
            }
            i5++;
            this = listItemRevealLayout;
            i = i3;
            i2 = i4;
        }
        ListItemRevealLayout listItemRevealLayout2 = this;
        int i9 = i2;
        listItemRevealLayout2.intrinsicWidth = resolveSizeAndState(Math.max(i6 + listItemRevealLayout2.getPaddingLeft() + listItemRevealLayout2.getPaddingRight(), listItemRevealLayout2.getSuggestedMinimumWidth()), i, 0);
        listItemRevealLayout2.intrinsicHeight = resolveSizeAndState(resolveSizeAndState(Math.max(i7 + listItemRevealLayout2.getPaddingTop() + listItemRevealLayout2.getPaddingBottom(), listItemRevealLayout2.getSuggestedMinimumHeight()), i9, 0) & 16777215, i9, i8 << 16);
    }

    private void measureByGrowingPrimarySwipeAction(int i) {
        Integer findFirstVisibleChildIndex = ListItemUtils.isRightAligned(this) == (getLayoutDirection() == 1) ? findFirstVisibleChildIndex() : findLastVisibleChildIndex();
        if (findFirstVisibleChildIndex != null) {
            int paddingStart = getPaddingStart() + getPaddingEnd();
            int i2 = this.revealedWidth;
            int i3 = this.intrinsicWidth;
            float max = Math.max(0.0f, Math.min(1.0f, (i2 - i3) / (i - i3)));
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() != 8 && i4 != findFirstVisibleChildIndex.intValue()) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(AnimationUtils.lerp(Math.max(this.originalChildWidths[i4], this.minChildWidth), this.minChildWidth, max), 1073741824), View.MeasureSpec.makeMeasureSpec(this.originalChildHeights[i4], 1073741824));
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                    paddingStart += marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + this.minChildWidth;
                    if (childAt instanceof MaterialButton) {
                        MaterialButton materialButton = (MaterialButton) childAt;
                        if (materialButton.getIcon() != null) {
                            materialButton.getIcon().setAlpha(AnimationUtils.lerp(255, 0, max));
                        }
                    }
                }
            }
            View childAt2 = getChildAt(findFirstVisibleChildIndex.intValue());
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) childAt2.getLayoutParams();
            childAt2.measure(View.MeasureSpec.makeMeasureSpec(AnimationUtils.lerp(this.originalChildWidths[findFirstVisibleChildIndex.intValue()], ((i - paddingStart) - marginLayoutParams2.rightMargin) - marginLayoutParams2.leftMargin, max) + Math.max(this.revealedWidth - i, 0), 1073741824), View.MeasureSpec.makeMeasureSpec(this.originalChildHeights[findFirstVisibleChildIndex.intValue()], 1073741824));
            if (childAt2 instanceof MaterialButton) {
                MaterialButton materialButton2 = (MaterialButton) childAt2;
                if (materialButton2.getIcon() != null) {
                    materialButton2.getIcon().setAlpha(255);
                }
            }
        }
        setMeasuredDimension(this.revealedWidth, this.intrinsicHeight);
    }

    private void measureByPreservingSwipeActionRatios(int i) {
        int i2 = this.intrinsicWidth;
        int lerp = (int) AnimationUtils.lerp(0.0f, 255.0f, i2 / 4.0f, i2 / 2.0f, this.revealedWidth);
        float f = this.revealedWidth / this.intrinsicWidth;
        int paddingLeft = (int) (getPaddingLeft() * f);
        int paddingRight = (int) (getPaddingRight() * f);
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                int max = Math.max(this.minChildWidth, (int) (this.originalChildWidths[i4] * f));
                childAt.measure(View.MeasureSpec.makeMeasureSpec(max, 1073741824), View.MeasureSpec.makeMeasureSpec(this.originalChildHeights[i4], 1073741824));
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                i3 += max + ((int) (marginLayoutParams.leftMargin * f)) + ((int) (marginLayoutParams.rightMargin * f));
                if (childAt instanceof MaterialButton) {
                    MaterialButton materialButton = (MaterialButton) childAt;
                    if (materialButton.getIcon() != null) {
                        materialButton.getIcon().setAlpha(lerp);
                    }
                }
            }
        }
        setMeasuredDimension(Math.max(this.revealedWidth, i3 + paddingLeft + paddingRight), this.intrinsicHeight);
    }

    private void saveOriginalChildSizes(int i) {
        this.originalChildWidths = new int[i];
        this.originalChildHeights = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                this.originalChildWidths[i2] = childAt.getMeasuredWidth();
                this.originalChildHeights[i2] = childAt.getMeasuredHeight();
                if (((ViewGroup.MarginLayoutParams) childAt.getLayoutParams()).height == -1) {
                    this.originalChildHeights[i2] = this.intrinsicHeight;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    public void resetIntrinsicWidth() {
        this.intrinsicWidth = -1;
        requestLayout();
    }

    @Override // com.google.android.material.listitem.RevealableListItem
    public int getIntrinsicWidth() {
        int i = this.intrinsicWidth;
        if (i != -1) {
            return i;
        }
        return 0;
    }

    @Override // com.google.android.material.listitem.RevealableListItem
    public void setRevealedWidth(int i) {
        int max = Math.max(0, i);
        if (this.revealedWidth == max) {
            return;
        }
        this.revealedWidth = max;
        requestLayout();
    }

    private int calculateFullRevealableWidth() {
        WeakReference<View> weakReference = this.siblingSwipeableView;
        if (weakReference != null && weakReference.get() != null) {
            return this.siblingSwipeableView.get().getMeasuredWidth();
        }
        if (getParent() instanceof View) {
            return ((View) getParent()).getMeasuredWidth();
        }
        return this.intrinsicWidth;
    }

    private View findSiblingSwipeableView() {
        if (getParent() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) getParent();
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof SwipeableListItem) {
                    return childAt;
                }
            }
            return null;
        }
        return null;
    }

    public void setMinChildWidth(int i) {
        if (this.minChildWidth == i) {
            return;
        }
        this.minChildWidth = i;
        requestLayout();
    }

    public int getMinChildWidth() {
        return this.minChildWidth;
    }

    private Integer findLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (getChildAt(childCount).getVisibility() != 8) {
                return Integer.valueOf(childCount);
            }
        }
        return null;
    }

    private Integer findFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i).getVisibility() != 8) {
                return Integer.valueOf(i);
            }
        }
        return null;
    }

    @Override // com.google.android.material.listitem.RevealableListItem
    public void setPrimaryActionSwipeMode(int i) {
        this.primaryActionSwipeMode = i;
    }

    @Override // com.google.android.material.listitem.RevealableListItem
    public int getPrimaryActionSwipeMode() {
        return this.primaryActionSwipeMode;
    }
}
