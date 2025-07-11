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
    public final C0488ok f606a;
    public final IHandlerExecutor b;

    public R9() {
        C0488ok w = Ga.j().w();
        this.f606a = w;
        this.b = w.c();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getDefaultExecutor() {
        return this.f606a.a();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final InterruptionSafeThread getInterruptionThread(String str, String str2, Runnable runnable) {
        return new InterruptionSafeThread(runnable, (str + '-' + str2) + Constants.FILENAME_SEQUENCE_SEPARATOR + Md.f536a.incrementAndGet());
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getModuleExecutor() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getSupportIOExecutor() {
        C0488ok c0488ok = this.f606a;
        if (c0488ok.f == null) {
            synchronized (c0488ok) {
                if (c0488ok.f == null) {
                    c0488ok.f978a.getClass();
                    HandlerThreadC0653vb a2 = S9.a("IAA-SIO");
                    c0488ok.f = new S9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return c0488ok.f;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final Executor getUiExecutor() {
        return this.f606a.f();
    }
}
