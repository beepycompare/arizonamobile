package io.appmetrica.analytics.impl;

import com.google.android.vending.expansion.downloader.Constants;
import java.util.UUID;
/* loaded from: classes4.dex */
public final class jo {
    public static boolean a(String str) {
        UUID uuid;
        if (str == null || str.length() != 32) {
            return false;
        }
        try {
            uuid = UUID.fromString(b(str));
        } catch (Throwable unused) {
            uuid = null;
        }
        return uuid != null;
    }

    public static String b(String str) {
        return str.substring(0, 8) + Constants.FILENAME_SEQUENCE_SEPARATOR + str.substring(8, 12) + Constants.FILENAME_SEQUENCE_SEPARATOR + str.substring(12, 16) + Constants.FILENAME_SEQUENCE_SEPARATOR + str.substring(16, 20) + Constants.FILENAME_SEQUENCE_SEPARATOR + str.substring(20, 32);
    }
}
