package ru.mrlargha.commonui.elements.catalog;

import kotlin.Metadata;
/* compiled from: CatalogPaginationController.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lru/mrlargha/commonui/elements/catalog/CatalogPaginationController;", "", "<init>", "()V", "currentPage", "", "isRequestPending", "", "canLoadMore", "requestNextPage", "()Ljava/lang/Integer;", "onPageReceived", "", "itemCount", "reset", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CatalogPaginationController {
    private boolean isRequestPending;
    private int currentPage = 1;
    private boolean canLoadMore = true;

    public final Integer requestNextPage() {
        if (this.isRequestPending || !this.canLoadMore) {
            return null;
        }
        this.isRequestPending = true;
        int i = this.currentPage + 1;
        this.currentPage = i;
        return Integer.valueOf(i);
    }

    public final void onPageReceived(int i) {
        this.isRequestPending = false;
        this.canLoadMore = i > 0;
    }

    public final void reset() {
        this.currentPage = 1;
        this.isRequestPending = false;
        this.canLoadMore = true;
    }
}
