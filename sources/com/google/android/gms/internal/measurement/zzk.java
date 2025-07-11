package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzk extends zzai {
    private final zzab zza;

    public zzk(zzab zzabVar) {
        super("internal.eventLogger");
        this.zza = zzabVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzai
    public final zzao zza(zzg zzgVar, List list) {
        Map hashMap;
        zzh.zza(this.zzd, 3, list);
        String zzc = zzgVar.zza((zzao) list.get(0)).zzc();
        long zzi = (long) zzh.zzi(zzgVar.zza((zzao) list.get(1)).zzd().doubleValue());
        zzao zza = zzgVar.zza((zzao) list.get(2));
        if (zza instanceof zzal) {
            hashMap = zzh.zzk((zzal) zza);
        } else {
            hashMap = new HashMap();
        }
        this.zza.zze(zzc, zzi, hashMap);
        return zzao.zzf;
    }
}
