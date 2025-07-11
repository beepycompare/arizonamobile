package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzpq;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzy {
    final /* synthetic */ zzad zza;
    private String zzb;
    private boolean zzc;
    private com.google.android.gms.internal.measurement.zzii zzd;
    private BitSet zze;
    private BitSet zzf;
    private Map zzg;
    private Map zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzy(zzad zzadVar, String str, com.google.android.gms.internal.measurement.zzii zziiVar, BitSet bitSet, BitSet bitSet2, Map map, Map map2, byte[] bArr) {
        Objects.requireNonNull(zzadVar);
        this.zza = zzadVar;
        this.zzb = str;
        this.zze = bitSet;
        this.zzf = bitSet2;
        this.zzg = map;
        this.zzh = new ArrayMap();
        for (Integer num : map2.keySet()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) map2.get(num));
            this.zzh.put(num, arrayList);
        }
        this.zzc = false;
        this.zzd = zziiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzab zzabVar) {
        int zza = zzabVar.zza();
        Boolean bool = zzabVar.zzd;
        if (bool != null) {
            BitSet bitSet = this.zzf;
            bool.booleanValue();
            bitSet.set(zza, true);
        }
        Boolean bool2 = zzabVar.zze;
        if (bool2 != null) {
            this.zze.set(zza, bool2.booleanValue());
        }
        if (zzabVar.zzf != null) {
            Map map = this.zzg;
            Integer valueOf = Integer.valueOf(zza);
            Long l = (Long) map.get(valueOf);
            long longValue = zzabVar.zzf.longValue() / 1000;
            if (l == null || longValue > l.longValue()) {
                this.zzg.put(valueOf, Long.valueOf(longValue));
            }
        }
        if (zzabVar.zzg != null) {
            Map map2 = this.zzh;
            Integer valueOf2 = Integer.valueOf(zza);
            List list = (List) map2.get(valueOf2);
            if (list == null) {
                list = new ArrayList();
                this.zzh.put(valueOf2, list);
            }
            if (zzabVar.zzb()) {
                list.clear();
            }
            zzpq.zza();
            zzib zzibVar = this.zza.zzu;
            zzal zzc = zzibVar.zzc();
            String str = this.zzb;
            zzfw zzfwVar = zzfx.zzaF;
            if (zzc.zzp(str, zzfwVar) && zzabVar.zzc()) {
                list.clear();
            }
            zzpq.zza();
            if (!zzibVar.zzc().zzp(this.zzb, zzfwVar)) {
                list.add(Long.valueOf(zzabVar.zzg.longValue() / 1000));
                return;
            }
            Long valueOf3 = Long.valueOf(zzabVar.zzg.longValue() / 1000);
            if (list.contains(valueOf3)) {
                return;
            }
            list.add(valueOf3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final com.google.android.gms.internal.measurement.zzhg zzb(int i) {
        ArrayList arrayList;
        List list;
        com.google.android.gms.internal.measurement.zzhf zzh = com.google.android.gms.internal.measurement.zzhg.zzh();
        zzh.zza(i);
        zzh.zzd(this.zzc);
        com.google.android.gms.internal.measurement.zzii zziiVar = this.zzd;
        if (zziiVar != null) {
            zzh.zzc(zziiVar);
        }
        com.google.android.gms.internal.measurement.zzih zzi = com.google.android.gms.internal.measurement.zzii.zzi();
        zzi.zzc(zzpj.zzp(this.zze));
        zzi.zza(zzpj.zzp(this.zzf));
        Map map = this.zzg;
        if (map == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(map.size());
            for (Integer num : this.zzg.keySet()) {
                int intValue = num.intValue();
                Long l = (Long) this.zzg.get(Integer.valueOf(intValue));
                if (l != null) {
                    com.google.android.gms.internal.measurement.zzhp zze = com.google.android.gms.internal.measurement.zzhq.zze();
                    zze.zza(intValue);
                    zze.zzb(l.longValue());
                    arrayList2.add((com.google.android.gms.internal.measurement.zzhq) zze.zzbc());
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            zzi.zze(arrayList);
        }
        Map map2 = this.zzh;
        if (map2 == null) {
            list = Collections.emptyList();
        } else {
            ArrayList arrayList3 = new ArrayList(map2.size());
            for (Integer num2 : this.zzh.keySet()) {
                com.google.android.gms.internal.measurement.zzij zzf = com.google.android.gms.internal.measurement.zzik.zzf();
                zzf.zza(num2.intValue());
                List list2 = (List) this.zzh.get(num2);
                if (list2 != null) {
                    Collections.sort(list2);
                    zzf.zzb(list2);
                }
                arrayList3.add((com.google.android.gms.internal.measurement.zzik) zzf.zzbc());
            }
            list = arrayList3;
        }
        zzi.zzg(list);
        zzh.zzb(zzi);
        return (com.google.android.gms.internal.measurement.zzhg) zzh.zzbc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ BitSet zzc() {
        return this.zze;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzy(zzad zzadVar, String str, byte[] bArr) {
        Objects.requireNonNull(zzadVar);
        this.zza = zzadVar;
        this.zzb = str;
        this.zzc = true;
        this.zze = new BitSet();
        this.zzf = new BitSet();
        this.zzg = new ArrayMap();
        this.zzh = new ArrayMap();
    }
}
