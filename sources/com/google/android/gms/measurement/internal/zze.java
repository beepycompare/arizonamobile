package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
final class zze {
    private final zzji zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zze(zzji zzjiVar) {
        this.zza = zzjiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zze zzc(String str) {
        zzji zzjiVar;
        if (!TextUtils.isEmpty(str) && str.length() <= 1) {
            zzjiVar = zzjl.zzj(str.charAt(0));
        } else {
            zzjiVar = zzji.UNINITIALIZED;
        }
        return new zze(zzjiVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzji zza() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzb() {
        return String.valueOf(zzjl.zzm(this.zza));
    }
}
