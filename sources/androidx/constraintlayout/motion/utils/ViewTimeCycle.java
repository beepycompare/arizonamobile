package androidx.constraintlayout.motion.utils;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* loaded from: classes2.dex */
public abstract class ViewTimeCycle extends TimeCycleSplineSet {
    private static final String TAG = "ViewTimeCycle";

    public abstract boolean setProperty(View view, float f, long j, KeyCache keyCache);

    public float get(float f, long j, View view, KeyCache keyCache) {
        this.mCurveFit.getPos(f, this.mCache);
        float f2 = this.mCache[1];
        int i = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        if (i == 0) {
            this.mContinue = false;
            return this.mCache[2];
        }
        if (Float.isNaN(this.mLastCycle)) {
            this.mLastCycle = keyCache.getFloatValue(view, this.mType, 0);
            if (Float.isNaN(this.mLastCycle)) {
                this.mLastCycle = 0.0f;
            }
        }
        this.mLastCycle = (float) ((this.mLastCycle + (((j - this.mLastTime) * 1.0E-9d) * f2)) % 1.0d);
        keyCache.setFloatValue(view, this.mType, 0, this.mLastCycle);
        this.mLastTime = j;
        float f3 = this.mCache[0];
        float calcWave = (calcWave(this.mLastCycle) * f3) + this.mCache[2];
        this.mContinue = (f3 == 0.0f && i == 0) ? false : true;
        return calcWave;
    }

    public static ViewTimeCycle makeCustomSpline(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new CustomSet(str, sparseArray);
    }

