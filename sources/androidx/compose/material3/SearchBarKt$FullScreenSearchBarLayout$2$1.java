package androidx.compose.material3;

import androidx.compose.material3.internal.BackEventProgress;
import androidx.compose.material3.internal.MutableWindowInsets;
import androidx.compose.material3.internal.SwipeEdge;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.compose.ui.util.MathHelpersKt;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SearchBar.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SearchBarKt$FullScreenSearchBarLayout$2$1 implements MeasurePolicy {
    final /* synthetic */ MutableState<BackEventProgress.InProgress> $firstInProgressValue;
    final /* synthetic */ MutableState<BackEventProgress.InProgress> $lastInProgressValue;
    final /* synthetic */ SearchBarState $state;
    final /* synthetic */ MutableWindowInsets $unconsumedInsets;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SearchBarKt$FullScreenSearchBarLayout$2$1(MutableState<BackEventProgress.InProgress> mutableState, SearchBarState searchBarState, MutableWindowInsets mutableWindowInsets, MutableState<BackEventProgress.InProgress> mutableState2) {
        this.$lastInProgressValue = mutableState;
        this.$state = searchBarState;
        this.$unconsumedInsets = mutableWindowInsets;
        this.$firstInProgressValue = mutableState2;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo41measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        float transform;
        IntRect collapsedBounds;
        IntRect collapsedBounds2;
        final MeasureScope measureScope2 = measureScope;
        List<? extends Measurable> list2 = list;
        final long j2 = j;
        transform = SearchBarKt.transform(this.$lastInProgressValue.getValue());
        collapsedBounds = SearchBarKt.getCollapsedBounds(this.$state);
        Integer valueOf = Integer.valueOf(collapsedBounds.getWidth());
        if (valueOf.intValue() == 0) {
            valueOf = null;
        }
        int intValue = valueOf != null ? valueOf.intValue() : measureScope2.mo399roundToPx0680j_4(SearchBarKt.getSearchBarMinWidth());
        collapsedBounds2 = SearchBarKt.getCollapsedBounds(this.$state);
        Integer valueOf2 = Integer.valueOf(collapsedBounds2.getHeight());
        Integer num = valueOf2.intValue() != 0 ? valueOf2 : null;
        int intValue2 = num != null ? num.intValue() : measureScope2.mo399roundToPx0680j_4(SearchBarDefaults.INSTANCE.m2414getInputFieldHeightD9Ej5fM());
        final int coerceAtLeast = RangesKt.coerceAtLeast(MathKt.roundToInt(Constraints.m7508getMaxWidthimpl(j2) * 0.9f), intValue);
        final int coerceAtLeast2 = RangesKt.coerceAtLeast(MathKt.roundToInt(Constraints.m7507getMaxHeightimpl(j2) * 0.9f), intValue2);
        int lerp = MathHelpersKt.lerp(Constraints.m7508getMaxWidthimpl(j2), coerceAtLeast, transform);
        int lerp2 = MathHelpersKt.lerp(Constraints.m7507getMaxHeightimpl(j2), coerceAtLeast2, transform);
        int m7525constrainWidthK40F9xA = ConstraintsKt.m7525constrainWidthK40F9xA(j2, MathHelpersKt.lerp(intValue, lerp, this.$state.getProgress()));
        int m7524constrainHeightK40F9xA = ConstraintsKt.m7524constrainHeightK40F9xA(j2, MathHelpersKt.lerp(intValue2, lerp2, this.$state.getProgress()));
        List<? extends Measurable> list3 = list2;
        int size = list3.size();
        int i = 0;
        while (i < size) {
            Measurable measurable = list2.get(i);
            final float f = transform;
            List<? extends Measurable> list4 = list3;
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "Surface")) {
                Placeable mo6216measureBRTryo0 = measurable.mo6216measureBRTryo0(Constraints.Companion.m7518fixedJhjzzOo(m7525constrainWidthK40F9xA, m7524constrainHeightK40F9xA));
                int size2 = list4.size();
                int i2 = 0;
                while (i2 < size2) {
                    Measurable measurable2 = list2.get(i2);
                    final Placeable placeable = mo6216measureBRTryo0;
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "InputField")) {
                        final Placeable mo6216measureBRTryo02 = measurable2.mo6216measureBRTryo0(Constraints.Companion.m7518fixedJhjzzOo(m7525constrainWidthK40F9xA, intValue2));
                        int top = this.$unconsumedInsets.getTop(measureScope2) + measureScope2.mo399roundToPx0680j_4(SearchBarKt.getSearchBarVerticalPadding());
                        int i3 = measureScope2.mo399roundToPx0680j_4(SearchBarKt.getSearchBarVerticalPadding());
                        final int lerp3 = MathHelpersKt.lerp(0, top, Math.min(this.$state.getProgress(), 1.0f - f));
                        int lerp4 = MathHelpersKt.lerp(0, i3, this.$state.getProgress());
                        int height = mo6216measureBRTryo02.getHeight() + lerp3 + lerp4;
                        int size3 = list4.size();
                        int i4 = 0;
                        while (i4 < size3) {
                            Measurable measurable3 = list2.get(i4);
                            int i5 = i4;
                            final int i6 = top;
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), "Content")) {
                                final Placeable mo6216measureBRTryo03 = measurable3.mo6216measureBRTryo0(ConstraintsKt.Constraints(m7525constrainWidthK40F9xA, m7525constrainWidthK40F9xA, 0, RangesKt.coerceAtLeast(m7524constrainHeightK40F9xA - height, 0)));
                                int m7508getMaxWidthimpl = Constraints.m7508getMaxWidthimpl(j2);
                                int m7507getMaxHeightimpl = Constraints.m7507getMaxHeightimpl(j2);
                                final int i7 = lerp4;
                                final MutableState<BackEventProgress.InProgress> mutableState = this.$lastInProgressValue;
                                final SearchBarState searchBarState = this.$state;
                                final MutableState<BackEventProgress.InProgress> mutableState2 = this.$firstInProgressValue;
                                return MeasureScope.layout$default(measureScope, m7508getMaxWidthimpl, m7507getMaxHeightimpl, null, new Function1() { // from class: androidx.compose.material3.SearchBarKt$FullScreenSearchBarLayout$2$1$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return SearchBarKt$FullScreenSearchBarLayout$2$1.measure_3p2s80s$lambda$6(MutableState.this, f, searchBarState, placeable, mo6216measureBRTryo02, lerp3, mo6216measureBRTryo03, i7, j2, measureScope2, coerceAtLeast, mutableState2, coerceAtLeast2, i6, (Placeable.PlacementScope) obj);
                                    }
                                }, 4, null);
                            }
                            measureScope2 = measureScope;
                            j2 = j;
                            i4 = i5 + 1;
                            top = i6;
                            lerp4 = lerp4;
                            list2 = list;
                        }
                        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                        throw new KotlinNothingValueException();
                    }
                    i2++;
                    measureScope2 = measureScope;
                    list2 = list;
                    j2 = j;
                    mo6216measureBRTryo0 = placeable;
                }
                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                throw new KotlinNothingValueException();
            }
            i++;
            measureScope2 = measureScope;
            list2 = list;
            j2 = j;
            transform = f;
            list3 = list4;
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    private static final int measure_3p2s80s$lambda$6$endOffsetX(BackEventProgress.InProgress inProgress, long j, MeasureScope measureScope, int i, SearchBarState searchBarState) {
        float f;
        int i2;
        IntRect collapsedBounds;
        IntRect collapsedBounds2;
        float f2;
        if (inProgress.getSwipeEdge() != SwipeEdge.Left) {
            f = SearchBarKt.SearchBarPredictiveBackMinMargin;
            i2 = measureScope.mo399roundToPx0680j_4(f);
        } else {
            int m7508getMaxWidthimpl = Constraints.m7508getMaxWidthimpl(j);
            f2 = SearchBarKt.SearchBarPredictiveBackMinMargin;
            i2 = (m7508getMaxWidthimpl - measureScope.mo399roundToPx0680j_4(f2)) - i;
        }
        collapsedBounds = SearchBarKt.getCollapsedBounds(searchBarState);
        int coerceAtLeast = RangesKt.coerceAtLeast(i2, collapsedBounds.getRight() - i);
        collapsedBounds2 = SearchBarKt.getCollapsedBounds(searchBarState);
        return RangesKt.coerceAtMost(coerceAtLeast, collapsedBounds2.getLeft());
    }

    private static final int measure_3p2s80s$lambda$6$endOffsetY(BackEventProgress.InProgress inProgress, MutableState<BackEventProgress.InProgress> mutableState, long j, int i, MeasureScope measureScope, int i2, SearchBarState searchBarState) {
        float f;
        float f2;
        IntRect collapsedBounds;
        float touchY = inProgress.getTouchY();
        BackEventProgress.InProgress value = mutableState.getValue();
        if (value != null) {
            float touchY2 = touchY - value.getTouchY();
            f = SearchBarKt.SearchBarPredictiveBackMinMargin;
            int coerceAtLeast = RangesKt.coerceAtLeast(((Constraints.m7507getMaxHeightimpl(j) - i) / 2) - measureScope.mo399roundToPx0680j_4(f), 0);
            f2 = SearchBarKt.SearchBarPredictiveBackMaxOffsetY;
            int min = Math.min(coerceAtLeast, measureScope.mo399roundToPx0680j_4(f2));
            collapsedBounds = SearchBarKt.getCollapsedBounds(searchBarState);
            return RangesKt.coerceAtMost((MathHelpersKt.lerp(0, min, Math.abs(touchY2) / Constraints.m7507getMaxHeightimpl(j)) * ((int) Math.signum(touchY2))) + i2, collapsedBounds.getTop());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit measure_3p2s80s$lambda$6(MutableState mutableState, float f, final SearchBarState searchBarState, Placeable placeable, Placeable placeable2, int i, Placeable placeable3, int i2, long j, MeasureScope measureScope, int i3, MutableState mutableState2, int i4, int i5, Placeable.PlacementScope placementScope) {
        IntRect collapsedBounds;
        IntRect collapsedBounds2;
        BackEventProgress.InProgress inProgress = (BackEventProgress.InProgress) mutableState.getValue();
        int lerp = MathHelpersKt.lerp(0, inProgress != null ? measure_3p2s80s$lambda$6$endOffsetX(inProgress, j, measureScope, i3, searchBarState) : 0, f);
        BackEventProgress.InProgress inProgress2 = (BackEventProgress.InProgress) mutableState.getValue();
        int lerp2 = MathHelpersKt.lerp(0, inProgress2 != null ? measure_3p2s80s$lambda$6$endOffsetY(inProgress2, mutableState2, j, i4, measureScope, i5, searchBarState) : 0, f);
        collapsedBounds = SearchBarKt.getCollapsedBounds(searchBarState);
        int lerp3 = MathHelpersKt.lerp(collapsedBounds.getLeft(), lerp, searchBarState.getProgress());
        collapsedBounds2 = SearchBarKt.getCollapsedBounds(searchBarState);
        int lerp4 = MathHelpersKt.lerp(collapsedBounds2.getTop(), lerp2, searchBarState.getProgress());
        Placeable.PlacementScope.place$default(placementScope, placeable, lerp3, lerp4, 0.0f, 4, null);
        int i6 = lerp4 + i;
        Placeable.PlacementScope.place$default(placementScope, placeable2, lerp3, i6, 0.0f, 4, null);
        Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable3, lerp3, i6 + placeable2.getHeight() + i2, 0.0f, new Function1() { // from class: androidx.compose.material3.SearchBarKt$FullScreenSearchBarLayout$2$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SearchBarKt$FullScreenSearchBarLayout$2$1.measure_3p2s80s$lambda$6$lambda$5(SearchBarState.this, (GraphicsLayerScope) obj);
            }
        }, 4, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit measure_3p2s80s$lambda$6$lambda$5(SearchBarState searchBarState, GraphicsLayerScope graphicsLayerScope) {
        graphicsLayerScope.setAlpha(searchBarState.getProgress());
        return Unit.INSTANCE;
    }
}
