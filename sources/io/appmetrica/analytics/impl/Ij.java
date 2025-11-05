package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* loaded from: classes3.dex */
public final class Ij implements Xa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f531a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PluginErrorDetails c;

    public Ij(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.f531a = str;
        this.b = str2;
        this.c = pluginErrorDetails;
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final void a(Ya ya) {
        ya.getPluginExtension().reportError(this.f531a, this.b, this.c);
    }
}
