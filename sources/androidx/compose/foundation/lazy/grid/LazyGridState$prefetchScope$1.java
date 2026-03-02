package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
/* compiled from: LazyGridState.kt */
@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J1\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0019\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\b\u000bH\u0016¨\u0006\f"}, d2 = {"androidx/compose/foundation/lazy/grid/LazyGridState$prefetchScope$1", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchScope;", "scheduleLinePrefetch", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "lineIndex", "", "onPrefetchFinished", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchResultScope;", "", "Lkotlin/ExtensionFunctionType;", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyGridState$prefetchScope$1 implements LazyGridPrefetchScope {
    final /* synthetic */ LazyGridState this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LazyGridState$prefetchScope$1(LazyGridState lazyGridState) {
        this.this$0 = lazyGridState;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridPrefetchScope
    public List<LazyLayoutPrefetchState.PrefetchHandle> scheduleLinePrefetch(int i) {
        return scheduleLinePrefetch(i, null);
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridPrefetchScope
    public List<LazyLayoutPrefetchState.PrefetchHandle> scheduleLinePrefetch(final int i, final Function1<? super LazyGridPrefetchResultScope, Unit> function1) {
        MutableState mutableState;
        LazyGridMeasureResult lazyGridMeasureResult;
        boolean z;
        ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = function1 == null ? null : new ArrayList();
        Snapshot.Companion companion = Snapshot.Companion;
        LazyGridState lazyGridState = this.this$0;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            if (!lazyGridState.getHasLookaheadOccurred$foundation()) {
                mutableState = lazyGridState.layoutInfoState;
                lazyGridMeasureResult = (LazyGridMeasureResult) mutableState.getValue();
            } else {
                lazyGridMeasureResult = lazyGridState.getApproachLayoutInfo$foundation();
            }
            final LazyGridMeasureResult lazyGridMeasureResult2 = lazyGridMeasureResult;
            if (lazyGridMeasureResult2 != null) {
                final Ref.IntRef intRef = new Ref.IntRef();
                intRef.element = 1;
                final List<Pair<Integer, Constraints>> invoke = lazyGridMeasureResult2.getPrefetchInfoRetriever().invoke(Integer.valueOf(i));
                int size = invoke.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Pair<Integer, Constraints> pair = invoke.get(i2);
                    LazyLayoutPrefetchState prefetchState$foundation = lazyGridState.getPrefetchState$foundation();
                    int intValue = pair.getFirst().intValue();
                    long m7514unboximpl = pair.getSecond().m7514unboximpl();
                    z = lazyGridState.executeRequestsInHighPriorityMode;
                    arrayList.add(prefetchState$foundation.m1001schedulePrecompositionAndPremeasure_EkL_Y$foundation(intValue, m7514unboximpl, z, new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridState$prefetchScope$1$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit scheduleLinePrefetch$lambda$0$0$0$0;
                            scheduleLinePrefetch$lambda$0$0$0$0 = LazyGridState$prefetchScope$1.scheduleLinePrefetch$lambda$0$0$0$0(arrayList2, intRef, invoke, function1, i, lazyGridMeasureResult2, (LazyLayoutPrefetchState.PrefetchResultScope) obj);
                            return scheduleLinePrefetch$lambda$0$0$0$0;
                        }
                    }));
                }
                Unit unit = Unit.INSTANCE;
            }
            return arrayList;
        } finally {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit scheduleLinePrefetch$lambda$0$0$0$0(List list, Ref.IntRef intRef, List list2, Function1 function1, int i, LazyGridMeasureResult lazyGridMeasureResult, LazyLayoutPrefetchState.PrefetchResultScope prefetchResultScope) {
        long mo1003getSizeYEO4UFw;
        int placeablesCount = prefetchResultScope.getPlaceablesCount();
        int i2 = 0;
        for (int i3 = 0; i3 < placeablesCount; i3++) {
            if (lazyGridMeasureResult.getOrientation() == Orientation.Vertical) {
                mo1003getSizeYEO4UFw = prefetchResultScope.mo1003getSizeYEO4UFw(i3) & 4294967295L;
            } else {
                mo1003getSizeYEO4UFw = prefetchResultScope.mo1003getSizeYEO4UFw(i3) >> 32;
            }
            i2 += (int) mo1003getSizeYEO4UFw;
        }
        if (list != null) {
            list.add(Integer.valueOf(i2));
        }
        if (intRef.element != list2.size()) {
            intRef.element++;
        } else if (function1 != null && list != null) {
            function1.invoke(new LazyGridPrefetchResultScopeImpl(i, list));
        }
        return Unit.INSTANCE;
    }
}
