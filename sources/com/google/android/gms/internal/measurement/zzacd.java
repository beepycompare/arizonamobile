package com.google.android.gms.internal.measurement;

import java.io.InputStream;
/* compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* loaded from: classes4.dex */
public abstract class zzacd implements zzafj {
    static {
        int i = zzadf.zzb;
        int i2 = zzacf.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzafj
    public final /* synthetic */ Object zza(InputStream inputStream, zzadf zzadfVar) throws zzaeh {
        zzafy zzafyVar;
        zzacv zzM = zzacv.zzM(inputStream, 4096);
        zzafc zzafcVar = (zzafc) zzb(zzM, zzadfVar);
        zzM.zzb(0);
        if (zzafcVar == null || zzafcVar.zzcJ()) {
            return zzafcVar;
        }
        if (!(zzafcVar instanceof zzacb)) {
            if (zzafcVar instanceof zzacc) {
                zzacc zzaccVar = (zzacc) zzafcVar;
                throw null;
            }
            zzafyVar = new zzafy(zzafcVar);
        } else {
            zzafyVar = new zzafy((zzacb) zzafcVar);
        }
        throw zzafyVar.zza();
    }
}
