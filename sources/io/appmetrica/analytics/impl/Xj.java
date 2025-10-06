package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* loaded from: classes4.dex */
public final class Xj implements InterfaceC0534qb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f746a;

    public Xj(PluginErrorDetails pluginErrorDetails) {
        this.f746a = pluginErrorDetails;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0534qb
    public final void a(InterfaceC0558rb interfaceC0558rb) {
        interfaceC0558rb.getPluginExtension().reportUnhandledException(this.f746a);
    }
}
