package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* renamed from: io.appmetrica.analytics.impl.ck  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0177ck implements InterfaceC0478ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f933a;
    public final /* synthetic */ String b;

    public C0177ck(PluginErrorDetails pluginErrorDetails, String str) {
        this.f933a = pluginErrorDetails;
        this.b = str;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0478ob
    public final void a(InterfaceC0504pb interfaceC0504pb) {
        interfaceC0504pb.getPluginExtension().reportError(this.f933a, this.b);
    }
}
