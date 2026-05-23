package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import androidx.collection.ArrayMap;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzlg {
    public static final /* synthetic */ int zza = 0;
    private static final ArrayMap zzb = new ArrayMap();

    public static synchronized Uri zza(String str) {
        synchronized (zzlg.class) {
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

    public static String zzb(Context context, String str, boolean z) {
        if (str.contains("#")) {
            String.valueOf(str);
            throw new IllegalArgumentException("The passed in package cannot already have a subpackage: ".concat(String.valueOf(str)));
        }
        String packageName = context.getPackageName();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(packageName).length());
        sb.append(str);
        sb.append("#");
        sb.append(packageName);
        return sb.toString();
    }
}
