package com.google.android.gms.internal.measurement;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzsr implements zzrt {
    private boolean zza = false;

    static {
        new AtomicInteger();
    }

    private zzsr() {
    }

    public static zzsr zzb() {
        return new zzsr();
    }

    @Override // com.google.android.gms.internal.measurement.zzrt
    public final /* bridge */ /* synthetic */ Object zza(zzrs zzrsVar) throws IOException {
        if (this.zza) {
            if (zzrsVar.zze()) {
                throw new zzsk("Short circuit would skip transforms.");
            }
            return zzrsVar.zza().zzg(zzrsVar.zzb());
        }
        zzsj zza = zzsj.zza(zzst.zzc(zzrsVar));
        try {
            if (!(zza.zzb() instanceof zzsf)) {
                throw new IOException("Not convertible and fallback to pipe is disabled.");
            }
            File zza2 = ((zzsf) zza.zzb()).zza();
            zza.close();
            return zza2;
        } catch (Throwable th) {
            try {
                zza.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final zzsr zzc() {
        this.zza = true;
        return this;
    }
}
