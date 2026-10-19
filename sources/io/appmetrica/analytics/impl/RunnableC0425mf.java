package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* renamed from: io.appmetrica.analytics.impl.mf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0425mf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f1102a;
    public final /* synthetic */ C0503pf b;

    public RunnableC0425mf(C0503pf c0503pf, PluginErrorDetails pluginErrorDetails) {
        this.b = c0503pf;
        this.f1102a = pluginErrorDetails;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((InterfaceC0499pb) this.b.d.get()).getPluginExtension().reportUnhandledException(this.f1102a);
    }
}
