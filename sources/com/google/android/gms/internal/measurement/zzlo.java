package com.google.android.gms.internal.measurement;

import java.util.concurrent.ThreadFactory;
/* compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* loaded from: classes4.dex */
final /* synthetic */ class zzlo implements ThreadFactory {
    static final /* synthetic */ zzlo zza = new zzlo();

    private /* synthetic */ zzlo() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final /* synthetic */ Thread newThread(Runnable runnable) {
        int i = zzlk.zza;
        return new Thread(runnable, "ProcessStablePhenotypeFlag");
    }
}
