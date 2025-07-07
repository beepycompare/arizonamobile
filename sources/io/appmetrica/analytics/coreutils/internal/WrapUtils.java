package io.appmetrica.analytics.coreutils.internal;

import android.text.TextUtils;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class WrapUtils {
    public static double getFiniteDoubleOrDefault(double d, double d2) {
        return Double.isFinite(d) ? d : d2;
    }

    public static long getMillisOrDefault(Long l, TimeUnit timeUnit, long j) {
        return l == null ? j : timeUnit.toMillis(l.longValue());
    }

    public static <T> T getOrDefault(T t, T t2) {
        return t == null ? t2 : t;
    }

    public static String getOrDefaultIfEmpty(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : str;
    }

    public static <T> T getOrDefaultNullable(T t, T t2) {
        return t == null ? t2 : t;
    }

    public static String getOrDefaultNullableIfEmpty(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : str;
    }

    public static <T> String wrapToTag(T t) {
        if (t == null) {
            return "<null>";
        }
        if (t.toString().isEmpty()) {
            return "<empty>";
        }
        return t.toString();
    }
}
