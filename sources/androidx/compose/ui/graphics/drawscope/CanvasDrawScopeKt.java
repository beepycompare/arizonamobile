package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.InlineClassHelperKt;
import androidx.compose.ui.graphics.Path;
import kotlin.Metadata;
/* compiled from: CanvasDrawScope.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"asDrawTransform", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "ui-graphics_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CanvasDrawScopeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawTransform asDrawTransform(final DrawContext drawContext) {
        return new DrawTransform() { // from class: androidx.compose.ui.graphics.drawscope.CanvasDrawScopeKt$asDrawTransform$1
            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: getSize-NH-jbRc  reason: not valid java name */
            public long mo4566getSizeNHjbRc() {
                return DrawContext.this.mo4561getSizeNHjbRc();
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: getCenter-F1C5BW0  reason: not valid java name */
            public long mo4565getCenterF1C5BW0() {
                return SizeKt.m3916getCenteruvyYCjk(mo4566getSizeNHjbRc());
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            public void inset(float f, float f2, float f3, float f4) {
                Canvas canvas = DrawContext.this.getCanvas();
                DrawContext drawContext2 = DrawContext.this;
                long m3897constructorimpl = Size.m3897constructorimpl((Float.floatToRawIntBits(Float.intBitsToFloat((int) (mo4566getSizeNHjbRc() & 4294967295L)) - (f4 + f2)) & 4294967295L) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (mo4566getSizeNHjbRc() >> 32)) - (f3 + f)) << 32));
                if (!(Float.intBitsToFloat((int) (m3897constructorimpl >> 32)) >= 0.0f && Float.intBitsToFloat((int) (m3897constructorimpl & 4294967295L)) >= 0.0f)) {
                    InlineClassHelperKt.throwIllegalArgumentException("Width and height must be greater than or equal to zero");
                }
                drawContext2.mo4562setSizeuvyYCjk(m3897constructorimpl);
                canvas.translate(f, f2);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: clipRect-N_I0leg  reason: not valid java name */
            public void mo4564clipRectN_I0leg(float f, float f2, float f3, float f4, int i) {
                DrawContext.this.getCanvas().mo3932clipRectN_I0leg(f, f2, f3, f4, i);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: clipPath-mtrdD-E  reason: not valid java name */
            public void mo4563clipPathmtrdDE(Path path, int i) {
                DrawContext.this.getCanvas().mo3931clipPathmtrdDE(path, i);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            public void translate(float f, float f2) {
                DrawContext.this.getCanvas().translate(f, f2);
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: rotate-Uv8p0NA  reason: not valid java name */
            public void mo4567rotateUv8p0NA(float f, long j) {
                Canvas canvas = DrawContext.this.getCanvas();
                int i = (int) (j >> 32);
                int i2 = (int) (j & 4294967295L);
                canvas.translate(Float.intBitsToFloat(i), Float.intBitsToFloat(i2));
                canvas.rotate(f);
                canvas.translate(-Float.intBitsToFloat(i), -Float.intBitsToFloat(i2));
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: scale-0AR0LA0  reason: not valid java name */
            public void mo4568scale0AR0LA0(float f, float f2, long j) {
                Canvas canvas = DrawContext.this.getCanvas();
                int i = (int) (j >> 32);
                int i2 = (int) (j & 4294967295L);
                canvas.translate(Float.intBitsToFloat(i), Float.intBitsToFloat(i2));
                canvas.scale(f, f2);
                canvas.translate(-Float.intBitsToFloat(i), -Float.intBitsToFloat(i2));
            }

            @Override // androidx.compose.ui.graphics.drawscope.DrawTransform
            /* renamed from: transform-58bKbWc  reason: not valid java name */
            public void mo4569transform58bKbWc(float[] fArr) {
                DrawContext.this.getCanvas().mo3933concat58bKbWc(fArr);
            }
        };
    }
}
