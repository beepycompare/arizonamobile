package io.appmetrica.analytics.impl;

import android.os.Handler;
import android.os.Looper;
import com.google.android.vending.expansion.downloader.Constants;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider;
import java.util.concurrent.Executor;
/* renamed from: io.appmetrica.analytics.impl.y9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0721y9 implements ExecutorProvider {

    /* renamed from: a  reason: collision with root package name */
    public final C0383kk f1318a;
    public final IHandlerExecutor b;

    public C0721y9() {
        C0383kk w = C0448na.k().w();
        this.f1318a = w;
        this.b = w.b();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getDefaultExecutor() {
        return this.f1318a.a();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final InterruptionSafeThread getInterruptionThread(String str, String str2, Runnable runnable) {
        return new InterruptionSafeThread(runnable, (str + '-' + str2) + Constants.FILENAME_SEQUENCE_SEPARATOR + ThreadFactoryC0750zd.f1332a.incrementAndGet());
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getModuleExecutor() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final Executor getReportRunnableExecutor() {
        return this.f1318a.d();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getSupportIOExecutor() {
        C0383kk c0383kk = this.f1318a;
        if (c0383kk.f == null) {
            synchronized (c0383kk) {
                if (c0383kk.f == null) {
                    c0383kk.f1084a.getClass();
                    HandlerThreadC0168cb a2 = C0746z9.a("IAA-SIO");
                    c0383kk.f = new C0746z9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return c0383kk.f;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final Executor getUiExecutor() {
        C0383kk c0383kk = this.f1318a;
        if (c0383kk.h == null) {
            synchronized (c0383kk) {
                if (c0383kk.h == null) {
                    c0383kk.f1084a.getClass();
                    c0383kk.h = new ExecutorC0331ik(new Handler(Looper.getMainLooper()));
                }
            }
        }
        return c0383kk.h;
    }
}
