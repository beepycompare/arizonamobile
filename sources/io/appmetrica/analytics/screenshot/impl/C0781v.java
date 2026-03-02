package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
/* renamed from: io.appmetrica.analytics.screenshot.impl.v  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0781v implements T {

    /* renamed from: a  reason: collision with root package name */
    public final ClientContext f1486a;
    public final U b;
    public volatile C0771k c;
    public final Z d;

    public C0781v(ClientContext clientContext, U u) {
        this.f1486a = clientContext;
        this.b = u;
        this.d = new Z(clientContext, new C0778s(this));
    }

    @Override // io.appmetrica.analytics.screenshot.impl.T
    public final void a(C0773m c0773m) {
        this.c = c0773m != null ? c0773m.c : null;
        this.d.c = this.c;
    }

    public final String b() {
        return "ContentObserverScreenshotCaptor";
    }

    @Override // io.appmetrica.analytics.screenshot.impl.T
    public final void a() {
        this.f1486a.getActivityLifecycleRegistry().registerListener(new C0780u(this), ActivityEvent.RESUMED, ActivityEvent.PAUSED);
    }
}
