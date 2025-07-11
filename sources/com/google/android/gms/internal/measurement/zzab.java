package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzab {
    private zzaa zza;
    private zzaa zzb;
    private final List zzc;

    public zzab() {
        this.zza = new zzaa("", 0L, null);
        this.zzb = new zzaa("", 0L, null);
        this.zzc = new ArrayList();
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzab zzabVar = new zzab(this.zza.clone());
        for (zzaa zzaaVar : this.zzc) {
            zzabVar.zzc.add(zzaaVar.clone());
        }
        return zzabVar;
    }

    public final zzaa zza() {
        return this.zza;
    }

    public final void zzb(zzaa zzaaVar) {
        this.zza = zzaaVar;
        this.zzb = zzaaVar.clone();
        this.zzc.clear();
    }

    public final zzaa zzc() {
        return this.zzb;
    }

    public final void zzd(zzaa zzaaVar) {
        this.zzb = zzaaVar;
    }

    public final void zze(String str, long j, Map map) {
        HashMap hashMap = new HashMap();
        for (String str2 : map.keySet()) {
            hashMap.put(str2, zzaa.zzh(str2, this.zza.zze(str2), map.get(str2)));
        }
        this.zzc.add(new zzaa(str, j, hashMap));
    }

    public final List zzf() {
        return this.zzc;
    }

    public zzab(zzaa zzaaVar) {
        this.zza = zzaaVar;
        this.zzb = zzaaVar.clone();
        this.zzc = new ArrayList();
    }
}
