package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* loaded from: classes4.dex */
public final class Mj implements InterfaceC0354jb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f540a;
    public final /* synthetic */ String b;

    public Mj(PluginErrorDetails pluginErrorDetails, String str) {
        this.f540a = pluginErrorDetails;
        this.b = str;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0354jb
    public final void a(InterfaceC0379kb interfaceC0379kb) {
        interfaceC0379kb.getPluginExtension().reportError(this.f540a, this.b);
    }
}
