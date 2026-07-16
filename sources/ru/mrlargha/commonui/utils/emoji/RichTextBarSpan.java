package ru.mrlargha.commonui.utils.emoji;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.material.navigation.NavigationBarView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* compiled from: RichTextBarSpan.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J4\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016JR\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lru/mrlargha/commonui/utils/emoji/RichTextBarSpan;", "Landroid/text/style/ReplacementSpan;", "bar", "Lru/mrlargha/commonui/utils/emoji/RichTextBar;", "<init>", "(Lru/mrlargha/commonui/utils/emoji/RichTextBar;)V", "barView", "Landroid/view/View;", "getSize", "", "paint", "Landroid/graphics/Paint;", "text", "", TtmlNode.START, TtmlNode.END, "fm", "Landroid/graphics/Paint$FontMetricsInt;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "x", "", "top", "y", "bottom", "getXmlBarView", "metrics", "Lru/mrlargha/commonui/utils/emoji/RichTextBarMetrics;", "calculateMetrics", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
final class RichTextBarSpan extends ReplacementSpan {
    private final RichTextBar bar;
    private View barView;

    public RichTextBarSpan(RichTextBar bar) {
        Intrinsics.checkNotNullParameter(bar, "bar");
        this.bar = bar;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        RichTextBarMetrics calculateMetrics = calculateMetrics(paint);
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
        RichTextBarMetrics calculateMetrics = calculateMetrics(paint);
        float height = i5 - calculateMetrics.getHeight();
        View xmlBarView = getXmlBarView(calculateMetrics, paint);
        if (xmlBarView != null) {
            int save = canvas.save();
            canvas.translate(f, height);
            xmlBarView.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        float width = calculateMetrics.getWidth() + f;
        Paint paint2 = new Paint(paint);
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(Color.parseColor("#1AFFFFFF"));
        Paint paint3 = new Paint(paint2);
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeWidth(calculateMetrics.getStrokeWidth());
        paint3.setColor(Color.parseColor("#55C7DDE0"));
        Paint paint4 = new Paint(paint2);
        paint4.setColor(Color.parseColor("#9BFF00"));
        Paint paint5 = new Paint(paint);
        paint5.setAntiAlias(true);
        paint5.setColor(Color.parseColor("#E8F9FC"));
        paint5.setTextSize(calculateMetrics.getLabelTextSize());
        paint5.setTypeface(paint.getTypeface());
        Paint paint6 = new Paint(paint2);
        paint6.setColor(-16777216);
        Paint paint7 = new Paint(paint2);
        paint7.setColor(Color.parseColor("#BEFF00"));
        Paint paint8 = new Paint(paint5);
        paint8.setTextSize(calculateMetrics.getBadgeTextSize());
        paint8.setColor(-1);
        paint8.setFakeBoldText(true);
        Paint paint9 = new Paint(paint8);
        paint9.setColor(-16777216);
        canvas.drawText(this.bar.getLabel(), f, (calculateMetrics.getTopPadding() + height) - paint5.getFontMetrics().ascent, paint5);
        float topPadding = height + calculateMetrics.getTopPadding() + calculateMetrics.getLabelHeight() + calculateMetrics.getLabelBottomGap();
        float barHeight = calculateMetrics.getBarHeight() + topPadding;
        RectF rectF = new RectF(f, topPadding, width, barHeight);
        canvas.drawRect(rectF, paint2);
        float coerceAtMost = RangesKt.coerceAtMost(Math.max(calculateMetrics.getMinProgressWidth() + f, f + ((width - f) * this.bar.getProgress())), width);
        if (coerceAtMost > f) {
            canvas.drawRect(new RectF(f, topPadding, coerceAtMost, barHeight), paint4);
        }
        canvas.drawRect(rectF, paint3);
        String valueOf = String.valueOf(this.bar.getLevel());
        float coerceAtLeast = RangesKt.coerceAtLeast(paint8.measureText(valueOf) + (calculateMetrics.getBadgeHorizontalPadding() * 2.0f), calculateMetrics.getMinBadgeWidth());
        float barHeight2 = ((calculateMetrics.getBarHeight() - calculateMetrics.getBadgeHeight()) / 2.0f) + topPadding;
        RectF rectF2 = new RectF(calculateMetrics.getBadgeInset() + f, barHeight2, f + calculateMetrics.getBadgeInset() + coerceAtLeast, calculateMetrics.getBadgeHeight() + barHeight2);
        canvas.drawRoundRect(rectF2, calculateMetrics.getBadgeCornerRadius(), calculateMetrics.getBadgeCornerRadius(), paint6);
        canvas.drawText(valueOf, rectF2.centerX() - (paint8.measureText(valueOf) / 2.0f), rectF2.centerY() - ((paint8.descent() + paint8.ascent()) / 2.0f), paint8);
        String progressText = this.bar.getProgressText();
        float coerceAtLeast2 = RangesKt.coerceAtLeast(paint9.measureText(progressText) + (calculateMetrics.getValueBadgeHorizontalPadding() * 2.0f), calculateMetrics.getMinValueBadgeWidth());
        float barHeight3 = topPadding + ((calculateMetrics.getBarHeight() - calculateMetrics.getValueBadgeHeight()) / 2.0f);
        RectF rectF3 = new RectF((width - calculateMetrics.getBadgeInset()) - coerceAtLeast2, barHeight3, width - calculateMetrics.getBadgeInset(), calculateMetrics.getValueBadgeHeight() + barHeight3);
        canvas.drawRoundRect(rectF3, calculateMetrics.getBadgeCornerRadius(), calculateMetrics.getBadgeCornerRadius(), paint7);
        canvas.drawText(progressText, rectF3.centerX() - (paint9.measureText(progressText) / 2.0f), rectF3.centerY() - ((paint9.descent() + paint9.ascent()) / 2.0f), paint9);
    }

    private final View getXmlBarView(RichTextBarMetrics richTextBarMetrics, Paint paint) {
        Context context$CommonUI = ChatEmoji.INSTANCE.getContext$CommonUI();
        if (context$CommonUI == null) {
            return null;
        }
        View view = this.barView;
        if (view == null) {
            view = LayoutInflater.from(context$CommonUI).inflate(R.layout.rich_text_bar_span, (ViewGroup) null, false);
            this.barView = view;
        }
        view.setPadding(0, MathKt.roundToInt(richTextBarMetrics.getTopPadding()), 0, MathKt.roundToInt(richTextBarMetrics.getBottomPadding()));
        view.setLayoutParams(new ViewGroup.LayoutParams(richTextBarMetrics.getWidth(), richTextBarMetrics.getHeight()));
        TextView textView = (TextView) view.findViewById(R.id.rich_text_bar_label);
        textView.setText(this.bar.getLabel());
        textView.setTypeface(paint.getTypeface());
        textView.setGravity(16);
        textView.setTextSize(0, richTextBarMetrics.getLabelTextSize());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, MathKt.roundToInt(richTextBarMetrics.getLabelHeight())));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, MathKt.roundToInt(richTextBarMetrics.getBarHeight()));
        layoutParams.topMargin = MathKt.roundToInt(richTextBarMetrics.getLabelBottomGap());
        ((CustomCardView) view.findViewById(R.id.rich_text_bar_track)).setLayoutParams(layoutParams);
        ((CustomCardView) view.findViewById(R.id.rich_text_bar_progress)).setPercentWidth(RangesKt.coerceAtLeast(this.bar.getProgress(), richTextBarMetrics.getMinProgressPercent()));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, MathKt.roundToInt(richTextBarMetrics.getBadgeHeight()), NavigationBarView.ITEM_GRAVITY_START_CENTER);
        layoutParams2.setMarginStart(MathKt.roundToInt(richTextBarMetrics.getBadgeInset()));
        ((CustomCardView) view.findViewById(R.id.rich_text_bar_level_badge)).setLayoutParams(layoutParams2);
        TextView textView2 = (TextView) view.findViewById(R.id.rich_text_bar_level_text);
        textView2.setText(String.valueOf(this.bar.getLevel()));
        textView2.setTypeface(paint.getTypeface());
        textView2.setTextSize(0, richTextBarMetrics.getBadgeTextSize());
        textView2.setPadding(MathKt.roundToInt(richTextBarMetrics.getBadgeHorizontalPadding()), 0, MathKt.roundToInt(richTextBarMetrics.getBadgeHorizontalPadding()), 0);
        textView2.setMinWidth(MathKt.roundToInt(richTextBarMetrics.getMinBadgeWidth()));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, MathKt.roundToInt(richTextBarMetrics.getValueBadgeHeight()), 8388629);
        layoutParams3.setMarginEnd(MathKt.roundToInt(richTextBarMetrics.getBadgeInset()));
        ((CustomCardView) view.findViewById(R.id.rich_text_bar_value_badge)).setLayoutParams(layoutParams3);
        TextView textView3 = (TextView) view.findViewById(R.id.rich_text_bar_value_text);
        textView3.setText(this.bar.getProgressText());
        textView3.setTypeface(paint.getTypeface());
        textView3.setTextSize(0, richTextBarMetrics.getBadgeTextSize());
        textView3.setPadding(MathKt.roundToInt(richTextBarMetrics.getValueBadgeHorizontalPadding()), 0, MathKt.roundToInt(richTextBarMetrics.getValueBadgeHorizontalPadding()), 0);
        textView3.setMinWidth(MathKt.roundToInt(richTextBarMetrics.getMinValueBadgeWidth()));
        view.measure(View.MeasureSpec.makeMeasureSpec(richTextBarMetrics.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(richTextBarMetrics.getHeight(), 1073741824));
        view.layout(0, 0, richTextBarMetrics.getWidth(), richTextBarMetrics.getHeight());
        return view;
    }

    private final RichTextBarMetrics calculateMetrics(Paint paint) {
        float coerceAtLeast = RangesKt.coerceAtLeast(paint.getTextSize(), 1.0f);
        float f = coerceAtLeast * 0.72f;
        float f2 = coerceAtLeast * 0.02f;
        float f3 = f * 1.1f;
        float f4 = coerceAtLeast * 0.15f;
        float f5 = coerceAtLeast * 1.45f;
        float f6 = coerceAtLeast * 0.06f;
        int roundToInt = MathKt.roundToInt(RangesKt.coerceAtLeast(60.0f * coerceAtLeast, paint.measureText(this.bar.getLabel()) * 4.2f));
        float f7 = f5 * 0.72f;
        float f8 = coerceAtLeast * 7.15f;
        return new RichTextBarMetrics(roundToInt, MathKt.roundToInt(f2 + f3 + f4 + f5 + f6), f2, f, f3, f4, f6, f5, f7, coerceAtLeast * 0.82f, coerceAtLeast * 0.16f, coerceAtLeast * 0.62f, coerceAtLeast * 2.1f, f8, RangesKt.coerceIn(f8 / roundToInt, 0.0f, 1.0f), f7, coerceAtLeast * 0.45f, coerceAtLeast * 4.9f, coerceAtLeast * 0.8f, RangesKt.coerceAtLeast(0.08f * coerceAtLeast, 1.0f));
    }
}
