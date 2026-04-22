package androidx.compose.foundation;

import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.widget.EdgeEffect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.math.MathKt;
/* compiled from: AndroidOverscroll.android.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\f\u0010\u0010\u001a\u00020\u0011*\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u001c\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\n\u0010\u0019\u001a\u00060\u001aj\u0002`\u001bH\u0002J\u001c\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00182\n\u0010\u0019\u001a\u00060\u001aj\u0002`\u001bH\u0002J\u001c\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020\u00182\n\u0010\u0019\u001a\u00060\u001aj\u0002`\u001bH\u0002J\u001c\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00182\n\u0010\u0019\u001a\u00060\u001aj\u0002`\u001bH\u0002J$\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00182\n\u0010\u0019\u001a\u00060\u001aj\u0002`\u001bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006&"}, d2 = {"Landroidx/compose/foundation/StretchOverscrollNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "pointerInputNode", "Landroidx/compose/ui/node/DelegatableNode;", "overscrollEffect", "Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "edgeEffectWrapper", "Landroidx/compose/foundation/EdgeEffectWrapper;", "<init>", "(Landroidx/compose/ui/node/DelegatableNode;Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;Landroidx/compose/foundation/EdgeEffectWrapper;)V", "_renderNode", "Landroid/graphics/RenderNode;", "renderNode", "getRenderNode", "()Landroid/graphics/RenderNode;", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "shouldDrawVerticalStretch", "", "shouldDrawHorizontalStretch", "drawLeftStretch", TtmlNode.LEFT, "Landroid/widget/EdgeEffect;", "canvas", "Landroid/graphics/Canvas;", "Landroidx/compose/ui/graphics/NativeCanvas;", "drawTopStretch", "top", "drawRightStretch", TtmlNode.RIGHT, "drawBottomStretch", "bottom", "drawWithRotation", "rotationDegrees", "", "edgeEffect", "foundation"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class StretchOverscrollNode extends DelegatingNode implements DrawModifierNode {
    private RenderNode _renderNode;
    private final EdgeEffectWrapper edgeEffectWrapper;
    private final AndroidEdgeEffectOverscrollEffect overscrollEffect;

    public StretchOverscrollNode(DelegatableNode delegatableNode, AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, EdgeEffectWrapper edgeEffectWrapper) {
        this.overscrollEffect = androidEdgeEffectOverscrollEffect;
        this.edgeEffectWrapper = edgeEffectWrapper;
        delegate(delegatableNode);
    }

    private final RenderNode getRenderNode() {
        RenderNode renderNode = this._renderNode;
        if (renderNode == null) {
            RenderNode renderNode2 = new RenderNode("AndroidEdgeEffectOverscrollEffect");
            this._renderNode = renderNode2;
            return renderNode2;
        }
        return renderNode;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01f8  */
    @Override // androidx.compose.ui.node.DrawModifierNode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void draw(ContentDrawScope contentDrawScope) {
        float f;
        boolean z;
        char c;
        ContentDrawScope contentDrawScope2;
        Canvas Canvas;
        Density density;
        LayoutDirection layoutDirection;
        Canvas canvas;
        long mo5267getSizeNHjbRc;
        GraphicsLayer graphicsLayer;
        this.overscrollEffect.m244updateSizeuvyYCjk$foundation(contentDrawScope.mo5346getSizeNHjbRc());
        android.graphics.Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(contentDrawScope.getDrawContext().getCanvas());
        this.overscrollEffect.getRedrawSignal$foundation().getValue();
        if (Size.m4598isEmptyimpl(contentDrawScope.mo5346getSizeNHjbRc())) {
            contentDrawScope.drawContent();
        } else if (!nativeCanvas.isHardwareAccelerated()) {
            this.edgeEffectWrapper.finishAll();
            contentDrawScope.drawContent();
        } else {
            float f2 = contentDrawScope.mo405toPx0680j_4(ClipScrollableContainerKt.getMaxSupportedElevation());
            EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
            boolean shouldDrawVerticalStretch = shouldDrawVerticalStretch();
            boolean shouldDrawHorizontalStretch = shouldDrawHorizontalStretch();
            if (shouldDrawVerticalStretch && shouldDrawHorizontalStretch) {
                getRenderNode().setPosition(0, 0, nativeCanvas.getWidth(), nativeCanvas.getHeight());
            } else if (shouldDrawVerticalStretch) {
                getRenderNode().setPosition(0, 0, nativeCanvas.getWidth() + (MathKt.roundToInt(f2) * 2), nativeCanvas.getHeight());
            } else if (shouldDrawHorizontalStretch) {
                getRenderNode().setPosition(0, 0, nativeCanvas.getWidth(), nativeCanvas.getHeight() + (MathKt.roundToInt(f2) * 2));
            } else {
                contentDrawScope.drawContent();
                return;
            }
            RecordingCanvas beginRecording = getRenderNode().beginRecording();
            if (edgeEffectWrapper.isLeftNegationStretched()) {
                EdgeEffect orCreateLeftEffectNegation = edgeEffectWrapper.getOrCreateLeftEffectNegation();
                drawRightStretch(orCreateLeftEffectNegation, beginRecording);
                orCreateLeftEffectNegation.finish();
            }
            if (edgeEffectWrapper.isLeftAnimating()) {
                EdgeEffect orCreateLeftEffect = edgeEffectWrapper.getOrCreateLeftEffect();
                z = drawLeftStretch(orCreateLeftEffect, beginRecording);
                if (edgeEffectWrapper.isLeftStretched()) {
                    f = 1.0f;
                    EdgeEffectCompat.INSTANCE.onPullDistanceCompat(edgeEffectWrapper.getOrCreateLeftEffectNegation(), EdgeEffectCompat.INSTANCE.getDistanceCompat(orCreateLeftEffect), 1.0f - Float.intBitsToFloat((int) (this.overscrollEffect.m243displacementF1C5BW0$foundation() & 4294967295L)));
                } else {
                    f = 1.0f;
                }
            } else {
                f = 1.0f;
                z = false;
            }
            if (edgeEffectWrapper.isTopNegationStretched()) {
                EdgeEffect orCreateTopEffectNegation = edgeEffectWrapper.getOrCreateTopEffectNegation();
                drawBottomStretch(orCreateTopEffectNegation, beginRecording);
                orCreateTopEffectNegation.finish();
            }
            try {
                if (edgeEffectWrapper.isTopAnimating()) {
                    EdgeEffect orCreateTopEffect = edgeEffectWrapper.getOrCreateTopEffect();
                    z = drawTopStretch(orCreateTopEffect, beginRecording) || z;
                    if (edgeEffectWrapper.isTopStretched()) {
                        c = ' ';
                        EdgeEffectCompat.INSTANCE.onPullDistanceCompat(edgeEffectWrapper.getOrCreateTopEffectNegation(), EdgeEffectCompat.INSTANCE.getDistanceCompat(orCreateTopEffect), Float.intBitsToFloat((int) (this.overscrollEffect.m243displacementF1C5BW0$foundation() >> 32)));
                        if (edgeEffectWrapper.isRightNegationStretched()) {
                            EdgeEffect orCreateRightEffectNegation = edgeEffectWrapper.getOrCreateRightEffectNegation();
                            drawLeftStretch(orCreateRightEffectNegation, beginRecording);
                            orCreateRightEffectNegation.finish();
                        }
                        if (edgeEffectWrapper.isRightAnimating()) {
                            EdgeEffect orCreateRightEffect = edgeEffectWrapper.getOrCreateRightEffect();
                            z = drawRightStretch(orCreateRightEffect, beginRecording) || z;
                            if (edgeEffectWrapper.isRightStretched()) {
                                EdgeEffectCompat.INSTANCE.onPullDistanceCompat(edgeEffectWrapper.getOrCreateRightEffectNegation(), EdgeEffectCompat.INSTANCE.getDistanceCompat(orCreateRightEffect), Float.intBitsToFloat((int) (this.overscrollEffect.m243displacementF1C5BW0$foundation() & 4294967295L)));
                            }
                        }
                        if (edgeEffectWrapper.isBottomNegationStretched()) {
                            EdgeEffect orCreateBottomEffectNegation = edgeEffectWrapper.getOrCreateBottomEffectNegation();
                            drawTopStretch(orCreateBottomEffectNegation, beginRecording);
                            orCreateBottomEffectNegation.finish();
                        }
                        if (edgeEffectWrapper.isBottomAnimating()) {
                            EdgeEffect orCreateBottomEffect = edgeEffectWrapper.getOrCreateBottomEffect();
                            boolean z2 = drawBottomStretch(orCreateBottomEffect, beginRecording) || z;
                            if (edgeEffectWrapper.isBottomStretched()) {
                                EdgeEffectCompat.INSTANCE.onPullDistanceCompat(edgeEffectWrapper.getOrCreateBottomEffectNegation(), EdgeEffectCompat.INSTANCE.getDistanceCompat(orCreateBottomEffect), f - Float.intBitsToFloat((int) (this.overscrollEffect.m243displacementF1C5BW0$foundation() >> c)));
                            }
                            z = z2;
                        }
                        if (z) {
                            this.overscrollEffect.invalidateOverscroll$foundation();
                        }
                        float f3 = !shouldDrawHorizontalStretch ? 0.0f : f2;
                        if (shouldDrawVerticalStretch) {
                            f2 = 0.0f;
                        }
                        contentDrawScope2 = contentDrawScope;
                        LayoutDirection layoutDirection2 = contentDrawScope.getLayoutDirection();
                        Canvas = AndroidCanvas_androidKt.Canvas(beginRecording);
                        long j = contentDrawScope.mo5346getSizeNHjbRc();
                        density = contentDrawScope2.getDrawContext().getDensity();
                        layoutDirection = contentDrawScope2.getDrawContext().getLayoutDirection();
                        canvas = contentDrawScope2.getDrawContext().getCanvas();
                        mo5267getSizeNHjbRc = contentDrawScope2.getDrawContext().mo5267getSizeNHjbRc();
                        graphicsLayer = contentDrawScope2.getDrawContext().getGraphicsLayer();
                        DrawContext drawContext = contentDrawScope2.getDrawContext();
                        drawContext.setDensity(contentDrawScope);
                        drawContext.setLayoutDirection(layoutDirection2);
                        drawContext.setCanvas(Canvas);
                        drawContext.mo5268setSizeuvyYCjk(j);
                        drawContext.setGraphicsLayer(null);
                        Canvas.save();
                        contentDrawScope2.getDrawContext().getTransform().translate(f3, f2);
                        contentDrawScope.drawContent();
                        float f4 = -f3;
                        float f5 = -f2;
                        contentDrawScope2.getDrawContext().getTransform().translate(f4, f5);
                        Canvas.restore();
                        DrawContext drawContext2 = contentDrawScope2.getDrawContext();
                        drawContext2.setDensity(density);
                        drawContext2.setLayoutDirection(layoutDirection);
                        drawContext2.setCanvas(canvas);
                        drawContext2.mo5268setSizeuvyYCjk(mo5267getSizeNHjbRc);
                        drawContext2.setGraphicsLayer(graphicsLayer);
                        getRenderNode().endRecording();
                        int save = nativeCanvas.save();
                        nativeCanvas.translate(f4, f5);
                        nativeCanvas.drawRenderNode(getRenderNode());
                        nativeCanvas.restoreToCount(save);
                        return;
                    }
                }
                contentDrawScope2.getDrawContext().getTransform().translate(f3, f2);
                contentDrawScope.drawContent();
                float f42 = -f3;
                float f52 = -f2;
                contentDrawScope2.getDrawContext().getTransform().translate(f42, f52);
                Canvas.restore();
                DrawContext drawContext22 = contentDrawScope2.getDrawContext();
                drawContext22.setDensity(density);
                drawContext22.setLayoutDirection(layoutDirection);
                drawContext22.setCanvas(canvas);
                drawContext22.mo5268setSizeuvyYCjk(mo5267getSizeNHjbRc);
                drawContext22.setGraphicsLayer(graphicsLayer);
                getRenderNode().endRecording();
                int save2 = nativeCanvas.save();
                nativeCanvas.translate(f42, f52);
                nativeCanvas.drawRenderNode(getRenderNode());
                nativeCanvas.restoreToCount(save2);
                return;
            } catch (Throwable th) {
                Canvas.restore();
                DrawContext drawContext3 = contentDrawScope2.getDrawContext();
                drawContext3.setDensity(density);
                drawContext3.setLayoutDirection(layoutDirection);
                drawContext3.setCanvas(canvas);
                drawContext3.mo5268setSizeuvyYCjk(mo5267getSizeNHjbRc);
                drawContext3.setGraphicsLayer(graphicsLayer);
                throw th;
            }
            c = ' ';
            if (edgeEffectWrapper.isRightNegationStretched()) {
            }
            if (edgeEffectWrapper.isRightAnimating()) {
            }
            if (edgeEffectWrapper.isBottomNegationStretched()) {
            }
            if (edgeEffectWrapper.isBottomAnimating()) {
            }
            if (z) {
            }
            if (!shouldDrawHorizontalStretch) {
            }
            if (shouldDrawVerticalStretch) {
            }
            contentDrawScope2 = contentDrawScope;
            LayoutDirection layoutDirection22 = contentDrawScope.getLayoutDirection();
            Canvas = AndroidCanvas_androidKt.Canvas(beginRecording);
            long j2 = contentDrawScope.mo5346getSizeNHjbRc();
            density = contentDrawScope2.getDrawContext().getDensity();
            layoutDirection = contentDrawScope2.getDrawContext().getLayoutDirection();
            canvas = contentDrawScope2.getDrawContext().getCanvas();
            mo5267getSizeNHjbRc = contentDrawScope2.getDrawContext().mo5267getSizeNHjbRc();
            graphicsLayer = contentDrawScope2.getDrawContext().getGraphicsLayer();
            DrawContext drawContext4 = contentDrawScope2.getDrawContext();
            drawContext4.setDensity(contentDrawScope);
            drawContext4.setLayoutDirection(layoutDirection22);
            drawContext4.setCanvas(Canvas);
            drawContext4.mo5268setSizeuvyYCjk(j2);
            drawContext4.setGraphicsLayer(null);
            Canvas.save();
        }
    }

    private final boolean shouldDrawVerticalStretch() {
        EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        return edgeEffectWrapper.isTopAnimating() || edgeEffectWrapper.isTopNegationStretched() || edgeEffectWrapper.isBottomAnimating() || edgeEffectWrapper.isBottomNegationStretched();
    }

    private final boolean shouldDrawHorizontalStretch() {
        EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        return edgeEffectWrapper.isLeftAnimating() || edgeEffectWrapper.isLeftNegationStretched() || edgeEffectWrapper.isRightAnimating() || edgeEffectWrapper.isRightNegationStretched();
    }

    private final boolean drawLeftStretch(EdgeEffect edgeEffect, android.graphics.Canvas canvas) {
        return drawWithRotation(270.0f, edgeEffect, canvas);
    }

    private final boolean drawTopStretch(EdgeEffect edgeEffect, android.graphics.Canvas canvas) {
        return drawWithRotation(0.0f, edgeEffect, canvas);
    }

    private final boolean drawRightStretch(EdgeEffect edgeEffect, android.graphics.Canvas canvas) {
        return drawWithRotation(90.0f, edgeEffect, canvas);
    }

    private final boolean drawBottomStretch(EdgeEffect edgeEffect, android.graphics.Canvas canvas) {
        return drawWithRotation(180.0f, edgeEffect, canvas);
    }

    private final boolean drawWithRotation(float f, EdgeEffect edgeEffect, android.graphics.Canvas canvas) {
        if (f == 0.0f) {
            return edgeEffect.draw(canvas);
        }
        int save = canvas.save();
        canvas.rotate(f);
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
    }
}
