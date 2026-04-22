package androidx.compose.material3;

import androidx.activity.BackEventCompat;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.material3.internal.MutableWindowInsets;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
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
public final class SearchBarKt$SearchBarLayout$2$1 implements MeasurePolicy {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $animationProgress;
    final /* synthetic */ MutableState<BackEventCompat> $currentBackEvent;
    final /* synthetic */ MutableFloatState $finalBackProgress;
    final /* synthetic */ MutableState<BackEventCompat> $firstBackEvent;
    final /* synthetic */ MutableWindowInsets $unconsumedInsets;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SearchBarKt$SearchBarLayout$2$1(Animatable<Float, AnimationVector1D> animatable, MutableWindowInsets mutableWindowInsets, MutableState<BackEventCompat> mutableState, MutableFloatState mutableFloatState, MutableState<BackEventCompat> mutableState2) {
        this.$animationProgress = animatable;
        this.$unconsumedInsets = mutableWindowInsets;
        this.$currentBackEvent = mutableState;
        this.$finalBackProgress = mutableFloatState;
        this.$firstBackEvent = mutableState2;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo41measure3p2s80s(final MeasureScope measureScope, List<? extends Measurable> list, final long j) {
        Measurable measurable;
        final float calculatePredictiveBackMultiplier;
        final Placeable placeable;
        int i;
        int m7507getMaxHeightimpl;
        MeasureScope measureScope2 = measureScope;
        long j2 = j;
        final float floatValue = this.$animationProgress.getValue().floatValue();
        List<? extends Measurable> list2 = list;
        int size = list2.size();
        int i2 = 0;
        while (i2 < size) {
            Measurable measurable2 = list.get(i2);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "InputField")) {
                int size2 = list2.size();
                int i3 = 0;
                while (i3 < size2) {
                    Measurable measurable3 = list.get(i3);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), "Surface")) {
                        int size3 = list2.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 >= size3) {
                                measurable = null;
                                break;
                            }
                            measurable = list.get(i4);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "Content")) {
                                break;
                            }
                            i4++;
                        }
                        Measurable measurable4 = measurable;
                        final int top = this.$unconsumedInsets.getTop(measureScope2) + measureScope2.mo399roundToPx0680j_4(SearchBarKt.getSearchBarVerticalPadding());
                        int i5 = measureScope2.mo399roundToPx0680j_4(SearchBarKt.getSearchBarVerticalPadding());
                        int m7525constrainWidthK40F9xA = ConstraintsKt.m7525constrainWidthK40F9xA(j2, measurable2.maxIntrinsicWidth(Constraints.m7507getMaxHeightimpl(j2)));
                        int m7524constrainHeightK40F9xA = ConstraintsKt.m7524constrainHeightK40F9xA(j2, measurable2.minIntrinsicHeight(Constraints.m7508getMaxWidthimpl(j2)));
                        int roundToInt = MathKt.roundToInt(Constraints.m7508getMaxWidthimpl(j2) * 0.9f);
                        int roundToInt2 = MathKt.roundToInt(Constraints.m7507getMaxHeightimpl(j2) * 0.9f);
                        calculatePredictiveBackMultiplier = SearchBarKt.calculatePredictiveBackMultiplier(this.$currentBackEvent.getValue(), floatValue, this.$finalBackProgress.getFloatValue());
                        int lerp = MathHelpersKt.lerp(m7525constrainWidthK40F9xA, roundToInt, calculatePredictiveBackMultiplier);
                        int i6 = top + m7524constrainHeightK40F9xA;
                        int lerp2 = MathHelpersKt.lerp(i6, roundToInt2, calculatePredictiveBackMultiplier);
                        int m7508getMaxWidthimpl = Constraints.m7508getMaxWidthimpl(j2);
                        int m7507getMaxHeightimpl2 = Constraints.m7507getMaxHeightimpl(j2);
                        int lerp3 = MathHelpersKt.lerp(lerp, m7508getMaxWidthimpl, floatValue);
                        final int lerp4 = MathHelpersKt.lerp(lerp2, m7507getMaxHeightimpl2, floatValue);
                        final int lerp5 = MathHelpersKt.lerp(top, 0, floatValue);
                        final int lerp6 = MathHelpersKt.lerp(0, i5, floatValue);
                        final Placeable mo6216measureBRTryo0 = measurable2.mo6216measureBRTryo0(ConstraintsKt.Constraints(lerp3, m7508getMaxWidthimpl, m7524constrainHeightK40F9xA, m7524constrainHeightK40F9xA));
                        int width = mo6216measureBRTryo0.getWidth();
                        final Placeable mo6216measureBRTryo02 = measurable3.mo6216measureBRTryo0(Constraints.Companion.m7518fixedJhjzzOo(width, lerp4 - lerp5));
                        if (measurable4 != null) {
                            if (Constraints.m7503getHasBoundedHeightimpl(j2)) {
                                i = 0;
                                m7507getMaxHeightimpl = RangesKt.coerceAtLeast(Constraints.m7507getMaxHeightimpl(j2) - (i6 + i5), 0);
                            } else {
                                i = 0;
                                m7507getMaxHeightimpl = Constraints.m7507getMaxHeightimpl(j2);
                            }
                            placeable = measurable4.mo6216measureBRTryo0(ConstraintsKt.Constraints(width, width, i, m7507getMaxHeightimpl));
                        } else {
                            placeable = null;
                        }
                        final MutableState<BackEventCompat> mutableState = this.$currentBackEvent;
                        final MutableState<BackEventCompat> mutableState2 = this.$firstBackEvent;
                        return MeasureScope.layout$default(measureScope, width, lerp4, null, new Function1() { // from class: androidx.compose.material3.SearchBarKt$SearchBarLayout$2$1$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return SearchBarKt$SearchBarLayout$2$1.measure_3p2s80s$lambda$3(MeasureScope.this, j, mutableState, floatValue, calculatePredictiveBackMultiplier, mutableState2, lerp4, mo6216measureBRTryo02, lerp5, mo6216measureBRTryo0, top, placeable, lerp6, (Placeable.PlacementScope) obj);
                            }
                        }, 4, null);
                    }
                    i3++;
                    measureScope2 = measureScope;
                    j2 = j;
                }
                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                throw new KotlinNothingValueException();
            }
            i2++;
            measureScope2 = measureScope;
            j2 = j;
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit measure_3p2s80s$lambda$3(MeasureScope measureScope, long j, MutableState mutableState, float f, float f2, MutableState mutableState2, int i, Placeable placeable, int i2, Placeable placeable2, int i3, Placeable placeable3, int i4, Placeable.PlacementScope placementScope) {
        float f3;
        int m2436calculatePredictiveBackOffsetXrOvwMX4;
        float f4;
        int m2437calculatePredictiveBackOffsetYdzo92Q0;
        f3 = SearchBarKt.SearchBarPredictiveBackMinMargin;
        int i5 = measureScope.mo399roundToPx0680j_4(f3);
        m2436calculatePredictiveBackOffsetXrOvwMX4 = SearchBarKt.m2436calculatePredictiveBackOffsetXrOvwMX4(j, i5, (BackEventCompat) mutableState.getValue(), measureScope.getLayoutDirection(), f, f2);
        BackEventCompat backEventCompat = (BackEventCompat) mutableState.getValue();
        BackEventCompat backEventCompat2 = (BackEventCompat) mutableState2.getValue();
        f4 = SearchBarKt.SearchBarPredictiveBackMaxOffsetY;
        m2437calculatePredictiveBackOffsetYdzo92Q0 = SearchBarKt.m2437calculatePredictiveBackOffsetYdzo92Q0(j, i5, backEventCompat, backEventCompat2, i, measureScope.mo399roundToPx0680j_4(f4), f2);
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, m2436calculatePredictiveBackOffsetXrOvwMX4, m2437calculatePredictiveBackOffsetYdzo92Q0 + i2, 0.0f, 4, null);
        int i6 = m2437calculatePredictiveBackOffsetYdzo92Q0 + i3;
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, m2436calculatePredictiveBackOffsetXrOvwMX4, i6, 0.0f, 4, null);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, m2436calculatePredictiveBackOffsetXrOvwMX4, i6 + placeable2.getHeight() + i4, 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }
}
