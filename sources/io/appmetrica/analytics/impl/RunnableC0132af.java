package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* renamed from: io.appmetrica.analytics.impl.af  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0132af implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f769a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0184cf c;

    public RunnableC0132af(C0184cf c0184cf, PluginErrorDetails pluginErrorDetails, String str) {
        this.c = c0184cf;
        this.f769a = pluginErrorDetails;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((InterfaceC0432mb) this.c.d.get()).getPluginExtension().reportError(this.f769a, this.b);
    }
}
