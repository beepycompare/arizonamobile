package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* renamed from: io.appmetrica.analytics.impl.zd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class ThreadFactoryC0751zd implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicInteger f1333a = new AtomicInteger(0);

    public static int a() {
        return f1333a.incrementAndGet();
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new InterruptionSafeThread(runnable, "null-" + f1333a.incrementAndGet());
    }
}
