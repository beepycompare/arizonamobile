package androidx.compose.material3.internal.colorUtil;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: Frame.android.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\u0013\b\u0001\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cBY\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0002\u001a\u00020\u00038G¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u00020\u00038G¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001a\u00020\u00038G¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0013\u0010\t\u001a\u00020\n8G¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0013\u0010\f\u001a\u00020\u00038G¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0011R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u0006\u001d"}, d2 = {"Landroidx/compose/material3/internal/colorUtil/Frame;", "", "n", "", "aw", "nbb", "ncb", "c", "nc", "rgbD", "", "fl", "flRoot", "z", "<init>", "(FFFFFF[FFFF)V", "getN", "()F", "getAw", "getNbb", "getNcb", "getC", "getNc", "getRgbD", "()[F", "getFl", "getFlRoot", "getZ", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Frame {
    public static final int $stable;
    public static final Companion Companion;
    private static final Frame Default;
    private final float aw;
    private final float c;
    private final float fl;
    private final float flRoot;
    private final float n;
    private final float nbb;
    private final float nc;
    private final float ncb;
    private final float[] rgbD;
    private final float z;

    public /* synthetic */ Frame(float f, float f2, float f3, float f4, float f5, float f6, float[] fArr, float f7, float f8, float f9, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, f5, f6, fArr, f7, f8, f9);
    }

    private Frame(float f, float f2, float f3, float f4, float f5, float f6, float[] fArr, float f7, float f8, float f9) {
        this.n = f;
        this.aw = f2;
        this.nbb = f3;
        this.ncb = f4;
        this.c = f5;
        this.nc = f6;
        this.rgbD = fArr;
        this.fl = f7;
        this.flRoot = f8;
        this.z = f9;
    }

    public final float getN() {
        return this.n;
    }

    public final float getAw() {
        return this.aw;
    }

    public final float getNbb() {
        return this.nbb;
    }

    public final float getNcb() {
        return this.ncb;
    }

    public final float getC() {
        return this.c;
    }

    public final float getNc() {
        return this.nc;
    }

    public final float[] getRgbD() {
        return this.rgbD;
    }

    public final float getFl() {
        return this.fl;
    }

    public final float getFlRoot() {
        return this.flRoot;
    }

    public final float getZ() {
        return this.z;
    }

    /* compiled from: Frame.android.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Landroidx/compose/material3/internal/colorUtil/Frame$Companion;", "", "<init>", "()V", "Default", "Landroidx/compose/material3/internal/colorUtil/Frame;", "getDefault", "()Landroidx/compose/material3/internal/colorUtil/Frame;", "make", "whitepoint", "", "adaptingLuminance", "", "backgroundLstar", "surround", "discountingIlluminant", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Frame getDefault() {
            return Frame.Default;
        }

        public final Frame make(float[] fArr, float f, float f2, float f3, boolean z) {
            float[][] xyz_to_cam16rgb = CamUtils.INSTANCE.getXYZ_TO_CAM16RGB();
            float f4 = fArr[0];
            float[] fArr2 = xyz_to_cam16rgb[0];
            float f5 = fArr[1];
            float f6 = fArr[2];
            float f7 = (fArr2[0] * f4) + (fArr2[1] * f5) + (fArr2[2] * f6);
            float[] fArr3 = xyz_to_cam16rgb[1];
            float f8 = (fArr3[0] * f4) + (fArr3[1] * f5) + (fArr3[2] * f6);
            float[] fArr4 = xyz_to_cam16rgb[2];
            float f9 = (f4 * fArr4[0]) + (f5 * fArr4[1]) + (f6 * fArr4[2]);
            float f10 = (f3 / 10.0f) + 0.8f;
            float lerp = ((double) f10) >= 0.9d ? Frame_androidKt.lerp(0.59f, 0.69f, (f10 - 0.9f) * 10.0f) : Frame_androidKt.lerp(0.525f, 0.59f, (f10 - 0.8f) * 10.0f);
            float exp = z ? 1.0f : (1.0f - (((float) Math.exp(((-f) - 42.0f) / 92.0f)) * 0.2777778f)) * f10;
            double d = exp;
            if (d > 1.0d) {
                exp = 1.0f;
            } else if (d < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                exp = 0.0f;
            }
            float[] fArr5 = {(((100.0f / f7) * exp) + 1.0f) - exp, (((100.0f / f8) * exp) + 1.0f) - exp, (((100.0f / f9) * exp) + 1.0f) - exp};
            float f11 = 1.0f / ((5.0f * f) + 1.0f);
            float f12 = f11 * f11 * f11 * f11;
            float f13 = 1.0f - f12;
            float cbrt = (f12 * f) + (0.1f * f13 * f13 * ((float) Math.cbrt(f * 5.0d)));
            float yFromLstar = ((float) CamUtils.INSTANCE.yFromLstar(f2)) / fArr[1];
            double d2 = yFromLstar;
            float sqrt = ((float) Math.sqrt(d2)) + 1.48f;
            float pow = 0.725f / ((float) Math.pow(d2, 0.20000000298023224d));
            float[] fArr6 = {(float) Math.pow(((fArr5[0] * cbrt) * f7) / 100.0f, 0.41999998688697815d), (float) Math.pow(((fArr5[1] * cbrt) * f8) / 100.0f, 0.41999998688697815d), (float) Math.pow(((fArr5[2] * cbrt) * f9) / 100.0f, 0.41999998688697815d)};
            float f14 = fArr6[0];
            float f15 = (f14 * 400.0f) / (f14 + 27.13f);
            float f16 = fArr6[1];
            float f17 = (f16 * 400.0f) / (f16 + 27.13f);
            float f18 = fArr6[2];
            float[] fArr7 = {f15, f17, (400.0f * f18) / (f18 + 27.13f)};
            return new Frame(yFromLstar, ((fArr7[0] * 2.0f) + fArr7[1] + (fArr7[2] * 0.05f)) * pow, pow, pow, lerp, f10, fArr5, cbrt, (float) Math.pow(cbrt, 0.25d), sqrt, null);
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        $stable = 8;
        Default = companion.make(CamUtils.INSTANCE.getWHITE_POINT_D65(), (float) ((CamUtils.INSTANCE.yFromLstar(50.0d) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);
    }
}
