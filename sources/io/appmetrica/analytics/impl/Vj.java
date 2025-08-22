package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* loaded from: classes4.dex */
public final class Vj implements InterfaceC0454nb {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f698a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PluginErrorDetails c;

    public Vj(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.f698a = str;
        this.b = str2;
        this.c = pluginErrorDetails;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0454nb
    public final void a(InterfaceC0479ob interfaceC0479ob) {
        interfaceC0479ob.getPluginExtension().reportError(this.f698a, this.b, this.c);
    }
}
