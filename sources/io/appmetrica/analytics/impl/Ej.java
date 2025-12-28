package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* loaded from: classes5.dex */
public final class Ej implements Ra {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f562a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PluginErrorDetails c;

    public Ej(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.f562a = str;
        this.b = str2;
        this.c = pluginErrorDetails;
    }

    @Override // io.appmetrica.analytics.impl.Ra
    public final void a(Sa sa) {
        sa.getPluginExtension().reportError(this.f562a, this.b, this.c);
    }
}
