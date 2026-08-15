package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* renamed from: io.appmetrica.analytics.impl.nf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0457nf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f1117a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0509pf c;

    public RunnableC0457nf(C0509pf c0509pf, PluginErrorDetails pluginErrorDetails, String str) {
        this.c = c0509pf;
        this.f1117a = pluginErrorDetails;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((InterfaceC0505pb) this.c.d.get()).getPluginExtension().reportError(this.f1117a, this.b);
    }
}
