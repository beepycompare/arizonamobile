package androidx.paging;

import androidx.paging.internal.SynchronizedLock;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: InvalidatingPagingSourceFactory.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004B!\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00070\rH\u0001¢\u0006\u0002\b\u000eJ\u0015\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007H\u0096\u0002J\u0006\u0010\u0010\u001a\u00020\u0011R \u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00070\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/paging/InvalidatingPagingSourceFactory;", "Key", "", "Value", "Landroidx/paging/PagingSourceFactory;", "pagingSourceFactory", "Lkotlin/Function0;", "Landroidx/paging/PagingSource;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "lock", "Landroidx/paging/internal/SynchronizedLock;", "pagingSources", "", "pagingSources$paging_common", "invoke", "invalidate", "", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InvalidatingPagingSourceFactory<Key, Value> implements PagingSourceFactory<Key, Value> {
    private final SynchronizedLock lock;
    private final Function0<PagingSource<Key, Value>> pagingSourceFactory;
    private List<? extends PagingSource<Key, Value>> pagingSources;

    /* JADX WARN: Multi-variable type inference failed */
    public InvalidatingPagingSourceFactory(Function0<? extends PagingSource<Key, Value>> pagingSourceFactory) {
        Intrinsics.checkNotNullParameter(pagingSourceFactory, "pagingSourceFactory");
        this.pagingSourceFactory = pagingSourceFactory;
        this.lock = new SynchronizedLock();
        this.pagingSources = CollectionsKt.emptyList();
    }

    public final List<PagingSource<Key, Value>> pagingSources$paging_common() {
        return (List<? extends PagingSource<Key, Value>>) this.pagingSources;
    }

    @Override // kotlin.jvm.functions.Function0
    public PagingSource<Key, Value> invoke() {
        PagingSource<Key, Value> invoke = this.pagingSourceFactory.invoke();
        synchronized (this.lock) {
            this.pagingSources = CollectionsKt.plus((Collection<? extends PagingSource<Key, Value>>) this.pagingSources, invoke);
            Unit unit = Unit.INSTANCE;
        }
        return invoke;
    }

    public final void invalidate() {
        List<? extends PagingSource<Key, Value>> list;
        synchronized (this.lock) {
            list = this.pagingSources;
            this.pagingSources = CollectionsKt.emptyList();
        }
        for (PagingSource<Key, Value> pagingSource : list) {
            if (!pagingSource.getInvalid()) {
                pagingSource.invalidate();
            }
        }
    }
}
