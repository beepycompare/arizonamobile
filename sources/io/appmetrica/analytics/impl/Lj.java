package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* loaded from: classes4.dex */
public final class Lj implements InterfaceC0354jb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f521a;

    public Lj(PluginErrorDetails pluginErrorDetails) {
        this.f521a = pluginErrorDetails;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0354jb
    public final void a(InterfaceC0379kb interfaceC0379kb) {
        interfaceC0379kb.getPluginExtension().reportUnhandledException(this.f521a);
    }
}
