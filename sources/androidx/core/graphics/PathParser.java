package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.extractor.metadata.dvbsi.AppInfoTableDecoder;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import io.appmetrica.analytics.BuildConfig;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public final class PathParser {
    private static final String LOGTAG = "PathParser";

    static float[] copyOfRange(float[] fArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        int min = Math.min(i3, length - i);
        float[] fArr2 = new float[i3];
        System.arraycopy(fArr, i, fArr2, 0, min);
        return fArr2;
    }

    public static Path createPathFromPathData(String str) {
        Path path = new Path();
        try {
            PathDataNode.nodesToPath(createNodesFromPathData(str), path);
            return path;
        } catch (RuntimeException e) {
            throw new RuntimeException("Error in parsing " + str, e);
        }
    }

    public static PathDataNode[] createNodesFromPathData(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 1;
        while (i2 < str.length()) {
            int nextStart = nextStart(str, i2);
            String trim = str.substring(i, nextStart).trim();
            if (!trim.isEmpty()) {
                addNode(arrayList, trim.charAt(0), getFloats(trim));
            }
            i = nextStart;
            i2 = nextStart + 1;
        }
        if (i2 - i == 1 && i < str.length()) {
            addNode(arrayList, str.charAt(i), new float[0]);
        }
        return (PathDataNode[]) arrayList.toArray(new PathDataNode[0]);
    }

    public static PathDataNode[] deepCopyNodes(PathDataNode[] pathDataNodeArr) {
        PathDataNode[] pathDataNodeArr2 = new PathDataNode[pathDataNodeArr.length];
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            pathDataNodeArr2[i] = new PathDataNode(pathDataNodeArr[i]);
        }
        return pathDataNodeArr2;
    }

    public static boolean canMorph(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
            return false;
        }
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            if (pathDataNodeArr[i].mType != pathDataNodeArr2[i].mType || pathDataNodeArr[i].mParams.length != pathDataNodeArr2[i].mParams.length) {
                return false;
            }
        }
        return true;
    }

    public static void updateNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        for (int i = 0; i < pathDataNodeArr2.length; i++) {
            pathDataNodeArr[i].mType = pathDataNodeArr2[i].mType;
            for (int i2 = 0; i2 < pathDataNodeArr2[i].mParams.length; i2++) {
                pathDataNodeArr[i].mParams[i2] = pathDataNodeArr2[i].mParams[i2];
            }
        }
    }

    private static int nextStart(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                break;
            }
            i++;
        }
        return i;
    }

    private static void addNode(ArrayList<PathDataNode> arrayList, char c, float[] fArr) {
        arrayList.add(new PathDataNode(c, fArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegOrDot;

        ExtractFloatResult() {
        }
    }

    private static float[] getFloats(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            ExtractFloatResult extractFloatResult = new ExtractFloatResult();
            int length = str.length();
            int i = 1;
            int i2 = 0;
            while (i < length) {
                extract(str, i, extractFloatResult);
                int i3 = extractFloatResult.mEndPosition;
                if (i < i3) {
                    fArr[i2] = Float.parseFloat(str.substring(i, i3));
                    i2++;
                }
                i = extractFloatResult.mEndWithNegOrDot ? i3 : i3 + 1;
            }
            return copyOfRange(fArr, 0, i2);
        } catch (NumberFormatException e) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003a A[LOOP:0: B:3:0x0007->B:24:0x003a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void extract(String str, int i, ExtractFloatResult extractFloatResult) {
        extractFloatResult.mEndWithNegOrDot = false;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (int i2 = i; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt != ' ') {
                if (charAt != 'E' && charAt != 'e') {
                    switch (charAt) {
                        case ',':
                            break;
                        case '-':
                            if (i2 != i && !z) {
                                extractFloatResult.mEndWithNegOrDot = true;
                                break;
                            }
                            z = false;
                            break;
                        case '.':
                            if (z2) {
                                extractFloatResult.mEndWithNegOrDot = true;
                                break;
                            } else {
                                z = false;
                                z2 = true;
                                break;
                            }
                        default:
                            z = false;
                            break;
                    }
                } else {
                    z = true;
                }
                if (!z3) {
                    extractFloatResult.mEndPosition = i2;
                }
            }
            z = false;
            z3 = true;
            if (!z3) {
            }
        }
        extractFloatResult.mEndPosition = i2;
    }

    public static void interpolatePathDataNodes(PathDataNode[] pathDataNodeArr, float f, PathDataNode[] pathDataNodeArr2, PathDataNode[] pathDataNodeArr3) {
        if (!interpolatePathDataNodes(pathDataNodeArr, pathDataNodeArr2, pathDataNodeArr3, f)) {
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
    }

    @Deprecated
    public static boolean interpolatePathDataNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2, PathDataNode[] pathDataNodeArr3, float f) {
        if (pathDataNodeArr.length != pathDataNodeArr2.length || pathDataNodeArr2.length != pathDataNodeArr3.length) {
            throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
        }
        if (canMorph(pathDataNodeArr2, pathDataNodeArr3)) {
            for (int i = 0; i < pathDataNodeArr.length; i++) {
                pathDataNodeArr[i].interpolatePathDataNode(pathDataNodeArr2[i], pathDataNodeArr3[i], f);
            }
            return true;
        }
        return false;
    }

    public static void nodesToPath(PathDataNode[] pathDataNodeArr, Path path) {
        float[] fArr = new float[6];
        char c = 'm';
        for (PathDataNode pathDataNode : pathDataNodeArr) {
            PathDataNode.addCommand(path, fArr, c, pathDataNode.mType, pathDataNode.mParams);
            c = pathDataNode.mType;
        }
    }

    /* loaded from: classes2.dex */
    public static class PathDataNode {
        private final float[] mParams;
        private char mType;

        public char getType() {
            return this.mType;
        }

        public float[] getParams() {
            return this.mParams;
        }

        PathDataNode(char c, float[] fArr) {
            this.mType = c;
            this.mParams = fArr;
        }

        PathDataNode(PathDataNode pathDataNode) {
            this.mType = pathDataNode.mType;
            float[] fArr = pathDataNode.mParams;
            this.mParams = PathParser.copyOfRange(fArr, 0, fArr.length);
        }

        @Deprecated
        public static void nodesToPath(PathDataNode[] pathDataNodeArr, Path path) {
            PathParser.nodesToPath(pathDataNodeArr, path);
        }

        public void interpolatePathDataNode(PathDataNode pathDataNode, PathDataNode pathDataNode2, float f) {
            this.mType = pathDataNode.mType;
            int i = 0;
            while (true) {
                float[] fArr = pathDataNode.mParams;
                if (i >= fArr.length) {
                    return;
                }
                this.mParams[i] = (fArr[i] * (1.0f - f)) + (pathDataNode2.mParams[i] * f);
                i++;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public static void addCommand(Path path, float[] fArr, char c, char c2, float[] fArr2) {
            int i;
            int i2;
            boolean z;
            boolean z2;
            char c3;
            char c4;
            int i3;
            float f;
            boolean z3;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            boolean z4;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            float f15;
            float f16;
            Path path2 = path;
            boolean z5 = false;
            float f17 = fArr[0];
            boolean z6 = true;
            float f18 = fArr[1];
            char c5 = 2;
            float f19 = fArr[2];
            char c6 = 3;
            float f20 = fArr[3];
            float f21 = fArr[4];
            float f22 = fArr[5];
            switch (c2) {
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                case 'a':
                    i = 7;
                    i2 = i;
                    break;
                case 'C':
                case 'c':
                    i = 6;
                    i2 = i;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i2 = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case AppInfoTableDecoder.APPLICATION_INFORMATION_TABLE_ID /* 116 */:
                default:
                    i2 = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case BuildConfig.API_LEVEL /* 115 */:
                    i2 = 4;
                    break;
                case 'Z':
                case 'z':
                    path2.close();
                    path2.moveTo(f21, f22);
                    f17 = f21;
                    f19 = f17;
                    f18 = f22;
                    f20 = f18;
                    i2 = 2;
                    break;
            }
            float f23 = f17;
            float f24 = f18;
            float f25 = f21;
            float f26 = f22;
            int i4 = 0;
            char c7 = c;
            while (i4 < fArr2.length) {
                if (c2 == 'A') {
                    float f27 = f23;
                    float f28 = f24;
                    z = z5;
                    z2 = z6;
                    c3 = c5;
                    c4 = c6;
                    i3 = i4;
                    int i5 = i3 + 5;
                    float f29 = fArr2[i5];
                    int i6 = i3 + 6;
                    float f30 = fArr2[i6];
                    float f31 = fArr2[i3];
                    float f32 = fArr2[i3 + 1];
                    float f33 = fArr2[i3 + 2];
                    if (fArr2[i3 + 3] != 0.0f) {
                        f = 0.0f;
                        z3 = z2;
                    } else {
                        f = 0.0f;
                        z3 = z;
                    }
                    drawArc(path, f27, f28, f29, f30, f31, f32, f33, z3, fArr2[i3 + 4] != f ? z2 : z);
                    f19 = fArr2[i5];
                    f23 = f19;
                    f20 = fArr2[i6];
                    f24 = f20;
                } else if (c2 == 'C') {
                    z = z5;
                    z2 = z6;
                    c3 = c5;
                    c4 = c6;
                    i3 = i4;
                    int i7 = i3 + 2;
                    int i8 = i3 + 3;
                    int i9 = i3 + 4;
                    int i10 = i3 + 5;
                    path2.cubicTo(fArr2[i3], fArr2[i3 + 1], fArr2[i7], fArr2[i8], fArr2[i9], fArr2[i10]);
                    float f34 = fArr2[i9];
                    float f35 = fArr2[i10];
                    float f36 = fArr2[i7];
                    float f37 = fArr2[i8];
                    f23 = f34;
                    f24 = f35;
                    f20 = f37;
                    f19 = f36;
                } else if (c2 != 'H') {
                    if (c2 != 'Q') {
                        z = z5;
                        if (c2 == 'V') {
                            z2 = z6;
                            c3 = c5;
                            c4 = c6;
                            i3 = i4;
                            path2.lineTo(f23, fArr2[i3]);
                            f4 = fArr2[i3];
                        } else if (c2 != 'a') {
                            if (c2 != 'c') {
                                z2 = z6;
                                if (c2 != 'h') {
                                    if (c2 != 'q') {
                                        c3 = c5;
                                        if (c2 != 'v') {
                                            if (c2 != 'L') {
                                                if (c2 != 'M') {
                                                    c4 = c6;
                                                    if (c2 == 'S') {
                                                        if (c7 == 'c' || c7 == 's' || c7 == 'C' || c7 == 'S') {
                                                            f23 = (f23 * 2.0f) - f19;
                                                            f24 = (f24 * 2.0f) - f20;
                                                        }
                                                        int i11 = i4 + 1;
                                                        int i12 = i4 + 2;
                                                        int i13 = i4 + 3;
                                                        path2.cubicTo(f23, f24, fArr2[i4], fArr2[i11], fArr2[i12], fArr2[i13]);
                                                        f2 = fArr2[i4];
                                                        f3 = fArr2[i11];
                                                        f23 = fArr2[i12];
                                                        f24 = fArr2[i13];
                                                        i3 = i4;
                                                    } else if (c2 == 'T') {
                                                        if (c7 == 'q' || c7 == 't' || c7 == 'Q' || c7 == 'T') {
                                                            f23 = (f23 * 2.0f) - f19;
                                                            f24 = (f24 * 2.0f) - f20;
                                                        }
                                                        int i14 = i4 + 1;
                                                        path2.quadTo(f23, f24, fArr2[i4], fArr2[i14]);
                                                        float f38 = fArr2[i4];
                                                        f4 = fArr2[i14];
                                                        f19 = f23;
                                                        f20 = f24;
                                                        i3 = i4;
                                                        f23 = f38;
                                                    } else if (c2 == 'l') {
                                                        int i15 = i4 + 1;
                                                        path2.rLineTo(fArr2[i4], fArr2[i15]);
                                                        f23 += fArr2[i4];
                                                        f10 = fArr2[i15];
                                                    } else if (c2 == 'm') {
                                                        float f39 = fArr2[i4];
                                                        f23 += f39;
                                                        float f40 = fArr2[i4 + 1];
                                                        f24 += f40;
                                                        if (i4 > 0) {
                                                            path2.rLineTo(f39, f40);
                                                        } else {
                                                            path2.rMoveTo(f39, f40);
                                                            f25 = f23;
                                                        }
                                                    } else if (c2 == 's') {
                                                        if (c7 == 'c' || c7 == 's' || c7 == 'C' || c7 == 'S') {
                                                            f13 = f24 - f20;
                                                            f14 = f23 - f19;
                                                        } else {
                                                            f14 = 0.0f;
                                                            f13 = 0.0f;
                                                        }
                                                        int i16 = i4 + 1;
                                                        int i17 = i4 + 2;
                                                        int i18 = i4 + 3;
                                                        path2.rCubicTo(f14, f13, fArr2[i4], fArr2[i16], fArr2[i17], fArr2[i18]);
                                                        f7 = fArr2[i4] + f23;
                                                        f8 = fArr2[i16] + f24;
                                                        f23 += fArr2[i17];
                                                        f9 = fArr2[i18];
                                                    } else if (c2 == 't') {
                                                        if (c7 == 'q' || c7 == 't' || c7 == 'Q' || c7 == 'T') {
                                                            f15 = f23 - f19;
                                                            f16 = f24 - f20;
                                                        } else {
                                                            f16 = 0.0f;
                                                            f15 = 0.0f;
                                                        }
                                                        int i19 = i4 + 1;
                                                        path2.rQuadTo(f15, f16, fArr2[i4], fArr2[i19]);
                                                        float f41 = f15 + f23;
                                                        float f42 = f16 + f24;
                                                        f23 += fArr2[i4];
                                                        f24 += fArr2[i19];
                                                        f20 = f42;
                                                        f19 = f41;
                                                    }
                                                } else {
                                                    c4 = c6;
                                                    f11 = fArr2[i4];
                                                    f12 = fArr2[i4 + 1];
                                                    if (i4 > 0) {
                                                        path2.lineTo(f11, f12);
                                                    } else {
                                                        path2.moveTo(f11, f12);
                                                        f23 = f11;
                                                        f25 = f23;
                                                        f24 = f12;
                                                    }
                                                }
                                                f26 = f24;
                                            } else {
                                                c4 = c6;
                                                int i20 = i4 + 1;
                                                path2.lineTo(fArr2[i4], fArr2[i20]);
                                                f11 = fArr2[i4];
                                                f12 = fArr2[i20];
                                            }
                                            f23 = f11;
                                            f24 = f12;
                                        } else {
                                            c4 = c6;
                                            path2.rLineTo(0.0f, fArr2[i4]);
                                            f10 = fArr2[i4];
                                        }
                                        f24 += f10;
                                    } else {
                                        c3 = c5;
                                        c4 = c6;
                                        int i21 = i4 + 1;
                                        int i22 = i4 + 2;
                                        int i23 = i4 + 3;
                                        path2.rQuadTo(fArr2[i4], fArr2[i21], fArr2[i22], fArr2[i23]);
                                        f7 = fArr2[i4] + f23;
                                        f8 = fArr2[i21] + f24;
                                        f23 += fArr2[i22];
                                        f9 = fArr2[i23];
                                    }
                                    f24 += f9;
                                    f19 = f7;
                                    f20 = f8;
                                } else {
                                    c3 = c5;
                                    c4 = c6;
                                    path2.rLineTo(fArr2[i4], 0.0f);
                                    f23 += fArr2[i4];
                                }
                            } else {
                                z2 = z6;
                                c3 = c5;
                                c4 = c6;
                                int i24 = i4 + 2;
                                int i25 = i4 + 3;
                                int i26 = i4 + 4;
                                int i27 = i4 + 5;
                                path2.rCubicTo(fArr2[i4], fArr2[i4 + 1], fArr2[i24], fArr2[i25], fArr2[i26], fArr2[i27]);
                                float f43 = fArr2[i24] + f23;
                                float f44 = fArr2[i25] + f24;
                                f23 += fArr2[i26];
                                f24 += fArr2[i27];
                                f19 = f43;
                                f20 = f44;
                            }
                            i3 = i4;
                        } else {
                            z2 = z6;
                            c3 = c5;
                            c4 = c6;
                            int i28 = i4 + 5;
                            float f45 = fArr2[i28] + f23;
                            int i29 = i4 + 6;
                            float f46 = fArr2[i29] + f24;
                            float f47 = fArr2[i4];
                            float f48 = fArr2[i4 + 1];
                            float f49 = fArr2[i4 + 2];
                            if (fArr2[i4 + 3] != 0.0f) {
                                f5 = 0.0f;
                                f6 = f24;
                                z4 = z2;
                            } else {
                                f5 = 0.0f;
                                f6 = f24;
                                z4 = z;
                            }
                            i3 = i4;
                            boolean z7 = fArr2[i4 + 4] != f5 ? z2 : z;
                            float f50 = f23;
                            drawArc(path, f50, f6, f45, f46, f47, f48, f49, z4, z7);
                            f23 = f50 + fArr2[i28];
                            f24 = f6 + fArr2[i29];
                            f19 = f23;
                            f20 = f24;
                        }
                        f24 = f4;
                    } else {
                        z = z5;
                        z2 = z6;
                        c3 = c5;
                        c4 = c6;
                        i3 = i4;
                        int i30 = i3 + 1;
                        int i31 = i3 + 2;
                        int i32 = i3 + 3;
                        path2.quadTo(fArr2[i3], fArr2[i30], fArr2[i31], fArr2[i32]);
                        f2 = fArr2[i3];
                        f3 = fArr2[i30];
                        f23 = fArr2[i31];
                        f24 = fArr2[i32];
                    }
                    f19 = f2;
                    f20 = f3;
                } else {
                    z = z5;
                    z2 = z6;
                    c3 = c5;
                    c4 = c6;
                    i3 = i4;
                    path2.lineTo(fArr2[i3], f24);
                    f23 = fArr2[i3];
                }
                i4 = i3 + i2;
                path2 = path;
                c7 = c2;
                z5 = z;
                z6 = z2;
                c5 = c3;
                c6 = c4;
            }
            fArr[z5 ? 1 : 0] = f23;
            fArr[z6 ? 1 : 0] = f24;
            fArr[c5] = f19;
            fArr[c6] = f20;
            fArr[4] = f25;
            fArr[5] = f26;
        }

        private static void drawArc(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            double d;
            double d2;
            double radians = Math.toRadians(f7);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d3 = f;
            double d4 = f2;
            double d5 = f5;
            double d6 = ((d3 * cos) + (d4 * sin)) / d5;
            double d7 = f6;
            double d8 = (((-f) * sin) + (d4 * cos)) / d7;
            double d9 = f4;
            double d10 = ((f3 * cos) + (d9 * sin)) / d5;
            double d11 = (((-f3) * sin) + (d9 * cos)) / d7;
            double d12 = d6 - d10;
            double d13 = d8 - d11;
            double d14 = (d6 + d10) / 2.0d;
            double d15 = (d8 + d11) / 2.0d;
            double d16 = (d12 * d12) + (d13 * d13);
            if (d16 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                Log.w(PathParser.LOGTAG, " Points are coincident");
                return;
            }
            double d17 = (1.0d / d16) - 0.25d;
            if (d17 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                Log.w(PathParser.LOGTAG, "Points are too far apart " + d16);
                float sqrt = (float) (Math.sqrt(d16) / 1.99999d);
                drawArc(path, f, f2, f3, f4, f5 * sqrt, sqrt * f6, f7, z, z2);
                return;
            }
            double sqrt2 = Math.sqrt(d17);
            double d18 = d12 * sqrt2;
            double d19 = sqrt2 * d13;
            if (z == z2) {
                d = d14 - d19;
                d2 = d15 + d18;
            } else {
                d = d14 + d19;
                d2 = d15 - d18;
            }
            double atan2 = Math.atan2(d8 - d2, d6 - d);
            double atan22 = Math.atan2(d11 - d2, d10 - d) - atan2;
            int i = (atan22 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (atan22 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1));
            if (z2 != (i >= 0)) {
                atan22 = i > 0 ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            double d20 = d * d5;
            double d21 = d2 * d7;
            arcToBezier(path, (d20 * cos) - (d21 * sin), (d20 * sin) + (d21 * cos), d5, d7, d3, d4, radians, atan2, atan22);
        }

        private static void arcToBezier(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            double d10 = d3;
            int ceil = (int) Math.ceil(Math.abs((d9 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d7);
            double sin = Math.sin(d7);
            double cos2 = Math.cos(d8);
            double sin2 = Math.sin(d8);
            double d11 = -d10;
            double d12 = d11 * cos;
            double d13 = d4 * sin;
            double d14 = (d12 * sin2) - (d13 * cos2);
            double d15 = d11 * sin;
            double d16 = d4 * cos;
            double d17 = (sin2 * d15) + (cos2 * d16);
            double d18 = d9 / ceil;
            double d19 = d17;
            double d20 = d14;
            int i = 0;
            double d21 = d5;
            double d22 = d6;
            double d23 = d8;
            while (i < ceil) {
                double d24 = d23 + d18;
                double sin3 = Math.sin(d24);
                double cos3 = Math.cos(d24);
                double d25 = (d + ((d10 * cos) * cos3)) - (d13 * sin3);
                int i2 = i;
                double d26 = d2 + (d3 * sin * cos3) + (d16 * sin3);
                double d27 = (d12 * sin3) - (d13 * cos3);
                double d28 = (sin3 * d15) + (cos3 * d16);
                double d29 = d24 - d23;
                double tan = Math.tan(d29 / 2.0d);
                double sin4 = (Math.sin(d29) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                double d30 = d21 + (d20 * sin4);
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) d30, (float) (d22 + (d19 * sin4)), (float) (d25 - (sin4 * d27)), (float) (d26 - (sin4 * d28)), (float) d25, (float) d26);
                sin = sin;
                d18 = d18;
                d21 = d25;
                d15 = d15;
                d23 = d24;
                d19 = d28;
                cos = cos;
                d10 = d3;
                d22 = d26;
                i = i2 + 1;
                ceil = ceil;
                d20 = d27;
            }
        }
    }

    private PathParser() {
    }
}
