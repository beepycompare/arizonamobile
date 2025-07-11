package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzmb implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzr zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ com.google.android.gms.internal.measurement.zzcu zze;
    final /* synthetic */ zznk zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmb(zznk zznkVar, String str, String str2, zzr zzrVar, boolean z, com.google.android.gms.internal.measurement.zzcu zzcuVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzrVar;
        this.zzd = z;
        this.zze = zzcuVar;
        Objects.requireNonNull(zznkVar);
        this.zzf = zznkVar;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x00b3: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:38:0x00b2 */
    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle;
        RemoteException e;
        Bundle bundle2;
        Bundle bundle3 = new Bundle();
        try {
            try {
                zznk zznkVar = this.zzf;
                zzga zzZ = zznkVar.zzZ();
                if (zzZ == null) {
                    zzib zzibVar = zznkVar.zzu;
                    zzibVar.zzaV().zzb().zzc("Failed to get user properties; not connected to service", this.zza, this.zzb);
                    zzibVar.zzk().zzaq(this.zze, bundle3);
                    return;
                }
                zzr zzrVar = this.zzc;
                Preconditions.checkNotNull(zzrVar);
                List<zzpk> zzp = zzZ.zzp(this.zza, this.zzb, this.zzd, zzrVar);
                int i = zzpo.zza;
                bundle = new Bundle();
                if (zzp != null) {
                    for (zzpk zzpkVar : zzp) {
                        String str = zzpkVar.zze;
                        if (str != null) {
                            bundle.putString(zzpkVar.zzb, str);
                        } else {
                            Long l = zzpkVar.zzd;
                            if (l != null) {
                                bundle.putLong(zzpkVar.zzb, l.longValue());
                            } else {
                                Double d = zzpkVar.zzg;
                                if (d != null) {
                                    bundle.putDouble(zzpkVar.zzb, d.doubleValue());
                                }
                            }
                        }
                    }
                }
                try {
                    zznkVar.zzV();
                    zzib zzibVar2 = zznkVar.zzu;
                    zzibVar2.zzk().zzaq(this.zze, bundle);
                } catch (RemoteException e2) {
                    e = e2;
                    this.zzf.zzu.zzaV().zzb().zzc("Failed to get user properties; remote exception", this.zza, e);
                    zznk zznkVar2 = this.zzf;
                    zznkVar2.zzu.zzk().zzaq(this.zze, bundle);
                }
            } catch (Throwable th) {
                th = th;
                bundle3 = bundle2;
                zznk zznkVar3 = this.zzf;
                zznkVar3.zzu.zzk().zzaq(this.zze, bundle3);
                throw th;
            }
        } catch (RemoteException e3) {
            bundle = bundle3;
            e = e3;
        } catch (Throwable th2) {
            th = th2;
            zznk zznkVar32 = this.zzf;
            zznkVar32.zzu.zzk().zzaq(this.zze, bundle3);
            throw th;
        }
    }
}
