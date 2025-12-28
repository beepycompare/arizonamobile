package com.skydoves.cloudy.internals;

import androidx.compose.animation.core.Easing;
import com.skydoves.cloudy.internals.SkySnapshot;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SkySnapshot.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/skydoves/cloudy/internals/ProgressiveParams;", "", "direction", "Lcom/skydoves/cloudy/internals/SkySnapshot$ProgressiveDirection;", "fadeStart", "", "fadeEnd", "easing", "Landroidx/compose/animation/core/Easing;", "<init>", "(Lcom/skydoves/cloudy/internals/SkySnapshot$ProgressiveDirection;FFLandroidx/compose/animation/core/Easing;)V", "getDirection", "()Lcom/skydoves/cloudy/internals/SkySnapshot$ProgressiveDirection;", "getFadeStart", "()F", "getFadeEnd", "getEasing", "()Landroidx/compose/animation/core/Easing;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "cloudy_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ProgressiveParams {
    private final SkySnapshot.ProgressiveDirection direction;
    private final Easing easing;
    private final float fadeEnd;
    private final float fadeStart;

    public static /* synthetic */ ProgressiveParams copy$default(ProgressiveParams progressiveParams, SkySnapshot.ProgressiveDirection progressiveDirection, float f, float f2, Easing easing, int i, Object obj) {
        if ((i & 1) != 0) {
            progressiveDirection = progressiveParams.direction;
        }
        if ((i & 2) != 0) {
            f = progressiveParams.fadeStart;
        }
        if ((i & 4) != 0) {
            f2 = progressiveParams.fadeEnd;
        }
        if ((i & 8) != 0) {
            easing = progressiveParams.easing;
        }
        return progressiveParams.copy(progressiveDirection, f, f2, easing);
    }

    public final SkySnapshot.ProgressiveDirection component1() {
        return this.direction;
    }

    public final float component2() {
        return this.fadeStart;
    }

    public final float component3() {
        return this.fadeEnd;
    }

    public final Easing component4() {
        return this.easing;
    }

    public final ProgressiveParams copy(SkySnapshot.ProgressiveDirection direction, float f, float f2, Easing easing) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(easing, "easing");
        return new ProgressiveParams(direction, f, f2, easing);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ProgressiveParams) {
            ProgressiveParams progressiveParams = (ProgressiveParams) obj;
            return this.direction == progressiveParams.direction && Float.compare(this.fadeStart, progressiveParams.fadeStart) == 0 && Float.compare(this.fadeEnd, progressiveParams.fadeEnd) == 0 && Intrinsics.areEqual(this.easing, progressiveParams.easing);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.direction.hashCode() * 31) + Float.hashCode(this.fadeStart)) * 31) + Float.hashCode(this.fadeEnd)) * 31) + this.easing.hashCode();
    }

    public String toString() {
        return "ProgressiveParams(direction=" + this.direction + ", fadeStart=" + this.fadeStart + ", fadeEnd=" + this.fadeEnd + ", easing=" + this.easing + ')';
    }

    public ProgressiveParams(SkySnapshot.ProgressiveDirection direction, float f, float f2, Easing easing) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(easing, "easing");
        this.direction = direction;
        this.fadeStart = f;
        this.fadeEnd = f2;
        this.easing = easing;
    }

    public final SkySnapshot.ProgressiveDirection getDirection() {
        return this.direction;
    }

    public final float getFadeStart() {
        return this.fadeStart;
    }

    public final float getFadeEnd() {
        return this.fadeEnd;
    }

    public final Easing getEasing() {
        return this.easing;
    }
}
