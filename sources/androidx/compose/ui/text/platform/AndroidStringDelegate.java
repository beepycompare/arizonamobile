package androidx.compose.ui.text.platform;

import androidx.compose.ui.text.PlatformStringDelegate;
import androidx.compose.ui.text.intl.Locale;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
/* compiled from: AndroidStringDelegate.android.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\f"}, d2 = {"Landroidx/compose/ui/text/platform/AndroidStringDelegate;", "Landroidx/compose/ui/text/PlatformStringDelegate;", "<init>", "()V", "toUpperCase", "", TypedValues.Custom.S_STRING, CommonUrlParts.LOCALE, "Landroidx/compose/ui/text/intl/Locale;", "toLowerCase", "capitalize", "decapitalize", "ui-text"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AndroidStringDelegate implements PlatformStringDelegate {
    public static final int $stable = 0;

    @Override // androidx.compose.ui.text.PlatformStringDelegate
    public String toUpperCase(String str, Locale locale) {
        String upperCase = str.toUpperCase(locale.getPlatformLocale());
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    @Override // androidx.compose.ui.text.PlatformStringDelegate
    public String toLowerCase(String str, Locale locale) {
        String lowerCase = str.toLowerCase(locale.getPlatformLocale());
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    @Override // androidx.compose.ui.text.PlatformStringDelegate
    public String capitalize(String str, Locale locale) {
        if (str.length() > 0) {
            StringBuilder sb = new StringBuilder();
            char charAt = str.charAt(0);
            StringBuilder append = sb.append((Object) (Character.isLowerCase(charAt) ? CharsKt.titlecase(charAt, locale.getPlatformLocale()) : String.valueOf(charAt)));
            String substring = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return append.append(substring).toString();
        }
        return str;
    }

    @Override // androidx.compose.ui.text.PlatformStringDelegate
    public String decapitalize(String str, Locale locale) {
        if (str.length() > 0) {
            StringBuilder append = new StringBuilder().append((Object) CharsKt.lowercase(str.charAt(0), locale.getPlatformLocale()));
            String substring = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            return append.append(substring).toString();
        }
        return str;
    }
}
