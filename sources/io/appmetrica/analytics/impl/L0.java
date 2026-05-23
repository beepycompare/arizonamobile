package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.AppMetricaPlugins;
import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* loaded from: classes5.dex */
public final class L0 implements AppMetricaPlugins {

    /* renamed from: a  reason: collision with root package name */
    public final N0 f635a;

    public L0(N0 n0) {
        this.f635a = n0;
    }

    @Override // io.appmetrica.analytics.plugins.AppMetricaPlugins
    public final void reportError(PluginErrorDetails pluginErrorDetails, String str) {
        this.f635a.a(pluginErrorDetails, str);
    }

    @Override // io.appmetrica.analytics.plugins.AppMetricaPlugins
    public final void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
        this.f635a.a(pluginErrorDetails);
    }

    public L0() {
        this(new N0());
    }

    @Override // io.appmetrica.analytics.plugins.AppMetricaPlugins
    public final void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.f635a.a(str, str2, pluginErrorDetails);
    }
}
