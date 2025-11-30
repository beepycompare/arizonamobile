package io.appmetrica.analytics.impl;

import android.os.Handler;
import java.util.concurrent.Executor;
/* renamed from: io.appmetrica.analytics.impl.jk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class ExecutorC0354jk implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Handler f959a;

    public ExecutorC0354jk(Handler handler) {
        this.f959a = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f959a.post(runnable);
    }
}
