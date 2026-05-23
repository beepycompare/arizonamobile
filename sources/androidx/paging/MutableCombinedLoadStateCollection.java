package androidx.paging;

import androidx.paging.internal.CopyOnWriteArrayList;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
/* compiled from: MutableCombinedLoadStateCollection.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u001e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u001a\u0010\u001a\u001a\u00020\b2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006J\u001a\u0010\u001c\u001a\u00020\b2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006J-\u0010\u001d\u001a\u00020\b2#\u0010\u001e\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00070\u0006H\u0002R \u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\""}, d2 = {"Landroidx/paging/MutableCombinedLoadStateCollection;", "", "<init>", "()V", "listeners", "Landroidx/paging/internal/CopyOnWriteArrayList;", "Lkotlin/Function1;", "Landroidx/paging/CombinedLoadStates;", "", "_stateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "stateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "set", "sourceLoadStates", "Landroidx/paging/LoadStates;", "remoteLoadStates", "type", "Landroidx/paging/LoadType;", "remote", "", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/paging/LoadState;", "get", "addListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeListener", "dispatchNewState", "computeNewState", "Lkotlin/ParameterName;", "name", "currState", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MutableCombinedLoadStateCollection {
    private final MutableStateFlow<CombinedLoadStates> _stateFlow;
    private final CopyOnWriteArrayList<Function1<CombinedLoadStates, Unit>> listeners = new CopyOnWriteArrayList<>();
    private final StateFlow<CombinedLoadStates> stateFlow;

    public MutableCombinedLoadStateCollection() {
        MutableStateFlow<CombinedLoadStates> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this._stateFlow = MutableStateFlow;
        this.stateFlow = FlowKt.asStateFlow(MutableStateFlow);
    }

    public final StateFlow<CombinedLoadStates> getStateFlow() {
        return this.stateFlow;
    }

    public final void set(final LoadStates sourceLoadStates, final LoadStates loadStates) {
        Intrinsics.checkNotNullParameter(sourceLoadStates, "sourceLoadStates");
        dispatchNewState(new Function1() { // from class: androidx.paging.MutableCombinedLoadStateCollection$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                CombinedLoadStates computeNewState;
                computeNewState = MutableCombinedLoadStateCollectionKt.computeNewState((CombinedLoadStates) obj, LoadStates.this, loadStates);
                return computeNewState;
            }
        });
    }

    public final void set(final LoadType type, final boolean z, final LoadState state) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(state, "state");
        dispatchNewState(new Function1() { // from class: androidx.paging.MutableCombinedLoadStateCollection$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MutableCombinedLoadStateCollection.set$lambda$1(z, type, state, (CombinedLoadStates) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CombinedLoadStates set$lambda$1(boolean z, LoadType loadType, LoadState loadState, CombinedLoadStates combinedLoadStates) {
        LoadStates idle;
        if (combinedLoadStates == null || (idle = combinedLoadStates.getSource()) == null) {
            idle = LoadStates.Companion.getIDLE();
        }
        LoadStates mediator = combinedLoadStates != null ? combinedLoadStates.getMediator() : null;
        if (z) {
            mediator = LoadStates.Companion.getIDLE().modifyState$paging_common(loadType, loadState);
        } else {
            idle = idle.modifyState$paging_common(loadType, loadState);
        }
        return MutableCombinedLoadStateCollectionKt.computeNewState(combinedLoadStates, idle, mediator);
    }

    public final LoadState get(LoadType type, boolean z) {
        LoadStates source;
        Intrinsics.checkNotNullParameter(type, "type");
        CombinedLoadStates value = this._stateFlow.getValue();
        if (z) {
            if (value != null) {
                source = value.getMediator();
            }
            source = null;
        } else {
            if (value != null) {
                source = value.getSource();
            }
            source = null;
        }
        if (source != null) {
            return source.get$paging_common(type);
        }
        return null;
    }

    public final void addListener(Function1<? super CombinedLoadStates, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
        CombinedLoadStates value = this._stateFlow.getValue();
        if (value != null) {
            listener.invoke(value);
        }
    }

    public final void removeListener(Function1<? super CombinedLoadStates, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }

    private final void dispatchNewState(Function1<? super CombinedLoadStates, CombinedLoadStates> function1) {
        CombinedLoadStates value;
        CombinedLoadStates invoke;
        MutableStateFlow<CombinedLoadStates> mutableStateFlow = this._stateFlow;
        do {
            value = mutableStateFlow.getValue();
            CombinedLoadStates combinedLoadStates = value;
            invoke = function1.invoke(combinedLoadStates);
            if (Intrinsics.areEqual(combinedLoadStates, invoke)) {
                return;
            }
        } while (!mutableStateFlow.compareAndSet(value, invoke));
        if (invoke != null) {
            for (Function1<CombinedLoadStates, Unit> function12 : this.listeners) {
                function12.invoke(invoke);
            }
        }
    }
}
