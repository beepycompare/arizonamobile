package com.google.android.gms.internal.measurement;

import android.util.Log;
import javax.annotation.Nullable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.4.0 */
/* loaded from: classes3.dex */
public final class zzkc extends zzki {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkc(zzkf zzkfVar, String str, Boolean bool, boolean z) {
        super(zzkfVar, str, bool, true, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzki
    @Nullable
    final /* synthetic */ Object zza(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (zzjc.zzc.matcher(str).matches()) {
                return true;
            }
            if (zzjc.zzd.matcher(str).matches()) {
                return false;
            }
        }
        String str2 = this.zzb;
        String obj2 = obj.toString();
        Log.e("PhenotypeFlag", "Invalid boolean value for " + str2 + ": " + obj2);
        return null;
    }
}
