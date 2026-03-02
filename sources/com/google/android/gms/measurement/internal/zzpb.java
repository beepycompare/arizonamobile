package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@23.0.0 */
/* loaded from: classes4.dex */
public final class zzpb implements zzpo {
    final /* synthetic */ zzpg zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpb(zzpg zzpgVar) {
        Objects.requireNonNull(zzpgVar);
        this.zza = zzpgVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzpo
    public final void zza(String str, String str2, Bundle bundle) {
        boolean isEmpty = TextUtils.isEmpty(str);
        zzpg zzpgVar = this.zza;
        if (isEmpty) {
            if (zzpgVar.zzax() != null) {
                zzpgVar.zzax().zzaV().zzb().zzb("AppId not known when logging event", str2);
                return;
            }
            return;
        }
        zzpgVar.zzaW().zzj(new zzpa(this, str, str2, bundle));
    }
}
