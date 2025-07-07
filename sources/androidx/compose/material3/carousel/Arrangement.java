package androidx.compose.material3.carousel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
/* compiled from: Arrangement.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0006\u0010\u0018\u001a\u00020\u0003R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u001a"}, d2 = {"Landroidx/compose/material3/carousel/Arrangement;", "", "priority", "", "smallSize", "", "smallCount", "mediumSize", "mediumCount", "largeSize", "largeCount", "(IFIFIFI)V", "getLargeCount", "()I", "getLargeSize", "()F", "getMediumCount", "getMediumSize", "getSmallCount", "getSmallSize", "cost", "targetLargeSize", "isValid", "", "itemCount", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Arrangement {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private static final float MediumItemFlexPercentage = 0.1f;
    private final int largeCount;
    private final float largeSize;
    private final int mediumCount;
    private final float mediumSize;
    private final int priority;
    private final int smallCount;
    private final float smallSize;

    public Arrangement(int i, float f, int i2, float f2, int i3, float f3, int i4) {
        this.priority = i;
        this.smallSize = f;
        this.smallCount = i2;
        this.mediumSize = f2;
        this.mediumCount = i3;
        this.largeSize = f3;
        this.largeCount = i4;
    }

    public final float getSmallSize() {
        return this.smallSize;
    }

    public final int getSmallCount() {
        return this.smallCount;
    }

    public final float getMediumSize() {
        return this.mediumSize;
    }

    public final int getMediumCount() {
        return this.mediumCount;
    }

    public final float getLargeSize() {
        return this.largeSize;
    }

    public final int getLargeCount() {
        return this.largeCount;
    }

    private final boolean isValid() {
        int i = this.largeCount;
        if (i <= 0 || this.smallCount <= 0 || this.mediumCount <= 0) {
            return i <= 0 || this.smallCount <= 0 || this.largeSize > this.smallSize;
        }
        float f = this.largeSize;
        float f2 = this.mediumSize;
        return f > f2 && f2 > this.smallSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float cost(float f) {
        if (isValid()) {
            return Math.abs(f - this.largeSize) * this.priority;
        }
        return Float.MAX_VALUE;
    }

    public final int itemCount() {
        return this.largeCount + this.mediumCount + this.smallCount;
    }

    /* compiled from: Arrangement.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0002JX\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0013J`\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/compose/material3/carousel/Arrangement$Companion;", "", "()V", "MediumItemFlexPercentage", "", "calculateLargeSize", "availableSpace", "smallCount", "", "smallSize", "mediumCount", "largeCount", "findLowestCostArrangement", "Landroidx/compose/material3/carousel/Arrangement;", "itemSpacing", "targetSmallSize", "minSmallSize", "maxSmallSize", "smallCounts", "", "targetMediumSize", "mediumCounts", "targetLargeSize", "largeCounts", "fit", "priority", "mediumSize", "largeSize", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final float calculateLargeSize(float f, int i, float f2, int i2, int i3) {
            float f3 = i2 / 2.0f;
            return (f - ((i + f3) * f2)) / (i3 + f3);
        }

        private Companion() {
        }

        public final Arrangement findLowestCostArrangement(float f, float f2, float f3, float f4, float f5, int[] iArr, float f6, int[] iArr2, float f7, int[] iArr3) {
            int[] iArr4 = iArr;
            int length = iArr3.length;
            Arrangement arrangement = null;
            int i = 1;
            int i2 = 0;
            while (i2 < length) {
                int i3 = iArr3[i2];
                int length2 = iArr2.length;
                int i4 = 0;
                while (i4 < length2) {
                    int i5 = iArr2[i4];
                    int length3 = iArr4.length;
                    int i6 = 0;
                    while (i6 < length3) {
                        int i7 = i4;
                        int i8 = iArr4[i6];
                        Arrangement arrangement2 = arrangement;
                        int i9 = i2;
                        int i10 = length2;
                        int i11 = length3;
                        int i12 = i6;
                        Arrangement fit = fit(i, f, f2, i8, f3, f4, f5, i5, f6, i3, f7);
                        if (arrangement2 != null && fit.cost(f7) >= arrangement2.cost(f7)) {
                            arrangement = arrangement2;
                        } else if (fit.cost(f7) == 0.0f) {
                            return fit;
                        } else {
                            arrangement = fit;
                        }
                        i++;
                        i6 = i12 + 1;
                        iArr4 = iArr;
                        i2 = i9;
                        length2 = i10;
                        i4 = i7;
                        length3 = i11;
                    }
                    i4++;
                    iArr4 = iArr;
                }
                i2++;
                iArr4 = iArr;
            }
            return arrangement;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x006a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final Arrangement fit(int i, float f, float f2, int i2, float f3, float f4, float f5, int i3, float f6, int i4, float f7) {
            float max;
            float f8;
            Companion companion;
            int i5;
            int i6;
            float calculateLargeSize;
            float f9;
            float f10;
            float f11 = f - ((((i4 + i3) + i2) - 1) * f2);
            float coerceIn = RangesKt.coerceIn(f3, f4, f5);
            float f12 = i4;
            float f13 = i3;
            float f14 = (f7 * f12) + (f6 * f13);
            float f15 = i2;
            float f16 = f11 - (f14 + (coerceIn * f15));
            if (i2 > 0 && f16 > 0.0f) {
                max = Math.min(f16 / f15, f5 - coerceIn);
            } else {
                if (i2 > 0 && f16 < 0.0f) {
                    max = Math.max(f16 / f15, f4 - coerceIn);
                }
                if (i2 <= 0) {
                    f8 = coerceIn;
                    i5 = i3;
                    i6 = i4;
                    companion = this;
                } else {
                    f8 = 0.0f;
                    companion = this;
                    i5 = i3;
                    i6 = i4;
                }
                calculateLargeSize = companion.calculateLargeSize(f11, i2, f8, i5, i6);
                float f17 = f8;
                f9 = (calculateLargeSize + f17) / 2.0f;
                if (i5 > 0 && calculateLargeSize != f7) {
                    f10 = (f7 - calculateLargeSize) * f12;
                    float min = Math.min(Math.abs(f10), 0.1f * f9 * f13);
                    if (f10 <= 0.0f) {
                        f9 -= min / f13;
                        calculateLargeSize += min / f12;
                    } else {
                        f9 += min / f13;
                        calculateLargeSize -= min / f12;
                    }
                }
                return new Arrangement(i, f17, i2, f9, i5, calculateLargeSize, i6);
            }
            coerceIn += max;
            if (i2 <= 0) {
            }
            calculateLargeSize = companion.calculateLargeSize(f11, i2, f8, i5, i6);
            float f172 = f8;
            f9 = (calculateLargeSize + f172) / 2.0f;
            if (i5 > 0) {
                f10 = (f7 - calculateLargeSize) * f12;
                float min2 = Math.min(Math.abs(f10), 0.1f * f9 * f13);
                if (f10 <= 0.0f) {
                }
            }
            return new Arrangement(i, f172, i2, f9, i5, calculateLargeSize, i6);
        }
    }
}
