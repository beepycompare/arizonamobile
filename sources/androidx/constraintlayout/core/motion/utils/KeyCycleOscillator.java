package androidx.constraintlayout.core.motion.utils;

import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
/* loaded from: classes2.dex */
public abstract class KeyCycleOscillator {
    private static final String TAG = "KeyCycleOscillator";
    private CurveFit mCurveFit;
    private CycleOscillator mCycleOscillator;
    private String mType;
    private int mWaveShape = 0;
    private String mWaveString = null;
    public int mVariesBy = 0;
    ArrayList<WavePoint> mWavePoints = new ArrayList<>();

    protected void setCustom(Object obj) {
    }

    public void setProperty(MotionWidget motionWidget, float f) {
    }

    public static KeyCycleOscillator makeWidgetCycle(String str) {
        if (str.equals("pathRotate")) {
            return new PathRotateSet(str);
        }
        return new CoreSpline(str);
    }

    /* loaded from: classes2.dex */
    private static class CoreSpline extends KeyCycleOscillator {
        String mType;
        int mTypeId;

        CoreSpline(String str) {
            this.mType = str;
            this.mTypeId = TypedValues.CycleType.getId(str);
        }

        @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
        public void setProperty(MotionWidget motionWidget, float f) {
            motionWidget.setValue(this.mTypeId, get(f));
        }
    }

    /* loaded from: classes2.dex */
    public static class PathRotateSet extends KeyCycleOscillator {
        String mType;
        int mTypeId;

        public PathRotateSet(String str) {
            this.mType = str;
            this.mTypeId = TypedValues.CycleType.getId(str);
        }

        @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
        public void setProperty(MotionWidget motionWidget, float f) {
            motionWidget.setValue(this.mTypeId, get(f));
        }

        public void setPathRotate(MotionWidget motionWidget, float f, double d, double d2) {
            motionWidget.setRotationZ(get(f) + ((float) Math.toDegrees(Math.atan2(d2, d))));
        }
    }

