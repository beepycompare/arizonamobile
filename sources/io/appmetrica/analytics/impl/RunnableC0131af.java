package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* renamed from: io.appmetrica.analytics.impl.af  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0131af implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f770a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0183cf c;

    public RunnableC0131af(C0183cf c0183cf, PluginErrorDetails pluginErrorDetails, String str) {
        this.c = c0183cf;
        this.f770a = pluginErrorDetails;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((InterfaceC0431mb) this.c.d.get()).getPluginExtension().reportError(this.f770a, this.b);
    }
}
