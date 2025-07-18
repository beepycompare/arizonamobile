package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.view.DisplayListCanvas;
import android.view.RenderNode;
import android.view.View;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidBlendMode_androidKt;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidColorFilter_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import io.appmetrica.analytics.modulesapi.internal.client.adrevenue.AdRevenueConstants;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: GraphicsLayerV23.android.kt */
@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u0000 \u0091\u00012\u00020\u0001:\u0002\u0091\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010l\u001a\u00020mH\u0002J\u001a\u0010n\u001a\u00020m2\u0006\u00102\u001a\u000201H\u0002ø\u0001\u0000¢\u0006\u0004\bo\u0010\u001eJ\b\u0010p\u001a\u00020>H\u0016J\b\u0010q\u001a\u00020mH\u0016J\r\u0010r\u001a\u00020mH\u0000¢\u0006\u0002\bsJ\u0010\u0010t\u001a\u00020m2\u0006\u0010u\u001a\u00020vH\u0016J\b\u0010w\u001a\u00020<H\u0002J<\u0010x\u001a\u00020m2\u0006\u0010y\u001a\u00020z2\u0006\u0010{\u001a\u00020|2\u0006\u0010}\u001a\u00020~2\u001a\u0010\u007f\u001a\u0016\u0012\u0005\u0012\u00030\u0081\u0001\u0012\u0004\u0012\u00020m0\u0080\u0001¢\u0006\u0003\b\u0082\u0001H\u0016J\t\u0010\u0083\u0001\u001a\u00020#H\u0002J)\u0010\u0084\u0001\u001a\u00020m2\n\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0086\u00012\u0006\u0010@\u001a\u00020AH\u0016ø\u0001\u0000¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J1\u0010\u0089\u0001\u001a\u00020m2\b\u0010\u008a\u0001\u001a\u00030\u008b\u00012\b\u0010\u008c\u0001\u001a\u00030\u008b\u00012\u0006\u0010b\u001a\u00020AH\u0016ø\u0001\u0000¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\t\u0010\u008f\u0001\u001a\u00020mH\u0002J\u0011\u0010\u0090\u0001\u001a\u00020m2\u0006\u0010M\u001a\u00020NH\u0002R$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R,\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u0012@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R,\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\u0019@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u0011R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010$\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020#@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010,\u001a\u0004\u0018\u00010+2\b\u0010\u000b\u001a\u0004\u0018\u00010+@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R,\u00102\u001a\u0002012\u0006\u0010\u000b\u001a\u000201@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u0010\u001eR\u0014\u00105\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u0010&R\u001a\u00107\u001a\u00020#X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010&\"\u0004\b8\u0010(R\u0014\u00109\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0015R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010@\u001a\u00020AX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0018R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\u0015R,\u0010D\u001a\u00020C2\u0006\u0010\u000b\u001a\u00020C@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\bE\u0010\u0015\"\u0004\bF\u0010\u0017R\u001c\u0010G\u001a\u0004\u0018\u00010HX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u000e\u0010M\u001a\u00020NX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010O\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u000f\"\u0004\bQ\u0010\u0011R$\u0010R\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u000f\"\u0004\bT\u0010\u0011R$\u0010U\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u000f\"\u0004\bW\u0010\u0011R$\u0010X\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u000f\"\u0004\bZ\u0010\u0011R$\u0010[\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u000f\"\u0004\b]\u0010\u0011R$\u0010^\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u000f\"\u0004\b`\u0010\u0011R\u000e\u0010a\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010b\u001a\u00020AX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0018R,\u0010c\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u0012@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\bd\u0010\u0015\"\u0004\be\u0010\u0017R$\u0010f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010\u000f\"\u0004\bh\u0010\u0011R$\u0010i\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010\u000f\"\u0004\bk\u0010\u0011\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0092\u0001"}, d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsLayerV23;", "Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "ownerView", "Landroid/view/View;", "ownerId", "", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "canvasDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "(Landroid/view/View;JLandroidx/compose/ui/graphics/CanvasHolder;Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;)V", "value", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "Landroidx/compose/ui/graphics/Color;", "ambientShadowColor", "getAmbientShadowColor-0d7_KjU", "()J", "setAmbientShadowColor-8_81llA", "(J)V", "J", "Landroidx/compose/ui/graphics/BlendMode;", "blendMode", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "I", "cameraDistance", "getCameraDistance", "setCameraDistance", "", "clip", "getClip", "()Z", "setClip", "(Z)V", "clipToBounds", "clipToOutline", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "Landroidx/compose/ui/graphics/layer/CompositingStrategy;", "compositingStrategy", "getCompositingStrategy-ke2Ky5w", "setCompositingStrategy-Wpw9cng", "hasDisplayList", "getHasDisplayList", "isInvalidated", "setInvalidated", "layerId", "getLayerId", "layerPaint", "Landroid/graphics/Paint;", "matrix", "Landroid/graphics/Matrix;", "outlineIsProvided", "outlineSize", "Landroidx/compose/ui/unit/IntSize;", "getOwnerId", "Landroidx/compose/ui/geometry/Offset;", "pivotOffset", "getPivotOffset-F1C5BW0", "setPivotOffset-k-4lQ0M", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "renderNode", "Landroid/view/RenderNode;", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "shadowElevation", "getShadowElevation", "setShadowElevation", "shouldManuallySetCenterPivot", "size", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "applyClip", "", "applyCompositingStrategy", "applyCompositingStrategy-Wpw9cng", "calculateMatrix", "discardDisplayList", "discardDisplayListInternal", "discardDisplayListInternal$ui_graphics_release", "draw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "obtainLayerPaint", "record", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", AdRevenueConstants.LAYER_KEY, "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "requiresCompositingLayer", "setOutline", "outline", "Landroid/graphics/Outline;", "setOutline-O0kMr_c", "(Landroid/graphics/Outline;J)V", "setPosition", "x", "", "y", "setPosition-H0pRuoY", "(IIJ)V", "updateLayerProperties", "verifyShadowColorProperties", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GraphicsLayerV23 implements GraphicsLayerImpl {
    public static final Companion Companion = new Companion(null);
    private static final AtomicBoolean needToValidateAccess = new AtomicBoolean(true);
    private static boolean testFailCreateRenderNode;
    private float alpha;
    private long ambientShadowColor;
    private int blendMode;
    private float cameraDistance;
    private final CanvasDrawScope canvasDrawScope;
    private final CanvasHolder canvasHolder;
    private boolean clip;
    private boolean clipToBounds;
    private boolean clipToOutline;
    private ColorFilter colorFilter;
    private int compositingStrategy;
    private boolean isInvalidated;
    private final long layerId;
    private Paint layerPaint;
    private Matrix matrix;
    private boolean outlineIsProvided;
    private long outlineSize;
    private final long ownerId;
    private long pivotOffset;
    private RenderEffect renderEffect;
    private final RenderNode renderNode;
    private float rotationX;
    private float rotationY;
    private float rotationZ;
    private float scaleX;
    private float scaleY;
    private float shadowElevation;
    private boolean shouldManuallySetCenterPivot;
    private long size;
    private long spotShadowColor;
    private float translationX;
    private float translationY;

    public GraphicsLayerV23(View view, long j, CanvasHolder canvasHolder, CanvasDrawScope canvasDrawScope) {
        this.ownerId = j;
        this.canvasHolder = canvasHolder;
        this.canvasDrawScope = canvasDrawScope;
        RenderNode create = RenderNode.create("Compose", view);
        this.renderNode = create;
        this.size = IntSize.Companion.m6860getZeroYbymL2g();
        this.outlineSize = IntSize.Companion.m6860getZeroYbymL2g();
        if (needToValidateAccess.getAndSet(false)) {
            create.setScaleX(create.getScaleX());
            create.setScaleY(create.getScaleY());
            create.setTranslationX(create.getTranslationX());
            create.setTranslationY(create.getTranslationY());
            create.setElevation(create.getElevation());
            create.setRotation(create.getRotation());
            create.setRotationX(create.getRotationX());
            create.setRotationY(create.getRotationY());
            create.setCameraDistance(create.getCameraDistance());
            create.setPivotX(create.getPivotX());
            create.setPivotY(create.getPivotY());
            create.setClipToOutline(create.getClipToOutline());
            create.setClipToBounds(false);
            create.setAlpha(create.getAlpha());
            create.isValid();
            create.setLeftTopRightBottom(0, 0, 0, 0);
            create.offsetLeftAndRight(0);
            create.offsetTopAndBottom(0);
            verifyShadowColorProperties(create);
            discardDisplayListInternal$ui_graphics_release();
            create.setLayerType(0);
            create.setHasOverlappingRendering(create.hasOverlappingRendering());
        }
        if (testFailCreateRenderNode) {
            throw new NoClassDefFoundError();
        }
        create.setClipToBounds(false);
        m4755applyCompositingStrategyWpw9cng(CompositingStrategy.Companion.m4720getAutoke2Ky5w());
        this.compositingStrategy = CompositingStrategy.Companion.m4720getAutoke2Ky5w();
        this.blendMode = BlendMode.Companion.m4020getSrcOver0nO6VwU();
        this.alpha = 1.0f;
        this.pivotOffset = Offset.Companion.m3852getUnspecifiedF1C5BW0();
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.ambientShadowColor = Color.Companion.m4104getBlack0d7_KjU();
        this.spotShadowColor = Color.Companion.m4104getBlack0d7_KjU();
        this.cameraDistance = 8.0f;
        this.isInvalidated = true;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public long getOwnerId() {
        return this.ownerId;
    }

    public /* synthetic */ GraphicsLayerV23(View view, long j, CanvasHolder canvasHolder, CanvasDrawScope canvasDrawScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, j, (i & 4) != 0 ? new CanvasHolder() : canvasHolder, (i & 8) != 0 ? new CanvasDrawScope() : canvasDrawScope);
    }

    private final Paint obtainLayerPaint() {
        Paint paint = this.layerPaint;
        if (paint == null) {
            Paint paint2 = new Paint();
            this.layerPaint = paint2;
            return paint2;
        }
        return paint;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: getCompositingStrategy-ke2Ky5w */
    public int mo4745getCompositingStrategyke2Ky5w() {
        return this.compositingStrategy;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: setCompositingStrategy-Wpw9cng */
    public void mo4750setCompositingStrategyWpw9cng(int i) {
        this.compositingStrategy = i;
        updateLayerProperties();
    }

    /* renamed from: applyCompositingStrategy-Wpw9cng  reason: not valid java name */
    private final void m4755applyCompositingStrategyWpw9cng(int i) {
        RenderNode renderNode = this.renderNode;
        if (CompositingStrategy.m4716equalsimpl0(i, CompositingStrategy.Companion.m4722getOffscreenke2Ky5w())) {
            renderNode.setLayerType(2);
            renderNode.setLayerPaint(this.layerPaint);
            renderNode.setHasOverlappingRendering(true);
        } else if (CompositingStrategy.m4716equalsimpl0(i, CompositingStrategy.Companion.m4721getModulateAlphake2Ky5w())) {
            renderNode.setLayerType(0);
            renderNode.setLayerPaint(this.layerPaint);
            renderNode.setHasOverlappingRendering(false);
        } else {
            renderNode.setLayerType(0);
            renderNode.setLayerPaint(this.layerPaint);
            renderNode.setHasOverlappingRendering(true);
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: getBlendMode-0nO6VwU */
    public int mo4744getBlendMode0nO6VwU() {
        return this.blendMode;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: setBlendMode-s9anfk8 */
    public void mo4749setBlendModes9anfk8(int i) {
        if (BlendMode.m3989equalsimpl0(this.blendMode, i)) {
            return;
        }
        this.blendMode = i;
        obtainLayerPaint().setXfermode(new PorterDuffXfermode(AndroidBlendMode_androidKt.m3930toPorterDuffModes9anfk8(i)));
        updateLayerProperties();
    }

    private final boolean requiresCompositingLayer() {
        return (!CompositingStrategy.m4716equalsimpl0(mo4745getCompositingStrategyke2Ky5w(), CompositingStrategy.Companion.m4722getOffscreenke2Ky5w()) && BlendMode.m3989equalsimpl0(mo4744getBlendMode0nO6VwU(), BlendMode.Companion.m4020getSrcOver0nO6VwU()) && getColorFilter() == null) ? false : true;
    }

    private final void updateLayerProperties() {
        if (requiresCompositingLayer()) {
            m4755applyCompositingStrategyWpw9cng(CompositingStrategy.Companion.m4722getOffscreenke2Ky5w());
        } else {
            m4755applyCompositingStrategyWpw9cng(mo4745getCompositingStrategyke2Ky5w());
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setColorFilter(ColorFilter colorFilter) {
        this.colorFilter = colorFilter;
        if (colorFilter != null) {
            m4755applyCompositingStrategyWpw9cng(CompositingStrategy.Companion.m4722getOffscreenke2Ky5w());
            RenderNode renderNode = this.renderNode;
            Paint obtainLayerPaint = obtainLayerPaint();
            obtainLayerPaint.setColorFilter(AndroidColorFilter_androidKt.asAndroidColorFilter(colorFilter));
            renderNode.setLayerPaint(obtainLayerPaint);
            return;
        }
        updateLayerProperties();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getAlpha() {
        return this.alpha;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setAlpha(float f) {
        this.alpha = f;
        this.renderNode.setAlpha(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: getPivotOffset-F1C5BW0 */
    public long mo4746getPivotOffsetF1C5BW0() {
        return this.pivotOffset;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: setPivotOffset-k-4lQ0M */
    public void mo4752setPivotOffsetk4lQ0M(long j) {
        this.pivotOffset = j;
        if ((9223372034707292159L & j) == InlineClassHelperKt.UnspecifiedPackedFloats) {
            this.shouldManuallySetCenterPivot = true;
            this.renderNode.setPivotX(((int) (this.size >> 32)) / 2.0f);
            this.renderNode.setPivotY(((int) (4294967295L & this.size)) / 2.0f);
            return;
        }
        this.shouldManuallySetCenterPivot = false;
        this.renderNode.setPivotX(Float.intBitsToFloat((int) (j >> 32)));
        this.renderNode.setPivotY(Float.intBitsToFloat((int) (j & 4294967295L)));
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getScaleX() {
        return this.scaleX;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setScaleX(float f) {
        this.scaleX = f;
        this.renderNode.setScaleX(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getScaleY() {
        return this.scaleY;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setScaleY(float f) {
        this.scaleY = f;
        this.renderNode.setScaleY(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getTranslationX() {
        return this.translationX;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setTranslationX(float f) {
        this.translationX = f;
        this.renderNode.setTranslationX(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getTranslationY() {
        return this.translationY;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setTranslationY(float f) {
        this.translationY = f;
        this.renderNode.setTranslationY(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getShadowElevation() {
        return this.shadowElevation;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setShadowElevation(float f) {
        this.shadowElevation = f;
        this.renderNode.setElevation(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: getAmbientShadowColor-0d7_KjU */
    public long mo4743getAmbientShadowColor0d7_KjU() {
        return this.ambientShadowColor;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: setAmbientShadowColor-8_81llA */
    public void mo4748setAmbientShadowColor8_81llA(long j) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.ambientShadowColor = j;
            RenderNodeVerificationHelper28.INSTANCE.setAmbientShadowColor(this.renderNode, ColorKt.m4132toArgb8_81llA(j));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: getSpotShadowColor-0d7_KjU */
    public long mo4747getSpotShadowColor0d7_KjU() {
        return this.spotShadowColor;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: setSpotShadowColor-8_81llA */
    public void mo4754setSpotShadowColor8_81llA(long j) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.spotShadowColor = j;
            RenderNodeVerificationHelper28.INSTANCE.setSpotShadowColor(this.renderNode, ColorKt.m4132toArgb8_81llA(j));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getRotationX() {
        return this.rotationX;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setRotationX(float f) {
        this.rotationX = f;
        this.renderNode.setRotationX(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getRotationY() {
        return this.rotationY;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setRotationY(float f) {
        this.rotationY = f;
        this.renderNode.setRotationY(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getRotationZ() {
        return this.rotationZ;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setRotationZ(float f) {
        this.rotationZ = f;
        this.renderNode.setRotation(f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public float getCameraDistance() {
        return this.cameraDistance;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setCameraDistance(float f) {
        this.cameraDistance = f;
        this.renderNode.setCameraDistance(-f);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public boolean getClip() {
        return this.clip;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setClip(boolean z) {
        this.clip = z;
        applyClip();
    }

    private final void applyClip() {
        boolean z = true;
        boolean z2 = getClip() && !this.outlineIsProvided;
        if (!getClip() || !this.outlineIsProvided) {
            z = false;
        }
        if (z2 != this.clipToBounds) {
            this.clipToBounds = z2;
            this.renderNode.setClipToBounds(z2);
        }
        if (z != this.clipToOutline) {
            this.clipToOutline = z;
            this.renderNode.setClipToOutline(z);
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public RenderEffect getRenderEffect() {
        return this.renderEffect;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setRenderEffect(RenderEffect renderEffect) {
        this.renderEffect = renderEffect;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: setPosition-H0pRuoY */
    public void mo4753setPositionH0pRuoY(int i, int i2, long j) {
        int i3 = (int) (j >> 32);
        int i4 = (int) (4294967295L & j);
        this.renderNode.setLeftTopRightBottom(i, i2, i + i3, i2 + i4);
        if (IntSize.m6853equalsimpl0(this.size, j)) {
            return;
        }
        if (this.shouldManuallySetCenterPivot) {
            this.renderNode.setPivotX(i3 / 2.0f);
            this.renderNode.setPivotY(i4 / 2.0f);
        }
        this.size = j;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    /* renamed from: setOutline-O0kMr_c */
    public void mo4751setOutlineO0kMr_c(Outline outline, long j) {
        this.outlineSize = j;
        this.renderNode.setOutline(outline);
        this.outlineIsProvided = outline != null;
        applyClip();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public boolean isInvalidated() {
        return this.isInvalidated;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void setInvalidated(boolean z) {
        this.isInvalidated = z;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public boolean getHasDisplayList() {
        return this.renderNode.isValid();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void record(Density density, LayoutDirection layoutDirection, GraphicsLayer graphicsLayer, Function1<? super DrawScope, Unit> function1) {
        Canvas start = this.renderNode.start(Math.max((int) (this.size >> 32), (int) (this.outlineSize >> 32)), Math.max((int) (this.size & 4294967295L), (int) (this.outlineSize & 4294967295L)));
        try {
            CanvasHolder canvasHolder = this.canvasHolder;
            Canvas internalCanvas = canvasHolder.getAndroidCanvas().getInternalCanvas();
            canvasHolder.getAndroidCanvas().setInternalCanvas(start);
            AndroidCanvas androidCanvas = canvasHolder.getAndroidCanvas();
            CanvasDrawScope canvasDrawScope = this.canvasDrawScope;
            long m6867toSizeozmzZPI = IntSizeKt.m6867toSizeozmzZPI(this.size);
            Density density2 = canvasDrawScope.getDrawContext().getDensity();
            LayoutDirection layoutDirection2 = canvasDrawScope.getDrawContext().getLayoutDirection();
            androidx.compose.ui.graphics.Canvas canvas = canvasDrawScope.getDrawContext().getCanvas();
            long mo4561getSizeNHjbRc = canvasDrawScope.getDrawContext().mo4561getSizeNHjbRc();
            GraphicsLayer graphicsLayer2 = canvasDrawScope.getDrawContext().getGraphicsLayer();
            DrawContext drawContext = canvasDrawScope.getDrawContext();
            drawContext.setDensity(density);
            drawContext.setLayoutDirection(layoutDirection);
            drawContext.setCanvas(androidCanvas);
            drawContext.mo4562setSizeuvyYCjk(m6867toSizeozmzZPI);
            drawContext.setGraphicsLayer(graphicsLayer);
            androidCanvas.save();
            function1.invoke(canvasDrawScope);
            androidCanvas.restore();
            DrawContext drawContext2 = canvasDrawScope.getDrawContext();
            drawContext2.setDensity(density2);
            drawContext2.setLayoutDirection(layoutDirection2);
            drawContext2.setCanvas(canvas);
            drawContext2.mo4562setSizeuvyYCjk(mo4561getSizeNHjbRc);
            drawContext2.setGraphicsLayer(graphicsLayer2);
            canvasHolder.getAndroidCanvas().setInternalCanvas(internalCanvas);
            this.renderNode.end(start);
            setInvalidated(false);
        } catch (Throwable th) {
            this.renderNode.end(start);
            throw th;
        }
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void draw(androidx.compose.ui.graphics.Canvas canvas) {
        DisplayListCanvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(canvas);
        Intrinsics.checkNotNull(nativeCanvas, "null cannot be cast to non-null type android.view.DisplayListCanvas");
        nativeCanvas.drawRenderNode(this.renderNode);
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public Matrix calculateMatrix() {
        Matrix matrix = this.matrix;
        if (matrix == null) {
            matrix = new Matrix();
            this.matrix = matrix;
        }
        this.renderNode.getMatrix(matrix);
        return matrix;
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public void discardDisplayList() {
        discardDisplayListInternal$ui_graphics_release();
    }

    @Override // androidx.compose.ui.graphics.layer.GraphicsLayerImpl
    public long getLayerId() {
        return this.layerId;
    }

    private final void verifyShadowColorProperties(RenderNode renderNode) {
        if (Build.VERSION.SDK_INT >= 28) {
            RenderNodeVerificationHelper28.INSTANCE.setAmbientShadowColor(renderNode, RenderNodeVerificationHelper28.INSTANCE.getAmbientShadowColor(renderNode));
            RenderNodeVerificationHelper28.INSTANCE.setSpotShadowColor(renderNode, RenderNodeVerificationHelper28.INSTANCE.getSpotShadowColor(renderNode));
        }
    }

    public final void discardDisplayListInternal$ui_graphics_release() {
        RenderNodeVerificationHelper24.INSTANCE.discardDisplayList(this.renderNode);
    }

    /* compiled from: GraphicsLayerV23.android.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsLayerV23$Companion;", "", "()V", "needToValidateAccess", "Ljava/util/concurrent/atomic/AtomicBoolean;", "testFailCreateRenderNode", "", "getTestFailCreateRenderNode$ui_graphics_release", "()Z", "setTestFailCreateRenderNode$ui_graphics_release", "(Z)V", "ui-graphics_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getTestFailCreateRenderNode$ui_graphics_release() {
            return GraphicsLayerV23.testFailCreateRenderNode;
        }

        public final void setTestFailCreateRenderNode$ui_graphics_release(boolean z) {
            GraphicsLayerV23.testFailCreateRenderNode = z;
        }
    }
}
