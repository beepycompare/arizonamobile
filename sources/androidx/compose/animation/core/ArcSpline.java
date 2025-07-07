package androidx.compose.animation.core;

import com.arizona.launcher.UpdateActivity;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
/* compiled from: ArcSpline.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0014B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005J\u0016\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005R\u001c\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/compose/animation/core/ArcSpline;", "", "arcModes", "", "timePoints", "", "y", "", "([I[F[[F)V", "arcs", "Landroidx/compose/animation/core/ArcSpline$Arc;", "[[Landroidx/compose/animation/core/ArcSpline$Arc;", "isExtrapolate", "", "getPos", "", "time", "", "v", "getSlope", "Arc", "animation-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ArcSpline {
    public static final int $stable = 8;
    private final Arc[][] arcs;
    private final boolean isExtrapolate = true;

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0028, code lost:
        if (r7 == r2) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0044 A[LOOP:1: B:20:0x0042->B:21:0x0044, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArcSpline(int[] iArr, float[] fArr, float[][] fArr2) {
        int i;
        int length;
        int i2;
        int i3 = 1;
        int length2 = fArr.length - 1;
        Arc[][] arcArr = new Arc[length2];
        int i4 = 1;
        int i5 = 1;
        int i6 = 0;
        while (i6 < length2) {
            int i7 = iArr[i6];
            int i8 = 3;
            if (i7 != 0) {
                if (i7 != i3) {
                    if (i7 != 2) {
                        if (i7 != 3) {
                            i8 = 4;
                            if (i7 != 4) {
                                i8 = 5;
                                if (i7 != 5) {
                                    i = i5;
                                    float[] fArr3 = fArr2[i6];
                                    int i9 = i6 + 1;
                                    float[] fArr4 = fArr2[i9];
                                    float f = fArr[i6];
                                    float f2 = fArr[i9];
                                    length = (fArr3.length % 2) + (fArr3.length / 2);
                                    Arc[] arcArr2 = new Arc[length];
                                    i2 = 0;
                                    while (i2 < length) {
                                        int i10 = i2 * 2;
                                        int i11 = i2;
                                        int i12 = i10 + 1;
                                        arcArr2[i11] = new Arc(i, f, f2, fArr3[i10], fArr3[i12], fArr4[i10], fArr4[i12]);
                                        i2 = i11 + 1;
                                    }
                                    arcArr[i6] = arcArr2;
                                    i6 = i9;
                                    i5 = i;
                                    i3 = 1;
                                }
                            }
                        }
                    }
                    i4 = 2;
                    i = i4;
                    float[] fArr32 = fArr2[i6];
                    int i92 = i6 + 1;
                    float[] fArr42 = fArr2[i92];
                    float f3 = fArr[i6];
                    float f22 = fArr[i92];
                    length = (fArr32.length % 2) + (fArr32.length / 2);
                    Arc[] arcArr22 = new Arc[length];
                    i2 = 0;
                    while (i2 < length) {
                    }
                    arcArr[i6] = arcArr22;
                    i6 = i92;
                    i5 = i;
                    i3 = 1;
                }
                i4 = i3;
                i = i4;
                float[] fArr322 = fArr2[i6];
                int i922 = i6 + 1;
                float[] fArr422 = fArr2[i922];
                float f32 = fArr[i6];
                float f222 = fArr[i922];
                length = (fArr322.length % 2) + (fArr322.length / 2);
                Arc[] arcArr222 = new Arc[length];
                i2 = 0;
                while (i2 < length) {
                }
                arcArr[i6] = arcArr222;
                i6 = i922;
                i5 = i;
                i3 = 1;
            }
            i = i8;
            float[] fArr3222 = fArr2[i6];
            int i9222 = i6 + 1;
            float[] fArr4222 = fArr2[i9222];
            float f322 = fArr[i6];
            float f2222 = fArr[i9222];
            length = (fArr3222.length % 2) + (fArr3222.length / 2);
            Arc[] arcArr2222 = new Arc[length];
            i2 = 0;
            while (i2 < length) {
            }
            arcArr[i6] = arcArr2222;
            i6 = i9222;
            i5 = i;
            i3 = 1;
        }
        this.arcs = arcArr;
    }

    public final void getPos(float f, float[] fArr) {
        Arc[][] arcArr = this.arcs;
        Arc[][] arcArr2 = arcArr;
        int length = arcArr2.length - 1;
        int i = 0;
        float time1 = arcArr[0][0].getTime1();
        float time2 = arcArr[length][0].getTime2();
        int length2 = fArr.length;
        if (!this.isExtrapolate) {
            f = Math.min(Math.max(f, time1), time2);
        } else if (f < time1 || f > time2) {
            if (f > time2) {
                time1 = time2;
            } else {
                length = 0;
            }
            float f2 = f - time1;
            int i2 = 0;
            while (i < length2 - 1) {
                Arc arc = arcArr[length][i2];
                if (arc.isLinear) {
                    fArr[i] = arc.getLinearX(time1) + (arc.ellipseCenterX * f2);
                    fArr[i + 1] = arc.getLinearY(time1) + (arc.ellipseCenterY * f2);
                } else {
                    arc.setPoint(time1);
                    fArr[i] = arc.ellipseCenterX + (arc.ellipseA * arc.tmpSinAngle) + (arc.calcDX() * f2);
                    fArr[i + 1] = arc.ellipseCenterY + (arc.ellipseB * arc.tmpCosAngle) + (arc.calcDY() * f2);
                }
                i += 2;
                i2++;
            }
            return;
        }
        int length3 = arcArr2.length;
        boolean z = false;
        for (int i3 = 0; i3 < length3; i3++) {
            int i4 = 0;
            int i5 = 0;
            while (i4 < length2 - 1) {
                Arc arc2 = arcArr[i3][i5];
                if (f <= arc2.getTime2()) {
                    if (arc2.isLinear) {
                        fArr[i4] = arc2.getLinearX(f);
                        fArr[i4 + 1] = arc2.getLinearY(f);
                    } else {
                        arc2.setPoint(f);
                        fArr[i4] = arc2.ellipseCenterX + (arc2.ellipseA * arc2.tmpSinAngle);
                        fArr[i4 + 1] = arc2.ellipseCenterY + (arc2.ellipseB * arc2.tmpCosAngle);
                    }
                    z = true;
                }
                i4 += 2;
                i5++;
            }
            if (z) {
                return;
            }
        }
    }

    public final void getSlope(float f, float[] fArr) {
        Arc[][] arcArr = this.arcs;
        float time1 = arcArr[0][0].getTime1();
        Arc[][] arcArr2 = arcArr;
        float time2 = arcArr[arcArr2.length - 1][0].getTime2();
        if (f < time1) {
            f = time1;
        }
        if (f <= time2) {
            time2 = f;
        }
        int length = fArr.length;
        int length2 = arcArr2.length;
        boolean z = false;
        for (int i = 0; i < length2; i++) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < length - 1) {
                Arc arc = arcArr[i][i3];
                if (time2 <= arc.getTime2()) {
                    if (!arc.isLinear) {
                        arc.setPoint(time2);
                        fArr[i2] = arc.calcDX();
                        fArr[i2 + 1] = arc.calcDY();
                    } else {
                        fArr[i2] = arc.ellipseCenterX;
                        fArr[i2 + 1] = arc.ellipseCenterY;
                    }
                    z = true;
                }
                i2 += 2;
                i3++;
            }
            if (z) {
                return;
            }
        }
    }

    /* compiled from: ArcSpline.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B?\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ-\u0010!\u001a\u00020\"2\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0000¢\u0006\u0002\b#J\u0011\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0005H\u0082\bJ\u0006\u0010&\u001a\u00020\u0005J\u0006\u0010'\u001a\u00020\u0005J\t\u0010(\u001a\u00020\u0005H\u0086\bJ\t\u0010)\u001a\u00020\u0005H\u0086\bJ\u000e\u0010*\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0005J\u000e\u0010+\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0005J\u0010\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005H\u0002J\u000e\u0010.\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u0005R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u00058\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00138\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0014\u001a\u00020\u00058À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0017\u001a\u00020\u00058À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Landroidx/compose/animation/core/ArcSpline$Arc;", "", UpdateActivity.UPDATE_MODE, "", "time1", "", "time2", "x1", "y1", "x2", "y2", "(IFFFFFF)V", "arcDistance", "arcVelocity", "ellipseA", "ellipseB", "ellipseCenterX", "ellipseCenterY", "isLinear", "", "linearDX", "getLinearDX$animation_core_release", "()F", "linearDY", "getLinearDY$animation_core_release", "lut", "", "oneOverDeltaTime", "getTime1", "getTime2", "tmpCosAngle", "tmpSinAngle", "vertical", "buildTable", "", "buildTable$animation_core_release", "calcAngle", "time", "calcDX", "calcDY", "calcX", "calcY", "getLinearX", "getLinearY", "lookup", "v", "setPoint", "animation-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Arc {
        public static final int $stable = 8;
        private float arcDistance;
        private final float arcVelocity;
        public final float ellipseA;
        public final float ellipseB;
        public final float ellipseCenterX;
        public final float ellipseCenterY;
        public final boolean isLinear;
        private final float[] lut;
        private final float oneOverDeltaTime;
        private final float time1;
        private final float time2;
        private float tmpCosAngle;
        private float tmpSinAngle;
        private final float vertical;
        private final float x1;
        private final float x2;
        private final float y1;
        private final float y2;

        public Arc(int i, float f, float f2, float f3, float f4, float f5, float f6) {
            this.time1 = f;
            this.time2 = f2;
            this.x1 = f3;
            this.y1 = f4;
            this.x2 = f5;
            this.y2 = f6;
            float f7 = f5 - f3;
            float f8 = f6 - f4;
            boolean z = true;
            boolean z2 = i == 1 || (i == 4 ? f8 > 0.0f : !(i != 5 || f8 >= 0.0f));
            float f9 = z2 ? -1.0f : 1.0f;
            this.vertical = f9;
            float f10 = 1 / (f2 - f);
            this.oneOverDeltaTime = f10;
            this.lut = new float[101];
            boolean z3 = i == 3;
            if (z3 || Math.abs(f7) < 0.001f || Math.abs(f8) < 0.001f) {
                float hypot = (float) Math.hypot(f8, f7);
                this.arcDistance = hypot;
                this.arcVelocity = hypot * f10;
                this.ellipseCenterX = f7 * f10;
                this.ellipseCenterY = f8 * f10;
                this.ellipseA = Float.NaN;
                this.ellipseB = Float.NaN;
            } else {
                this.ellipseA = f7 * f9;
                this.ellipseB = f8 * (-f9);
                this.ellipseCenterX = z2 ? f5 : f3;
                this.ellipseCenterY = z2 ? f4 : f6;
                buildTable$animation_core_release(f3, f4, f5, f6);
                this.arcVelocity = this.arcDistance * f10;
                z = z3;
            }
            this.isLinear = z;
        }

        public final float getTime1() {
            return this.time1;
        }

        public final float getTime2() {
            return this.time2;
        }

        public final float getLinearDX$animation_core_release() {
            return this.ellipseCenterX;
        }

        public final float getLinearDY$animation_core_release() {
            return this.ellipseCenterY;
        }

        private final float calcAngle(float f) {
            return lookup((this.vertical == -1.0f ? this.time2 - f : f - this.time1) * this.oneOverDeltaTime) * 1.5707964f;
        }

        public final float calcX() {
            return this.ellipseCenterX + (this.ellipseA * this.tmpSinAngle);
        }

        public final float calcY() {
            return this.ellipseCenterY + (this.ellipseB * this.tmpCosAngle);
        }

        public final float calcDX() {
            float f = this.ellipseA * this.tmpCosAngle;
            return f * this.vertical * (this.arcVelocity / ((float) Math.hypot(f, (-this.ellipseB) * this.tmpSinAngle)));
        }

        public final float calcDY() {
            float f = this.ellipseA * this.tmpCosAngle;
            float f2 = (-this.ellipseB) * this.tmpSinAngle;
            return f2 * this.vertical * (this.arcVelocity / ((float) Math.hypot(f, f2)));
        }

        public final float getLinearX(float f) {
            float f2 = (f - this.time1) * this.oneOverDeltaTime;
            float f3 = this.x1;
            return f3 + (f2 * (this.x2 - f3));
        }

        public final float getLinearY(float f) {
            float f2 = (f - this.time1) * this.oneOverDeltaTime;
            float f3 = this.y1;
            return f3 + (f2 * (this.y2 - f3));
        }

        private final float lookup(float f) {
            if (f <= 0.0f) {
                return 0.0f;
            }
            if (f >= 1.0f) {
                return 1.0f;
            }
            float f2 = f * 100;
            int i = (int) f2;
            float f3 = f2 - i;
            float[] fArr = this.lut;
            float f4 = fArr[i];
            return f4 + (f3 * (fArr[i + 1] - f4));
        }

        public final void buildTable$animation_core_release(float f, float f2, float f3, float f4) {
            float[] fArr;
            float f5;
            float f6;
            float f7;
            float f8 = f3 - f;
            float f9 = f2 - f4;
            fArr = ArcSplineKt.OurPercentCache;
            int length = fArr.length - 1;
            float f10 = length;
            float[] fArr2 = this.lut;
            if (1 <= length) {
                float f11 = f9;
                int i = 1;
                f7 = 0.0f;
                float f12 = 0.0f;
                while (true) {
                    f6 = 0.0f;
                    double radians = (float) Math.toRadians((i * 90.0d) / length);
                    float sin = ((float) Math.sin(radians)) * f8;
                    float cos = ((float) Math.cos(radians)) * f9;
                    f5 = f10;
                    f7 += (float) Math.hypot(sin - f12, cos - f11);
                    fArr[i] = f7;
                    if (i == length) {
                        break;
                    }
                    i++;
                    f11 = cos;
                    f10 = f5;
                    f12 = sin;
                }
            } else {
                f5 = f10;
                f6 = 0.0f;
                f7 = 0.0f;
            }
            this.arcDistance = f7;
            if (1 <= length) {
                int i2 = 1;
                while (true) {
                    fArr[i2] = fArr[i2] / f7;
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                }
            }
            int length2 = fArr2.length;
            for (int i3 = 0; i3 < length2; i3++) {
                float f13 = i3 / 100.0f;
                int binarySearch$default = ArraysKt.binarySearch$default(fArr, f13, 0, 0, 6, (Object) null);
                if (binarySearch$default >= 0) {
                    fArr2[i3] = binarySearch$default / f5;
                } else if (binarySearch$default == -1) {
                    fArr2[i3] = f6;
                } else {
                    int i4 = -binarySearch$default;
                    int i5 = i4 - 2;
                    float f14 = i5;
                    float f15 = fArr[i5];
                    fArr2[i3] = (f14 + ((f13 - f15) / (fArr[i4 - 1] - f15))) / f5;
                }
            }
        }

        public final void setPoint(float f) {
            double lookup = lookup((this.vertical == -1.0f ? this.time2 - f : f - this.time1) * this.oneOverDeltaTime) * 1.5707964f;
            this.tmpSinAngle = (float) Math.sin(lookup);
            this.tmpCosAngle = (float) Math.cos(lookup);
        }
    }
}
