package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
final class zze {
    private final zzjh zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zze(zzjh zzjhVar) {
        this.zza = zzjhVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zze zzc(String str) {
        zzjh zzjhVar;
        if (TextUtils.isEmpty(str) || str.length() > 1) {
            zzjhVar = zzjh.UNINITIALIZED;
        } else {
            zzjhVar = zzjk.zzj(str.charAt(0));
        }
        return new zze(zzjhVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzjh zza() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzb() {
        return String.valueOf(zzjk.zzm(this.zza));
    }
}
