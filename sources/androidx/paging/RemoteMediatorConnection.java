package androidx.paging;

import kotlin.Metadata;
/* compiled from: RemoteMediatorAccessor.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002J\u001c\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007H&J$\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007H&J\u001c\u0010\u000b\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007H&J\b\u0010\f\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Landroidx/paging/RemoteMediatorConnection;", "Key", "", "Value", "requestRefreshIfAllowed", "", "pagingState", "Landroidx/paging/PagingState;", "requestLoad", "loadType", "Landroidx/paging/LoadType;", "retryFailed", "allowRefresh", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface RemoteMediatorConnection<Key, Value> {
    void allowRefresh();

    void requestLoad(LoadType loadType, PagingState<Key, Value> pagingState);

    void requestRefreshIfAllowed(PagingState<Key, Value> pagingState);

    void retryFailed(PagingState<Key, Value> pagingState);
}
