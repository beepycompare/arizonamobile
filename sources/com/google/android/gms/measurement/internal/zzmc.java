package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzmc implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ zzr zzb;
    final /* synthetic */ boolean zzc;
    final /* synthetic */ zznk zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmc(zznk zznkVar, AtomicReference atomicReference, zzr zzrVar, boolean z) {
        this.zza = atomicReference;
        this.zzb = zzrVar;
        this.zzc = z;
        Objects.requireNonNull(zznkVar);
        this.zzd = zznkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        zznk zznkVar;
        zzga zzZ;
        AtomicReference atomicReference2 = this.zza;
        synchronized (atomicReference2) {
            try {
                zznkVar = this.zzd;
                zzZ = zznkVar.zzZ();
            } catch (RemoteException e) {
                this.zzd.zzu.zzaV().zzb().zzb("Failed to get all user properties; remote exception", e);
                atomicReference = this.zza;
            }
            if (zzZ == null) {
                zznkVar.zzu.zzaV().zzb().zza("Failed to get all user properties; not connected to service");
                atomicReference2.notify();
                return;
            }
            zzr zzrVar = this.zzb;
            Preconditions.checkNotNull(zzrVar);
            atomicReference2.set(zzZ.zzj(zzrVar, this.zzc));
            zznkVar.zzV();
            atomicReference = this.zza;
            atomicReference.notify();
        }
    }
}
