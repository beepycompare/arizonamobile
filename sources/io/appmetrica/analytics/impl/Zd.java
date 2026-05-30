package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes5.dex */
public final class Zd implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicInteger f871a = new AtomicInteger(0);

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new InterruptionSafeThread(runnable, "null-" + f871a.incrementAndGet());
    }
}
