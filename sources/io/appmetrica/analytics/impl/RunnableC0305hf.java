package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* renamed from: io.appmetrica.analytics.impl.hf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0305hf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f911a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PluginErrorDetails c;
    public final /* synthetic */ Cif d;

    public RunnableC0305hf(Cif cif, String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.d = cif;
        this.f911a = str;
        this.b = str2;
        this.c = pluginErrorDetails;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((InterfaceC0557rb) this.d.d.get()).getPluginExtension().reportError(this.f911a, this.b, this.c);
    }
}
