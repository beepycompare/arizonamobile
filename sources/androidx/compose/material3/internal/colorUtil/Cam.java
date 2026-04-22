package androidx.compose.material3.internal.colorUtil;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.graphics.ColorUtils;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Cam.android.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fBG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0000J\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000e¨\u0006 "}, d2 = {"Landroidx/compose/material3/internal/colorUtil/Cam;", "", "hue", "", "chroma", "j", CmcdData.OBJECT_TYPE_MANIFEST, CmcdData.STREAMING_FORMAT_SS, "jstar", "astar", "bstar", "<init>", "(FFFFFFFF)V", "getHue", "()F", "getChroma", "getJ", "getM", "getS", "getJstar", "setJstar", "(F)V", "getAstar", "getBstar", "distance", "other", "viewedInSrgb", "", "viewed", TypedValues.AttributesType.S_FRAME, "Landroidx/compose/material3/internal/colorUtil/Frame;", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Cam {
    private static final float CHROMA_SEARCH_ENDPOINT = 0.4f;
    private static final float DE_MAX = 1.0f;
    private static final float DL_MAX = 0.2f;
    private static final float LIGHTNESS_SEARCH_ENDPOINT = 0.01f;
    private final float astar;
    private final float bstar;
    private final float chroma;
    private final float hue;
    private final float j;
    private float jstar;
    private final float m;
    private final float s;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public Cam(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        this.hue = f;
        this.chroma = f2;
        this.j = f3;
        this.m = f4;
        this.s = f5;
        this.jstar = f6;
        this.astar = f7;
        this.bstar = f8;
    }

    public final float getHue() {
        return this.hue;
    }

    public final float getChroma() {
        return this.chroma;
    }

    public final float getJ() {
        return this.j;
    }

    public final float getM() {
        return this.m;
    }

    public final float getS() {
        return this.s;
    }

    public final float getJstar() {
        return this.jstar;
    }

    public final void setJstar(float f) {
        this.jstar = f;
    }

    public final float getAstar() {
        return this.astar;
    }

    public final float getBstar() {
        return this.bstar;
    }

    public final float distance(Cam cam) {
        float f = this.jstar - cam.jstar;
        float f2 = this.astar - cam.astar;
        float f3 = this.bstar - cam.bstar;
        return (float) (Math.pow(Math.sqrt((f * f) + (f2 * f2) + (f3 * f3)), 0.63d) * 1.41d);
    }

    public final int viewedInSrgb() {
        return viewed(Frame.Companion.getDefault());
    }

    public final int viewed(Frame frame) {
        float f;
        float f2;
        float f3;
        float f4 = this.chroma;
        if (f4 != 0.0f) {
            if (this.j != 0.0f) {
                f = f4 / ((float) Math.sqrt(f3 / 100.0f));
                float pow = f / ((float) Math.pow(1.64f - ((float) Math.pow((float) Math.pow(0.28999999165534973d, frame.getN()), 0.7300000190734863d)), 1.1111111640930176d));
                float f5 = (this.hue * 3.1415927f) / 180.0f;
                float aw = frame.getAw() * ((float) Math.pow(this.j / 100.0f, (1.0f / frame.getC()) / frame.getZ()));
                float cos = (((float) Math.cos(2.0f + f5)) + 3.8f) * 0.25f * 3846.1538f * frame.getNc() * frame.getNcb();
                float nbb = aw / frame.getNbb();
                double d = f5;
                float sin = (float) Math.sin(d);
                float cos2 = (float) Math.cos(d);
                float f6 = (((0.305f + nbb) * 23.0f) * pow) / (((cos * 23.0f) + ((11.0f * pow) * cos2)) + ((pow * 108.0f) * sin));
                float f7 = cos2 * f6;
                float f8 = f6 * sin;
                float f9 = nbb * 460.0f;
                float f10 = (((451.0f * f7) + f9) + (288.0f * f8)) / 1403.0f;
                float f11 = ((f9 - (891.0f * f7)) - (261.0f * f8)) / 1403.0f;
                float signum = Math.signum(f10) * (100.0f / frame.getFl()) * ((float) Math.pow(Math.max(0.0f, (Math.abs(f10) * 27.13f) / (400.0f - Math.abs(f10))), 2.3809523582458496d));
                float signum2 = Math.signum(f11) * (100.0f / frame.getFl()) * ((float) Math.pow(Math.max(0.0f, (Math.abs(f11) * 27.13f) / (400.0f - Math.abs(f11))), 2.3809523582458496d));
                float signum3 = Math.signum(((f9 - (f7 * 220.0f)) - (f8 * 6300.0f)) / 1403.0f) * (100.0f / frame.getFl()) * ((float) Math.pow(Math.max(0.0f, (Math.abs(f2) * 27.13f) / (400.0f - Math.abs(f2))), 2.3809523582458496d));
                float f12 = signum / frame.getRgbD()[0];
                float f13 = signum2 / frame.getRgbD()[1];
                float f14 = signum3 / frame.getRgbD()[2];
                float[][] cam16rgb_to_xyz = CamUtils.INSTANCE.getCAM16RGB_TO_XYZ();
                float[] fArr = cam16rgb_to_xyz[0];
                float f15 = (fArr[0] * f12) + (fArr[1] * f13) + (fArr[2] * f14);
                float[] fArr2 = cam16rgb_to_xyz[1];
                float[] fArr3 = cam16rgb_to_xyz[2];
                return ColorUtils.XYZToColor(f15, (fArr2[0] * f12) + (fArr2[1] * f13) + (fArr2[2] * f14), (f12 * fArr3[0]) + (f13 * fArr3[1]) + (f14 * fArr3[2]));
            }
        }
        f = 0.0f;
        float pow2 = f / ((float) Math.pow(1.64f - ((float) Math.pow((float) Math.pow(0.28999999165534973d, frame.getN()), 0.7300000190734863d)), 1.1111111640930176d));
        float f52 = (this.hue * 3.1415927f) / 180.0f;
        float aw2 = frame.getAw() * ((float) Math.pow(this.j / 100.0f, (1.0f / frame.getC()) / frame.getZ()));
        float cos3 = (((float) Math.cos(2.0f + f52)) + 3.8f) * 0.25f * 3846.1538f * frame.getNc() * frame.getNcb();
        float nbb2 = aw2 / frame.getNbb();
        double d2 = f52;
        float sin2 = (float) Math.sin(d2);
        float cos22 = (float) Math.cos(d2);
        float f62 = (((0.305f + nbb2) * 23.0f) * pow2) / (((cos3 * 23.0f) + ((11.0f * pow2) * cos22)) + ((pow2 * 108.0f) * sin2));
        float f72 = cos22 * f62;
        float f82 = f62 * sin2;
        float f92 = nbb2 * 460.0f;
        float f102 = (((451.0f * f72) + f92) + (288.0f * f82)) / 1403.0f;
        float f112 = ((f92 - (891.0f * f72)) - (261.0f * f82)) / 1403.0f;
        float signum4 = Math.signum(f102) * (100.0f / frame.getFl()) * ((float) Math.pow(Math.max(0.0f, (Math.abs(f102) * 27.13f) / (400.0f - Math.abs(f102))), 2.3809523582458496d));
        float signum22 = Math.signum(f112) * (100.0f / frame.getFl()) * ((float) Math.pow(Math.max(0.0f, (Math.abs(f112) * 27.13f) / (400.0f - Math.abs(f112))), 2.3809523582458496d));
        float signum32 = Math.signum(((f92 - (f72 * 220.0f)) - (f82 * 6300.0f)) / 1403.0f) * (100.0f / frame.getFl()) * ((float) Math.pow(Math.max(0.0f, (Math.abs(f2) * 27.13f) / (400.0f - Math.abs(f2))), 2.3809523582458496d));
        float f122 = signum4 / frame.getRgbD()[0];
        float f132 = signum22 / frame.getRgbD()[1];
        float f142 = signum32 / frame.getRgbD()[2];
        float[][] cam16rgb_to_xyz2 = CamUtils.INSTANCE.getCAM16RGB_TO_XYZ();
        float[] fArr4 = cam16rgb_to_xyz2[0];
        float f152 = (fArr4[0] * f122) + (fArr4[1] * f132) + (fArr4[2] * f142);
        float[] fArr22 = cam16rgb_to_xyz2[1];
        float[] fArr32 = cam16rgb_to_xyz2[2];
        return ColorUtils.XYZToColor(f152, (fArr22[0] * f122) + (fArr22[1] * f132) + (fArr22[2] * f142), (f122 * fArr32[0]) + (f132 * fArr32[1]) + (f142 * fArr32[2]));
    }

    /* compiled from: Cam.android.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nJ\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J \u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J(\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\"\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/compose/material3/internal/colorUtil/Cam$Companion;", "", "<init>", "()V", "DL_MAX", "", "DE_MAX", "CHROMA_SEARCH_ENDPOINT", "LIGHTNESS_SEARCH_ENDPOINT", "getInt", "", "hue", "chroma", "lstar", "fromInt", "Landroidx/compose/material3/internal/colorUtil/Cam;", "argb", "fromIntInFrame", TypedValues.AttributesType.S_FRAME, "Landroidx/compose/material3/internal/colorUtil/Frame;", "fromJch", "j", "c", CmcdData.STREAMING_FORMAT_HLS, "fromJchInFrame", "findCamByJ", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getInt(float f, float f2, float f3) {
            return getInt(f, f2, f3, Frame.Companion.getDefault());
        }

        public final Cam fromInt(int i) {
            return fromIntInFrame(i, Frame.Companion.getDefault());
        }

        private final Cam fromIntInFrame(int i, Frame frame) {
            float pow;
            float[] xyzFromInt = CamUtils.INSTANCE.xyzFromInt(i);
            float[][] xyz_to_cam16rgb = CamUtils.INSTANCE.getXYZ_TO_CAM16RGB();
            float f = xyzFromInt[0];
            float[] fArr = xyz_to_cam16rgb[0];
            float f2 = xyzFromInt[1];
            float f3 = xyzFromInt[2];
            float f4 = (fArr[0] * f) + (fArr[1] * f2) + (fArr[2] * f3);
            float[] fArr2 = xyz_to_cam16rgb[1];
            float f5 = (fArr2[0] * f) + (fArr2[1] * f2) + (fArr2[2] * f3);
            float[] fArr3 = xyz_to_cam16rgb[2];
            float f6 = (f * fArr3[0]) + (f2 * fArr3[1]) + (f3 * fArr3[2]);
            float f7 = frame.getRgbD()[0] * f4;
            float f8 = frame.getRgbD()[1] * f5;
            float f9 = frame.getRgbD()[2] * f6;
            float pow2 = (float) Math.pow((frame.getFl() * Math.abs(f7)) / 100.0f, 0.41999998688697815d);
            float pow3 = (float) Math.pow((frame.getFl() * Math.abs(f8)) / 100.0f, 0.41999998688697815d);
            float pow4 = (float) Math.pow((frame.getFl() * Math.abs(f9)) / 100.0f, 0.41999998688697815d);
            float signum = ((Math.signum(f7) * 400.0f) * pow2) / (pow2 + 27.13f);
            float signum2 = ((Math.signum(f8) * 400.0f) * pow3) / (pow3 + 27.13f);
            float signum3 = ((Math.signum(f9) * 400.0f) * pow4) / (pow4 + 27.13f);
            float f10 = (((signum * 11.0f) + ((-12.0f) * signum2)) + signum3) / 11.0f;
            float f11 = ((signum + signum2) - (signum3 * 2.0f)) / 9.0f;
            float f12 = signum2 * 20.0f;
            float f13 = (((signum * 20.0f) + f12) + (21.0f * signum3)) / 20.0f;
            float f14 = (((signum * 40.0f) + f12) + signum3) / 20.0f;
            float atan2 = (((float) Math.atan2(f11, f10)) * 180.0f) / 3.1415927f;
            if (atan2 < 0.0f) {
                atan2 += 360.0f;
            } else if (atan2 >= 360.0f) {
                atan2 -= 360.0f;
            }
            float f15 = atan2;
            float f16 = (f15 * 3.1415927f) / 180.0f;
            float pow5 = ((float) Math.pow((f14 * frame.getNbb()) / frame.getAw(), frame.getC() * frame.getZ())) * 100.0f;
            float pow6 = ((float) Math.pow(((((((((float) Math.cos((((((double) f15) < 20.14d ? 360.0f + f15 : f15) * 3.1415927f) / 180.0f) + 2.0f)) + 3.8f) * 0.25f) * 3846.1538f) * frame.getNc()) * frame.getNcb()) * ((float) Math.sqrt((f10 * f10) + (f11 * f11)))) / (f13 + 0.305f), 0.8999999761581421d)) * ((float) Math.pow(1.64f - ((float) Math.pow(0.28999999165534973d, frame.getN())), 0.7300000190734863d)) * ((float) Math.sqrt(pow5 / 100.0f));
            float flRoot = pow6 * frame.getFlRoot();
            float sqrt = ((float) Math.sqrt((pow * frame.getC()) / (frame.getAw() + 4.0f))) * 50.0f;
            float f17 = (1.7f * pow5) / ((0.007f * pow5) + 1.0f);
            float log = ((float) Math.log((0.0228f * flRoot) + 1.0f)) * 43.85965f;
            double d = f16;
            return new Cam(f15, pow6, pow5, flRoot, sqrt, f17, log * ((float) Math.cos(d)), log * ((float) Math.sin(d)));
        }

        private final Cam fromJch(float f, float f2, float f3) {
            return fromJchInFrame(f, f2, f3, Frame.Companion.getDefault());
        }

        private final Cam fromJchInFrame(float f, float f2, float f3, Frame frame) {
            float flRoot = f2 * frame.getFlRoot();
            float sqrt = ((float) Math.sqrt(((f2 / ((float) Math.sqrt(f / 100.0d))) * frame.getC()) / (frame.getAw() + 4.0f))) * 50.0f;
            float f4 = (1.7f * f) / ((0.007f * f) + 1.0f);
            float log = ((float) Math.log((flRoot * 0.0228d) + 1.0d)) * 43.85965f;
            double d = (3.1415927f * f3) / 180.0f;
            return new Cam(f3, f2, f, flRoot, sqrt, f4, log * ((float) Math.cos(d)), log * ((float) Math.sin(d)));
        }

        private final int getInt(float f, float f2, float f3, Frame frame) {
            if (Intrinsics.areEqual(frame, Frame.Companion.getDefault())) {
                return HctSolver.INSTANCE.solveToInt(f, f2, f3);
            }
            if (f2 < 1.0d || Math.round(f3) <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || Math.round(f3) >= 100.0d) {
                return CamUtils.INSTANCE.intFromLstar(f3);
            }
            float min = f < 0.0f ? 0.0f : Math.min(360.0f, f);
            Cam cam = null;
            boolean z = true;
            float f4 = 0.0f;
            float f5 = f2;
            while (Math.abs(f4 - f2) >= 0.4000000059604645d) {
                Cam findCamByJ = findCamByJ(min, f5, f3);
                if (!z) {
                    if (findCamByJ == null) {
                        f2 = f5;
                    } else {
                        f4 = f5;
                        cam = findCamByJ;
                    }
                    f5 = ((f2 - f4) / 2.0f) + f4;
                } else if (findCamByJ != null) {
                    return findCamByJ.viewed(frame);
                } else {
                    f5 = ((f2 - f4) / 2.0f) + f4;
                    z = false;
                }
            }
            if (cam == null) {
                return CamUtils.INSTANCE.intFromLstar(f3);
            }
            return cam.viewed(frame);
        }

        private final Cam findCamByJ(float f, float f2, float f3) {
            float f4 = 100.0f;
            float f5 = 1000.0f;
            float f6 = 0.0f;
            Cam cam = null;
            float f7 = 1000.0f;
            while (Math.abs(f6 - f4) > 0.009999999776482582d) {
                float f8 = ((f4 - f6) / 2.0f) + f6;
                int viewedInSrgb = fromJch(f8, f2, f).viewedInSrgb();
                float lstarFromInt = CamUtils.INSTANCE.lstarFromInt(viewedInSrgb);
                float abs = (float) Math.abs(f3 - lstarFromInt);
                if (abs < 0.2f) {
                    Cam fromInt = fromInt(viewedInSrgb);
                    float distance = fromInt.distance(fromJch(fromInt.getJ(), fromInt.getChroma(), f));
                    if (distance <= 1.0f) {
                        cam = fromInt;
                        f5 = abs;
                        f7 = distance;
                    }
                }
                if (f5 == 0.0f && f7 == 0.0f) {
                    return cam;
                }
                if (lstarFromInt < f3) {
                    f6 = f8;
                } else {
                    f4 = f8;
                }
            }
            return cam;
        }
    }
}
