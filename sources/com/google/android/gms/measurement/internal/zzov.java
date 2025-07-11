package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzov implements zzgv {
    final /* synthetic */ String zza;
    final /* synthetic */ List zzb;
    final /* synthetic */ zzpf zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzov(zzpf zzpfVar, String str, List list) {
        this.zza = str;
        this.zzb = list;
        Objects.requireNonNull(zzpfVar);
        this.zzc = zzpfVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzgv
    public final void zza(String str, int i, Throwable th, byte[] bArr, Map map) {
        this.zzc.zzU(true, i, th, bArr, this.zza, this.zzb);
    }
}
