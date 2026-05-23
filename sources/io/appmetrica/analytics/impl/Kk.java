package io.appmetrica.analytics.impl;

import android.os.Handler;
import java.util.concurrent.Executor;
/* loaded from: classes5.dex */
public final class Kk implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Handler f630a;

    public Kk(Handler handler) {
        this.f630a = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f630a.post(runnable);
    }
}
