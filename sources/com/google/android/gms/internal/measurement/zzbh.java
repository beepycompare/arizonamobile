package com.google.android.gms.internal.measurement;

import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzbh extends zzav {
    /* JADX INFO: Access modifiers changed from: protected */
    public zzbh() {
        this.zza.add(zzbk.ADD);
        this.zza.add(zzbk.DIVIDE);
        this.zza.add(zzbk.MODULUS);
        this.zza.add(zzbk.MULTIPLY);
        this.zza.add(zzbk.NEGATE);
        this.zza.add(zzbk.POST_DECREMENT);
        this.zza.add(zzbk.POST_INCREMENT);
        this.zza.add(zzbk.PRE_DECREMENT);
        this.zza.add(zzbk.PRE_INCREMENT);
        this.zza.add(zzbk.SUBTRACT);
    }

    @Override // com.google.android.gms.internal.measurement.zzav
    public final zzao zza(String str, zzg zzgVar, List list) {
        zzbk zzbkVar = zzbk.ADD;
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal == 0) {
            zzh.zza(zzbk.ADD.name(), 2, list);
            zzao zza = zzgVar.zza((zzao) list.get(0));
            zzao zza2 = zzgVar.zza((zzao) list.get(1));
            if ((zza instanceof zzak) || (zza instanceof zzas) || (zza2 instanceof zzak) || (zza2 instanceof zzas)) {
                String zzc = zza.zzc();
                String zzc2 = zza2.zzc();
                String.valueOf(zzc);
                String.valueOf(zzc2);
                return new zzas(String.valueOf(zzc).concat(String.valueOf(zzc2)));
            }
            return new zzah(Double.valueOf(zza.zzd().doubleValue() + zza2.zzd().doubleValue()));
        } else if (ordinal == 21) {
            zzh.zza(zzbk.DIVIDE.name(), 2, list);
            return new zzah(Double.valueOf(zzgVar.zza((zzao) list.get(0)).zzd().doubleValue() / zzgVar.zza((zzao) list.get(1)).zzd().doubleValue()));
        } else if (ordinal == 59) {
            zzh.zza(zzbk.SUBTRACT.name(), 2, list);
            return new zzah(Double.valueOf(zzgVar.zza((zzao) list.get(0)).zzd().doubleValue() + new zzah(Double.valueOf(-zzgVar.zza((zzao) list.get(1)).zzd().doubleValue())).zzd().doubleValue()));
        } else if (ordinal == 52 || ordinal == 53) {
            zzh.zza(str, 2, list);
            zzao zza3 = zzgVar.zza((zzao) list.get(0));
            zzgVar.zza((zzao) list.get(1));
            return zza3;
        } else if (ordinal != 55 && ordinal != 56) {
            switch (ordinal) {
                case 44:
                    zzh.zza(zzbk.MODULUS.name(), 2, list);
                    return new zzah(Double.valueOf(zzgVar.zza((zzao) list.get(0)).zzd().doubleValue() % zzgVar.zza((zzao) list.get(1)).zzd().doubleValue()));
                case 45:
                    zzh.zza(zzbk.MULTIPLY.name(), 2, list);
                    return new zzah(Double.valueOf(zzgVar.zza((zzao) list.get(0)).zzd().doubleValue() * zzgVar.zza((zzao) list.get(1)).zzd().doubleValue()));
                case 46:
                    zzh.zza(zzbk.NEGATE.name(), 1, list);
                    return new zzah(Double.valueOf(-zzgVar.zza((zzao) list.get(0)).zzd().doubleValue()));
                default:
                    return super.zzb(str);
            }
        } else {
            zzh.zza(str, 1, list);
            return zzgVar.zza((zzao) list.get(0));
        }
    }
}
