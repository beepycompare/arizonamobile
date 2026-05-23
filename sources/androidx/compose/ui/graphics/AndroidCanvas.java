package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.Region;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.IntOffset;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidCanvas.android.kt */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0018H\u0016J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0018H\u0016J\u0018\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0018H\u0016J\u0017\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$J7\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020+H\u0016¢\u0006\u0004\b,\u0010-J\u001f\u0010.\u001a\u00020\u000f2\u0006\u0010/\u001a\u0002002\u0006\u0010*\u001a\u00020+H\u0016¢\u0006\u0004\b1\u00102J\u0011\u00103\u001a\u000204*\u00020+¢\u0006\u0004\b5\u00106J'\u00107\u001a\u00020\u000f2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002092\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\b;\u0010<J0\u0010=\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J@\u0010>\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u00182\u0006\u0010?\u001a\u00020\u00182\u0006\u0010@\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J0\u0010A\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J'\u0010B\u001a\u00020\u000f2\u0006\u0010C\u001a\u0002092\u0006\u0010D\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\bE\u0010FJH\u0010G\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u00182\u0006\u0010H\u001a\u00020\u00182\u0006\u0010I\u001a\u00020\u00182\u0006\u0010J\u001a\u00020K2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010L\u001a\u00020\u000f2\u0006\u0010/\u001a\u0002002\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J'\u0010M\u001a\u00020\u000f2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u0002092\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\bQ\u0010RJ?\u0010S\u001a\u00020\u000f2\u0006\u0010N\u001a\u00020O2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020U2\u0006\u0010Y\u001a\u00020W2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\bZ\u0010[J-\u0010\\\u001a\u00020\u000f2\u0006\u0010]\u001a\u00020^2\f\u0010_\u001a\b\u0012\u0004\u0012\u0002090`2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\ba\u0010bJ\b\u0010c\u001a\u00020\u000fH\u0016J\b\u0010d\u001a\u00020\u000fH\u0016J\u001e\u0010\\\u001a\u00020\u000f2\f\u0010_\u001a\b\u0012\u0004\u0012\u0002090`2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J&\u0010e\u001a\u00020\u000f2\f\u0010_\u001a\b\u0012\u0004\u0012\u0002090`2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010f\u001a\u00020gH\u0002J'\u0010h\u001a\u00020\u000f2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020i2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\bj\u0010kJ \u0010h\u001a\u00020\u000f2\u0006\u0010_\u001a\u00020i2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010f\u001a\u00020gH\u0002J \u0010l\u001a\u00020\u000f2\u0006\u0010_\u001a\u00020i2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010f\u001a\u00020gH\u0002J'\u0010m\u001a\u00020\u000f2\u0006\u0010n\u001a\u00020o2\u0006\u0010p\u001a\u00020q2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\br\u0010sR$\u0010\u0004\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006t"}, d2 = {"Landroidx/compose/ui/graphics/AndroidCanvas;", "Landroidx/compose/ui/graphics/Canvas;", "<init>", "()V", "internalCanvas", "Landroid/graphics/Canvas;", "getInternalCanvas$annotations", "getInternalCanvas", "()Landroid/graphics/Canvas;", "setInternalCanvas", "(Landroid/graphics/Canvas;)V", "srcRect", "Landroid/graphics/Rect;", "dstRect", "save", "", "restore", "saveLayer", "bounds", "Landroidx/compose/ui/geometry/Rect;", "paint", "Landroidx/compose/ui/graphics/Paint;", "translate", "dx", "", "dy", "scale", "sx", "sy", "rotate", "degrees", "skew", "concat", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "concat-58bKbWc", "([F)V", "clipRect", TtmlNode.LEFT, "top", TtmlNode.RIGHT, "bottom", "clipOp", "Landroidx/compose/ui/graphics/ClipOp;", "clipRect-N_I0leg", "(FFFFI)V", "clipPath", "path", "Landroidx/compose/ui/graphics/Path;", "clipPath-mtrdD-E", "(Landroidx/compose/ui/graphics/Path;I)V", "toRegionOp", "Landroid/graphics/Region$Op;", "toRegionOp--7u2Bmg", "(I)Landroid/graphics/Region$Op;", "drawLine", "p1", "Landroidx/compose/ui/geometry/Offset;", "p2", "drawLine-Wko1d7g", "(JJLandroidx/compose/ui/graphics/Paint;)V", "drawRect", "drawRoundRect", "radiusX", "radiusY", "drawOval", "drawCircle", TtmlNode.CENTER, "radius", "drawCircle-9KIMszo", "(JFLandroidx/compose/ui/graphics/Paint;)V", "drawArc", "startAngle", "sweepAngle", "useCenter", "", "drawPath", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "topLeftOffset", "drawImage-d-4ec7I", "(Landroidx/compose/ui/graphics/ImageBitmap;JLandroidx/compose/ui/graphics/Paint;)V", "drawImageRect", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImageRect-HPBpro0", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJLandroidx/compose/ui/graphics/Paint;)V", "drawPoints", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "points", "", "drawPoints-O7TthRY", "(ILjava/util/List;Landroidx/compose/ui/graphics/Paint;)V", "enableZ", "disableZ", "drawLines", "stepBy", "", "drawRawPoints", "", "drawRawPoints-O7TthRY", "(I[FLandroidx/compose/ui/graphics/Paint;)V", "drawRawLines", "drawVertices", "vertices", "Landroidx/compose/ui/graphics/Vertices;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawVertices-TPEHhCM", "(Landroidx/compose/ui/graphics/Vertices;ILandroidx/compose/ui/graphics/Paint;)V", "ui-graphics"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AndroidCanvas implements Canvas {
    public static final int $stable = 8;
    private Rect dstRect;
    private android.graphics.Canvas internalCanvas;
    private Rect srcRect;

    public static /* synthetic */ void getInternalCanvas$annotations() {
    }

    public AndroidCanvas() {
        android.graphics.Canvas canvas;
        canvas = AndroidCanvas_androidKt.EmptyCanvas;
        this.internalCanvas = canvas;
    }

    public final android.graphics.Canvas getInternalCanvas() {
        return this.internalCanvas;
    }

    public final void setInternalCanvas(android.graphics.Canvas canvas) {
        this.internalCanvas = canvas;
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void save() {
        this.internalCanvas.save();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void restore() {
        this.internalCanvas.restore();
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void saveLayer(androidx.compose.ui.geometry.Rect rect, Paint paint) {
        this.internalCanvas.saveLayer(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom(), AndroidPaint_androidKt.getNativePaint(paint), 31);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void translate(float f, float f2) {
        this.internalCanvas.translate(f, f2);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void scale(float f, float f2) {
        this.internalCanvas.scale(f, f2);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void rotate(float f) {
        this.internalCanvas.rotate(f);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void skew(float f, float f2) {
        this.internalCanvas.skew(f, f2);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* renamed from: concat-58bKbWc  reason: not valid java name */
    public void mo5199concat58bKbWc(float[] fArr) {
        if (MatrixKt.m5617isIdentity58bKbWc(fArr)) {
            return;
        }
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        AndroidMatrixConversions_androidKt.m5215setFromEL8BTi8(matrix, fArr);
        this.internalCanvas.concat(matrix);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* renamed from: clipRect-N_I0leg  reason: not valid java name */
    public void mo5198clipRectN_I0leg(float f, float f2, float f3, float f4, int i) {
        this.internalCanvas.clipRect(f, f2, f3, f4, m5207toRegionOp7u2Bmg(i));
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* renamed from: clipPath-mtrdD-E  reason: not valid java name */
    public void mo5197clipPathmtrdDE(Path path, int i) {
        android.graphics.Canvas canvas = this.internalCanvas;
        if (path instanceof AndroidPath) {
            canvas.clipPath(((AndroidPath) path).getInternalPath(), m5207toRegionOp7u2Bmg(i));
            return;
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    /* renamed from: toRegionOp--7u2Bmg  reason: not valid java name */
    public final Region.Op m5207toRegionOp7u2Bmg(int i) {
        return ClipOp.m5332equalsimpl0(i, ClipOp.Companion.m5336getDifferencertfAjoo()) ? Region.Op.DIFFERENCE : Region.Op.INTERSECT;
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* renamed from: drawLine-Wko1d7g  reason: not valid java name */
    public void mo5203drawLineWko1d7g(long j, long j2, Paint paint) {
        this.internalCanvas.drawLine(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)), Float.intBitsToFloat((int) (j2 >> 32)), Float.intBitsToFloat((int) (j2 & 4294967295L)), AndroidPaint_androidKt.getNativePaint(paint));
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawRect(float f, float f2, float f3, float f4, Paint paint) {
        this.internalCanvas.drawRect(f, f2, f3, f4, AndroidPaint_androidKt.getNativePaint(paint));
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawRoundRect(float f, float f2, float f3, float f4, float f5, float f6, Paint paint) {
        this.internalCanvas.drawRoundRect(f, f2, f3, f4, f5, f6, AndroidPaint_androidKt.getNativePaint(paint));
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawOval(float f, float f2, float f3, float f4, Paint paint) {
        this.internalCanvas.drawOval(f, f2, f3, f4, AndroidPaint_androidKt.getNativePaint(paint));
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* renamed from: drawCircle-9KIMszo  reason: not valid java name */
    public void mo5200drawCircle9KIMszo(long j, float f, Paint paint) {
        this.internalCanvas.drawCircle(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)), f, AndroidPaint_androidKt.getNativePaint(paint));
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawArc(float f, float f2, float f3, float f4, float f5, float f6, boolean z, Paint paint) {
        this.internalCanvas.drawArc(f, f2, f3, f4, f5, f6, z, AndroidPaint_androidKt.getNativePaint(paint));
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void drawPath(Path path, Paint paint) {
        android.graphics.Canvas canvas = this.internalCanvas;
        if (path instanceof AndroidPath) {
            canvas.drawPath(((AndroidPath) path).getInternalPath(), AndroidPaint_androidKt.getNativePaint(paint));
            return;
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* renamed from: drawImage-d-4ec7I  reason: not valid java name */
    public void mo5201drawImaged4ec7I(ImageBitmap imageBitmap, long j, Paint paint) {
        this.internalCanvas.drawBitmap(AndroidImageBitmap_androidKt.asAndroidBitmap(imageBitmap), Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)), AndroidPaint_androidKt.getNativePaint(paint));
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* renamed from: drawImageRect-HPBpro0  reason: not valid java name */
    public void mo5202drawImageRectHPBpro0(ImageBitmap imageBitmap, long j, long j2, long j3, long j4, Paint paint) {
        if (this.srcRect == null) {
            this.srcRect = new Rect();
            this.dstRect = new Rect();
        }
        android.graphics.Canvas canvas = this.internalCanvas;
        Bitmap asAndroidBitmap = AndroidImageBitmap_androidKt.asAndroidBitmap(imageBitmap);
        Rect rect = this.srcRect;
        Intrinsics.checkNotNull(rect);
        rect.left = IntOffset.m8288getXimpl(j);
        rect.top = IntOffset.m8289getYimpl(j);
        rect.right = IntOffset.m8288getXimpl(j) + ((int) (j2 >> 32));
        rect.bottom = IntOffset.m8289getYimpl(j) + ((int) (j2 & 4294967295L));
        Unit unit = Unit.INSTANCE;
        Rect rect2 = this.dstRect;
        Intrinsics.checkNotNull(rect2);
        rect2.left = IntOffset.m8288getXimpl(j3);
        rect2.top = IntOffset.m8289getYimpl(j3);
        rect2.right = IntOffset.m8288getXimpl(j3) + ((int) (j4 >> 32));
        rect2.bottom = IntOffset.m8289getYimpl(j3) + ((int) (j4 & 4294967295L));
        Unit unit2 = Unit.INSTANCE;
        canvas.drawBitmap(asAndroidBitmap, rect, rect2, AndroidPaint_androidKt.getNativePaint(paint));
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* renamed from: drawPoints-O7TthRY  reason: not valid java name */
    public void mo5204drawPointsO7TthRY(int i, List<Offset> list, Paint paint) {
        if (PointMode.m5663equalsimpl0(i, PointMode.Companion.m5667getLinesr_lszbg())) {
            drawLines(list, paint, 2);
        } else if (PointMode.m5663equalsimpl0(i, PointMode.Companion.m5669getPolygonr_lszbg())) {
            drawLines(list, paint, 1);
        } else if (PointMode.m5663equalsimpl0(i, PointMode.Companion.m5668getPointsr_lszbg())) {
            drawPoints(list, paint);
        }
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void enableZ() {
        CanvasUtils.INSTANCE.enableZ(this.internalCanvas, true);
    }

    @Override // androidx.compose.ui.graphics.Canvas
    public void disableZ() {
        CanvasUtils.INSTANCE.enableZ(this.internalCanvas, false);
    }

    private final void drawLines(List<Offset> list, Paint paint, int i) {
        if (list.size() >= 2) {
            android.graphics.Paint nativePaint = AndroidPaint_androidKt.getNativePaint(paint);
            int i2 = 0;
            while (i2 < list.size() - 1) {
                long m5113unboximpl = list.get(i2).m5113unboximpl();
                long m5113unboximpl2 = list.get(i2 + 1).m5113unboximpl();
                this.internalCanvas.drawLine(Float.intBitsToFloat((int) (m5113unboximpl >> 32)), Float.intBitsToFloat((int) (m5113unboximpl & 4294967295L)), Float.intBitsToFloat((int) (m5113unboximpl2 >> 32)), Float.intBitsToFloat((int) (m5113unboximpl2 & 4294967295L)), nativePaint);
                i2 += i;
            }
        }
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* renamed from: drawRawPoints-O7TthRY  reason: not valid java name */
    public void mo5205drawRawPointsO7TthRY(int i, float[] fArr, Paint paint) {
        if (fArr.length % 2 != 0) {
            throw new IllegalArgumentException("points must have an even number of values");
        }
        if (PointMode.m5663equalsimpl0(i, PointMode.Companion.m5667getLinesr_lszbg())) {
            drawRawLines(fArr, paint, 2);
        } else if (PointMode.m5663equalsimpl0(i, PointMode.Companion.m5669getPolygonr_lszbg())) {
            drawRawLines(fArr, paint, 1);
        } else if (PointMode.m5663equalsimpl0(i, PointMode.Companion.m5668getPointsr_lszbg())) {
            drawRawPoints(fArr, paint, 2);
        }
    }

    private final void drawRawPoints(float[] fArr, Paint paint, int i) {
        if (fArr.length % 2 == 0) {
            android.graphics.Paint nativePaint = AndroidPaint_androidKt.getNativePaint(paint);
            int i2 = 0;
            while (i2 < fArr.length - 1) {
                this.internalCanvas.drawPoint(fArr[i2], fArr[i2 + 1], nativePaint);
                i2 += i;
            }
        }
    }

    private final void drawRawLines(float[] fArr, Paint paint, int i) {
        if (fArr.length < 4 || fArr.length % 2 != 0) {
            return;
        }
        android.graphics.Paint nativePaint = AndroidPaint_androidKt.getNativePaint(paint);
        int i2 = 0;
        while (i2 < fArr.length - 3) {
            this.internalCanvas.drawLine(fArr[i2], fArr[i2 + 1], fArr[i2 + 2], fArr[i2 + 3], nativePaint);
            i2 += i * 2;
        }
    }

    @Override // androidx.compose.ui.graphics.Canvas
    /* renamed from: drawVertices-TPEHhCM  reason: not valid java name */
    public void mo5206drawVerticesTPEHhCM(Vertices vertices, int i, Paint paint) {
        this.internalCanvas.drawVertices(AndroidVertexMode_androidKt.m5252toAndroidVertexModeJOOmi9M(vertices.m5773getVertexModec2xauaI()), vertices.getPositions().length, vertices.getPositions(), 0, vertices.getTextureCoordinates(), 0, vertices.getColors(), 0, vertices.getIndices(), 0, vertices.getIndices().length, AndroidPaint_androidKt.getNativePaint(paint));
    }

    private final void drawPoints(List<Offset> list, Paint paint) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            long m5113unboximpl = list.get(i).m5113unboximpl();
            this.internalCanvas.drawPoint(Float.intBitsToFloat((int) (m5113unboximpl >> 32)), Float.intBitsToFloat((int) (m5113unboximpl & 4294967295L)), AndroidPaint_androidKt.getNativePaint(paint));
        }
    }
}
