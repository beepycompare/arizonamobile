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
public final class C0722y9 implements ExecutorProvider {

    /* renamed from: a  reason: collision with root package name */
    public final C0384kk f1319a;
    public final IHandlerExecutor b;

    public C0722y9() {
        C0384kk w = C0449na.k().w();
        this.f1319a = w;
        this.b = w.b();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getDefaultExecutor() {
        return this.f1319a.a();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final InterruptionSafeThread getInterruptionThread(String str, String str2, Runnable runnable) {
        return new InterruptionSafeThread(runnable, (str + '-' + str2) + Constants.FILENAME_SEQUENCE_SEPARATOR + ThreadFactoryC0751zd.f1333a.incrementAndGet());
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getModuleExecutor() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final Executor getReportRunnableExecutor() {
        return this.f1319a.d();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getSupportIOExecutor() {
        C0384kk c0384kk = this.f1319a;
        if (c0384kk.f == null) {
            synchronized (c0384kk) {
                if (c0384kk.f == null) {
                    c0384kk.f1085a.getClass();
                    HandlerThreadC0169cb a2 = C0747z9.a("IAA-SIO");
                    c0384kk.f = new C0747z9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return c0384kk.f;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final Executor getUiExecutor() {
        C0384kk c0384kk = this.f1319a;
        if (c0384kk.h == null) {
            synchronized (c0384kk) {
                if (c0384kk.h == null) {
                    c0384kk.f1085a.getClass();
                    c0384kk.h = new ExecutorC0332ik(new Handler(Looper.getMainLooper()));
                }
            }
        }
        return c0384kk.h;
    }
}
