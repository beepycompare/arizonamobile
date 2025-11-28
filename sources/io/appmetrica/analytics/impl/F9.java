package io.appmetrica.analytics.impl;

import android.os.Handler;
import android.os.Looper;
import com.google.android.vending.expansion.downloader.Constants;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider;
import java.util.concurrent.Executor;
/* loaded from: classes5.dex */
public final class F9 implements ExecutorProvider {

    /* renamed from: a  reason: collision with root package name */
    public final C0481ok f473a;
    public final IHandlerExecutor b;

    public F9() {
        C0481ok x = C0620ua.k().x();
        this.f473a = x;
        this.b = x.c();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getDefaultExecutor() {
        return this.f473a.a();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final InterruptionSafeThread getInterruptionThread(String str, String str2, Runnable runnable) {
        return new InterruptionSafeThread(runnable, (str + '-' + str2) + Constants.FILENAME_SEQUENCE_SEPARATOR + Gd.f490a.incrementAndGet());
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getModuleExecutor() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final Executor getReportRunnableExecutor() {
        return this.f473a.e();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getSupportIOExecutor() {
        C0481ok c0481ok = this.f473a;
        if (c0481ok.f == null) {
            synchronized (c0481ok) {
                if (c0481ok.f == null) {
                    c0481ok.f1044a.getClass();
                    HandlerThreadC0345jb a2 = G9.a("IAA-SIO");
                    c0481ok.f = new G9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return c0481ok.f;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final Executor getUiExecutor() {
        C0481ok c0481ok = this.f473a;
        if (c0481ok.h == null) {
            synchronized (c0481ok) {
                if (c0481ok.h == null) {
                    c0481ok.f1044a.getClass();
                    c0481ok.h = new ExecutorC0431mk(new Handler(Looper.getMainLooper()));
                }
            }
        }
        return c0481ok.h;
    }
}
