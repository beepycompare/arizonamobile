package io.appmetrica.analytics.coreutils.internal;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.text.CharsKt;
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0002J\u0012\u0010\u0003\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006"}, d2 = {"Lio/appmetrica/analytics/coreutils/internal/StringExtensions;", "", "", "replaceFirstCharWithTitleCase", "Ljava/util/Locale;", "locale", "core-utils_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class StringExtensions {
    public static final StringExtensions INSTANCE = new StringExtensions();

    private StringExtensions() {
    }

    public final String replaceFirstCharWithTitleCase(String str) {
        return replaceFirstCharWithTitleCase(str, Locale.US);
    }

    public final String replaceFirstCharWithTitleCase(String str, Locale locale) {
        if (str.length() > 0) {
            StringBuilder sb = new StringBuilder();
            char charAt = str.charAt(0);
            return sb.append((Object) (Character.isLowerCase(charAt) ? CharsKt.titlecase(charAt, locale) : String.valueOf(charAt))).append(str.substring(1)).toString();
        }
        return str;
    }
}
