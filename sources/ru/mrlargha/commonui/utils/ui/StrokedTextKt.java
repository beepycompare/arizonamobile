package ru.mrlargha.commonui.utils.ui;

import android.text.SpannableStringBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: StrokedText.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u001c\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"STROKE_TAG", "", "stroke", "", "color", "", "strokeWidthPx", "", "CommonUI"}, k = 2, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class StrokedTextKt {
    private static final String STROKE_TAG = "<stroke>";

    public static /* synthetic */ CharSequence stroke$default(CharSequence charSequence, int i, float f, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f = 3.0f;
        }
        return stroke(charSequence, i, f);
    }

    public static final CharSequence stroke(CharSequence charSequence, int i, float f) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        String obj = charSequence.toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int i2 = 0;
        while (true) {
            if (i2 >= obj.length()) {
                break;
            }
            String str = obj;
            int indexOf$default = StringsKt.indexOf$default((CharSequence) str, STROKE_TAG, i2, false, 4, (Object) null);
            if (indexOf$default == -1) {
                spannableStringBuilder.append(charSequence, i2, obj.length());
                break;
            }
            if (indexOf$default > i2) {
                spannableStringBuilder.append(charSequence, i2, indexOf$default);
            }
            int i3 = indexOf$default + 8;
            int indexOf$default2 = StringsKt.indexOf$default((CharSequence) str, STROKE_TAG, i3, false, 4, (Object) null);
            if (indexOf$default2 == -1) {
                spannableStringBuilder.append(charSequence, indexOf$default, obj.length());
                break;
            }
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append(charSequence, i3, indexOf$default2);
            spannableStringBuilder.setSpan(new StrokeSpan(i, f), length, spannableStringBuilder.length(), 33);
            i2 = indexOf$default2 + 8;
        }
        return spannableStringBuilder;
    }
}
