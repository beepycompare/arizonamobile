package androidx.paging;

import androidx.paging.internal.SynchronizedLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RemoteMediatorAccessor.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J1\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0002\u0010\u00122\u001e\u0010\u0013\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010\u0012\u0004\u0012\u0002H\u00120\u0014¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/paging/AccessorStateHolder;", "Key", "", "Value", "<init>", "()V", "lock", "Landroidx/paging/internal/SynchronizedLock;", "_loadStates", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/paging/LoadStates;", "loadStates", "Lkotlinx/coroutines/flow/StateFlow;", "getLoadStates", "()Lkotlinx/coroutines/flow/StateFlow;", "internalState", "Landroidx/paging/AccessorState;", "use", "R", "block", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AccessorStateHolder<Key, Value> {
    private final SynchronizedLock lock = new SynchronizedLock();
    private final MutableStateFlow<LoadStates> _loadStates = StateFlowKt.MutableStateFlow(LoadStates.Companion.getIDLE());
    private final AccessorState<Key, Value> internalState = new AccessorState<>();

    public final StateFlow<LoadStates> getLoadStates() {
        return this._loadStates;
    }

    public final <R> R use(Function1<? super AccessorState<Key, Value>, ? extends R> block) {
        R invoke;
        Intrinsics.checkNotNullParameter(block, "block");
        synchronized (this.lock) {
            invoke = block.invoke(this.internalState);
            this._loadStates.setValue(this.internalState.computeLoadStates());
        }
        return invoke;
    }
}
