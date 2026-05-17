package ru.mrlargha.commonui.elements.donate.utils;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: CustomGridLayoutManager.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u001c\u0010\u0012\u001a\u00020\u00102\n\u0010\u0013\u001a\u00060\u0014R\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J4\u0010\u0018\u001a\u00020\u00102\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u001a2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J$\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\n\u0010\u0013\u001a\u00060\u0014R\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010!\u001a\u00020\u000eH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lru/mrlargha/commonui/elements/donate/utils/CustomGridLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "verticalScrollOffset", "", "totalHeight", "TAG", "", "generateDefaultLayoutParams", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "canScrollVertically", "", "scrollToPosition", "", "position", "onLayoutChildren", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/recyclerview/widget/RecyclerView$State;", "layoutLine", "views", "", "Landroid/view/View;", "paramsList", "offsetY", "lineMaxHeight", "scrollVerticallyBy", "dy", "canScrollHorizontally", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CustomGridLayoutManager extends LinearLayoutManager {
    private final String TAG;
    private int totalHeight;
    private int verticalScrollOffset;

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomGridLayoutManager(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "TESTTAG";
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        if (i == 0) {
            this.verticalScrollOffset = 0;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        detachAndScrapAttachedViews(recycler);
        if (state.isPreLayout()) {
            return;
        }
        if (getItemCount() == 0) {
            this.verticalScrollOffset = 0;
            return;
        }
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
            try {
                View viewForPosition = recycler.getViewForPosition(i2);
                Intrinsics.checkNotNull(viewForPosition);
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
            } catch (IndexOutOfBoundsException unused) {
                Log.w(this.TAG, "View for position " + i2 + " not available, skipping");
            }
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
        int i3 = 0;
        while (i3 < size) {
            View view = list.get(i3);
            RecyclerView.LayoutParams layoutParams = list2.get(i3);
            int decoratedMeasuredWidth = this.getDecoratedMeasuredWidth(view);
            int i4 = (i2 - layoutParams.topMargin) - layoutParams.bottomMargin;
            view.measure(View.MeasureSpec.makeMeasureSpec(decoratedMeasuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
            int i5 = layoutParams.leftMargin + paddingLeft;
            int i6 = (layoutParams.topMargin + i) - this.verticalScrollOffset;
            int i7 = i6 + i4;
            CustomGridLayoutManager customGridLayoutManager = this;
            customGridLayoutManager.layoutDecoratedWithMargins(view, i5, i6, i5 + decoratedMeasuredWidth, i7);
            paddingLeft += decoratedMeasuredWidth + layoutParams.leftMargin + layoutParams.rightMargin;
            i3++;
            this = customGridLayoutManager;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
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
