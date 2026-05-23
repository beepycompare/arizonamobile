package com.google.android.gms.internal.measurement;

import android.net.Uri;
import androidx.collection.SimpleArrayMap;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzle {
    private final SimpleArrayMap zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzle(SimpleArrayMap simpleArrayMap) {
        this.zza = simpleArrayMap;
    }

    public final String zza(Uri uri, String str, String str2, String str3) {
        SimpleArrayMap simpleArrayMap = uri != null ? (SimpleArrayMap) this.zza.get(uri.toString()) : null;
        if (simpleArrayMap == null) {
            return null;
        }
        return (String) simpleArrayMap.get(str3);
    }
}
