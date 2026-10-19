package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* renamed from: io.appmetrica.analytics.impl.dk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0198dk implements InterfaceC0473ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f952a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PluginErrorDetails c;

    public C0198dk(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.f952a = str;
        this.b = str2;
        this.c = pluginErrorDetails;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0473ob
    public final void a(InterfaceC0499pb interfaceC0499pb) {
        interfaceC0499pb.getPluginExtension().reportError(this.f952a, this.b, this.c);
    }
}
