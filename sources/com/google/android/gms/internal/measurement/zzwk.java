package com.google.android.gms.internal.measurement;

import androidx.collection.SimpleArrayMap;
import com.google.common.base.Preconditions;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzwk extends zzwl {
    static final zzwl zza;
    static final zzwl zzb;

    static {
        zzwj zzwjVar;
        zzwl zzb2 = new zzwk(null, new SimpleArrayMap(0)).zzb();
        zza = zzb2;
        zzwk zzwkVar = new zzwk(zzb2, new SimpleArrayMap(), null);
        Preconditions.checkState(!zzwkVar.zzh(), "Can't mutate after handing to trace");
        Preconditions.checkNotNull(true);
        zzwjVar = zzwl.zza;
        Preconditions.checkState(true ^ zzwkVar.zzd(zzwjVar), "Key already present");
        zzwkVar.zzg().put(zzwjVar, true);
        zzb = zzwkVar.zzb();
    }

    private zzwk(zzwl zzwlVar, SimpleArrayMap simpleArrayMap) {
        super(null, simpleArrayMap, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzwk(zzwl zzwlVar, SimpleArrayMap simpleArrayMap, byte[] bArr) {
        super(zzwlVar, simpleArrayMap, null);
    }
}
