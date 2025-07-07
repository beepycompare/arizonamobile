package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* loaded from: classes4.dex */
public final class Nj implements InterfaceC0362jb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f557a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PluginErrorDetails c;

    public Nj(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.f557a = str;
        this.b = str2;
        this.c = pluginErrorDetails;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0362jb
    public final void a(InterfaceC0387kb interfaceC0387kb) {
        interfaceC0387kb.getPluginExtension().reportError(this.f557a, this.b, this.c);
    }
}
