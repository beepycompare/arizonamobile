package com.google.android.gms.measurement.internal;

import android.content.Intent;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzoy extends zzaz {
    final /* synthetic */ zzpg zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzoy(zzpg zzpgVar, zzjg zzjgVar) {
        super(zzjgVar);
        Objects.requireNonNull(zzpgVar);
        this.zza = zzpgVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzaz
    public final void zza() {
        zzpg zzpgVar = this.zza;
        zzpgVar.zzaX().zzg();
        String str = (String) zzpgVar.zzaz().pollFirst();
        if (str != null) {
            zzpgVar.zzaA(zzpgVar.zzba().elapsedRealtime());
            zzpgVar.zzaW().zzk().zzb("Sending trigger URI notification to app", str);
            Intent intent = new Intent();
            intent.setAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
            intent.setPackage(str);
            zzpg.zzaR(zzpgVar.zzaZ(), intent);
        }
        zzpgVar.zzaw();
    }
}
