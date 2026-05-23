package androidx.paging;

import androidx.paging.HintHandler;
import androidx.paging.ViewportHint;
import androidx.paging.internal.SynchronizedLock;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
/* compiled from: HintHandler.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0002\u0013\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fR\u0012\u0010\u0004\u001a\u00060\u0005R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Landroidx/paging/HintHandler;", "", "<init>", "()V", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/paging/HintHandler$State;", "lastAccessHint", "Landroidx/paging/ViewportHint$Access;", "getLastAccessHint", "()Landroidx/paging/ViewportHint$Access;", "hintFor", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/ViewportHint;", "loadType", "Landroidx/paging/LoadType;", "forceSetHint", "", "viewportHint", "processHint", "State", "HintFlow", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HintHandler {
    private final State state = new State();

    /* compiled from: HintHandler.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoadType.values().length];
            try {
                iArr[LoadType.PREPEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadType.APPEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final ViewportHint.Access getLastAccessHint() {
        return this.state.getLastAccessHint();
    }

    public final Flow<ViewportHint> hintFor(LoadType loadType) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        int i = WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return this.state.getAppendFlow();
            }
            throw new IllegalArgumentException("invalid load type for hints");
        }
        return this.state.getPrependFlow();
    }

    public final void forceSetHint(final LoadType loadType, final ViewportHint viewportHint) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(viewportHint, "viewportHint");
        if (loadType != LoadType.PREPEND && loadType != LoadType.APPEND) {
            throw new IllegalArgumentException(("invalid load type for reset: " + loadType).toString());
        }
        this.state.modify(null, new Function2() { // from class: androidx.paging.HintHandler$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return HintHandler.forceSetHint$lambda$1(LoadType.this, viewportHint, (HintHandler.HintFlow) obj, (HintHandler.HintFlow) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit forceSetHint$lambda$1(LoadType loadType, ViewportHint viewportHint, HintFlow prependHint, HintFlow appendHint) {
        Intrinsics.checkNotNullParameter(prependHint, "prependHint");
        Intrinsics.checkNotNullParameter(appendHint, "appendHint");
        if (loadType == LoadType.PREPEND) {
            prependHint.setValue(viewportHint);
        } else {
            appendHint.setValue(viewportHint);
        }
        return Unit.INSTANCE;
    }

    public final void processHint(final ViewportHint viewportHint) {
        Intrinsics.checkNotNullParameter(viewportHint, "viewportHint");
        this.state.modify(viewportHint instanceof ViewportHint.Access ? (ViewportHint.Access) viewportHint : null, new Function2() { // from class: androidx.paging.HintHandler$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return HintHandler.processHint$lambda$0(ViewportHint.this, (HintHandler.HintFlow) obj, (HintHandler.HintFlow) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit processHint$lambda$0(ViewportHint viewportHint, HintFlow prependHint, HintFlow appendHint) {
        Intrinsics.checkNotNullParameter(prependHint, "prependHint");
        Intrinsics.checkNotNullParameter(appendHint, "appendHint");
        if (HintHandlerKt.shouldPrioritizeOver(viewportHint, prependHint.getValue(), LoadType.PREPEND)) {
            prependHint.setValue(viewportHint);
        }
        if (HintHandlerKt.shouldPrioritizeOver(viewportHint, appendHint.getValue(), LoadType.APPEND)) {
            appendHint.setValue(viewportHint);
        }
        return Unit.INSTANCE;
    }

    /* compiled from: HintHandler.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JP\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\t2>\u0010\u0019\u001a:\u0012\u0017\u0012\u00150\u0005R\u00020\u0006¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0004\u0012\u0017\u0012\u00150\u0005R\u00020\u0006¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00170\u001aR\u0012\u0010\u0004\u001a\u00060\u0005R\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00060\u0005R\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/paging/HintHandler$State;", "", "<init>", "(Landroidx/paging/HintHandler;)V", "prepend", "Landroidx/paging/HintHandler$HintFlow;", "Landroidx/paging/HintHandler;", "append", "value", "Landroidx/paging/ViewportHint$Access;", "lastAccessHint", "getLastAccessHint", "()Landroidx/paging/ViewportHint$Access;", "prependFlow", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/ViewportHint;", "getPrependFlow", "()Lkotlinx/coroutines/flow/Flow;", "appendFlow", "getAppendFlow", "lock", "Landroidx/paging/internal/SynchronizedLock;", "modify", "", "accessHint", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private final class State {
        private final HintFlow append;
        private ViewportHint.Access lastAccessHint;
        private final SynchronizedLock lock = new SynchronizedLock();
        private final HintFlow prepend;

        public State() {
            this.prepend = new HintFlow();
            this.append = new HintFlow();
        }

        public final ViewportHint.Access getLastAccessHint() {
            return this.lastAccessHint;
        }

        public final Flow<ViewportHint> getPrependFlow() {
            return this.prepend.getFlow();
        }

        public final Flow<ViewportHint> getAppendFlow() {
            return this.append.getFlow();
        }

        public final void modify(ViewportHint.Access access, Function2<? super HintFlow, ? super HintFlow, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            synchronized (this.lock) {
                if (access != null) {
                    this.lastAccessHint = access;
                }
                block.invoke(this.prepend, this.append);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HintHandler.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R(\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/paging/HintHandler$HintFlow;", "", "<init>", "(Landroidx/paging/HintHandler;)V", "value", "Landroidx/paging/ViewportHint;", "getValue", "()Landroidx/paging/ViewportHint;", "setValue", "(Landroidx/paging/ViewportHint;)V", "_flow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "flow", "Lkotlinx/coroutines/flow/Flow;", "getFlow", "()Lkotlinx/coroutines/flow/Flow;", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class HintFlow {
        private final MutableSharedFlow<ViewportHint> _flow = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, null);
        private ViewportHint value;

        public HintFlow() {
        }

        public final ViewportHint getValue() {
            return this.value;
        }

        public final void setValue(ViewportHint viewportHint) {
            this.value = viewportHint;
            if (viewportHint != null) {
                this._flow.tryEmit(viewportHint);
            }
        }

        public final Flow<ViewportHint> getFlow() {
            return this._flow;
        }
    }
}
