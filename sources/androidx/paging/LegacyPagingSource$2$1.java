package androidx.paging;

import androidx.paging.DataSource;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LegacyPagingSource.jvmAndAndroid.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* synthetic */ class LegacyPagingSource$2$1 implements DataSource.InvalidatedCallback, FunctionAdapter {
    final /* synthetic */ LegacyPagingSource<Key, Value> $tmp0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LegacyPagingSource$2$1(LegacyPagingSource<Key, Value> legacyPagingSource) {
        this.$tmp0 = legacyPagingSource;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof DataSource.InvalidatedCallback) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
    public final Function<?> getFunctionDelegate() {
        return new FunctionReferenceImpl(0, this.$tmp0, LegacyPagingSource.class, "invalidate", "invalidate()V", 0);
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    @Override // androidx.paging.DataSource.InvalidatedCallback
    public final void onInvalidated() {
        this.$tmp0.invalidate();
    }
}
