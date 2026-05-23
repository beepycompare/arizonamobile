package com.google.android.gms.internal.measurement;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.UUID;
import java.util.function.Consumer;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzwa extends zzwb {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwa() {
        super(null);
    }

    @Override // com.google.android.gms.internal.measurement.zzwb
    public final zzwi zza(String str, zzxd zzxdVar) {
        boolean z;
        zzwq zzwqVar;
        zzws zzj;
        zzwl zzwlVar = zzwk.zza;
        Preconditions.checkNotNull(zzxdVar);
        zzwq zzd = zzvy.zzd();
        zzws zzwsVar = zzd.zzb;
        if (zzwsVar == zzwg.zza) {
            zzvy.zzc(zzd, null);
            z = true;
            zzwsVar = null;
        } else {
            z = false;
        }
        if (zzwsVar == null) {
            final UUID zzc = zzvz.zza().zzc();
            String zzcL = zzvn.zzcL(zzc);
            zzvq zzvqVar = zzwd.zza;
            ImmutableSet zza = zzvy.zza();
            if (!zza.isEmpty()) {
                zza.forEach(new Consumer(zzc, null) { // from class: com.google.android.gms.internal.measurement.zzwe
                    @Override // java.util.function.Consumer
                    public final /* synthetic */ void accept(Object obj) {
                        ((zzwu) obj).zza();
                    }
                });
            }
            zzwqVar = zzd;
            zzj = new zzwf(zzc, zzcL, str, zzwlVar, zzvqVar, false, false, zzwqVar);
        } else {
            zzwqVar = zzd;
            if (zzwsVar instanceof zzvs) {
                zzj = ((zzvs) zzwsVar).zzg(str, zzwlVar, false, zzwqVar);
            } else {
                zzj = zzwsVar.zzj(str, "", "", 0, zzwlVar, zzwqVar);
            }
        }
        zzvy.zzc(zzwqVar, zzj);
        return new zzwi(zzj, z);
    }
}
