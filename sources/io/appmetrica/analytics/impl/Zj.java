package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* loaded from: classes4.dex */
public final class Zj implements InterfaceC0534qb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f778a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PluginErrorDetails c;

    public Zj(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.f778a = str;
        this.b = str2;
        this.c = pluginErrorDetails;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0534qb
    public final void a(InterfaceC0558rb interfaceC0558rb) {
        interfaceC0558rb.getPluginExtension().reportError(this.f778a, this.b, this.c);
    }
}
