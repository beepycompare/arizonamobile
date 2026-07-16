package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* renamed from: io.appmetrica.analytics.impl.ck  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0179ck implements InterfaceC0480ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f933a;
    public final /* synthetic */ String b;

    public C0179ck(PluginErrorDetails pluginErrorDetails, String str) {
        this.f933a = pluginErrorDetails;
        this.b = str;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0480ob
    public final void a(InterfaceC0506pb interfaceC0506pb) {
        interfaceC0506pb.getPluginExtension().reportError(this.f933a, this.b);
    }
}
