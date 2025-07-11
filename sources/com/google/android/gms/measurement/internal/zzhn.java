package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
final class zzhn implements com.google.android.gms.internal.measurement.zzo {
    final /* synthetic */ String zza;
    final /* synthetic */ zzhs zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhn(zzhs zzhsVar, String str) {
        this.zza = str;
        Objects.requireNonNull(zzhsVar);
        this.zzb = zzhsVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzo
    public final String zza(String str) {
        Map map = (Map) this.zzb.zzD().get(this.zza);
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return (String) map.get(str);
    }
}
