package androidx.core.content.res;

import androidx.core.graphics.ColorUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
/* loaded from: classes2.dex */
public class CamColor {
    private static final float CHROMA_SEARCH_ENDPOINT = 0.4f;
    private static final float DE_MAX = 1.0f;
    private static final float DL_MAX = 0.2f;
    private static final float LIGHTNESS_SEARCH_ENDPOINT = 0.01f;
    private final float mAstar;
    private final float mBstar;
    private final float mChroma;
    private final float mHue;
    private final float mJ;
    private final float mJstar;
    private final float mM;
    private final float mQ;
    private final float mS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getHue() {
        return this.mHue;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getChroma() {
        return this.mChroma;
    }

    float getJ() {
        return this.mJ;
    }

    float getQ() {
        return this.mQ;
    }

    float getM() {
        return this.mM;
    }

    float getS() {
        return this.mS;
    }

    float getJStar() {
        return this.mJstar;
    }

    float getAStar() {
        return this.mAstar;
    }

    float getBStar() {
        return this.mBstar;
    }

    CamColor(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.mHue = f;
        this.mChroma = f2;
        this.mJ = f3;
        this.mQ = f4;
        this.mM = f5;
        this.mS = f6;
        this.mJstar = f7;
        this.mAstar = f8;
        this.mBstar = f9;
    }

    public static int toColor(float f, float f2, float f3) {
        return toColor(f, f2, f3, ViewingConditions.DEFAULT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CamColor fromColor(int i) {
        float[] fArr = new float[7];
        float[] fArr2 = new float[3];
        fromColorInViewingConditions(i, ViewingConditions.DEFAULT, fArr, fArr2);
        return new CamColor(fArr2[0], fArr2[1], fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6]);
    }

    public static void getM3HCTfromColor(int i, float[] fArr) {
        fromColorInViewingConditions(i, ViewingConditions.DEFAULT, null, fArr);
        fArr[2] = CamUtils.lStarFromInt(i);
    }

    static void fromColorInViewingConditions(int i, ViewingConditions viewingConditions, float[] fArr, float[] fArr2) {
        float pow;
        CamUtils.xyzFromInt(i, fArr2);
        float[][] fArr3 = CamUtils.XYZ_TO_CAM16RGB;
        float f = fArr2[0];
        float[] fArr4 = fArr3[0];
        float f2 = fArr2[1];
        float f3 = fArr2[2];
        float f4 = (fArr4[0] * f) + (fArr4[1] * f2) + (fArr4[2] * f3);
        float[] fArr5 = fArr3[1];
        float f5 = (fArr5[0] * f) + (fArr5[1] * f2) + (fArr5[2] * f3);
        float[] fArr6 = fArr3[2];
        float f6 = viewingConditions.getRgbD()[0] * f4;
        float f7 = viewingConditions.getRgbD()[1] * f5;
        float f8 = viewingConditions.getRgbD()[2] * ((f * fArr6[0]) + (f2 * fArr6[1]) + (f3 * fArr6[2]));
        float pow2 = (float) Math.pow((viewingConditions.getFl() * Math.abs(f6)) / 100.0d, 0.42d);
        float pow3 = (float) Math.pow((viewingConditions.getFl() * Math.abs(f7)) / 100.0d, 0.42d);
        float pow4 = (float) Math.pow((viewingConditions.getFl() * Math.abs(f8)) / 100.0d, 0.42d);
        float signum = ((Math.signum(f6) * 400.0f) * pow2) / (pow2 + 27.13f);
        float signum2 = ((Math.signum(f7) * 400.0f) * pow3) / (pow3 + 27.13f);
        float signum3 = ((Math.signum(f8) * 400.0f) * pow4) / (pow4 + 27.13f);
        double d = signum3;
        float f9 = ((float) (((signum * 11.0d) + (signum2 * (-12.0d))) + d)) / 11.0f;
        float f10 = ((float) ((signum + signum2) - (d * 2.0d))) / 9.0f;
        float f11 = signum2 * 20.0f;
        float f12 = (((signum * 20.0f) + f11) + (21.0f * signum3)) / 20.0f;
        float f13 = (((signum * 40.0f) + f11) + signum3) / 20.0f;
        float atan2 = (((float) Math.atan2(f10, f9)) * 180.0f) / 3.1415927f;
        if (atan2 < 0.0f) {
            atan2 += 360.0f;
        } else if (atan2 >= 360.0f) {
            atan2 -= 360.0f;
        }
        float f14 = (3.1415927f * atan2) / 180.0f;
        float pow5 = ((float) Math.pow((f13 * viewingConditions.getNbb()) / viewingConditions.getAw(), viewingConditions.getC() * viewingConditions.getZ())) * 100.0f;
        float c = (4.0f / viewingConditions.getC()) * ((float) Math.sqrt(pow5 / 100.0f)) * (viewingConditions.getAw() + 4.0f) * viewingConditions.getFlRoot();
        float sqrt = ((float) Math.sqrt(pow5 / 100.0d)) * ((float) Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos((((((double) atan2) < 20.14d ? 360.0f + atan2 : atan2) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * viewingConditions.getNc()) * viewingConditions.getNcb()) * ((float) Math.sqrt((f9 * f9) + (f10 * f10)))) / (f12 + 0.305f), 0.9d));
        float flRoot = viewingConditions.getFlRoot() * sqrt;
        float sqrt2 = ((float) Math.sqrt((pow * viewingConditions.getC()) / (viewingConditions.getAw() + 4.0f))) * 50.0f;
        float f15 = (1.7f * pow5) / ((0.007f * pow5) + 1.0f);
        float log = ((float) Math.log((0.0228f * flRoot) + 1.0f)) * 43.85965f;
        double d2 = f14;
        float cos = ((float) Math.cos(d2)) * log;
        float sin = log * ((float) Math.sin(d2));
        fArr2[0] = atan2;
        fArr2[1] = sqrt;
        if (fArr != null) {
            fArr[0] = pow5;
            fArr[1] = c;
            fArr[2] = flRoot;
            fArr[3] = sqrt2;
            fArr[4] = f15;
            fArr[5] = cos;
            fArr[6] = sin;
        }
    }

    private static CamColor fromJch(float f, float f2, float f3) {
        return fromJchInFrame(f, f2, f3, ViewingConditions.DEFAULT);
    }

    private static CamColor fromJchInFrame(float f, float f2, float f3, ViewingConditions viewingConditions) {
        double d;
        float c = (4.0f / viewingConditions.getC()) * ((float) Math.sqrt(f / 100.0d)) * (viewingConditions.getAw() + 4.0f) * viewingConditions.getFlRoot();
        float flRoot = viewingConditions.getFlRoot() * f2;
        float sqrt = ((float) Math.sqrt(((f2 / ((float) Math.sqrt(d))) * viewingConditions.getC()) / (viewingConditions.getAw() + 4.0f))) * 50.0f;
        float f4 = (1.7f * f) / ((0.007f * f) + 1.0f);
        float log = ((float) Math.log((flRoot * 0.0228d) + 1.0d)) * 43.85965f;
        double d2 = (3.1415927f * f3) / 180.0f;
        return new CamColor(f3, f2, f, c, flRoot, sqrt, f4, ((float) Math.cos(d2)) * log, log * ((float) Math.sin(d2)));
    }

    float distance(CamColor camColor) {
        float jStar = getJStar() - camColor.getJStar();
        float aStar = getAStar() - camColor.getAStar();
        float bStar = getBStar() - camColor.getBStar();
        return (float) (Math.pow(Math.sqrt((jStar * jStar) + (aStar * aStar) + (bStar * bStar)), 0.63d) * 1.41d);
    }

    int viewedInSrgb() {
        return viewed(ViewingConditions.DEFAULT);
    }

    int viewed(ViewingConditions viewingConditions) {
        float f;
        float pow = (float) Math.pow(((((double) getChroma()) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || ((double) getJ()) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) ? 0.0f : getChroma() / ((float) Math.sqrt(getJ() / 100.0d))) / Math.pow(1.64d - Math.pow(0.29d, viewingConditions.getN()), 0.73d), 1.1111111111111112d);
        double hue = (getHue() * 3.1415927f) / 180.0f;
        float aw = viewingConditions.getAw() * ((float) Math.pow(getJ() / 100.0d, (1.0d / viewingConditions.getC()) / viewingConditions.getZ()));
        float cos = ((float) (Math.cos(2.0d + hue) + 3.8d)) * 0.25f * 3846.1538f * viewingConditions.getNc() * viewingConditions.getNcb();
        float nbb = aw / viewingConditions.getNbb();
        float sin = (float) Math.sin(hue);
        float cos2 = (float) Math.cos(hue);
        float f2 = (((0.305f + nbb) * 23.0f) * pow) / (((cos * 23.0f) + ((11.0f * pow) * cos2)) + ((pow * 108.0f) * sin));
        float f3 = cos2 * f2;
        float f4 = f2 * sin;
        float f5 = nbb * 460.0f;
        float f6 = (((451.0f * f3) + f5) + (288.0f * f4)) / 1403.0f;
        float f7 = ((f5 - (891.0f * f3)) - (261.0f * f4)) / 1403.0f;
        float signum = Math.signum(f6) * (100.0f / viewingConditions.getFl()) * ((float) Math.pow((float) Math.max((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, (Math.abs(f6) * 27.13d) / (400.0d - Math.abs(f6))), 2.380952380952381d));
        float signum2 = Math.signum(f7) * (100.0f / viewingConditions.getFl()) * ((float) Math.pow((float) Math.max((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, (Math.abs(f7) * 27.13d) / (400.0d - Math.abs(f7))), 2.380952380952381d));
        float signum3 = Math.signum(((f5 - (f3 * 220.0f)) - (f4 * 6300.0f)) / 1403.0f) * (100.0f / viewingConditions.getFl()) * ((float) Math.pow((float) Math.max((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, (Math.abs(f) * 27.13d) / (400.0d - Math.abs(f))), 2.380952380952381d));
        float f8 = signum / viewingConditions.getRgbD()[0];
        float f9 = signum2 / viewingConditions.getRgbD()[1];
        float f10 = signum3 / viewingConditions.getRgbD()[2];
        float[][] fArr = CamUtils.CAM16RGB_TO_XYZ;
        float[] fArr2 = fArr[0];
        float f11 = (fArr2[0] * f8) + (fArr2[1] * f9) + (fArr2[2] * f10);
        float[] fArr3 = fArr[1];
        float[] fArr4 = fArr[2];
        return ColorUtils.XYZToColor(f11, (fArr3[0] * f8) + (fArr3[1] * f9) + (fArr3[2] * f10), (f8 * fArr4[0]) + (f9 * fArr4[1]) + (f10 * fArr4[2]));
    }

    static int toColor(float f, float f2, float f3, ViewingConditions viewingConditions) {
        if (f2 < 1.0d || Math.round(f3) <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || Math.round(f3) >= 100.0d) {
            return CamUtils.intFromLStar(f3);
        }
        float min = f < 0.0f ? 0.0f : Math.min(360.0f, f);
        CamColor camColor = null;
        boolean z = true;
        float f4 = 0.0f;
        float f5 = f2;
        while (Math.abs(f4 - f2) >= 0.4f) {
            CamColor findCamByJ = findCamByJ(min, f5, f3);
            if (!z) {
                if (findCamByJ == null) {
                    f2 = f5;
                } else {
                    f4 = f5;
                    camColor = findCamByJ;
                }
                f5 = ((f2 - f4) / 2.0f) + f4;
            } else if (findCamByJ != null) {
                return findCamByJ.viewed(viewingConditions);
            } else {
                f5 = ((f2 - f4) / 2.0f) + f4;
                z = false;
            }
        }
        if (camColor == null) {
            return CamUtils.intFromLStar(f3);
        }
        return camColor.viewed(viewingConditions);
    }

    private static CamColor findCamByJ(float f, float f2, float f3) {
        float f4 = 100.0f;
        float f5 = 1000.0f;
        float f6 = 0.0f;
        CamColor camColor = null;
        float f7 = 1000.0f;
        while (Math.abs(f6 - f4) > 0.01f) {
            float f8 = ((f4 - f6) / 2.0f) + f6;
            int viewedInSrgb = fromJch(f8, f2, f).viewedInSrgb();
            float lStarFromInt = CamUtils.lStarFromInt(viewedInSrgb);
            float abs = Math.abs(f3 - lStarFromInt);
            if (abs < 0.2f) {
                CamColor fromColor = fromColor(viewedInSrgb);
                float distance = fromColor.distance(fromJch(fromColor.getJ(), fromColor.getChroma(), f));
                if (distance <= 1.0f) {
                    camColor = fromColor;
                    f5 = abs;
                    f7 = distance;
                }
            }
            if (f5 == 0.0f && f7 == 0.0f) {
                return camColor;
            }
            if (lStarFromInt < f3) {
                f6 = f8;
            } else {
                f4 = f8;
            }
        }
        return camColor;
    }
}
