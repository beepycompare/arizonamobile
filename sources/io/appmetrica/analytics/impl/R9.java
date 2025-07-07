package io.appmetrica.analytics.impl;

import android.os.Handler;
import com.google.android.vending.expansion.downloader.Constants;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider;
import java.util.concurrent.Executor;
/* loaded from: classes4.dex */
public final class R9 implements ExecutorProvider {

    /* renamed from: a  reason: collision with root package name */
    public final C0496ok f605a;
    public final IHandlerExecutor b;

    public R9() {
        C0496ok w = Ga.j().w();
        this.f605a = w;
        this.b = w.c();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getDefaultExecutor() {
        return this.f605a.a();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final InterruptionSafeThread getInterruptionThread(String str, String str2, Runnable runnable) {
        return new InterruptionSafeThread(runnable, (str + '-' + str2) + Constants.FILENAME_SEQUENCE_SEPARATOR + Md.f535a.incrementAndGet());
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getModuleExecutor() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getSupportIOExecutor() {
        C0496ok c0496ok = this.f605a;
        if (c0496ok.f == null) {
            synchronized (c0496ok) {
                if (c0496ok.f == null) {
                    c0496ok.f977a.getClass();
                    HandlerThreadC0661vb a2 = S9.a("IAA-SIO");
                    c0496ok.f = new S9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return c0496ok.f;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final Executor getUiExecutor() {
        return this.f605a.f();
    }
}
