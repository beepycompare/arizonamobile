package androidx.compose.ui.text.platform.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
/* compiled from: BulletSpan.android.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016Jp\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010'\u001a\u0004\u0018\u00010(H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Landroidx/compose/ui/text/platform/style/CustomBulletSpan;", "Landroid/text/style/LeadingMarginSpan;", "shape", "Landroidx/compose/ui/graphics/Shape;", "bulletWidthPx", "", "bulletHeightPx", "gapWidthPx", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "density", "Landroidx/compose/ui/unit/Density;", "textIndentPx", "<init>", "(Landroidx/compose/ui/graphics/Shape;FFFLandroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/unit/Density;F)V", "minimumRequiredIndent", "", "diff", "getLeadingMargin", "first", "", "drawLeadingMargin", "", "c", "Landroid/graphics/Canvas;", TtmlNode.TAG_P, "Landroid/graphics/Paint;", "x", "dir", "top", "baseline", "bottom", "text", "", TtmlNode.START, TtmlNode.END, "layout", "Landroid/text/Layout;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CustomBulletSpan implements LeadingMarginSpan {
    public static final int $stable = DrawStyle.$stable;
    private final float alpha;
    private final Brush brush;
    private final float bulletHeightPx;
    private final float bulletWidthPx;
    private final Density density;
    private final int diff;
    private final DrawStyle drawStyle;
    private final int minimumRequiredIndent;
    private final Shape shape;

    public CustomBulletSpan(Shape shape, float f, float f2, float f3, Brush brush, float f4, DrawStyle drawStyle, Density density, float f5) {
        this.shape = shape;
        this.bulletWidthPx = f;
        this.bulletHeightPx = f2;
        this.brush = brush;
        this.alpha = f4;
        this.drawStyle = drawStyle;
        this.density = density;
        int roundToInt = MathKt.roundToInt(f + f3);
        this.minimumRequiredIndent = roundToInt;
        this.diff = MathKt.roundToInt(f5) - roundToInt;
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        int i = this.diff;
        if (i >= 0) {
            return 0;
        }
        return Math.abs(i);
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(final Canvas canvas, final Paint paint, int i, final int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        if (canvas == null) {
            return;
        }
        final float f = (i3 + i5) / 2.0f;
        final int coerceAtLeast = RangesKt.coerceAtLeast(i - this.minimumRequiredIndent, 0);
        Intrinsics.checkNotNull(charSequence, "null cannot be cast to non-null type android.text.Spanned");
        if (((Spanned) charSequence).getSpanStart(this) != i6 || paint == null) {
            return;
        }
        Paint.Style style = paint.getStyle();
        BulletSpan_androidKt.setDrawStyle(paint, this.drawStyle);
        float f2 = this.bulletWidthPx;
        float f3 = this.bulletHeightPx;
        final long m4587constructorimpl = Size.m4587constructorimpl((Float.floatToRawIntBits(f3) & 4294967295L) | (Float.floatToRawIntBits(f2) << 32));
        BulletSpan_androidKt.m7289setBrushAndDrawyzxVdVo(paint, this.brush, this.alpha, m4587constructorimpl, new Function0() { // from class: androidx.compose.ui.text.platform.style.CustomBulletSpan$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit drawLeadingMargin$lambda$0$0;
                drawLeadingMargin$lambda$0$0 = CustomBulletSpan.drawLeadingMargin$lambda$0$0(CustomBulletSpan.this, m4587constructorimpl, i2, canvas, paint, coerceAtLeast, f);
                return drawLeadingMargin$lambda$0$0;
            }
        });
        paint.setStyle(style);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit drawLeadingMargin$lambda$0$0(CustomBulletSpan customBulletSpan, long j, int i, Canvas canvas, Paint paint, int i2, float f) {
        BulletSpan_androidKt.draw(customBulletSpan.shape.mo320createOutlinePq9zytI(j, i > 0 ? LayoutDirection.Ltr : LayoutDirection.Rtl, customBulletSpan.density), canvas, paint, i2, f, i);
        return Unit.INSTANCE;
    }
}
