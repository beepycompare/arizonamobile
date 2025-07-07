package androidx.constraintlayout.compose.carousel;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: CarouselSwipeable.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0081\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0006\u001a\u00020\u0003HÂ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u001c\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Landroidx/constraintlayout/compose/carousel/FixedThreshold;", "Landroidx/constraintlayout/compose/carousel/ThresholdConfig;", TypedValues.CycleType.S_WAVE_OFFSET, "Landroidx/compose/ui/unit/Dp;", "(FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "component1", "component1-D9Ej5fM", "()F", "copy", "copy-0680j_4", "(F)Landroidx/constraintlayout/compose/carousel/FixedThreshold;", "equals", "", "other", "", "hashCode", "", "toString", "", "computeThreshold", "", "Landroidx/compose/ui/unit/Density;", "fromValue", "toValue", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FixedThreshold implements ThresholdConfig {
    public static final int $stable = 0;
    private final float offset;

    public /* synthetic */ FixedThreshold(float f, DefaultConstructorMarker defaultConstructorMarker) {
        this(f);
    }

    /* renamed from: component1-D9Ej5fM  reason: not valid java name */
    private final float m7161component1D9Ej5fM() {
        return this.offset;
    }

    /* renamed from: copy-0680j_4$default  reason: not valid java name */
    public static /* synthetic */ FixedThreshold m7162copy0680j_4$default(FixedThreshold fixedThreshold, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = fixedThreshold.offset;
        }
        return fixedThreshold.m7163copy0680j_4(f);
    }

    /* renamed from: copy-0680j_4  reason: not valid java name */
    public final FixedThreshold m7163copy0680j_4(float f) {
        return new FixedThreshold(f, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FixedThreshold) && Dp.m6689equalsimpl0(this.offset, ((FixedThreshold) obj).offset);
    }

    public int hashCode() {
        return Dp.m6690hashCodeimpl(this.offset);
    }

    public String toString() {
        return "FixedThreshold(offset=" + ((Object) Dp.m6695toStringimpl(this.offset)) + ')';
    }

    private FixedThreshold(float f) {
        this.offset = f;
    }

    @Override // androidx.constraintlayout.compose.carousel.ThresholdConfig
    public float computeThreshold(Density density, float f, float f2) {
        return f + (density.mo389toPx0680j_4(this.offset) * Math.signum(f2 - f));
    }
}
