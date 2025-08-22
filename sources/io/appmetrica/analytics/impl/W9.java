package io.appmetrica.analytics.impl;

import android.os.Handler;
import android.os.Looper;
import com.google.android.vending.expansion.downloader.Constants;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public final class W9 implements IHandlerExecutor {

    /* renamed from: a  reason: collision with root package name */
    public final Looper f706a;
    public final Handler b;
    public final HandlerThreadC0753zb c;

    public W9(String str) {
        this(a(str));
    }

    public static HandlerThreadC0753zb a(String str) {
        HandlerThreadC0753zb handlerThreadC0753zb = new HandlerThreadC0753zb(str + Constants.FILENAME_SEQUENCE_SEPARATOR + Qd.f620a.incrementAndGet());
        handlerThreadC0753zb.start();
        return handlerThreadC0753zb;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor, java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.b.post(runnable);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor
    public final void executeDelayed(Runnable runnable, long j) {
        this.b.postDelayed(runnable, TimeUnit.MILLISECONDS.toMillis(j));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor
    public final Handler getHandler() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor
    public final Looper getLooper() {
        return this.f706a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public final boolean isRunning() {
        boolean z;
        HandlerThreadC0753zb handlerThreadC0753zb = this.c;
        synchronized (handlerThreadC0753zb) {
            z = handlerThreadC0753zb.f1178a;
        }
        return z;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor
    public final void remove(Runnable runnable) {
        this.b.removeCallbacks(runnable);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor
    public final void removeAll() {
        this.b.removeCallbacksAndMessages(null);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public final void stopRunning() {
        HandlerThreadC0753zb handlerThreadC0753zb = this.c;
        synchronized (handlerThreadC0753zb) {
            handlerThreadC0753zb.f1178a = false;
            handlerThreadC0753zb.interrupt();
        }
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor
    public final <T> Future<T> submit(Callable<T> callable) {
        FutureTask futureTask = new FutureTask(callable);
        this.b.post(futureTask);
        return futureTask;
    }

    public W9(HandlerThreadC0753zb handlerThreadC0753zb) {
        this(handlerThreadC0753zb, handlerThreadC0753zb.getLooper(), new Handler(handlerThreadC0753zb.getLooper()));
    }

    public W9(HandlerThreadC0753zb handlerThreadC0753zb, Looper looper, Handler handler) {
        this.c = handlerThreadC0753zb;
        this.f706a = looper;
        this.b = handler;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor
    public final void executeDelayed(Runnable runnable, long j, TimeUnit timeUnit) {
        this.b.postDelayed(runnable, timeUnit.toMillis(j));
    }
}
