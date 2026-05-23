package com.google.android.gms.measurement.internal;

import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzmq extends zzaz {
    final /* synthetic */ zznl zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzmq(zznl zznlVar, zzjg zzjgVar) {
        super(zzjgVar);
        Objects.requireNonNull(zznlVar);
        this.zza = zznlVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzaz
    public final void zza() {
        this.zza.zzu.zzaW().zze().zza("Tasks have been queued for a long time");
    }
}
