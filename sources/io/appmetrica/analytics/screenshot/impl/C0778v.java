package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
/* renamed from: io.appmetrica.analytics.screenshot.impl.v  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0778v implements T {

    /* renamed from: a  reason: collision with root package name */
    public final ClientContext f1477a;
    public final U b;
    public volatile C0768k c;
    public final Z d;

    public C0778v(ClientContext clientContext, U u) {
        this.f1477a = clientContext;
        this.b = u;
        this.d = new Z(clientContext, new C0775s(this));
    }

    @Override // io.appmetrica.analytics.screenshot.impl.T
    public final void a(C0770m c0770m) {
        this.c = c0770m != null ? c0770m.c : null;
        this.d.c = this.c;
    }

    public final String b() {
        return "ContentObserverScreenshotCaptor";
    }

    @Override // io.appmetrica.analytics.screenshot.impl.T
    public final void a() {
        this.f1477a.getActivityLifecycleRegistry().registerListener(new C0777u(this), ActivityEvent.RESUMED, ActivityEvent.PAUSED);
    }
}
