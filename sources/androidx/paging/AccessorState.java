package androidx.paging;

import androidx.paging.AccessorState;
import androidx.paging.LoadState;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RemoteMediatorAccessor.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002:\u0002*+B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\"\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001eJ\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\bJ\u0014\u0010\"\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001eJ \u0010#\u001a\u001c\u0012\u0004\u0012\u00020\u001b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001e\u0018\u00010$J\u0006\u0010%\u001a\u00020 J\u000e\u0010&\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010'\u001a\u00020 J\u0018\u0010(\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010)\u001a\u0004\u0018\u00010\u000bR\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0018\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR \u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006,"}, d2 = {"Landroidx/paging/AccessorState;", "Key", "", "Value", "<init>", "()V", "blockStates", "", "Landroidx/paging/AccessorState$BlockState;", "[Landroidx/paging/AccessorState$BlockState;", "errors", "Landroidx/paging/LoadState$Error;", "[Landroidx/paging/LoadState$Error;", "pendingRequests", "Lkotlin/collections/ArrayDeque;", "Landroidx/paging/AccessorState$PendingRequest;", "refreshAllowed", "", "getRefreshAllowed", "()Z", "setRefreshAllowed", "(Z)V", "computeLoadStates", "Landroidx/paging/LoadStates;", "computeLoadTypeState", "Landroidx/paging/LoadState;", "loadType", "Landroidx/paging/LoadType;", "add", "pagingState", "Landroidx/paging/PagingState;", "setBlockState", "", RemoteConfigConstants.ResponseFieldKey.STATE, "getPendingRefresh", "getPendingBoundary", "Lkotlin/Pair;", "clearPendingRequests", "clearPendingRequest", "clearErrors", "setError", "errorState", "PendingRequest", "BlockState", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AccessorState<Key, Value> {
    private final BlockState[] blockStates;
    private final LoadState.Error[] errors;
    private final ArrayDeque<PendingRequest<Key, Value>> pendingRequests;
    private boolean refreshAllowed;

    /* compiled from: RemoteMediatorAccessor.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[LoadType.values().length];
            try {
                iArr[LoadType.REFRESH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[BlockState.values().length];
            try {
                iArr2[BlockState.COMPLETED.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[BlockState.REQUIRES_REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[BlockState.UNBLOCKED.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public AccessorState() {
        int length = LoadType.values().length;
        BlockState[] blockStateArr = new BlockState[length];
        for (int i = 0; i < length; i++) {
            blockStateArr[i] = BlockState.UNBLOCKED;
        }
        this.blockStates = blockStateArr;
        int length2 = LoadType.values().length;
        LoadState.Error[] errorArr = new LoadState.Error[length2];
        for (int i2 = 0; i2 < length2; i2++) {
            errorArr[i2] = null;
        }
        this.errors = errorArr;
        this.pendingRequests = new ArrayDeque<>();
    }

    public final boolean getRefreshAllowed() {
        return this.refreshAllowed;
    }

    public final void setRefreshAllowed(boolean z) {
        this.refreshAllowed = z;
    }

    public final LoadStates computeLoadStates() {
        return new LoadStates(computeLoadTypeState(LoadType.REFRESH), computeLoadTypeState(LoadType.PREPEND), computeLoadTypeState(LoadType.APPEND));
    }

    private final LoadState computeLoadTypeState(LoadType loadType) {
        LoadState.NotLoading complete$paging_common;
        BlockState blockState = this.blockStates[loadType.ordinal()];
        ArrayDeque<PendingRequest<Key, Value>> arrayDeque = this.pendingRequests;
        if (!(arrayDeque instanceof Collection) || !arrayDeque.isEmpty()) {
            Iterator<PendingRequest<Key, Value>> it = arrayDeque.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().getLoadType() == loadType) {
                    if (blockState != BlockState.REQUIRES_REFRESH) {
                        return LoadState.Loading.INSTANCE;
                    }
                }
            }
        }
        LoadState.Error error = this.errors[loadType.ordinal()];
        if (error != null) {
            return error;
        }
        int i = WhenMappings.$EnumSwitchMapping$1[blockState.ordinal()];
        if (i == 1) {
            if (WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()] == 1) {
                complete$paging_common = LoadState.NotLoading.Companion.getIncomplete$paging_common();
            } else {
                complete$paging_common = LoadState.NotLoading.Companion.getComplete$paging_common();
            }
            return complete$paging_common;
        } else if (i != 2) {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            return LoadState.NotLoading.Companion.getIncomplete$paging_common();
        } else {
            return LoadState.NotLoading.Companion.getIncomplete$paging_common();
        }
    }

    public final boolean add(LoadType loadType, PagingState<Key, Value> pagingState) {
        PendingRequest<Key, Value> pendingRequest;
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(pagingState, "pagingState");
        Iterator<PendingRequest<Key, Value>> it = this.pendingRequests.iterator();
        while (true) {
            if (!it.hasNext()) {
                pendingRequest = null;
                break;
            }
            pendingRequest = it.next();
            if (pendingRequest.getLoadType() == loadType) {
                break;
            }
        }
        PendingRequest<Key, Value> pendingRequest2 = pendingRequest;
        if (pendingRequest2 != null) {
            pendingRequest2.setPagingState(pagingState);
            return false;
        }
        BlockState blockState = this.blockStates[loadType.ordinal()];
        if (blockState == BlockState.REQUIRES_REFRESH && loadType != LoadType.REFRESH) {
            this.pendingRequests.add(new PendingRequest<>(loadType, pagingState));
            return false;
        } else if (blockState == BlockState.UNBLOCKED || loadType == LoadType.REFRESH) {
            if (loadType == LoadType.REFRESH) {
                setError(LoadType.REFRESH, null);
            }
            if (this.errors[loadType.ordinal()] == null) {
                return this.pendingRequests.add(new PendingRequest<>(loadType, pagingState));
            }
            return false;
        } else {
            return false;
        }
    }

    public final void setBlockState(LoadType loadType, BlockState state) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(state, "state");
        this.blockStates[loadType.ordinal()] = state;
    }

    public final PagingState<Key, Value> getPendingRefresh() {
        PendingRequest<Key, Value> pendingRequest;
        Iterator<PendingRequest<Key, Value>> it = this.pendingRequests.iterator();
        while (true) {
            if (!it.hasNext()) {
                pendingRequest = null;
                break;
            }
            pendingRequest = it.next();
            if (pendingRequest.getLoadType() == LoadType.REFRESH) {
                break;
            }
        }
        PendingRequest<Key, Value> pendingRequest2 = pendingRequest;
        if (pendingRequest2 != null) {
            return pendingRequest2.getPagingState();
        }
        return null;
    }

    public final Pair<LoadType, PagingState<Key, Value>> getPendingBoundary() {
        PendingRequest<Key, Value> pendingRequest;
        Iterator<PendingRequest<Key, Value>> it = this.pendingRequests.iterator();
        while (true) {
            if (!it.hasNext()) {
                pendingRequest = null;
                break;
            }
            pendingRequest = it.next();
            PendingRequest<Key, Value> pendingRequest2 = pendingRequest;
            if (pendingRequest2.getLoadType() != LoadType.REFRESH && this.blockStates[pendingRequest2.getLoadType().ordinal()] == BlockState.UNBLOCKED) {
                break;
            }
        }
        PendingRequest<Key, Value> pendingRequest3 = pendingRequest;
        if (pendingRequest3 != null) {
            return TuplesKt.to(pendingRequest3.getLoadType(), pendingRequest3.getPagingState());
        }
        return null;
    }

    public final void clearPendingRequests() {
        this.pendingRequests.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean clearPendingRequest$lambda$0(LoadType loadType, PendingRequest it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getLoadType() == loadType;
    }

    public final void clearPendingRequest(final LoadType loadType) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        CollectionsKt.removeAll((List) this.pendingRequests, new Function1() { // from class: androidx.paging.AccessorState$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(AccessorState.clearPendingRequest$lambda$0(LoadType.this, (AccessorState.PendingRequest) obj));
            }
        });
    }

    public final void clearErrors() {
        int length = this.errors.length;
        for (int i = 0; i < length; i++) {
            this.errors[i] = null;
        }
    }

    public final void setError(LoadType loadType, LoadState.Error error) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        this.errors[loadType.ordinal()] = error;
    }

    /* compiled from: RemoteMediatorAccessor.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u0002*\b\b\u0003\u0010\u0003*\u00020\u00022\u00020\u0002B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/paging/AccessorState$PendingRequest;", "Key", "", "Value", "loadType", "Landroidx/paging/LoadType;", "pagingState", "Landroidx/paging/PagingState;", "<init>", "(Landroidx/paging/LoadType;Landroidx/paging/PagingState;)V", "getLoadType", "()Landroidx/paging/LoadType;", "getPagingState", "()Landroidx/paging/PagingState;", "setPagingState", "(Landroidx/paging/PagingState;)V", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class PendingRequest<Key, Value> {
        private final LoadType loadType;
        private PagingState<Key, Value> pagingState;

        public PendingRequest(LoadType loadType, PagingState<Key, Value> pagingState) {
            Intrinsics.checkNotNullParameter(loadType, "loadType");
            Intrinsics.checkNotNullParameter(pagingState, "pagingState");
            this.loadType = loadType;
            this.pagingState = pagingState;
        }

        public final LoadType getLoadType() {
            return this.loadType;
        }

        public final PagingState<Key, Value> getPagingState() {
            return this.pagingState;
        }

        public final void setPagingState(PagingState<Key, Value> pagingState) {
            Intrinsics.checkNotNullParameter(pagingState, "<set-?>");
            this.pagingState = pagingState;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: RemoteMediatorAccessor.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/paging/AccessorState$BlockState;", "", "<init>", "(Ljava/lang/String;I)V", "UNBLOCKED", "COMPLETED", "REQUIRES_REFRESH", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class BlockState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ BlockState[] $VALUES;
        public static final BlockState UNBLOCKED = new BlockState("UNBLOCKED", 0);
        public static final BlockState COMPLETED = new BlockState("COMPLETED", 1);
        public static final BlockState REQUIRES_REFRESH = new BlockState("REQUIRES_REFRESH", 2);

        private static final /* synthetic */ BlockState[] $values() {
            return new BlockState[]{UNBLOCKED, COMPLETED, REQUIRES_REFRESH};
        }

        public static EnumEntries<BlockState> getEntries() {
            return $ENTRIES;
        }

        public static BlockState valueOf(String str) {
            return (BlockState) Enum.valueOf(BlockState.class, str);
        }

        public static BlockState[] values() {
            return (BlockState[]) $VALUES.clone();
        }

        private BlockState(String str, int i) {
        }

        static {
            BlockState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }
}
