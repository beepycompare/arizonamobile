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
public final class U9 implements IHandlerExecutor {

    /* renamed from: a  reason: collision with root package name */
    public final Looper f668a;
    public final Handler b;
    public final HandlerThreadC0705xb c;

    public U9(String str) {
        this(a(str));
    }

    public static HandlerThreadC0705xb a(String str) {
        HandlerThreadC0705xb handlerThreadC0705xb = new HandlerThreadC0705xb(str + Constants.FILENAME_SEQUENCE_SEPARATOR + Od.f579a.incrementAndGet());
        handlerThreadC0705xb.start();
        return handlerThreadC0705xb;
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
        return this.f668a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public final boolean isRunning() {
        boolean z;
        HandlerThreadC0705xb handlerThreadC0705xb = this.c;
        synchronized (handlerThreadC0705xb) {
            z = handlerThreadC0705xb.f1137a;
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
        HandlerThreadC0705xb handlerThreadC0705xb = this.c;
        synchronized (handlerThreadC0705xb) {
            handlerThreadC0705xb.f1137a = false;
            handlerThreadC0705xb.interrupt();
        }
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor
    public final <T> Future<T> submit(Callable<T> callable) {
        FutureTask futureTask = new FutureTask(callable);
        this.b.post(futureTask);
        return futureTask;
    }

    public U9(HandlerThreadC0705xb handlerThreadC0705xb) {
        this(handlerThreadC0705xb, handlerThreadC0705xb.getLooper(), new Handler(handlerThreadC0705xb.getLooper()));
    }

    public U9(HandlerThreadC0705xb handlerThreadC0705xb, Looper looper, Handler handler) {
        this.c = handlerThreadC0705xb;
        this.f668a = looper;
        this.b = handler;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor
    public final void executeDelayed(Runnable runnable, long j, TimeUnit timeUnit) {
        this.b.postDelayed(runnable, timeUnit.toMillis(j));
    }
}
