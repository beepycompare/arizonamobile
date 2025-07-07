package androidx.paging;

import androidx.paging.LoadState;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
/* compiled from: MutableCombinedLoadStateCollection.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000f\u001a\u00020\t2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\bJ*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012H\u0002J$\u0010\u0017\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0002J-\u0010\u001b\u001a\u00020\t2#\u0010\u0017\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00050\bH\u0002J\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00122\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u001a\u0010$\u001a\u00020\t2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\bJ\u0018\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u00192\b\u0010'\u001a\u0004\u0018\u00010\u0019J\u001e\u0010%\u001a\u00020\t2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010(\u001a\u00020\u0012R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\u0006\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b0\u0007j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006)"}, d2 = {"Landroidx/paging/MutableCombinedLoadStateCollection;", "", "()V", "_stateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/paging/CombinedLoadStates;", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function1;", "", "Landroidx/paging/internal/CopyOnWriteArrayList;", "stateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "addListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "computeHelperState", "Landroidx/paging/LoadState;", "previousState", "sourceRefreshState", "sourceState", "remoteState", "computeNewState", "newSource", "Landroidx/paging/LoadStates;", "newRemote", "dispatchNewState", "Lkotlin/ParameterName;", "name", "currState", "get", "type", "Landroidx/paging/LoadType;", "remote", "", "removeListener", "set", "sourceLoadStates", "remoteLoadStates", RemoteConfigConstants.ResponseFieldKey.STATE, "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
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
        dispatchNewState(new Function1<CombinedLoadStates, CombinedLoadStates>() { // from class: androidx.paging.MutableCombinedLoadStateCollection$set$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CombinedLoadStates invoke(CombinedLoadStates combinedLoadStates) {
                CombinedLoadStates computeNewState;
                computeNewState = MutableCombinedLoadStateCollection.this.computeNewState(combinedLoadStates, sourceLoadStates, loadStates);
                return computeNewState;
            }
        });
    }

    public final void set(final LoadType type, final boolean z, final LoadState state) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(state, "state");
        dispatchNewState(new Function1<CombinedLoadStates, CombinedLoadStates>() { // from class: androidx.paging.MutableCombinedLoadStateCollection$set$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CombinedLoadStates invoke(CombinedLoadStates combinedLoadStates) {
                LoadStates idle;
                CombinedLoadStates computeNewState;
                if (combinedLoadStates == null || (idle = combinedLoadStates.getSource()) == null) {
                    idle = LoadStates.Companion.getIDLE();
                }
                LoadStates mediator = combinedLoadStates != null ? combinedLoadStates.getMediator() : null;
                if (z) {
                    mediator = LoadStates.Companion.getIDLE().modifyState$paging_common_release(type, state);
                } else {
                    idle = idle.modifyState$paging_common_release(type, state);
                }
                computeNewState = this.computeNewState(combinedLoadStates, idle, mediator);
                return computeNewState;
            }
        });
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
            return source.get$paging_common_release(type);
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
            Iterator<T> it = this.listeners.iterator();
            while (it.hasNext()) {
                ((Function1) it.next()).invoke(invoke);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CombinedLoadStates computeNewState(CombinedLoadStates combinedLoadStates, LoadStates loadStates, LoadStates loadStates2) {
        LoadState.NotLoading incomplete$paging_common_release;
        LoadState.NotLoading incomplete$paging_common_release2;
        LoadState.NotLoading incomplete$paging_common_release3;
        if (combinedLoadStates == null || (incomplete$paging_common_release = combinedLoadStates.getRefresh()) == null) {
            incomplete$paging_common_release = LoadState.NotLoading.Companion.getIncomplete$paging_common_release();
        }
        LoadState computeHelperState = computeHelperState(incomplete$paging_common_release, loadStates.getRefresh(), loadStates.getRefresh(), loadStates2 != null ? loadStates2.getRefresh() : null);
        if (combinedLoadStates == null || (incomplete$paging_common_release2 = combinedLoadStates.getPrepend()) == null) {
            incomplete$paging_common_release2 = LoadState.NotLoading.Companion.getIncomplete$paging_common_release();
        }
        LoadState computeHelperState2 = computeHelperState(incomplete$paging_common_release2, loadStates.getRefresh(), loadStates.getPrepend(), loadStates2 != null ? loadStates2.getPrepend() : null);
        if (combinedLoadStates == null || (incomplete$paging_common_release3 = combinedLoadStates.getAppend()) == null) {
            incomplete$paging_common_release3 = LoadState.NotLoading.Companion.getIncomplete$paging_common_release();
        }
        return new CombinedLoadStates(computeHelperState, computeHelperState2, computeHelperState(incomplete$paging_common_release3, loadStates.getRefresh(), loadStates.getAppend(), loadStates2 != null ? loadStates2.getAppend() : null), loadStates, loadStates2);
    }

    private final LoadState computeHelperState(LoadState loadState, LoadState loadState2, LoadState loadState3, LoadState loadState4) {
        return loadState4 == null ? loadState3 : (!(loadState instanceof LoadState.Loading) || ((loadState2 instanceof LoadState.NotLoading) && (loadState4 instanceof LoadState.NotLoading)) || (loadState4 instanceof LoadState.Error)) ? loadState4 : loadState;
    }
}
