package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* loaded from: classes4.dex */
public final class Zj implements InterfaceC0533qb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f777a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PluginErrorDetails c;

    public Zj(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.f777a = str;
        this.b = str2;
        this.c = pluginErrorDetails;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0533qb
    public final void a(InterfaceC0557rb interfaceC0557rb) {
        interfaceC0557rb.getPluginExtension().reportError(this.f777a, this.b, this.c);
    }
}
