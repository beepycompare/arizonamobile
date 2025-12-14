package io.appmetrica.analytics.impl;

import android.os.Handler;
import java.util.concurrent.Executor;
/* renamed from: io.appmetrica.analytics.impl.jk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class ExecutorC0353jk implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Handler f1056a;

    public ExecutorC0353jk(Handler handler) {
        this.f1056a = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f1056a.post(runnable);
    }
}
