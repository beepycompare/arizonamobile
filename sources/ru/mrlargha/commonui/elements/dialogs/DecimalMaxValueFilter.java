package ru.mrlargha.commonui.elements.dialogs;

import android.text.InputFilter;
import android.text.Spanned;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
/* compiled from: DecimalMaxValueFilter.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ:\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lru/mrlargha/commonui/elements/dialogs/DecimalMaxValueFilter;", "Landroid/text/InputFilter;", "maxValue", "", "maxDigitsBeforeDot", "", "maxDigitsAfterDot", "<init>", "(DII)V", "filter", "", "source", TtmlNode.START, TtmlNode.END, "dest", "Landroid/text/Spanned;", "dstart", "dend", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DecimalMaxValueFilter implements InputFilter {
    private final int maxDigitsAfterDot;
    private final int maxDigitsBeforeDot;
    private final double maxValue;

    public DecimalMaxValueFilter() {
        this(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 0, 0, 7, null);
    }

    public DecimalMaxValueFilter(double d, int i, int i2) {
        this.maxValue = d;
        this.maxDigitsBeforeDot = i;
        this.maxDigitsAfterDot = i2;
    }

    public /* synthetic */ DecimalMaxValueFilter(double d, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 999.999d : d, (i3 & 2) != 0 ? 3 : i, (i3 & 4) != 0 ? 3 : i2);
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence source, int i, int i2, Spanned dest, int i3, int i4) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(dest, "dest");
        String sb = new StringBuilder(dest).replace(i3, i4, source.subSequence(i, i2).toString()).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        String str = sb;
        if (str.length() == 0) {
            return null;
        }
        if (!new Regex("^\\d{0," + this.maxDigitsBeforeDot + "}(\\.\\d{0," + this.maxDigitsAfterDot + "})?$").matches(str)) {
            return "";
        }
        int i5 = 0;
        for (int i6 = 0; i6 < str.length(); i6++) {
            if (str.charAt(i6) == '.') {
                i5++;
            }
        }
        if (i5 > 1) {
            return "";
        }
        Double doubleOrNull = StringsKt.toDoubleOrNull(sb);
        if (doubleOrNull == null || doubleOrNull.doubleValue() <= this.maxValue) {
            return null;
        }
        return "";
    }
}
