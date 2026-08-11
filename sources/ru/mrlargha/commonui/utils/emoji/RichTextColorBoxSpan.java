package ru.mrlargha.commonui.utils.emoji;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.style.ReplacementSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RichTextColorBoxSpan.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J4\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016JR\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J0\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lru/mrlargha/commonui/utils/emoji/RichTextColorBoxSpan;", "Landroid/text/style/ReplacementSpan;", "colorBox", "Lru/mrlargha/commonui/utils/emoji/RichTextColorBox;", "<init>", "(Lru/mrlargha/commonui/utils/emoji/RichTextColorBox;)V", "colorBoxView", "Landroid/view/View;", "getSize", "", "paint", "Landroid/graphics/Paint;", "text", "", TtmlNode.START, TtmlNode.END, "fm", "Landroid/graphics/Paint$FontMetricsInt;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "x", "", "top", "y", "bottom", "getXmlColorBoxView", "metrics", "Lru/mrlargha/commonui/utils/emoji/RichTextColorBoxMetrics;", "drawFallback", "sourcePaint", "calculateMetrics", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RichTextColorBoxSpan extends ReplacementSpan {
    private final RichTextColorBox colorBox;
    private View colorBoxView;

    public RichTextColorBoxSpan(RichTextColorBox colorBox) {
        Intrinsics.checkNotNullParameter(colorBox, "colorBox");
        this.colorBox = colorBox;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        RichTextColorBoxMetrics calculateMetrics = calculateMetrics(paint);
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = -calculateMetrics.getHeight();
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = fontMetricsInt.ascent;
            fontMetricsInt.bottom = 0;
        }
        return calculateMetrics.getWidth();
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        RichTextColorBoxMetrics calculateMetrics = calculateMetrics(paint);
        float height = i5 - calculateMetrics.getHeight();
        View xmlColorBoxView = getXmlColorBoxView(calculateMetrics);
        if (xmlColorBoxView != null) {
            int save = canvas.save();
            canvas.translate(f, height);
            xmlColorBoxView.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        drawFallback(canvas, f, height, paint, calculateMetrics);
    }

    private final View getXmlColorBoxView(RichTextColorBoxMetrics richTextColorBoxMetrics) {
        Context context$CommonUI = ChatEmoji.INSTANCE.getContext$CommonUI();
        if (context$CommonUI == null) {
            return null;
        }
        View view = this.colorBoxView;
        if (view == null) {
            view = LayoutInflater.from(context$CommonUI).inflate(R.layout.rich_text_color_box_span, (ViewGroup) null, false);
            this.colorBoxView = view;
        }
        view.setLayoutParams(new ViewGroup.LayoutParams(richTextColorBoxMetrics.getContentWidth(), richTextColorBoxMetrics.getHeight()));
        CustomCardView customCardView = (CustomCardView) view.findViewById(R.id.rich_text_color_box_card);
        customCardView.setBackground(Color.parseColor("#" + this.colorBox.getHex()));
        customCardView.setBorder(Color.parseColor("#55B4C4CD"));
        customCardView.setCorners(richTextColorBoxMetrics.getCornerRadius());
        TextView textView = (TextView) view.findViewById(R.id.rich_text_color_box_label);
        textView.setText(this.colorBox.getLabel());
        textView.setTextColor(this.colorBox.getUseDarkText() ? -16777216 : -1);
        textView.setTextSize(0, richTextColorBoxMetrics.getTextSize());
        textView.setGravity(17);
        view.measure(View.MeasureSpec.makeMeasureSpec(richTextColorBoxMetrics.getContentWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(richTextColorBoxMetrics.getHeight(), 1073741824));
        view.layout(0, 0, richTextColorBoxMetrics.getContentWidth(), richTextColorBoxMetrics.getHeight());
        return view;
    }

    private final void drawFallback(Canvas canvas, float f, float f2, Paint paint, RichTextColorBoxMetrics richTextColorBoxMetrics) {
        RectF rectF = new RectF((richTextColorBoxMetrics.getStrokeWidth() / 2.0f) + f, (richTextColorBoxMetrics.getStrokeWidth() / 2.0f) + f2, (f + richTextColorBoxMetrics.getContentWidth()) - (richTextColorBoxMetrics.getStrokeWidth() / 2.0f), (f2 + richTextColorBoxMetrics.getHeight()) - (richTextColorBoxMetrics.getStrokeWidth() / 2.0f));
        Paint paint2 = new Paint(paint);
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(Color.parseColor("#" + this.colorBox.getHex()));
        canvas.drawRoundRect(rectF, richTextColorBoxMetrics.getCornerRadius(), richTextColorBoxMetrics.getCornerRadius(), paint2);
        Paint paint3 = new Paint(paint2);
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeWidth(richTextColorBoxMetrics.getStrokeWidth());
        paint3.setColor(Color.parseColor("#55B4C4CD"));
        canvas.drawRoundRect(rectF, richTextColorBoxMetrics.getCornerRadius(), richTextColorBoxMetrics.getCornerRadius(), paint3);
        Paint paint4 = new Paint(paint);
        paint4.setColor(this.colorBox.getUseDarkText() ? -16777216 : -1);
        paint4.setTextSize(richTextColorBoxMetrics.getTextSize());
        paint4.setTypeface(Typeface.create(paint.getTypeface(), 1));
        paint4.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(this.colorBox.getLabel(), rectF.centerX(), rectF.centerY() - ((paint4.getFontMetrics().ascent + paint4.getFontMetrics().descent) / 2.0f), paint4);
    }

    private final RichTextColorBoxMetrics calculateMetrics(Paint paint) {
        float coerceAtLeast = RangesKt.coerceAtLeast(paint.getTextSize(), 1.0f);
        int roundToInt = MathKt.roundToInt(Math.max(7.5f * coerceAtLeast, paint.measureText(this.colorBox.getLabel()) + (3.8f * coerceAtLeast)));
        return new RichTextColorBoxMetrics(roundToInt + MathKt.roundToInt(0.55f * coerceAtLeast), roundToInt, MathKt.roundToInt(2.7f * coerceAtLeast), coerceAtLeast, coerceAtLeast * 0.85f, RangesKt.coerceAtLeast(0.14f * coerceAtLeast, 1.0f));
    }
}
