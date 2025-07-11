package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzkb implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ Bundle zzd;
    final /* synthetic */ boolean zze;
    final /* synthetic */ boolean zzf;
    final /* synthetic */ boolean zzg;
    final /* synthetic */ String zzh;
    final /* synthetic */ zzli zzi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkb(zzli zzliVar, String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = j;
        this.zzd = bundle;
        this.zze = z;
        this.zzf = z2;
        this.zzg = z3;
        this.zzh = str3;
        Objects.requireNonNull(zzliVar);
        this.zzi = zzliVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzi.zzH(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh);
    }
}
