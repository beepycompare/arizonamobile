package com.google.android.gms.measurement.internal;

import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzpd {
    final String zza;
    long zzb;

    private zzpd(zzpg zzpgVar, String str) {
        Objects.requireNonNull(zzpgVar);
        this.zza = str;
        this.zzb = zzpgVar.zzba().elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzpd(zzpg zzpgVar, String str, byte[] bArr) {
        this(zzpgVar, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzpd(zzpg zzpgVar, byte[] bArr) {
        this(zzpgVar, zzpgVar.zzt().zzaz());
    }
}
