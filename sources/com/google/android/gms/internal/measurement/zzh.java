package com.google.android.gms.internal.measurement;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzh {
    public static void zza(String str, int i, List list) {
        if (list.size() != i) {
            throw new IllegalArgumentException(String.format("%s operation requires %s parameters found %s", str, Integer.valueOf(i), Integer.valueOf(list.size())));
        }
    }

    public static void zzb(String str, int i, List list) {
        if (list.size() < i) {
            throw new IllegalArgumentException(String.format("%s operation requires at least %s parameters found %s", str, Integer.valueOf(i), Integer.valueOf(list.size())));
        }
    }

    public static void zzc(String str, int i, List list) {
        if (list.size() > i) {
            throw new IllegalArgumentException(String.format("%s operation requires at most %s parameters found %s", str, Integer.valueOf(i), Integer.valueOf(list.size())));
        }
    }

    public static boolean zzd(zzao zzaoVar) {
        if (zzaoVar == null) {
            return false;
        }
        Double zzd = zzaoVar.zzd();
        return !zzd.isNaN() && zzd.doubleValue() >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && zzd.equals(Double.valueOf(Math.floor(zzd.doubleValue())));
    }

    public static zzbk zze(String str) {
        zzbk zzbkVar = null;
        if (str != null && !str.isEmpty()) {
            zzbkVar = zzbk.zza(Integer.parseInt(str));
        }
        if (zzbkVar != null) {
            return zzbkVar;
        }
        throw new IllegalArgumentException(String.format("Unsupported commandId %s", str));
    }

    public static boolean zzf(zzao zzaoVar, zzao zzaoVar2) {
        if (zzaoVar.getClass().equals(zzaoVar2.getClass())) {
            if ((zzaoVar instanceof zzat) || (zzaoVar instanceof zzam)) {
                return true;
            }
            if (zzaoVar instanceof zzah) {
                if (Double.isNaN(zzaoVar.zzd().doubleValue()) || Double.isNaN(zzaoVar2.zzd().doubleValue())) {
                    return false;
                }
                return zzaoVar.zzd().equals(zzaoVar2.zzd());
            } else if (zzaoVar instanceof zzas) {
                return zzaoVar.zzc().equals(zzaoVar2.zzc());
            } else {
                if (zzaoVar instanceof zzaf) {
                    return zzaoVar.zze().equals(zzaoVar2.zze());
                }
                return zzaoVar == zzaoVar2;
            }
        }
        return false;
    }

    public static int zzg(double d) {
        int i;
        if (Double.isNaN(d) || Double.isInfinite(d) || d == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return 0;
        }
        return (int) (((i > 0 ? 1 : -1) * Math.floor(Math.abs(d))) % 4.294967296E9d);
    }

    public static long zzh(double d) {
        return zzg(d) & 4294967295L;
    }

    public static double zzi(double d) {
        int i;
        if (Double.isNaN(d)) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        if (Double.isInfinite(d) || d == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || i == 0) {
            return d;
        }
        return (i > 0 ? 1 : -1) * Math.floor(Math.abs(d));
    }

    public static Object zzj(zzao zzaoVar) {
        if (zzao.zzg.equals(zzaoVar)) {
            return null;
        }
        if (zzao.zzf.equals(zzaoVar)) {
            return "";
        }
        if (zzaoVar instanceof zzal) {
            return zzk((zzal) zzaoVar);
        }
        if (zzaoVar instanceof zzae) {
            ArrayList arrayList = new ArrayList();
            Iterator it = ((zzae) zzaoVar).iterator();
            while (it.hasNext()) {
                Object zzj = zzj((zzao) it.next());
                if (zzj != null) {
                    arrayList.add(zzj);
                }
            }
            return arrayList;
        } else if (!zzaoVar.zzd().isNaN()) {
            return zzaoVar.zzd();
        } else {
            return zzaoVar.zzc();
        }
    }

    public static Map zzk(zzal zzalVar) {
        HashMap hashMap = new HashMap();
        for (String str : zzalVar.zzb()) {
            Object zzj = zzj(zzalVar.zzk(str));
            if (zzj != null) {
                hashMap.put(str, zzj);
            }
        }
        return hashMap;
    }

    public static int zzl(zzg zzgVar) {
        int zzg = zzg(zzgVar.zzh("runtime.counter").zzd().doubleValue() + 1.0d);
        if (zzg <= 1000000) {
            zzgVar.zze("runtime.counter", new zzah(Double.valueOf(zzg)));
            return zzg;
        }
        throw new IllegalStateException("Instructions allowed exceeded");
    }
}
