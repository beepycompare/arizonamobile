package com.arizona.common.utils;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: GridItemDecoration.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/arizona/common/utils/GridItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "itemWidthPercent", "", "itemHeightPercent", "marginRightPercent", "marginLeftPercent", "marginBottomPercent", "<init>", "(FFFFF)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/recyclerview/widget/RecyclerView$State;", "CommonLibs_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GridItemDecoration extends RecyclerView.ItemDecoration {
    private final float itemHeightPercent;
    private final float itemWidthPercent;
    private final float marginBottomPercent;
    private final float marginLeftPercent;
    private final float marginRightPercent;

    public GridItemDecoration(float f, float f2, float f3, float f4, float f5) {
        this.itemWidthPercent = f;
        this.itemHeightPercent = f2;
        this.marginRightPercent = f3;
        this.marginLeftPercent = f4;
        this.marginBottomPercent = f5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        int width = parent.getWidth();
        int height = parent.getHeight();
        float f = width;
        int i = (int) (this.itemWidthPercent * f);
        float f2 = height;
        int i2 = (int) (this.itemHeightPercent * f2);
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        boolean z = childAdapterPosition >= gridLayoutManager.getSpanCount() * (gridLayoutManager.getItemCount() / gridLayoutManager.getSpanCount());
        boolean z2 = childAdapterPosition % gridLayoutManager.getSpanCount() == 0;
        boolean z3 = (childAdapterPosition + 1) % gridLayoutManager.getSpanCount() == 0;
        if (z2) {
            outRect.left = 0;
        } else {
            outRect.left = (int) (this.marginLeftPercent * f);
        }
        if (z3) {
            outRect.right = 0;
        } else {
            outRect.right = (int) (f * this.marginRightPercent);
        }
        if (z) {
            outRect.bottom = 0;
        } else {
            outRect.bottom = (int) (f2 * this.marginBottomPercent);
        }
        view.getLayoutParams().width = i;
        view.getLayoutParams().height = i2;
    }
}
