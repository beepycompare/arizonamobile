package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* loaded from: classes4.dex */
public final class Ye implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f722a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0139af c;

    public Ye(C0139af c0139af, PluginErrorDetails pluginErrorDetails, String str) {
        this.c = c0139af;
        this.f722a = pluginErrorDetails;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((InterfaceC0387kb) this.c.d.get()).getPluginExtension().reportError(this.f722a, this.b);
    }
}
