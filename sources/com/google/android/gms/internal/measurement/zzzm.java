package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzzm {
    private static final zzzp zza = new zzzk();
    private static final zzzo zzb = new zzzl();
    private final zzzp zze;
    private final Map zzc = new HashMap();
    private final Map zzd = new HashMap();
    private zzzo zzf = null;

    public final zzzm zza(zzzo zzzoVar) {
        this.zzf = zzzoVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(zzyl zzylVar) {
        zzabr.zza(zzylVar, "key");
        if (zzylVar.zzf()) {
            zzzo zzzoVar = zzb;
            zzabr.zza(zzylVar, "key");
            zzabr.zzb(zzylVar.zzf(), "key must be repeating");
            this.zzc.remove(zzylVar);
            this.zzd.put(zzylVar, zzzoVar);
            return;
        }
        zzzp zzzpVar = zza;
        zzabr.zza(zzylVar, "key");
        this.zzd.remove(zzylVar);
        this.zzc.put(zzylVar, zzzpVar);
    }

    public final zzzq zzc() {
        return new zzzn(this, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Map zzd() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Map zze() {
        return this.zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzzp zzf() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzzo zzg() {
        return this.zzf;
    }
}
