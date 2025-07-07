package androidx.compose.ui.graphics;

import androidx.collection.FloatFloatPair;
import androidx.compose.ui.graphics.PathSegment;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
/* compiled from: Bezier.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\t\u001a\u0011\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0082\b\u001a?\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0007¢\u0006\u0002\u0010\u001b\u001a'\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0007¢\u0006\u0002\u0010\u001e\u001a'\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0000¢\u0006\u0002\u0010\u001e\u001aH\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0003H\u0000\u001a \u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u0018H\u0002\u001a0\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u00182\u0006\u00102\u001a\u00020\u0018H\u0000\u001a \u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u00032\u0006\u00106\u001a\u00020\u0003H\u0007\u001a0\u00103\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u00032\u0006\u00106\u001a\u00020\u0003H\u0002\u001a \u00109\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u00106\u001a\u00020\u0003H\u0002\u001a(\u0010:\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u00032\u0006\u00106\u001a\u00020\u0003H\u0002\u001a\u0018\u0010;\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0003H\u0002\u001a\u0018\u0010<\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u0003H\u0007\u001a\u0018\u0010=\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u00182\u0006\u0010>\u001a\u00020\u0018H\u0002\u001a(\u0010?\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010@\u001a\u00020A2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002\u001a(\u0010B\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u0003H\u0007\u001a\u0019\u0010C\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0003H\u0082\b\u001a \u0010D\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u0003H\u0002\u001a\u0018\u0010E\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010F\u001a\u00020\u0003H\u0007\u001a+\u0010G\u001a\u00020\u001a2\u0006\u00107\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0082\b\u001a2\u0010H\u001a\u00020\u001a2\u0006\u00107\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0002\u001a \u0010I\u001a\u00020A2\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0003H\u0002\u001a \u0010J\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0003H\u0000\u001a(\u0010K\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u00182\u0006\u0010L\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0003H\u0002\u001a0\u0010M\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u00182\u0006\u0010L\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u0018H\u0002\u001a\u0018\u0010N\u001a\u00020\u001a2\u0006\u0010O\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u0018H\u0002\u001a0\u0010P\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020\u00182\u0006\u00102\u001a\u00020\u0018H\u0000\u001a0\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\u00182\u0006\u0010U\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u00182\u0006\u0010V\u001a\u00020\u001a2\u0006\u00106\u001a\u00020\u0003H\u0002\u001a \u0010W\u001a\u00020S2\u0006\u0010T\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u00182\u0006\u00106\u001a\u00020\u0003H\u0002\u001a\u0018\u0010X\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0003H\u0002\u001a \u0010Y\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002\u001a\u0015\u0010Z\u001a\u00020A*\u00020\u00012\u0006\u0010[\u001a\u00020\u0001H\u0080\b\u001a\u0015\u0010Z\u001a\u00020A*\u00020\u00032\u0006\u0010[\u001a\u00020\u0003H\u0080\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0005\u001a\u00020\u0003*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0018\u0010\t\u001a\u00020\u0003*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\b\"\u0019\u0010\u000b\u001a\u00020\u0003*\u00020\u00068Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\b\"\u0019\u0010\r\u001a\u00020\u0003*\u00020\u00068Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\b¨\u0006\\"}, d2 = {"Epsilon", "", "FloatEpsilon", "", "Tau", "endX", "Landroidx/compose/ui/graphics/PathSegment;", "getEndX", "(Landroidx/compose/ui/graphics/PathSegment;)F", "endY", "getEndY", "startX", "getStartX", "startY", "getStartY", "clampValidRootInUnitRange", "r", "computeCubicVerticalBounds", "Landroidx/collection/FloatFloatPair;", "p0y", "p1y", "p2y", "p3y", "roots", "", FirebaseAnalytics.Param.INDEX, "", "(FFFF[FI)J", "computeHorizontalBounds", "segment", "(Landroidx/compose/ui/graphics/PathSegment;[FI)J", "computeVerticalBounds", "cubicArea", "x0", "y0", "x1", "y1", "x2", "y2", "x3", "y3", "cubicToMonotonicCubics", "cubic", "dst", "tmpRoot", "cubicWinding", "points", "x", "y", "tmpCubics", "tmpRoots", "evaluateCubic", "p1", "p2", "t", "p0", "p3", "evaluateLine", "evaluateQuadratic", "evaluateX", "evaluateY", "findCubicExtremaY", "dstRoots", "findDerivativeRoots", "horizontal", "", "findFirstCubicRoot", "findFirstLineRoot", "findFirstQuadraticRoot", "findFirstRoot", "fraction", "findLineRoot", "findQuadraticRoots", "isQuadraticMonotonic", "lineWinding", "monotonicCubicWinding", TypedValues.CycleType.S_WAVE_OFFSET, "monotonicQuadraticWinding", "quadraticToMonotonicQuadratics", "quadratic", "quadraticWinding", "tmpQuadratics", "splitCubicAt", "", "src", "srcOffset", "dstOffset", "splitQuadraticAt", "unitDivide", "writeValidRootInUnitRange", "closeTo", "b", "ui-graphics_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BezierKt {
    private static final double Epsilon = 1.0E-7d;
    private static final float FloatEpsilon = 1.05E-6f;
    private static final double Tau = 6.283185307179586d;

    /* compiled from: Bezier.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PathSegment.Type.values().length];
            try {
                iArr[PathSegment.Type.Move.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PathSegment.Type.Line.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PathSegment.Type.Quadratic.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PathSegment.Type.Cubic.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PathSegment.Type.Conic.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PathSegment.Type.Close.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PathSegment.Type.Done.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final float cubicArea(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        return ((((((((f8 - f2) * (f3 + f5)) - ((f7 - f) * (f4 + f6))) + (f4 * (f - f5))) - (f3 * (f2 - f6))) + (f8 * (f5 + (f / 3.0f)))) - (f7 * (f6 + (f2 / 3.0f)))) * 3.0f) / 20.0f;
    }

    public static final float evaluateCubic(float f, float f2, float f3) {
        return ((((((f - f2) + 0.33333334f) * f3) + (f2 - (2.0f * f))) * f3) + f) * 3.0f * f3;
    }

    private static final float evaluateCubic(float f, float f2, float f3, float f4, float f5) {
        return (((((((f4 + ((f2 - f3) * 3.0f)) - f) * f5) + (((f3 - (2.0f * f2)) + f) * 3.0f)) * f5) + ((f2 - f) * 3.0f)) * f5) + f;
    }

    private static final float evaluateLine(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }

    private static final float evaluateQuadratic(float f, float f2, float f3, float f4) {
        return (((((f3 - (f2 * 2.0f)) + f) * f4) + ((f2 - f) * 2.0f)) * f4) + f;
    }

    private static final float unitDivide(float f, float f2) {
        if (f < 0.0f) {
            f = -f;
            f2 = -f2;
        }
        if (f2 == 0.0f || f == 0.0f || f >= f2) {
            return Float.NaN;
        }
        float f3 = f / f2;
        if (f3 == 0.0f) {
            return Float.NaN;
        }
        return f3;
    }

    private static final float evaluateX(PathSegment pathSegment, float f) {
        float[] points = pathSegment.getPoints();
        int i = WhenMappings.$EnumSwitchMapping$0[pathSegment.getType().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return Float.NaN;
                    }
                    return evaluateCubic(points[0], points[2], points[4], points[6], f);
                }
                return evaluateQuadratic(points[0], points[2], points[4], f);
            }
            return evaluateLine(points[0], points[2], f);
        }
        return points[0];
    }

    public static final float evaluateY(PathSegment pathSegment, float f) {
        float[] points = pathSegment.getPoints();
        int i = WhenMappings.$EnumSwitchMapping$0[pathSegment.getType().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return Float.NaN;
                    }
                    return evaluateCubic(points[1], points[3], points[5], points[7], f);
                }
                return evaluateQuadratic(points[1], points[3], points[5], f);
            }
            return evaluateLine(points[1], points[3], f);
        }
        return points[1];
    }

    public static final float findFirstRoot(PathSegment pathSegment, float f) {
        float[] points = pathSegment.getPoints();
        switch (WhenMappings.$EnumSwitchMapping$0[pathSegment.getType().ordinal()]) {
            case 1:
                return Float.NaN;
            case 2:
                float f2 = points[0] - f;
                float f3 = (-f2) / ((points[2] - f) - f2);
                float f4 = f3 >= 0.0f ? f3 : 0.0f;
                if (f4 > 1.0f) {
                    f4 = 1.0f;
                }
                if (Math.abs(f4 - f3) > FloatEpsilon) {
                    return Float.NaN;
                }
                return f4;
            case 3:
                return findFirstQuadraticRoot(points[0] - f, points[2] - f, points[4] - f);
            case 4:
                return findFirstCubicRoot(points[0] - f, points[2] - f, points[4] - f, points[6] - f);
            case 5:
            case 6:
            case 7:
                return Float.NaN;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final int findLineRoot(float f, float f2, float[] fArr, int i) {
        return writeValidRootInUnitRange((-f) / (f2 - f), fArr, i);
    }

    static /* synthetic */ int findLineRoot$default(float f, float f2, float[] fArr, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = 0;
        }
        return writeValidRootInUnitRange((-f) / (f2 - f), fArr, i);
    }

    static /* synthetic */ int findQuadraticRoots$default(float f, float f2, float f3, float[] fArr, int i, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            i = 0;
        }
        return findQuadraticRoots(f, f2, f3, fArr, i);
    }

    private static final int findQuadraticRoots(float f, float f2, float f3, float[] fArr, int i) {
        double d = f;
        double d2 = f2;
        double d3 = f3;
        double d4 = d2 * 2.0d;
        double d5 = (d - d4) + d3;
        if (d5 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            if (d2 == d3) {
                return 0;
            }
            return writeValidRootInUnitRange((float) ((d4 - d3) / (d4 - (d3 * 2.0d))), fArr, i);
        }
        double d6 = -Math.sqrt((d2 * d2) - (d3 * d));
        double d7 = (-d) + d2;
        int writeValidRootInUnitRange = writeValidRootInUnitRange((float) ((-(d6 + d7)) / d5), fArr, i);
        int writeValidRootInUnitRange2 = writeValidRootInUnitRange + writeValidRootInUnitRange((float) ((d6 - d7) / d5), fArr, i + writeValidRootInUnitRange);
        if (writeValidRootInUnitRange2 > 1) {
            float f4 = fArr[i];
            int i2 = i + 1;
            float f5 = fArr[i2];
            if (f4 <= f5) {
                return f4 == f5 ? writeValidRootInUnitRange2 - 1 : writeValidRootInUnitRange2;
            }
            fArr[i] = f5;
            fArr[i2] = f4;
            return writeValidRootInUnitRange2;
        }
        return writeValidRootInUnitRange2;
    }

    private static final int findDerivativeRoots(PathSegment pathSegment, boolean z, float[] fArr, int i) {
        int i2 = !z ? 1 : 0;
        float[] points = pathSegment.getPoints();
        int i3 = WhenMappings.$EnumSwitchMapping$0[pathSegment.getType().ordinal()];
        if (i3 == 3) {
            float f = 2;
            float f2 = points[i2 + 2];
            float f3 = (f2 - points[i2]) * f;
            return writeValidRootInUnitRange((-f3) / ((f * (points[i2 + 4] - f2)) - f3), fArr, i);
        } else if (i3 != 4) {
            return 0;
        } else {
            float f4 = points[i2 + 2];
            float f5 = (f4 - points[i2]) * 3.0f;
            float f6 = points[i2 + 4];
            float f7 = (f6 - f4) * 3.0f;
            float f8 = (points[i2 + 6] - f6) * 3.0f;
            int findQuadraticRoots = findQuadraticRoots(f5, f7, f8, fArr, i);
            float f9 = (f7 - f5) * 2.0f;
            return findQuadraticRoots + writeValidRootInUnitRange((-f9) / (((f8 - f7) * 2.0f) - f9), fArr, i + findQuadraticRoots);
        }
    }

    public static /* synthetic */ long computeHorizontalBounds$default(PathSegment pathSegment, float[] fArr, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return computeHorizontalBounds(pathSegment, fArr, i);
    }

    public static final long computeHorizontalBounds(PathSegment pathSegment, float[] fArr, int i) {
        int findDerivativeRoots = findDerivativeRoots(pathSegment, true, fArr, i);
        float min = Math.min(pathSegment.getPoints()[0], getEndX(pathSegment));
        float max = Math.max(pathSegment.getPoints()[0], getEndX(pathSegment));
        for (int i2 = 0; i2 < findDerivativeRoots; i2++) {
            float evaluateX = evaluateX(pathSegment, fArr[i2]);
            min = Math.min(min, evaluateX);
            max = Math.max(max, evaluateX);
        }
        return FloatFloatPair.m14constructorimpl(min, max);
    }

    public static /* synthetic */ long computeVerticalBounds$default(PathSegment pathSegment, float[] fArr, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return computeVerticalBounds(pathSegment, fArr, i);
    }

    public static final long computeVerticalBounds(PathSegment pathSegment, float[] fArr, int i) {
        int findDerivativeRoots = findDerivativeRoots(pathSegment, false, fArr, i);
        float min = Math.min(pathSegment.getPoints()[1], getEndY(pathSegment));
        float max = Math.max(pathSegment.getPoints()[1], getEndY(pathSegment));
        for (int i2 = 0; i2 < findDerivativeRoots; i2++) {
            float evaluateY = evaluateY(pathSegment, fArr[i2]);
            min = Math.min(min, evaluateY);
            max = Math.max(max, evaluateY);
        }
        return FloatFloatPair.m14constructorimpl(min, max);
    }

    public static /* synthetic */ long computeCubicVerticalBounds$default(float f, float f2, float f3, float f4, float[] fArr, int i, int i2, Object obj) {
        if ((i2 & 32) != 0) {
            i = 0;
        }
        return computeCubicVerticalBounds(f, f2, f3, f4, fArr, i);
    }

    public static final long computeCubicVerticalBounds(float f, float f2, float f3, float f4, float[] fArr, int i) {
        float f5 = (f2 - f) * 3.0f;
        float f6 = (f3 - f2) * 3.0f;
        float f7 = (f4 - f3) * 3.0f;
        int findQuadraticRoots = findQuadraticRoots(f5, f6, f7, fArr, i);
        float f8 = (f6 - f5) * 2.0f;
        int writeValidRootInUnitRange = findQuadraticRoots + writeValidRootInUnitRange((-f8) / (((f7 - f6) * 2.0f) - f8), fArr, i + findQuadraticRoots);
        float min = Math.min(f, f4);
        float max = Math.max(f, f4);
        for (int i2 = 0; i2 < writeValidRootInUnitRange; i2++) {
            float evaluateCubic = evaluateCubic(f, f2, f3, f4, fArr[i2]);
            min = Math.min(min, evaluateCubic);
            max = Math.max(max, evaluateCubic);
        }
        return FloatFloatPair.m14constructorimpl(min, max);
    }

    public static final boolean closeTo(double d, double d2) {
        return Math.abs(d - d2) < Epsilon;
    }

    public static final boolean closeTo(float f, float f2) {
        return Math.abs(f - f2) < FloatEpsilon;
    }

    private static final float clampValidRootInUnitRange(float f) {
        float f2 = f >= 0.0f ? f : 0.0f;
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (Math.abs(f2 - f) > FloatEpsilon) {
            return Float.NaN;
        }
        return f2;
    }

    public static final int lineWinding(float[] fArr, float f, float f2) {
        int i;
        float f3;
        if (fArr.length < 4) {
            return 0;
        }
        float f4 = fArr[0];
        float f5 = fArr[1];
        float f6 = fArr[2];
        float f7 = fArr[3];
        float f8 = f7 - f5;
        if (f5 > f7) {
            i = -1;
            f3 = f5;
        } else {
            i = 1;
            f3 = f7;
            f7 = f5;
        }
        if (f2 < f7 || f2 >= f3) {
            return 0;
        }
        float f9 = ((f6 - f4) * (f2 - f5)) - (f8 * (f - f4));
        if (f9 == 0.0f || ((int) Math.signum(f9)) == i) {
            return 0;
        }
        return i;
    }

    private static final boolean isQuadraticMonotonic(float f, float f2, float f3) {
        return !(Math.signum(f - f2) + Math.signum(f2 - f3) == 0.0f);
    }

    public static final int quadraticWinding(float[] fArr, float f, float f2, float[] fArr2, float[] fArr3) {
        if (isQuadraticMonotonic(fArr[1], fArr[3], fArr[5])) {
            return monotonicQuadraticWinding(fArr, 0, f, f2, fArr3);
        }
        int quadraticToMonotonicQuadratics = quadraticToMonotonicQuadratics(fArr, fArr2);
        int monotonicQuadraticWinding = monotonicQuadraticWinding(fArr2, 0, f, f2, fArr3);
        return quadraticToMonotonicQuadratics > 0 ? monotonicQuadraticWinding + monotonicQuadraticWinding(fArr2, 4, f, f2, fArr3) : monotonicQuadraticWinding;
    }

    private static final int monotonicQuadraticWinding(float[] fArr, int i, float f, float f2, float[] fArr2) {
        int i2;
        float f3;
        float f4;
        float evaluateQuadratic;
        float f5 = fArr[i + 1];
        float f6 = fArr[i + 5];
        if (f5 > f6) {
            i2 = -1;
            f4 = f5;
            f3 = f6;
        } else {
            i2 = 1;
            f3 = f5;
            f4 = f6;
        }
        if (f2 >= f3 && f2 < f4) {
            float f7 = fArr[i + 3];
            if (findQuadraticRoots$default((f5 - (f7 * 2.0f)) + f6, (f7 - f5) * 2.0f, f5 - f2, fArr2, 0, 16, null) == 0) {
                evaluateQuadratic = fArr[(1 - i2) * 2];
            } else {
                evaluateQuadratic = evaluateQuadratic(fArr[0], fArr[2], fArr[4], fArr2[0]);
            }
            if ((Math.abs(evaluateQuadratic - f) >= FloatEpsilon || (f == fArr[4] && f2 == f6)) && evaluateQuadratic < f) {
                return i2;
            }
        }
        return 0;
    }

    private static final int quadraticToMonotonicQuadratics(float[] fArr, float[] fArr2) {
        if (fArr.length >= 6 && fArr2.length >= 6) {
            float f = fArr[1];
            float f2 = fArr[3];
            float f3 = fArr[5];
            if (!isQuadraticMonotonic(f, f2, f3)) {
                float f4 = f - f2;
                float unitDivide = unitDivide(f4, (f4 - f2) + f3);
                if (!Float.isNaN(unitDivide)) {
                    splitQuadraticAt(fArr, fArr2, unitDivide);
                    return 1;
                }
                if (Math.abs(f4) >= Math.abs(f2 - f3)) {
                    f = f3;
                }
                f2 = f;
            }
            ArraysKt.copyInto(fArr, fArr2, 0, 0, 6);
            fArr2[3] = f2;
            return 0;
        }
        return 0;
    }

    private static final void splitQuadraticAt(float[] fArr, float[] fArr2, float f) {
        if (fArr.length >= 6 && fArr2.length >= 10) {
            float f2 = fArr[0];
            float f3 = fArr[1];
            float f4 = fArr[2];
            float f5 = fArr[3];
            float f6 = fArr[4];
            float f7 = fArr[5];
            float lerp = MathHelpersKt.lerp(f2, f4, f);
            float lerp2 = MathHelpersKt.lerp(f3, f5, f);
            fArr2[0] = f2;
            fArr2[1] = f3;
            fArr2[2] = lerp;
            fArr2[3] = lerp2;
            float lerp3 = MathHelpersKt.lerp(f4, f6, f);
            float lerp4 = MathHelpersKt.lerp(f5, f7, f);
            float lerp5 = MathHelpersKt.lerp(lerp, lerp3, f);
            float lerp6 = MathHelpersKt.lerp(lerp2, lerp4, f);
            fArr2[4] = lerp5;
            fArr2[5] = lerp6;
            fArr2[6] = lerp3;
            fArr2[7] = lerp4;
            fArr2[8] = f6;
            fArr2[9] = f7;
        }
    }

    public static final int cubicWinding(float[] fArr, float f, float f2, float[] fArr2, float[] fArr3) {
        int cubicToMonotonicCubics = cubicToMonotonicCubics(fArr, fArr2, fArr3);
        int i = 0;
        if (cubicToMonotonicCubics >= 0) {
            int i2 = 0;
            while (true) {
                i += monotonicCubicWinding(fArr2, i2 * 6, f, f2);
                if (i2 == cubicToMonotonicCubics) {
                    break;
                }
                i2++;
            }
        }
        return i;
    }

    private static final int monotonicCubicWinding(float[] fArr, int i, float f, float f2) {
        int i2;
        int i3 = i + 1;
        float f3 = fArr[i3];
        int i4 = i + 7;
        float f4 = fArr[i4];
        if (f3 > f4) {
            i2 = -1;
            f4 = f3;
            f3 = f4;
        } else {
            i2 = 1;
        }
        if (f2 >= f3 && f2 < f4) {
            float f5 = fArr[i];
            float f6 = fArr[i + 2];
            float f7 = fArr[i + 4];
            float f8 = fArr[i + 6];
            if (f < Math.min(f5, Math.min(f6, Math.min(f7, f8)))) {
                return 0;
            }
            if (f <= Math.max(f5, Math.max(f6, Math.max(f7, f8)))) {
                float f9 = fArr[i3];
                float f10 = fArr[i + 3];
                float f11 = fArr[i + 5];
                float f12 = fArr[i4];
                float findFirstCubicRoot = findFirstCubicRoot(f9 - f2, f10 - f2, f11 - f2, f12 - f2);
                if (Float.isNaN(findFirstCubicRoot)) {
                    return 0;
                }
                float evaluateCubic = evaluateCubic(f5, f6, f7, f8, findFirstCubicRoot);
                if ((Math.abs(evaluateCubic - f) >= FloatEpsilon || (f == f8 && f2 == f12)) && evaluateCubic < f) {
                }
            }
            return i2;
        }
        return 0;
    }

    private static final int cubicToMonotonicCubics(float[] fArr, float[] fArr2, float[] fArr3) {
        int findCubicExtremaY = findCubicExtremaY(fArr, fArr3);
        int i = 0;
        if (findCubicExtremaY == 0) {
            if (fArr2.length < 8) {
                return 0;
            }
            ArraysKt.copyInto(fArr, fArr2, 0, 0, 8);
            return findCubicExtremaY;
        }
        int i2 = 0;
        float f = 0.0f;
        while (i < findCubicExtremaY) {
            float f2 = (fArr3[i] - f) / (1.0f - f);
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            f = f2 > 1.0f ? 1.0f : f2;
            splitCubicAt(fArr, i2, fArr2, i2, f);
            i2 += 6;
            i++;
            fArr = fArr2;
        }
        return findCubicExtremaY;
    }

    private static final int findCubicExtremaY(float[] fArr, float[] fArr2) {
        float f = fArr[1];
        float f2 = fArr[3];
        float f3 = fArr[5];
        return findQuadraticRoots((fArr[7] - f) + ((f2 - f3) * 3.0f), (((f - f2) - f2) - f3) * 2.0f, f2 - f, fArr2, 0);
    }

    private static final void splitCubicAt(float[] fArr, int i, float[] fArr2, int i2, float f) {
        if (fArr.length >= i + 8 && fArr2.length >= i2 + 14) {
            if (f >= 1.0f) {
                ArraysKt.copyInto(fArr, fArr2, i2, i, 8);
                float f2 = fArr[i + 6];
                float f3 = fArr[i + 7];
                fArr2[i2 + 8] = f2;
                fArr2[i2 + 9] = f3;
                fArr2[i2 + 10] = f2;
                fArr2[i2 + 11] = f3;
                fArr2[i2 + 12] = f2;
                fArr2[i2 + 13] = f3;
                return;
            }
            float f4 = fArr[i];
            float f5 = fArr[i + 1];
            fArr2[i2] = f4;
            fArr2[i2 + 1] = f5;
            float f6 = fArr[i + 2];
            float f7 = fArr[i + 3];
            float lerp = MathHelpersKt.lerp(f4, f6, f);
            float lerp2 = MathHelpersKt.lerp(f5, f7, f);
            fArr2[i2 + 2] = lerp;
            fArr2[i2 + 3] = lerp2;
            float f8 = fArr[i + 4];
            float f9 = fArr[i + 5];
            float lerp3 = MathHelpersKt.lerp(f6, f8, f);
            float lerp4 = MathHelpersKt.lerp(f7, f9, f);
            float lerp5 = MathHelpersKt.lerp(lerp, lerp3, f);
            float lerp6 = MathHelpersKt.lerp(lerp2, lerp4, f);
            fArr2[i2 + 4] = lerp5;
            fArr2[i2 + 5] = lerp6;
            float f10 = fArr[i + 6];
            float f11 = fArr[i + 7];
            float lerp7 = MathHelpersKt.lerp(f8, f10, f);
            float lerp8 = MathHelpersKt.lerp(f9, f11, f);
            float lerp9 = MathHelpersKt.lerp(lerp3, lerp7, f);
            float lerp10 = MathHelpersKt.lerp(lerp4, lerp8, f);
            float lerp11 = MathHelpersKt.lerp(lerp5, lerp9, f);
            float lerp12 = MathHelpersKt.lerp(lerp6, lerp10, f);
            fArr2[i2 + 6] = lerp11;
            fArr2[i2 + 7] = lerp12;
            fArr2[i2 + 8] = lerp9;
            fArr2[i2 + 9] = lerp10;
            fArr2[i2 + 10] = lerp7;
            fArr2[i2 + 11] = lerp8;
            fArr2[i2 + 12] = f10;
            fArr2[i2 + 13] = f11;
        }
    }

    private static final float getStartX(PathSegment pathSegment) {
        return pathSegment.getPoints()[0];
    }

    private static final float getEndX(PathSegment pathSegment) {
        float[] points = pathSegment.getPoints();
        int i = WhenMappings.$EnumSwitchMapping$0[pathSegment.getType().ordinal()];
        char c = 2;
        if (i != 2) {
            if (i != 3) {
                if (i == 4) {
                    c = 6;
                } else if (i != 5) {
                    c = 0;
                }
            }
            c = 4;
        }
        return points[c];
    }

    private static final float getStartY(PathSegment pathSegment) {
        return pathSegment.getPoints()[1];
    }

    private static final float getEndY(PathSegment pathSegment) {
        float[] points = pathSegment.getPoints();
        int i = WhenMappings.$EnumSwitchMapping$0[pathSegment.getType().ordinal()];
        char c = 3;
        if (i != 2) {
            if (i != 3) {
                if (i == 4) {
                    c = 7;
                } else if (i != 5) {
                    c = 0;
                }
            }
            c = 5;
        }
        return points[c];
    }

    private static final float findFirstLineRoot(float f, float f2) {
        float f3 = (-f) / (f2 - f);
        float f4 = f3 >= 0.0f ? f3 : 0.0f;
        if (f4 > 1.0f) {
            f4 = 1.0f;
        }
        if (Math.abs(f4 - f3) > FloatEpsilon) {
            return Float.NaN;
        }
        return f4;
    }

    private static final float findFirstQuadraticRoot(float f, float f2, float f3) {
        float f4;
        float f5;
        double d = f;
        double d2 = f2;
        double d3 = f3;
        double d4 = d2 * 2.0d;
        double d5 = (d - d4) + d3;
        if (d5 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            if (d2 == d3) {
                return Float.NaN;
            }
            float f6 = (float) ((d4 - d3) / (d4 - (d3 * 2.0d)));
            f4 = f6 >= 0.0f ? f6 : 0.0f;
            f5 = f4 <= 1.0f ? f4 : 1.0f;
            if (Math.abs(f5 - f6) > FloatEpsilon) {
                return Float.NaN;
            }
            return f5;
        }
        double d6 = -Math.sqrt((d2 * d2) - (d3 * d));
        double d7 = (-d) + d2;
        float f7 = (float) ((-(d6 + d7)) / d5);
        float f8 = f7 < 0.0f ? 0.0f : f7;
        if (f8 > 1.0f) {
            f8 = 1.0f;
        }
        if (Math.abs(f8 - f7) > FloatEpsilon) {
            f8 = Float.NaN;
        }
        if (Float.isNaN(f8)) {
            float f9 = (float) ((d6 - d7) / d5);
            f4 = f9 >= 0.0f ? f9 : 0.0f;
            f5 = f4 <= 1.0f ? f4 : 1.0f;
            if (Math.abs(f5 - f9) > FloatEpsilon) {
                return Float.NaN;
            }
            return f5;
        }
        return f8;
    }

    public static final float findFirstCubicRoot(float f, float f2, float f3, float f4) {
        float f5;
        float f6;
        double d = f;
        double d2 = ((d - (f2 * 2.0d)) + f3) * 3.0d;
        double d3 = (f2 - f) * 3.0d;
        double d4 = (-f) + ((f2 - f3) * 3.0d) + f4;
        if (Math.abs(d4 - FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) < Epsilon) {
            if (Math.abs(d2 - FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) >= Epsilon) {
                double sqrt = Math.sqrt((d3 * d3) - ((4.0d * d2) * d));
                double d5 = d2 * 2.0d;
                float f7 = (float) ((sqrt - d3) / d5);
                float f8 = f7 < 0.0f ? 0.0f : f7;
                if (f8 > 1.0f) {
                    f8 = 1.0f;
                }
                if (Math.abs(f8 - f7) > FloatEpsilon) {
                    f8 = Float.NaN;
                }
                if (Float.isNaN(f8)) {
                    float f9 = (float) (((-d3) - sqrt) / d5);
                    f5 = f9 >= 0.0f ? f9 : 0.0f;
                    f6 = f5 <= 1.0f ? f5 : 1.0f;
                    if (Math.abs(f6 - f9) > FloatEpsilon) {
                        return Float.NaN;
                    }
                    return f6;
                }
                return f8;
            } else if (Math.abs(d3 - FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) < Epsilon) {
                return Float.NaN;
            } else {
                float f10 = (float) ((-d) / d3);
                f5 = f10 >= 0.0f ? f10 : 0.0f;
                f6 = f5 <= 1.0f ? f5 : 1.0f;
                if (Math.abs(f6 - f10) > FloatEpsilon) {
                    return Float.NaN;
                }
                return f6;
            }
        }
        double d6 = d2 / d4;
        double d7 = d3 / d4;
        double d8 = d / d4;
        double d9 = ((d7 * 3.0d) - (d6 * d6)) / 9.0d;
        double d10 = (((((2.0d * d6) * d6) * d6) - ((9.0d * d6) * d7)) + (d8 * 27.0d)) / 54.0d;
        double d11 = d9 * d9 * d9;
        double d12 = (d10 * d10) + d11;
        double d13 = d6 / 3.0d;
        int i = (d12 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (d12 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1));
        if (i >= 0) {
            if (i == 0) {
                float f11 = -MathHelpersKt.fastCbrt((float) d10);
                float f12 = (float) d13;
                float f13 = (2.0f * f11) - f12;
                float f14 = f13 < 0.0f ? 0.0f : f13;
                if (f14 > 1.0f) {
                    f14 = 1.0f;
                }
                if (Math.abs(f14 - f13) > FloatEpsilon) {
                    f14 = Float.NaN;
                }
                if (Float.isNaN(f14)) {
                    float f15 = (-f11) - f12;
                    f5 = f15 >= 0.0f ? f15 : 0.0f;
                    f6 = f5 <= 1.0f ? f5 : 1.0f;
                    if (Math.abs(f6 - f15) > FloatEpsilon) {
                        return Float.NaN;
                    }
                    return f6;
                }
                return f14;
            }
            double sqrt2 = Math.sqrt(d12);
            float fastCbrt = (float) ((MathHelpersKt.fastCbrt((float) ((-d10) + sqrt2)) - MathHelpersKt.fastCbrt((float) (d10 + sqrt2))) - d13);
            f5 = fastCbrt >= 0.0f ? fastCbrt : 0.0f;
            f6 = f5 <= 1.0f ? f5 : 1.0f;
            if (Math.abs(f6 - fastCbrt) > FloatEpsilon) {
                return Float.NaN;
            }
            return f6;
        }
        double sqrt3 = Math.sqrt(-d11);
        double d14 = (-d10) / sqrt3;
        if (d14 < -1.0d) {
            d14 = -1.0d;
        }
        if (d14 > 1.0d) {
            d14 = 1.0d;
        }
        double acos = Math.acos(d14);
        double fastCbrt2 = MathHelpersKt.fastCbrt((float) sqrt3) * 2.0f;
        float cos = (float) ((Math.cos(acos / 3.0d) * fastCbrt2) - d13);
        float f16 = cos < 0.0f ? 0.0f : cos;
        if (f16 > 1.0f) {
            f16 = 1.0f;
        }
        if (Math.abs(f16 - cos) > FloatEpsilon) {
            f16 = Float.NaN;
        }
        if (Float.isNaN(f16)) {
            float cos2 = (float) ((Math.cos((Tau + acos) / 3.0d) * fastCbrt2) - d13);
            float f17 = cos2 < 0.0f ? 0.0f : cos2;
            if (f17 > 1.0f) {
                f17 = 1.0f;
            }
            if (Math.abs(f17 - cos2) > FloatEpsilon) {
                f17 = Float.NaN;
            }
            if (Float.isNaN(f17)) {
                float cos3 = (float) ((fastCbrt2 * Math.cos((acos + 12.566370614359172d) / 3.0d)) - d13);
                f5 = cos3 >= 0.0f ? cos3 : 0.0f;
                f6 = f5 <= 1.0f ? f5 : 1.0f;
                if (Math.abs(f6 - cos3) > FloatEpsilon) {
                    return Float.NaN;
                }
                return f6;
            }
            return f17;
        }
        return f16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int writeValidRootInUnitRange(float f, float[] fArr, int i) {
        float f2 = f >= 0.0f ? f : 0.0f;
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (Math.abs(f2 - f) > FloatEpsilon) {
            f2 = Float.NaN;
        }
        fArr[i] = f2;
        return !Float.isNaN(f2) ? 1 : 0;
    }
}
