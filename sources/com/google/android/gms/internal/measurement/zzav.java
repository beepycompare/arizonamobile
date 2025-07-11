package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public abstract class zzav {
    final List zza = new ArrayList();

    public abstract zzao zza(String str, zzg zzgVar, List list);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzao zzb(String str) {
        if (this.zza.contains(zzh.zze(str))) {
            String.valueOf(str);
            throw new UnsupportedOperationException("Command not implemented: ".concat(String.valueOf(str)));
        }
        throw new IllegalArgumentException("Command not supported");
    }
}
