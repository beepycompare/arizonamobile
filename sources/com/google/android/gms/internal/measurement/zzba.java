package com.google.android.gms.internal.measurement;

import com.adjust.sdk.Constants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzba {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static zzao zza(String str, zzae zzaeVar, zzg zzgVar, List list) {
        char c;
        String str2;
        double d;
        zzae zzaeVar2;
        double min;
        zzai zzaiVar;
        zzae zzaeVar3;
        switch (str.hashCode()) {
            case -1776922004:
                if (str.equals("toString")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case -1354795244:
                if (str.equals("concat")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1274492040:
                if (str.equals("filter")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -934873754:
                if (str.equals("reduce")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case -895859076:
                if (str.equals("splice")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case -678635926:
                if (str.equals("forEach")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -467511597:
                if (str.equals("lastIndexOf")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -277637751:
                if (str.equals("unshift")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case 107868:
                if (str.equals("map")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 111185:
                if (str.equals("pop")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 3267882:
                if (str.equals("join")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 3452698:
                if (str.equals(Constants.PUSH)) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 3536116:
                if (str.equals("some")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 3536286:
                if (str.equals("sort")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 96891675:
                if (str.equals("every")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 109407362:
                if (str.equals("shift")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 109526418:
                if (str.equals("slice")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 965561430:
                if (str.equals("reduceRight")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 1099846370:
                if (str.equals("reverse")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 1943291465:
                if (str.equals("indexOf")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        char c2 = c;
        double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        switch (c2) {
            case 0:
                zzae zzaeVar4 = (zzae) zzaeVar.zzt();
                if (!list.isEmpty()) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        zzao zza = zzgVar.zza((zzao) it.next());
                        if (!(zza instanceof zzag)) {
                            int zzh = zzaeVar4.zzh();
                            if (zza instanceof zzae) {
                                zzae zzaeVar5 = (zzae) zza;
                                Iterator zzg = zzaeVar5.zzg();
                                while (zzg.hasNext()) {
                                    Integer num = (Integer) zzg.next();
                                    zzaeVar4.zzn(num.intValue() + zzh, zzaeVar5.zzl(num.intValue()));
                                }
                            } else {
                                zzaeVar4.zzn(zzh, zza);
                            }
                        } else {
                            throw new IllegalStateException("Failed evaluation of arguments");
                        }
                    }
                }
                return zzaeVar4;
            case 1:
                zzh.zza("every", 1, list);
                zzao zza2 = zzgVar.zza((zzao) list.get(0));
                if (!(zza2 instanceof zzan)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (zzaeVar.zzh() != 0 && zzc(zzaeVar, zzgVar, (zzan) zza2, false, true).zzh() != zzaeVar.zzh()) {
                    return zzao.zzl;
                }
                return zzao.zzk;
            case 2:
                zzh.zza("filter", 1, list);
                zzao zza3 = zzgVar.zza((zzao) list.get(0));
                if (!(zza3 instanceof zzan)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (zzaeVar.zzi() == 0) {
                    return new zzae();
                }
                zzae zzaeVar6 = (zzae) zzaeVar.zzt();
                zzae zzc = zzc(zzaeVar, zzgVar, (zzan) zza3, null, true);
                zzae zzaeVar7 = new zzae();
                Iterator zzg2 = zzc.zzg();
                while (zzg2.hasNext()) {
                    zzaeVar7.zzn(zzaeVar7.zzh(), zzaeVar6.zzl(((Integer) zzg2.next()).intValue()));
                }
                return zzaeVar7;
            case 3:
                zzh.zza("forEach", 1, list);
                zzao zza4 = zzgVar.zza((zzao) list.get(0));
                if (!(zza4 instanceof zzan)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (zzaeVar.zzi() == 0) {
                    return zzao.zzf;
                }
                zzc(zzaeVar, zzgVar, (zzan) zza4, null, null);
                return zzao.zzf;
            case 4:
                zzh.zzc("indexOf", 2, list);
                zzao zzaoVar = zzao.zzf;
                if (!list.isEmpty()) {
                    zzaoVar = zzgVar.zza((zzao) list.get(0));
                }
                if (list.size() > 1) {
                    double zzi = zzh.zzi(zzgVar.zza((zzao) list.get(1)).zzd().doubleValue());
                    if (zzi >= zzaeVar.zzh()) {
                        return new zzah(Double.valueOf(-1.0d));
                    }
                    d2 = zzi < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? zzaeVar.zzh() + zzi : zzi;
                }
                Iterator zzg3 = zzaeVar.zzg();
                while (zzg3.hasNext()) {
                    int intValue = ((Integer) zzg3.next()).intValue();
                    double d3 = intValue;
                    if (d3 >= d2 && zzh.zzf(zzaeVar.zzl(intValue), zzaoVar)) {
                        return new zzah(Double.valueOf(d3));
                    }
                }
                return new zzah(Double.valueOf(-1.0d));
            case 5:
                zzh.zzc("join", 1, list);
                if (zzaeVar.zzh() == 0) {
                    return zzao.zzm;
                }
                if (!list.isEmpty()) {
                    zzao zza5 = zzgVar.zza((zzao) list.get(0));
                    str2 = ((zza5 instanceof zzam) || (zza5 instanceof zzat)) ? "" : zza5.zzc();
                } else {
                    str2 = StringUtils.COMMA;
                }
                return new zzas(zzaeVar.zzs(str2));
            case 6:
                zzh.zzc("lastIndexOf", 2, list);
                zzao zzaoVar2 = zzao.zzf;
                if (!list.isEmpty()) {
                    zzaoVar2 = zzgVar.zza((zzao) list.get(0));
                }
                int zzh2 = zzaeVar.zzh() - 1;
                if (list.size() > 1) {
                    zzao zza6 = zzgVar.zza((zzao) list.get(1));
                    d = Double.isNaN(zza6.zzd().doubleValue()) ? zzaeVar.zzh() - 1 : zzh.zzi(zza6.zzd().doubleValue());
                    if (d < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        d += zzaeVar.zzh();
                    }
                } else {
                    d = zzh2;
                }
                if (d < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    return new zzah(Double.valueOf(-1.0d));
                }
                for (int min2 = (int) Math.min(zzaeVar.zzh(), d); min2 >= 0; min2--) {
                    if (zzaeVar.zzo(min2) && zzh.zzf(zzaeVar.zzl(min2), zzaoVar2)) {
                        return new zzah(Double.valueOf(min2));
                    }
                }
                return new zzah(Double.valueOf(-1.0d));
            case 7:
                zzh.zza("map", 1, list);
                zzao zza7 = zzgVar.zza((zzao) list.get(0));
                if (!(zza7 instanceof zzan)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (zzaeVar.zzh() == 0) {
                    return new zzae();
                }
                return zzc(zzaeVar, zzgVar, (zzan) zza7, null, null);
            case '\b':
                zzh.zza("pop", 0, list);
                int zzh3 = zzaeVar.zzh();
                if (zzh3 == 0) {
                    return zzao.zzf;
                }
                int i = zzh3 - 1;
                zzao zzl = zzaeVar.zzl(i);
                zzaeVar.zzr(i);
                return zzl;
            case '\t':
                if (!list.isEmpty()) {
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        zzaeVar.zzn(zzaeVar.zzh(), zzgVar.zza((zzao) it2.next()));
                    }
                }
                return new zzah(Double.valueOf(zzaeVar.zzh()));
            case '\n':
                return zzb(zzaeVar, zzgVar, list, true);
            case 11:
                return zzb(zzaeVar, zzgVar, list, false);
            case '\f':
                zzaeVar2 = zzaeVar;
                zzh.zza("reverse", 0, list);
                int zzh4 = zzaeVar2.zzh();
                if (zzh4 != 0) {
                    for (int i2 = 0; i2 < zzh4 / 2; i2++) {
                        if (zzaeVar2.zzo(i2)) {
                            zzao zzl2 = zzaeVar2.zzl(i2);
                            zzaeVar2.zzn(i2, null);
                            int i3 = (zzh4 - 1) - i2;
                            if (zzaeVar2.zzo(i3)) {
                                zzaeVar2.zzn(i2, zzaeVar2.zzl(i3));
                            }
                            zzaeVar2.zzn(i3, zzl2);
                        }
                    }
                    break;
                }
                break;
            case '\r':
                zzh.zza("shift", 0, list);
                if (zzaeVar.zzh() == 0) {
                    return zzao.zzf;
                }
                zzao zzl3 = zzaeVar.zzl(0);
                zzaeVar.zzr(0);
                return zzl3;
            case 14:
                zzh.zzc("slice", 2, list);
                if (list.isEmpty()) {
                    return zzaeVar.zzt();
                }
                double zzh5 = zzaeVar.zzh();
                double zzi2 = zzh.zzi(zzgVar.zza((zzao) list.get(0)).zzd().doubleValue());
                if (zzi2 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                    min = Math.max(zzi2 + zzh5, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                } else {
                    min = Math.min(zzi2, zzh5);
                }
                if (list.size() == 2) {
                    double zzi3 = zzh.zzi(zzgVar.zza((zzao) list.get(1)).zzd().doubleValue());
                    if (zzi3 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        zzh5 = Math.max(zzh5 + zzi3, (double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                    } else {
                        zzh5 = Math.min(zzh5, zzi3);
                    }
                }
                zzae zzaeVar8 = new zzae();
                for (int i4 = (int) min; i4 < zzh5; i4++) {
                    zzaeVar8.zzn(zzaeVar8.zzh(), zzaeVar.zzl(i4));
                }
                return zzaeVar8;
            case 15:
                zzh.zza("some", 1, list);
                zzao zza8 = zzgVar.zza((zzao) list.get(0));
                if (!(zza8 instanceof zzai)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (zzaeVar.zzh() == 0) {
                    return zzao.zzl;
                }
                zzai zzaiVar2 = (zzai) zza8;
                Iterator zzg4 = zzaeVar.zzg();
                while (zzg4.hasNext()) {
                    int intValue2 = ((Integer) zzg4.next()).intValue();
                    if (zzaeVar.zzo(intValue2) && zzaiVar2.zza(zzgVar, Arrays.asList(zzaeVar.zzl(intValue2), new zzah(Double.valueOf(intValue2)), zzaeVar)).zze().booleanValue()) {
                        return zzao.zzk;
                    }
                }
                return zzao.zzl;
            case 16:
                zzaeVar2 = zzaeVar;
                zzh.zzc("sort", 1, list);
                if (zzaeVar2.zzh() >= 2) {
                    List<zzao> zzb = zzaeVar2.zzb();
                    if (list.isEmpty()) {
                        zzaiVar = null;
                    } else {
                        zzao zza9 = zzgVar.zza((zzao) list.get(0));
                        if (!(zza9 instanceof zzai)) {
                            throw new IllegalArgumentException("Comparator should be a method");
                        }
                        zzaiVar = (zzai) zza9;
                    }
                    Collections.sort(zzb, new zzaz(zzaiVar, zzgVar));
                    zzaeVar2.zzp();
                    int i5 = 0;
                    for (zzao zzaoVar3 : zzb) {
                        zzaeVar2.zzn(i5, zzaoVar3);
                        i5++;
                    }
                    break;
                }
                break;
            case 17:
                if (list.isEmpty()) {
                    return new zzae();
                }
                int zzi4 = (int) zzh.zzi(zzgVar.zza((zzao) list.get(0)).zzd().doubleValue());
                if (zzi4 < 0) {
                    zzi4 = Math.max(0, zzi4 + zzaeVar.zzh());
                } else if (zzi4 > zzaeVar.zzh()) {
                    zzi4 = zzaeVar.zzh();
                }
                int zzh6 = zzaeVar.zzh();
                zzae zzaeVar9 = new zzae();
                if (list.size() > 1) {
                    int max = Math.max(0, (int) zzh.zzi(zzgVar.zza((zzao) list.get(1)).zzd().doubleValue()));
                    if (max > 0) {
                        for (int i6 = zzi4; i6 < Math.min(zzh6, zzi4 + max); i6++) {
                            zzaeVar9.zzn(zzaeVar9.zzh(), zzaeVar.zzl(zzi4));
                            zzaeVar.zzr(zzi4);
                        }
                    }
                    if (list.size() > 2) {
                        for (int i7 = 2; i7 < list.size(); i7++) {
                            zzao zza10 = zzgVar.zza((zzao) list.get(i7));
                            if (!(zza10 instanceof zzag)) {
                                zzaeVar.zzq((zzi4 + i7) - 2, zza10);
                            } else {
                                throw new IllegalArgumentException("Failed to parse elements to add");
                            }
                        }
                    }
                } else {
                    while (zzi4 < zzh6) {
                        zzaeVar9.zzn(zzaeVar9.zzh(), zzaeVar.zzl(zzi4));
                        zzaeVar.zzn(zzi4, null);
                        zzi4++;
                    }
                }
                return zzaeVar9;
            case 18:
                zzh.zza("toString", 0, list);
                return new zzas(zzaeVar.zzs(StringUtils.COMMA));
            case 19:
                if (list.isEmpty()) {
                    zzaeVar3 = zzaeVar;
                } else {
                    zzae zzaeVar10 = new zzae();
                    Iterator it3 = list.iterator();
                    while (it3.hasNext()) {
                        zzao zza11 = zzgVar.zza((zzao) it3.next());
                        if (!(zza11 instanceof zzag)) {
                            zzaeVar10.zzn(zzaeVar10.zzh(), zza11);
                        } else {
                            throw new IllegalStateException("Argument evaluation failed");
                        }
                    }
                    int zzh7 = zzaeVar10.zzh();
                    Iterator zzg5 = zzaeVar.zzg();
                    while (zzg5.hasNext()) {
                        Integer num2 = (Integer) zzg5.next();
                        zzaeVar10.zzn(num2.intValue() + zzh7, zzaeVar.zzl(num2.intValue()));
                    }
                    zzaeVar3 = zzaeVar;
                    zzaeVar3.zzp();
                    Iterator zzg6 = zzaeVar10.zzg();
                    while (zzg6.hasNext()) {
                        Integer num3 = (Integer) zzg6.next();
                        zzaeVar3.zzn(num3.intValue(), zzaeVar10.zzl(num3.intValue()));
                    }
                }
                return new zzah(Double.valueOf(zzaeVar3.zzh()));
            default:
                throw new IllegalArgumentException("Command not supported");
        }
        return zzaeVar2;
    }

    private static zzao zzb(zzae zzaeVar, zzg zzgVar, List list, boolean z) {
        zzao zzaoVar;
        zzh.zzb("reduce", 1, list);
        zzh.zzc("reduce", 2, list);
        zzao zza = zzgVar.zza((zzao) list.get(0));
        if (!(zza instanceof zzai)) {
            throw new IllegalArgumentException("Callback should be a method");
        }
        if (list.size() == 2) {
            zzaoVar = zzgVar.zza((zzao) list.get(1));
            if (zzaoVar instanceof zzag) {
                throw new IllegalArgumentException("Failed to parse initial value");
            }
        } else if (zzaeVar.zzh() == 0) {
            throw new IllegalStateException("Empty array with no initial value error");
        } else {
            zzaoVar = null;
        }
        zzai zzaiVar = (zzai) zza;
        int zzh = zzaeVar.zzh();
        int i = z ? 0 : zzh - 1;
        int i2 = z ? zzh - 1 : 0;
        int i3 = true == z ? 1 : -1;
        if (zzaoVar == null) {
            zzaoVar = zzaeVar.zzl(i);
            i += i3;
        }
        while ((i2 - i) * i3 >= 0) {
            if (zzaeVar.zzo(i)) {
                zzaoVar = zzaiVar.zza(zzgVar, Arrays.asList(zzaoVar, zzaeVar.zzl(i), new zzah(Double.valueOf(i)), zzaeVar));
                if (zzaoVar instanceof zzag) {
                    throw new IllegalStateException("Reduce operation failed");
                }
                i += i3;
            } else {
                i += i3;
            }
        }
        return zzaoVar;
    }

    private static zzae zzc(zzae zzaeVar, zzg zzgVar, zzai zzaiVar, Boolean bool, Boolean bool2) {
        zzae zzaeVar2 = new zzae();
        Iterator zzg = zzaeVar.zzg();
        while (zzg.hasNext()) {
            int intValue = ((Integer) zzg.next()).intValue();
            if (zzaeVar.zzo(intValue)) {
                zzao zza = zzaiVar.zza(zzgVar, Arrays.asList(zzaeVar.zzl(intValue), new zzah(Double.valueOf(intValue)), zzaeVar));
                if (zza.zze().equals(bool)) {
                    break;
                } else if (bool2 == null || zza.zze().equals(bool2)) {
                    zzaeVar2.zzn(intValue, zza);
                }
            }
        }
        return zzaeVar2;
    }
}
