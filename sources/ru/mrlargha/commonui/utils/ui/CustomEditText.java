package ru.mrlargha.commonui.utils.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Editable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
/* compiled from: CustomEditText.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u000bR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lru/mrlargha/commonui/utils/ui/CustomEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "typedArray", "Landroid/content/res/TypedArray;", "alwaysHint", "", "editTextValidationBuilder", "Lru/mrlargha/commonui/utils/ui/EditTextValidationBuilder;", "getEditTextValidationBuilder", "()Lru/mrlargha/commonui/utils/ui/EditTextValidationBuilder;", "hintPaint", "Landroid/graphics/Paint;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "setAlwaysHint", "hint", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CustomEditText extends AppCompatEditText {
    private String alwaysHint;
    private final EditTextValidationBuilder editTextValidationBuilder;
    private final Paint hintPaint;
    private final TypedArray typedArray;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.CustomEditText);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.typedArray = obtainStyledAttributes;
        String string = obtainStyledAttributes.getString(R.styleable.CustomEditText_alwaysHint);
        this.alwaysHint = string == null ? "" : string;
        this.editTextValidationBuilder = new EditTextValidationBuilder(this);
        Paint paint = new Paint();
        paint.setColor(-7829368);
        paint.setTextSize(paint.getTextSize());
        this.hintPaint = paint;
        setHint("");
    }

    public final EditTextValidationBuilder getEditTextValidationBuilder() {
        return this.editTextValidationBuilder;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        Paint paint = this.hintPaint;
        paint.setTextSize(getTextSize());
        paint.setTypeface(getTypeface());
        paint.setColor(getCurrentTextColor());
        paint.setAlpha(160);
        paint.setLetterSpacing(0.05f);
        String str = this.alwaysHint;
        Editable text = getText();
        if (text != null && text.length() != 0) {
            CharSequence text2 = getText();
            if (text2 == null) {
                text2 = "";
            }
            CharSequence charSequence = text2;
            char[] charArray = this.alwaysHint.toCharArray();
            Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
            int length = charSequence.length();
            for (int i = 0; i < length; i++) {
                if (i < charArray.length) {
                    charArray[i] = charSequence.charAt(i);
                }
            }
            str = new String(charArray);
        }
        canvas.drawText(str, getCompoundPaddingLeft(), getBaseline(), this.hintPaint);
    }

    public final void setAlwaysHint(String hint) {
        Intrinsics.checkNotNullParameter(hint, "hint");
        this.alwaysHint = hint;
        invalidate();
    }
}
