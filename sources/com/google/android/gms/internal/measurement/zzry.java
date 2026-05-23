package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.os.SystemClock;
import java.io.File;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzry {
    public static File zza(Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir == null) {
            SystemClock.sleep(100L);
            File filesDir2 = context.getFilesDir();
            if (filesDir2 != null) {
                return filesDir2;
            }
            throw new IllegalStateException("getFilesDir returned null twice.");
        }
        return filesDir;
    }
}
