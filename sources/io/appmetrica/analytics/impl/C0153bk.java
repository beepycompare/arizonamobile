package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* renamed from: io.appmetrica.analytics.impl.bk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0153bk implements InterfaceC0480ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f910a;

    public C0153bk(PluginErrorDetails pluginErrorDetails) {
        this.f910a = pluginErrorDetails;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0480ob
    public final void a(InterfaceC0506pb interfaceC0506pb) {
        interfaceC0506pb.getPluginExtension().reportUnhandledException(this.f910a);
    }
}
