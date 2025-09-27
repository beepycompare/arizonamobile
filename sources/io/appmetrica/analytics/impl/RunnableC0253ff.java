package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* renamed from: io.appmetrica.analytics.impl.ff  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0253ff implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f880a;
    public final /* synthetic */ Cif b;

    public RunnableC0253ff(Cif cif, PluginErrorDetails pluginErrorDetails) {
        this.b = cif;
        this.f880a = pluginErrorDetails;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((InterfaceC0557rb) this.b.d.get()).getPluginExtension().reportUnhandledException(this.f880a);
    }
}
