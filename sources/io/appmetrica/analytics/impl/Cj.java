package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* loaded from: classes5.dex */
public final class Cj implements Ra {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f531a;

    public Cj(PluginErrorDetails pluginErrorDetails) {
        this.f531a = pluginErrorDetails;
    }

    @Override // io.appmetrica.analytics.impl.Ra
    public final void a(Sa sa) {
        sa.getPluginExtension().reportUnhandledException(this.f531a);
    }
}
