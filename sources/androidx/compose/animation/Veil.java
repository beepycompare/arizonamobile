package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: EnterExitTransition.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0013\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0014\u0010\fJ\u0010\u0010\u0015\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0016\u0010\fJ\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J>\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\""}, d2 = {"Landroidx/compose/animation/Veil;", "", "initialColor", "Landroidx/compose/ui/graphics/Color;", "targetColor", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "matchParentSize", "", "<init>", "(JJLandroidx/compose/animation/core/FiniteAnimationSpec;ZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getInitialColor-0d7_KjU", "()J", "J", "getTargetColor-0d7_KjU", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "getMatchParentSize", "()Z", "component1", "component1-0d7_KjU", "component2", "component2-0d7_KjU", "component3", "component4", "copy", "copy-RFnl5yQ", "(JJLandroidx/compose/animation/core/FiniteAnimationSpec;Z)Landroidx/compose/animation/Veil;", "equals", "other", "hashCode", "", "toString", "", "animation"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Veil {
    public static final int $stable = 0;
    private final FiniteAnimationSpec<Color> animationSpec;
    private final long initialColor;
    private final boolean matchParentSize;
    private final long targetColor;

    public /* synthetic */ Veil(long j, long j2, FiniteAnimationSpec finiteAnimationSpec, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, finiteAnimationSpec, z);
    }

    /* renamed from: copy-RFnl5yQ$default  reason: not valid java name */
    public static /* synthetic */ Veil m154copyRFnl5yQ$default(Veil veil, long j, long j2, FiniteAnimationSpec finiteAnimationSpec, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            j = veil.initialColor;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            j2 = veil.targetColor;
        }
        long j4 = j2;
        FiniteAnimationSpec<Color> finiteAnimationSpec2 = finiteAnimationSpec;
        if ((i & 4) != 0) {
            finiteAnimationSpec2 = veil.animationSpec;
        }
        FiniteAnimationSpec finiteAnimationSpec3 = finiteAnimationSpec2;
        if ((i & 8) != 0) {
            z = veil.matchParentSize;
        }
        return veil.m157copyRFnl5yQ(j3, j4, finiteAnimationSpec3, z);
    }

    /* renamed from: component1-0d7_KjU  reason: not valid java name */
    public final long m155component10d7_KjU() {
        return this.initialColor;
    }

    /* renamed from: component2-0d7_KjU  reason: not valid java name */
    public final long m156component20d7_KjU() {
        return this.targetColor;
    }

    public final FiniteAnimationSpec<Color> component3() {
        return this.animationSpec;
    }

    public final boolean component4() {
        return this.matchParentSize;
    }

    /* renamed from: copy-RFnl5yQ  reason: not valid java name */
    public final Veil m157copyRFnl5yQ(long j, long j2, FiniteAnimationSpec<Color> finiteAnimationSpec, boolean z) {
        return new Veil(j, j2, finiteAnimationSpec, z, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Veil) {
            Veil veil = (Veil) obj;
            return Color.m4773equalsimpl0(this.initialColor, veil.initialColor) && Color.m4773equalsimpl0(this.targetColor, veil.targetColor) && Intrinsics.areEqual(this.animationSpec, veil.animationSpec) && this.matchParentSize == veil.matchParentSize;
        }
        return false;
    }

    public int hashCode() {
        return (((((Color.m4779hashCodeimpl(this.initialColor) * 31) + Color.m4779hashCodeimpl(this.targetColor)) * 31) + this.animationSpec.hashCode()) * 31) + Boolean.hashCode(this.matchParentSize);
    }

    public String toString() {
        return "Veil(initialColor=" + ((Object) Color.m4780toStringimpl(this.initialColor)) + ", targetColor=" + ((Object) Color.m4780toStringimpl(this.targetColor)) + ", animationSpec=" + this.animationSpec + ", matchParentSize=" + this.matchParentSize + ')';
    }

    private Veil(long j, long j2, FiniteAnimationSpec<Color> finiteAnimationSpec, boolean z) {
        this.initialColor = j;
        this.targetColor = j2;
        this.animationSpec = finiteAnimationSpec;
        this.matchParentSize = z;
    }

    /* renamed from: getInitialColor-0d7_KjU  reason: not valid java name */
    public final long m158getInitialColor0d7_KjU() {
        return this.initialColor;
    }

    /* renamed from: getTargetColor-0d7_KjU  reason: not valid java name */
    public final long m159getTargetColor0d7_KjU() {
        return this.targetColor;
    }

    public final FiniteAnimationSpec<Color> getAnimationSpec() {
        return this.animationSpec;
    }

    public final boolean getMatchParentSize() {
        return this.matchParentSize;
    }
}
