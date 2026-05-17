package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* loaded from: classes5.dex */
public final class Bj implements Qa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f527a;

    public Bj(PluginErrorDetails pluginErrorDetails) {
        this.f527a = pluginErrorDetails;
    }

    @Override // io.appmetrica.analytics.impl.Qa
    public final void a(Ra ra) {
        ra.getPluginExtension().reportUnhandledException(this.f527a);
    }
}
