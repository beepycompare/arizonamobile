package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* renamed from: io.appmetrica.analytics.impl.of  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0477of implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1137a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PluginErrorDetails c;
    public final /* synthetic */ C0503pf d;

    public RunnableC0477of(C0503pf c0503pf, String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.d = c0503pf;
        this.f1137a = str;
        this.b = str2;
        this.c = pluginErrorDetails;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((InterfaceC0499pb) this.d.d.get()).getPluginExtension().reportError(this.f1137a, this.b, this.c);
    }
}
