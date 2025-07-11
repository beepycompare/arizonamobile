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
public final class S9 implements IHandlerExecutor {

    /* renamed from: a  reason: collision with root package name */
    public final Looper f623a;
    public final Handler b;
    public final HandlerThreadC0653vb c;

    public S9(String str) {
        this(a(str));
    }

    public static HandlerThreadC0653vb a(String str) {
        HandlerThreadC0653vb handlerThreadC0653vb = new HandlerThreadC0653vb(str + Constants.FILENAME_SEQUENCE_SEPARATOR + Md.f536a.incrementAndGet());
        handlerThreadC0653vb.start();
        return handlerThreadC0653vb;
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
        return this.f623a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public final boolean isRunning() {
        boolean z;
        HandlerThreadC0653vb handlerThreadC0653vb = this.c;
        synchronized (handlerThreadC0653vb) {
            z = handlerThreadC0653vb.f1091a;
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
        HandlerThreadC0653vb handlerThreadC0653vb = this.c;
        synchronized (handlerThreadC0653vb) {
            handlerThreadC0653vb.f1091a = false;
            handlerThreadC0653vb.interrupt();
        }
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor
    public final <T> Future<T> submit(Callable<T> callable) {
        FutureTask futureTask = new FutureTask(callable);
        this.b.post(futureTask);
        return futureTask;
    }

    public S9(HandlerThreadC0653vb handlerThreadC0653vb) {
        this(handlerThreadC0653vb, handlerThreadC0653vb.getLooper(), new Handler(handlerThreadC0653vb.getLooper()));
    }

    public S9(HandlerThreadC0653vb handlerThreadC0653vb, Looper looper, Handler handler) {
        this.c = handlerThreadC0653vb;
        this.f623a = looper;
        this.b = handler;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor
    public final void executeDelayed(Runnable runnable, long j, TimeUnit timeUnit) {
        this.b.postDelayed(runnable, timeUnit.toMillis(j));
    }
}
