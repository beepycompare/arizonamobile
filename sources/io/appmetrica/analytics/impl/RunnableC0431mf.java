package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* renamed from: io.appmetrica.analytics.impl.mf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0431mf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f1099a;
    public final /* synthetic */ C0509pf b;

    public RunnableC0431mf(C0509pf c0509pf, PluginErrorDetails pluginErrorDetails) {
        this.b = c0509pf;
        this.f1099a = pluginErrorDetails;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((InterfaceC0505pb) this.b.d.get()).getPluginExtension().reportUnhandledException(this.f1099a);
    }
}
