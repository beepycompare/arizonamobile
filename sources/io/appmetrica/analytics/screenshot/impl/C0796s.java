package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
/* renamed from: io.appmetrica.analytics.screenshot.impl.s  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0796s implements B {

    /* renamed from: a  reason: collision with root package name */
    public final ClientContext f1456a;
    public final C b;
    public volatile C0788j c;
    public final G d;

    public C0796s(ClientContext clientContext, C c) {
        this.f1456a = clientContext;
        this.b = c;
        this.d = new G(clientContext, new C0794p(this));
    }

    @Override // io.appmetrica.analytics.screenshot.impl.B
    public final void a(C0789k c0789k) {
        this.c = c0789k != null ? c0789k.d : null;
        this.d.c = this.c;
    }

    public final String b() {
        return "ContentObserverScreenshotCaptor";
    }

    @Override // io.appmetrica.analytics.screenshot.impl.B
    public final void a() {
        this.f1456a.getActivityLifecycleRegistry().registerListener(new r(this), ActivityEvent.RESUMED, ActivityEvent.PAUSED);
    }
}
