package com.google.android.gms.internal.measurement;

import java.util.logging.Level;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzaal {
    public static String zza(String str, String str2, boolean z) {
        if (str2.length() > 23) {
            int i = -1;
            for (int length = str2.length() - 1; length >= 0; length--) {
                char charAt = str2.charAt(length);
                if (charAt == '.' || charAt == '$') {
                    i = length;
                    break;
                }
            }
            str2 = str2.substring(i + 1);
        }
        String.valueOf(str2);
        String concat = "".concat(String.valueOf(str2));
        return concat.substring(0, Math.min(concat.length(), 23));
    }

    public static int zzb(Level level) {
        int intValue = level.intValue();
        if (intValue >= Level.SEVERE.intValue()) {
            return 6;
        }
        if (intValue >= Level.WARNING.intValue()) {
            return 5;
        }
        if (intValue >= Level.INFO.intValue()) {
            return 4;
        }
        return intValue >= Level.FINE.intValue() ? 3 : 2;
    }
}
