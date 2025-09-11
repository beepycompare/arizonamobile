package io.appmetrica.analytics.impl;

import android.os.Handler;
import com.google.android.vending.expansion.downloader.Constants;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider;
import java.util.concurrent.Executor;
/* loaded from: classes4.dex */
public final class Y9 implements ExecutorProvider {

    /* renamed from: a  reason: collision with root package name */
    public final Ak f754a;
    public final IHandlerExecutor b;

    public Y9() {
        Ak w = Na.j().w();
        this.f754a = w;
        this.b = w.c();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getDefaultExecutor() {
        return this.f754a.a();
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final InterruptionSafeThread getInterruptionThread(String str, String str2, Runnable runnable) {
        return new InterruptionSafeThread(runnable, (str + '-' + str2) + Constants.FILENAME_SEQUENCE_SEPARATOR + Ud.f699a.incrementAndGet());
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getModuleExecutor() {
        return this.b;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final IHandlerExecutor getSupportIOExecutor() {
        Ak ak = this.f754a;
        if (ak.f == null) {
            synchronized (ak) {
                if (ak.f == null) {
                    ak.f353a.getClass();
                    Cb a2 = Z9.a("IAA-SIO");
                    ak.f = new Z9(a2, a2.getLooper(), new Handler(a2.getLooper()));
                }
            }
        }
        return ak.f;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.common.ExecutorProvider
    public final Executor getUiExecutor() {
        return this.f754a.f();
    }
}
