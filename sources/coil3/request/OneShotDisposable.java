package coil3.request;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
/* compiled from: Disposable.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0016R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcoil3/request/OneShotDisposable;", "Lcoil3/request/Disposable;", "job", "Lkotlinx/coroutines/Deferred;", "Lcoil3/request/ImageResult;", "<init>", "(Lkotlinx/coroutines/Deferred;)V", "getJob", "()Lkotlinx/coroutines/Deferred;", "isDisposed", "", "()Z", "dispose", "", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OneShotDisposable implements Disposable {
    private final Deferred<ImageResult> job;

    /* JADX WARN: Multi-variable type inference failed */
    public OneShotDisposable(Deferred<? extends ImageResult> deferred) {
        this.job = deferred;
    }

    @Override // coil3.request.Disposable
    public Deferred<ImageResult> getJob() {
        return this.job;
    }

    @Override // coil3.request.Disposable
    public boolean isDisposed() {
        return !getJob().isActive();
    }

    @Override // coil3.request.Disposable
    public void dispose() {
        if (isDisposed()) {
            return;
        }
        Job.DefaultImpls.cancel$default((Job) getJob(), (CancellationException) null, 1, (Object) null);
    }
}
