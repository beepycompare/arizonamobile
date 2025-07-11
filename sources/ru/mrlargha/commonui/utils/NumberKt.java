package ru.mrlargha.commonui.utils;

import android.content.res.Resources;
import android.util.TypedValue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
/* compiled from: Number.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0007\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\f\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u0005¨\u0006\u0006"}, d2 = {"toPx", "", "", "formatPhoneNumber", "", "", "CommonUI_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NumberKt {
    public static final float toPx(Number number) {
        Intrinsics.checkNotNullParameter(number, "<this>");
        return TypedValue.applyDimension(1, number.floatValue(), Resources.getSystem().getDisplayMetrics());
    }

    public static final String formatPhoneNumber(int i) {
        String valueOf = String.valueOf(i);
        int length = valueOf.length();
        if (length == 6) {
            return new Regex("^(\\d{2})(\\d{2})(\\d{2})$").replaceFirst(valueOf, "$1-$2-$3");
        } else if (length != 7) {
            return null;
        } else {
            return new Regex("^(\\d{3})(\\d{3})(\\d{1})$").replaceFirst(valueOf, "$1-$2-$3");
        }
    }
}
