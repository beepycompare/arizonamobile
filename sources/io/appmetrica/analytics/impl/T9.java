package io.appmetrica.analytics.impl;

import android.os.Handler;
import com.google.android.vending.expansion.downloader.Constants;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider;
import java.util.concurrent.Executor;
/* loaded from: classes4.dex */
public final class T9 implements ExecutorProvider {

    /* renamed from: a  reason: collision with root package name */
    public final C0564rk f650a;
    public final IHandlerExecutor b;

    public T9() {
        C0564rk w = Ia.j().w();
        this.f650a = w;
        this.b = w.c();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getDefaultExecutor() {
        return this.f650a.a();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final InterruptionSafeThread getInterruptionThread(String str, String str2, Runnable runnable) {
        return new InterruptionSafeThread(runnable, (str + '-' + str2) + Constants.FILENAME_SEQUENCE_SEPARATOR + Od.f579a.incrementAndGet());
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getModuleExecutor() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getSupportIOExecutor() {
        C0564rk c0564rk = this.f650a;
        if (c0564rk.f == null) {
            synchronized (c0564rk) {
                if (c0564rk.f == null) {
                    c0564rk.f1041a.getClass();
                    HandlerThreadC0705xb a2 = U9.a("IAA-SIO");
                    c0564rk.f = new U9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return c0564rk.f;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final Executor getUiExecutor() {
        return this.f650a.f();
    }
}
