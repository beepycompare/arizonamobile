package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Provider;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.plugins.IPluginReporter;
import io.appmetrica.analytics.plugins.PluginErrorDetails;
import java.util.Collection;
/* loaded from: classes5.dex */
public final class Pe implements IPluginReporter {

    /* renamed from: a  reason: collision with root package name */
    public final Se f733a = new Se();
    public final Te b = new Te();
    public final IHandlerExecutor c = C0157c4.l().g().a();
    public final Provider d;

    public Pe(Provider<Sa> provider) {
        this.d = provider;
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(PluginErrorDetails pluginErrorDetails, String str) {
        Se se = this.f733a;
        se.f776a.a(pluginErrorDetails);
        if (se.c.a((Collection<Object>) (pluginErrorDetails != null ? pluginErrorDetails.getStacktrace() : null)).f1205a) {
            this.b.getClass();
            this.c.execute(new Ne(this, pluginErrorDetails, str));
        }
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
        this.f733a.f776a.a(pluginErrorDetails);
        this.b.getClass();
        this.c.execute(new Me(this, pluginErrorDetails));
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.f733a.b.a(str);
        this.b.getClass();
        this.c.execute(new Oe(this, str, str2, pluginErrorDetails));
    }
}
