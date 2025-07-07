package androidx.compose.material3.carousel;

import kotlin.Metadata;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Strategy.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Landroidx/compose/material3/carousel/ShiftPointRange;", "", "fromStepIndex", "", "toStepIndex", "steppedInterpolation", "", "(IIF)V", "getFromStepIndex", "()I", "getSteppedInterpolation", "()F", "getToStepIndex", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ShiftPointRange {
    private final int fromStepIndex;
    private final float steppedInterpolation;
    private final int toStepIndex;

    public static /* synthetic */ ShiftPointRange copy$default(ShiftPointRange shiftPointRange, int i, int i2, float f, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = shiftPointRange.fromStepIndex;
        }
        if ((i3 & 2) != 0) {
            i2 = shiftPointRange.toStepIndex;
        }
        if ((i3 & 4) != 0) {
            f = shiftPointRange.steppedInterpolation;
        }
        return shiftPointRange.copy(i, i2, f);
    }

    public final int component1() {
        return this.fromStepIndex;
    }

    public final int component2() {
        return this.toStepIndex;
    }

    public final float component3() {
        return this.steppedInterpolation;
    }

    public final ShiftPointRange copy(int i, int i2, float f) {
        return new ShiftPointRange(i, i2, f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ShiftPointRange) {
            ShiftPointRange shiftPointRange = (ShiftPointRange) obj;
            return this.fromStepIndex == shiftPointRange.fromStepIndex && this.toStepIndex == shiftPointRange.toStepIndex && Float.compare(this.steppedInterpolation, shiftPointRange.steppedInterpolation) == 0;
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.fromStepIndex) * 31) + Integer.hashCode(this.toStepIndex)) * 31) + Float.hashCode(this.steppedInterpolation);
    }

    public String toString() {
        return "ShiftPointRange(fromStepIndex=" + this.fromStepIndex + ", toStepIndex=" + this.toStepIndex + ", steppedInterpolation=" + this.steppedInterpolation + ')';
    }

    public ShiftPointRange(int i, int i2, float f) {
        this.fromStepIndex = i;
        this.toStepIndex = i2;
        this.steppedInterpolation = f;
    }

    public final int getFromStepIndex() {
        return this.fromStepIndex;
    }

    public final int getToStepIndex() {
        return this.toStepIndex;
    }

    public final float getSteppedInterpolation() {
        return this.steppedInterpolation;
    }
}
