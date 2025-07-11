package com.google.android.gms.internal.measurement;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzax extends zzav {
    public zzax() {
        this.zza.add(zzbk.EQUALS);
        this.zza.add(zzbk.GREATER_THAN);
        this.zza.add(zzbk.GREATER_THAN_EQUALS);
        this.zza.add(zzbk.IDENTITY_EQUALS);
        this.zza.add(zzbk.IDENTITY_NOT_EQUALS);
        this.zza.add(zzbk.LESS_THAN);
        this.zza.add(zzbk.LESS_THAN_EQUALS);
        this.zza.add(zzbk.NOT_EQUALS);
    }

    private static boolean zzc(zzao zzaoVar, zzao zzaoVar2) {
        int i;
        if (zzaoVar instanceof zzak) {
            zzaoVar = new zzas(zzaoVar.zzc());
        }
        if (zzaoVar2 instanceof zzak) {
            zzaoVar2 = new zzas(zzaoVar2.zzc());
        }
        if ((zzaoVar instanceof zzas) && (zzaoVar2 instanceof zzas)) {
            return zzaoVar.zzc().compareTo(zzaoVar2.zzc()) < 0;
        }
        double doubleValue = zzaoVar.zzd().doubleValue();
        double doubleValue2 = zzaoVar2.zzd().doubleValue();
        return (Double.isNaN(doubleValue) || Double.isNaN(doubleValue2) || (doubleValue == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && doubleValue2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) || ((i == 0 && doubleValue2 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) || Double.compare(doubleValue, doubleValue2) >= 0)) ? false : true;
    }

    private static boolean zzd(zzao zzaoVar, zzao zzaoVar2) {
        if (zzaoVar.getClass().equals(zzaoVar2.getClass())) {
            if ((zzaoVar instanceof zzat) || (zzaoVar instanceof zzam)) {
                return true;
            }
            if (zzaoVar instanceof zzah) {
                return (Double.isNaN(zzaoVar.zzd().doubleValue()) || Double.isNaN(zzaoVar2.zzd().doubleValue()) || zzaoVar.zzd().doubleValue() != zzaoVar2.zzd().doubleValue()) ? false : true;
            } else if (zzaoVar instanceof zzas) {
                return zzaoVar.zzc().equals(zzaoVar2.zzc());
            } else {
                if (zzaoVar instanceof zzaf) {
                    return zzaoVar.zze().equals(zzaoVar2.zze());
                }
                return zzaoVar == zzaoVar2;
            }
        } else if (((zzaoVar instanceof zzat) || (zzaoVar instanceof zzam)) && ((zzaoVar2 instanceof zzat) || (zzaoVar2 instanceof zzam))) {
            return true;
        } else {
            boolean z = zzaoVar instanceof zzah;
            if (!z || !(zzaoVar2 instanceof zzas)) {
                boolean z2 = zzaoVar instanceof zzas;
                if (!z2 || !(zzaoVar2 instanceof zzah)) {
                    if (zzaoVar instanceof zzaf) {
                        return zzd(new zzah(zzaoVar.zzd()), zzaoVar2);
                    }
                    if (zzaoVar2 instanceof zzaf) {
                        return zzd(zzaoVar, new zzah(zzaoVar2.zzd()));
                    }
                    if ((z2 || z) && (zzaoVar2 instanceof zzak)) {
                        return zzd(zzaoVar, new zzas(zzaoVar2.zzc()));
                    }
                    if ((zzaoVar instanceof zzak) && ((zzaoVar2 instanceof zzas) || (zzaoVar2 instanceof zzah))) {
                        return zzd(new zzas(zzaoVar.zzc()), zzaoVar2);
                    }
                    return false;
                }
                return zzd(new zzah(zzaoVar.zzd()), zzaoVar2);
            }
            return zzd(zzaoVar, new zzah(zzaoVar2.zzd()));
        }
    }

    private static boolean zze(zzao zzaoVar, zzao zzaoVar2) {
        if (zzaoVar instanceof zzak) {
            zzaoVar = new zzas(zzaoVar.zzc());
        }
        if (zzaoVar2 instanceof zzak) {
            zzaoVar2 = new zzas(zzaoVar2.zzc());
        }
        return (((zzaoVar instanceof zzas) && (zzaoVar2 instanceof zzas)) || !(Double.isNaN(zzaoVar.zzd().doubleValue()) || Double.isNaN(zzaoVar2.zzd().doubleValue()))) && !zzc(zzaoVar2, zzaoVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzav
    public final zzao zza(String str, zzg zzgVar, List list) {
        boolean zzd;
        boolean zzd2;
        zzh.zza(zzh.zze(str).name(), 2, list);
        zzao zza = zzgVar.zza((zzao) list.get(0));
        zzao zza2 = zzgVar.zza((zzao) list.get(1));
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal != 23) {
            if (ordinal == 48) {
                zzd2 = zzd(zza, zza2);
            } else if (ordinal == 42) {
                zzd = zzc(zza, zza2);
            } else if (ordinal == 43) {
                zzd = zze(zza, zza2);
            } else {
                switch (ordinal) {
                    case 37:
                        zzd = zzc(zza2, zza);
                        break;
                    case 38:
                        zzd = zze(zza2, zza);
                        break;
                    case 39:
                        zzd = zzh.zzf(zza, zza2);
                        break;
                    case 40:
                        zzd2 = zzh.zzf(zza, zza2);
                        break;
                    default:
                        return super.zzb(str);
                }
            }
            zzd = !zzd2;
        } else {
            zzd = zzd(zza, zza2);
        }
        return zzd ? zzao.zzk : zzao.zzl;
    }
}
