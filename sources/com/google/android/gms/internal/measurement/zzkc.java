package com.google.android.gms.internal.measurement;

import android.util.Log;
import javax.annotation.Nullable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzkc extends zzkl {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkc(zzkf zzkfVar, String str, Boolean bool, boolean z) {
        super(zzkfVar, str, bool, true, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzkl
    @Nullable
    final /* synthetic */ Object zza(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (zzjg.zzc.matcher(str).matches()) {
                return true;
            }
            if (zzjg.zzd.matcher(str).matches()) {
                return false;
            }
        }
        String str2 = this.zzb;
        String obj2 = obj.toString();
        StringBuilder sb = new StringBuilder(str2.length() + 28 + obj2.length());
        sb.append("Invalid boolean value for ");
        sb.append(str2);
        sb.append(": ");
        sb.append(obj2);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}
