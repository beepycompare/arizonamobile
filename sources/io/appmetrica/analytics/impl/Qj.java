package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* loaded from: classes4.dex */
public final class Qj implements InterfaceC0406lb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f613a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PluginErrorDetails c;

    public Qj(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.f613a = str;
        this.b = str2;
        this.c = pluginErrorDetails;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0406lb
    public final void a(InterfaceC0431mb interfaceC0431mb) {
        interfaceC0431mb.getPluginExtension().reportError(this.f613a, this.b, this.c);
    }
}
