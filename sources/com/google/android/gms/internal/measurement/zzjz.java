package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.internal.ListenerHolder;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
final class zzjz implements ListenerHolder.Notifier {
    final /* synthetic */ byte[] zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjz(zzka zzkaVar, byte[] bArr) {
        this.zza = bArr;
        Objects.requireNonNull(zzkaVar);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        zzpm zzpmVar = (zzpm) obj;
        try {
            zzpmVar.zza(zzpl.zzb(this.zza, zzadf.zza()));
        } catch (zzaeh e) {
            zzpmVar.zzb(e);
        }
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
    }
}
