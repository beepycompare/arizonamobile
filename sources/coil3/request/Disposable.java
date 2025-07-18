package coil3.request;

import kotlin.Metadata;
import kotlinx.coroutines.Deferred;
/* compiled from: Disposable.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\n\u001a\u00020\u000bH&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Lcoil3/request/Disposable;", "", "job", "Lkotlinx/coroutines/Deferred;", "Lcoil3/request/ImageResult;", "getJob", "()Lkotlinx/coroutines/Deferred;", "isDisposed", "", "()Z", "dispose", "", "coil-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface Disposable {
    void dispose();

    Deferred<ImageResult> getJob();

    boolean isDisposed();
}
