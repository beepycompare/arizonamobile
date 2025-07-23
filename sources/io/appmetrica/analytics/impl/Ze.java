package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* loaded from: classes4.dex */
public final class Ze implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f749a;
    public final /* synthetic */ C0183cf b;

    public Ze(C0183cf c0183cf, PluginErrorDetails pluginErrorDetails) {
        this.b = c0183cf;
        this.f749a = pluginErrorDetails;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((InterfaceC0431mb) this.b.d.get()).getPluginExtension().reportUnhandledException(this.f749a);
    }
}
