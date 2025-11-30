package io.appmetrica.analytics.impl;

import android.os.Handler;
import android.os.Looper;
import com.google.android.vending.expansion.downloader.Constants;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider;
import java.util.concurrent.Executor;
/* renamed from: io.appmetrica.analytics.impl.z9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0744z9 implements ExecutorProvider {

    /* renamed from: a  reason: collision with root package name */
    public final C0406lk f1230a;
    public final IHandlerExecutor b;

    public C0744z9() {
        C0406lk w = C0471oa.k().w();
        this.f1230a = w;
        this.b = w.b();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getDefaultExecutor() {
        return this.f1230a.a();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final InterruptionSafeThread getInterruptionThread(String str, String str2, Runnable runnable) {
        return new InterruptionSafeThread(runnable, (str + '-' + str2) + Constants.FILENAME_SEQUENCE_SEPARATOR + Ad.f395a.incrementAndGet());
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getModuleExecutor() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final Executor getReportRunnableExecutor() {
        return this.f1230a.d();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getSupportIOExecutor() {
        C0406lk c0406lk = this.f1230a;
        if (c0406lk.f == null) {
            synchronized (c0406lk) {
                if (c0406lk.f == null) {
                    c0406lk.f996a.getClass();
                    HandlerThreadC0191db a2 = A9.a("IAA-SIO");
                    c0406lk.f = new A9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return c0406lk.f;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final Executor getUiExecutor() {
        C0406lk c0406lk = this.f1230a;
        if (c0406lk.h == null) {
            synchronized (c0406lk) {
                if (c0406lk.h == null) {
                    c0406lk.f996a.getClass();
                    c0406lk.h = new ExecutorC0354jk(new Handler(Looper.getMainLooper()));
                }
            }
        }
        return c0406lk.h;
    }
}
