package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import androidx.paging.PageEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CachedPagingData.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006J\u000e\u0010\u0014\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/paging/MulticastedPagingData;", ExifInterface.GPS_DIRECTION_TRUE, "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "parent", "Landroidx/paging/PagingData;", "tracker", "Landroidx/paging/ActiveFlowTracker;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/paging/PagingData;Landroidx/paging/ActiveFlowTracker;)V", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "getParent", "()Landroidx/paging/PagingData;", "getTracker", "()Landroidx/paging/ActiveFlowTracker;", "accumulated", "Landroidx/paging/CachedPageEventFlow;", "asPagingData", "close", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MulticastedPagingData<T> {
    private final CachedPageEventFlow<T> accumulated;
    private final PagingData<T> parent;
    private final CoroutineScope scope;
    private final ActiveFlowTracker tracker;

    public MulticastedPagingData(CoroutineScope scope, PagingData<T> parent, ActiveFlowTracker activeFlowTracker) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.scope = scope;
        this.parent = parent;
        this.tracker = activeFlowTracker;
        CachedPageEventFlow<T> cachedPageEventFlow = new CachedPageEventFlow<>(parent.getFlow$paging_common(), scope);
        if (activeFlowTracker != null) {
            activeFlowTracker.onNewCachedEventFlow(cachedPageEventFlow);
        }
        this.accumulated = cachedPageEventFlow;
    }

    public /* synthetic */ MulticastedPagingData(CoroutineScope coroutineScope, PagingData pagingData, ActiveFlowTracker activeFlowTracker, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineScope, pagingData, (i & 4) != 0 ? null : activeFlowTracker);
    }

    public final CoroutineScope getScope() {
        return this.scope;
    }

    public final PagingData<T> getParent() {
        return this.parent;
    }

    public final ActiveFlowTracker getTracker() {
        return this.tracker;
    }

    public final PagingData<T> asPagingData() {
        return new PagingData<>(FlowKt.onCompletion(FlowKt.onStart(this.accumulated.getDownstreamFlow(), new MulticastedPagingData$asPagingData$1(this, null)), new MulticastedPagingData$asPagingData$2(this, null)), this.parent.getUiReceiver$paging_common(), this.parent.getHintReceiver$paging_common(), new Function0() { // from class: androidx.paging.MulticastedPagingData$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                PageEvent.Insert cachedEvent$paging_common;
                cachedEvent$paging_common = MulticastedPagingData.this.accumulated.getCachedEvent$paging_common();
                return cachedEvent$paging_common;
            }
        });
    }

    public final Object close(Continuation<? super Unit> continuation) {
        this.accumulated.close();
        return Unit.INSTANCE;
    }
}
