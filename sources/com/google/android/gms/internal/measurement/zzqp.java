package com.google.android.gms.internal.measurement;

import com.google.common.base.Function;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final /* synthetic */ class zzqp implements Function {
    static final /* synthetic */ zzqp zza = new zzqp();

    private /* synthetic */ zzqp() {
    }

    @Override // com.google.common.base.Function
    public final /* synthetic */ Object apply(Object obj) {
        zzmg zzmgVar = (zzmg) obj;
        zzqu zzh = zzqv.zzh();
        if (zzmgVar == null) {
            return (zzqv) zzh.zzbd();
        }
        for (zzmi zzmiVar : zzmgVar.zze()) {
            zzqw zzh2 = zzqx.zzh();
            zzh2.zza(zzmiVar.zza());
            int zzq = zzmiVar.zzq();
            int i = zzq - 1;
            if (zzq == 0) {
                throw null;
            }
            if (i == 0) {
                zzh2.zzb(zzmiVar.zzb());
            } else if (i == 1) {
                zzh2.zzc(zzmiVar.zzc());
            } else if (i == 2) {
                zzh2.zzd(zzmiVar.zzd());
            } else if (i == 3) {
                zzh2.zze(zzmiVar.zze());
            } else if (i == 4) {
                zzh2.zzf(zzmiVar.zzf());
            } else {
                throw new IllegalStateException("No known flag type");
            }
            zzh.zze((zzqx) zzh2.zzbd());
        }
        zzh.zzc(zzmgVar.zzd());
        zzh.zza(zzmgVar.zza());
        zzh.zzd(zzmgVar.zzf());
        if (zzmgVar.zzb()) {
            zzh.zzb(zzmgVar.zzc());
        }
        return (zzqv) zzh.zzbd();
    }
}
