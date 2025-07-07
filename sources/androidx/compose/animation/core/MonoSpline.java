package androidx.compose.animation.core;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
/* compiled from: MonoSpline.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0013J \u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0003H\u0002J\u0018\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0013H\u0002J#\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0013H\u0002¢\u0006\u0002\u0010\u001aR\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u001b"}, d2 = {"Landroidx/compose/animation/core/MonoSpline;", "", "time", "", "y", "", "periodicBias", "", "([F[[FF)V", "slopeTemp", "tangents", "[[F", "timePoints", "values", "getPos", "", "v", "Landroidx/compose/animation/core/AnimationVector;", FirebaseAnalytics.Param.INDEX, "", "t", "j", "getSlope", "makeFloatArray", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "(II)[[F", "animation-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MonoSpline {
    public static final int $stable = 8;
    private final float[] slopeTemp;
    private final float[][] tangents;
    private final float[] timePoints;
    private final float[][] values;

    public MonoSpline(float[] fArr, float[][] fArr2, float f) {
        int i;
        int length = fArr.length;
        int i2 = 0;
        int length2 = fArr2[0].length;
        this.slopeTemp = new float[length2];
        int i3 = length - 1;
        float[][] makeFloatArray = makeFloatArray(i3, length2);
        float[][] makeFloatArray2 = makeFloatArray(length, length2);
        for (int i4 = 0; i4 < length2; i4++) {
            int i5 = 0;
            while (i5 < i3) {
                int i6 = i5 + 1;
                float f2 = fArr[i6] - fArr[i5];
                float[] fArr3 = makeFloatArray[i5];
                float f3 = (fArr2[i6][i4] - fArr2[i5][i4]) / f2;
                fArr3[i4] = f3;
                if (i5 == 0) {
                    makeFloatArray2[i5][i4] = f3;
                } else {
                    makeFloatArray2[i5][i4] = (makeFloatArray[i5 - 1][i4] + f3) * 0.5f;
                }
                i5 = i6;
            }
            makeFloatArray2[i3][i4] = makeFloatArray[length - 2][i4];
        }
        if (!Float.isNaN(f)) {
            for (int i7 = 0; i7 < length2; i7++) {
                float[] fArr4 = makeFloatArray[length - 2];
                float f4 = fArr4[i7] * (1 - f);
                float[] fArr5 = makeFloatArray[0];
                float f5 = f4 + (fArr5[i7] * f);
                fArr5[i7] = f5;
                fArr4[i7] = f5;
                makeFloatArray2[i3][i7] = f5;
                makeFloatArray2[0][i7] = f5;
            }
        }
        int i8 = 0;
        while (i8 < i3) {
            int i9 = i2;
            while (i9 < length2) {
                float f6 = makeFloatArray[i8][i9];
                if (f6 == 0.0f) {
                    makeFloatArray2[i8][i9] = 0.0f;
                    makeFloatArray2[i8 + 1][i9] = 0.0f;
                    i = length2;
                } else {
                    float f7 = makeFloatArray2[i8][i9] / f6;
                    int i10 = i8 + 1;
                    float f8 = makeFloatArray2[i10][i9] / f6;
                    i = length2;
                    float hypot = (float) Math.hypot(f7, f8);
                    if (hypot > 9.0d) {
                        float f9 = 3.0f / hypot;
                        float[] fArr6 = makeFloatArray2[i8];
                        float[] fArr7 = makeFloatArray[i8];
                        fArr6[i9] = f7 * f9 * fArr7[i9];
                        makeFloatArray2[i10][i9] = f9 * f8 * fArr7[i9];
                    }
                }
                i9++;
                length2 = i;
            }
            i8++;
            i2 = 0;
        }
        this.timePoints = fArr;
        this.values = fArr2;
        this.tangents = makeFloatArray2;
    }

    private final float[][] makeFloatArray(int i, int i2) {
        float[][] fArr = new float[i];
        for (int i3 = 0; i3 < i; i3++) {
            fArr[i3] = new float[i2];
        }
        return fArr;
    }

    public final float getPos(float f, int i) {
        int i2;
        float[][] fArr = this.values;
        float[][] fArr2 = this.tangents;
        float[] fArr3 = this.timePoints;
        int length = fArr3.length;
        int i3 = 0;
        if (f <= fArr3[0]) {
            i2 = 0;
        } else {
            i2 = length - 1;
            if (f < fArr3[i2]) {
                i2 = -1;
            }
        }
        if (i2 != -1) {
            float f2 = fArr[i2][i];
            float f3 = fArr3[i2];
            return f2 + ((f - f3) * getSlope(f3, i));
        }
        int i4 = length - 1;
        while (i3 < i4) {
            float[] fArr4 = this.timePoints;
            float f4 = fArr4[i3];
            if (f == f4) {
                return fArr[i3][i];
            }
            int i5 = i3 + 1;
            float f5 = fArr4[i5];
            if (f < f5) {
                float f6 = f5 - f4;
                return MonoSplineKt.hermiteInterpolate(f6, (f - f4) / f6, fArr[i3][i], fArr[i5][i], fArr2[i3][i], fArr2[i5][i]);
            }
            i3 = i5;
        }
        return 0.0f;
    }

    public static /* synthetic */ void getPos$default(MonoSpline monoSpline, float f, AnimationVector animationVector, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        monoSpline.getPos(f, animationVector, i);
    }

    public final void getPos(float f, AnimationVector animationVector, int i) {
        int i2;
        float[] fArr = this.timePoints;
        int length = fArr.length;
        int i3 = 0;
        int length2 = this.values[0].length;
        if (f <= fArr[0]) {
            i2 = 0;
        } else {
            i2 = length - 1;
            if (f < fArr[i2]) {
                i2 = -1;
            }
        }
        if (i2 != -1) {
            getSlope(fArr[i2], this.slopeTemp);
            while (i3 < length2) {
                animationVector.set$animation_core_release(i3, this.values[i2][i3] + ((f - this.timePoints[i2]) * this.slopeTemp[i3]));
                i3++;
            }
            return;
        }
        int i4 = length - 1;
        int i5 = i;
        while (i5 < i4) {
            float[] fArr2 = this.timePoints;
            float f2 = fArr2[i5];
            if (f == f2) {
                while (i3 < length2) {
                    animationVector.set$animation_core_release(i3, this.values[i5][i3]);
                    i3++;
                }
                return;
            }
            int i6 = i5 + 1;
            float f3 = fArr2[i6];
            if (f < f3) {
                float f4 = f3 - f2;
                float f5 = (f - f2) / f4;
                while (i3 < length2) {
                    float[][] fArr3 = this.values;
                    float f6 = fArr3[i5][i3];
                    float f7 = fArr3[i6][i3];
                    float[][] fArr4 = this.tangents;
                    animationVector.set$animation_core_release(i3, MonoSplineKt.hermiteInterpolate(f4, f5, f6, f7, fArr4[i5][i3], fArr4[i6][i3]));
                    i3++;
                }
                return;
            }
            i5 = i6;
        }
    }

    private final void getSlope(float f, float[] fArr) {
        int length = this.values[0].length;
        float[] fArr2 = this.timePoints;
        int length2 = fArr2.length;
        float f2 = fArr2[0];
        int i = length2 - 1;
        float f3 = fArr2[i];
        if (f < f2) {
            f = f2;
        }
        if (f <= f3) {
            f3 = f;
        }
        if (fArr.length < length) {
            return;
        }
        int i2 = 0;
        while (i2 < i) {
            float[] fArr3 = this.timePoints;
            int i3 = i2 + 1;
            float f4 = fArr3[i3];
            if (f3 <= f4) {
                float f5 = fArr3[i2];
                float f6 = f4 - f5;
                float f7 = (f3 - f5) / f6;
                for (int i4 = 0; i4 < length; i4++) {
                    float[][] fArr4 = this.values;
                    float f8 = fArr4[i2][i4];
                    float f9 = fArr4[i3][i4];
                    float[][] fArr5 = this.tangents;
                    fArr[i4] = MonoSplineKt.hermiteDifferential(f6, f7, f8, f9, fArr5[i2][i4], fArr5[i3][i4]) / f6;
                }
                return;
            }
            i2 = i3;
        }
    }

    public static /* synthetic */ void getSlope$default(MonoSpline monoSpline, float f, AnimationVector animationVector, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        monoSpline.getSlope(f, animationVector, i);
    }

    public final void getSlope(float f, AnimationVector animationVector, int i) {
        int i2;
        float[] fArr = this.timePoints;
        float[][] fArr2 = this.values;
        float[][] fArr3 = this.tangents;
        int length = fArr.length;
        int i3 = 0;
        int length2 = fArr2[0].length;
        if (f <= fArr[0]) {
            i2 = 0;
        } else {
            i2 = length - 1;
            if (f < fArr[i2]) {
                i2 = -1;
            }
        }
        if (i2 != -1) {
            float[] fArr4 = fArr3[i2];
            if (fArr4.length < length2) {
                return;
            }
            while (i3 < length2) {
                animationVector.set$animation_core_release(i3, fArr4[i3]);
                i3++;
            }
            return;
        }
        int i4 = length - 1;
        int i5 = i;
        while (i5 < i4) {
            int i6 = i5 + 1;
            float f2 = fArr[i6];
            if (f <= f2) {
                float f3 = fArr[i5];
                float f4 = f2 - f3;
                float f5 = (f - f3) / f4;
                while (i3 < length2) {
                    animationVector.set$animation_core_release(i3, MonoSplineKt.hermiteDifferential(f4, f5, fArr2[i5][i3], fArr2[i6][i3], fArr3[i5][i3], fArr3[i6][i3]) / f4);
                    i3++;
                }
                return;
            }
            i5 = i6;
        }
    }

    private final float getSlope(float f, int i) {
        float[] fArr = this.timePoints;
        float[][] fArr2 = this.values;
        float[][] fArr3 = this.tangents;
        int length = fArr.length;
        int i2 = 0;
        float f2 = fArr[0];
        int i3 = length - 1;
        float f3 = fArr[i3];
        if (f < f2) {
            f = f2;
        }
        if (f <= f3) {
            f3 = f;
        }
        while (i2 < i3) {
            int i4 = i2 + 1;
            float f4 = fArr[i4];
            if (f3 <= f4) {
                float f5 = fArr2[i2][i];
                float f6 = fArr2[i4][i];
                float f7 = fArr3[i2][i];
                float f8 = fArr3[i4][i];
                float f9 = fArr[i2];
                float f10 = f4 - f9;
                return MonoSplineKt.hermiteDifferential(f10, (f3 - f9) / f10, f5, f6, f7, f8) / f10;
            }
            i2 = i4;
        }
        return 0.0f;
    }
}
