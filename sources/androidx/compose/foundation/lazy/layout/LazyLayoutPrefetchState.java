package androidx.compose.foundation.lazy.layout;

import com.facebook.widget.FacebookDialog;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: LazyLayoutPrefetchState.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0003;<=B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B2\b\u0017\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u001b\b\u0002\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\n¢\u0006\u0004\b\u0002\u0010\u000bB&\b\u0017\u0012\u001b\b\u0002\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\n¢\u0006\u0004\b\u0002\u0010\fJ\u0010\u0010(\u001a\u00020)2\b\b\u0001\u0010*\u001a\u00020\u001dJ\u001d\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020,H\u0000¢\u0006\u0002\b-J<\u0010.\u001a\u00020)2\b\b\u0001\u0010*\u001a\u00020\u001d2\u0006\u0010/\u001a\u0002002\u001b\b\u0002\u00101\u001a\u0015\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\n¢\u0006\u0004\b3\u00104JD\u0010.\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001d2\u0006\u0010/\u001a\u0002002\u0006\u0010+\u001a\u00020,2\u001b\b\u0002\u00101\u001a\u0015\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\nH\u0000¢\u0006\u0004\b5\u00106J\u0013\u00107\u001a\b\u0012\u0004\u0012\u00020908H\u0000¢\u0006\u0002\b:R\"\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R'\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\nX\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0003R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u0003\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001a\u0010%\u001a\u00020\u001dX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!¨\u0006>"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "", "<init>", "()V", "prefetchScheduler", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "onNestedPrefetch", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/layout/NestedPrefetchScope;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;Lkotlin/jvm/functions/Function1;)V", "(Lkotlin/jvm/functions/Function1;)V", "getPrefetchScheduler$foundation_release$annotations", "getPrefetchScheduler$foundation_release", "()Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "setPrefetchScheduler$foundation_release", "(Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;)V", "getOnNestedPrefetch$annotations", "prefetchMetrics", "Landroidx/compose/foundation/lazy/layout/PrefetchMetrics;", "prefetchHandleProvider", "Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;", "getPrefetchHandleProvider$foundation_release$annotations", "getPrefetchHandleProvider$foundation_release", "()Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;", "setPrefetchHandleProvider$foundation_release", "(Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;)V", "realizedNestedPrefetchCount", "", "getRealizedNestedPrefetchCount$foundation_release", "()I", "setRealizedNestedPrefetchCount$foundation_release", "(I)V", "idealNestedPrefetchCount", "getIdealNestedPrefetchCount$foundation_release", "setIdealNestedPrefetchCount$foundation_release", "lastNumberOfNestedPrefetchItems", "getLastNumberOfNestedPrefetchItems$foundation_release", "setLastNumberOfNestedPrefetchItems$foundation_release", "schedulePrecomposition", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", FirebaseAnalytics.Param.INDEX, "isHighPriority", "", "schedulePrecomposition$foundation_release", "schedulePrecompositionAndPremeasure", "constraints", "Landroidx/compose/ui/unit/Constraints;", "onItemPremeasured", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchResultScope;", "schedulePrecompositionAndPremeasure-VKLhPVY", "(IJLkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "schedulePrecompositionAndPremeasure-_EkL_-Y$foundation_release", "(IJZLkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "collectNestedPrefetchRequests", "", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "collectNestedPrefetchRequests$foundation_release", "PrefetchHandle", "PrefetchResultScope", "NestedPrefetchScopeImpl", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyLayoutPrefetchState {
    public static final int $stable = 0;
    private int idealNestedPrefetchCount;
    private int lastNumberOfNestedPrefetchItems;
    private Function1<? super NestedPrefetchScope, Unit> onNestedPrefetch;
    private PrefetchHandleProvider prefetchHandleProvider;
    private final PrefetchMetrics prefetchMetrics;
    private PrefetchScheduler prefetchScheduler;
    private int realizedNestedPrefetchCount;

    /* compiled from: LazyLayoutPrefetchState.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&\u0082\u0001\u0002\u0005\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "", FacebookDialog.COMPLETION_GESTURE_CANCEL, "", "markAsUrgent", "Landroidx/compose/foundation/lazy/layout/DummyHandle;", "Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface PrefetchHandle {
        void cancel();

        void markAsUrgent();
    }

    /* compiled from: LazyLayoutPrefetchState.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\u0019\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u0003H&¢\u0006\u0004\b\u000b\u0010\fR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005\u0082\u0001\u0001\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchResultScope;", "", "placeablesCount", "", "getPlaceablesCount", "()I", FirebaseAnalytics.Param.INDEX, "getIndex", "getSize", "Landroidx/compose/ui/unit/IntSize;", "placeableIndex", "getSize-YEO4UFw", "(I)J", "Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface PrefetchResultScope {
        int getIndex();

        int getPlaceablesCount();

        /* renamed from: getSize-YEO4UFw  reason: not valid java name */
        long mo1063getSizeYEO4UFw(int i);
    }

    private static /* synthetic */ void getOnNestedPrefetch$annotations() {
    }

    public static /* synthetic */ void getPrefetchHandleProvider$foundation_release$annotations() {
    }

    public static /* synthetic */ void getPrefetchScheduler$foundation_release$annotations() {
    }

    public LazyLayoutPrefetchState() {
        this.prefetchMetrics = new PrefetchMetrics();
        this.realizedNestedPrefetchCount = -1;
        this.idealNestedPrefetchCount = -1;
    }

    public /* synthetic */ LazyLayoutPrefetchState(PrefetchScheduler prefetchScheduler, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : prefetchScheduler, (i & 2) != 0 ? null : function1);
    }

    @Deprecated(message = "Please use overload without Prefetch Scheduler.")
    public LazyLayoutPrefetchState(PrefetchScheduler prefetchScheduler, Function1<? super NestedPrefetchScope, Unit> function1) {
        this();
        this.prefetchScheduler = prefetchScheduler;
        this.onNestedPrefetch = function1;
    }

    public /* synthetic */ LazyLayoutPrefetchState(Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function1);
    }

    public LazyLayoutPrefetchState(Function1<? super NestedPrefetchScope, Unit> function1) {
        this();
        this.onNestedPrefetch = function1;
    }

    public final PrefetchScheduler getPrefetchScheduler$foundation_release() {
        return this.prefetchScheduler;
    }

    public final void setPrefetchScheduler$foundation_release(PrefetchScheduler prefetchScheduler) {
        this.prefetchScheduler = prefetchScheduler;
    }

    public final PrefetchHandleProvider getPrefetchHandleProvider$foundation_release() {
        return this.prefetchHandleProvider;
    }

    public final void setPrefetchHandleProvider$foundation_release(PrefetchHandleProvider prefetchHandleProvider) {
        this.prefetchHandleProvider = prefetchHandleProvider;
    }

    public final int getRealizedNestedPrefetchCount$foundation_release() {
        return this.realizedNestedPrefetchCount;
    }

    public final void setRealizedNestedPrefetchCount$foundation_release(int i) {
        this.realizedNestedPrefetchCount = i;
    }

    public final int getIdealNestedPrefetchCount$foundation_release() {
        return this.idealNestedPrefetchCount;
    }

    public final void setIdealNestedPrefetchCount$foundation_release(int i) {
        this.idealNestedPrefetchCount = i;
    }

    public final int getLastNumberOfNestedPrefetchItems$foundation_release() {
        return this.lastNumberOfNestedPrefetchItems;
    }

    public final void setLastNumberOfNestedPrefetchItems$foundation_release(int i) {
        this.lastNumberOfNestedPrefetchItems = i;
    }

    public final PrefetchHandle schedulePrecomposition(int i) {
        return schedulePrecomposition$foundation_release(i, true);
    }

    public final PrefetchHandle schedulePrecomposition$foundation_release(int i, boolean z) {
        PrefetchHandle schedulePrecomposition;
        PrefetchHandleProvider prefetchHandleProvider = this.prefetchHandleProvider;
        return (prefetchHandleProvider == null || (schedulePrecomposition = prefetchHandleProvider.schedulePrecomposition(i, z, this.prefetchMetrics)) == null) ? DummyHandle.INSTANCE : schedulePrecomposition;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: schedulePrecompositionAndPremeasure-VKLhPVY$default  reason: not valid java name */
    public static /* synthetic */ PrefetchHandle m1058schedulePrecompositionAndPremeasureVKLhPVY$default(LazyLayoutPrefetchState lazyLayoutPrefetchState, int i, long j, Function1 function1, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        return lazyLayoutPrefetchState.m1060schedulePrecompositionAndPremeasureVKLhPVY(i, j, function1);
    }

    /* renamed from: schedulePrecompositionAndPremeasure-VKLhPVY  reason: not valid java name */
    public final PrefetchHandle m1060schedulePrecompositionAndPremeasureVKLhPVY(int i, long j, Function1<? super PrefetchResultScope, Unit> function1) {
        return m1061schedulePrecompositionAndPremeasure_EkL_Y$foundation_release(i, j, true, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: schedulePrecompositionAndPremeasure-_EkL_-Y$foundation_release$default  reason: not valid java name */
    public static /* synthetic */ PrefetchHandle m1059xe6b2911(LazyLayoutPrefetchState lazyLayoutPrefetchState, int i, long j, boolean z, Function1 function1, int i2, Object obj) {
        Function1<? super PrefetchResultScope, Unit> function12 = function1;
        if ((i2 & 8) != 0) {
            function12 = null;
        }
        return lazyLayoutPrefetchState.m1061schedulePrecompositionAndPremeasure_EkL_Y$foundation_release(i, j, z, function12);
    }

    /* renamed from: schedulePrecompositionAndPremeasure-_EkL_-Y$foundation_release  reason: not valid java name */
    public final PrefetchHandle m1061schedulePrecompositionAndPremeasure_EkL_Y$foundation_release(int i, long j, boolean z, Function1<? super PrefetchResultScope, Unit> function1) {
        PrefetchHandle m1083schedulePremeasurem8Kt_7k;
        PrefetchHandleProvider prefetchHandleProvider = this.prefetchHandleProvider;
        return (prefetchHandleProvider == null || (m1083schedulePremeasurem8Kt_7k = prefetchHandleProvider.m1083schedulePremeasurem8Kt_7k(i, j, this.prefetchMetrics, z, function1)) == null) ? DummyHandle.INSTANCE : m1083schedulePremeasurem8Kt_7k;
    }

    public final List<PrefetchRequest> collectNestedPrefetchRequests$foundation_release() {
        Function1<? super NestedPrefetchScope, Unit> function1 = this.onNestedPrefetch;
        if (function1 == null) {
            return CollectionsKt.emptyList();
        }
        NestedPrefetchScopeImpl nestedPrefetchScopeImpl = new NestedPrefetchScopeImpl(this.realizedNestedPrefetchCount);
        function1.invoke(nestedPrefetchScopeImpl);
        List<PrefetchRequest> requests = nestedPrefetchScopeImpl.getRequests();
        this.lastNumberOfNestedPrefetchItems = requests.size();
        return requests;
    }

    /* compiled from: LazyLayoutPrefetchState.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u001f\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$NestedPrefetchScopeImpl;", "Landroidx/compose/foundation/lazy/layout/NestedPrefetchScope;", "nestedPrefetchItemCount", "", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;I)V", "getNestedPrefetchItemCount", "()I", "requests", "", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "getRequests", "()Ljava/util/List;", "_requests", "", "schedulePrecomposition", "", FirebaseAnalytics.Param.INDEX, "schedulePrecompositionAndPremeasure", "constraints", "Landroidx/compose/ui/unit/Constraints;", "schedulePrecompositionAndPremeasure-0kLqBqw", "(IJ)V", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    private final class NestedPrefetchScopeImpl implements NestedPrefetchScope {
        private final List<PrefetchRequest> _requests = new ArrayList();
        private final int nestedPrefetchItemCount;

        public NestedPrefetchScopeImpl(int i) {
            this.nestedPrefetchItemCount = i;
        }

        @Override // androidx.compose.foundation.lazy.layout.NestedPrefetchScope
        public int getNestedPrefetchItemCount() {
            return this.nestedPrefetchItemCount;
        }

        public final List<PrefetchRequest> getRequests() {
            return this._requests;
        }

        @Override // androidx.compose.foundation.lazy.layout.NestedPrefetchScope
        public void schedulePrecomposition(int i) {
            PrefetchHandleProvider prefetchHandleProvider$foundation_release = LazyLayoutPrefetchState.this.getPrefetchHandleProvider$foundation_release();
            if (prefetchHandleProvider$foundation_release == null) {
                return;
            }
            this._requests.add(prefetchHandleProvider$foundation_release.createNestedPrefetchRequest(i, LazyLayoutPrefetchState.this.prefetchMetrics));
        }

        @Override // androidx.compose.foundation.lazy.layout.NestedPrefetchScope
        /* renamed from: schedulePrecompositionAndPremeasure-0kLqBqw  reason: not valid java name */
        public void mo1062schedulePrecompositionAndPremeasure0kLqBqw(int i, long j) {
            PrefetchHandleProvider prefetchHandleProvider$foundation_release = LazyLayoutPrefetchState.this.getPrefetchHandleProvider$foundation_release();
            if (prefetchHandleProvider$foundation_release == null) {
                return;
            }
            this._requests.add(prefetchHandleProvider$foundation_release.m1082createNestedPrefetchRequestVKLhPVY(i, j, LazyLayoutPrefetchState.this.prefetchMetrics));
        }
    }
}
