package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* renamed from: io.appmetrica.analytics.impl.bk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0151bk implements InterfaceC0478ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f912a;

    public C0151bk(PluginErrorDetails pluginErrorDetails) {
        this.f912a = pluginErrorDetails;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0478ob
    public final void a(InterfaceC0504pb interfaceC0504pb) {
        interfaceC0504pb.getPluginExtension().reportUnhandledException(this.f912a);
    }
}
