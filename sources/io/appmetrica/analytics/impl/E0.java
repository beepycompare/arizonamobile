package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.AppMetricaPlugins;
import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* loaded from: classes4.dex */
public final class E0 implements AppMetricaPlugins {

    /* renamed from: a  reason: collision with root package name */
    public final G0 f397a;

    public E0(G0 g0) {
        this.f397a = g0;
    }

    @Override // io.appmetrica.analytics.plugins.AppMetricaPlugins
    public final void reportError(PluginErrorDetails pluginErrorDetails, String str) {
        this.f397a.a(pluginErrorDetails, str);
    }

    @Override // io.appmetrica.analytics.plugins.AppMetricaPlugins
    public final void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
        this.f397a.a(pluginErrorDetails);
    }

    public E0() {
        this(new G0());
    }

    @Override // io.appmetrica.analytics.plugins.AppMetricaPlugins
    public final void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.f397a.a(str, str2, pluginErrorDetails);
    }
}
