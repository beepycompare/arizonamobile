package com.google.android.gms.internal.measurement;

import android.util.Log;
import javax.annotation.Nullable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzkb extends zzkl {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkb(zzkf zzkfVar, String str, Long l, boolean z) {
        super(zzkfVar, str, l, true, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzkl
    @Nullable
    final /* synthetic */ Object zza(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof String) {
            try {
                return Long.valueOf(Long.parseLong((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        String str = this.zzb;
        String obj2 = obj.toString();
        StringBuilder sb = new StringBuilder(str.length() + 25 + obj2.length());
        sb.append("Invalid long value for ");
        sb.append(str);
        sb.append(": ");
        sb.append(obj2);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
