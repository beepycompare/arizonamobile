package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* renamed from: io.appmetrica.analytics.impl.nf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0451nf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f1120a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0503pf c;

    public RunnableC0451nf(C0503pf c0503pf, PluginErrorDetails pluginErrorDetails, String str) {
        this.c = c0503pf;
        this.f1120a = pluginErrorDetails;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((InterfaceC0499pb) this.c.d.get()).getPluginExtension().reportError(this.f1120a, this.b);
    }
}
