package io.appmetrica.analytics.impl;

import android.os.Handler;
import java.util.concurrent.Executor;
/* renamed from: io.appmetrica.analytics.impl.mk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class ExecutorC0446mk implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Handler f943a;

    public ExecutorC0446mk(Handler handler) {
        this.f943a = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f943a.post(runnable);
    }
}
