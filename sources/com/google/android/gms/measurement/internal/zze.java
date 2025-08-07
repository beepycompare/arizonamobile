package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.0.0 */
/* loaded from: classes3.dex */
final class zze {
    private final zzji zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zze(zzji zzjiVar) {
        this.zza = zzjiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zze zzc(String str) {
        zzji zzjiVar;
        if (TextUtils.isEmpty(str) || str.length() > 1) {
            zzjiVar = zzji.UNINITIALIZED;
        } else {
            zzjiVar = zzjl.zzj(str.charAt(0));
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
