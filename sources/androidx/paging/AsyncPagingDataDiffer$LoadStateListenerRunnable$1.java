package androidx.paging;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AsyncPagingDataDiffer.kt */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\t\u001a\u00020\nH\u0016R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"androidx/paging/AsyncPagingDataDiffer$LoadStateListenerRunnable$1", "Ljava/lang/Runnable;", "loadState", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/paging/CombinedLoadStates;", "getLoadState", "()Ljava/util/concurrent/atomic/AtomicReference;", "setLoadState", "(Ljava/util/concurrent/atomic/AtomicReference;)V", "run", "", "paging-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AsyncPagingDataDiffer$LoadStateListenerRunnable$1 implements Runnable {
    private AtomicReference<CombinedLoadStates> loadState = new AtomicReference<>(null);
    final /* synthetic */ AsyncPagingDataDiffer<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AsyncPagingDataDiffer$LoadStateListenerRunnable$1(AsyncPagingDataDiffer<T> asyncPagingDataDiffer) {
        this.this$0 = asyncPagingDataDiffer;
    }

    public final AtomicReference<CombinedLoadStates> getLoadState() {
        return this.loadState;
    }

    public final void setLoadState(AtomicReference<CombinedLoadStates> atomicReference) {
        Intrinsics.checkNotNullParameter(atomicReference, "<set-?>");
        this.loadState = atomicReference;
    }

    @Override // java.lang.Runnable
    public void run() {
        CopyOnWriteArrayList<Function1> copyOnWriteArrayList;
        CombinedLoadStates combinedLoadStates = this.loadState.get();
        if (combinedLoadStates != null) {
            copyOnWriteArrayList = ((AsyncPagingDataDiffer) this.this$0).childLoadStateListeners;
            for (Function1 function1 : copyOnWriteArrayList) {
                function1.invoke(combinedLoadStates);
            }
        }
    }
}
