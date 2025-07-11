package com.google.android.gms.internal.measurement;

import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzbb extends zzav {
    /* JADX INFO: Access modifiers changed from: protected */
    public zzbb() {
        this.zza.add(zzbk.AND);
        this.zza.add(zzbk.NOT);
        this.zza.add(zzbk.OR);
    }

    @Override // com.google.android.gms.internal.measurement.zzav
    public final zzao zza(String str, zzg zzgVar, List list) {
        zzbk zzbkVar = zzbk.ADD;
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal == 1) {
            zzh.zza(zzbk.AND.name(), 2, list);
            zzao zza = zzgVar.zza((zzao) list.get(0));
            return zza.zze().booleanValue() ? zzgVar.zza((zzao) list.get(1)) : zza;
        } else if (ordinal == 47) {
            zzh.zza(zzbk.NOT.name(), 1, list);
            return new zzaf(Boolean.valueOf(!zzgVar.zza((zzao) list.get(0)).zze().booleanValue()));
        } else if (ordinal == 50) {
            zzh.zza(zzbk.OR.name(), 2, list);
            zzao zza2 = zzgVar.zza((zzao) list.get(0));
            return !zza2.zze().booleanValue() ? zzgVar.zza((zzao) list.get(1)) : zza2;
        } else {
            return super.zzb(str);
        }
    }
}
