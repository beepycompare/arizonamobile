package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
final class zzjy extends zzkp {
    final /* synthetic */ TaskCompletionSource zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjy(zzkk zzkkVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
        Objects.requireNonNull(zzkkVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzkq
    public final void zzb(Status status, byte[] bArr) {
        if (status.isSuccess()) {
            try {
                TaskUtil.setResultOrApiException(status, zzno.zzc(bArr, zzadf.zza()), this.zza);
                return;
            } catch (zzaeh e) {
                this.zza.setException(e);
                return;
            }
        }
        TaskUtil.setResultOrApiException(status, (Object) null, this.zza);
    }
}
