package com.google.android.gms.internal.measurement;

import java.util.logging.Level;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public abstract class zzxo extends zzxz implements zzyi {
    /* JADX INFO: Access modifiers changed from: protected */
    public zzxo(Level level, boolean z) {
        super(level, false);
    }

    @Override // com.google.android.gms.internal.measurement.zzxz
    protected final zzabn zza() {
        return zzabl.zza();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzxz
    public final boolean zzb(zzyd zzydVar) {
        zzzj zzl = zzl();
        int zza = zzl.zza();
        int i = 0;
        while (true) {
            if (i >= zza) {
                break;
            } else if (zzl.zzb(i).zzd() != "eye3tag") {
                i++;
            } else if (zzl.zzd(zzxx.zza) == null) {
                zzyl zzylVar = zzxx.zzi;
                if (zzl.zzd(zzylVar) == null) {
                    zzm(zzylVar, zzyv.SMALL);
                }
            }
        }
        return super.zzb(zzydVar);
    }
}
