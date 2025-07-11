package com.google.android.gms.internal.measurement;

import java.util.List;
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzbi extends zzav {
    @Override // com.google.android.gms.internal.measurement.zzav
    public final zzao zza(String str, zzg zzgVar, List list) {
        if (str == null || str.isEmpty() || !zzgVar.zzd(str)) {
            throw new IllegalArgumentException(String.format("Command not found: %s", str));
        }
        zzao zzh = zzgVar.zzh(str);
        if (!(zzh instanceof zzai)) {
            throw new IllegalArgumentException(String.format("Function %s is not defined", str));
        }
        return ((zzai) zzh).zza(zzgVar, list);
    }
}
