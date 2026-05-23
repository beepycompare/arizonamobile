package com.google.android.gms.internal.measurement;

import com.google.common.base.Preconditions;
import java.util.UUID;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public abstract class zzvt extends zzvn {
    private final zzwl zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzvt(String str, zzws zzwsVar, zzwl zzwlVar, zzwq zzwqVar) {
        super(str, zzwsVar, zzwqVar);
        Preconditions.checkArgument(zzwlVar.zze());
        this.zza = zzwlVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzws
    public final zzwl zzh() {
        return zzwl.zza(this.zza, zzl());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzvt(String str, UUID uuid, String str2, zzwl zzwlVar, zzwq zzwqVar) {
        super(str, uuid, str2, zzwqVar);
        Preconditions.checkArgument(zzwlVar.zze());
        this.zza = zzwlVar;
    }
}
