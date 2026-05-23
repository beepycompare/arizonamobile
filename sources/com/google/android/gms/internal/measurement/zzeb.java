package com.google.android.gms.internal.measurement;

import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@23.2.0 */
/* loaded from: classes4.dex */
public final class zzeb implements ThreadFactory {
    private final ThreadFactory zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeb(zzez zzezVar) {
        Objects.requireNonNull(zzezVar);
        this.zza = Executors.defaultThreadFactory();
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.zza.newThread(runnable);
        newThread.setName("ScionFrontendApi");
        return newThread;
    }
}
