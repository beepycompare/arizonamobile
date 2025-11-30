package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
/* renamed from: io.appmetrica.analytics.screenshot.impl.v  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0779v implements T {

    /* renamed from: a  reason: collision with root package name */
    public final ClientContext f1380a;
    public final U b;
    public volatile C0769k c;
    public final Z d;

    public C0779v(ClientContext clientContext, U u) {
        this.f1380a = clientContext;
        this.b = u;
        this.d = new Z(clientContext, new C0776s(this));
    }

    @Override // io.appmetrica.analytics.screenshot.impl.T
    public final void a(C0771m c0771m) {
        this.c = c0771m != null ? c0771m.c : null;
        this.d.c = this.c;
    }

    public final String b() {
        return "ContentObserverScreenshotCaptor";
    }

    @Override // io.appmetrica.analytics.screenshot.impl.T
    public final void a() {
        this.f1380a.getActivityLifecycleRegistry().registerListener(new C0778u(this), ActivityEvent.RESUMED, ActivityEvent.PAUSED);
    }
}
