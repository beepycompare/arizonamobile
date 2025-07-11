package com.google.android.gms.internal.measurement;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.List;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
final class zzx extends zzai {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzx(zzy zzyVar, String str) {
        super("getVersion");
        Objects.requireNonNull(zzyVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzai
    public final zzao zza(zzg zzgVar, List list) {
        return new zzah(Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
    }
}
