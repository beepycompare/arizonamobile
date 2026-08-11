package ru.mrlargha.commonui.utils.recycle_view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: GridEdgeSpacingItemDecoration.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lru/mrlargha/commonui/utils/recycle_view/GridEdgeSpacingItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "topSpacing", "", "bottomSpacing", "<init>", "(II)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/recyclerview/widget/RecyclerView$State;", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GridEdgeSpacingItemDecoration extends RecyclerView.ItemDecoration {
    private final int bottomSpacing;
    private final int topSpacing;

    public GridEdgeSpacingItemDecoration() {
        this(0, 0, 3, null);
    }

    public GridEdgeSpacingItemDecoration(int i, int i2) {
        this.topSpacing = i;
        this.bottomSpacing = i2;
    }

    public /* synthetic */ GridEdgeSpacingItemDecoration(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int childAdapterPosition;
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        GridLayoutManager gridLayoutManager = layoutManager instanceof GridLayoutManager ? (GridLayoutManager) layoutManager : null;
        if (gridLayoutManager == null || (childAdapterPosition = parent.getChildAdapterPosition(view)) == -1 || state.getItemCount() == 0) {
            return;
        }
        int spanCount = gridLayoutManager.getSpanCount();
        GridLayoutManager.SpanSizeLookup spanSizeLookup = gridLayoutManager.getSpanSizeLookup();
        int spanGroupIndex = spanSizeLookup.getSpanGroupIndex(childAdapterPosition, spanCount);
        int spanGroupIndex2 = spanSizeLookup.getSpanGroupIndex(state.getItemCount() - 1, spanCount);
        if (spanGroupIndex == 0) {
            outRect.top = this.topSpacing;
        }
        if (spanGroupIndex == spanGroupIndex2) {
            outRect.bottom = this.bottomSpacing;
        }
    }
}
