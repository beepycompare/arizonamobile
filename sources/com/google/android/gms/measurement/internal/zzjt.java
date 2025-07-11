package com.google.android.gms.measurement.internal;

import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
public final class zzjt extends zzay {
    final /* synthetic */ zzli zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzjt(zzli zzliVar, zzjf zzjfVar) {
        super(zzjfVar);
        Objects.requireNonNull(zzliVar);
        this.zza = zzliVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzay
    public final void zza() {
        final zzli zzj = this.zza.zzu.zzj();
        Objects.requireNonNull(zzj);
        new Thread(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjs
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzli.this.zzw();
            }
        }).start();
    }
}
