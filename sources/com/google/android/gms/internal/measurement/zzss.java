package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.io.InputStream;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzss implements zzrt {
    private final zzafj zza;
    private final zzadf zzb = zzadf.zza();

    private zzss(zzafj zzafjVar) {
        this.zza = zzafjVar;
    }

    public static zzss zzb(zzafc zzafcVar) {
        return new zzss(zzafcVar.zzcj());
    }

    @Override // com.google.android.gms.internal.measurement.zzrt
    public final /* bridge */ /* synthetic */ Object zza(zzrs zzrsVar) throws IOException {
        InputStream zzc = zzst.zzc(zzrsVar);
        try {
            zzafc zzafcVar = (zzafc) this.zza.zza(zzc, this.zzb);
            if (zzc != null) {
                zzc.close();
            }
            return zzafcVar;
        } catch (Throwable th) {
            if (zzc != null) {
                try {
                    zzc.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
