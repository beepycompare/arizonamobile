package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.5.0 */
/* loaded from: classes3.dex */
final class zzjo extends ContentObserver {
    final /* synthetic */ zzjq zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzjo(zzjq zzjqVar, Handler handler) {
        super(null);
        Objects.requireNonNull(zzjqVar);
        this.zza = zzjqVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.zza.zzc();
    }
}
