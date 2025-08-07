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
    public final Looper f667a;
    public final Handler b;
    public final HandlerThreadC0706xb c;

    public U9(String str) {
        this(a(str));
    }

    public static HandlerThreadC0706xb a(String str) {
        HandlerThreadC0706xb handlerThreadC0706xb = new HandlerThreadC0706xb(str + Constants.FILENAME_SEQUENCE_SEPARATOR + Od.f578a.incrementAndGet());
        handlerThreadC0706xb.start();
        return handlerThreadC0706xb;
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
        return this.f667a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public final boolean isRunning() {
        boolean z;
        HandlerThreadC0706xb handlerThreadC0706xb = this.c;
        synchronized (handlerThreadC0706xb) {
            z = handlerThreadC0706xb.f1136a;
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
        HandlerThreadC0706xb handlerThreadC0706xb = this.c;
        synchronized (handlerThreadC0706xb) {
            handlerThreadC0706xb.f1136a = false;
            handlerThreadC0706xb.interrupt();
        }
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor
    public final <T> Future<T> submit(Callable<T> callable) {
        FutureTask futureTask = new FutureTask(callable);
        this.b.post(futureTask);
        return futureTask;
    }

    public U9(HandlerThreadC0706xb handlerThreadC0706xb) {
        this(handlerThreadC0706xb, handlerThreadC0706xb.getLooper(), new Handler(handlerThreadC0706xb.getLooper()));
    }

    public U9(HandlerThreadC0706xb handlerThreadC0706xb, Looper looper, Handler handler) {
        this.c = handlerThreadC0706xb;
        this.f667a = looper;
        this.b = handler;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor
    public final void executeDelayed(Runnable runnable, long j, TimeUnit timeUnit) {
        this.b.postDelayed(runnable, timeUnit.toMillis(j));
    }
}
