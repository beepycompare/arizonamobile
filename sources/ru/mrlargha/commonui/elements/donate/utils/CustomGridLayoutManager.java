package ru.mrlargha.commonui.elements.donate.utils;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: CustomGridLayoutManager.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u001c\u0010\u0010\u001a\u00020\u000e2\n\u0010\u0011\u001a\u00060\u0012R\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J4\u0010\u0016\u001a\u00020\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u00182\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J$\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\n\u0010\u0011\u001a\u00060\u0012R\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u001f\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lru/mrlargha/commonui/elements/donate/utils/CustomGridLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "<init>", "()V", "verticalScrollOffset", "", "totalHeight", "TAG", "", "generateDefaultLayoutParams", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "canScrollVertically", "", "scrollToPosition", "", "position", "onLayoutChildren", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/recyclerview/widget/RecyclerView$State;", "layoutLine", "views", "", "Landroid/view/View;", "paramsList", "offsetY", "lineMaxHeight", "scrollVerticallyBy", "dy", "canScrollHorizontally", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CustomGridLayoutManager extends RecyclerView.LayoutManager {
    private final String TAG = "TESTTAG";
    private int totalHeight;
    private int verticalScrollOffset;

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        if (i == 0) {
            this.verticalScrollOffset = 0;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        detachAndScrapAttachedViews(recycler);
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        getHeight();
        this.totalHeight = getPaddingTop();
        Log.d(this.TAG, "onLayoutChildren: invoke, " + getItemCount());
        int itemCount = getItemCount();
        int i = 0;
        for (int i2 = 0; i2 < itemCount; i2++) {
            View viewForPosition = recycler.getViewForPosition(i2);
            Intrinsics.checkNotNullExpressionValue(viewForPosition, "getViewForPosition(...)");
            addView(viewForPosition);
            measureChildWithMargins(viewForPosition, 0, 0);
            ViewGroup.LayoutParams layoutParams = viewForPosition.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
            int decoratedMeasuredWidth = getDecoratedMeasuredWidth(viewForPosition) + layoutParams2.leftMargin + layoutParams2.rightMargin;
            int decoratedMeasuredHeight = getDecoratedMeasuredHeight(viewForPosition) + layoutParams2.topMargin + layoutParams2.bottomMargin;
            if (paddingLeft + decoratedMeasuredWidth > getWidth() - getPaddingRight() && !arrayList.isEmpty()) {
                layoutLine(arrayList, arrayList2, paddingTop, i);
                paddingTop += i;
                paddingLeft = getPaddingLeft();
                arrayList.clear();
                arrayList2.clear();
                i = 0;
            }
            arrayList.add(viewForPosition);
            arrayList2.add(layoutParams2);
            paddingLeft += decoratedMeasuredWidth;
            i = Math.max(i, decoratedMeasuredHeight);
        }
        if (!arrayList.isEmpty()) {
            layoutLine(arrayList, arrayList2, paddingTop, i);
            paddingTop += i;
        }
        this.totalHeight = paddingTop + getPaddingBottom();
    }

    private final void layoutLine(List<? extends View> list, List<? extends RecyclerView.LayoutParams> list2, int i, int i2) {
        int paddingLeft = getPaddingLeft();
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = list.get(i3);
            RecyclerView.LayoutParams layoutParams = list2.get(i3);
            int decoratedMeasuredWidth = getDecoratedMeasuredWidth(view);
            int i4 = (i2 - layoutParams.topMargin) - layoutParams.bottomMargin;
            view.measure(View.MeasureSpec.makeMeasureSpec(decoratedMeasuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
            int i5 = layoutParams.leftMargin + paddingLeft;
            int i6 = (layoutParams.topMargin + i) - this.verticalScrollOffset;
            layoutDecoratedWithMargins(view, i5, i6, i5 + decoratedMeasuredWidth, i6 + i4);
            paddingLeft += decoratedMeasuredWidth + layoutParams.leftMargin + layoutParams.rightMargin;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        int coerceIn = RangesKt.coerceIn(this.verticalScrollOffset + i, 0, RangesKt.coerceAtLeast(this.totalHeight - getHeight(), 0));
        int i2 = coerceIn - this.verticalScrollOffset;
        this.verticalScrollOffset = coerceIn;
        offsetChildrenVertical(-i2);
        return i2;
    }
}
