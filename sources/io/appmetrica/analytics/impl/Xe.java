package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* loaded from: classes4.dex */
public final class Xe implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f707a;
    public final /* synthetic */ C0131af b;

    public Xe(C0131af c0131af, PluginErrorDetails pluginErrorDetails) {
        this.b = c0131af;
        this.f707a = pluginErrorDetails;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((InterfaceC0379kb) this.b.d.get()).getPluginExtension().reportUnhandledException(this.f707a);
    }
}
