package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* renamed from: io.appmetrica.analytics.impl.nf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0458nf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f1114a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0510pf c;

    public RunnableC0458nf(C0510pf c0510pf, PluginErrorDetails pluginErrorDetails, String str) {
        this.c = c0510pf;
        this.f1114a = pluginErrorDetails;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((InterfaceC0506pb) this.c.d.get()).getPluginExtension().reportError(this.f1114a, this.b);
    }
}