    public boolean variesByPath() {
        return this.mVariesBy == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class WavePoint {
        float mOffset;
        float mPeriod;
        float mPhase;
        int mPosition;
        float mValue;

        WavePoint(int i, float f, float f2, float f3, float f4) {
            this.mPosition = i;
            this.mValue = f4;
            this.mOffset = f2;
            this.mPeriod = f;
            this.mPhase = f3;
        }
    }

    public String toString() {
        String str = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        Iterator<WavePoint> it = this.mWavePoints.iterator();
        while (it.hasNext()) {
            WavePoint next = it.next();
            str = str + "[" + next.mPosition + " , " + decimalFormat.format(next.mValue) + "] ";
        }
        return str;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public float get(float f) {
        return (float) this.mCycleOscillator.getValues(f);
    }

    public float getSlope(float f) {
        return (float) this.mCycleOscillator.getSlope(f);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public void setPoint(int i, int i2, String str, int i3, float f, float f2, float f3, float f4, Object obj) {
        this.mWavePoints.add(new WavePoint(i, f, f2, f3, f4));
        if (i3 != -1) {
            this.mVariesBy = i3;
        }
        this.mWaveShape = i2;
        setCustom(obj);
        this.mWaveString = str;
    }

    public void setPoint(int i, int i2, String str, int i3, float f, float f2, float f3, float f4) {
        this.mWavePoints.add(new WavePoint(i, f, f2, f3, f4));
        if (i3 != -1) {
            this.mVariesBy = i3;
        }
        this.mWaveShape = i2;
        this.mWaveString = str;
    }

    public void setup(float f) {
        int size = this.mWavePoints.size();
        if (size == 0) {
            return;
        }
        Collections.sort(this.mWavePoints, new Comparator<WavePoint>() { // from class: androidx.constraintlayout.core.motion.utils.KeyCycleOscillator.1
            @Override // java.util.Comparator
            public int compare(WavePoint wavePoint, WavePoint wavePoint2) {
                return Integer.compare(wavePoint.mPosition, wavePoint2.mPosition);
            }
        });
        double[] dArr = new double[size];
        double[][] dArr2 = (double[][]) Array.newInstance(Double.TYPE, size, 3);
        this.mCycleOscillator = new CycleOscillator(this.mWaveShape, this.mWaveString, this.mVariesBy, size);
        Iterator<WavePoint> it = this.mWavePoints.iterator();
        int i = 0;
        while (it.hasNext()) {
            WavePoint next = it.next();
            dArr[i] = next.mPeriod * 0.01d;
            dArr2[i][0] = next.mValue;
            dArr2[i][1] = next.mOffset;
            dArr2[i][2] = next.mPhase;
            this.mCycleOscillator.setPoint(i, next.mPosition, next.mPeriod, next.mOffset, next.mPhase, next.mValue);
            i++;
        }
        this.mCycleOscillator.setup(f);
        this.mCurveFit = CurveFit.get(0, dArr, dArr2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class CycleOscillator {
        private static final String TAG = "CycleOscillator";
        static final int UNSET = -1;
        CurveFit mCurveFit;
        float[] mOffsetArr;
        private final int mOffst;
        Oscillator mOscillator;
        float mPathLength;
        float[] mPeriod;
        private final int mPhase;
        float[] mPhaseArr;
        double[] mPosition;
        float[] mScale;
        double[] mSplineSlopeCache;
        double[] mSplineValueCache;
        private final int mValue;
        float[] mValues;
        private final int mVariesBy;
        int mWaveShape;

        CycleOscillator(int i, String str, int i2, int i3) {
            Oscillator oscillator = new Oscillator();
            this.mOscillator = oscillator;
            this.mOffst = 0;
            this.mPhase = 1;
            this.mValue = 2;
            this.mWaveShape = i;
            this.mVariesBy = i2;
            oscillator.setType(i, str);
            this.mValues = new float[i3];
            this.mPosition = new double[i3];
            this.mPeriod = new float[i3];
            this.mOffsetArr = new float[i3];
            this.mPhaseArr = new float[i3];
            this.mScale = new float[i3];
        }

        public double getValues(float f) {
            CurveFit curveFit = this.mCurveFit;
            if (curveFit != null) {
                curveFit.getPos(f, this.mSplineValueCache);
            } else {
                double[] dArr = this.mSplineValueCache;
                dArr[0] = this.mOffsetArr[0];
                dArr[1] = this.mPhaseArr[0];
                dArr[2] = this.mValues[0];
            }
            double[] dArr2 = this.mSplineValueCache;
            double d = dArr2[0];
            Objects.requireNonNull(this);
            return d + (this.mOscillator.getValue(f, dArr2[1]) * this.mSplineValueCache[2]);
        }

        public double getLastPhase() {
            return this.mSplineValueCache[1];
        }

        public double getSlope(float f) {
            CurveFit curveFit = this.mCurveFit;
            if (curveFit != null) {
                double d = f;
                curveFit.getSlope(d, this.mSplineSlopeCache);
                this.mCurveFit.getPos(d, this.mSplineValueCache);
            } else {
                double[] dArr = this.mSplineSlopeCache;
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
                dArr[2] = 0.0d;
            }
            double d2 = f;
            double value = this.mOscillator.getValue(d2, this.mSplineValueCache[1]);
            double slope = this.mOscillator.getSlope(d2, this.mSplineValueCache[1], this.mSplineSlopeCache[1]);
            double[] dArr2 = this.mSplineSlopeCache;
            return dArr2[0] + (value * dArr2[2]) + (slope * this.mSplineValueCache[2]);
        }

        public void setPoint(int i, int i2, float f, float f2, float f3, float f4) {
            this.mPosition[i] = i2 / 100.0d;
            this.mPeriod[i] = f;
            this.mOffsetArr[i] = f2;
            this.mPhaseArr[i] = f3;
            this.mValues[i] = f4;
        }

        public void setup(float f) {
            this.mPathLength = f;
            double[][] dArr = (double[][]) Array.newInstance(Double.TYPE, this.mPosition.length, 3);
            float[] fArr = this.mValues;
            this.mSplineValueCache = new double[fArr.length + 2];
            this.mSplineSlopeCache = new double[fArr.length + 2];
            if (this.mPosition[0] > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                this.mOscillator.addPoint(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, this.mPeriod[0]);
            }
            double[] dArr2 = this.mPosition;
            int length = dArr2.length - 1;
            if (dArr2[length] < 1.0d) {
                this.mOscillator.addPoint(1.0d, this.mPeriod[length]);
            }
            for (int i = 0; i < dArr.length; i++) {
                double[] dArr3 = dArr[i];
                dArr3[0] = this.mOffsetArr[i];
                dArr3[1] = this.mPhaseArr[i];
                dArr3[2] = this.mValues[i];
                this.mOscillator.addPoint(this.mPosition[i], this.mPeriod[i]);
            }
            this.mOscillator.normalize();
            double[] dArr4 = this.mPosition;
            if (dArr4.length > 1) {
                this.mCurveFit = CurveFit.get(0, dArr4, dArr);
            } else {
                this.mCurveFit = null;
            }
        }
    }
}
