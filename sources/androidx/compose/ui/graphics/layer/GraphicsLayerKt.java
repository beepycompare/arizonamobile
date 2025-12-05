package androidx.compose.ui.graphics.layer;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
/* compiled from: GraphicsLayer.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0007\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\b\u001a\u00020\t\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"drawLayer", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "DefaultCameraDistance", "", "setOutline", "outline", "Landroidx/compose/ui/graphics/Outline;", "ui-graphics"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GraphicsLayerKt {
    public static final float DefaultCameraDistance = 8.0f;

    public static final void setOutline(GraphicsLayer graphicsLayer, Outline outline) {
        if (outline instanceof Outline.Rectangle) {
            Outline.Rectangle rectangle = (Outline.Rectangle) outline;
            float left = rectangle.getRect().getLeft();
            float top = rectangle.getRect().getTop();
            long m5171constructorimpl = Offset.m5171constructorimpl((Float.floatToRawIntBits(left) << 32) | (Float.floatToRawIntBits(top) & 4294967295L));
            Rect rect = rectangle.getRect();
            float right = rect.getRight() - rect.getLeft();
            Rect rect2 = rectangle.getRect();
            float bottom = rect2.getBottom() - rect2.getTop();
            graphicsLayer.m6104setRectOutlinetz77jQw(m5171constructorimpl, Size.m5239constructorimpl((Float.floatToRawIntBits(bottom) & 4294967295L) | (Float.floatToRawIntBits(right) << 32)));
        } else if (outline instanceof Outline.Generic) {
            graphicsLayer.setPathOutline(((Outline.Generic) outline).getPath());
        } else if (!(outline instanceof Outline.Rounded)) {
            throw new NoWhenBranchMatchedException();
        } else {
            Outline.Rounded rounded = (Outline.Rounded) outline;
            if (rounded.getRoundRectPath$ui_graphics() != null) {
                graphicsLayer.setPathOutline(rounded.getRoundRectPath$ui_graphics());
                return;
            }
            RoundRect roundRect = rounded.getRoundRect();
            float left2 = roundRect.getLeft();
            float top2 = roundRect.getTop();
            long m5171constructorimpl2 = Offset.m5171constructorimpl((Float.floatToRawIntBits(left2) << 32) | (Float.floatToRawIntBits(top2) & 4294967295L));
            float width = roundRect.getWidth();
            float height = roundRect.getHeight();
            graphicsLayer.m6105setRoundRectOutlineTNW_H78(m5171constructorimpl2, Size.m5239constructorimpl((Float.floatToRawIntBits(height) & 4294967295L) | (Float.floatToRawIntBits(width) << 32)), Float.intBitsToFloat((int) (roundRect.m5227getBottomLeftCornerRadiuskKHJgLs() >> 32)));
        }
    }

    public static final void drawLayer(DrawScope drawScope, GraphicsLayer graphicsLayer) {
        graphicsLayer.draw$ui_graphics(drawScope.getDrawContext().getCanvas(), drawScope.getDrawContext().getGraphicsLayer());
    }
}
