package androidx.compose.foundation.text.input.internal;

import android.os.Build;
import androidx.compose.ui.text.style.TextDirection;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.Locale;
import kotlin.Metadata;
/* compiled from: TextFieldLayoutStateCache.android.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\u0000¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"resolveTextDirectionForKeyboardTypePhone", "Landroidx/compose/ui/text/style/TextDirection;", CommonUrlParts.LOCALE, "Ljava/util/Locale;", "Landroidx/compose/ui/text/intl/PlatformLocale;", "(Ljava/util/Locale;)I", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldLayoutStateCache_androidKt {
    public static final int resolveTextDirectionForKeyboardTypePhone(Locale locale) {
        byte resolve;
        if (Build.VERSION.SDK_INT >= 28) {
            resolve = DigitDirectionalityApi28.INSTANCE.resolve(locale);
        } else {
            resolve = DigitDirectionalityApi24.INSTANCE.resolve(locale);
        }
        if (resolve == 1 || resolve == 2) {
            return TextDirection.Companion.m6586getRtls_7Xco();
        }
        return TextDirection.Companion.m6585getLtrs_7Xco();
    }
}
