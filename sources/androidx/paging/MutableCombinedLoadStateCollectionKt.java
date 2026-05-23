package androidx.paging;

import androidx.paging.LoadState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MutableCombinedLoadStateCollection.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a \u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0000\u001a*\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0002¨\u0006\u000b"}, d2 = {"computeNewState", "Landroidx/paging/CombinedLoadStates;", "newSource", "Landroidx/paging/LoadStates;", "newRemote", "computeHelperState", "Landroidx/paging/LoadState;", "previousState", "sourceRefreshState", "sourceState", "remoteState", "paging-common"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MutableCombinedLoadStateCollectionKt {
    public static final CombinedLoadStates computeNewState(CombinedLoadStates combinedLoadStates, LoadStates newSource, LoadStates loadStates) {
        LoadState.NotLoading incomplete$paging_common;
        LoadState.NotLoading incomplete$paging_common2;
        LoadState.NotLoading incomplete$paging_common3;
        Intrinsics.checkNotNullParameter(newSource, "newSource");
        if (combinedLoadStates == null || (incomplete$paging_common = combinedLoadStates.getRefresh()) == null) {
            incomplete$paging_common = LoadState.NotLoading.Companion.getIncomplete$paging_common();
        }
        LoadState computeHelperState = computeHelperState(incomplete$paging_common, newSource.getRefresh(), newSource.getRefresh(), loadStates != null ? loadStates.getRefresh() : null);
        if (combinedLoadStates == null || (incomplete$paging_common2 = combinedLoadStates.getPrepend()) == null) {
            incomplete$paging_common2 = LoadState.NotLoading.Companion.getIncomplete$paging_common();
        }
        LoadState computeHelperState2 = computeHelperState(incomplete$paging_common2, newSource.getRefresh(), newSource.getPrepend(), loadStates != null ? loadStates.getPrepend() : null);
        if (combinedLoadStates == null || (incomplete$paging_common3 = combinedLoadStates.getAppend()) == null) {
            incomplete$paging_common3 = LoadState.NotLoading.Companion.getIncomplete$paging_common();
        }
        return new CombinedLoadStates(computeHelperState, computeHelperState2, computeHelperState(incomplete$paging_common3, newSource.getRefresh(), newSource.getAppend(), loadStates != null ? loadStates.getAppend() : null), newSource, loadStates);
    }

    private static final LoadState computeHelperState(LoadState loadState, LoadState loadState2, LoadState loadState3, LoadState loadState4) {
        return loadState4 == null ? loadState3 : (!(loadState instanceof LoadState.Loading) || ((loadState2 instanceof LoadState.NotLoading) && (loadState4 instanceof LoadState.NotLoading)) || (loadState4 instanceof LoadState.Error)) ? loadState4 : loadState;
    }
}
