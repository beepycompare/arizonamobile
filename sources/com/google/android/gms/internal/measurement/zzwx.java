package com.google.android.gms.internal.measurement;

import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.ListenableFuture;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzwx implements AsyncCallable {
    final /* synthetic */ zzws zza;
    final /* synthetic */ AsyncCallable zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzwx(zzws zzwsVar, AsyncCallable asyncCallable) {
        this.zza = zzwsVar;
        this.zzb = asyncCallable;
    }

    @Override // com.google.common.util.concurrent.AsyncCallable
    public final ListenableFuture call() {
        zzws zzwsVar = this.zza;
        Intrinsics.checkNotNull(zzwsVar);
        zzwq zzd = zzvy.zzd();
        zzws zzc = zzvy.zzc(zzd, zzwsVar);
        try {
            ListenableFuture call = this.zzb.call();
            zzvy.zzc(zzd, zzc);
            Intrinsics.checkNotNullExpressionValue(call, "wrapInTrace(...)");
            return call;
        } finally {
        }
    }

    public final String toString() {
        AsyncCallable asyncCallable = this.zzb;
        StringBuilder sb = new StringBuilder(asyncCallable.toString().length() + 14);
        sb.append("propagating=[");
        sb.append(asyncCallable);
        sb.append("]");
        return sb.toString();
    }
}
