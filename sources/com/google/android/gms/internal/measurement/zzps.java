package com.google.android.gms.internal.measurement;

import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzps {
    private final AtomicInteger zza = new AtomicInteger();

    public final int zza() {
        return this.zza.get();
    }

    public final void zzb() {
        this.zza.incrementAndGet();
    }
}
