package com.google.android.gms.internal.measurement;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzabr {
    public static Object zza(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str.concat(" must not be null"));
    }

    public static void zzb(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void zzc(boolean z, String str) {
        if (!z) {
            throw new IllegalStateException(str);
        }
    }

    public static String zzd(String str) {
        if (zze(str.charAt(0))) {
            for (int i = 1; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (!zze(charAt) && ((charAt < '0' || charAt > '9') && charAt != '_')) {
                    throw new IllegalArgumentException("identifier must contain only ASCII letters, digits or underscore: ".concat(str));
                }
            }
            return str;
        }
        throw new IllegalArgumentException("identifier must start with an ASCII letter: ".concat(str));
    }

    private static boolean zze(char c) {
        if (c < 'a' || c > 'z') {
            return c >= 'A' && c <= 'Z';
        }
        return true;
    }
}
