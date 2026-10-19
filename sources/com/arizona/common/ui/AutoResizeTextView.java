package com.arizona.common.ui;

import android.content.Context;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AutoResizeTextView.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 F2\u00020\u0001:\u0002EFB-\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a\u0002\b\n¢\u0006\u0004\b\b\u0010\tJ(\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0014J(\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0014J\u0010\u0010&\u001a\u00020\u001b2\b\u0010'\u001a\u0004\u0018\u00010\fJ\u0010\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\u0010H\u0016J\u0018\u0010(\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0010H\u0016J\u0018\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u0010H\u0016J\u0006\u00106\u001a\u00020\u001bJ0\u00107\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u000e2\u0006\u00109\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u0007H\u0014J\u0006\u0010=\u001a\u00020\u001bJ\u0016\u0010=\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u0007J*\u0010@\u001a\u00020\u00072\b\u0010A\u001a\u0004\u0018\u00010\u001d2\u0006\u0010B\u001a\u00020C2\u0006\u0010>\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u0010H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010.\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u00103\u001a\u00020\u00102\u0006\u00103\u001a\u00020\u00108F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b4\u00100\"\u0004\b5\u00102¨\u0006G"}, d2 = {"Lcom/arizona/common/ui/AutoResizeTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lkotlin/jvm/JvmOverloads;", "mTextResizeListener", "Lcom/arizona/common/ui/AutoResizeTextView$OnTextResizeListener;", "mNeedsResize", "", "mTextSize", "", "mMaxTextSize", "mMinTextSize", "mSpacingMult", "mSpacingAdd", "addEllipsis", "getAddEllipsis", "()Z", "setAddEllipsis", "(Z)V", "onTextChanged", "", "text", "", TtmlNode.START, TtmlNode.ANNOTATION_POSITION_BEFORE, TtmlNode.ANNOTATION_POSITION_AFTER, "onSizeChanged", "w", CmcdData.STREAMING_FORMAT_HLS, "oldw", "oldh", "setOnResizeListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setTextSize", "size", "unit", "setLineSpacing", "add", "mult", "maxTextSize", "getMaxTextSize", "()F", "setMaxTextSize", "(F)V", "minTextSize", "getMinTextSize", "setMinTextSize", "resetTextSize", "onLayout", "changed", TtmlNode.LEFT, "top", TtmlNode.RIGHT, "bottom", "resizeText", "width", "height", "getTextHeight", "source", "paint", "Landroid/text/TextPaint;", "textSize", "OnTextResizeListener", "Companion", "CommonLibs"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AutoResizeTextView extends AppCompatTextView {
    public static final Companion Companion = new Companion(null);
    public static final float MIN_TEXT_SIZE = 10.0f;
    private static final String mEllipsis = "...";
    private boolean addEllipsis;
    private float mMaxTextSize;
    private float mMinTextSize;
    private boolean mNeedsResize;
    private float mSpacingAdd;
    private float mSpacingMult;
    private OnTextResizeListener mTextResizeListener;
    private float mTextSize;

    /* compiled from: AutoResizeTextView.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/arizona/common/ui/AutoResizeTextView$OnTextResizeListener;", "", "onTextResize", "", "textView", "Landroid/widget/TextView;", "oldSize", "", "newSize", "CommonLibs"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface OnTextResizeListener {
        void onTextResize(TextView textView, float f, float f2);
    }

    public AutoResizeTextView(Context context) {
        this(context, null, 0, 6, null);
    }

    public AutoResizeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ AutoResizeTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoResizeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNull(context);
        this.mMinTextSize = 10.0f;
        this.mSpacingMult = 1.0f;
        this.addEllipsis = true;
        this.mTextSize = getTextSize();
    }

    public final boolean getAddEllipsis() {
        return this.addEllipsis;
    }

    public final void setAddEllipsis(boolean z) {
        this.addEllipsis = z;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    protected void onTextChanged(CharSequence text, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.mNeedsResize = true;
        resetTextSize();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (i == i3 && i2 == i4) {
            return;
        }
        this.mNeedsResize = true;
    }

    public final void setOnResizeListener(OnTextResizeListener onTextResizeListener) {
        this.mTextResizeListener = onTextResizeListener;
    }

    @Override // android.widget.TextView
    public void setTextSize(float f) {
        super.setTextSize(f);
        this.mTextSize = getTextSize();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        this.mTextSize = getTextSize();
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        super.setLineSpacing(f, f2);
        this.mSpacingMult = f2;
        this.mSpacingAdd = f;
    }

    public final float getMaxTextSize() {
        return this.mMaxTextSize;
    }

    public final void setMaxTextSize(float f) {
        this.mMaxTextSize = f;
        requestLayout();
        invalidate();
    }

    public final float getMinTextSize() {
        return this.mMinTextSize;
    }

    public final void setMinTextSize(float f) {
        this.mMinTextSize = f;
        requestLayout();
        invalidate();
    }

    public final void resetTextSize() {
        float f = this.mTextSize;
        if (f > 0.0f) {
            super.setTextSize(0, f);
            this.mMaxTextSize = this.mTextSize;
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z || this.mNeedsResize) {
            resizeText(((i3 - i) - getCompoundPaddingLeft()) - getCompoundPaddingRight(), ((i4 - i2) - getCompoundPaddingBottom()) - getCompoundPaddingTop());
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public final void resizeText() {
        resizeText((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingBottom()) - getPaddingTop());
    }

    public final void resizeText(int i, int i2) {
        CharSequence text = getText();
        if (text == null || text.length() == 0 || i2 <= 0 || i <= 0 || this.mTextSize == 0.0f) {
            return;
        }
        if (getTransformationMethod() != null) {
            text = getTransformationMethod().getTransformation(text, this);
        }
        CharSequence charSequence = text;
        TextPaint paint = getPaint();
        float textSize = paint.getTextSize();
        float f = this.mMaxTextSize;
        int i3 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
        float f2 = this.mTextSize;
        if (i3 > 0) {
            f2 = (float) Math.min(f2, f);
        }
        Intrinsics.checkNotNull(paint);
        int textHeight = getTextHeight(charSequence, paint, i, f2);
        float f3 = f2;
        while (textHeight > i2) {
            float f4 = this.mMinTextSize;
            if (f3 <= f4) {
                break;
            }
            f3 = (float) Math.max(f3 - 2.0f, f4);
            textHeight = getTextHeight(charSequence, paint, i, f3);
        }
        if (this.addEllipsis && f3 == this.mMinTextSize && textHeight > i2) {
            StaticLayout staticLayout = new StaticLayout(charSequence, new TextPaint(paint), i, Layout.Alignment.ALIGN_NORMAL, this.mSpacingMult, this.mSpacingAdd, false);
            if (staticLayout.getLineCount() > 0) {
                int lineForVertical = staticLayout.getLineForVertical(i2) - 1;
                if (lineForVertical < 0) {
                    setText("");
                } else {
                    int lineStart = staticLayout.getLineStart(lineForVertical);
                    int lineEnd = staticLayout.getLineEnd(lineForVertical);
                    float lineWidth = staticLayout.getLineWidth(lineForVertical);
                    float measureText = paint.measureText(mEllipsis);
                    while (i < lineWidth + measureText) {
                        Intrinsics.checkNotNull(charSequence);
                        int i4 = lineEnd - 1;
                        float measureText2 = paint.measureText(charSequence.subSequence(lineStart, lineEnd).toString());
                        lineEnd = i4;
                        lineWidth = measureText2;
                    }
                    Intrinsics.checkNotNull(charSequence);
                    setText(((Object) charSequence.subSequence(0, lineEnd)) + mEllipsis);
                }
            }
        }
        setTextSize(0, f3);
        setLineSpacing(this.mSpacingAdd, this.mSpacingMult);
        OnTextResizeListener onTextResizeListener = this.mTextResizeListener;
        if (onTextResizeListener != null) {
            Intrinsics.checkNotNull(onTextResizeListener);
            onTextResizeListener.onTextResize(this, textSize, f3);
        }
        this.mNeedsResize = false;
    }

    private final int getTextHeight(CharSequence charSequence, TextPaint textPaint, int i, float f) {
        TextPaint textPaint2 = new TextPaint(textPaint);
        textPaint2.setTextSize(f);
        return new StaticLayout(charSequence, textPaint2, i, Layout.Alignment.ALIGN_NORMAL, this.mSpacingMult, this.mSpacingAdd, true).getHeight();
    }

    /* compiled from: AutoResizeTextView.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/arizona/common/ui/AutoResizeTextView$Companion;", "", "<init>", "()V", "MIN_TEXT_SIZE", "", "mEllipsis", "", "CommonLibs"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
