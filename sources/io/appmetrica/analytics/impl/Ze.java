package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* loaded from: classes4.dex */
public final class Ze implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f749a;
    public final /* synthetic */ C0184cf b;

    public Ze(C0184cf c0184cf, PluginErrorDetails pluginErrorDetails) {
        this.b = c0184cf;
        this.f749a = pluginErrorDetails;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((InterfaceC0432mb) this.b.d.get()).getPluginExtension().reportUnhandledException(this.f749a);
    }
}
