package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextOverflow;
import kotlin.Metadata;
/* compiled from: TextPainter.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Landroidx/compose/ui/text/TextPainter;", "", "<init>", "()V", "paint", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TextPainter {
    public static final int $stable = 0;
    public static final TextPainter INSTANCE = new TextPainter();

    private TextPainter() {
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void paint(Canvas canvas, TextLayoutResult textLayoutResult) {
        Canvas canvas2;
        Throwable th;
        Brush brush;
        Canvas canvas3;
        long m5306getBlack0d7_KjU;
        float alpha;
        boolean z = textLayoutResult.getHasVisualOverflow() && !TextOverflow.m7922equalsimpl0(textLayoutResult.getLayoutInput().m7425getOverflowgIe3tQ8(), TextOverflow.Companion.m7935getVisiblegIe3tQ8());
        if (z) {
            Rect m5076Recttz77jQw = RectKt.m5076Recttz77jQw(Offset.Companion.m5052getZeroF1C5BW0(), Size.m5096constructorimpl((Float.floatToRawIntBits((int) (textLayoutResult.m7429getSizeYbymL2g() & 4294967295L)) & 4294967295L) | (Float.floatToRawIntBits((int) (textLayoutResult.m7429getSizeYbymL2g() >> 32)) << 32)));
            canvas.save();
            canvas2 = null;
            Canvas.m5253clipRectmtrdDE$default(canvas, m5076Recttz77jQw, 0, 2, null);
        }
        SpanStyle spanStyle$ui_text = textLayoutResult.getLayoutInput().getStyle().getSpanStyle$ui_text();
        TextDecoration textDecoration = spanStyle$ui_text.getTextDecoration();
        if (textDecoration == null) {
            textDecoration = TextDecoration.Companion.getNone();
        }
        TextDecoration textDecoration2 = textDecoration;
        Shadow shadow = spanStyle$ui_text.getShadow();
        if (shadow == null) {
            shadow = Shadow.Companion.getNone();
        }
        Shadow shadow2 = shadow;
        Fill drawStyle = spanStyle$ui_text.getDrawStyle();
        if (drawStyle == null) {
            drawStyle = Fill.INSTANCE;
        }
        DrawStyle drawStyle2 = drawStyle;
        try {
            brush = spanStyle$ui_text.getBrush();
        } catch (Throwable th2) {
            th = th2;
            canvas2 = canvas;
        }
        try {
            if (brush != null) {
                if (spanStyle$ui_text.getTextForegroundStyle$ui_text() != TextForegroundStyle.Unspecified.INSTANCE) {
                    try {
                        alpha = spanStyle$ui_text.getTextForegroundStyle$ui_text().getAlpha();
                    } catch (Throwable th3) {
                        th = th3;
                        canvas2 = canvas;
                        if (z) {
                            canvas2.restore();
                        }
                        throw th;
                    }
                } else {
                    alpha = 1.0f;
                }
                canvas3 = canvas;
                MultiParagraph.m7297painthn5TExg$default(textLayoutResult.getMultiParagraph(), canvas3, brush, alpha, shadow2, textDecoration2, drawStyle2, 0, 64, null);
            } else {
                canvas3 = canvas;
                if (spanStyle$ui_text.getTextForegroundStyle$ui_text() != TextForegroundStyle.Unspecified.INSTANCE) {
                    m5306getBlack0d7_KjU = spanStyle$ui_text.getTextForegroundStyle$ui_text().mo7766getColor0d7_KjU();
                } else {
                    m5306getBlack0d7_KjU = Color.Companion.m5306getBlack0d7_KjU();
                }
                textLayoutResult.getMultiParagraph().m7302paintLG529CI(canvas3, (r14 & 2) != 0 ? Color.Companion.m5316getUnspecified0d7_KjU() : m5306getBlack0d7_KjU, (r14 & 4) != 0 ? null : shadow2, (r14 & 8) != 0 ? null : textDecoration2, (r14 & 16) == 0 ? drawStyle2 : null, (r14 & 32) != 0 ? DrawScope.Companion.m5861getDefaultBlendMode0nO6VwU() : 0);
            }
            if (z) {
                canvas3.restore();
            }
        } catch (Throwable th4) {
            th = th4;
            th = th;
            if (z) {
            }
            throw th;
        }
    }
}
