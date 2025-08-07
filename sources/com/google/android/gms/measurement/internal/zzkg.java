package com.google.android.gms.measurement.internal;

import androidx.media3.exoplayer.ExoPlayer;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.0.0 */
/* loaded from: classes3.dex */
public final class zzkg extends zzay {
    final /* synthetic */ zzlj zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzkg(zzlj zzljVar, zzjg zzjgVar) {
        super(zzjgVar);
        Objects.requireNonNull(zzljVar);
        this.zza = zzljVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzay
    public final void zza() {
        zzlj zzljVar = this.zza;
        if (zzljVar.zzu.zzI()) {
            zzljVar.zzap().zzb(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
    }
}
