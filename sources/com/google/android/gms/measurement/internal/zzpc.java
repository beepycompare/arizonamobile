package com.google.android.gms.measurement.internal;

import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzpc {
    final String zza;
    long zzb;

    private zzpc(zzpf zzpfVar, String str) {
        Objects.requireNonNull(zzpfVar);
        this.zza = str;
        this.zzb = zzpfVar.zzaZ().elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzpc(zzpf zzpfVar, String str, byte[] bArr) {
        this(zzpfVar, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzpc(zzpf zzpfVar, byte[] bArr) {
        this(zzpfVar, zzpfVar.zzt().zzaw());
    }
}
