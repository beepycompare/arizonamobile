package androidx.compose.material3;

import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.compose.ui.util.MathHelpersKt;
import com.google.firebase.messaging.Constants;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NavigationItem.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010!\u001a\u00020\"*\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\u0006\u0010'\u001a\u00020(H\u0016¢\u0006\u0004\b)\u0010*J\"\u0010+\u001a\u00020,*\u00020-2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020.0%2\u0006\u0010/\u001a\u00020,H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\n\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0019R\u0013\u0010\u000b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001c\u0010\u0019R\u0013\u0010\f\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001d\u0010\u0019R\u0013\u0010\r\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001e\u0010\u0019R\u0013\u0010\u000e\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001f\u0010\u0019R\u0013\u0010\u000f\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b \u0010\u0019¨\u00060"}, d2 = {"Landroidx/compose/material3/AnimatedMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "iconPosition", "Landroidx/compose/material3/NavigationItemIconPosition;", "iconPositionProgress", "Lkotlin/Function0;", "", "indicatorAnimationProgress", "topIconIndicatorHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "topIconIndicatorVerticalPadding", "topIconIndicatorToLabelVerticalPadding", "startIconIndicatorHorizontalPadding", "startIconIndicatorVerticalPadding", "startIconToLabelHorizontalPadding", "itemHorizontalPadding", "<init>", "(ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;FFFFFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIconPosition--xw1Ddg", "()I", "I", "getIconPositionProgress", "()Lkotlin/jvm/functions/Function0;", "getIndicatorAnimationProgress", "getTopIconIndicatorHorizontalPadding-D9Ej5fM", "()F", "F", "getTopIconIndicatorVerticalPadding-D9Ej5fM", "getTopIconIndicatorToLabelVerticalPadding-D9Ej5fM", "getStartIconIndicatorHorizontalPadding-D9Ej5fM", "getStartIconIndicatorVerticalPadding-D9Ej5fM", "getStartIconToLabelHorizontalPadding-D9Ej5fM", "getItemHorizontalPadding-D9Ej5fM", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "maxIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AnimatedMeasurePolicy implements MeasurePolicy {
    private final int iconPosition;
    private final Function0<Float> iconPositionProgress;
    private final Function0<Float> indicatorAnimationProgress;
    private final float itemHorizontalPadding;
    private final float startIconIndicatorHorizontalPadding;
    private final float startIconIndicatorVerticalPadding;
    private final float startIconToLabelHorizontalPadding;
    private final float topIconIndicatorHorizontalPadding;
    private final float topIconIndicatorToLabelVerticalPadding;
    private final float topIconIndicatorVerticalPadding;

    public /* synthetic */ AnimatedMeasurePolicy(int i, Function0 function0, Function0 function02, float f, float f2, float f3, float f4, float f5, float f6, float f7, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, function0, function02, f, f2, f3, f4, f5, f6, f7);
    }

    private AnimatedMeasurePolicy(int i, Function0<Float> function0, Function0<Float> function02, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        this.iconPosition = i;
        this.iconPositionProgress = function0;
        this.indicatorAnimationProgress = function02;
        this.topIconIndicatorHorizontalPadding = f;
        this.topIconIndicatorVerticalPadding = f2;
        this.topIconIndicatorToLabelVerticalPadding = f3;
        this.startIconIndicatorHorizontalPadding = f4;
        this.startIconIndicatorVerticalPadding = f5;
        this.startIconToLabelHorizontalPadding = f6;
        this.itemHorizontalPadding = f7;
    }

    /* renamed from: getIconPosition--xw1Ddg  reason: not valid java name */
    public final int m1709getIconPositionxw1Ddg() {
        return this.iconPosition;
    }

    public final Function0<Float> getIconPositionProgress() {
        return this.iconPositionProgress;
    }

    public final Function0<Float> getIndicatorAnimationProgress() {
        return this.indicatorAnimationProgress;
    }

    /* renamed from: getTopIconIndicatorHorizontalPadding-D9Ej5fM  reason: not valid java name */
    public final float m1714getTopIconIndicatorHorizontalPaddingD9Ej5fM() {
        return this.topIconIndicatorHorizontalPadding;
    }

    /* renamed from: getTopIconIndicatorVerticalPadding-D9Ej5fM  reason: not valid java name */
    public final float m1716getTopIconIndicatorVerticalPaddingD9Ej5fM() {
        return this.topIconIndicatorVerticalPadding;
    }

    /* renamed from: getTopIconIndicatorToLabelVerticalPadding-D9Ej5fM  reason: not valid java name */
    public final float m1715getTopIconIndicatorToLabelVerticalPaddingD9Ej5fM() {
        return this.topIconIndicatorToLabelVerticalPadding;
    }

    /* renamed from: getStartIconIndicatorHorizontalPadding-D9Ej5fM  reason: not valid java name */
    public final float m1711getStartIconIndicatorHorizontalPaddingD9Ej5fM() {
        return this.startIconIndicatorHorizontalPadding;
    }

    /* renamed from: getStartIconIndicatorVerticalPadding-D9Ej5fM  reason: not valid java name */
    public final float m1712getStartIconIndicatorVerticalPaddingD9Ej5fM() {
        return this.startIconIndicatorVerticalPadding;
    }

    /* renamed from: getStartIconToLabelHorizontalPadding-D9Ej5fM  reason: not valid java name */
    public final float m1713getStartIconToLabelHorizontalPaddingD9Ej5fM() {
        return this.startIconToLabelHorizontalPadding;
    }

    /* renamed from: getItemHorizontalPadding-D9Ej5fM  reason: not valid java name */
    public final float m1710getItemHorizontalPaddingD9Ej5fM() {
        return this.itemHorizontalPadding;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo41measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        MeasureResult m2320placeAnimatedLabelAndIcon2QYhCQ8;
        MeasureScope measureScope2 = measureScope;
        float floatValue = this.indicatorAnimationProgress.invoke().floatValue();
        float floatValue2 = this.iconPositionProgress.invoke().floatValue();
        long m7498copyZbe2FdA$default = Constraints.m7498copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
        List<? extends Measurable> list2 = list;
        int size = list2.size();
        int i = 0;
        while (i < size) {
            Measurable measurable = list.get(i);
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "icon")) {
                Placeable mo6216measureBRTryo0 = measurable.mo6216measureBRTryo0(m7498copyZbe2FdA$default);
                int size2 = list2.size();
                int i2 = 0;
                while (i2 < size2) {
                    Measurable measurable2 = list.get(i2);
                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), Constants.ScionAnalytics.PARAM_LABEL)) {
                        Placeable mo6216measureBRTryo02 = measurable2.mo6216measureBRTryo0(m7498copyZbe2FdA$default);
                        int width = mo6216measureBRTryo0.getWidth() + measureScope2.mo399roundToPx0680j_4(Dp.m7555constructorimpl(this.topIconIndicatorHorizontalPadding * 2.0f));
                        int height = mo6216measureBRTryo0.getHeight() + measureScope2.mo399roundToPx0680j_4(Dp.m7555constructorimpl(this.topIconIndicatorVerticalPadding * 2.0f));
                        int width2 = mo6216measureBRTryo0.getWidth() + mo6216measureBRTryo02.getWidth() + measureScope2.mo399roundToPx0680j_4(Dp.m7555constructorimpl(this.startIconToLabelHorizontalPadding + Dp.m7555constructorimpl(this.startIconIndicatorHorizontalPadding * 2.0f)));
                        int max = Math.max(mo6216measureBRTryo0.getHeight(), mo6216measureBRTryo02.getHeight()) + measureScope2.mo399roundToPx0680j_4(Dp.m7555constructorimpl(this.startIconIndicatorVerticalPadding * 2.0f));
                        int lerp = MathHelpersKt.lerp(width, width2, floatValue2);
                        int roundToInt = MathKt.roundToInt(lerp * floatValue);
                        int lerp2 = MathHelpersKt.lerp(height, max, floatValue2);
                        int size3 = list2.size();
                        int i3 = 0;
                        while (i3 < size3) {
                            Measurable measurable3 = list.get(i3);
                            List<? extends Measurable> list3 = list2;
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), "indicatorRipple")) {
                                Placeable mo6216measureBRTryo03 = measurable3.mo6216measureBRTryo0(ConstraintsKt.m7523constrainN9IONVI(m7498copyZbe2FdA$default, Constraints.Companion.m7518fixedJhjzzOo(lerp, lerp2)));
                                int size4 = list3.size();
                                int i4 = 0;
                                while (i4 < size4) {
                                    Measurable measurable4 = list.get(i4);
                                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable4), "indicator")) {
                                        Placeable mo6216measureBRTryo04 = measurable4.mo6216measureBRTryo0(ConstraintsKt.m7523constrainN9IONVI(m7498copyZbe2FdA$default, Constraints.Companion.m7518fixedJhjzzOo(roundToInt, lerp2)));
                                        Placeable placeable = mo6216measureBRTryo0;
                                        Placeable placeable2 = mo6216measureBRTryo03;
                                        m2320placeAnimatedLabelAndIcon2QYhCQ8 = NavigationItemKt.m2320placeAnimatedLabelAndIcon2QYhCQ8(measureScope, this.iconPosition, this.iconPositionProgress, mo6216measureBRTryo02, placeable, placeable2, mo6216measureBRTryo04, width, m7498copyZbe2FdA$default, this.topIconIndicatorToLabelVerticalPadding, this.topIconIndicatorVerticalPadding, this.topIconIndicatorHorizontalPadding, this.startIconIndicatorHorizontalPadding, this.startIconIndicatorVerticalPadding, this.startIconToLabelHorizontalPadding, this.itemHorizontalPadding);
                                        return m2320placeAnimatedLabelAndIcon2QYhCQ8;
                                    }
                                    int i5 = width;
                                    Placeable placeable3 = mo6216measureBRTryo03;
                                    i4++;
                                    mo6216measureBRTryo0 = mo6216measureBRTryo0;
                                    mo6216measureBRTryo03 = placeable3;
                                    width = i5;
                                    mo6216measureBRTryo02 = mo6216measureBRTryo02;
                                }
                                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                                throw new KotlinNothingValueException();
                            }
                            i3++;
                            list2 = list3;
                            mo6216measureBRTryo02 = mo6216measureBRTryo02;
                            mo6216measureBRTryo0 = mo6216measureBRTryo0;
                        }
                        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                        throw new KotlinNothingValueException();
                    }
                    i2++;
                    measureScope2 = measureScope;
                }
                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                throw new KotlinNothingValueException();
            }
            i++;
            measureScope2 = measureScope;
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        List<? extends IntrinsicMeasurable> list2 = list;
        int size = list2.size();
        for (int i2 = 0; i2 < size; i2++) {
            IntrinsicMeasurable intrinsicMeasurable = list.get(i2);
            if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable), "icon")) {
                int maxIntrinsicWidth = intrinsicMeasurable.maxIntrinsicWidth(i);
                int size2 = list2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    IntrinsicMeasurable intrinsicMeasurable2 = list.get(i3);
                    if (Intrinsics.areEqual(LayoutUtilKt.getLayoutId(intrinsicMeasurable2), Constants.ScionAnalytics.PARAM_LABEL)) {
                        int maxIntrinsicWidth2 = intrinsicMeasurable2.maxIntrinsicWidth(i);
                        if (NavigationItemIconPosition.m2305equalsimpl0(this.iconPosition, NavigationItemIconPosition.Companion.m2310getTopxw1Ddg())) {
                            return Math.max(maxIntrinsicWidth2, maxIntrinsicWidth + intrinsicMeasureScope.mo399roundToPx0680j_4(Dp.m7555constructorimpl(Dp.m7555constructorimpl(this.topIconIndicatorHorizontalPadding * 2.0f) + Dp.m7555constructorimpl(this.itemHorizontalPadding * 2.0f))));
                        }
                        return maxIntrinsicWidth + maxIntrinsicWidth2 + intrinsicMeasureScope.mo399roundToPx0680j_4(Dp.m7555constructorimpl(Dp.m7555constructorimpl(Dp.m7555constructorimpl(this.startIconIndicatorHorizontalPadding * 2.0f) + this.startIconToLabelHorizontalPadding) + this.itemHorizontalPadding));
                    }
                }
                ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
                throw new KotlinNothingValueException();
            }
        }
        ListUtilsKt.throwNoSuchElementException("Collection contains no element matching the predicate.");
        throw new KotlinNothingValueException();
    }
}
