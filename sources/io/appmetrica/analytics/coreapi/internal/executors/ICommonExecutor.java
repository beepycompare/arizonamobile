package io.appmetrica.analytics.coreapi.internal.executors;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public interface ICommonExecutor extends IInterruptionSafeThread, Executor {
    @Override // java.util.concurrent.Executor
    void execute(Runnable runnable);

    void executeDelayed(Runnable runnable, long j);

    void executeDelayed(Runnable runnable, long j, TimeUnit timeUnit);

    void remove(Runnable runnable);

    void removeAll();

    <T> Future<T> submit(Callable<T> callable);
}
