package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.ConnectionResult;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzne implements Runnable {
    final /* synthetic */ ConnectionResult zza;
    final /* synthetic */ zznf zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzne(zznf zznfVar, ConnectionResult connectionResult) {
        this.zza = connectionResult;
        Objects.requireNonNull(zznfVar);
        this.zzb = zznfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zznl zznlVar = this.zzb.zza;
        zznlVar.zzaa(null);
        if (this.zza.getErrorCode() == 7777) {
            if (zznlVar.zzab() == null) {
                zznlVar.zzac(Executors.newScheduledThreadPool(1));
            }
            zznlVar.zzab().schedule(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznc
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    final zznl zznlVar2 = zzne.this.zzb.zza;
                    zzhz zzaX = zznlVar2.zzu.zzaX();
                    Objects.requireNonNull(zznlVar2);
                    zzaX.zzj(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznd
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            zznl.this.zzI();
                        }
                    });
                }
            }, ((Long) zzfy.zzZ.zzb(null)).longValue(), TimeUnit.MILLISECONDS);
            return;
        }
        zznlVar.zzX();
    }
}
