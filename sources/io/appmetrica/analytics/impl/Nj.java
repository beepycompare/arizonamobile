package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* loaded from: classes4.dex */
public final class Nj implements InterfaceC0354jb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f558a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PluginErrorDetails c;

    public Nj(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.f558a = str;
        this.b = str2;
        this.c = pluginErrorDetails;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0354jb
    public final void a(InterfaceC0379kb interfaceC0379kb) {
        interfaceC0379kb.getPluginExtension().reportError(this.f558a, this.b, this.c);
    }
}
