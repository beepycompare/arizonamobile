package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
final class zzgw implements Runnable {
    private final zzgv zza;
    private final int zzb;
    private final Throwable zzc;
    private final byte[] zzd;
    private final String zze;
    private final Map zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgw(String str, zzgv zzgvVar, int i, Throwable th, byte[] bArr, Map map, byte[] bArr2) {
        Preconditions.checkNotNull(zzgvVar);
        this.zza = zzgvVar;
        this.zzb = i;
        this.zzc = th;
        this.zzd = bArr;
        this.zze = str;
        this.zzf = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zza(this.zze, this.zzb, this.zzc, this.zzd, this.zzf);
    }
}
