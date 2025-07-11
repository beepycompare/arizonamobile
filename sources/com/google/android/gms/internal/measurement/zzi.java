package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzi {
    public static zzao zza(Object obj) {
        if (obj == null) {
            return zzao.zzg;
        }
        if (obj instanceof String) {
            return new zzas((String) obj);
        }
        if (obj instanceof Double) {
            return new zzah((Double) obj);
        }
        if (obj instanceof Long) {
            return new zzah(Double.valueOf(((Long) obj).doubleValue()));
        }
        if (obj instanceof Integer) {
            return new zzah(Double.valueOf(((Integer) obj).doubleValue()));
        }
        if (obj instanceof Boolean) {
            return new zzaf((Boolean) obj);
        }
        if (obj instanceof Map) {
            zzal zzalVar = new zzal();
            Map map = (Map) obj;
            for (Object obj2 : map.keySet()) {
                zzao zza = zza(map.get(obj2));
                if (obj2 != null) {
                    if (!(obj2 instanceof String)) {
                        obj2 = obj2.toString();
                    }
                    zzalVar.zzm((String) obj2, zza);
                }
            }
            return zzalVar;
        } else if (obj instanceof List) {
            zzae zzaeVar = new zzae();
            for (Object obj3 : (List) obj) {
                zzaeVar.zzn(zzaeVar.zzh(), zza(obj3));
            }
            return zzaeVar;
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    public static zzao zzb(zzje zzjeVar) {
        if (zzjeVar == null) {
            return zzao.zzf;
        }
        int zzj = zzjeVar.zzj() - 1;
        if (zzj == 1) {
            if (zzjeVar.zzc()) {
                return new zzas(zzjeVar.zzd());
            }
            return zzao.zzm;
        } else if (zzj == 2) {
            if (zzjeVar.zzg()) {
                return new zzah(Double.valueOf(zzjeVar.zzh()));
            }
            return new zzah(null);
        } else if (zzj == 3) {
            if (zzjeVar.zze()) {
                return new zzaf(Boolean.valueOf(zzjeVar.zzf()));
            }
            return new zzaf(null);
        } else if (zzj == 4) {
            List<zzje> zza = zzjeVar.zza();
            ArrayList arrayList = new ArrayList();
            for (zzje zzjeVar2 : zza) {
                arrayList.add(zzb(zzjeVar2));
            }
            return new zzap(zzjeVar.zzb(), arrayList);
        } else {
            throw new IllegalArgumentException("Unknown type found. Cannot convert entity");
        }
    }
}
