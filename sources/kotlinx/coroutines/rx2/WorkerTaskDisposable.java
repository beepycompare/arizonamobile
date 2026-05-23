package kotlinx.coroutines.rx2;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.DisposableHandle;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RxScheduler.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\t\u0010\n\u001a\u00020\u000bX\u0082\u0004¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/rx2/WorkerTaskDisposable;", "Lio/reactivex/disposables/Disposable;", "timeoutHandle", "Lkotlinx/coroutines/DisposableHandle;", "cleanupOnScopeCancellationHandle", "<init>", "(Lkotlinx/coroutines/DisposableHandle;Lkotlinx/coroutines/DisposableHandle;)V", "getTimeoutHandle", "()Lkotlinx/coroutines/DisposableHandle;", "getCleanupOnScopeCancellationHandle", "isDisposedField", "Lkotlinx/atomicfu/AtomicBoolean;", "dispose", "", "isDisposed", "", "toString", "", "kotlinx-coroutines-rx2"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WorkerTaskDisposable implements Disposable {
    private static final /* synthetic */ AtomicIntegerFieldUpdater isDisposedField$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(WorkerTaskDisposable.class, "isDisposedField$volatile");
    private final DisposableHandle cleanupOnScopeCancellationHandle;
    private volatile /* synthetic */ int isDisposedField$volatile;
    private final DisposableHandle timeoutHandle;

    private final /* synthetic */ int isDisposedField$volatile() {
        return this.isDisposedField$volatile;
    }

    private final /* synthetic */ void setDisposedField$volatile(int i) {
        this.isDisposedField$volatile = i;
    }

    public WorkerTaskDisposable(DisposableHandle disposableHandle, DisposableHandle disposableHandle2) {
        this.timeoutHandle = disposableHandle;
        this.cleanupOnScopeCancellationHandle = disposableHandle2;
    }

    public final DisposableHandle getTimeoutHandle() {
        return this.timeoutHandle;
    }

    public final DisposableHandle getCleanupOnScopeCancellationHandle() {
        return this.cleanupOnScopeCancellationHandle;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        isDisposedField$volatile$FU.set(this, 1);
        this.timeoutHandle.dispose();
        this.cleanupOnScopeCancellationHandle.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return isDisposedField$volatile$FU.get(this) == 1;
    }

    public String toString() {
        return "WorkerTaskDisposable(isDisposed=" + isDisposed() + ')';
    }
}
