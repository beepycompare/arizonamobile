package com.google.android.gms.internal.measurement;

import android.net.Uri;
import android.os.Process;
import com.google.android.vending.expansion.downloader.Constants;
import java.util.concurrent.atomic.AtomicLong;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
final class zzsu {
    private static final AtomicLong zza = new AtomicLong();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Uri zza(Uri uri) {
        int myPid = Process.myPid();
        long id = Thread.currentThread().getId();
        long currentTimeMillis = System.currentTimeMillis();
        long andIncrement = zza.getAndIncrement();
        int length = String.valueOf(myPid).length();
        int length2 = String.valueOf(id).length();
        StringBuilder sb = new StringBuilder(length + 15 + length2 + 1 + String.valueOf(currentTimeMillis).length() + 1 + String.valueOf(andIncrement).length());
        sb.append(".mobstore_tmp-");
        sb.append(myPid);
        sb.append(Constants.FILENAME_SEQUENCE_SEPARATOR);
        sb.append(id);
        sb.append(Constants.FILENAME_SEQUENCE_SEPARATOR);
        sb.append(currentTimeMillis);
        sb.append(Constants.FILENAME_SEQUENCE_SEPARATOR);
        sb.append(andIncrement);
        String sb2 = sb.toString();
        Uri.Builder buildUpon = uri.buildUpon();
        String path = uri.getPath();
        String.valueOf(path);
        return buildUpon.path(String.valueOf(path).concat(sb2)).build();
    }
}
