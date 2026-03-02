package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.snapshots.Snapshot;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
/* compiled from: LazyListState.kt */
@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0019\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\nH\u0016¨\u0006\u000b"}, d2 = {"androidx/compose/foundation/lazy/LazyListState$prefetchScope$1", "Landroidx/compose/foundation/lazy/LazyListPrefetchScope;", "schedulePrefetch", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", FirebaseAnalytics.Param.INDEX, "", "onPrefetchFinished", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListPrefetchResultScope;", "", "Lkotlin/ExtensionFunctionType;", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyListState$prefetchScope$1 implements LazyListPrefetchScope {
    final /* synthetic */ LazyListState this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LazyListState$prefetchScope$1(LazyListState lazyListState) {
        this.this$0 = lazyListState;
    }

    @Override // androidx.compose.foundation.lazy.LazyListPrefetchScope
    public LazyLayoutPrefetchState.PrefetchHandle schedulePrefetch(final int i, final Function1<? super LazyListPrefetchResultScope, Unit> function1) {
        MutableState mutableState;
        boolean z;
        Snapshot.Companion companion = Snapshot.Companion;
        LazyListState lazyListState = this.this$0;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            mutableState = lazyListState.layoutInfoState;
            final LazyListMeasureResult lazyListMeasureResult = (LazyListMeasureResult) mutableState.getValue();
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            LazyLayoutPrefetchState prefetchState$foundation = this.this$0.getPrefetchState$foundation();
            long m927getChildConstraintsmsEJaDk = lazyListMeasureResult.m927getChildConstraintsmsEJaDk();
            z = this.this$0.executeRequestsInHighPriorityMode;
            return prefetchState$foundation.m1001schedulePrecompositionAndPremeasure_EkL_Y$foundation(i, m927getChildConstraintsmsEJaDk, z, new Function1() { // from class: androidx.compose.foundation.lazy.LazyListState$prefetchScope$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LazyListState$prefetchScope$1.schedulePrefetch$lambda$1(Function1.this, i, lazyListMeasureResult, (LazyLayoutPrefetchState.PrefetchResultScope) obj);
                }
            });
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit schedulePrefetch$lambda$1(Function1 function1, int i, LazyListMeasureResult lazyListMeasureResult, LazyLayoutPrefetchState.PrefetchResultScope prefetchResultScope) {
        long mo1003getSizeYEO4UFw;
        if (function1 != null) {
            int placeablesCount = prefetchResultScope.getPlaceablesCount();
            int i2 = 0;
            for (int i3 = 0; i3 < placeablesCount; i3++) {
                if (lazyListMeasureResult.getOrientation() == Orientation.Vertical) {
                    mo1003getSizeYEO4UFw = prefetchResultScope.mo1003getSizeYEO4UFw(i3) & 4294967295L;
                } else {
                    mo1003getSizeYEO4UFw = prefetchResultScope.mo1003getSizeYEO4UFw(i3) >> 32;
                }
                i2 += (int) mo1003getSizeYEO4UFw;
            }
            function1.invoke(new LazyListPrefetchResultScopeImpl(i, i2));
        }
        return Unit.INSTANCE;
    }
}
