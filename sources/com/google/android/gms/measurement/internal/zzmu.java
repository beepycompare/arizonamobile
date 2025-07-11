package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzmu implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzr zzd;
    final /* synthetic */ zznk zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmu(zznk zznkVar, AtomicReference atomicReference, String str, String str2, String str3, zzr zzrVar) {
        this.zza = atomicReference;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = zzrVar;
        Objects.requireNonNull(zznkVar);
        this.zze = zznkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        zznk zznkVar;
        zzga zzZ;
        AtomicReference atomicReference2 = this.zza;
        synchronized (atomicReference2) {
            try {
                zznkVar = this.zze;
                zzZ = zznkVar.zzZ();
            } catch (RemoteException e) {
                this.zze.zzu.zzaV().zzb().zzd("(legacy) Failed to get conditional properties; remote exception", null, this.zzb, e);
                this.zza.set(Collections.emptyList());
                atomicReference = this.zza;
            }
            if (zzZ != null) {
                if (!TextUtils.isEmpty(null)) {
                    atomicReference2.set(zzZ.zzs(null, this.zzb, this.zzc));
                } else {
                    zzr zzrVar = this.zzd;
                    Preconditions.checkNotNull(zzrVar);
                    atomicReference2.set(zzZ.zzr(this.zzb, this.zzc, zzrVar));
                }
                zznkVar.zzV();
                atomicReference = this.zza;
                atomicReference.notify();
                return;
            }
            zznkVar.zzu.zzaV().zzb().zzd("(legacy) Failed to get conditional properties; not connected to service", null, this.zzb, this.zzc);
            atomicReference2.set(Collections.emptyList());
            atomicReference2.notify();
        }
    }
}
