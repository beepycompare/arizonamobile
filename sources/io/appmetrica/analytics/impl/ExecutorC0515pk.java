package io.appmetrica.analytics.impl;

import android.os.Handler;
import java.util.concurrent.Executor;
/* renamed from: io.appmetrica.analytics.impl.pk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class ExecutorC0515pk implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Handler f1006a;

    public ExecutorC0515pk(Handler handler) {
        this.f1006a = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f1006a.post(runnable);
    }
}
