package com.google.android.gms.measurement.internal;

import android.content.Intent;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzox extends zzay {
    final /* synthetic */ zzpf zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzox(zzpf zzpfVar, zzjf zzjfVar) {
        super(zzjfVar);
        Objects.requireNonNull(zzpfVar);
        this.zza = zzpfVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzay
    public final void zza() {
        zzpf zzpfVar = this.zza;
        zzpfVar.zzaW().zzg();
        String str = (String) zzpfVar.zzax().pollFirst();
        if (str != null) {
            zzpfVar.zzay(zzpfVar.zzaZ().elapsedRealtime());
            zzpfVar.zzaV().zzk().zzb("Sending trigger URI notification to app", str);
            Intent intent = new Intent();
            intent.setAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
            intent.setPackage(str);
            zzpf.zzaP(zzpfVar.zzaY(), intent);
        }
        zzpfVar.zzau();
    }
}
