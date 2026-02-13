package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Provider;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.plugins.IPluginReporter;
import io.appmetrica.analytics.plugins.PluginErrorDetails;
import java.util.Collection;
/* loaded from: classes5.dex */
public final class Oe implements IPluginReporter {

    /* renamed from: a  reason: collision with root package name */
    public final Re f724a = new Re();
    public final Se b = new Se();
    public final IHandlerExecutor c = C0136b4.l().g().a();
    public final Provider d;

    public Oe(Provider<Ra> provider) {
        this.d = provider;
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(PluginErrorDetails pluginErrorDetails, String str) {
        Re re = this.f724a;
        re.f766a.a(pluginErrorDetails);
        if (re.c.a((Collection<Object>) (pluginErrorDetails != null ? pluginErrorDetails.getStacktrace() : null)).f1194a) {
            this.b.getClass();
            this.c.execute(new Me(this, pluginErrorDetails, str));
        }
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
        this.f724a.f766a.a(pluginErrorDetails);
        this.b.getClass();
        this.c.execute(new Le(this, pluginErrorDetails));
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.f724a.b.a(str);
        this.b.getClass();
        this.c.execute(new Ne(this, str, str2, pluginErrorDetails));
    }
}
