package androidx.compose.foundation;

import android.graphics.Canvas;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.widget.EdgeEffect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
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
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001c\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0002J\u001c\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0002J\u001c\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0002J\u001c\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0002J$\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0002J\b\u0010 \u001a\u00020\u0010H\u0002J\b\u0010!\u001a\u00020\u0010H\u0002J\f\u0010\"\u001a\u00020#*\u00020$H\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006%"}, d2 = {"Landroidx/compose/foundation/StretchOverscrollNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "pointerInputNode", "Landroidx/compose/ui/node/DelegatableNode;", "overscrollEffect", "Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "edgeEffectWrapper", "Landroidx/compose/foundation/EdgeEffectWrapper;", "(Landroidx/compose/ui/node/DelegatableNode;Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;Landroidx/compose/foundation/EdgeEffectWrapper;)V", "_renderNode", "Landroid/graphics/RenderNode;", "renderNode", "getRenderNode", "()Landroid/graphics/RenderNode;", "drawBottomStretch", "", "bottom", "Landroid/widget/EdgeEffect;", "canvas", "Landroid/graphics/Canvas;", "Landroidx/compose/ui/graphics/NativeCanvas;", "drawLeftStretch", TtmlNode.LEFT, "drawRightStretch", TtmlNode.RIGHT, "drawTopStretch", "top", "drawWithRotation", "rotationDegrees", "", "edgeEffect", "shouldDrawHorizontalStretch", "shouldDrawVerticalStretch", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        long j;
        boolean z;
        this.overscrollEffect.m228updateSizeuvyYCjk$foundation_release(contentDrawScope.mo4640getSizeNHjbRc());
        Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(contentDrawScope.getDrawContext().getCanvas());
        this.overscrollEffect.getRedrawSignal$foundation_release().getValue();
        if (Size.m3908isEmptyimpl(contentDrawScope.mo4640getSizeNHjbRc())) {
            contentDrawScope.drawContent();
        } else if (!nativeCanvas.isHardwareAccelerated()) {
            this.edgeEffectWrapper.finishAll();
            contentDrawScope.drawContent();
        } else {
            float f = contentDrawScope.mo389toPx0680j_4(ClipScrollableContainerKt.getMaxSupportedElevation());
            EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
            boolean shouldDrawVerticalStretch = shouldDrawVerticalStretch();
            boolean shouldDrawHorizontalStretch = shouldDrawHorizontalStretch();
            if (shouldDrawVerticalStretch && shouldDrawHorizontalStretch) {
                getRenderNode().setPosition(0, 0, nativeCanvas.getWidth(), nativeCanvas.getHeight());
            } else if (shouldDrawVerticalStretch) {
                getRenderNode().setPosition(0, 0, nativeCanvas.getWidth() + (MathKt.roundToInt(f) * 2), nativeCanvas.getHeight());
            } else if (shouldDrawHorizontalStretch) {
                getRenderNode().setPosition(0, 0, nativeCanvas.getWidth(), nativeCanvas.getHeight() + (MathKt.roundToInt(f) * 2));
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
                    j = 4294967295L;
                    EdgeEffectCompat.INSTANCE.onPullDistanceCompat(edgeEffectWrapper.getOrCreateLeftEffectNegation(), EdgeEffectCompat.INSTANCE.getDistanceCompat(orCreateLeftEffect), 1 - Float.intBitsToFloat((int) (this.overscrollEffect.m227displacementF1C5BW0$foundation_release() & 4294967295L)));
                } else {
                    j = 4294967295L;
                }
            } else {
                j = 4294967295L;
                z = false;
            }
            if (edgeEffectWrapper.isTopNegationStretched()) {
                EdgeEffect orCreateTopEffectNegation = edgeEffectWrapper.getOrCreateTopEffectNegation();
                drawBottomStretch(orCreateTopEffectNegation, beginRecording);
                orCreateTopEffectNegation.finish();
            }
            if (edgeEffectWrapper.isTopAnimating()) {
                EdgeEffect orCreateTopEffect = edgeEffectWrapper.getOrCreateTopEffect();
                z = drawTopStretch(orCreateTopEffect, beginRecording) || z;
                if (edgeEffectWrapper.isTopStretched()) {
                    EdgeEffectCompat.INSTANCE.onPullDistanceCompat(edgeEffectWrapper.getOrCreateTopEffectNegation(), EdgeEffectCompat.INSTANCE.getDistanceCompat(orCreateTopEffect), Float.intBitsToFloat((int) (this.overscrollEffect.m227displacementF1C5BW0$foundation_release() >> 32)));
                }
            }
            if (edgeEffectWrapper.isRightNegationStretched()) {
                EdgeEffect orCreateRightEffectNegation = edgeEffectWrapper.getOrCreateRightEffectNegation();
                drawLeftStretch(orCreateRightEffectNegation, beginRecording);
                orCreateRightEffectNegation.finish();
            }
            if (edgeEffectWrapper.isRightAnimating()) {
                EdgeEffect orCreateRightEffect = edgeEffectWrapper.getOrCreateRightEffect();
                z = drawRightStretch(orCreateRightEffect, beginRecording) || z;
                if (edgeEffectWrapper.isRightStretched()) {
                    EdgeEffectCompat.INSTANCE.onPullDistanceCompat(edgeEffectWrapper.getOrCreateRightEffectNegation(), EdgeEffectCompat.INSTANCE.getDistanceCompat(orCreateRightEffect), Float.intBitsToFloat((int) (this.overscrollEffect.m227displacementF1C5BW0$foundation_release() & j)));
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
                    EdgeEffectCompat.INSTANCE.onPullDistanceCompat(edgeEffectWrapper.getOrCreateBottomEffectNegation(), EdgeEffectCompat.INSTANCE.getDistanceCompat(orCreateBottomEffect), 1 - Float.intBitsToFloat((int) (this.overscrollEffect.m227displacementF1C5BW0$foundation_release() >> 32)));
                }
                z = z2;
            }
            if (z) {
                this.overscrollEffect.invalidateOverscroll$foundation_release();
            }
            float f2 = shouldDrawHorizontalStretch ? 0.0f : f;
            if (shouldDrawVerticalStretch) {
                f = 0.0f;
            }
            ContentDrawScope contentDrawScope2 = contentDrawScope;
            LayoutDirection layoutDirection = contentDrawScope.getLayoutDirection();
            androidx.compose.ui.graphics.Canvas Canvas = AndroidCanvas_androidKt.Canvas(beginRecording);
            long j2 = contentDrawScope.mo4640getSizeNHjbRc();
            Density density = contentDrawScope2.getDrawContext().getDensity();
            LayoutDirection layoutDirection2 = contentDrawScope2.getDrawContext().getLayoutDirection();
            androidx.compose.ui.graphics.Canvas canvas = contentDrawScope2.getDrawContext().getCanvas();
            long mo4561getSizeNHjbRc = contentDrawScope2.getDrawContext().mo4561getSizeNHjbRc();
            GraphicsLayer graphicsLayer = contentDrawScope2.getDrawContext().getGraphicsLayer();
            DrawContext drawContext = contentDrawScope2.getDrawContext();
            drawContext.setDensity(contentDrawScope);
            drawContext.setLayoutDirection(layoutDirection);
            drawContext.setCanvas(Canvas);
            drawContext.mo4562setSizeuvyYCjk(j2);
            drawContext.setGraphicsLayer(null);
            Canvas.save();
            try {
                contentDrawScope2.getDrawContext().getTransform().translate(f2, f);
                contentDrawScope.drawContent();
                float f3 = -f2;
                float f4 = -f;
                contentDrawScope2.getDrawContext().getTransform().translate(f3, f4);
                Canvas.restore();
                DrawContext drawContext2 = contentDrawScope2.getDrawContext();
                drawContext2.setDensity(density);
                drawContext2.setLayoutDirection(layoutDirection2);
                drawContext2.setCanvas(canvas);
                drawContext2.mo4562setSizeuvyYCjk(mo4561getSizeNHjbRc);
                drawContext2.setGraphicsLayer(graphicsLayer);
                getRenderNode().endRecording();
                int save = nativeCanvas.save();
                nativeCanvas.translate(f3, f4);
                nativeCanvas.drawRenderNode(getRenderNode());
                nativeCanvas.restoreToCount(save);
            } catch (Throwable th) {
                Canvas.restore();
                DrawContext drawContext3 = contentDrawScope2.getDrawContext();
                drawContext3.setDensity(density);
                drawContext3.setLayoutDirection(layoutDirection2);
                drawContext3.setCanvas(canvas);
                drawContext3.mo4562setSizeuvyYCjk(mo4561getSizeNHjbRc);
                drawContext3.setGraphicsLayer(graphicsLayer);
                throw th;
            }
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

    private final boolean drawLeftStretch(EdgeEffect edgeEffect, Canvas canvas) {
        return drawWithRotation(270.0f, edgeEffect, canvas);
    }

    private final boolean drawTopStretch(EdgeEffect edgeEffect, Canvas canvas) {
        return drawWithRotation(0.0f, edgeEffect, canvas);
    }

    private final boolean drawRightStretch(EdgeEffect edgeEffect, Canvas canvas) {
        return drawWithRotation(90.0f, edgeEffect, canvas);
    }

    private final boolean drawBottomStretch(EdgeEffect edgeEffect, Canvas canvas) {
        return drawWithRotation(180.0f, edgeEffect, canvas);
    }

    private final boolean drawWithRotation(float f, EdgeEffect edgeEffect, Canvas canvas) {
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
