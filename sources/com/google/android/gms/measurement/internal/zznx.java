package com.google.android.gms.measurement.internal;

import androidx.media3.exoplayer.ExoPlayer;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zznx {
    final /* synthetic */ zzob zza;
    private zznw zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zznx(zzob zzobVar) {
        Objects.requireNonNull(zzobVar);
        this.zza = zzobVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza() {
        zzob zzobVar = this.zza;
        zzobVar.zzg();
        zznw zznwVar = this.zzb;
        if (zznwVar != null) {
            zzobVar.zzm().removeCallbacks(zznwVar);
        }
        zzib zzibVar = zzobVar.zzu;
        zzibVar.zzd().zzn.zzb(false);
        zzobVar.zzh(false);
        if (zzibVar.zzc().zzp(null, zzfx.zzaT)) {
            zzib zzibVar2 = zzobVar.zzu;
            if (zzibVar2.zzj().zzx()) {
                zzibVar.zzaV().zzk().zza("Retrying trigger URI registration in foreground");
                zzibVar2.zzj().zzz();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(long j) {
        zzob zzobVar = this.zza;
        this.zzb = new zznw(this, zzobVar.zzu.zzaZ().currentTimeMillis(), j);
        zzobVar.zzm().postDelayed(this.zzb, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }
}
