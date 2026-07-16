package io.appmetrica.analytics.screenshot.impl;

import android.os.Handler;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
/* loaded from: classes5.dex */
public final class M implements B {

    /* renamed from: a  reason: collision with root package name */
    public final ClientContext f1440a;
    public final C b;
    public final Handler c;
    public volatile boolean d;
    public volatile C0790l e;
    public final J f = new J(this);

    public M(ClientContext clientContext, C c) {
        this.f1440a = clientContext;
        this.b = c;
        this.c = clientContext.getClientExecutorProvider().getDefaultExecutor().getHandler();
    }

    @Override // io.appmetrica.analytics.screenshot.impl.B
    public final void a(C0789k c0789k) {
        this.e = c0789k != null ? c0789k.c : null;
    }

    public final String b() {
        return "ServiceScreenshotCaptor";
    }

    @Override // io.appmetrica.analytics.screenshot.impl.B
    public final void a() {
        this.f1440a.getActivityLifecycleRegistry().registerListener(new L(this), ActivityEvent.RESUMED, ActivityEvent.PAUSED);
    }
}
