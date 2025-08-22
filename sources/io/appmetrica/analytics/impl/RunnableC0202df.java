package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* renamed from: io.appmetrica.analytics.impl.df  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0202df implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f831a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PluginErrorDetails c;
    public final /* synthetic */ C0227ef d;

    public RunnableC0202df(C0227ef c0227ef, String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.d = c0227ef;
        this.f831a = str;
        this.b = str2;
        this.c = pluginErrorDetails;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((InterfaceC0479ob) this.d.d.get()).getPluginExtension().reportError(this.f831a, this.b, this.c);
    }
}
