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
public final class C0743z9 implements ExecutorProvider {

    /* renamed from: a  reason: collision with root package name */
    public final C0405lk f1313a;
    public final IHandlerExecutor b;

    public C0743z9() {
        C0405lk w = C0470oa.k().w();
        this.f1313a = w;
        this.b = w.b();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getDefaultExecutor() {
        return this.f1313a.a();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final InterruptionSafeThread getInterruptionThread(String str, String str2, Runnable runnable) {
        return new InterruptionSafeThread(runnable, (str + '-' + str2) + Constants.FILENAME_SEQUENCE_SEPARATOR + Ad.f478a.incrementAndGet());
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getModuleExecutor() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final Executor getReportRunnableExecutor() {
        return this.f1313a.d();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getSupportIOExecutor() {
        C0405lk c0405lk = this.f1313a;
        if (c0405lk.f == null) {
            synchronized (c0405lk) {
                if (c0405lk.f == null) {
                    c0405lk.f1079a.getClass();
                    HandlerThreadC0190db a2 = A9.a("IAA-SIO");
                    c0405lk.f = new A9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return c0405lk.f;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final Executor getUiExecutor() {
        C0405lk c0405lk = this.f1313a;
        if (c0405lk.h == null) {
            synchronized (c0405lk) {
                if (c0405lk.h == null) {
                    c0405lk.f1079a.getClass();
                    c0405lk.h = new ExecutorC0353jk(new Handler(Looper.getMainLooper()));
                }
            }
        }
        return c0405lk.h;
    }
}