    public static ViewTimeCycle makeSpline(String str, long j) {
        ViewTimeCycle rotationXset;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    c = 0;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c = 1;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c = 2;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c = 3;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c = 4;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c = 5;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c = 6;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c = 7;
                    break;
                }
                break;
            case -40300674:
                if (str.equals(Key.ROTATION)) {
                    c = '\b';
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c = '\t';
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c = '\n';
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c = 11;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                rotationXset = new RotationXset();
                break;
            case 1:
                rotationXset = new RotationYset();
                break;
            case 2:
                rotationXset = new TranslationXset();
                break;
            case 3:
                rotationXset = new TranslationYset();
                break;
            case 4:
                rotationXset = new TranslationZset();
                break;
            case 5:
                rotationXset = new ProgressSet();
                break;
            case 6:
                rotationXset = new ScaleXset();
                break;
            case 7:
                rotationXset = new ScaleYset();
                break;
            case '\b':
                rotationXset = new RotationSet();
                break;
            case '\t':
                rotationXset = new ElevationSet();
                break;
            case '\n':
                rotationXset = new PathRotate();
                break;
            case 11:
                rotationXset = new AlphaSet();
                break;
            default:
                return null;
        }
        rotationXset.setStartTime(j);
        return rotationXset;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class ElevationSet extends ViewTimeCycle {
        ElevationSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setElevation(get(f, j, view, keyCache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class AlphaSet extends ViewTimeCycle {
        AlphaSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setAlpha(get(f, j, view, keyCache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class RotationSet extends ViewTimeCycle {
        RotationSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setRotation(get(f, j, view, keyCache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class RotationXset extends ViewTimeCycle {
        RotationXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setRotationX(get(f, j, view, keyCache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class RotationYset extends ViewTimeCycle {
        RotationYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setRotationY(get(f, j, view, keyCache));
            return this.mContinue;
        }
    }

    /* loaded from: classes2.dex */
    public static class PathRotate extends ViewTimeCycle {
        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            return this.mContinue;
        }

        public boolean setPathRotate(View view, KeyCache keyCache, float f, long j, double d, double d2) {
            view.setRotation(get(f, j, view, keyCache) + ((float) Math.toDegrees(Math.atan2(d2, d))));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class ScaleXset extends ViewTimeCycle {
        ScaleXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setScaleX(get(f, j, view, keyCache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class ScaleYset extends ViewTimeCycle {
        ScaleYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setScaleY(get(f, j, view, keyCache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class TranslationXset extends ViewTimeCycle {
        TranslationXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setTranslationX(get(f, j, view, keyCache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class TranslationYset extends ViewTimeCycle {
        TranslationYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setTranslationY(get(f, j, view, keyCache));
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class TranslationZset extends ViewTimeCycle {
        TranslationZset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            view.setTranslationZ(get(f, j, view, keyCache));
            return this.mContinue;
        }
    }

    /* loaded from: classes2.dex */
    public static class CustomSet extends ViewTimeCycle {
        String mAttributeName;
        SparseArray<ConstraintAttribute> mConstraintAttributeList;
        float[] mTempValues;
        SparseArray<float[]> mWaveProperties = new SparseArray<>();

        public CustomSet(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.mAttributeName = str.split(StringUtils.COMMA)[1];
            this.mConstraintAttributeList = sparseArray;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setup(int i) {
            float[] fArr;
            int size = this.mConstraintAttributeList.size();
            int numberOfInterpolatedValues = this.mConstraintAttributeList.valueAt(0).numberOfInterpolatedValues();
            double[] dArr = new double[size];
            int i2 = numberOfInterpolatedValues + 2;
            this.mTempValues = new float[i2];
            this.mCache = new float[numberOfInterpolatedValues];
            double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, size, i2);
            for (int i3 = 0; i3 < size; i3++) {
                int keyAt = this.mConstraintAttributeList.keyAt(i3);
                float[] valueAt = this.mWaveProperties.valueAt(i3);
                dArr[i3] = keyAt * 0.01d;
                this.mConstraintAttributeList.valueAt(i3).getValuesToInterpolate(this.mTempValues);
                int i4 = 0;
                while (true) {
                    if (i4 < this.mTempValues.length) {
                        dArr2[i3][i4] = fArr[i4];
                        i4++;
                    }
                }
                double[] dArr3 = dArr2[i3];
                dArr3[numberOfInterpolatedValues] = valueAt[0];
                dArr3[numberOfInterpolatedValues + 1] = valueAt[1];
            }
            this.mCurveFit = CurveFit.get(i, dArr, dArr2);
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void setPoint(int i, float f, float f2, int i2, float f3) {
            throw new RuntimeException("Wrong call for custom attribute");
        }

        public void setPoint(int i, ConstraintAttribute constraintAttribute, float f, int i2, float f2) {
            this.mConstraintAttributeList.append(i, constraintAttribute);
            this.mWaveProperties.append(i, new float[]{f, f2});
            this.mWaveShape = Math.max(this.mWaveShape, i2);
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            this.mCurveFit.getPos(f, this.mTempValues);
            float[] fArr = this.mTempValues;
            float f2 = fArr[fArr.length - 2];
            float f3 = fArr[fArr.length - 1];
            long j2 = j - this.mLastTime;
            if (Float.isNaN(this.mLastCycle)) {
                this.mLastCycle = keyCache.getFloatValue(view, this.mAttributeName, 0);
                if (Float.isNaN(this.mLastCycle)) {
                    this.mLastCycle = 0.0f;
                }
            }
            this.mLastCycle = (float) ((this.mLastCycle + ((j2 * 1.0E-9d) * f2)) % 1.0d);
            this.mLastTime = j;
            float calcWave = calcWave(this.mLastCycle);
            this.mContinue = false;
            for (int i = 0; i < this.mCache.length; i++) {
                this.mContinue |= ((double) this.mTempValues[i]) != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                this.mCache[i] = (this.mTempValues[i] * calcWave) + f3;
            }
            CustomSupport.setInterpolatedValue(this.mConstraintAttributeList.valueAt(0), view, this.mCache);
            if (f2 != 0.0f) {
                this.mContinue = true;
            }
            return this.mContinue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class ProgressSet extends ViewTimeCycle {
        boolean mNoMethod = false;

        ProgressSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean setProperty(View view, float f, long j, KeyCache keyCache) {
            ProgressSet progressSet;
            Method method;
            if (view instanceof MotionLayout) {
                progressSet = this;
                ((MotionLayout) view).setProgress(get(f, j, view, keyCache));
            } else {
                progressSet = this;
                if (progressSet.mNoMethod) {
                    return false;
                }
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    progressSet.mNoMethod = true;
                    method = null;
                }
                if (method != null) {
                    try {
                        method.invoke(view, Float.valueOf(progressSet.get(f, j, view, keyCache)));
                    } catch (IllegalAccessException e) {
                        Log.e(ViewTimeCycle.TAG, "unable to setProgress", e);
                    } catch (InvocationTargetException e2) {
                        Log.e(ViewTimeCycle.TAG, "unable to setProgress", e2);
                    }
                }
            }
            return progressSet.mContinue;
        }
    }
}
