package ru.mrlargha.commonui.utils.recycle_view;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PaginationScrollListener.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\tH$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lru/mrlargha/commonui/utils/recycle_view/PaginationScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "isReverseScroll", "", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "<init>", "(ZLandroidx/recyclerview/widget/LinearLayoutManager;)V", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "loadMoreItems", "isLoading", "()Z", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class PaginationScrollListener extends RecyclerView.OnScrollListener {
    private final boolean isReverseScroll;
    private final LinearLayoutManager layoutManager;

    public abstract boolean isLoading();

    protected abstract void loadMoreItems();

    public /* synthetic */ PaginationScrollListener(boolean z, LinearLayoutManager linearLayoutManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, linearLayoutManager);
    }

    public PaginationScrollListener(boolean z, LinearLayoutManager layoutManager) {
        Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
        this.isReverseScroll = z;
        this.layoutManager = layoutManager;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        int childCount = this.layoutManager.getChildCount();
        int itemCount = this.layoutManager.getItemCount();
        int findFirstVisibleItemPosition = this.layoutManager.findFirstVisibleItemPosition() + 1;
        if (this.isReverseScroll) {
            if (isLoading() || i2 >= 0 || this.layoutManager.findFirstVisibleItemPosition() != 0) {
                return;
            }
        } else if (isLoading() || childCount + findFirstVisibleItemPosition < itemCount || findFirstVisibleItemPosition < 0 || itemCount < 20) {
            return;
        }
        loadMoreItems();
    }
}
