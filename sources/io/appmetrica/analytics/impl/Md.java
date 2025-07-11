package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes4.dex */
public final class Md implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicInteger f536a = new AtomicInteger(0);

    public static int a() {
        return f536a.incrementAndGet();
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new InterruptionSafeThread(runnable, "null-" + f536a.incrementAndGet());
    }
}
