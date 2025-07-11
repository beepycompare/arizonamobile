package kotlinx.datetime.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: util.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0002H\u0000\u001a\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0002\u001a\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0000\u001a\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0000\u001a\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0000¨\u0006\r"}, d2 = {"isAsciiDigit", "", "", "isAsciiLetter", "asciiDigitToInt", "", "removeLeadingZerosFromLongYearForm", "", "input", "minStringLengthAfterYear", "removeLeadingZerosFromLongYearFormLocalDate", "removeLeadingZerosFromLongYearFormLocalDateTime", "removeLeadingZerosFromLongYearFormYearMonth", "kotlinx-datetime"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UtilKt {
    public static final int asciiDigitToInt(char c) {
        return c - '0';
    }

    public static final boolean isAsciiDigit(char c) {
        return '0' <= c && c < ':';
    }

    public static final boolean isAsciiLetter(char c) {
        if ('A' > c || c >= '[') {
            return 'a' <= c && c < '{';
        }
        return true;
    }

    private static final String removeLeadingZerosFromLongYearForm(String str, int i) {
        String str2;
        int indexOf$default;
        if (str.length() >= i + 12) {
            int i2 = 0;
            if (StringsKt.contains$default((CharSequence) "+-", str.charAt(0), false, 2, (Object) null) && (indexOf$default = StringsKt.indexOf$default((CharSequence) (str2 = str), '-', 1, false, 4, (Object) null)) >= 12) {
                while (true) {
                    int i3 = i2 + 1;
                    if (str.charAt(i3) != '0') {
                        break;
                    }
                    i2 = i3;
                }
                return indexOf$default - i2 >= 12 ? str : StringsKt.removeRange((CharSequence) str2, 1, indexOf$default - 10).toString();
            }
            return str;
        }
        return str;
    }

    public static final String removeLeadingZerosFromLongYearFormLocalDate(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return removeLeadingZerosFromLongYearForm(input.toString(), 6);
    }

    public static final String removeLeadingZerosFromLongYearFormLocalDateTime(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return removeLeadingZerosFromLongYearForm(input.toString(), 12);
    }

    public static final String removeLeadingZerosFromLongYearFormYearMonth(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return removeLeadingZerosFromLongYearForm(input.toString(), 3);
    }
}
