package androidx.paging;

import androidx.paging.AccessorState;
import androidx.paging.LoadState;
import androidx.paging.RemoteMediator;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlow;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RemoteMediatorAccessor.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \"*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004:\u0001\"B#\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u001c\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016J$\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0017H\u0016J4\u0010\u0019\u001a\u00020\u0015*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0017H\u0002J\b\u0010\u001c\u001a\u00020\u0015H\u0002J\b\u0010\u001d\u001a\u00020\u0015H\u0002J\u001c\u0010\u001e\u001a\u00020\u00152\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0017H\u0016J\u000e\u0010\u001f\u001a\u00020 H\u0096@¢\u0006\u0002\u0010!R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006#"}, d2 = {"Landroidx/paging/RemoteMediatorAccessImpl;", "Key", "", "Value", "Landroidx/paging/RemoteMediatorAccessor;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "remoteMediator", "Landroidx/paging/RemoteMediator;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/paging/RemoteMediator;)V", "accessorState", "Landroidx/paging/AccessorStateHolder;", "isolationRunner", "Landroidx/paging/SingleRunner;", RemoteConfigConstants.ResponseFieldKey.STATE, "Lkotlinx/coroutines/flow/StateFlow;", "Landroidx/paging/LoadStates;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "requestRefreshIfAllowed", "", "pagingState", "Landroidx/paging/PagingState;", "allowRefresh", "requestLoad", "loadType", "Landroidx/paging/LoadType;", "launchRefresh", "launchBoundary", "retryFailed", "initialize", "Landroidx/paging/RemoteMediator$InitializeAction;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "paging-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RemoteMediatorAccessImpl<Key, Value> implements RemoteMediatorAccessor<Key, Value> {
    public static final Companion Companion = new Companion(null);
    private static final int PRIORITY_APPEND_PREPEND = 1;
    private static final int PRIORITY_REFRESH = 2;
    private final AccessorStateHolder<Key, Value> accessorState;
    private final SingleRunner isolationRunner;
    private final RemoteMediator<Key, Value> remoteMediator;
    private final CoroutineScope scope;

    /* compiled from: RemoteMediatorAccessor.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoadType.values().length];
            try {
                iArr[LoadType.REFRESH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public RemoteMediatorAccessImpl(CoroutineScope scope, RemoteMediator<Key, Value> remoteMediator) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(remoteMediator, "remoteMediator");
        this.scope = scope;
        this.remoteMediator = remoteMediator;
        this.accessorState = new AccessorStateHolder<>();
        this.isolationRunner = new SingleRunner(false);
    }

    @Override // androidx.paging.RemoteMediatorAccessor
    public StateFlow<LoadStates> getState() {
        return this.accessorState.getLoadStates();
    }

    @Override // androidx.paging.RemoteMediatorConnection
    public void requestRefreshIfAllowed(final PagingState<Key, Value> pagingState) {
        Intrinsics.checkNotNullParameter(pagingState, "pagingState");
        this.accessorState.use(new Function1() { // from class: androidx.paging.RemoteMediatorAccessImpl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RemoteMediatorAccessImpl.requestRefreshIfAllowed$lambda$0(RemoteMediatorAccessImpl.this, pagingState, (AccessorState) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit requestRefreshIfAllowed$lambda$0(RemoteMediatorAccessImpl remoteMediatorAccessImpl, PagingState pagingState, AccessorState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getRefreshAllowed()) {
            it.setRefreshAllowed(false);
            remoteMediatorAccessImpl.requestLoad(remoteMediatorAccessImpl.accessorState, LoadType.REFRESH, pagingState);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit allowRefresh$lambda$0(AccessorState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.setRefreshAllowed(true);
        return Unit.INSTANCE;
    }

    @Override // androidx.paging.RemoteMediatorConnection
    public void allowRefresh() {
        this.accessorState.use(new Function1() { // from class: androidx.paging.RemoteMediatorAccessImpl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RemoteMediatorAccessImpl.allowRefresh$lambda$0((AccessorState) obj);
            }
        });
    }

    @Override // androidx.paging.RemoteMediatorConnection
    public void requestLoad(LoadType loadType, PagingState<Key, Value> pagingState) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(pagingState, "pagingState");
        requestLoad(this.accessorState, loadType, pagingState);
    }

    private final void requestLoad(AccessorStateHolder<Key, Value> accessorStateHolder, final LoadType loadType, final PagingState<Key, Value> pagingState) {
        if (((Boolean) accessorStateHolder.use(new Function1() { // from class: androidx.paging.RemoteMediatorAccessImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(RemoteMediatorAccessImpl.requestLoad$lambda$0(LoadType.this, pagingState, (AccessorState) obj));
            }
        })).booleanValue()) {
            if (WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()] == 1) {
                launchRefresh();
            } else {
                launchBoundary();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean requestLoad$lambda$0(LoadType loadType, PagingState pagingState, AccessorState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.add(loadType, pagingState);
    }

    private final void launchRefresh() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new RemoteMediatorAccessImpl$launchRefresh$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void launchBoundary() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new RemoteMediatorAccessImpl$launchBoundary$1(this, null), 3, null);
    }

    @Override // androidx.paging.RemoteMediatorConnection
    public void retryFailed(PagingState<Key, Value> pagingState) {
        Intrinsics.checkNotNullParameter(pagingState, "pagingState");
        final ArrayList<LoadType> arrayList = new ArrayList();
        this.accessorState.use(new Function1() { // from class: androidx.paging.RemoteMediatorAccessImpl$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RemoteMediatorAccessImpl.retryFailed$lambda$0(arrayList, (AccessorState) obj);
            }
        });
        for (LoadType loadType : arrayList) {
            requestLoad(loadType, pagingState);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit retryFailed$lambda$0(List list, AccessorState accessorState) {
        Intrinsics.checkNotNullParameter(accessorState, "accessorState");
        LoadStates computeLoadStates = accessorState.computeLoadStates();
        boolean z = computeLoadStates.getRefresh() instanceof LoadState.Error;
        accessorState.clearErrors();
        if (z) {
            list.add(LoadType.REFRESH);
            accessorState.setBlockState(LoadType.REFRESH, AccessorState.BlockState.UNBLOCKED);
        }
        if (computeLoadStates.getAppend() instanceof LoadState.Error) {
            if (!z) {
                list.add(LoadType.APPEND);
            }
            accessorState.clearPendingRequest(LoadType.APPEND);
        }
        if (computeLoadStates.getPrepend() instanceof LoadState.Error) {
            if (!z) {
                list.add(LoadType.PREPEND);
            }
            accessorState.clearPendingRequest(LoadType.PREPEND);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0047  */
    @Override // androidx.paging.RemoteMediatorAccessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object initialize(Continuation<? super RemoteMediator.InitializeAction> continuation) {
        RemoteMediatorAccessImpl$initialize$1 remoteMediatorAccessImpl$initialize$1;
        Object obj;
        int i;
        if (continuation instanceof RemoteMediatorAccessImpl$initialize$1) {
            remoteMediatorAccessImpl$initialize$1 = (RemoteMediatorAccessImpl$initialize$1) continuation;
            if ((remoteMediatorAccessImpl$initialize$1.label & Integer.MIN_VALUE) != 0) {
                remoteMediatorAccessImpl$initialize$1.label -= Integer.MIN_VALUE;
                obj = remoteMediatorAccessImpl$initialize$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = remoteMediatorAccessImpl$initialize$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    RemoteMediator<Key, Value> remoteMediator = this.remoteMediator;
                    remoteMediatorAccessImpl$initialize$1.label = 1;
                    obj = remoteMediator.initialize(remoteMediatorAccessImpl$initialize$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                }
                if (((RemoteMediator.InitializeAction) obj) == RemoteMediator.InitializeAction.LAUNCH_INITIAL_REFRESH) {
                    this.accessorState.use(new Function1() { // from class: androidx.paging.RemoteMediatorAccessImpl$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            Unit initialize$lambda$0$0;
                            initialize$lambda$0$0 = RemoteMediatorAccessImpl.initialize$lambda$0$0((AccessorState) obj2);
                            return initialize$lambda$0$0;
                        }
                    });
                }
                return obj;
            }
        }
        remoteMediatorAccessImpl$initialize$1 = new RemoteMediatorAccessImpl$initialize$1(this, continuation);
        obj = remoteMediatorAccessImpl$initialize$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = remoteMediatorAccessImpl$initialize$1.label;
        if (i != 0) {
        }
        if (((RemoteMediator.InitializeAction) obj) == RemoteMediator.InitializeAction.LAUNCH_INITIAL_REFRESH) {
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initialize$lambda$0$0(AccessorState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.setBlockState(LoadType.APPEND, AccessorState.BlockState.REQUIRES_REFRESH);
        it.setBlockState(LoadType.PREPEND, AccessorState.BlockState.REQUIRES_REFRESH);
        return Unit.INSTANCE;
    }

    /* compiled from: RemoteMediatorAccessor.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/paging/RemoteMediatorAccessImpl$Companion;", "", "<init>", "()V", "PRIORITY_REFRESH", "", "PRIORITY_APPEND_PREPEND", "paging-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
