package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* renamed from: io.appmetrica.analytics.impl.gf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0279gf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f897a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Cif c;

    public RunnableC0279gf(Cif cif, PluginErrorDetails pluginErrorDetails, String str) {
        this.c = cif;
        this.f897a = pluginErrorDetails;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((InterfaceC0557rb) this.c.d.get()).getPluginExtension().reportError(this.f897a, this.b);
    }
}
