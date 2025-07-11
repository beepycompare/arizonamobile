package com.google.android.gms.internal.measurement;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzc {
    final zzf zza;
    zzg zzb;
    final zzab zzc;
    private final zzz zzd;

    public zzc() {
        zzf zzfVar = new zzf();
        this.zza = zzfVar;
        this.zzb = zzfVar.zzb.zzc();
        this.zzc = new zzab();
        this.zzd = new zzz();
        zzfVar.zzd.zza("internal.registerCallback", new Callable() { // from class: com.google.android.gms.internal.measurement.zzb
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return zzc.this.zzg();
            }
        });
        zzfVar.zzd.zza("internal.eventLogger", new Callable() { // from class: com.google.android.gms.internal.measurement.zza
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return new zzk(zzc.this.zzc);
            }
        });
    }

    public final void zza(String str, Callable callable) {
        this.zza.zzd.zza(str, callable);
    }

    public final boolean zzb(zzaa zzaaVar) throws zzd {
        try {
            zzab zzabVar = this.zzc;
            zzabVar.zzb(zzaaVar);
            this.zza.zzc.zze("runtime.counter", new zzah(Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)));
            this.zzd.zzb(this.zzb.zzc(), zzabVar);
            if (zzc()) {
                return true;
            }
            return zzd();
        } catch (Throwable th) {
            throw new zzd(th);
        }
    }

    public final boolean zzc() {
        zzab zzabVar = this.zzc;
        return !zzabVar.zzc().equals(zzabVar.zza());
    }

    public final boolean zzd() {
        return !this.zzc.zzf().isEmpty();
    }

    public final zzab zze() {
        return this.zzc;
    }

    public final void zzf(zzja zzjaVar) throws zzd {
        zzai zzaiVar;
        try {
            zzf zzfVar = this.zza;
            this.zzb = zzfVar.zzb.zzc();
            if (zzfVar.zza(this.zzb, (zzje[]) zzjaVar.zza().toArray(new zzje[0])) instanceof zzag) {
                throw new IllegalStateException("Program loading failed");
            }
            for (zziy zziyVar : zzjaVar.zzb().zza()) {
                List zzb = zziyVar.zzb();
                String zza = zziyVar.zza();
                Iterator it = zzb.iterator();
                while (it.hasNext()) {
                    zzao zza2 = zzfVar.zza(this.zzb, (zzje) it.next());
                    if (zza2 instanceof zzal) {
                        zzg zzgVar = this.zzb;
                        if (zzgVar.zzd(zza)) {
                            zzao zzh = zzgVar.zzh(zza);
                            if (zzh instanceof zzai) {
                                zzaiVar = (zzai) zzh;
                            } else {
                                String.valueOf(zza);
                                throw new IllegalStateException("Invalid function name: ".concat(String.valueOf(zza)));
                            }
                        } else {
                            zzaiVar = null;
                        }
                        if (zzaiVar != null) {
                            zzaiVar.zza(this.zzb, Collections.singletonList(zza2));
                        } else {
                            String.valueOf(zza);
                            throw new IllegalStateException("Rule function is undefined: ".concat(String.valueOf(zza)));
                        }
                    } else {
                        throw new IllegalArgumentException("Invalid rule definition");
                    }
                }
            }
        } catch (Throwable th) {
            throw new zzd(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzai zzg() {
        return new zzv(this.zzd);
    }
}
