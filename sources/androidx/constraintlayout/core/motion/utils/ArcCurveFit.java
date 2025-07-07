package androidx.constraintlayout.core.motion.utils;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class ArcCurveFit extends CurveFit {
    public static final int ARC_ABOVE = 5;
    public static final int ARC_BELOW = 4;
    public static final int ARC_START_FLIP = 3;
    public static final int ARC_START_HORIZONTAL = 2;
    public static final int ARC_START_LINEAR = 0;
    public static final int ARC_START_VERTICAL = 1;
    private static final int DOWN_ARC = 4;
    private static final int START_HORIZONTAL = 2;
    private static final int START_LINEAR = 3;
    private static final int START_VERTICAL = 1;
    private static final int UP_ARC = 5;
    Arc[] mArcs;
    private boolean mExtrapolate = true;
    private final double[] mTime;

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d, double[] dArr) {
        if (this.mExtrapolate) {
            if (d < this.mArcs[0].mTime1) {
                double d2 = this.mArcs[0].mTime1;
                double d3 = d - this.mArcs[0].mTime1;
                if (this.mArcs[0].mLinear) {
                    dArr[0] = this.mArcs[0].getLinearX(d2) + (this.mArcs[0].getLinearDX(d2) * d3);
                    dArr[1] = this.mArcs[0].getLinearY(d2) + (d3 * this.mArcs[0].getLinearDY(d2));
                    return;
                }
                this.mArcs[0].setPoint(d2);
                dArr[0] = this.mArcs[0].getX() + (this.mArcs[0].getDX() * d3);
                dArr[1] = this.mArcs[0].getY() + (d3 * this.mArcs[0].getDY());
                return;
            }
            Arc[] arcArr = this.mArcs;
            if (d > arcArr[arcArr.length - 1].mTime2) {
                Arc[] arcArr2 = this.mArcs;
                double d4 = arcArr2[arcArr2.length - 1].mTime2;
                double d5 = d - d4;
                Arc[] arcArr3 = this.mArcs;
                int length = arcArr3.length - 1;
                if (arcArr3[length].mLinear) {
                    dArr[0] = this.mArcs[length].getLinearX(d4) + (this.mArcs[length].getLinearDX(d4) * d5);
                    dArr[1] = this.mArcs[length].getLinearY(d4) + (d5 * this.mArcs[length].getLinearDY(d4));
                    return;
                }
                this.mArcs[length].setPoint(d);
                dArr[0] = this.mArcs[length].getX() + (this.mArcs[length].getDX() * d5);
                dArr[1] = this.mArcs[length].getY() + (d5 * this.mArcs[length].getDY());
                return;
            }
        } else {
            if (d < this.mArcs[0].mTime1) {
                d = this.mArcs[0].mTime1;
            }
            Arc[] arcArr4 = this.mArcs;
            if (d > arcArr4[arcArr4.length - 1].mTime2) {
                Arc[] arcArr5 = this.mArcs;
                d = arcArr5[arcArr5.length - 1].mTime2;
            }
        }
        int i = 0;
        while (true) {
            Arc[] arcArr6 = this.mArcs;
            if (i >= arcArr6.length) {
                return;
            }
            if (d <= arcArr6[i].mTime2) {
                if (this.mArcs[i].mLinear) {
                    dArr[0] = this.mArcs[i].getLinearX(d);
                    dArr[1] = this.mArcs[i].getLinearY(d);
                    return;
                }
                this.mArcs[i].setPoint(d);
                dArr[0] = this.mArcs[i].getX();
                dArr[1] = this.mArcs[i].getY();
                return;
            }
            i++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getPos(double d, float[] fArr) {
        if (this.mExtrapolate) {
            if (d < this.mArcs[0].mTime1) {
                double d2 = this.mArcs[0].mTime1;
                double d3 = d - this.mArcs[0].mTime1;
                if (this.mArcs[0].mLinear) {
                    fArr[0] = (float) (this.mArcs[0].getLinearX(d2) + (this.mArcs[0].getLinearDX(d2) * d3));
                    fArr[1] = (float) (this.mArcs[0].getLinearY(d2) + (d3 * this.mArcs[0].getLinearDY(d2)));
                    return;
                }
                this.mArcs[0].setPoint(d2);
                fArr[0] = (float) (this.mArcs[0].getX() + (this.mArcs[0].getDX() * d3));
                fArr[1] = (float) (this.mArcs[0].getY() + (d3 * this.mArcs[0].getDY()));
                return;
            }
            Arc[] arcArr = this.mArcs;
            if (d > arcArr[arcArr.length - 1].mTime2) {
                Arc[] arcArr2 = this.mArcs;
                double d4 = arcArr2[arcArr2.length - 1].mTime2;
                double d5 = d - d4;
                Arc[] arcArr3 = this.mArcs;
                int length = arcArr3.length - 1;
                if (arcArr3[length].mLinear) {
                    fArr[0] = (float) (this.mArcs[length].getLinearX(d4) + (this.mArcs[length].getLinearDX(d4) * d5));
                    fArr[1] = (float) (this.mArcs[length].getLinearY(d4) + (d5 * this.mArcs[length].getLinearDY(d4)));
                    return;
                }
                this.mArcs[length].setPoint(d);
                fArr[0] = (float) this.mArcs[length].getX();
                fArr[1] = (float) this.mArcs[length].getY();
                return;
            }
        } else if (d < this.mArcs[0].mTime1) {
            d = this.mArcs[0].mTime1;
        } else {
            Arc[] arcArr4 = this.mArcs;
            if (d > arcArr4[arcArr4.length - 1].mTime2) {
                Arc[] arcArr5 = this.mArcs;
                d = arcArr5[arcArr5.length - 1].mTime2;
            }
        }
        int i = 0;
        while (true) {
            Arc[] arcArr6 = this.mArcs;
            if (i >= arcArr6.length) {
                return;
            }
            if (d <= arcArr6[i].mTime2) {
                if (this.mArcs[i].mLinear) {
                    fArr[0] = (float) this.mArcs[i].getLinearX(d);
                    fArr[1] = (float) this.mArcs[i].getLinearY(d);
                    return;
                }
                this.mArcs[i].setPoint(d);
                fArr[0] = (float) this.mArcs[i].getX();
                fArr[1] = (float) this.mArcs[i].getY();
                return;
            }
            i++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public void getSlope(double d, double[] dArr) {
        if (d < this.mArcs[0].mTime1) {
            d = this.mArcs[0].mTime1;
        } else {
            Arc[] arcArr = this.mArcs;
            if (d > arcArr[arcArr.length - 1].mTime2) {
                Arc[] arcArr2 = this.mArcs;
                d = arcArr2[arcArr2.length - 1].mTime2;
            }
        }
        int i = 0;
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i >= arcArr3.length) {
                return;
            }
            if (d <= arcArr3[i].mTime2) {
                if (this.mArcs[i].mLinear) {
                    dArr[0] = this.mArcs[i].getLinearDX(d);
                    dArr[1] = this.mArcs[i].getLinearDY(d);
                    return;
                }
                this.mArcs[i].setPoint(d);
                dArr[0] = this.mArcs[i].getDX();
                dArr[1] = this.mArcs[i].getDY();
                return;
            }
            i++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getPos(double d, int i) {
        Arc[] arcArr;
        Arc[] arcArr2;
        Arc[] arcArr3;
        Arc[] arcArr4;
        double d2;
        double linearY;
        double linearDY;
        double y;
        double dy;
        int i2 = 0;
        if (this.mExtrapolate) {
            if (d < this.mArcs[0].mTime1) {
                double d3 = this.mArcs[0].mTime1;
                d2 = d - this.mArcs[0].mTime1;
                if (!this.mArcs[0].mLinear) {
                    this.mArcs[0].setPoint(d3);
                    if (i == 0) {
                        y = this.mArcs[0].getX();
                        dy = this.mArcs[0].getDX();
                    } else {
                        y = this.mArcs[0].getY();
                        dy = this.mArcs[0].getDY();
                    }
                    return y + (d2 * dy);
                } else if (i == 0) {
                    linearY = this.mArcs[0].getLinearX(d3);
                    linearDY = this.mArcs[0].getLinearDX(d3);
                } else {
                    linearY = this.mArcs[0].getLinearY(d3);
                    linearDY = this.mArcs[0].getLinearDY(d3);
                }
            } else {
                if (d > this.mArcs[arcArr3.length - 1].mTime2) {
                    double d4 = this.mArcs[arcArr4.length - 1].mTime2;
                    d2 = d - d4;
                    Arc[] arcArr5 = this.mArcs;
                    int length = arcArr5.length - 1;
                    if (i == 0) {
                        linearY = arcArr5[length].getLinearX(d4);
                        linearDY = this.mArcs[length].getLinearDX(d4);
                    } else {
                        linearY = arcArr5[length].getLinearY(d4);
                        linearDY = this.mArcs[length].getLinearDY(d4);
                    }
                }
            }
            return linearY + (d2 * linearDY);
        } else if (d < this.mArcs[0].mTime1) {
            d = this.mArcs[0].mTime1;
        } else {
            if (d > this.mArcs[arcArr.length - 1].mTime2) {
                d = this.mArcs[arcArr2.length - 1].mTime2;
            }
        }
        while (true) {
            Arc[] arcArr6 = this.mArcs;
            if (i2 >= arcArr6.length) {
                return Double.NaN;
            }
            if (d <= arcArr6[i2].mTime2) {
                if (this.mArcs[i2].mLinear) {
                    if (i == 0) {
                        return this.mArcs[i2].getLinearX(d);
                    }
                    return this.mArcs[i2].getLinearY(d);
                }
                this.mArcs[i2].setPoint(d);
                if (i == 0) {
                    return this.mArcs[i2].getX();
                }
                return this.mArcs[i2].getY();
            }
            i2++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double getSlope(double d, int i) {
        int i2 = 0;
        if (d < this.mArcs[0].mTime1) {
            d = this.mArcs[0].mTime1;
        }
        Arc[] arcArr = this.mArcs;
        if (d > arcArr[arcArr.length - 1].mTime2) {
            Arc[] arcArr2 = this.mArcs;
            d = arcArr2[arcArr2.length - 1].mTime2;
        }
        while (true) {
            Arc[] arcArr3 = this.mArcs;
            if (i2 >= arcArr3.length) {
                return Double.NaN;
            }
            if (d <= arcArr3[i2].mTime2) {
                if (this.mArcs[i2].mLinear) {
                    if (i == 0) {
                        return this.mArcs[i2].getLinearDX(d);
                    }
                    return this.mArcs[i2].getLinearDY(d);
                }
                this.mArcs[i2].setPoint(d);
                if (i == 0) {
                    return this.mArcs[i2].getDX();
                }
                return this.mArcs[i2].getDY();
            }
            i2++;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.mTime;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
        if (r5 == 1) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArcCurveFit(int[] iArr, double[] dArr, double[][] dArr2) {
        this.mTime = dArr;
        this.mArcs = new Arc[dArr.length - 1];
        int i = 1;
        int i2 = 1;
        int i3 = 0;
        while (true) {
            Arc[] arcArr = this.mArcs;
            if (i3 >= arcArr.length) {
                return;
            }
            int i4 = iArr[i3];
            int i5 = 3;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            i5 = 4;
                            if (i4 != 4) {
                                i5 = 5;
                                if (i4 != 5) {
                                    i5 = i2;
                                }
                            }
                        }
                    }
                    i = 2;
                    i5 = i;
                }
                i = 1;
                i5 = i;
            }
            double d = dArr[i3];
            int i6 = i3 + 1;
            double d2 = dArr[i6];
            double[] dArr3 = dArr2[i3];
            double d3 = dArr3[0];
            double d4 = dArr3[1];
            double[] dArr4 = dArr2[i6];
            arcArr[i3] = new Arc(i5, d, d2, d3, d4, dArr4[0], dArr4[1]);
            i3 = i6;
            i2 = i5;
        }
    }

    /* loaded from: classes2.dex */
    private static class Arc {
        private static final double EPSILON = 0.001d;
        private static final String TAG = "Arc";
        private static double[] sOurPercent = new double[91];
        double mArcDistance;
        double mArcVelocity;
        double mEllipseA;
        double mEllipseB;
        double mEllipseCenterX;
        double mEllipseCenterY;
        boolean mLinear;
        double[] mLut;
        double mOneOverDeltaTime;
        double mTime1;
        double mTime2;
        double mTmpCosAngle;
        double mTmpSinAngle;
        boolean mVertical;
        double mX1;
        double mX2;
        double mY1;
        double mY2;

        Arc(int i, double d, double d2, double d3, double d4, double d5, double d6) {
            this.mLinear = false;
            double d7 = d5 - d3;
            double d8 = d6 - d4;
            if (i == 1) {
                this.mVertical = true;
            } else if (i == 4) {
                this.mVertical = d8 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            } else if (i == 5) {
                this.mVertical = d8 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            } else {
                this.mVertical = false;
            }
            this.mTime1 = d;
            this.mTime2 = d2;
            this.mOneOverDeltaTime = 1.0d / (d2 - d);
            if (3 == i) {
                this.mLinear = true;
            }
            if (this.mLinear || Math.abs(d7) < EPSILON || Math.abs(d8) < EPSILON) {
                this.mLinear = true;
                this.mX1 = d3;
                this.mX2 = d5;
                this.mY1 = d4;
                this.mY2 = d6;
                double hypot = Math.hypot(d8, d7);
                this.mArcDistance = hypot;
                this.mArcVelocity = hypot * this.mOneOverDeltaTime;
                double d9 = this.mTime2;
                double d10 = this.mTime1;
                this.mEllipseCenterX = d7 / (d9 - d10);
                this.mEllipseCenterY = d8 / (d9 - d10);
                return;
            }
            this.mLut = new double[101];
            boolean z = this.mVertical;
            this.mEllipseA = d7 * (z ? -1 : 1);
            this.mEllipseB = d8 * (z ? 1 : -1);
            this.mEllipseCenterX = z ? d5 : d3;
            this.mEllipseCenterY = z ? d4 : d6;
            buildTable(d3, d4, d5, d6);
            this.mArcVelocity = this.mArcDistance * this.mOneOverDeltaTime;
        }

        void setPoint(double d) {
            double lookup = lookup((this.mVertical ? this.mTime2 - d : d - this.mTime1) * this.mOneOverDeltaTime) * 1.5707963267948966d;
            this.mTmpSinAngle = Math.sin(lookup);
            this.mTmpCosAngle = Math.cos(lookup);
        }

        double getX() {
            return this.mEllipseCenterX + (this.mEllipseA * this.mTmpSinAngle);
        }

        double getY() {
            return this.mEllipseCenterY + (this.mEllipseB * this.mTmpCosAngle);
        }

        double getDX() {
            double d = this.mEllipseA * this.mTmpCosAngle;
            double hypot = this.mArcVelocity / Math.hypot(d, (-this.mEllipseB) * this.mTmpSinAngle);
            return this.mVertical ? (-d) * hypot : d * hypot;
        }

        double getDY() {
            double d = this.mEllipseA * this.mTmpCosAngle;
            double d2 = (-this.mEllipseB) * this.mTmpSinAngle;
            double hypot = this.mArcVelocity / Math.hypot(d, d2);
            return this.mVertical ? (-d2) * hypot : d2 * hypot;
        }

        public double getLinearX(double d) {
            double d2 = (d - this.mTime1) * this.mOneOverDeltaTime;
            double d3 = this.mX1;
            return d3 + (d2 * (this.mX2 - d3));
        }

        public double getLinearY(double d) {
            double d2 = (d - this.mTime1) * this.mOneOverDeltaTime;
            double d3 = this.mY1;
            return d3 + (d2 * (this.mY2 - d3));
        }

        public double getLinearDX(double d) {
            return this.mEllipseCenterX;
        }

        public double getLinearDY(double d) {
            return this.mEllipseCenterY;
        }

        double lookup(double d) {
            if (d <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            }
            if (d >= 1.0d) {
                return 1.0d;
            }
            double[] dArr = this.mLut;
            double length = d * (dArr.length - 1);
            int i = (int) length;
            double d2 = length - i;
            double d3 = dArr[i];
            return d3 + (d2 * (dArr[i + 1] - d3));
        }

        private void buildTable(double d, double d2, double d3, double d4) {
            double[] dArr;
            double[] dArr2;
            double d5 = d3 - d;
            double d6 = d2 - d4;
            int i = 0;
            double d7 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            double d8 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            double d9 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            while (true) {
                if (i >= sOurPercent.length) {
                    break;
                }
                int i2 = i;
                double radians = Math.toRadians((i * 90.0d) / (dArr.length - 1));
                double sin = Math.sin(radians) * d5;
                double cos = Math.cos(radians) * d6;
                if (i2 > 0) {
                    d7 += Math.hypot(sin - d8, cos - d9);
                    sOurPercent[i2] = d7;
                }
                i = i2 + 1;
                d8 = sin;
                d9 = cos;
            }
            this.mArcDistance = d7;
            int i3 = 0;
            while (true) {
                double[] dArr3 = sOurPercent;
                if (i3 >= dArr3.length) {
                    break;
                }
                dArr3[i3] = dArr3[i3] / d7;
                i3++;
            }
            int i4 = 0;
            while (true) {
                if (i4 >= this.mLut.length) {
                    return;
                }
                double length = i4 / (dArr2.length - 1);
                int binarySearch = Arrays.binarySearch(sOurPercent, length);
                if (binarySearch >= 0) {
                    this.mLut[i4] = binarySearch / (sOurPercent.length - 1);
                } else if (binarySearch == -1) {
                    this.mLut[i4] = 0.0d;
                } else {
                    int i5 = -binarySearch;
                    int i6 = i5 - 2;
                    double[] dArr4 = sOurPercent;
                    double d10 = dArr4[i6];
                    this.mLut[i4] = (i6 + ((length - d10) / (dArr4[i5 - 1] - d10))) / (dArr4.length - 1);
                }
                i4++;
            }
        }
    }
}
