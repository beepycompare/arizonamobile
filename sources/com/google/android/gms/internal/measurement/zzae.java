package com.google.android.gms.internal.measurement;

import com.adjust.sdk.Constants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzae implements Iterable, zzao, zzak {
    final SortedMap zza;
    final Map zzb;

    public zzae() {
        this.zza = new TreeMap();
        this.zzb = new TreeMap();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzae) {
            zzae zzaeVar = (zzae) obj;
            if (zzh() != zzaeVar.zzh()) {
                return false;
            }
            SortedMap sortedMap = this.zza;
            if (sortedMap.isEmpty()) {
                return zzaeVar.zza.isEmpty();
            }
            for (int intValue = ((Integer) sortedMap.firstKey()).intValue(); intValue <= ((Integer) sortedMap.lastKey()).intValue(); intValue++) {
                if (!zzl(intValue).equals(zzaeVar.zzl(intValue))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() * 31;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new zzad(this);
    }

    public final String toString() {
        return zzs(StringUtils.COMMA);
    }

    public final List zzb() {
        ArrayList arrayList = new ArrayList(zzh());
        for (int i = 0; i < zzh(); i++) {
            arrayList.add(zzl(i));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final String zzc() {
        return zzs(StringUtils.COMMA);
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final zzao zzcA(String str, zzg zzgVar, List list) {
        if ("concat".equals(str) || "every".equals(str) || "filter".equals(str) || "forEach".equals(str) || "indexOf".equals(str) || "join".equals(str) || "lastIndexOf".equals(str) || "map".equals(str) || "pop".equals(str) || Constants.PUSH.equals(str) || "reduce".equals(str) || "reduceRight".equals(str) || "reverse".equals(str) || "shift".equals(str) || "slice".equals(str) || "some".equals(str) || "sort".equals(str) || "splice".equals(str) || "toString".equals(str) || "unshift".equals(str)) {
            return zzba.zza(str, this, zzgVar, list);
        }
        return zzak.zzu(this, new zzas(str), zzgVar, list);
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Double zzd() {
        SortedMap sortedMap = this.zza;
        if (sortedMap.size() == 1) {
            return zzl(0).zzd();
        }
        if (sortedMap.size() <= 0) {
            return Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        }
        return Double.valueOf(Double.NaN);
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Boolean zze() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Iterator zzf() {
        return new zzac(this, this.zza.keySet().iterator(), this.zzb.keySet().iterator());
    }

    public final Iterator zzg() {
        return this.zza.keySet().iterator();
    }

    public final int zzh() {
        SortedMap sortedMap = this.zza;
        if (sortedMap.isEmpty()) {
            return 0;
        }
        return ((Integer) sortedMap.lastKey()).intValue() + 1;
    }

    public final int zzi() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzak
    public final boolean zzj(String str) {
        return "length".equals(str) || this.zzb.containsKey(str);
    }

    @Override // com.google.android.gms.internal.measurement.zzak
    public final zzao zzk(String str) {
        zzao zzaoVar;
        if ("length".equals(str)) {
            return new zzah(Double.valueOf(zzh()));
        }
        return (!zzj(str) || (zzaoVar = (zzao) this.zzb.get(str)) == null) ? zzf : zzaoVar;
    }

    public final zzao zzl(int i) {
        zzao zzaoVar;
        if (i < zzh()) {
            return (!zzo(i) || (zzaoVar = (zzao) this.zza.get(Integer.valueOf(i))) == null) ? zzf : zzaoVar;
        }
        throw new IndexOutOfBoundsException("Attempting to get element outside of current array");
    }

    @Override // com.google.android.gms.internal.measurement.zzak
    public final void zzm(String str, zzao zzaoVar) {
        if (zzaoVar == null) {
            this.zzb.remove(str);
        } else {
            this.zzb.put(str, zzaoVar);
        }
    }

    public final boolean zzo(int i) {
        if (i >= 0) {
            SortedMap sortedMap = this.zza;
            if (i <= ((Integer) sortedMap.lastKey()).intValue()) {
                return sortedMap.containsKey(Integer.valueOf(i));
            }
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 21);
        sb.append("Out of bounds index: ");
        sb.append(i);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final void zzp() {
        this.zza.clear();
    }

    public final void zzr(int i) {
        SortedMap sortedMap = this.zza;
        int intValue = ((Integer) sortedMap.lastKey()).intValue();
        if (i > intValue || i < 0) {
            return;
        }
        sortedMap.remove(Integer.valueOf(i));
        if (i == intValue) {
            int i2 = i - 1;
            Integer valueOf = Integer.valueOf(i2);
            if (sortedMap.containsKey(valueOf) || i2 < 0) {
                return;
            }
            sortedMap.put(valueOf, zzao.zzf);
            return;
        }
        while (true) {
            i++;
            if (i > ((Integer) sortedMap.lastKey()).intValue()) {
                return;
            }
            Integer valueOf2 = Integer.valueOf(i);
            zzao zzaoVar = (zzao) sortedMap.get(valueOf2);
            if (zzaoVar != null) {
                sortedMap.put(Integer.valueOf(i - 1), zzaoVar);
                sortedMap.remove(valueOf2);
            }
        }
    }

    public final String zzs(String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        if (!this.zza.isEmpty()) {
            int i = 0;
            while (true) {
                str2 = str == null ? "" : str;
                if (i >= zzh()) {
                    break;
                }
                zzao zzl = zzl(i);
                sb.append(str2);
                if (!(zzl instanceof zzat) && !(zzl instanceof zzam)) {
                    sb.append(zzl.zzc());
                }
                i++;
            }
            sb.delete(0, str2.length());
        }
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final zzao zzt() {
        zzae zzaeVar = new zzae();
        for (Map.Entry entry : this.zza.entrySet()) {
            if (entry.getValue() instanceof zzak) {
                zzaeVar.zza.put((Integer) entry.getKey(), (zzao) entry.getValue());
            } else {
                zzaeVar.zza.put((Integer) entry.getKey(), ((zzao) entry.getValue()).zzt());
            }
        }
        return zzaeVar;
    }

    @RequiresNonNull({"elements"})
    public final void zzn(int i, zzao zzaoVar) {
        if (i > 32468) {
            throw new IllegalStateException("Array too large");
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 21);
            sb.append("Out of bounds index: ");
            sb.append(i);
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (zzaoVar == null) {
            this.zza.remove(Integer.valueOf(i));
        } else {
            this.zza.put(Integer.valueOf(i), zzaoVar);
        }
    }

    public final void zzq(int i, zzao zzaoVar) {
        if (i < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 21);
            sb.append("Invalid value index: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        } else if (i >= zzh()) {
            zzn(i, zzaoVar);
        } else {
            SortedMap sortedMap = this.zza;
            for (int intValue = ((Integer) sortedMap.lastKey()).intValue(); intValue >= i; intValue--) {
                Integer valueOf = Integer.valueOf(intValue);
                zzao zzaoVar2 = (zzao) sortedMap.get(valueOf);
                if (zzaoVar2 != null) {
                    zzn(intValue + 1, zzaoVar2);
                    sortedMap.remove(valueOf);
                }
            }
            zzn(i, zzaoVar);
        }
    }

    public zzae(List list) {
        this();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                zzn(i, (zzao) list.get(i));
            }
        }
    }
}
