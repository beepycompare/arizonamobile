package com.google.android.gms.internal.measurement;

import java.util.Set;
import java.util.logging.Level;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzaar extends zzaag {
    private final String zza;
    private final Level zzb;
    private final Set zzc;
    private final zzzq zzd;
    private final int zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaar(String str, String str2, boolean z, int i, boolean z2, boolean z3) {
        super(str2);
        Set set;
        zzzq zzzqVar;
        Level level = Level.ALL;
        int i2 = zzaas.zza;
        this.zza = "";
        this.zze = 2;
        this.zzb = level;
        set = zzaas.zzb;
        this.zzc = set;
        zzzqVar = zzaas.zzc;
        this.zzd = zzzqVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzzf
    public final boolean zzb(Level level) {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzzf
    public final void zzc(zzzd zzzdVar) {
        String str = (String) zzzdVar.zzl().zzd(zzyw.zza);
        if (str == null) {
            str = zza();
        }
        if (str == null) {
            str = zzzdVar.zzg().zza();
            int indexOf = str.indexOf(36, str.lastIndexOf(46));
            if (indexOf >= 0) {
                str = str.substring(0, indexOf);
            }
        }
        String str2 = this.zza;
        zzaas.zzi(zzzdVar, zzaal.zza(str2, str, true), 2, this.zzb, this.zzc, this.zzd);
    }
}
