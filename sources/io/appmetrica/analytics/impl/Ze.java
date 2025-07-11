package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* loaded from: classes4.dex */
public final class Ze implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f738a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PluginErrorDetails c;
    public final /* synthetic */ C0131af d;

    public Ze(C0131af c0131af, String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.d = c0131af;
        this.f738a = str;
        this.b = str2;
        this.c = pluginErrorDetails;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((InterfaceC0379kb) this.d.d.get()).getPluginExtension().reportError(this.f738a, this.b, this.c);
    }
}
