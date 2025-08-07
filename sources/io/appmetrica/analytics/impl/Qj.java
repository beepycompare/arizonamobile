package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* loaded from: classes4.dex */
public final class Qj implements InterfaceC0407lb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f613a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PluginErrorDetails c;

    public Qj(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.f613a = str;
        this.b = str2;
        this.c = pluginErrorDetails;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0407lb
    public final void a(InterfaceC0432mb interfaceC0432mb) {
        interfaceC0432mb.getPluginExtension().reportError(this.f613a, this.b, this.c);
    }
}
