package com.google.android.gms.internal.measurement;

import android.net.Uri;
import androidx.collection.ArrayMap;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzka {
    public static final /* synthetic */ int zza = 0;
    private static final ArrayMap zzb = new ArrayMap();

    public static synchronized Uri zza(String str) {
        synchronized (zzka.class) {
            ArrayMap arrayMap = zzb;
            Uri uri = (Uri) arrayMap.get("com.google.android.gms.measurement");
            if (uri == null) {
                String encode = Uri.encode("com.google.android.gms.measurement");
                String.valueOf(encode);
                Uri parse = Uri.parse("content://com.google.android.gms.phenotype/".concat(String.valueOf(encode)));
                arrayMap.put("com.google.android.gms.measurement", parse);
                return parse;
            }
            return uri;
        }
    }
}
