package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* renamed from: io.appmetrica.analytics.impl.mf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0432mf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f1096a;
    public final /* synthetic */ C0510pf b;

    public RunnableC0432mf(C0510pf c0510pf, PluginErrorDetails pluginErrorDetails) {
        this.b = c0510pf;
        this.f1096a = pluginErrorDetails;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((InterfaceC0506pb) this.b.d.get()).getPluginExtension().reportUnhandledException(this.f1096a);
    }
}
