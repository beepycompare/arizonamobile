package androidx.paging;

import androidx.paging.LoadState;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MutableLoadStateCollection.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0005J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u001a"}, d2 = {"Landroidx/paging/MutableLoadStateCollection;", "", "<init>", "()V", "refresh", "Landroidx/paging/LoadState;", "getRefresh", "()Landroidx/paging/LoadState;", "setRefresh", "(Landroidx/paging/LoadState;)V", "prepend", "getPrepend", "setPrepend", "append", "getAppend", "setAppend", "snapshot", "Landroidx/paging/LoadStates;", "get", "loadType", "Landroidx/paging/LoadType;", "set", "", "type", RemoteConfigConstants.ResponseFieldKey.STATE, "states", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MutableLoadStateCollection {
    private LoadState refresh = LoadState.NotLoading.Companion.getIncomplete$paging_common();
    private LoadState prepend = LoadState.NotLoading.Companion.getIncomplete$paging_common();
    private LoadState append = LoadState.NotLoading.Companion.getIncomplete$paging_common();

    /* compiled from: MutableLoadStateCollection.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoadType.values().length];
            try {
                iArr[LoadType.REFRESH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadType.APPEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LoadType.PREPEND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final LoadState getRefresh() {
        return this.refresh;
    }

    public final void setRefresh(LoadState loadState) {
        Intrinsics.checkNotNullParameter(loadState, "<set-?>");
        this.refresh = loadState;
    }

    public final LoadState getPrepend() {
        return this.prepend;
    }

    public final void setPrepend(LoadState loadState) {
        Intrinsics.checkNotNullParameter(loadState, "<set-?>");
        this.prepend = loadState;
    }

    public final LoadState getAppend() {
        return this.append;
    }

    public final void setAppend(LoadState loadState) {
        Intrinsics.checkNotNullParameter(loadState, "<set-?>");
        this.append = loadState;
    }

    public final LoadStates snapshot() {
        return new LoadStates(this.refresh, this.prepend, this.append);
    }

    public final LoadState get(LoadType loadType) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        int i = WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                return this.prepend;
            }
            return this.append;
        }
        return this.refresh;
    }

    public final void set(LoadType type, LoadState state) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(state, "state");
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            this.refresh = state;
        } else if (i == 2) {
            this.append = state;
        } else if (i != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            this.prepend = state;
        }
    }

    public final void set(LoadStates states) {
        Intrinsics.checkNotNullParameter(states, "states");
        this.refresh = states.getRefresh();
        this.append = states.getAppend();
        this.prepend = states.getPrepend();
    }
}
