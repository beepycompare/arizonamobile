package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* renamed from: io.appmetrica.analytics.impl.of  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0484of implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1131a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PluginErrorDetails c;
    public final /* synthetic */ C0510pf d;

    public RunnableC0484of(C0510pf c0510pf, String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.d = c0510pf;
        this.f1131a = str;
        this.b = str2;
        this.c = pluginErrorDetails;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((InterfaceC0506pb) this.d.d.get()).getPluginExtension().reportError(this.f1131a, this.b, this.c);
    }
}
