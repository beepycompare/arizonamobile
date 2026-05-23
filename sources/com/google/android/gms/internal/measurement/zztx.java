package com.google.android.gms.internal.measurement;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zztx extends zzuw {
    private static final zzuw zza = new zztx();

    private zztx() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ zzuw zzc() {
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzuw
    public final String zza(zzti zztiVar) {
        Preconditions.checkNotNull(zztiVar);
        return "singleproc";
    }

    @Override // com.google.android.gms.internal.measurement.zzuw
    public final /* bridge */ /* synthetic */ zzuv zzb(zztr zztrVar, String str, Executor executor, zzru zzruVar, zzti zztiVar) {
        zzadf zza2;
        Preconditions.checkNotNull(zztiVar);
        if (zztrVar.zzf()) {
            zza2 = zzadf.zzb();
        } else {
            zza2 = zzadf.zza();
        }
        return new zzui(str, Futures.immediateFuture(zztrVar.zza()), zzve.zzd(zztrVar.zzb(), zza2), executor, zzruVar, zztrVar.zzc(), zzwb.zzb());
    }
}
