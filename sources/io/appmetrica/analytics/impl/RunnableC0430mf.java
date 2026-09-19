package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* renamed from: io.appmetrica.analytics.impl.mf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0430mf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f1099a;
    public final /* synthetic */ C0508pf b;

    public RunnableC0430mf(C0508pf c0508pf, PluginErrorDetails pluginErrorDetails) {
        this.b = c0508pf;
        this.f1099a = pluginErrorDetails;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((InterfaceC0504pb) this.b.d.get()).getPluginExtension().reportUnhandledException(this.f1099a);
    }
}
