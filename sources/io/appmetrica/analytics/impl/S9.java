package io.appmetrica.analytics.impl;

import android.os.Handler;
import android.os.Looper;
import com.google.android.vending.expansion.downloader.Constants;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider;
import java.util.concurrent.Executor;
/* loaded from: classes5.dex */
public final class S9 implements ExecutorProvider {

    /* renamed from: a  reason: collision with root package name */
    public final Mk f761a;
    public final IHandlerExecutor b;

    public S9() {
        Mk w = Na.k().w();
        this.f761a = w;
        this.b = w.c();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getDefaultExecutor() {
        return this.f761a.a();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final InterruptionSafeThread getInterruptionThread(String str, String str2, Runnable runnable) {
        return new InterruptionSafeThread(runnable, (str + '-' + str2) + Constants.FILENAME_SEQUENCE_SEPARATOR + Zd.f870a.incrementAndGet());
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getModuleExecutor() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final Executor getReportRunnableExecutor() {
        return this.f761a.f();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getSupportIOExecutor() {
        return this.f761a.g();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final Executor getUiExecutor() {
        Mk mk = this.f761a;
        if (mk.h == null) {
            synchronized (mk) {
                if (mk.h == null) {
                    mk.f667a.getClass();
                    mk.h = new Kk(new Handler(Looper.getMainLooper()));
                }
            }
        }
        return mk.h;
    }
}
