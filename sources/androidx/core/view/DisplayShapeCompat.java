package androidx.core.view;

import android.graphics.Matrix;
import android.graphics.Path;
import android.view.DisplayShape;
import androidx.core.graphics.PathParser;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* loaded from: classes2.dex */
public final class DisplayShapeCompat {
    static final DisplayShapeCompat EMPTY = new DisplayShapeCompat("", 0, 0, 1.0f, 0, 0, 0, 1.0f);
    private static final String TAG = "DisplayShapeCompat";
    private final Impl mImpl;

    /* loaded from: classes2.dex */
    private interface Impl {
        Path getPath();

        DisplayShape getPlatformDisplayShape();
    }

    private DisplayShapeCompat(DisplayShape displayShape) {
        this.mImpl = new Impl34(displayShape);
    }

    private DisplayShapeCompat(String str, int i, int i2, float f, int i3, int i4, int i5, float f2) {
        this.mImpl = new ImplBase(str, i, i2, f, i3, i4, i5, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DisplayShapeCompat toDisplayShapeCompat(DisplayShape displayShape) {
        if (displayShape == null) {
            return null;
        }
        return new DisplayShapeCompat(displayShape);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DisplayShape toPlatformDisplayShape(DisplayShapeCompat displayShapeCompat) {
        if (displayShapeCompat == null) {
            return null;
        }
        return displayShapeCompat.mImpl.getPlatformDisplayShape();
    }

    public static DisplayShapeCompat create(String str, float f, int i, int i2) {
        return new DisplayShapeCompat(str, i, i2, f, 0, 0, 0, 1.0f);
    }

    public static DisplayShapeCompat create(int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
        return new DisplayShapeCompat(createSpecString(i, i2, z, i3, i4, i5, i6), i, i2, 1.0f, 0, 0, 0, 1.0f);
    }

    private static String createSpecString(int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
        if (z) {
            int i7 = i / 2;
            int i8 = i2 / 2;
            return "M0," + i8 + " A" + i7 + StringUtils.COMMA + i8 + " 0 1,1 " + i + StringUtils.COMMA + i8 + " A" + i7 + StringUtils.COMMA + i8 + " 0 1,1 0," + i8 + " Z";
        }
        StringBuilder sb = new StringBuilder("M ");
        int min = Math.min(i / 2, i2 / 2);
        int min2 = Math.min(min, i3);
        int min3 = Math.min(min, i4);
        int min4 = Math.min(min, i5);
        int min5 = Math.min(min, i6);
        sb.append(min2).append(",0 L ");
        sb.append(i - min3).append(",0");
        if (min3 > 0) {
            sb.append(" A ").append(min3).append(StringUtils.COMMA).append(min3).append(" 0 0,1 ").append(i).append(StringUtils.COMMA).append(min3);
        }
        sb.append(" L ").append(i).append(StringUtils.COMMA).append(i2 - min4);
        if (min4 > 0) {
            sb.append(" A ").append(min4).append(StringUtils.COMMA).append(min4).append(" 0 0,1 ").append(i - min4).append(StringUtils.COMMA).append(i2);
        }
        sb.append(" L ").append(min5).append(StringUtils.COMMA).append(i2);
        if (min5 > 0) {
            sb.append(" A ").append(min5).append(StringUtils.COMMA).append(min5).append(" 0 0,1 0,").append(i2 - min5);
        }
        if (min2 > 0) {
            sb.append(" L 0,").append(min2);
            sb.append(" A ").append(min2).append(StringUtils.COMMA).append(min2).append(" 0 0,1 ").append(min2).append(",0");
        }
        sb.append(" Z");
        return sb.toString();
    }

    public Path getPath() {
        return this.mImpl.getPath();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DisplayShapeCompat) {
            return Objects.equals(this.mImpl, ((DisplayShapeCompat) obj).mImpl);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.mImpl);
    }

    public String toString() {
        return this.mImpl.toString();
    }

    /* loaded from: classes2.dex */
    private static class ImplBase implements Impl {
        private Path mCachedPath;
        private final int mDisplayHeight;
        private final String mDisplayShapeSpec;
        private final int mDisplayWidth;
        private final int mOffsetX;
        private final int mOffsetY;
        private final float mPhysicalPixelDisplaySizeRatio;
        private final int mRotation;
        private final float mScale;

        @Override // androidx.core.view.DisplayShapeCompat.Impl
        public DisplayShape getPlatformDisplayShape() {
            return null;
        }

        ImplBase(String str, int i, int i2, float f, int i3, int i4, int i5, float f2) {
            this.mDisplayShapeSpec = str;
            this.mDisplayWidth = i;
            this.mDisplayHeight = i2;
            this.mPhysicalPixelDisplaySizeRatio = f;
            this.mRotation = i3;
            this.mOffsetX = i4;
            this.mOffsetY = i5;
            this.mScale = f2;
        }

        @Override // androidx.core.view.DisplayShapeCompat.Impl
        public Path getPath() {
            float f;
            float f2;
            float f3;
            float f4;
            Path path = this.mCachedPath;
            if (path != null) {
                return path;
            }
            String str = this.mDisplayShapeSpec;
            if (str == null || str.isEmpty()) {
                return new Path();
            }
            try {
                Path createPathFromPathData = PathParser.createPathFromPathData(this.mDisplayShapeSpec);
                if (!createPathFromPathData.isEmpty()) {
                    Matrix matrix = new Matrix();
                    int i = this.mRotation;
                    if (i != 0) {
                        float f5 = 0.0f;
                        if (i != 1) {
                            if (i == 2) {
                                f5 = this.mDisplayWidth;
                                f3 = this.mDisplayHeight;
                                f4 = 180.0f;
                            } else if (i != 3) {
                                f = 0.0f;
                                f2 = 0.0f;
                            } else {
                                f3 = this.mDisplayHeight;
                                f4 = 270.0f;
                            }
                            float f6 = f4;
                            f2 = f3;
                            f = f5;
                            f5 = f6;
                        } else {
                            f = this.mDisplayWidth;
                            f5 = 90.0f;
                            f2 = 0.0f;
                        }
                        matrix.preRotate(f5, f, f2);
                    }
                    float f7 = this.mPhysicalPixelDisplaySizeRatio;
                    if (f7 != 1.0f) {
                        matrix.preScale(f7, f7);
                    }
                    int i2 = this.mOffsetX;
                    if (i2 != 0 || this.mOffsetY != 0) {
                        matrix.postTranslate(i2, this.mOffsetY);
                    }
                    float f8 = this.mScale;
                    if (f8 != 1.0f) {
                        matrix.postScale(f8, f8);
                    }
                    createPathFromPathData.transform(matrix);
                }
                this.mCachedPath = createPathFromPathData;
                return createPathFromPathData;
            } catch (RuntimeException e) {
                throw new IllegalArgumentException("Failed to parse DisplayShapeCompat path data: " + this.mDisplayShapeSpec, e);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ImplBase) {
                ImplBase implBase = (ImplBase) obj;
                return Objects.equals(this.mDisplayShapeSpec, implBase.mDisplayShapeSpec) && this.mDisplayWidth == implBase.mDisplayWidth && this.mDisplayHeight == implBase.mDisplayHeight && this.mPhysicalPixelDisplaySizeRatio == implBase.mPhysicalPixelDisplaySizeRatio && this.mRotation == implBase.mRotation && this.mOffsetX == implBase.mOffsetX && this.mOffsetY == implBase.mOffsetY && this.mScale == implBase.mScale;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(this.mDisplayShapeSpec, Integer.valueOf(this.mDisplayWidth), Integer.valueOf(this.mDisplayHeight), Float.valueOf(this.mPhysicalPixelDisplaySizeRatio), Integer.valueOf(this.mRotation), Integer.valueOf(this.mOffsetX), Integer.valueOf(this.mOffsetY), Float.valueOf(this.mScale));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("DisplayShapeCompat{ spec=");
            String str = this.mDisplayShapeSpec;
            return sb.append(str != null ? Integer.valueOf(str.hashCode()) : AbstractJsonLexerKt.NULL).append(" displayWidth=").append(this.mDisplayWidth).append(" displayHeight=").append(this.mDisplayHeight).append(" physicalPixelDisplaySizeRatio=").append(this.mPhysicalPixelDisplaySizeRatio).append(" rotation=").append(this.mRotation).append(" offsetX=").append(this.mOffsetX).append(" offsetY=").append(this.mOffsetY).append(" scale=").append(this.mScale).append("}").toString();
        }
    }

    /* loaded from: classes2.dex */
    private static class Impl34 implements Impl {
        private final DisplayShape mPlatformDisplayShape;

        Impl34(DisplayShape displayShape) {
            this.mPlatformDisplayShape = displayShape;
        }

        @Override // androidx.core.view.DisplayShapeCompat.Impl
        public Path getPath() {
            return this.mPlatformDisplayShape.getPath();
        }

        @Override // androidx.core.view.DisplayShapeCompat.Impl
        public DisplayShape getPlatformDisplayShape() {
            return this.mPlatformDisplayShape;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Impl34) {
                return Objects.equals(this.mPlatformDisplayShape, ((Impl34) obj).mPlatformDisplayShape);
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(this.mPlatformDisplayShape);
        }

        public String toString() {
            return "DisplayShapeCompat{mPlatformDisplayShape=" + this.mPlatformDisplayShape + AbstractJsonLexerKt.END_OBJ;
        }
    }
}
