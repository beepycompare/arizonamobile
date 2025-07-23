package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* renamed from: io.appmetrica.analytics.impl.bf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0157bf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f784a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PluginErrorDetails c;
    public final /* synthetic */ C0183cf d;

    public RunnableC0157bf(C0183cf c0183cf, String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.d = c0183cf;
        this.f784a = str;
        this.b = str2;
        this.c = pluginErrorDetails;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((InterfaceC0431mb) this.d.d.get()).getPluginExtension().reportError(this.f784a, this.b, this.c);
    }
}
