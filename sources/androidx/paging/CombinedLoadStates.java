package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CombinedLoadStates.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u0013\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J-\u0010\u0017\u001a\u00020\u00182\u001e\u0010\u0019\u001a\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00180\u001aH\u0000¢\u0006\u0002\b\u001cJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u00020\r8G¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011¨\u0006!"}, d2 = {"Landroidx/paging/CombinedLoadStates;", "", "refresh", "Landroidx/paging/LoadState;", "prepend", "append", "source", "Landroidx/paging/LoadStates;", "mediator", "(Landroidx/paging/LoadState;Landroidx/paging/LoadState;Landroidx/paging/LoadState;Landroidx/paging/LoadStates;Landroidx/paging/LoadStates;)V", "getAppend", "()Landroidx/paging/LoadState;", "hasError", "", "()Z", "isIdle", "getMediator", "()Landroidx/paging/LoadStates;", "getPrepend", "getRefresh", "getSource", "equals", "other", "forEach", "", "op", "Lkotlin/Function3;", "Landroidx/paging/LoadType;", "forEach$paging_common_release", "hashCode", "", "toString", "", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CombinedLoadStates {
    private final LoadState append;
    private final boolean hasError;
    private final boolean isIdle;
    private final LoadStates mediator;
    private final LoadState prepend;
    private final LoadState refresh;
    private final LoadStates source;

    /* JADX WARN: Removed duplicated region for block: B:12:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CombinedLoadStates(LoadState refresh, LoadState prepend, LoadState append, LoadStates source, LoadStates loadStates) {
        boolean z;
        Intrinsics.checkNotNullParameter(refresh, "refresh");
        Intrinsics.checkNotNullParameter(prepend, "prepend");
        Intrinsics.checkNotNullParameter(append, "append");
        Intrinsics.checkNotNullParameter(source, "source");
        this.refresh = refresh;
        this.prepend = prepend;
        this.append = append;
        this.source = source;
        this.mediator = loadStates;
        boolean z2 = true;
        if (source.isIdle()) {
            if (loadStates != null ? loadStates.isIdle() : true) {
                z = true;
                this.isIdle = z;
                if (!source.hasError()) {
                    if (!(loadStates != null ? loadStates.hasError() : false)) {
                        z2 = false;
                    }
                }
                this.hasError = z2;
            }
        }
        z = false;
        this.isIdle = z;
        if (!source.hasError()) {
        }
        this.hasError = z2;
    }

    public /* synthetic */ CombinedLoadStates(LoadState loadState, LoadState loadState2, LoadState loadState3, LoadStates loadStates, LoadStates loadStates2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(loadState, loadState2, loadState3, loadStates, (i & 16) != 0 ? null : loadStates2);
    }

    public final LoadState getRefresh() {
        return this.refresh;
    }

    public final LoadState getPrepend() {
        return this.prepend;
    }

    public final LoadState getAppend() {
        return this.append;
    }

    public final LoadStates getSource() {
        return this.source;
    }

    public final LoadStates getMediator() {
        return this.mediator;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CombinedLoadStates combinedLoadStates = (CombinedLoadStates) obj;
        return Intrinsics.areEqual(this.refresh, combinedLoadStates.refresh) && Intrinsics.areEqual(this.prepend, combinedLoadStates.prepend) && Intrinsics.areEqual(this.append, combinedLoadStates.append) && Intrinsics.areEqual(this.source, combinedLoadStates.source) && Intrinsics.areEqual(this.mediator, combinedLoadStates.mediator);
    }

    public int hashCode() {
        int hashCode = ((((((this.refresh.hashCode() * 31) + this.prepend.hashCode()) * 31) + this.append.hashCode()) * 31) + this.source.hashCode()) * 31;
        LoadStates loadStates = this.mediator;
        return hashCode + (loadStates != null ? loadStates.hashCode() : 0);
    }

    public String toString() {
        return "CombinedLoadStates(refresh=" + this.refresh + ", prepend=" + this.prepend + ", append=" + this.append + ", source=" + this.source + ", mediator=" + this.mediator + ')';
    }

    public final void forEach$paging_common_release(Function3<? super LoadType, ? super Boolean, ? super LoadState, Unit> op) {
        Intrinsics.checkNotNullParameter(op, "op");
        LoadStates loadStates = this.source;
        op.invoke(LoadType.REFRESH, false, loadStates.getRefresh());
        op.invoke(LoadType.PREPEND, false, loadStates.getPrepend());
        op.invoke(LoadType.APPEND, false, loadStates.getAppend());
        LoadStates loadStates2 = this.mediator;
        if (loadStates2 != null) {
            op.invoke(LoadType.REFRESH, true, loadStates2.getRefresh());
            op.invoke(LoadType.PREPEND, true, loadStates2.getPrepend());
            op.invoke(LoadType.APPEND, true, loadStates2.getAppend());
        }
    }

    public final boolean isIdle() {
        return this.isIdle;
    }

    public final boolean hasError() {
        return this.hasError;
    }
}
