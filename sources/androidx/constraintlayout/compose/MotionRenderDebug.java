package androidx.constraintlayout.compose;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import androidx.constraintlayout.core.motion.Motion;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.internal.view.SupportMenu;
import com.arizona.launcher.UpdateActivity;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MotionRenderDebug.kt */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0014\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0019\b\u0000\u0018\u0000 z2\u00020\u0001:\u0001zB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J>\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\u00122\u0006\u0010Y\u001a\u00020\u00122\u0006\u0010Z\u001a\u00020\u00122\u0006\u0010[\u001a\u00020B2\u0006\u0010\\\u001a\u00020BJ6\u0010]\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020\u00122\u0006\u0010^\u001a\u00020\u00122\u0006\u0010Y\u001a\u00020\u00122\u0006\u0010Z\u001a\u00020\u0012JZ\u0010]\u001a\u00020S2\u0006\u0010T\u001a\u00020U2*\u0010_\u001a&\u0012\u0006\u0012\u0004\u0018\u00010a\u0012\u0004\u0012\u00020W\u0018\u00010`j\u0012\u0012\u0006\u0012\u0004\u0018\u00010a\u0012\u0004\u0012\u00020W\u0018\u0001`b2\u0006\u0010X\u001a\u00020\u00122\u0006\u0010^\u001a\u00020\u00122\u0006\u0010Y\u001a\u00020\u00122\u0006\u0010Z\u001a\u00020\u0012J6\u0010c\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010d\u001a\u00020\u00122\u0006\u0010e\u001a\u00020\u00122\u0006\u0010V\u001a\u00020W2\u0006\u0010Y\u001a\u00020\u00122\u0006\u0010Z\u001a\u00020\u0012J\u0010\u0010f\u001a\u00020S2\u0006\u0010T\u001a\u00020UH\u0002J\u0010\u0010g\u001a\u00020S2\u0006\u0010T\u001a\u00020UH\u0002J\u0010\u0010h\u001a\u00020S2\u0006\u0010T\u001a\u00020UH\u0002J \u0010i\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010j\u001a\u00020\u00032\u0006\u0010k\u001a\u00020\u0003H\u0002J\u0010\u0010l\u001a\u00020S2\u0006\u0010T\u001a\u00020UH\u0002J \u0010m\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010j\u001a\u00020\u00032\u0006\u0010k\u001a\u00020\u0003H\u0002J@\u0010n\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010j\u001a\u00020\u00032\u0006\u0010k\u001a\u00020\u00032\u0006\u0010o\u001a\u00020\u00122\u0006\u0010p\u001a\u00020\u00122\u0006\u0010Y\u001a\u00020\u00122\u0006\u0010Z\u001a\u00020\u0012H\u0002J\u0018\u0010q\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020WH\u0002J8\u0010\\\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010d\u001a\u00020\u00122\u0006\u0010e\u001a\u00020\u00122\u0006\u0010V\u001a\u00020W2\u0006\u0010Y\u001a\u00020\u00122\u0006\u0010Z\u001a\u00020\u0012H\u0002J0\u0010r\u001a\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010s\u001a\u00020\u00032\u0006\u0010t\u001a\u00020\u00032\u0006\u0010u\u001a\u00020\u00032\u0006\u0010v\u001a\u00020\u0003H\u0002J\u0016\u0010w\u001a\u00020S2\u0006\u0010x\u001a\u00020a2\u0006\u0010y\u001a\u00020\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u0012X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u001a\u0010\u001d\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u0012X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0014R\u001a\u0010)\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0018\"\u0004\b+\u0010\u001aR\u001a\u0010,\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0018\"\u0004\b.\u0010\u001aR\u001a\u0010/\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0018\"\u0004\b1\u0010\u001aR\u001c\u00102\u001a\u0004\u0018\u000103X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u00108\u001a\u000209X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001c\u0010>\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010$\"\u0004\b@\u0010&R\u001a\u0010A\u001a\u00020BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u000e\u0010G\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010H\u001a\u00020\u0012X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u0014R\u0014\u0010J\u001a\u00020\u0012X\u0086D¢\u0006\b\n\u0000\u001a\u0004\bK\u0010\u0014R\u001a\u0010L\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0014\"\u0004\bN\u0010 R\u001a\u0010O\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0018\"\u0004\bQ\u0010\u001a¨\u0006{"}, d2 = {"Landroidx/constraintlayout/compose/MotionRenderDebug;", "", "textSize", "", "(F)V", "mBounds", "Landroid/graphics/Rect;", "getMBounds", "()Landroid/graphics/Rect;", "setMBounds", "(Landroid/graphics/Rect;)V", "mDashPathEffect", "Landroid/graphics/DashPathEffect;", "getMDashPathEffect", "()Landroid/graphics/DashPathEffect;", "setMDashPathEffect", "(Landroid/graphics/DashPathEffect;)V", "mDiamondSize", "", "getMDiamondSize", "()I", "mFillPaint", "Landroid/graphics/Paint;", "getMFillPaint", "()Landroid/graphics/Paint;", "setMFillPaint", "(Landroid/graphics/Paint;)V", "mGraphColor", "getMGraphColor", "mKeyFrameCount", "getMKeyFrameCount", "setMKeyFrameCount", "(I)V", "mKeyFramePoints", "", "getMKeyFramePoints", "()[F", "setMKeyFramePoints", "([F)V", "mKeyframeColor", "getMKeyframeColor", "mPaint", "getMPaint", "setMPaint", "mPaintGraph", "getMPaintGraph", "setMPaintGraph", "mPaintKeyframes", "getMPaintKeyframes", "setMPaintKeyframes", "mPath", "Landroid/graphics/Path;", "getMPath", "()Landroid/graphics/Path;", "setMPath", "(Landroid/graphics/Path;)V", "mPathMode", "", "getMPathMode", "()[I", "setMPathMode", "([I)V", "mPoints", "getMPoints", "setMPoints", "mPresentationMode", "", "getMPresentationMode", "()Z", "setMPresentationMode", "(Z)V", "mRectangle", "mRedColor", "getMRedColor", "mShadowColor", "getMShadowColor", "mShadowTranslate", "getMShadowTranslate", "setMShadowTranslate", "mTextPaint", "getMTextPaint", "setMTextPaint", "basicDraw", "", "canvas", "Landroid/graphics/Canvas;", "motionController", "Landroidx/constraintlayout/core/motion/Motion;", TypedValues.TransitionType.S_DURATION, "layoutWidth", "layoutHeight", "drawPath", "drawTicks", "draw", "debugPath", "frameArrayList", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "drawAll", UpdateActivity.UPDATE_MODE, "keyFrames", "drawBasicPath", "drawPathAsConfigured", "drawPathCartesian", "drawPathCartesianTicks", "x", "y", "drawPathRelative", "drawPathRelativeTicks", "drawPathScreenTicks", "viewWidth", "viewHeight", "drawRectangle", "drawTranslation", "x1", "y1", "x2", "y2", "getTextBounds", "text", "paint", "Companion", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MotionRenderDebug {
    private static final int DEBUG_PATH_TICKS_PER_MS = 16;
    public static final int DEBUG_SHOW_NONE = 0;
    public static final int DEBUG_SHOW_PATH = 2;
    public static final int DEBUG_SHOW_PROGRESS = 1;
    public static final int MAX_KEY_FRAMES = 50;
    private DashPathEffect mDashPathEffect;
    private Paint mFillPaint;
    private int mKeyFrameCount;
    private float[] mKeyFramePoints;
    private Paint mPaint;
    private Paint mPaintGraph;
    private Paint mPaintKeyframes;
    private Path mPath;
    private int[] mPathMode;
    private float[] mPoints;
    private boolean mPresentationMode;
    private final float[] mRectangle;
    private int mShadowTranslate;
    private Paint mTextPaint;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final int mRedColor = -21965;
    private final int mKeyframeColor = -2067046;
    private final int mGraphColor = -13391360;
    private final int mShadowColor = 1996488704;
    private final int mDiamondSize = 10;
    private Rect mBounds = new Rect();

    public MotionRenderDebug(float f) {
        this.mShadowTranslate = 1;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setColor(-21965);
        this.mPaint.setStrokeWidth(2.0f);
        this.mPaint.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.mPaintKeyframes = paint2;
        paint2.setAntiAlias(true);
        this.mPaintKeyframes.setColor(-2067046);
        this.mPaintKeyframes.setStrokeWidth(2.0f);
        this.mPaintKeyframes.setStyle(Paint.Style.STROKE);
        Paint paint3 = new Paint();
        this.mPaintGraph = paint3;
        paint3.setAntiAlias(true);
        this.mPaintGraph.setColor(-13391360);
        this.mPaintGraph.setStrokeWidth(2.0f);
        this.mPaintGraph.setStyle(Paint.Style.STROKE);
        Paint paint4 = new Paint();
        this.mTextPaint = paint4;
        paint4.setAntiAlias(true);
        this.mTextPaint.setColor(-13391360);
        this.mTextPaint.setTextSize(f);
        this.mRectangle = new float[8];
        Paint paint5 = new Paint();
        this.mFillPaint = paint5;
        paint5.setAntiAlias(true);
        DashPathEffect dashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
        this.mDashPathEffect = dashPathEffect;
        this.mPaintGraph.setPathEffect(dashPathEffect);
        this.mKeyFramePoints = new float[100];
        this.mPathMode = new int[50];
        if (this.mPresentationMode) {
            this.mPaint.setStrokeWidth(8.0f);
            this.mFillPaint.setStrokeWidth(8.0f);
            this.mPaintKeyframes.setStrokeWidth(8.0f);
            this.mShadowTranslate = 4;
        }
    }

    public final float[] getMPoints() {
        return this.mPoints;
    }

    public final void setMPoints(float[] fArr) {
        this.mPoints = fArr;
    }

    public final int[] getMPathMode() {
        return this.mPathMode;
    }

    public final void setMPathMode(int[] iArr) {
        this.mPathMode = iArr;
    }

    public final float[] getMKeyFramePoints() {
        return this.mKeyFramePoints;
    }

    public final void setMKeyFramePoints(float[] fArr) {
        this.mKeyFramePoints = fArr;
    }

    public final Path getMPath() {
        return this.mPath;
    }

    public final void setMPath(Path path) {
        this.mPath = path;
    }

    public final Paint getMPaint() {
        return this.mPaint;
    }

    public final void setMPaint(Paint paint) {
        this.mPaint = paint;
    }

    public final Paint getMPaintKeyframes() {
        return this.mPaintKeyframes;
    }

    public final void setMPaintKeyframes(Paint paint) {
        this.mPaintKeyframes = paint;
    }

    public final Paint getMPaintGraph() {
        return this.mPaintGraph;
    }

    public final void setMPaintGraph(Paint paint) {
        this.mPaintGraph = paint;
    }

    public final Paint getMTextPaint() {
        return this.mTextPaint;
    }

    public final void setMTextPaint(Paint paint) {
        this.mTextPaint = paint;
    }

    public final Paint getMFillPaint() {
        return this.mFillPaint;
    }

    public final void setMFillPaint(Paint paint) {
        this.mFillPaint = paint;
    }

    public final int getMRedColor() {
        return this.mRedColor;
    }

    public final int getMKeyframeColor() {
        return this.mKeyframeColor;
    }

    public final int getMGraphColor() {
        return this.mGraphColor;
    }

    public final int getMShadowColor() {
        return this.mShadowColor;
    }

    public final int getMDiamondSize() {
        return this.mDiamondSize;
    }

    public final DashPathEffect getMDashPathEffect() {
        return this.mDashPathEffect;
    }

    public final void setMDashPathEffect(DashPathEffect dashPathEffect) {
        this.mDashPathEffect = dashPathEffect;
    }

    public final int getMKeyFrameCount() {
        return this.mKeyFrameCount;
    }

    public final void setMKeyFrameCount(int i) {
        this.mKeyFrameCount = i;
    }

    public final Rect getMBounds() {
        return this.mBounds;
    }

    public final void setMBounds(Rect rect) {
        this.mBounds = rect;
    }

    public final boolean getMPresentationMode() {
        return this.mPresentationMode;
    }

    public final void setMPresentationMode(boolean z) {
        this.mPresentationMode = z;
    }

    public final int getMShadowTranslate() {
        return this.mShadowTranslate;
    }

    public final void setMShadowTranslate(int i) {
        this.mShadowTranslate = i;
    }

    public final void draw(Canvas canvas, HashMap<String, Motion> hashMap, int i, int i2, int i3, int i4) {
        if (hashMap == null || hashMap.size() == 0) {
            return;
        }
        canvas.save();
        for (Motion motion : hashMap.values()) {
            draw(canvas, motion, i, i2, i3, i4);
        }
        canvas.restore();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
        if (r13.length != (r12 * 2)) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void draw(Canvas canvas, Motion motion, int i, int i2, int i3, int i4) {
        int drawPath = motion.getDrawPath();
        int i5 = (i2 <= 0 || drawPath != 0) ? drawPath : 1;
        if (i5 == 0) {
            return;
        }
        this.mKeyFrameCount = motion.buildKeyFrames(this.mKeyFramePoints, this.mPathMode, null);
        if (i5 >= 1) {
            int i6 = i / 16;
            float[] fArr = this.mPoints;
            if (fArr != null) {
                Intrinsics.checkNotNull(fArr);
            }
            this.mPoints = new float[i6 * 2];
            this.mPath = new Path();
            int i7 = this.mShadowTranslate;
            canvas.translate(i7, i7);
            this.mPaint.setColor(this.mShadowColor);
            this.mFillPaint.setColor(this.mShadowColor);
            this.mPaintKeyframes.setColor(this.mShadowColor);
            this.mPaintGraph.setColor(this.mShadowColor);
            motion.buildPath(this.mPoints, i6);
            drawAll(canvas, i5, this.mKeyFrameCount, motion, i3, i4);
            this.mPaint.setColor(this.mRedColor);
            this.mPaintKeyframes.setColor(this.mKeyframeColor);
            this.mFillPaint.setColor(this.mKeyframeColor);
            this.mPaintGraph.setColor(this.mGraphColor);
            int i8 = this.mShadowTranslate;
            canvas.translate(-i8, -i8);
            drawAll(canvas, i5, this.mKeyFrameCount, motion, i3, i4);
            if (i5 == 5) {
                drawRectangle(canvas, motion);
            }
        }
    }

    public final void drawAll(Canvas canvas, int i, int i2, Motion motion, int i3, int i4) {
        if (i == 4) {
            drawPathAsConfigured(canvas);
        }
        if (i == 2) {
            drawPathRelative(canvas);
        }
        if (i == 3) {
            drawPathCartesian(canvas);
        }
        drawBasicPath(canvas);
        drawTicks(canvas, i, i2, motion, i3, i4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0017, code lost:
        if (r0.length != (r11 * 2)) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void basicDraw(Canvas canvas, Motion motion, int i, int i2, int i3, boolean z, boolean z2) {
        MotionRenderDebug motionRenderDebug;
        Canvas canvas2;
        Motion motion2;
        int i4;
        int i5;
        this.mKeyFrameCount = motion.buildKeyFrames(this.mKeyFramePoints, this.mPathMode, null);
        int i6 = i / 16;
        float[] fArr = this.mPoints;
        if (fArr != null) {
            Intrinsics.checkNotNull(fArr);
        }
        this.mPoints = new float[i6 * 2];
        this.mPath = new Path();
        int i7 = this.mShadowTranslate;
        canvas.translate(i7, i7);
        this.mPaint.setColor(this.mShadowColor);
        this.mFillPaint.setColor(this.mShadowColor);
        this.mPaintKeyframes.setColor(this.mShadowColor);
        this.mPaintGraph.setColor(this.mShadowColor);
        motion.buildPath(this.mPoints, i6);
        if (z) {
            drawBasicPath(canvas);
        }
        if (z2) {
            motionRenderDebug = this;
            canvas2 = canvas;
            motion2 = motion;
            i4 = i2;
            i5 = i3;
            motionRenderDebug.drawTicks(canvas2, 1, this.mKeyFrameCount, motion2, i4, i5);
        } else {
            motionRenderDebug = this;
            canvas2 = canvas;
            motion2 = motion;
            i4 = i2;
            i5 = i3;
        }
        motionRenderDebug.mPaint.setColor(motionRenderDebug.mRedColor);
        motionRenderDebug.mPaintKeyframes.setColor(motionRenderDebug.mKeyframeColor);
        motionRenderDebug.mFillPaint.setColor(motionRenderDebug.mKeyframeColor);
        motionRenderDebug.mPaintGraph.setColor(motionRenderDebug.mGraphColor);
        int i8 = motionRenderDebug.mShadowTranslate;
        canvas2.translate(-i8, -i8);
        if (z) {
            drawBasicPath(canvas2);
        }
        if (z2) {
            motionRenderDebug.drawTicks(canvas2, 1, motionRenderDebug.mKeyFrameCount, motion2, i4, i5);
        }
    }

    private final void drawBasicPath(Canvas canvas) {
        float[] fArr = this.mPoints;
        Intrinsics.checkNotNull(fArr);
        canvas.drawLines(fArr, this.mPaint);
    }

    private final void drawTicks(Canvas canvas, int i, int i2, Motion motion, int i3, int i4) {
        int i5;
        int i6;
        if (motion.getView() != null) {
            i5 = motion.getView().getWidth();
            i6 = motion.getView().getHeight();
        } else {
            i5 = 0;
            i6 = 0;
        }
        int i7 = i2 - 1;
        for (int i8 = 1; i8 < i7; i8++) {
            if (i != 4 || this.mPathMode[i8 - 1] != 0) {
                float[] fArr = this.mKeyFramePoints;
                int i9 = i8 * 2;
                float f = fArr[i9];
                float f2 = fArr[i9 + 1];
                Path path = this.mPath;
                Intrinsics.checkNotNull(path);
                path.reset();
                Path path2 = this.mPath;
                Intrinsics.checkNotNull(path2);
                path2.moveTo(f, this.mDiamondSize + f2);
                Path path3 = this.mPath;
                Intrinsics.checkNotNull(path3);
                path3.lineTo(this.mDiamondSize + f, f2);
                Path path4 = this.mPath;
                Intrinsics.checkNotNull(path4);
                path4.lineTo(f, f2 - this.mDiamondSize);
                Path path5 = this.mPath;
                Intrinsics.checkNotNull(path5);
                path5.lineTo(f - this.mDiamondSize, f2);
                Path path6 = this.mPath;
                Intrinsics.checkNotNull(path6);
                path6.close();
                if (i == 4) {
                    int i10 = this.mPathMode[i8 - 1];
                    if (i10 == 1) {
                        drawPathRelativeTicks(canvas, f - 0.0f, f2 - 0.0f);
                    } else if (i10 == 0) {
                        drawPathCartesianTicks(canvas, f - 0.0f, f2 - 0.0f);
                    } else if (i10 == 2) {
                        drawPathScreenTicks(canvas, f - 0.0f, f2 - 0.0f, i5, i6, i3, i4);
                    }
                    Path path7 = this.mPath;
                    Intrinsics.checkNotNull(path7);
                    canvas.drawPath(path7, this.mFillPaint);
                }
                if (i == 2) {
                    drawPathRelativeTicks(canvas, f - 0.0f, f2 - 0.0f);
                }
                if (i == 3) {
                    drawPathCartesianTicks(canvas, f - 0.0f, f2 - 0.0f);
                }
                if (i == 6) {
                    drawPathScreenTicks(canvas, f - 0.0f, f2 - 0.0f, i5, i6, i3, i4);
                }
                Path path8 = this.mPath;
                Intrinsics.checkNotNull(path8);
                canvas.drawPath(path8, this.mFillPaint);
            }
        }
        float[] fArr2 = this.mPoints;
        Intrinsics.checkNotNull(fArr2);
        if (fArr2.length > 1) {
            float[] fArr3 = this.mPoints;
            Intrinsics.checkNotNull(fArr3);
            float f3 = fArr3[0];
            float[] fArr4 = this.mPoints;
            Intrinsics.checkNotNull(fArr4);
            canvas.drawCircle(f3, fArr4[1], 8.0f, this.mPaintKeyframes);
            float[] fArr5 = this.mPoints;
            Intrinsics.checkNotNull(fArr5);
            float[] fArr6 = this.mPoints;
            Intrinsics.checkNotNull(fArr6);
            float f4 = fArr5[fArr6.length - 2];
            float[] fArr7 = this.mPoints;
            Intrinsics.checkNotNull(fArr7);
            float[] fArr8 = this.mPoints;
            Intrinsics.checkNotNull(fArr8);
            canvas.drawCircle(f4, fArr7[fArr8.length - 1], 8.0f, this.mPaintKeyframes);
        }
    }

    private final void drawTranslation(Canvas canvas, float f, float f2, float f3, float f4) {
        canvas.drawRect(f, f2, f3, f4, this.mPaintGraph);
        canvas.drawLine(f, f2, f3, f4, this.mPaintGraph);
    }

    private final void drawPathRelative(Canvas canvas) {
        float[] fArr = this.mPoints;
        Intrinsics.checkNotNull(fArr);
        float f = fArr[0];
        float[] fArr2 = this.mPoints;
        Intrinsics.checkNotNull(fArr2);
        float f2 = fArr2[1];
        float[] fArr3 = this.mPoints;
        Intrinsics.checkNotNull(fArr3);
        float[] fArr4 = this.mPoints;
        Intrinsics.checkNotNull(fArr4);
        float f3 = fArr3[fArr4.length - 2];
        float[] fArr5 = this.mPoints;
        Intrinsics.checkNotNull(fArr5);
        float[] fArr6 = this.mPoints;
        Intrinsics.checkNotNull(fArr6);
        canvas.drawLine(f, f2, f3, fArr5[fArr6.length - 1], this.mPaintGraph);
    }

    private final void drawPathAsConfigured(Canvas canvas) {
        int i = this.mKeyFrameCount;
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.mPathMode[i2];
            if (i3 == 1) {
                z = true;
            }
            if (i3 == 0) {
                z2 = true;
            }
        }
        if (z) {
            drawPathRelative(canvas);
        }
        if (z2) {
            drawPathCartesian(canvas);
        }
    }

    private final void drawPathRelativeTicks(Canvas canvas, float f, float f2) {
        float[] fArr = this.mPoints;
        Intrinsics.checkNotNull(fArr);
        float f3 = fArr[0];
        float[] fArr2 = this.mPoints;
        Intrinsics.checkNotNull(fArr2);
        float f4 = fArr2[1];
        float[] fArr3 = this.mPoints;
        Intrinsics.checkNotNull(fArr3);
        float[] fArr4 = this.mPoints;
        Intrinsics.checkNotNull(fArr4);
        float f5 = fArr3[fArr4.length - 2];
        float[] fArr5 = this.mPoints;
        Intrinsics.checkNotNull(fArr5);
        float[] fArr6 = this.mPoints;
        Intrinsics.checkNotNull(fArr6);
        float f6 = fArr5[fArr6.length - 1];
        float hypot = (float) Math.hypot(f3 - f5, f4 - f6);
        float f7 = f5 - f3;
        float f8 = f6 - f4;
        float f9 = (((f - f3) * f7) + ((f2 - f4) * f8)) / (hypot * hypot);
        float f10 = f3 + (f7 * f9);
        float f11 = f4 + (f9 * f8);
        Path path = new Path();
        path.moveTo(f, f2);
        path.lineTo(f10, f11);
        float hypot2 = (float) Math.hypot(f10 - f, f11 - f2);
        String str = "" + (((int) ((100 * hypot2) / hypot)) / 100.0f);
        getTextBounds(str, this.mTextPaint);
        canvas.drawTextOnPath(str, path, (hypot2 / 2) - (this.mBounds.width() / 2), -20.0f, this.mTextPaint);
        canvas.drawLine(f, f2, f10, f11, this.mPaintGraph);
    }

    public final void getTextBounds(String str, Paint paint) {
        paint.getTextBounds(str, 0, str.length(), this.mBounds);
    }

    private final void drawPathCartesian(Canvas canvas) {
        float[] fArr = this.mPoints;
        Intrinsics.checkNotNull(fArr);
        float f = fArr[0];
        float[] fArr2 = this.mPoints;
        Intrinsics.checkNotNull(fArr2);
        float f2 = fArr2[1];
        float[] fArr3 = this.mPoints;
        Intrinsics.checkNotNull(fArr3);
        float[] fArr4 = this.mPoints;
        Intrinsics.checkNotNull(fArr4);
        float f3 = fArr3[fArr4.length - 2];
        float[] fArr5 = this.mPoints;
        Intrinsics.checkNotNull(fArr5);
        float[] fArr6 = this.mPoints;
        Intrinsics.checkNotNull(fArr6);
        float f4 = fArr5[fArr6.length - 1];
        canvas.drawLine(Math.min(f, f3), Math.max(f2, f4), Math.max(f, f3), Math.max(f2, f4), this.mPaintGraph);
        canvas.drawLine(Math.min(f, f3), Math.min(f2, f4), Math.min(f, f3), Math.max(f2, f4), this.mPaintGraph);
    }

    private final void drawPathCartesianTicks(Canvas canvas, float f, float f2) {
        float[] fArr = this.mPoints;
        Intrinsics.checkNotNull(fArr);
        float f3 = fArr[0];
        float[] fArr2 = this.mPoints;
        Intrinsics.checkNotNull(fArr2);
        float f4 = fArr2[1];
        float[] fArr3 = this.mPoints;
        Intrinsics.checkNotNull(fArr3);
        float[] fArr4 = this.mPoints;
        Intrinsics.checkNotNull(fArr4);
        float f5 = fArr3[fArr4.length - 2];
        float[] fArr5 = this.mPoints;
        Intrinsics.checkNotNull(fArr5);
        float[] fArr6 = this.mPoints;
        Intrinsics.checkNotNull(fArr6);
        float f6 = fArr5[fArr6.length - 1];
        float min = Math.min(f3, f5);
        float max = Math.max(f4, f6);
        float min2 = f - Math.min(f3, f5);
        float max2 = Math.max(f4, f6) - f2;
        float f7 = 100;
        String str = "" + (((int) (((f7 * min2) / Math.abs(f5 - f3)) + 0.5d)) / 100.0f);
        getTextBounds(str, this.mTextPaint);
        float f8 = 2;
        canvas.drawText(str, ((min2 / f8) - (this.mBounds.width() / 2)) + min, f2 - 20, this.mTextPaint);
        canvas.drawLine(f, f2, Math.min(f3, f5), f2, this.mPaintGraph);
        String str2 = "" + (((int) (((f7 * max2) / Math.abs(f6 - f4)) + 0.5d)) / 100.0f);
        getTextBounds(str2, this.mTextPaint);
        canvas.drawText(str2, f + 5, max - ((max2 / f8) - (this.mBounds.height() / 2)), this.mTextPaint);
        canvas.drawLine(f, f2, f, Math.max(f4, f6), this.mPaintGraph);
    }

    private final void drawPathScreenTicks(Canvas canvas, float f, float f2, int i, int i2, int i3, int i4) {
        float f3 = 100;
        String str = "" + (((int) ((((f - (i / 2)) * f3) / (i3 - i)) + 0.5d)) / 100.0f);
        getTextBounds(str, this.mTextPaint);
        float f4 = 2;
        canvas.drawText(str, ((f / f4) - (this.mBounds.width() / 2)) + 0.0f, f2 - 20, this.mTextPaint);
        canvas.drawLine(f, f2, Math.min(0.0f, 1.0f), f2, this.mPaintGraph);
        String str2 = "" + (((int) (((f3 * (f2 - (i2 / 2))) / (i4 - i2)) + 0.5d)) / 100.0f);
        getTextBounds(str2, this.mTextPaint);
        canvas.drawText(str2, f + 5, 0.0f - ((f2 / f4) - (this.mBounds.height() / 2)), this.mTextPaint);
        canvas.drawLine(f, f2, f, Math.max(0.0f, 1.0f), this.mPaintGraph);
    }

    private final void drawRectangle(Canvas canvas, Motion motion) {
        Path path = this.mPath;
        Intrinsics.checkNotNull(path);
        path.reset();
        int i = 0;
        while (true) {
            motion.buildRect(i / 50, this.mRectangle, 0);
            Path path2 = this.mPath;
            Intrinsics.checkNotNull(path2);
            float[] fArr = this.mRectangle;
            path2.moveTo(fArr[0], fArr[1]);
            Path path3 = this.mPath;
            Intrinsics.checkNotNull(path3);
            float[] fArr2 = this.mRectangle;
            path3.lineTo(fArr2[2], fArr2[3]);
            Path path4 = this.mPath;
            Intrinsics.checkNotNull(path4);
            float[] fArr3 = this.mRectangle;
            path4.lineTo(fArr3[4], fArr3[5]);
            Path path5 = this.mPath;
            Intrinsics.checkNotNull(path5);
            float[] fArr4 = this.mRectangle;
            path5.lineTo(fArr4[6], fArr4[7]);
            Path path6 = this.mPath;
            Intrinsics.checkNotNull(path6);
            path6.close();
            if (i == 50) {
                this.mPaint.setColor(1140850688);
                canvas.translate(2.0f, 2.0f);
                Path path7 = this.mPath;
                Intrinsics.checkNotNull(path7);
                canvas.drawPath(path7, this.mPaint);
                canvas.translate(-2.0f, -2.0f);
                this.mPaint.setColor(SupportMenu.CATEGORY_MASK);
                Path path8 = this.mPath;
                Intrinsics.checkNotNull(path8);
                canvas.drawPath(path8, this.mPaint);
                return;
            }
            i++;
        }
    }

    /* compiled from: MotionRenderDebug.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/constraintlayout/compose/MotionRenderDebug$Companion;", "", "()V", "DEBUG_PATH_TICKS_PER_MS", "", "DEBUG_SHOW_NONE", "DEBUG_SHOW_PATH", "DEBUG_SHOW_PROGRESS", "MAX_KEY_FRAMES", "constraintlayout-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
