package ru.mrlargha.commonui.utils.recycle_view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: GridSpacingItemDecoration.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lru/mrlargha/commonui/utils/recycle_view/GridSpacingItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "spanCount", "", "spacing", "includeEdge", "", "<init>", "(IIZ)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/recyclerview/widget/RecyclerView$State;", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
    private final boolean includeEdge;
    private final int spacing;
    private final int spanCount;

    public GridSpacingItemDecoration(int i, int i2, boolean z) {
        this.spanCount = i;
        this.spacing = i2;
        this.includeEdge = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int i;
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        if (childAdapterPosition == -1) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        GridLayoutManager gridLayoutManager = layoutManager instanceof GridLayoutManager ? (GridLayoutManager) layoutManager : null;
        int spanCount = gridLayoutManager != null ? gridLayoutManager.getSpanCount() : this.spanCount;
        GridLayoutManager.SpanSizeLookup spanSizeLookup = gridLayoutManager != null ? gridLayoutManager.getSpanSizeLookup() : null;
        boolean z = true;
        int coerceIn = spanSizeLookup != null ? RangesKt.coerceIn(spanSizeLookup.getSpanSize(childAdapterPosition), 1, spanCount) : 1;
        if (spanSizeLookup != null) {
            i = spanSizeLookup.getSpanIndex(childAdapterPosition, spanCount);
        } else {
            i = childAdapterPosition % spanCount;
        }
        int coerceAtMost = RangesKt.coerceAtMost(coerceIn + i, spanCount);
        if (spanSizeLookup == null ? childAdapterPosition >= spanCount : spanSizeLookup.getSpanGroupIndex(childAdapterPosition, spanCount) != 0) {
            z = false;
        }
        boolean z2 = this.includeEdge;
        int i2 = this.spacing;
        if (z2) {
            outRect.left = i2 - ((i * i2) / spanCount);
            outRect.right = (coerceAtMost * this.spacing) / spanCount;
            if (z) {
                outRect.top = this.spacing;
            }
            outRect.bottom = this.spacing;
            return;
        }
        outRect.left = (i * i2) / spanCount;
        int i3 = this.spacing;
        outRect.right = i3 - ((coerceAtMost * i3) / spanCount);
        if (z) {
            return;
        }
        outRect.top = this.spacing;
    }
}
