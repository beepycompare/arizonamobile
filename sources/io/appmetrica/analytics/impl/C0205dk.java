package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* renamed from: io.appmetrica.analytics.impl.dk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0205dk implements InterfaceC0480ob {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f947a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PluginErrorDetails c;

    public C0205dk(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.f947a = str;
        this.b = str2;
        this.c = pluginErrorDetails;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0480ob
    public final void a(InterfaceC0506pb interfaceC0506pb) {
        interfaceC0506pb.getPluginExtension().reportError(this.f947a, this.b, this.c);
    }
}
