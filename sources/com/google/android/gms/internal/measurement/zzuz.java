package com.google.android.gms.internal.measurement;

import android.net.Uri;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzuz {
    public static Uri zza(Uri uri, String str) {
        Uri.Builder buildUpon = uri.buildUpon();
        String path = uri.getPath();
        String.valueOf(path);
        return buildUpon.path(String.valueOf(path).concat(str)).build();
    }
}
