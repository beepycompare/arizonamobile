package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* loaded from: classes4.dex */
public final class Ye implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f723a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0131af c;

    public Ye(C0131af c0131af, PluginErrorDetails pluginErrorDetails, String str) {
        this.c = c0131af;
        this.f723a = pluginErrorDetails;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((InterfaceC0379kb) this.c.d.get()).getPluginExtension().reportError(this.f723a, this.b);
    }
}
