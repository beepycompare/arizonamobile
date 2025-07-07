package androidx.paging;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: InvalidatingPagingSourceFactory.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004B\u001f\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00070\u0006¢\u0006\u0002\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0015\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007H\u0096\u0002J\u001f\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00070\rH\u0001¢\u0006\u0002\b\u0011R\u0012\u0010\t\u001a\u00060\nj\u0002`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00070\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/paging/InvalidatingPagingSourceFactory;", "Key", "", "Value", "Landroidx/paging/PagingSourceFactory;", "pagingSourceFactory", "Lkotlin/Function0;", "Landroidx/paging/PagingSource;", "(Lkotlin/jvm/functions/Function0;)V", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Landroidx/paging/internal/ReentrantLock;", "pagingSources", "", "invalidate", "", "invoke", "pagingSources$paging_common_release", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class InvalidatingPagingSourceFactory<Key, Value> implements PagingSourceFactory<Key, Value> {
    private final ReentrantLock lock;
    private final Function0<PagingSource<Key, Value>> pagingSourceFactory;
    private List<? extends PagingSource<Key, Value>> pagingSources;

    /* JADX WARN: Multi-variable type inference failed */
    public InvalidatingPagingSourceFactory(Function0<? extends PagingSource<Key, Value>> pagingSourceFactory) {
        Intrinsics.checkNotNullParameter(pagingSourceFactory, "pagingSourceFactory");
        this.pagingSourceFactory = pagingSourceFactory;
        this.lock = new ReentrantLock();
        this.pagingSources = CollectionsKt.emptyList();
    }

    public final List<PagingSource<Key, Value>> pagingSources$paging_common_release() {
        return (List<? extends PagingSource<Key, Value>>) this.pagingSources;
    }

    @Override // kotlin.jvm.functions.Function0
    public PagingSource<Key, Value> invoke() {
        PagingSource<Key, Value> invoke = this.pagingSourceFactory.invoke();
        ReentrantLock reentrantLock = this.lock;
        try {
            reentrantLock.lock();
            this.pagingSources = CollectionsKt.plus((Collection<? extends PagingSource<Key, Value>>) this.pagingSources, invoke);
            Unit unit = Unit.INSTANCE;
            return invoke;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void invalidate() {
        ReentrantLock reentrantLock = this.lock;
        try {
            reentrantLock.lock();
            List<? extends PagingSource<Key, Value>> list = this.pagingSources;
            this.pagingSources = CollectionsKt.emptyList();
            reentrantLock.unlock();
            for (PagingSource<Key, Value> pagingSource : list) {
                if (!pagingSource.getInvalid()) {
                    pagingSource.invalidate();
                }
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
