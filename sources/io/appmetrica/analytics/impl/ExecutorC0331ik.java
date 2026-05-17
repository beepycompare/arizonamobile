package io.appmetrica.analytics.impl;

import android.os.Handler;
import java.util.concurrent.Executor;
/* renamed from: io.appmetrica.analytics.impl.ik  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class ExecutorC0331ik implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Handler f1052a;

    public ExecutorC0331ik(Handler handler) {
        this.f1052a = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f1052a.post(runnable);
    }
}
