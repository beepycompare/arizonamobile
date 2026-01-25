package ru.mrlargha.ui.kit;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
/* compiled from: parseColoredText.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004H\u0002¨\u0006\u000b"}, d2 = {"toColoredText", "Landroid/text/SpannableStringBuilder;", "", "baseColor", "", "toStyledColoredText", "appendStyledPart", "", "builder", "text", "color", "ui-kit_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ParseColoredTextKt {
    public static /* synthetic */ SpannableStringBuilder toColoredText$default(String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -1;
        }
        return toColoredText(str, i);
    }

    public static final SpannableStringBuilder toColoredText(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int i2 = 0;
        int i3 = i;
        for (MatchResult matchResult : Regex.findAll$default(new Regex("\\{([0-9A-Fa-f]{6})\\}"), str, 0, 2, null)) {
            int first = matchResult.getRange().getFirst();
            int last = matchResult.getRange().getLast() + 1;
            String str2 = matchResult.getGroupValues().get(1);
            if (first > i2) {
                String substring = str.substring(i2, first);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                String replace$default = StringsKt.replace$default(StringsKt.replace$default(substring, "\\n", "\n", false, 4, (Object) null), "\\u003E", ">", false, 4, (Object) null);
                int length = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) replace$default);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(i3), length, spannableStringBuilder.length(), 33);
            }
            i3 = Color.parseColor("#" + str2);
            i2 = last;
        }
        if (i2 < str.length()) {
            String substring2 = str.substring(i2);
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            String replace$default2 = StringsKt.replace$default(StringsKt.replace$default(substring2, "\\n", "\n", false, 4, (Object) null), "\\u003E", ">", false, 4, (Object) null);
            int length2 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) replace$default2);
            spannableStringBuilder.append((CharSequence) "\n\n");
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i3), length2, spannableStringBuilder.length(), 33);
        }
        return spannableStringBuilder;
    }

    public static /* synthetic */ SpannableStringBuilder toStyledColoredText$default(String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Color.parseColor("#80FFFFFF");
        }
        return toStyledColoredText(str, i);
    }

    public static final SpannableStringBuilder toStyledColoredText(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Regex regex = new Regex("\\{([0-9A-Fa-f]{6})\\}");
        String replace$default = StringsKt.replace$default(str, "<br>", "\n", false, 4, (Object) null);
        int i2 = 0;
        for (MatchResult matchResult : Regex.findAll$default(regex, replace$default, 0, 2, null)) {
            int first = matchResult.getRange().getFirst();
            int last = matchResult.getRange().getLast() + 1;
            String str2 = matchResult.getGroupValues().get(1);
            if (first > i2) {
                String substring = replace$default.substring(i2, first);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                appendStyledPart(spannableStringBuilder, substring, i);
            }
            i = Color.parseColor("#" + str2);
            i2 = last;
        }
        if (i2 < replace$default.length()) {
            String substring2 = replace$default.substring(i2);
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            appendStyledPart(spannableStringBuilder, substring2, i);
        }
        return spannableStringBuilder;
    }

    private static final void appendStyledPart(SpannableStringBuilder spannableStringBuilder, String str, int i) {
        int i2 = 0;
        while (i2 < str.length()) {
            String str2 = str;
            int indexOf$default = StringsKt.indexOf$default((CharSequence) str2, "<strong>", i2, false, 4, (Object) null);
            if (indexOf$default == -1) {
                int length = spannableStringBuilder.length();
                String substring = str.substring(i2);
                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                spannableStringBuilder.append((CharSequence) substring);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(i), length, spannableStringBuilder.length(), 33);
                return;
            }
            if (indexOf$default > i2) {
                int length2 = spannableStringBuilder.length();
                String substring2 = str.substring(i2, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
                spannableStringBuilder.append((CharSequence) substring2);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(i), length2, spannableStringBuilder.length(), 33);
            }
            int indexOf$default2 = StringsKt.indexOf$default((CharSequence) str2, "</strong>", indexOf$default, false, 4, (Object) null);
            if (indexOf$default2 == -1) {
                return;
            }
            String substring3 = str.substring(indexOf$default + 8, indexOf$default2);
            Intrinsics.checkNotNullExpressionValue(substring3, "substring(...)");
            int length3 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) substring3);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i), length3, spannableStringBuilder.length(), 33);
            spannableStringBuilder.setSpan(new StyleSpan(1), length3, spannableStringBuilder.length(), 33);
            i2 = indexOf$default2 + 9;
        }
    }
}
