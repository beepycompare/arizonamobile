package io.appmetrica.analytics.screenshot.impl;

import android.os.Handler;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
/* loaded from: classes5.dex */
public final class g0 implements T {

    /* renamed from: a  reason: collision with root package name */
    public final ClientContext f1471a;
    public final U b;
    public final Handler c;
    public volatile boolean d;
    public volatile C0775n e;
    public final d0 f = new d0(this);

    public g0(ClientContext clientContext, U u) {
        this.f1471a = clientContext;
        this.b = u;
        this.c = clientContext.getClientExecutorProvider().getDefaultExecutor().getHandler();
    }

    @Override // io.appmetrica.analytics.screenshot.impl.T
    public final void a(C0774m c0774m) {
        this.e = c0774m != null ? c0774m.b : null;
    }

    public final String b() {
        return "ServiceScreenshotCaptor";
    }

    @Override // io.appmetrica.analytics.screenshot.impl.T
    public final void a() {
        this.f1471a.getActivityLifecycleRegistry().registerListener(new f0(this), ActivityEvent.RESUMED, ActivityEvent.PAUSED);
    }
}
