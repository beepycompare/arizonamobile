package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* loaded from: classes4.dex */
public final class Xe implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f706a;
    public final /* synthetic */ C0139af b;

    public Xe(C0139af c0139af, PluginErrorDetails pluginErrorDetails) {
        this.b = c0139af;
        this.f706a = pluginErrorDetails;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((InterfaceC0387kb) this.b.d.get()).getPluginExtension().reportUnhandledException(this.f706a);
    }
}
