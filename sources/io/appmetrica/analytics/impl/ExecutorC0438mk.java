package io.appmetrica.analytics.impl;

import android.os.Handler;
import java.util.concurrent.Executor;
/* renamed from: io.appmetrica.analytics.impl.mk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class ExecutorC0438mk implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Handler f944a;

    public ExecutorC0438mk(Handler handler) {
        this.f944a = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f944a.post(runnable);
    }
}
