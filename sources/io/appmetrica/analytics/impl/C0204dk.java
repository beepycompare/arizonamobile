package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* renamed from: io.appmetrica.analytics.impl.dk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0204dk implements InterfaceC0479ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f949a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PluginErrorDetails c;

    public C0204dk(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.f949a = str;
        this.b = str2;
        this.c = pluginErrorDetails;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0479ob
    public final void a(InterfaceC0505pb interfaceC0505pb) {
        interfaceC0505pb.getPluginExtension().reportError(this.f949a, this.b, this.c);
    }
}
