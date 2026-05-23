package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
/* compiled from: ItemSnapshotListFlow.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001aB\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00050\u00012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¨\u0006\n"}, d2 = {"asItemSnapshotListFlow", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/ItemSnapshotList;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/paging/PagingData;", "onLoadError", "Lkotlin/Function1;", "Landroidx/paging/CombinedLoadStates;", "", "paging-common"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ItemSnapshotListFlow {
    public static /* synthetic */ Flow asItemSnapshotListFlow$default(Flow flow, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Function1() { // from class: androidx.paging.ItemSnapshotListFlow$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return ItemSnapshotListFlow.asItemSnapshotListFlow$lambda$0((CombinedLoadStates) obj2);
                }
            };
        }
        return asItemSnapshotListFlow(flow, function1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit asItemSnapshotListFlow$lambda$0(CombinedLoadStates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public static final <T> Flow<ItemSnapshotList<T>> asItemSnapshotListFlow(Flow<PagingData<T>> flow, Function1<? super CombinedLoadStates, Unit> onLoadError) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(onLoadError, "onLoadError");
        return FlowKt.channelFlow(new ItemSnapshotListFlow$asItemSnapshotListFlow$2(flow, new Ref.ObjectRef(), onLoadError, null));
    }
}
