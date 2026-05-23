package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzzn extends zzzq {
    private final Map zza;
    private final Map zzb;
    private final zzzp zzc;
    private final zzzo zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzzn(zzzm zzzmVar, byte[] bArr) {
        HashMap hashMap = new HashMap();
        this.zza = hashMap;
        HashMap hashMap2 = new HashMap();
        this.zzb = hashMap2;
        hashMap.putAll(zzzmVar.zzd());
        hashMap2.putAll(zzzmVar.zze());
        this.zzc = zzzmVar.zzf();
        this.zzd = zzzmVar.zzg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzzq
    public final void zza(zzyl zzylVar, Object obj, Object obj2) {
        zzzp zzzpVar = (zzzp) this.zza.get(zzylVar);
        if (zzzpVar != null) {
            zzzpVar.zza(zzylVar, obj, obj2);
        } else {
            this.zzc.zza(zzylVar, obj, obj2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzzq
    public final void zzb(zzyl zzylVar, Iterator it, Object obj) {
        zzzo zzzoVar = (zzzo) this.zzb.get(zzylVar);
        if (zzzoVar != null) {
            zzzoVar.zza(zzylVar, it, obj);
            return;
        }
        zzzo zzzoVar2 = this.zzd;
        if (zzzoVar2 == null || this.zza.containsKey(zzylVar)) {
            while (it.hasNext()) {
                zza(zzylVar, it.next(), obj);
            }
            return;
        }
        zzzoVar2.zza(zzylVar, it, obj);
    }
}
