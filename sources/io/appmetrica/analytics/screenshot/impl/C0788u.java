package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
/* renamed from: io.appmetrica.analytics.screenshot.impl.u  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0788u implements P {

    /* renamed from: a  reason: collision with root package name */
    public final ClientContext f1315a;
    public final Q b;
    public volatile C0778j c;
    public final W d;

    public C0788u(ClientContext clientContext, Q q) {
        this.f1315a = clientContext;
        this.b = q;
        this.d = new W(clientContext, new r(this));
    }

    @Override // io.appmetrica.analytics.screenshot.impl.P
    public final void a(C0780l c0780l) {
        this.c = c0780l != null ? c0780l.c : null;
        this.d.c = this.c;
    }

    public final String b() {
        return "ContentObserverScreenshotCaptor";
    }

    @Override // io.appmetrica.analytics.screenshot.impl.P
    public final void a() {
        this.f1315a.getActivityLifecycleRegistry().registerListener(new C0787t(this), ActivityEvent.RESUMED, ActivityEvent.PAUSED);
    }
}
