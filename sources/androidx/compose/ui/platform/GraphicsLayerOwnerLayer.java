package androidx.compose.ui.platform;

import android.os.Build;
import androidx.compose.ui.FrameRateCategory;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.Fields;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.MatrixKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.GraphicLayerInfo;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: GraphicsLayerOwnerLayer.android.kt */
@Metadata(d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\r\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002Bi\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00128\u0010\t\u001a4\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\n\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010:\u001a\u00020\u00102\u0006\u0010&\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020\u0010H\u0002J\b\u0010=\u001a\u00020\u0010H\u0002J\u0017\u0010>\u001a\u00020\u00192\u0006\u0010?\u001a\u00020@H\u0016¢\u0006\u0004\bA\u0010BJ\u0017\u0010C\u001a\u00020\u00102\u0006\u0010?\u001a\u00020DH\u0016¢\u0006\u0004\bE\u0010FJ\u0017\u0010G\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¢\u0006\u0004\bH\u0010FJ\u001a\u0010J\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010K\u001a\u00020\u0010H\u0016J\b\u0010P\u001a\u00020\u0010H\u0016J\b\u0010Q\u001a\u00020\u0010H\u0016J\u001f\u0010R\u001a\u00020@2\u0006\u0010S\u001a\u00020@2\u0006\u0010T\u001a\u00020\u0019H\u0016¢\u0006\u0004\bU\u0010VJ\u0018\u0010W\u001a\u00020\u00102\u0006\u0010X\u001a\u00020Y2\u0006\u0010T\u001a\u00020\u0019H\u0016JP\u0010Z\u001a\u00020\u001028\u0010\t\u001a4\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\n2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012H\u0016J\u0017\u0010[\u001a\u00020\u00102\u0006\u0010\\\u001a\u00020\u001bH\u0016¢\u0006\u0004\b]\u0010^J\u0017\u0010_\u001a\u00020\u00102\u0006\u0010\\\u001a\u00020\u001bH\u0016¢\u0006\u0004\b`\u0010^J\u000f\u0010g\u001a\u00020\u001bH\u0002¢\u0006\u0004\bh\u0010iJ\u0011\u0010l\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\bm\u0010iJ\b\u0010n\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000RB\u0010\t\u001a6\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001cR\u001e\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0019@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u00020+X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00101\u001a\u000202X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u00020\u0019X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010!R\u000e\u0010I\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010L\u001a\u0013\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020\u00100M¢\u0006\u0002\bOX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010a\u001a\u00020b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bc\u0010dR\u0014\u0010e\u001a\u00020b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bf\u0010dR\u0014\u0010j\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bk\u0010i¨\u0006o"}, d2 = {"Landroidx/compose/ui/platform/GraphicsLayerOwnerLayer;", "Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/layout/GraphicLayerInfo;", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "context", "Landroidx/compose/ui/graphics/GraphicsContext;", "ownerView", "Landroidx/compose/ui/platform/AndroidComposeView;", "drawBlock", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/Canvas;", "Lkotlin/ParameterName;", "name", "canvas", "parentLayer", "", "invalidateParentLayer", "Lkotlin/Function0;", "<init>", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/ui/platform/AndroidComposeView;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "size", "Landroidx/compose/ui/unit/IntSize;", "J", "isDestroyed", "", "matrixCache", "Landroidx/compose/ui/graphics/Matrix;", "[F", "inverseMatrixCache", "value", "isDirty", "setDirty", "(Z)V", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "scope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "mutatedFields", "", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "outline", "Landroidx/compose/ui/graphics/Outline;", "isMatrixDirty", "isInverseMatrixDirty", "isIdentity", "frameRate", "", "getFrameRate", "()F", "setFrameRate", "(F)V", "isFrameRateFromParent", "()Z", "setFrameRateFromParent", "updateLayerProperties", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "triggerRepaint", "updateOutline", "isInLayer", "position", "Landroidx/compose/ui/geometry/Offset;", "isInLayer-k-4lQ0M", "(J)Z", "move", "Landroidx/compose/ui/unit/IntOffset;", "move--gyyYBs", "(J)V", "resize", "resize-ozmzZPI", "drawnWithEnabledZ", "drawLayer", "updateDisplayList", "recordLambda", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "invalidate", "destroy", "mapOffset", "point", "inverse", "mapOffset-8S9VItk", "(JZ)J", "mapBounds", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "reuseLayer", "transform", "matrix", "transform-58bKbWc", "([F)V", "inverseTransform", "inverseTransform-58bKbWc", "layerId", "", "getLayerId", "()J", "ownerViewId", "getOwnerViewId", "getMatrix", "getMatrix-sQKQjiQ", "()[F", "underlyingMatrix", "getUnderlyingMatrix-sQKQjiQ", "getInverseMatrix", "getInverseMatrix-3i98HWw", "updateMatrix", "ui"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GraphicsLayerOwnerLayer implements OwnedLayer, GraphicLayerInfo {
    public static final int $stable = 8;
    private final GraphicsContext context;
    private Function2<? super Canvas, ? super GraphicsLayer, Unit> drawBlock;
    private boolean drawnWithEnabledZ;
    private float frameRate;
    private GraphicsLayer graphicsLayer;
    private Function0<Unit> invalidateParentLayer;
    private float[] inverseMatrixCache;
    private boolean isDestroyed;
    private boolean isDirty;
    private boolean isFrameRateFromParent;
    private boolean isInverseMatrixDirty;
    private boolean isMatrixDirty;
    private int mutatedFields;
    private Outline outline;
    private final AndroidComposeView ownerView;
    private long size = IntSize.m8326constructorimpl(9223372034707292159L);
    private final float[] matrixCache = Matrix.m5592constructorimpl$default(null, 1, null);
    private Density density = DensityKt.Density$default(1.0f, 0.0f, 2, null);
    private LayoutDirection layoutDirection = LayoutDirection.Ltr;
    private final CanvasDrawScope scope = new CanvasDrawScope();
    private long transformOrigin = TransformOrigin.Companion.m5761getCenterSzJe1aQ();
    private boolean isIdentity = true;
    private final Function1<DrawScope, Unit> recordLambda = new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.platform.GraphicsLayerOwnerLayer$recordLambda$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
            invoke2(drawScope);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(DrawScope drawScope) {
            Function2 function2;
            GraphicsLayerOwnerLayer graphicsLayerOwnerLayer = GraphicsLayerOwnerLayer.this;
            Canvas canvas = drawScope.getDrawContext().getCanvas();
            function2 = graphicsLayerOwnerLayer.drawBlock;
            if (function2 != null) {
                function2.invoke(canvas, drawScope.getDrawContext().getGraphicsLayer());
            }
        }
    };

    public GraphicsLayerOwnerLayer(GraphicsLayer graphicsLayer, GraphicsContext graphicsContext, AndroidComposeView androidComposeView, Function2<? super Canvas, ? super GraphicsLayer, Unit> function2, Function0<Unit> function0) {
        this.graphicsLayer = graphicsLayer;
        this.context = graphicsContext;
        this.ownerView = androidComposeView;
        this.drawBlock = function2;
        this.invalidateParentLayer = function0;
    }

    private final void setDirty(boolean z) {
        if (z != this.isDirty) {
            this.isDirty = z;
            this.ownerView.notifyLayerIsDirty$ui(this, z);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public float getFrameRate() {
        return this.frameRate;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void setFrameRate(float f) {
        this.frameRate = f;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public boolean isFrameRateFromParent() {
        return this.isFrameRateFromParent;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void setFrameRateFromParent(boolean z) {
        this.isFrameRateFromParent = z;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void updateLayerProperties(ReusableGraphicsLayerScope reusableGraphicsLayerScope) {
        int m6003getModulateAlphake2Ky5w;
        Function0<Unit> function0;
        int mutatedFields$ui = reusableGraphicsLayerScope.getMutatedFields$ui() | this.mutatedFields;
        this.layoutDirection = reusableGraphicsLayerScope.getLayoutDirection$ui();
        this.density = reusableGraphicsLayerScope.getGraphicsDensity$ui();
        int i = mutatedFields$ui & 4096;
        if (i != 0) {
            this.transformOrigin = reusableGraphicsLayerScope.mo5544getTransformOriginSzJe1aQ();
        }
        if ((mutatedFields$ui & 1) != 0) {
            this.graphicsLayer.setScaleX(reusableGraphicsLayerScope.getScaleX());
        }
        if ((mutatedFields$ui & 2) != 0) {
            this.graphicsLayer.setScaleY(reusableGraphicsLayerScope.getScaleY());
        }
        if ((mutatedFields$ui & 4) != 0) {
            this.graphicsLayer.setAlpha(reusableGraphicsLayerScope.getAlpha());
        }
        if ((mutatedFields$ui & 8) != 0) {
            this.graphicsLayer.setTranslationX(reusableGraphicsLayerScope.getTranslationX());
        }
        if ((mutatedFields$ui & 16) != 0) {
            this.graphicsLayer.setTranslationY(reusableGraphicsLayerScope.getTranslationY());
        }
        if ((mutatedFields$ui & 32) != 0) {
            this.graphicsLayer.setShadowElevation(reusableGraphicsLayerScope.getShadowElevation());
            if (reusableGraphicsLayerScope.getShadowElevation() > 0.0f && !this.drawnWithEnabledZ && (function0 = this.invalidateParentLayer) != null) {
                function0.invoke();
            }
        }
        if ((mutatedFields$ui & 64) != 0) {
            this.graphicsLayer.m6017setAmbientShadowColor8_81llA(reusableGraphicsLayerScope.mo5539getAmbientShadowColor0d7_KjU());
        }
        if ((mutatedFields$ui & 128) != 0) {
            this.graphicsLayer.m6023setSpotShadowColor8_81llA(reusableGraphicsLayerScope.mo5543getSpotShadowColor0d7_KjU());
        }
        if ((mutatedFields$ui & 1024) != 0) {
            this.graphicsLayer.setRotationZ(reusableGraphicsLayerScope.getRotationZ());
        }
        if ((mutatedFields$ui & 256) != 0) {
            this.graphicsLayer.setRotationX(reusableGraphicsLayerScope.getRotationX());
        }
        if ((mutatedFields$ui & 512) != 0) {
            this.graphicsLayer.setRotationY(reusableGraphicsLayerScope.getRotationY());
        }
        if ((mutatedFields$ui & 2048) != 0) {
            this.graphicsLayer.setCameraDistance(reusableGraphicsLayerScope.getCameraDistance());
        }
        if (i != 0) {
            boolean m5755equalsimpl0 = TransformOrigin.m5755equalsimpl0(this.transformOrigin, TransformOrigin.Companion.m5761getCenterSzJe1aQ());
            GraphicsLayer graphicsLayer = this.graphicsLayer;
            if (m5755equalsimpl0) {
                graphicsLayer.m6020setPivotOffsetk4lQ0M(Offset.Companion.m5118getUnspecifiedF1C5BW0());
            } else {
                graphicsLayer.m6020setPivotOffsetk4lQ0M(Offset.m5095constructorimpl((Float.floatToRawIntBits(TransformOrigin.m5757getPivotFractionYimpl(this.transformOrigin) * ((int) (this.size & 4294967295L))) & 4294967295L) | (Float.floatToRawIntBits(TransformOrigin.m5756getPivotFractionXimpl(this.transformOrigin) * ((int) (this.size >> 32))) << 32)));
            }
        }
        if ((mutatedFields$ui & 16384) != 0) {
            this.graphicsLayer.setClip(reusableGraphicsLayerScope.getClip());
        }
        if ((131072 & mutatedFields$ui) != 0) {
            this.graphicsLayer.setRenderEffect(reusableGraphicsLayerScope.getRenderEffect());
        }
        if ((262144 & mutatedFields$ui) != 0) {
            this.graphicsLayer.setColorFilter(reusableGraphicsLayerScope.getColorFilter());
        }
        if ((524288 & mutatedFields$ui) != 0) {
            this.graphicsLayer.m6018setBlendModes9anfk8(reusableGraphicsLayerScope.mo5540getBlendMode0nO6VwU());
        }
        if ((32768 & mutatedFields$ui) != 0) {
            GraphicsLayer graphicsLayer2 = this.graphicsLayer;
            int mo5541getCompositingStrategyNrFUSI = reusableGraphicsLayerScope.mo5541getCompositingStrategyNrFUSI();
            if (CompositingStrategy.m5433equalsimpl0(mo5541getCompositingStrategyNrFUSI, CompositingStrategy.Companion.m5437getAutoNrFUSI())) {
                m6003getModulateAlphake2Ky5w = androidx.compose.ui.graphics.layer.CompositingStrategy.Companion.m6002getAutoke2Ky5w();
            } else if (CompositingStrategy.m5433equalsimpl0(mo5541getCompositingStrategyNrFUSI, CompositingStrategy.Companion.m5439getOffscreenNrFUSI())) {
                m6003getModulateAlphake2Ky5w = androidx.compose.ui.graphics.layer.CompositingStrategy.Companion.m6004getOffscreenke2Ky5w();
            } else if (!CompositingStrategy.m5433equalsimpl0(mo5541getCompositingStrategyNrFUSI, CompositingStrategy.Companion.m5438getModulateAlphaNrFUSI())) {
                throw new IllegalStateException("Not supported composition strategy");
            } else {
                m6003getModulateAlphake2Ky5w = androidx.compose.ui.graphics.layer.CompositingStrategy.Companion.m6003getModulateAlphake2Ky5w();
            }
            graphicsLayer2.m6019setCompositingStrategyWpw9cng(m6003getModulateAlphake2Ky5w);
        }
        boolean z = true;
        if ((mutatedFields$ui & Fields.MatrixAffectingFields) != 0) {
            this.isMatrixDirty = true;
            this.isInverseMatrixDirty = true;
        }
        if (Intrinsics.areEqual(this.outline, reusableGraphicsLayerScope.getOutline$ui())) {
            z = false;
        } else {
            this.outline = reusableGraphicsLayerScope.getOutline$ui();
            updateOutline();
        }
        this.mutatedFields = reusableGraphicsLayerScope.getMutatedFields$ui();
        if (mutatedFields$ui != 0 || z) {
            triggerRepaint();
            if (this.ownerView.isArrEnabled$ui()) {
                this.ownerView.voteFrameRate(getFrameRate());
            }
        }
    }

    private final void triggerRepaint() {
        if (Build.VERSION.SDK_INT >= 26) {
            WrapperRenderNodeLayerHelperMethods.INSTANCE.onDescendantInvalidated(this.ownerView);
        } else {
            this.ownerView.invalidate();
        }
    }

    private final void updateOutline() {
        Function0<Unit> function0;
        Outline outline = this.outline;
        if (outline == null) {
            return;
        }
        GraphicsLayerKt.setOutline(this.graphicsLayer, outline);
        if (Build.VERSION.SDK_INT < 33) {
            if (((outline instanceof Outline.Generic) || ((outline instanceof Outline.Rounded) && !RoundRectKt.isSimple(((Outline.Rounded) outline).getRoundRect()))) && (function0 = this.invalidateParentLayer) != null) {
                function0.invoke();
            }
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: move--gyyYBs */
    public void mo7196movegyyYBs(long j) {
        if (this.ownerView.isArrEnabled$ui()) {
            this.ownerView.voteFrameRate(FrameRateCategory.Companion.m4780getHighNSsRyOo());
        }
        this.graphicsLayer.m6024setTopLeftgyyYBs(j);
        triggerRepaint();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: resize-ozmzZPI */
    public void mo7197resizeozmzZPI(long j) {
        if (IntSize.m8329equalsimpl0(j, this.size)) {
            return;
        }
        if (this.ownerView.isArrEnabled$ui()) {
            this.ownerView.voteFrameRate(FrameRateCategory.Companion.m4780getHighNSsRyOo());
        }
        this.size = j;
        invalidate();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void drawLayer(Canvas canvas, GraphicsLayer graphicsLayer) {
        updateDisplayList();
        this.drawnWithEnabledZ = this.graphicsLayer.getShadowElevation() > 0.0f;
        DrawContext drawContext = this.scope.getDrawContext();
        drawContext.setCanvas(canvas);
        drawContext.setGraphicsLayer(graphicsLayer);
        GraphicsLayerKt.drawLayer(this.scope, this.graphicsLayer);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void updateDisplayList() {
        if (this.ownerView.isArrEnabled$ui() && getFrameRate() != 0.0f) {
            this.ownerView.voteFrameRate(getFrameRate());
        }
        if (this.isDirty) {
            if (!TransformOrigin.m5755equalsimpl0(this.transformOrigin, TransformOrigin.Companion.m5761getCenterSzJe1aQ()) && !IntSize.m8329equalsimpl0(this.graphicsLayer.m6013getSizeYbymL2g(), this.size)) {
                this.graphicsLayer.m6020setPivotOffsetk4lQ0M(Offset.m5095constructorimpl((Float.floatToRawIntBits(TransformOrigin.m5757getPivotFractionYimpl(this.transformOrigin) * ((int) (this.size & 4294967295L))) & 4294967295L) | (Float.floatToRawIntBits(TransformOrigin.m5756getPivotFractionXimpl(this.transformOrigin) * ((int) (this.size >> 32))) << 32)));
            }
            this.graphicsLayer.m6016recordmLhObY(this.density, this.layoutDirection, this.size, this.recordLambda);
            setDirty(false);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void invalidate() {
        if (this.isDirty || this.isDestroyed) {
            return;
        }
        this.ownerView.invalidate();
        setDirty(true);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void destroy() {
        setFrameRate(0.0f);
        setFrameRateFromParent(false);
        this.drawBlock = null;
        this.invalidateParentLayer = null;
        this.isDestroyed = true;
        setDirty(false);
        GraphicsContext graphicsContext = this.context;
        if (graphicsContext != null) {
            graphicsContext.releaseGraphicsLayer(this.graphicsLayer);
            this.ownerView.recycle$ui(this);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: mapOffset-8S9VItk */
    public long mo7195mapOffset8S9VItk(long j, boolean z) {
        float[] m7315getMatrixsQKQjiQ;
        if (z) {
            m7315getMatrixsQKQjiQ = m7314getInverseMatrix3i98HWw();
            if (m7315getMatrixsQKQjiQ == null) {
                return Offset.Companion.m5117getInfiniteF1C5BW0();
            }
        } else {
            m7315getMatrixsQKQjiQ = m7315getMatrixsQKQjiQ();
        }
        return this.isIdentity ? j : Matrix.m5598mapMKHz9U(m7315getMatrixsQKQjiQ, j);
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void mapBounds(MutableRect mutableRect, boolean z) {
        float[] m7314getInverseMatrix3i98HWw = z ? m7314getInverseMatrix3i98HWw() : m7315getMatrixsQKQjiQ();
        if (this.isIdentity) {
            return;
        }
        if (m7314getInverseMatrix3i98HWw == null) {
            mutableRect.set(0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            Matrix.m5600mapimpl(m7314getInverseMatrix3i98HWw, mutableRect);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public void reuseLayer(Function2<? super Canvas, ? super GraphicsLayer, Unit> function2, Function0<Unit> function0) {
        GraphicsContext graphicsContext = this.context;
        if (graphicsContext != null) {
            if (!this.graphicsLayer.isReleased()) {
                InlineClassHelperKt.throwIllegalArgumentException("layer should have been released before reuse");
            }
            this.graphicsLayer = graphicsContext.createGraphicsLayer();
            this.isDestroyed = false;
            this.drawBlock = function2;
            this.invalidateParentLayer = function0;
            this.isMatrixDirty = false;
            this.isInverseMatrixDirty = false;
            this.isIdentity = true;
            Matrix.m5601resetimpl(this.matrixCache);
            float[] fArr = this.inverseMatrixCache;
            if (fArr != null) {
                Matrix.m5601resetimpl(fArr);
            }
            this.transformOrigin = TransformOrigin.Companion.m5761getCenterSzJe1aQ();
            this.drawnWithEnabledZ = false;
            this.size = IntSize.m8326constructorimpl(9223372034707292159L);
            this.outline = null;
            this.mutatedFields = 0;
            return;
        }
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("currently reuse is only supported when we manage the layer lifecycle");
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: transform-58bKbWc */
    public void mo7198transform58bKbWc(float[] fArr) {
        Matrix.m5611timesAssign58bKbWc(fArr, m7315getMatrixsQKQjiQ());
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: inverseTransform-58bKbWc */
    public void mo7193inverseTransform58bKbWc(float[] fArr) {
        float[] m7314getInverseMatrix3i98HWw = m7314getInverseMatrix3i98HWw();
        if (m7314getInverseMatrix3i98HWw != null) {
            Matrix.m5611timesAssign58bKbWc(fArr, m7314getInverseMatrix3i98HWw);
        }
    }

    @Override // androidx.compose.ui.layout.GraphicLayerInfo
    public long getLayerId() {
        return this.graphicsLayer.getLayerId();
    }

    @Override // androidx.compose.ui.layout.GraphicLayerInfo
    public long getOwnerViewId() {
        return this.graphicsLayer.getOwnerViewId();
    }

    /* renamed from: getMatrix-sQKQjiQ  reason: not valid java name */
    private final float[] m7315getMatrixsQKQjiQ() {
        updateMatrix();
        return this.matrixCache;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: getUnderlyingMatrix-sQKQjiQ */
    public float[] mo7192getUnderlyingMatrixsQKQjiQ() {
        return m7315getMatrixsQKQjiQ();
    }

    /* renamed from: getInverseMatrix-3i98HWw  reason: not valid java name */
    private final float[] m7314getInverseMatrix3i98HWw() {
        float[] fArr = this.inverseMatrixCache;
        if (fArr == null) {
            fArr = Matrix.m5592constructorimpl$default(null, 1, null);
            this.inverseMatrixCache = fArr;
        }
        if (!this.isInverseMatrixDirty) {
            if (Float.isNaN(fArr[0])) {
                return null;
            }
        } else {
            this.isInverseMatrixDirty = false;
            float[] m7315getMatrixsQKQjiQ = m7315getMatrixsQKQjiQ();
            if (this.isIdentity) {
                return m7315getMatrixsQKQjiQ;
            }
            if (!InvertMatrixKt.m7318invertToJiSxe2E(m7315getMatrixsQKQjiQ, fArr)) {
                fArr[0] = Float.NaN;
                return null;
            }
        }
        return fArr;
    }

    private final void updateMatrix() {
        long m6012getPivotOffsetF1C5BW0;
        if (this.isMatrixDirty) {
            GraphicsLayer graphicsLayer = this.graphicsLayer;
            if ((graphicsLayer.m6012getPivotOffsetF1C5BW0() & 9223372034707292159L) == androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) {
                m6012getPivotOffsetF1C5BW0 = SizeKt.m5182getCenteruvyYCjk(IntSizeKt.m8343toSizeozmzZPI(this.size));
            } else {
                m6012getPivotOffsetF1C5BW0 = graphicsLayer.m6012getPivotOffsetF1C5BW0();
            }
            Matrix.m5603resetToPivotedTransformimpl$default(this.matrixCache, Float.intBitsToFloat((int) (m6012getPivotOffsetF1C5BW0 >> 32)), Float.intBitsToFloat((int) (m6012getPivotOffsetF1C5BW0 & 4294967295L)), graphicsLayer.getTranslationX(), graphicsLayer.getTranslationY(), 0.0f, graphicsLayer.getRotationX(), graphicsLayer.getRotationY(), graphicsLayer.getRotationZ(), graphicsLayer.getScaleX(), graphicsLayer.getScaleY(), 0.0f, 1040, null);
            this.isMatrixDirty = false;
            this.isIdentity = MatrixKt.m5617isIdentity58bKbWc(this.matrixCache);
        }
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    /* renamed from: isInLayer-k-4lQ0M */
    public boolean mo7194isInLayerk4lQ0M(long j) {
        float intBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        if (this.graphicsLayer.getClip()) {
            return ShapeContainingUtilKt.isInOutline$default(this.graphicsLayer.getOutline(), intBitsToFloat, intBitsToFloat2, null, null, 24, null);
        }
        return true;
    }
}
