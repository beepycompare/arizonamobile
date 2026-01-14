package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
/* renamed from: io.appmetrica.analytics.screenshot.impl.v  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0782v implements T {

    /* renamed from: a  reason: collision with root package name */
    public final ClientContext f1487a;
    public final U b;
    public volatile C0772k c;
    public final Z d;

    public C0782v(ClientContext clientContext, U u) {
        this.f1487a = clientContext;
        this.b = u;
        this.d = new Z(clientContext, new C0779s(this));
    }

    @Override // io.appmetrica.analytics.screenshot.impl.T
    public final void a(C0774m c0774m) {
        this.c = c0774m != null ? c0774m.c : null;
        this.d.c = this.c;
    }

    public final String b() {
        return "ContentObserverScreenshotCaptor";
    }

    @Override // io.appmetrica.analytics.screenshot.impl.T
    public final void a() {
        this.f1487a.getActivityLifecycleRegistry().registerListener(new C0781u(this), ActivityEvent.RESUMED, ActivityEvent.PAUSED);
    }
}
