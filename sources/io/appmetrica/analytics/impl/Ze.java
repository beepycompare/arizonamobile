package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* loaded from: classes4.dex */
public final class Ze implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f737a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PluginErrorDetails c;
    public final /* synthetic */ C0139af d;

    public Ze(C0139af c0139af, String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.d = c0139af;
        this.f737a = str;
        this.b = str2;
        this.c = pluginErrorDetails;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((InterfaceC0387kb) this.d.d.get()).getPluginExtension().reportError(this.f737a, this.b, this.c);
    }
}
