package com.google.android.play.core.splitinstall.internal;

import com.google.android.vending.expansion.downloader.Constants;
import java.io.File;
/* compiled from: com.google.android.play:feature-delivery@@2.1.0 */
/* loaded from: classes4.dex */
public final class zzbw {
    public static String zza(File file) {
        if (!file.getName().endsWith(".apk")) {
            throw new IllegalArgumentException("Non-apk found in splits directory.");
        }
        String replaceFirst = file.getName().replaceFirst("(_\\d+)?\\.apk", "");
        if (replaceFirst.equals("base-master") || replaceFirst.equals("base-main")) {
            return "";
        }
        if (replaceFirst.startsWith("base-")) {
            return replaceFirst.replace("base-", "config.");
        }
        return replaceFirst.replace(Constants.FILENAME_SEQUENCE_SEPARATOR, ".config.").replace(".config.master", "").replace(".config.main", "");
    }
}
