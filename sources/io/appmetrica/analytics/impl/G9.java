package io.appmetrica.analytics.impl;

import android.os.Handler;
import android.os.Looper;
import com.google.android.vending.expansion.downloader.Constants;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public final class G9 implements IHandlerExecutor {

    /* renamed from: a  reason: collision with root package name */
    public final Looper f488a;
    public final Handler b;
    public final HandlerThreadC0345jb c;

    public G9(String str) {
        this(a(str));
    }

    public static HandlerThreadC0345jb a(String str) {
        HandlerThreadC0345jb handlerThreadC0345jb = new HandlerThreadC0345jb(str + Constants.FILENAME_SEQUENCE_SEPARATOR + Gd.f490a.incrementAndGet());
        handlerThreadC0345jb.start();
        return handlerThreadC0345jb;
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
        return this.f488a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public final boolean isRunning() {
        boolean z;
        HandlerThreadC0345jb handlerThreadC0345jb = this.c;
        synchronized (handlerThreadC0345jb) {
            z = handlerThreadC0345jb.f951a;
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
        HandlerThreadC0345jb handlerThreadC0345jb = this.c;
        synchronized (handlerThreadC0345jb) {
            handlerThreadC0345jb.f951a = false;
            handlerThreadC0345jb.interrupt();
        }
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor
    public final <T> Future<T> submit(Callable<T> callable) {
        FutureTask futureTask = new FutureTask(callable);
        this.b.post(futureTask);
        return futureTask;
    }

    public G9(HandlerThreadC0345jb handlerThreadC0345jb) {
        this(handlerThreadC0345jb, handlerThreadC0345jb.getLooper(), new Handler(handlerThreadC0345jb.getLooper()));
    }

    public G9(HandlerThreadC0345jb handlerThreadC0345jb, Looper looper, Handler handler) {
        this.c = handlerThreadC0345jb;
        this.f488a = looper;
        this.b = handler;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor
    public final void executeDelayed(Runnable runnable, long j, TimeUnit timeUnit) {
        this.b.postDelayed(runnable, timeUnit.toMillis(j));
    }
}
