package io.appmetrica.analytics.impl;

import android.os.Handler;
import java.util.concurrent.Executor;
/* renamed from: io.appmetrica.analytics.impl.yk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class ExecutorC0741yk implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Handler f1175a;

    public ExecutorC0741yk(Handler handler) {
        this.f1175a = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f1175a.post(runnable);
    }
}
