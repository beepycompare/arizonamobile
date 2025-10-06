package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* loaded from: classes4.dex */
public final class Yj implements InterfaceC0534qb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f761a;
    public final /* synthetic */ String b;

    public Yj(PluginErrorDetails pluginErrorDetails, String str) {
        this.f761a = pluginErrorDetails;
        this.b = str;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0534qb
    public final void a(InterfaceC0558rb interfaceC0558rb) {
        interfaceC0558rb.getPluginExtension().reportError(this.f761a, this.b);
    }
}
