package io.appmetrica.analytics.impl;

import android.os.Handler;
import android.os.Looper;
import com.google.android.vending.expansion.downloader.Constants;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class A9 implements IHandlerExecutor {

    /* renamed from: a  reason: collision with root package name */
    public final Looper f490a;
    public final Handler b;
    public final HandlerThreadC0190db c;

    public A9(String str) {
        this(a(str));
    }

    public static HandlerThreadC0190db a(String str) {
        HandlerThreadC0190db handlerThreadC0190db = new HandlerThreadC0190db(str + Constants.FILENAME_SEQUENCE_SEPARATOR + Ad.f492a.incrementAndGet());
        handlerThreadC0190db.start();
        return handlerThreadC0190db;
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
        return this.f490a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public final boolean isRunning() {
        boolean z;
        HandlerThreadC0190db handlerThreadC0190db = this.c;
        synchronized (handlerThreadC0190db) {
            z = handlerThreadC0190db.f945a;
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
        HandlerThreadC0190db handlerThreadC0190db = this.c;
        synchronized (handlerThreadC0190db) {
            handlerThreadC0190db.f945a = false;
            handlerThreadC0190db.interrupt();
        }
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor
    public final <T> Future<T> submit(Callable<T> callable) {
        FutureTask futureTask = new FutureTask(callable);
        this.b.post(futureTask);
        return futureTask;
    }

    public A9(HandlerThreadC0190db handlerThreadC0190db) {
        this(handlerThreadC0190db, handlerThreadC0190db.getLooper(), new Handler(handlerThreadC0190db.getLooper()));
    }

    public A9(HandlerThreadC0190db handlerThreadC0190db, Looper looper, Handler handler) {
        this.c = handlerThreadC0190db;
        this.f490a = looper;
        this.b = handler;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor
    public final void executeDelayed(Runnable runnable, long j, TimeUnit timeUnit) {
        this.b.postDelayed(runnable, timeUnit.toMillis(j));
    }
}
