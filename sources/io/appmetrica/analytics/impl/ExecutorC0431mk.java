package io.appmetrica.analytics.impl;

import android.os.Handler;
import java.util.concurrent.Executor;
/* renamed from: io.appmetrica.analytics.impl.mk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class ExecutorC0431mk implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Handler f1012a;

    public ExecutorC0431mk(Handler handler) {
        this.f1012a = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f1012a.post(runnable);
    }
}
