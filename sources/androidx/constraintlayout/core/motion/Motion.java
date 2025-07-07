package androidx.constraintlayout.core.motion;

import androidx.constraintlayout.core.motion.key.MotionKey;
import androidx.constraintlayout.core.motion.key.MotionKeyAttributes;
import androidx.constraintlayout.core.motion.key.MotionKeyCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.key.MotionKeyTimeCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyTrigger;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.DifferentialInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.FloatRect;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.core.motion.utils.KeyFrameArray;
import androidx.constraintlayout.core.motion.utils.Rect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.motion.utils.Utils;
import androidx.constraintlayout.core.motion.utils.VelocityMatrix;
import androidx.constraintlayout.core.motion.utils.ViewState;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class Motion implements TypedValues {
    static final int BOUNCE = 4;
    private static final boolean DEBUG = false;
    public static final int DRAW_PATH_AS_CONFIGURED = 4;
    public static final int DRAW_PATH_BASIC = 1;
    public static final int DRAW_PATH_CARTESIAN = 3;
    public static final int DRAW_PATH_NONE = 0;
    public static final int DRAW_PATH_RECTANGLE = 5;
    public static final int DRAW_PATH_RELATIVE = 2;
    public static final int DRAW_PATH_SCREEN = 6;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final boolean FAVOR_FIXED_SIZE_VIEWS = false;
    public static final int HORIZONTAL_PATH_X = 2;
    public static final int HORIZONTAL_PATH_Y = 3;
    private static final int INTERPOLATOR_REFERENCE_ID = -2;
    private static final int INTERPOLATOR_UNDEFINED = -3;
    static final int LINEAR = 3;
    static final int OVERSHOOT = 5;
    public static final int PATH_PERCENT = 0;
    public static final int PATH_PERPENDICULAR = 1;
    public static final int ROTATION_LEFT = 2;
    public static final int ROTATION_RIGHT = 1;
    private static final int SPLINE_STRING = -1;
    private static final String TAG = "MotionController";
    public static final int VERTICAL_PATH_X = 4;
    public static final int VERTICAL_PATH_Y = 5;
    private CurveFit mArcSpline;
    private int[] mAttributeInterpolatorCount;
    private String[] mAttributeNames;
    String[] mAttributeTable;
    private HashMap<String, SplineSet> mAttributesMap;
    String mConstraintTag;
    float mCurrentCenterX;
    float mCurrentCenterY;
    private HashMap<String, KeyCycleOscillator> mCycleMap;
    public String mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private MotionKeyTrigger[] mKeyTriggers;
    Motion mRelativeMotion;
    private CurveFit[] mSpline;
    private HashMap<String, TimeCycleSplineSet> mTimeCycleAttributesMap;
    MotionWidget mView;
    Rect mTempRect = new Rect();
    private int mCurveFitType = 0;
    private MotionPaths mStartMotionPath = new MotionPaths();
    private MotionPaths mEndMotionPath = new MotionPaths();
    private MotionConstrainedPoint mStartPoint = new MotionConstrainedPoint();
    private MotionConstrainedPoint mEndPoint = new MotionConstrainedPoint();
    float mMotionStagger = Float.NaN;
    float mStaggerOffset = 0.0f;
    float mStaggerScale = 1.0f;
    private int mMaxDimension = 4;
    private float[] mValuesBuff = new float[4];
    private ArrayList<MotionPaths> mMotionPaths = new ArrayList<>();
    private float[] mVelocity = new float[1];
    private ArrayList<MotionKey> mKeyList = new ArrayList<>();
    private int mPathMotionArc = -1;
    private int mTransformPivotTarget = -1;
    private MotionWidget mTransformPivotView = null;
    private int mQuantizeMotionSteps = -1;
    private float mQuantizeMotionPhase = Float.NaN;
    private DifferentialInterpolator mQuantizeMotionInterpolator = null;
    private boolean mNoMovement = false;

    void endTrigger(boolean z) {
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String str) {
        return 0;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, boolean z) {
        return false;
    }

    public int getTransformPivotTarget() {
        return this.mTransformPivotTarget;
    }

    public void setTransformPivotTarget(int i) {
        this.mTransformPivotTarget = i;
        this.mTransformPivotView = null;
    }

    public MotionPaths getKeyFrame(int i) {
        return this.mMotionPaths.get(i);
    }

    public Motion(MotionWidget motionWidget) {
        setView(motionWidget);
    }

    public float getStartX() {
        return this.mStartMotionPath.mX;
    }

    public float getStartY() {
        return this.mStartMotionPath.mY;
    }

    public float getFinalX() {
        return this.mEndMotionPath.mX;
    }

    public float getFinalY() {
        return this.mEndMotionPath.mY;
    }

    public float getStartWidth() {
        return this.mStartMotionPath.mWidth;
    }

    public float getStartHeight() {
        return this.mStartMotionPath.mHeight;
    }

    public float getFinalWidth() {
        return this.mEndMotionPath.mWidth;
    }

    public float getFinalHeight() {
        return this.mEndMotionPath.mHeight;
    }

    public String getAnimateRelativeTo() {
        return this.mStartMotionPath.mAnimateRelativeTo;
    }

    public void setupRelative(Motion motion) {
        this.mRelativeMotion = motion;
    }

    private void setupRelative() {
        Motion motion = this.mRelativeMotion;
        if (motion == null) {
            return;
        }
        this.mStartMotionPath.setupRelative(motion, motion.mStartMotionPath);
        MotionPaths motionPaths = this.mEndMotionPath;
        Motion motion2 = this.mRelativeMotion;
        motionPaths.setupRelative(motion2, motion2.mEndMotionPath);
    }

    public float getCenterX() {
        return this.mCurrentCenterX;
    }

    public float getCenterY() {
        return this.mCurrentCenterY;
    }

    public void getCenter(double d, float[] fArr, float[] fArr2) {
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.mSpline[0].getPos(d, dArr);
        this.mSpline[0].getSlope(d, dArr2);
        Arrays.fill(fArr2, 0.0f);
        this.mStartMotionPath.getCenter(d, this.mInterpolateVariables, dArr, fArr, dArr2, fArr2);
    }

    public void buildPath(float[] fArr, int i) {
        float f;
        float f2 = 1.0f;
        float f3 = 1.0f / (i - 1);
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        SplineSet splineSet = hashMap == null ? null : hashMap.get("translationX");
        HashMap<String, SplineSet> hashMap2 = this.mAttributesMap;
        SplineSet splineSet2 = hashMap2 == null ? null : hashMap2.get("translationY");
        HashMap<String, KeyCycleOscillator> hashMap3 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator = hashMap3 == null ? null : hashMap3.get("translationX");
        HashMap<String, KeyCycleOscillator> hashMap4 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator2 = hashMap4 != null ? hashMap4.get("translationY") : null;
        int i2 = 0;
        while (i2 < i) {
            float f4 = i2 * f3;
            float f5 = this.mStaggerScale;
            float f6 = 0.0f;
            if (f5 != f2) {
                float f7 = this.mStaggerOffset;
                if (f4 < f7) {
                    f4 = 0.0f;
                }
                if (f4 > f7 && f4 < 1.0d) {
                    f4 = Math.min((f4 - f7) * f5, f2);
                }
            }
            double d = f4;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            float f8 = Float.NaN;
            while (it.hasNext()) {
                MotionPaths next = it.next();
                if (next.mKeyFrameEasing != null) {
                    if (next.mTime < f4) {
                        Easing easing2 = next.mKeyFrameEasing;
                        f6 = next.mTime;
                        easing = easing2;
                    } else if (Float.isNaN(f8)) {
                        f8 = next.mTime;
                    }
                }
            }
            if (easing != null) {
                if (Float.isNaN(f8)) {
                    f8 = 1.0f;
                }
                d = (((float) easing.get((f4 - f6) / f)) * (f8 - f6)) + f6;
            }
            this.mSpline[0].getPos(d, this.mInterpolateData);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d, dArr);
                }
            }
            int i3 = i2 * 2;
            this.mStartMotionPath.getCenter(d, this.mInterpolateVariables, this.mInterpolateData, fArr, i3);
            if (keyCycleOscillator != null) {
                fArr[i3] = fArr[i3] + keyCycleOscillator.get(f4);
            } else if (splineSet != null) {
                fArr[i3] = fArr[i3] + splineSet.get(f4);
            }
            if (keyCycleOscillator2 != null) {
                int i4 = i3 + 1;
                fArr[i4] = fArr[i4] + keyCycleOscillator2.get(f4);
            } else if (splineSet2 != null) {
                int i5 = i3 + 1;
                fArr[i5] = fArr[i5] + splineSet2.get(f4);
            }
            i2++;
            f2 = 1.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double[] getPos(double d) {
        this.mSpline[0].getPos(d, this.mInterpolateData);
        CurveFit curveFit = this.mArcSpline;
        if (curveFit != null) {
            double[] dArr = this.mInterpolateData;
            if (dArr.length > 0) {
                curveFit.getPos(d, dArr);
            }
        }
        return this.mInterpolateData;
    }

    void buildBounds(float[] fArr, int i) {
        float f;
        float f2 = 1.0f / (i - 1);
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        if (hashMap != null) {
            hashMap.get("translationX");
        }
        HashMap<String, SplineSet> hashMap2 = this.mAttributesMap;
        if (hashMap2 != null) {
            hashMap2.get("translationY");
        }
        HashMap<String, KeyCycleOscillator> hashMap3 = this.mCycleMap;
        if (hashMap3 != null) {
            hashMap3.get("translationX");
        }
        HashMap<String, KeyCycleOscillator> hashMap4 = this.mCycleMap;
        if (hashMap4 != null) {
            hashMap4.get("translationY");
        }
        for (int i2 = 0; i2 < i; i2++) {
            float f3 = i2 * f2;
            float f4 = this.mStaggerScale;
            float f5 = 0.0f;
            if (f4 != 1.0f) {
                float f6 = this.mStaggerOffset;
                if (f3 < f6) {
                    f3 = 0.0f;
                }
                if (f3 > f6 && f3 < 1.0d) {
                    f3 = Math.min((f3 - f6) * f4, 1.0f);
                }
            }
            double d = f3;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            float f7 = Float.NaN;
            while (it.hasNext()) {
                MotionPaths next = it.next();
                if (next.mKeyFrameEasing != null) {
                    if (next.mTime < f3) {
                        easing = next.mKeyFrameEasing;
                        f5 = next.mTime;
                    } else if (Float.isNaN(f7)) {
                        f7 = next.mTime;
                    }
                }
            }
            if (easing != null) {
                if (Float.isNaN(f7)) {
                    f7 = 1.0f;
                }
                d = (((float) easing.get((f3 - f5) / f)) * (f7 - f5)) + f5;
            }
            this.mSpline[0].getPos(d, this.mInterpolateData);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d, dArr);
                }
            }
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i2 * 2);
        }
    }

    private float getPreCycleDistance() {
        float f;
        float[] fArr = new float[2];
        float f2 = 1.0f / 99;
        double d = 0.0d;
        double d2 = 0.0d;
        int i = 0;
        float f3 = 0.0f;
        while (i < 100) {
            float f4 = i * f2;
            double d3 = f4;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            Iterator<MotionPaths> it = this.mMotionPaths.iterator();
            float f5 = Float.NaN;
            float f6 = 0.0f;
            while (it.hasNext()) {
                MotionPaths next = it.next();
                if (next.mKeyFrameEasing != null) {
                    if (next.mTime < f4) {
                        easing = next.mKeyFrameEasing;
                        f6 = next.mTime;
                    } else if (Float.isNaN(f5)) {
                        f5 = next.mTime;
                    }
                }
            }
            if (easing != null) {
                if (Float.isNaN(f5)) {
                    f5 = 1.0f;
                }
                d3 = (((float) easing.get((f4 - f6) / f)) * (f5 - f6)) + f6;
            }
            double d4 = d3;
            this.mSpline[0].getPos(d4, this.mInterpolateData);
            int i2 = i;
            this.mStartMotionPath.getCenter(d4, this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
            if (i2 > 0) {
                f3 += (float) Math.hypot(d2 - fArr[1], d - fArr[0]);
            }
            d = fArr[0];
            d2 = fArr[1];
            i = i2 + 1;
        }
        return f3;
    }

    MotionKeyPosition getPositionKeyframe(int i, int i2, float f, float f2) {
        int i3;
        int i4;
        float f3;
        float f4;
        FloatRect floatRect = new FloatRect();
        floatRect.left = this.mStartMotionPath.mX;
        floatRect.top = this.mStartMotionPath.mY;
        floatRect.right = floatRect.left + this.mStartMotionPath.mWidth;
        floatRect.bottom = floatRect.top + this.mStartMotionPath.mHeight;
        FloatRect floatRect2 = new FloatRect();
        floatRect2.left = this.mEndMotionPath.mX;
        floatRect2.top = this.mEndMotionPath.mY;
        floatRect2.right = floatRect2.left + this.mEndMotionPath.mWidth;
        floatRect2.bottom = floatRect2.top + this.mEndMotionPath.mHeight;
        Iterator<MotionKey> it = this.mKeyList.iterator();
        while (it.hasNext()) {
            MotionKey next = it.next();
            if (next instanceof MotionKeyPosition) {
                MotionKeyPosition motionKeyPosition = (MotionKeyPosition) next;
                i3 = i;
                i4 = i2;
                f3 = f;
                f4 = f2;
                if (motionKeyPosition.intersects(i3, i4, floatRect, floatRect2, f3, f4)) {
                    return motionKeyPosition;
                }
            } else {
                i3 = i;
                i4 = i2;
                f3 = f;
                f4 = f2;
            }
            i = i3;
            i2 = i4;
            f = f3;
            f2 = f4;
        }
        return null;
    }

    public int buildKeyFrames(float[] fArr, int[] iArr, int[] iArr2) {
        if (fArr != null) {
            double[] timePoints = this.mSpline[0].getTimePoints();
            if (iArr != null) {
                Iterator<MotionPaths> it = this.mMotionPaths.iterator();
                int i = 0;
                while (it.hasNext()) {
                    iArr[i] = it.next().mMode;
                    i++;
                }
            }
            if (iArr2 != null) {
                Iterator<MotionPaths> it2 = this.mMotionPaths.iterator();
                int i2 = 0;
                while (it2.hasNext()) {
                    iArr2[i2] = (int) (it2.next().mPosition * 100.0f);
                    i2++;
                }
            }
            int i3 = 0;
            for (int i4 = 0; i4 < timePoints.length; i4++) {
                this.mSpline[0].getPos(timePoints[i4], this.mInterpolateData);
                this.mStartMotionPath.getCenter(timePoints[i4], this.mInterpolateVariables, this.mInterpolateData, fArr, i3);
                i3 += 2;
            }
            return i3 / 2;
        }
        return 0;
    }

    int buildKeyBounds(float[] fArr, int[] iArr) {
        if (fArr != null) {
            double[] timePoints = this.mSpline[0].getTimePoints();
            if (iArr != null) {
                Iterator<MotionPaths> it = this.mMotionPaths.iterator();
                int i = 0;
                while (it.hasNext()) {
                    iArr[i] = it.next().mMode;
                    i++;
                }
            }
            int i2 = 0;
            for (double d : timePoints) {
                this.mSpline[0].getPos(d, this.mInterpolateData);
                this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArr, i2);
                i2 += 2;
            }
            return i2 / 2;
        }
        return 0;
    }

    int getAttributeValues(String str, float[] fArr, int i) {
        SplineSet splineSet = this.mAttributesMap.get(str);
        if (splineSet == null) {
            return -1;
        }
        for (int i2 = 0; i2 < fArr.length; i2++) {
            fArr[i2] = splineSet.get(i2 / (fArr.length - 1));
        }
        return fArr.length;
    }

    public void buildRect(float f, float[] fArr, int i) {
        this.mSpline[0].getPos(getAdjustedPosition(f, null), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i);
    }

    void buildRectangles(float[] fArr, int i) {
        float f = 1.0f / (i - 1);
        for (int i2 = 0; i2 < i; i2++) {
            this.mSpline[0].getPos(getAdjustedPosition(i2 * f, null), this.mInterpolateData);
            this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArr, i2 * 8);
        }
    }

    float getKeyFrameParameter(int i, float f, float f2) {
        float f3 = this.mEndMotionPath.mX - this.mStartMotionPath.mX;
        float f4 = this.mEndMotionPath.mY - this.mStartMotionPath.mY;
        float f5 = this.mStartMotionPath.mX + (this.mStartMotionPath.mWidth / 2.0f);
        float f6 = this.mStartMotionPath.mY + (this.mStartMotionPath.mHeight / 2.0f);
        float hypot = (float) Math.hypot(f3, f4);
        if (hypot < 1.0E-7d) {
            return Float.NaN;
        }
        float f7 = f - f5;
        float f8 = f2 - f6;
        if (((float) Math.hypot(f7, f8)) == 0.0f) {
            return 0.0f;
        }
        float f9 = (f7 * f3) + (f8 * f4);
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return 0.0f;
                            }
                            return f8 / f4;
                        }
                        return f7 / f4;
                    }
                    return f8 / f3;
                }
                return f7 / f3;
            }
            return (float) Math.sqrt((hypot * hypot) - (f9 * f9));
        }
        return f9 / hypot;
    }

    private void insertKey(MotionPaths motionPaths) {
        Iterator<MotionPaths> it = this.mMotionPaths.iterator();
        MotionPaths motionPaths2 = null;
        while (it.hasNext()) {
            MotionPaths next = it.next();
            if (motionPaths.mPosition == next.mPosition) {
                motionPaths2 = next;
            }
        }
        if (motionPaths2 != null) {
            this.mMotionPaths.remove(motionPaths2);
        }
        int binarySearch = Collections.binarySearch(this.mMotionPaths, motionPaths);
        if (binarySearch == 0) {
            Utils.loge(TAG, " KeyPath position \"" + motionPaths.mPosition + "\" outside of range");
        }
        this.mMotionPaths.add((-binarySearch) - 1, motionPaths);
    }

    void addKeys(ArrayList<MotionKey> arrayList) {
        this.mKeyList.addAll(arrayList);
    }

    public void addKey(MotionKey motionKey) {
        this.mKeyList.add(motionKey);
    }

    public void setPathMotionArc(int i) {
        this.mPathMotionArc = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setup(int i, int i2, float f, long j) {
        ArrayList arrayList;
        int i3;
        CustomVariable customVariable;
        SplineSet makeSpline;
        CustomVariable customVariable2;
        Integer num;
        int i4;
        SplineSet makeSpline2;
        CustomVariable customVariable3;
        new HashSet();
        HashSet<String> hashSet = new HashSet<>();
        HashSet<String> hashSet2 = new HashSet<>();
        HashSet<String> hashSet3 = new HashSet<>();
        HashMap<String, Integer> hashMap = new HashMap<>();
        setupRelative();
        if (this.mPathMotionArc != -1 && this.mStartMotionPath.mPathMotionArc == -1) {
            this.mStartMotionPath.mPathMotionArc = this.mPathMotionArc;
        }
        this.mStartPoint.different(this.mEndPoint, hashSet2);
        ArrayList<MotionKey> arrayList2 = this.mKeyList;
        if (arrayList2 != null) {
            Iterator<MotionKey> it = arrayList2.iterator();
            arrayList = null;
            while (it.hasNext()) {
                MotionKey next = it.next();
                if (next instanceof MotionKeyPosition) {
                    MotionKeyPosition motionKeyPosition = (MotionKeyPosition) next;
                    insertKey(new MotionPaths(i, i2, motionKeyPosition, this.mStartMotionPath, this.mEndMotionPath));
                    if (motionKeyPosition.mCurveFit != -1) {
                        this.mCurveFitType = motionKeyPosition.mCurveFit;
                    }
                } else if (next instanceof MotionKeyCycle) {
                    next.getAttributeNames(hashSet3);
                } else if (next instanceof MotionKeyTimeCycle) {
                    next.getAttributeNames(hashSet);
                } else if (next instanceof MotionKeyTrigger) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add((MotionKeyTrigger) next);
                } else {
                    next.setInterpolation(hashMap);
                    next.getAttributeNames(hashSet2);
                }
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            this.mKeyTriggers = (MotionKeyTrigger[]) arrayList.toArray(new MotionKeyTrigger[0]);
        }
        int i5 = 1;
        if (hashSet2.isEmpty()) {
            i3 = 1;
        } else {
            this.mAttributesMap = new HashMap<>();
            Iterator<String> it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                String next2 = it2.next();
                if (next2.startsWith("CUSTOM,")) {
                    KeyFrameArray.CustomVar customVar = new KeyFrameArray.CustomVar();
                    String str = next2.split(StringUtils.COMMA)[i5];
                    i4 = i5;
                    Iterator<MotionKey> it3 = this.mKeyList.iterator();
                    while (it3.hasNext()) {
                        MotionKey next3 = it3.next();
                        if (next3.mCustom != null && (customVariable3 = next3.mCustom.get(str)) != null) {
                            customVar.append(next3.mFramePosition, customVariable3);
                        }
                    }
                    makeSpline2 = SplineSet.makeCustomSplineSet(next2, customVar);
                } else {
                    i4 = i5;
                    makeSpline2 = SplineSet.makeSpline(next2, j);
                }
                if (makeSpline2 != null) {
                    makeSpline2.setType(next2);
                    this.mAttributesMap.put(next2, makeSpline2);
                }
                i5 = i4;
            }
            i3 = i5;
            ArrayList<MotionKey> arrayList3 = this.mKeyList;
            if (arrayList3 != null) {
                Iterator<MotionKey> it4 = arrayList3.iterator();
                while (it4.hasNext()) {
                    MotionKey next4 = it4.next();
                    if (next4 instanceof MotionKeyAttributes) {
                        next4.addValues(this.mAttributesMap);
                    }
                }
            }
            this.mStartPoint.addValues(this.mAttributesMap, 0);
            this.mEndPoint.addValues(this.mAttributesMap, 100);
            for (String str2 : this.mAttributesMap.keySet()) {
                int intValue = (!hashMap.containsKey(str2) || (num = hashMap.get(str2)) == null) ? 0 : num.intValue();
                SplineSet splineSet = this.mAttributesMap.get(str2);
                if (splineSet != null) {
                    splineSet.setup(intValue);
                }
            }
        }
        if (!hashSet.isEmpty()) {
            if (this.mTimeCycleAttributesMap == null) {
                this.mTimeCycleAttributesMap = new HashMap<>();
            }
            Iterator<String> it5 = hashSet.iterator();
            while (it5.hasNext()) {
                String next5 = it5.next();
                if (!this.mTimeCycleAttributesMap.containsKey(next5)) {
                    if (next5.startsWith("CUSTOM,")) {
                        KeyFrameArray.CustomVar customVar2 = new KeyFrameArray.CustomVar();
                        String str3 = next5.split(StringUtils.COMMA)[i3];
                        Iterator<MotionKey> it6 = this.mKeyList.iterator();
                        while (it6.hasNext()) {
                            MotionKey next6 = it6.next();
                            if (next6.mCustom != null && (customVariable2 = next6.mCustom.get(str3)) != null) {
                                customVar2.append(next6.mFramePosition, customVariable2);
                            }
                        }
                        makeSpline = SplineSet.makeCustomSplineSet(next5, customVar2);
                    } else {
                        makeSpline = SplineSet.makeSpline(next5, j);
                    }
                    if (makeSpline != null) {
                        makeSpline.setType(next5);
                    }
                }
            }
            ArrayList<MotionKey> arrayList4 = this.mKeyList;
            if (arrayList4 != null) {
                Iterator<MotionKey> it7 = arrayList4.iterator();
                while (it7.hasNext()) {
                    MotionKey next7 = it7.next();
                    if (next7 instanceof MotionKeyTimeCycle) {
                        ((MotionKeyTimeCycle) next7).addTimeValues(this.mTimeCycleAttributesMap);
                    }
                }
            }
            for (String str4 : this.mTimeCycleAttributesMap.keySet()) {
                this.mTimeCycleAttributesMap.get(str4).setup(hashMap.containsKey(str4) ? hashMap.get(str4).intValue() : 0);
            }
        }
        int size = this.mMotionPaths.size();
        int i6 = size + 2;
        MotionPaths[] motionPathsArr = new MotionPaths[i6];
        motionPathsArr[0] = this.mStartMotionPath;
        motionPathsArr[size + 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0 && this.mCurveFitType == MotionKey.UNSET) {
            this.mCurveFitType = 0;
        }
        Iterator<MotionPaths> it8 = this.mMotionPaths.iterator();
        int i7 = i3;
        while (it8.hasNext()) {
            motionPathsArr[i7] = it8.next();
            i7++;
        }
        HashSet hashSet4 = new HashSet();
        for (String str5 : this.mEndMotionPath.mCustomAttributes.keySet()) {
            if (this.mStartMotionPath.mCustomAttributes.containsKey(str5) && !hashSet2.contains("CUSTOM," + str5)) {
                hashSet4.add(str5);
            }
        }
        String[] strArr = (String[]) hashSet4.toArray(new String[0]);
        this.mAttributeNames = strArr;
        this.mAttributeInterpolatorCount = new int[strArr.length];
        int i8 = 0;
        while (true) {
            String[] strArr2 = this.mAttributeNames;
            if (i8 >= strArr2.length) {
                break;
            }
            String str6 = strArr2[i8];
            this.mAttributeInterpolatorCount[i8] = 0;
            int i9 = 0;
            while (true) {
                if (i9 >= i6) {
                    break;
                }
                if (motionPathsArr[i9].mCustomAttributes.containsKey(str6) && (customVariable = motionPathsArr[i9].mCustomAttributes.get(str6)) != null) {
                    int[] iArr = this.mAttributeInterpolatorCount;
                    iArr[i8] = iArr[i8] + customVariable.numberOfInterpolatedValues();
                    break;
                }
                i9++;
            }
            i8++;
        }
        boolean z = motionPathsArr[0].mPathMotionArc != -1 ? i3 : false;
        int length = 18 + this.mAttributeNames.length;
        boolean[] zArr = new boolean[length];
        for (int i10 = i3; i10 < i6; i10++) {
            motionPathsArr[i10].different(motionPathsArr[i10 - 1], zArr, this.mAttributeNames, z);
        }
        int i11 = 0;
        for (int i12 = i3; i12 < length; i12++) {
            if (zArr[i12]) {
                i11++;
            }
        }
        this.mInterpolateVariables = new int[i11];
        int max = Math.max(2, i11);
        this.mInterpolateData = new double[max];
        this.mInterpolateVelocity = new double[max];
        int i13 = 0;
        for (int i14 = i3; i14 < length; i14++) {
            if (zArr[i14]) {
                this.mInterpolateVariables[i13] = i14;
                i13++;
            }
        }
        int[] iArr2 = new int[2];
        iArr2[i3] = this.mInterpolateVariables.length;
        iArr2[0] = i6;
        double[][] dArr = (double[][]) Array.newInstance(Double.TYPE, iArr2);
        double[] dArr2 = new double[i6];
        for (int i15 = 0; i15 < i6; i15++) {
            motionPathsArr[i15].fillStandard(dArr[i15], this.mInterpolateVariables);
            dArr2[i15] = motionPathsArr[i15].mTime;
        }
        int i16 = 0;
        while (true) {
            int[] iArr3 = this.mInterpolateVariables;
            if (i16 >= iArr3.length) {
                break;
            }
            if (iArr3[i16] < MotionPaths.sNames.length) {
                String str7 = MotionPaths.sNames[this.mInterpolateVariables[i16]] + " [";
                for (int i17 = 0; i17 < i6; i17++) {
                    str7 = str7 + dArr[i17][i16];
                }
            }
            i16++;
        }
        this.mSpline = new CurveFit[this.mAttributeNames.length + 1];
        int i18 = 0;
        while (true) {
            String[] strArr3 = this.mAttributeNames;
            if (i18 >= strArr3.length) {
                break;
            }
            String str8 = strArr3[i18];
            int i19 = 0;
            double[] dArr3 = null;
            double[][] dArr4 = null;
            for (int i20 = 0; i20 < i6; i20++) {
                if (motionPathsArr[i20].hasCustomData(str8)) {
                    if (dArr4 == null) {
                        dArr3 = new double[i6];
                        int[] iArr4 = new int[2];
                        iArr4[i3] = motionPathsArr[i20].getCustomDataCount(str8);
                        iArr4[0] = i6;
                        dArr4 = (double[][]) Array.newInstance(Double.TYPE, iArr4);
                    }
                    dArr3[i19] = motionPathsArr[i20].mTime;
                    motionPathsArr[i20].getCustomData(str8, dArr4[i19], 0);
                    i19++;
                }
            }
            i18++;
            this.mSpline[i18] = CurveFit.get(this.mCurveFitType, Arrays.copyOf(dArr3, i19), (double[][]) Arrays.copyOf(dArr4, i19));
        }
        this.mSpline[0] = CurveFit.get(this.mCurveFitType, dArr2, dArr);
        if (motionPathsArr[0].mPathMotionArc != -1) {
            int[] iArr5 = new int[i6];
            double[] dArr5 = new double[i6];
            int[] iArr6 = new int[2];
            iArr6[i3] = 2;
            iArr6[0] = i6;
            double[][] dArr6 = (double[][]) Array.newInstance(Double.TYPE, iArr6);
            for (int i21 = 0; i21 < i6; i21++) {
                iArr5[i21] = motionPathsArr[i21].mPathMotionArc;
                dArr5[i21] = motionPathsArr[i21].mTime;
                dArr6[i21][0] = motionPathsArr[i21].mX;
                dArr6[i21][i3] = motionPathsArr[i21].mY;
            }
            this.mArcSpline = CurveFit.getArc(iArr5, dArr5, dArr6);
        }
        this.mCycleMap = new HashMap<>();
        if (this.mKeyList != null) {
            Iterator<String> it9 = hashSet3.iterator();
            float f2 = Float.NaN;
            while (it9.hasNext()) {
                String next8 = it9.next();
                KeyCycleOscillator makeWidgetCycle = KeyCycleOscillator.makeWidgetCycle(next8);
                if (makeWidgetCycle != null) {
                    if (makeWidgetCycle.variesByPath() && Float.isNaN(f2)) {
                        f2 = getPreCycleDistance();
                    }
                    makeWidgetCycle.setType(next8);
                    this.mCycleMap.put(next8, makeWidgetCycle);
                }
            }
            Iterator<MotionKey> it10 = this.mKeyList.iterator();
            while (it10.hasNext()) {
                MotionKey next9 = it10.next();
                if (next9 instanceof MotionKeyCycle) {
                    ((MotionKeyCycle) next9).addCycleValues(this.mCycleMap);
                }
            }
            for (KeyCycleOscillator keyCycleOscillator : this.mCycleMap.values()) {
                keyCycleOscillator.setup(f2);
            }
        }
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.mX + " y: " + this.mStartMotionPath.mY + " end: x: " + this.mEndMotionPath.mX + " y: " + this.mEndMotionPath.mY;
    }

    private void readView(MotionPaths motionPaths) {
        motionPaths.setBounds(this.mView.getX(), this.mView.getY(), this.mView.getWidth(), this.mView.getHeight());
    }

    public void setView(MotionWidget motionWidget) {
        this.mView = motionWidget;
    }

    public MotionWidget getView() {
        return this.mView;
    }

    public void setStart(MotionWidget motionWidget) {
        this.mStartMotionPath.mTime = 0.0f;
        this.mStartMotionPath.mPosition = 0.0f;
        this.mStartMotionPath.setBounds(motionWidget.getX(), motionWidget.getY(), motionWidget.getWidth(), motionWidget.getHeight());
        this.mStartMotionPath.applyParameters(motionWidget);
        this.mStartPoint.setState(motionWidget);
        TypedBundle motionProperties = motionWidget.getWidgetFrame().getMotionProperties();
        if (motionProperties != null) {
            motionProperties.applyDelta(this);
        }
    }

    public void setEnd(MotionWidget motionWidget) {
        this.mEndMotionPath.mTime = 1.0f;
        this.mEndMotionPath.mPosition = 1.0f;
        readView(this.mEndMotionPath);
        this.mEndMotionPath.setBounds(motionWidget.getLeft(), motionWidget.getTop(), motionWidget.getWidth(), motionWidget.getHeight());
        this.mEndMotionPath.applyParameters(motionWidget);
        this.mEndPoint.setState(motionWidget);
    }

    public void setStartState(ViewState viewState, MotionWidget motionWidget, int i, int i2, int i3) {
        this.mStartMotionPath.mTime = 0.0f;
        this.mStartMotionPath.mPosition = 0.0f;
        Rect rect = new Rect();
        if (i == 1) {
            int i4 = viewState.left + viewState.right;
            rect.left = ((viewState.top + viewState.bottom) - viewState.width()) / 2;
            rect.top = i2 - ((i4 + viewState.height()) / 2);
            rect.right = rect.left + viewState.width();
            rect.bottom = rect.top + viewState.height();
        } else if (i == 2) {
            int i5 = viewState.left + viewState.right;
            rect.left = i3 - (((viewState.top + viewState.bottom) + viewState.width()) / 2);
            rect.top = (i5 - viewState.height()) / 2;
            rect.right = rect.left + viewState.width();
            rect.bottom = rect.top + viewState.height();
        }
        this.mStartMotionPath.setBounds(rect.left, rect.top, rect.width(), rect.height());
        this.mStartPoint.setState(rect, motionWidget, i, viewState.rotation);
    }

    void rotate(Rect rect, Rect rect2, int i, int i2, int i3) {
        if (i == 1) {
            int i4 = rect.left + rect.right;
            rect2.left = ((rect.top + rect.bottom) - rect.width()) / 2;
            rect2.top = i3 - ((i4 + rect.height()) / 2);
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        } else if (i == 2) {
            int i5 = rect.left + rect.right;
            rect2.left = i2 - (((rect.top + rect.bottom) + rect.width()) / 2);
            rect2.top = (i5 - rect.height()) / 2;
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        } else if (i != 3) {
            if (i != 4) {
                return;
            }
            int i6 = rect.left + rect.right;
            rect2.left = i2 - (((rect.bottom + rect.top) + rect.width()) / 2);
            rect2.top = (i6 - rect.height()) / 2;
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        } else {
            int i7 = rect.left + rect.right;
            int i8 = rect.top;
            int i9 = rect.bottom;
            rect2.left = ((rect.height() / 2) + rect.top) - (i7 / 2);
            rect2.top = i3 - ((i7 + rect.height()) / 2);
            rect2.right = rect2.left + rect.width();
            rect2.bottom = rect2.top + rect.height();
        }
    }

    private static DifferentialInterpolator getInterpolator(int i, String str, int i2) {
        if (i != -1) {
            return null;
        }
        final Easing interpolator = Easing.getInterpolator(str);
        return new DifferentialInterpolator() { // from class: androidx.constraintlayout.core.motion.Motion.1
            float mX;

            @Override // androidx.constraintlayout.core.motion.utils.DifferentialInterpolator
            public float getInterpolation(float f) {
                this.mX = f;
                return (float) Easing.this.get(f);
            }

            @Override // androidx.constraintlayout.core.motion.utils.DifferentialInterpolator
            public float getVelocity() {
                return (float) Easing.this.getDiff(this.mX);
            }
        };
    }

    void setBothStates(MotionWidget motionWidget) {
        this.mStartMotionPath.mTime = 0.0f;
        this.mStartMotionPath.mPosition = 0.0f;
        this.mNoMovement = true;
        this.mStartMotionPath.setBounds(motionWidget.getX(), motionWidget.getY(), motionWidget.getWidth(), motionWidget.getHeight());
        this.mEndMotionPath.setBounds(motionWidget.getX(), motionWidget.getY(), motionWidget.getWidth(), motionWidget.getHeight());
        this.mStartPoint.setState(motionWidget);
        this.mEndPoint.setState(motionWidget);
    }

    private float getAdjustedPosition(float f, float[] fArr) {
        float f2 = 0.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f3 = this.mStaggerScale;
            if (f3 != 1.0d) {
                float f4 = this.mStaggerOffset;
                if (f < f4) {
                    f = 0.0f;
                }
                if (f > f4 && f < 1.0d) {
                    f = Math.min((f - f4) * f3, 1.0f);
                }
            }
        }
        Easing easing = this.mStartMotionPath.mKeyFrameEasing;
        Iterator<MotionPaths> it = this.mMotionPaths.iterator();
        float f5 = Float.NaN;
        while (it.hasNext()) {
            MotionPaths next = it.next();
            if (next.mKeyFrameEasing != null) {
                if (next.mTime < f) {
                    easing = next.mKeyFrameEasing;
                    f2 = next.mTime;
                } else if (Float.isNaN(f5)) {
                    f5 = next.mTime;
                }
            }
        }
        if (easing != null) {
            float f6 = (Float.isNaN(f5) ? 1.0f : f5) - f2;
            double d = (f - f2) / f6;
            f = (((float) easing.get(d)) * f6) + f2;
            if (fArr != null) {
                fArr[0] = (float) easing.getDiff(d);
            }
        }
        return f;
    }

    public boolean interpolate(MotionWidget motionWidget, float f, long j, KeyCache keyCache) {
        MotionWidget motionWidget2;
        float f2;
        MotionWidget motionWidget3 = motionWidget;
        float adjustedPosition = getAdjustedPosition(f, null);
        int i = this.mQuantizeMotionSteps;
        if (i != -1) {
            float f3 = 1.0f / i;
            float floor = ((float) Math.floor(adjustedPosition / f3)) * f3;
            float f4 = (adjustedPosition % f3) / f3;
            if (!Float.isNaN(this.mQuantizeMotionPhase)) {
                f4 = (f4 + this.mQuantizeMotionPhase) % 1.0f;
            }
            DifferentialInterpolator differentialInterpolator = this.mQuantizeMotionInterpolator;
            if (differentialInterpolator != null) {
                f2 = differentialInterpolator.getInterpolation(f4);
            } else {
                f2 = ((double) f4) > 0.5d ? 1.0f : 0.0f;
            }
            adjustedPosition = (f2 * f3) + floor;
        }
        float f5 = adjustedPosition;
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        if (hashMap != null) {
            for (SplineSet splineSet : hashMap.values()) {
                splineSet.setProperty(motionWidget3, f5);
            }
        }
        CurveFit[] curveFitArr = this.mSpline;
        if (curveFitArr != null) {
            double d = f5;
            curveFitArr[0].getPos(d, this.mInterpolateData);
            this.mSpline[0].getSlope(d, this.mInterpolateVelocity);
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr = this.mInterpolateData;
                if (dArr.length > 0) {
                    curveFit.getPos(d, dArr);
                    this.mArcSpline.getSlope(d, this.mInterpolateVelocity);
                }
            }
            if (!this.mNoMovement) {
                this.mStartMotionPath.setView(f5, motionWidget3, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, null);
                f5 = f5;
                motionWidget3 = motionWidget3;
            }
            if (this.mTransformPivotTarget != -1) {
                if (this.mTransformPivotView == null) {
                    this.mTransformPivotView = motionWidget3.getParent().findViewById(this.mTransformPivotTarget);
                }
                if (this.mTransformPivotView != null) {
                    float top = (motionWidget2.getTop() + this.mTransformPivotView.getBottom()) / 2.0f;
                    float left = (this.mTransformPivotView.getLeft() + this.mTransformPivotView.getRight()) / 2.0f;
                    if (motionWidget3.getRight() - motionWidget3.getLeft() > 0 && motionWidget3.getBottom() - motionWidget3.getTop() > 0) {
                        motionWidget3.setPivotX(left - motionWidget3.getLeft());
                        motionWidget3.setPivotY(top - motionWidget3.getTop());
                    }
                }
            }
            int i2 = 1;
            while (true) {
                CurveFit[] curveFitArr2 = this.mSpline;
                if (i2 >= curveFitArr2.length) {
                    break;
                }
                curveFitArr2[i2].getPos(d, this.mValuesBuff);
                this.mStartMotionPath.mCustomAttributes.get(this.mAttributeNames[i2 - 1]).setInterpolatedValue(motionWidget3, this.mValuesBuff);
                i2++;
            }
            if (this.mStartPoint.mVisibilityMode == 0) {
                if (f5 <= 0.0f) {
                    motionWidget3.setVisibility(this.mStartPoint.mVisibility);
                } else if (f5 >= 1.0f) {
                    motionWidget3.setVisibility(this.mEndPoint.mVisibility);
                } else if (this.mEndPoint.mVisibility != this.mStartPoint.mVisibility) {
                    motionWidget3.setVisibility(4);
                }
            }
            if (this.mKeyTriggers != null) {
                int i3 = 0;
                while (true) {
                    MotionKeyTrigger[] motionKeyTriggerArr = this.mKeyTriggers;
                    if (i3 >= motionKeyTriggerArr.length) {
                        break;
                    }
                    motionKeyTriggerArr[i3].conditionallyFire(f5, motionWidget3);
                    i3++;
                }
            }
        } else {
            float f6 = this.mStartMotionPath.mX + ((this.mEndMotionPath.mX - this.mStartMotionPath.mX) * f5) + 0.5f;
            float f7 = this.mStartMotionPath.mY + ((this.mEndMotionPath.mY - this.mStartMotionPath.mY) * f5) + 0.5f;
            motionWidget3.layout((int) f6, (int) f7, (int) (f6 + this.mStartMotionPath.mWidth + ((this.mEndMotionPath.mWidth - this.mStartMotionPath.mWidth) * f5)), (int) (f7 + this.mStartMotionPath.mHeight + ((this.mEndMotionPath.mHeight - this.mStartMotionPath.mHeight) * f5)));
        }
        HashMap<String, KeyCycleOscillator> hashMap2 = this.mCycleMap;
        if (hashMap2 != null) {
            for (KeyCycleOscillator keyCycleOscillator : hashMap2.values()) {
                if (keyCycleOscillator instanceof KeyCycleOscillator.PathRotateSet) {
                    double[] dArr2 = this.mInterpolateVelocity;
                    ((KeyCycleOscillator.PathRotateSet) keyCycleOscillator).setPathRotate(motionWidget3, f5, dArr2[0], dArr2[1]);
                } else {
                    keyCycleOscillator.setProperty(motionWidget3, f5);
                }
            }
        }
        return false;
    }

    public void getDpDt(float f, float f2, float f3, float[] fArr) {
        double[] dArr;
        float adjustedPosition = getAdjustedPosition(f, this.mVelocity);
        CurveFit[] curveFitArr = this.mSpline;
        int i = 0;
        if (curveFitArr != null) {
            double d = adjustedPosition;
            curveFitArr[0].getSlope(d, this.mInterpolateVelocity);
            this.mSpline[0].getPos(d, this.mInterpolateData);
            float f4 = this.mVelocity[0];
            while (true) {
                dArr = this.mInterpolateVelocity;
                if (i >= dArr.length) {
                    break;
                }
                dArr[i] = dArr[i] * f4;
                i++;
            }
            CurveFit curveFit = this.mArcSpline;
            if (curveFit != null) {
                double[] dArr2 = this.mInterpolateData;
                if (dArr2.length > 0) {
                    curveFit.getPos(d, dArr2);
                    this.mArcSpline.getSlope(d, this.mInterpolateVelocity);
                    this.mStartMotionPath.setDpDt(f2, f3, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
                    return;
                }
                return;
            }
            this.mStartMotionPath.setDpDt(f2, f3, fArr, this.mInterpolateVariables, dArr, this.mInterpolateData);
            return;
        }
        float f5 = this.mEndMotionPath.mX - this.mStartMotionPath.mX;
        float f6 = this.mEndMotionPath.mY - this.mStartMotionPath.mY;
        float f7 = (this.mEndMotionPath.mHeight - this.mStartMotionPath.mHeight) + f6;
        fArr[0] = (f5 * (1.0f - f2)) + (((this.mEndMotionPath.mWidth - this.mStartMotionPath.mWidth) + f5) * f2);
        fArr[1] = (f6 * (1.0f - f3)) + (f7 * f3);
    }

    void getPostLayoutDvDp(float f, int i, int i2, float f2, float f3, float[] fArr) {
        float adjustedPosition = getAdjustedPosition(f, this.mVelocity);
        HashMap<String, SplineSet> hashMap = this.mAttributesMap;
        SplineSet splineSet = hashMap == null ? null : hashMap.get("translationX");
        HashMap<String, SplineSet> hashMap2 = this.mAttributesMap;
        SplineSet splineSet2 = hashMap2 == null ? null : hashMap2.get("translationY");
        HashMap<String, SplineSet> hashMap3 = this.mAttributesMap;
        SplineSet splineSet3 = hashMap3 == null ? null : hashMap3.get("rotationZ");
        HashMap<String, SplineSet> hashMap4 = this.mAttributesMap;
        SplineSet splineSet4 = hashMap4 == null ? null : hashMap4.get("scaleX");
        HashMap<String, SplineSet> hashMap5 = this.mAttributesMap;
        SplineSet splineSet5 = hashMap5 == null ? null : hashMap5.get("scaleY");
        HashMap<String, KeyCycleOscillator> hashMap6 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator = hashMap6 == null ? null : hashMap6.get("translationX");
        HashMap<String, KeyCycleOscillator> hashMap7 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator2 = hashMap7 == null ? null : hashMap7.get("translationY");
        HashMap<String, KeyCycleOscillator> hashMap8 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator3 = hashMap8 == null ? null : hashMap8.get("rotationZ");
        HashMap<String, KeyCycleOscillator> hashMap9 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator4 = hashMap9 == null ? null : hashMap9.get("scaleX");
        HashMap<String, KeyCycleOscillator> hashMap10 = this.mCycleMap;
        KeyCycleOscillator keyCycleOscillator5 = hashMap10 != null ? hashMap10.get("scaleY") : null;
        VelocityMatrix velocityMatrix = new VelocityMatrix();
        velocityMatrix.clear();
        velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
        velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
        velocityMatrix.setRotationVelocity(keyCycleOscillator3, adjustedPosition);
        velocityMatrix.setTranslationVelocity(keyCycleOscillator, keyCycleOscillator2, adjustedPosition);
        velocityMatrix.setScaleVelocity(keyCycleOscillator4, keyCycleOscillator5, adjustedPosition);
        CurveFit curveFit = this.mArcSpline;
        if (curveFit != null) {
            double[] dArr = this.mInterpolateData;
            if (dArr.length > 0) {
                double d = adjustedPosition;
                curveFit.getPos(d, dArr);
                this.mArcSpline.getSlope(d, this.mInterpolateVelocity);
                this.mStartMotionPath.setDpDt(f2, f3, fArr, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
            }
            velocityMatrix.applyTransform(f2, f3, i, i2, fArr);
            return;
        }
        int i3 = 0;
        if (this.mSpline != null) {
            double adjustedPosition2 = getAdjustedPosition(adjustedPosition, this.mVelocity);
            this.mSpline[0].getSlope(adjustedPosition2, this.mInterpolateVelocity);
            this.mSpline[0].getPos(adjustedPosition2, this.mInterpolateData);
            float f4 = this.mVelocity[0];
            while (true) {
                double[] dArr2 = this.mInterpolateVelocity;
                if (i3 < dArr2.length) {
                    dArr2[i3] = dArr2[i3] * f4;
                    i3++;
                } else {
                    this.mStartMotionPath.setDpDt(f2, f3, fArr, this.mInterpolateVariables, dArr2, this.mInterpolateData);
                    velocityMatrix.applyTransform(f2, f3, i, i2, fArr);
                    return;
                }
            }
        } else {
            float f5 = this.mEndMotionPath.mX - this.mStartMotionPath.mX;
            float f6 = this.mEndMotionPath.mY - this.mStartMotionPath.mY;
            float f7 = f5 + (this.mEndMotionPath.mWidth - this.mStartMotionPath.mWidth);
            float f8 = (this.mEndMotionPath.mHeight - this.mStartMotionPath.mHeight) + f6;
            fArr[0] = (f5 * (1.0f - f2)) + (f7 * f2);
            fArr[1] = (f6 * (1.0f - f3)) + (f8 * f3);
            velocityMatrix.clear();
            velocityMatrix.setRotationVelocity(splineSet3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(splineSet, splineSet2, adjustedPosition);
            velocityMatrix.setScaleVelocity(splineSet4, splineSet5, adjustedPosition);
            velocityMatrix.setRotationVelocity(keyCycleOscillator3, adjustedPosition);
            velocityMatrix.setTranslationVelocity(keyCycleOscillator, keyCycleOscillator2, adjustedPosition);
            velocityMatrix.setScaleVelocity(keyCycleOscillator4, keyCycleOscillator5, adjustedPosition);
            velocityMatrix.applyTransform(f2, f3, i, i2, fArr);
        }
    }

    public int getDrawPath() {
        int i = this.mStartMotionPath.mDrawPath;
        Iterator<MotionPaths> it = this.mMotionPaths.iterator();
        while (it.hasNext()) {
            i = Math.max(i, it.next().mDrawPath);
        }
        return Math.max(i, this.mEndMotionPath.mDrawPath);
    }

    public void setDrawPath(int i) {
        this.mStartMotionPath.mDrawPath = i;
    }

    String name() {
        return this.mView.getName();
    }

    void positionKeyframe(MotionWidget motionWidget, MotionKeyPosition motionKeyPosition, float f, float f2, String[] strArr, float[] fArr) {
        FloatRect floatRect = new FloatRect();
        floatRect.left = this.mStartMotionPath.mX;
        floatRect.top = this.mStartMotionPath.mY;
        floatRect.right = floatRect.left + this.mStartMotionPath.mWidth;
        floatRect.bottom = floatRect.top + this.mStartMotionPath.mHeight;
        FloatRect floatRect2 = new FloatRect();
        floatRect2.left = this.mEndMotionPath.mX;
        floatRect2.top = this.mEndMotionPath.mY;
        floatRect2.right = floatRect2.left + this.mEndMotionPath.mWidth;
        floatRect2.bottom = floatRect2.top + this.mEndMotionPath.mHeight;
        motionKeyPosition.positionAttributes(motionWidget, floatRect, floatRect2, f, f2, strArr, fArr);
    }

    public int getKeyFramePositions(int[] iArr, float[] fArr) {
        Iterator<MotionKey> it = this.mKeyList.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            MotionKey next = it.next();
            iArr[i] = next.mFramePosition + (next.mType * 1000);
            double d = next.mFramePosition / 100.0f;
            this.mSpline[0].getPos(d, this.mInterpolateData);
            this.mStartMotionPath.getCenter(d, this.mInterpolateVariables, this.mInterpolateData, fArr, i2);
            i2 += 2;
            i++;
        }
        return i;
    }

    public int getKeyFrameInfo(int i, int[] iArr) {
        float[] fArr = new float[2];
        Iterator<MotionKey> it = this.mKeyList.iterator();
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            MotionKey next = it.next();
            if (next.mType == i || i != -1) {
                iArr[i3] = 0;
                iArr[i3 + 1] = next.mType;
                iArr[i3 + 2] = next.mFramePosition;
                double d = next.mFramePosition / 100.0f;
                this.mSpline[0].getPos(d, this.mInterpolateData);
                this.mStartMotionPath.getCenter(d, this.mInterpolateVariables, this.mInterpolateData, fArr, 0);
                iArr[i3 + 3] = Float.floatToIntBits(fArr[0]);
                int i4 = i3 + 4;
                iArr[i4] = Float.floatToIntBits(fArr[1]);
                if (next instanceof MotionKeyPosition) {
                    MotionKeyPosition motionKeyPosition = (MotionKeyPosition) next;
                    iArr[i3 + 5] = motionKeyPosition.mPositionType;
                    iArr[i3 + 6] = Float.floatToIntBits(motionKeyPosition.mPercentX);
                    i4 = i3 + 7;
                    iArr[i4] = Float.floatToIntBits(motionKeyPosition.mPercentY);
                }
                int i5 = i4 + 1;
                iArr[i3] = i5 - i3;
                i2++;
                i3 = i5;
            }
        }
        return i2;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, int i2) {
        if (i == 509) {
            setPathMotionArc(i2);
            return true;
        } else if (i != 610) {
            return i == 704;
        } else {
            this.mQuantizeMotionSteps = i2;
            return true;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, float f) {
        if (602 == i) {
            this.mQuantizeMotionPhase = f;
            return true;
        } else if (600 == i) {
            this.mMotionStagger = f;
            return true;
        } else {
            return false;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, String str) {
        if (705 == i || 611 == i) {
            this.mQuantizeMotionInterpolator = getInterpolator(-1, str, 0);
            return true;
        } else if (605 == i) {
            this.mStartMotionPath.mAnimateRelativeTo = str;
            return true;
        } else {
            return false;
        }
    }

    public void setStaggerScale(float f) {
        this.mStaggerScale = f;
    }

    public void setStaggerOffset(float f) {
        this.mStaggerOffset = f;
    }

    public float getMotionStagger() {
        return this.mMotionStagger;
    }

    public void setIdString(String str) {
        this.mId = str;
        this.mStartMotionPath.mId = str;
    }
}
