package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* renamed from: io.appmetrica.analytics.impl.of  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0483of implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1134a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PluginErrorDetails c;
    public final /* synthetic */ C0509pf d;

    public RunnableC0483of(C0509pf c0509pf, String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.d = c0509pf;
        this.f1134a = str;
        this.b = str2;
        this.c = pluginErrorDetails;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((InterfaceC0505pb) this.d.d.get()).getPluginExtension().reportError(this.f1134a, this.b, this.c);
    }
}
