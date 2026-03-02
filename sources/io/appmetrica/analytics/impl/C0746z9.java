package io.appmetrica.analytics.impl;

import android.os.Handler;
import android.os.Looper;
import com.google.android.vending.expansion.downloader.Constants;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.z9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0746z9 implements IHandlerExecutor {

    /* renamed from: a  reason: collision with root package name */
    public final Looper f1330a;
    public final Handler b;
    public final HandlerThreadC0168cb c;

    public C0746z9(String str) {
        this(a(str));
    }

    public static HandlerThreadC0168cb a(String str) {
        HandlerThreadC0168cb handlerThreadC0168cb = new HandlerThreadC0168cb(str + Constants.FILENAME_SEQUENCE_SEPARATOR + ThreadFactoryC0750zd.f1332a.incrementAndGet());
        handlerThreadC0168cb.start();
        return handlerThreadC0168cb;
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
        return this.f1330a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.IInterruptionSafeThread
    public final boolean isRunning() {
        boolean z;
        HandlerThreadC0168cb handlerThreadC0168cb = this.c;
        synchronized (handlerThreadC0168cb) {
            z = handlerThreadC0168cb.f935a;
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
        HandlerThreadC0168cb handlerThreadC0168cb = this.c;
        synchronized (handlerThreadC0168cb) {
            handlerThreadC0168cb.f935a = false;
            handlerThreadC0168cb.interrupt();
        }
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor
    public final <T> Future<T> submit(Callable<T> callable) {
        FutureTask futureTask = new FutureTask(callable);
        this.b.post(futureTask);
        return futureTask;
    }

    public C0746z9(HandlerThreadC0168cb handlerThreadC0168cb) {
        this(handlerThreadC0168cb, handlerThreadC0168cb.getLooper(), new Handler(handlerThreadC0168cb.getLooper()));
    }

    public C0746z9(HandlerThreadC0168cb handlerThreadC0168cb, Looper looper, Handler handler) {
        this.c = handlerThreadC0168cb;
        this.f1330a = looper;
        this.b = handler;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor
    public final void executeDelayed(Runnable runnable, long j, TimeUnit timeUnit) {
        this.b.postDelayed(runnable, timeUnit.toMillis(j));
    }
}
