package com.arizona.launcher;

import android.os.Bundle;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
/* compiled from: UpdateAnalyticsReporter.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002\u001a\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0002¨\u0006\u0007"}, d2 = {"toBundle", "Landroid/os/Bundle;", "", "", "", "hostOf", "url", "app"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UpdateAnalyticsReporterKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle toBundle(Map<String, ? extends Object> map) {
        Bundle bundle = new Bundle();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                bundle.putString(key, (String) value);
            } else if (value instanceof Integer) {
                bundle.putInt(key, ((Number) value).intValue());
            } else if (value instanceof Long) {
                bundle.putLong(key, ((Number) value).longValue());
            } else if (!(value instanceof Boolean)) {
                throw new IllegalStateException(("Unsupported updater analytics value for '" + key + "': " + value.getClass().getName()).toString());
            } else {
                bundle.putBoolean(key, ((Boolean) value).booleanValue());
            }
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String hostOf(String str) {
        String str2 = str;
        if (str2 == null || StringsKt.isBlank(str2)) {
            return null;
        }
        String substringAfter = StringsKt.substringAfter(str, "://", "");
        if (substringAfter.length() == 0) {
            return null;
        }
        String lowerCase = StringsKt.substringBefore$default(StringsKt.substringBefore$default(substringAfter, '/', (String) null, 2, (Object) null), (char) AbstractJsonLexerKt.COLON, (String) null, 2, (Object) null).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String str3 = lowerCase;
        return StringsKt.isBlank(str3) ? null : str3;
    }
}
