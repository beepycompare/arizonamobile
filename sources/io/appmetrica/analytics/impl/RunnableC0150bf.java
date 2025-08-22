package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* renamed from: io.appmetrica.analytics.impl.bf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0150bf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f795a;
    public final /* synthetic */ C0227ef b;

    public RunnableC0150bf(C0227ef c0227ef, PluginErrorDetails pluginErrorDetails) {
        this.b = c0227ef;
        this.f795a = pluginErrorDetails;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((InterfaceC0479ob) this.b.d.get()).getPluginExtension().reportUnhandledException(this.f795a);
    }
}
