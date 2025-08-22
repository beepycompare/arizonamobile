package io.appmetrica.analytics.impl;

import android.os.Handler;
import com.google.android.vending.expansion.downloader.Constants;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider;
import java.util.concurrent.Executor;
/* loaded from: classes4.dex */
public final class V9 implements ExecutorProvider {

    /* renamed from: a  reason: collision with root package name */
    public final C0687wk f691a;
    public final IHandlerExecutor b;

    public V9() {
        C0687wk w = Ka.j().w();
        this.f691a = w;
        this.b = w.c();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getDefaultExecutor() {
        return this.f691a.a();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final InterruptionSafeThread getInterruptionThread(String str, String str2, Runnable runnable) {
        return new InterruptionSafeThread(runnable, (str + '-' + str2) + Constants.FILENAME_SEQUENCE_SEPARATOR + Qd.f620a.incrementAndGet());
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getModuleExecutor() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getSupportIOExecutor() {
        C0687wk c0687wk = this.f691a;
        if (c0687wk.f == null) {
            synchronized (c0687wk) {
                if (c0687wk.f == null) {
                    c0687wk.f1126a.getClass();
                    HandlerThreadC0753zb a2 = W9.a("IAA-SIO");
                    c0687wk.f = new W9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return c0687wk.f;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final Executor getUiExecutor() {
        return this.f691a.f();
    }
}
