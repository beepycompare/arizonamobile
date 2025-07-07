package io.appmetrica.analytics.screenshot.impl;

import android.os.Handler;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
/* loaded from: classes4.dex */
public final class d0 implements P {

    /* renamed from: a  reason: collision with root package name */
    public final ClientContext f1294a;
    public final Q b;
    public final Handler c;
    public volatile boolean d;
    public volatile C0786m e;
    public final a0 f = new a0(this);

    public d0(ClientContext clientContext, Q q) {
        this.f1294a = clientContext;
        this.b = q;
        this.c = clientContext.getClientExecutorProvider().getDefaultExecutor().getHandler();
    }

    @Override // io.appmetrica.analytics.screenshot.impl.P
    public final void a(C0785l c0785l) {
        this.e = c0785l != null ? c0785l.b : null;
    }

    public final String b() {
        return "ServiceScreenshotCaptor";
    }

    @Override // io.appmetrica.analytics.screenshot.impl.P
    public final void a() {
        this.f1294a.getActivityLifecycleRegistry().registerListener(new c0(this), ActivityEvent.RESUMED, ActivityEvent.PAUSED);
    }
}
