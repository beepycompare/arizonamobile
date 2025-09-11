package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.modulesapi.internal.client.ClientContext;
/* renamed from: io.appmetrica.analytics.screenshot.impl.u  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0789u implements P {

    /* renamed from: a  reason: collision with root package name */
    public final ClientContext f1334a;
    public final Q b;
    public volatile C0779j c;
    public final W d;

    public C0789u(ClientContext clientContext, Q q) {
        this.f1334a = clientContext;
        this.b = q;
        this.d = new W(clientContext, new r(this));
    }

    @Override // io.appmetrica.analytics.screenshot.impl.P
    public final void a(C0781l c0781l) {
        this.c = c0781l != null ? c0781l.c : null;
        this.d.c = this.c;
    }

    public final String b() {
        return "ContentObserverScreenshotCaptor";
    }

    @Override // io.appmetrica.analytics.screenshot.impl.P
    public final void a() {
        this.f1334a.getActivityLifecycleRegistry().registerListener(new C0788t(this), ActivityEvent.RESUMED, ActivityEvent.PAUSED);
    }
}
