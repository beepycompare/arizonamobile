package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Provider;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.plugins.IPluginReporter;
import io.appmetrica.analytics.plugins.PluginErrorDetails;
import java.util.Collection;
/* loaded from: classes5.dex */
public final class Te implements IPluginReporter {

    /* renamed from: a  reason: collision with root package name */
    public final We f706a = new We();
    public final Xe b = new Xe();
    public final IHandlerExecutor c = C0338j4.l().g().a();
    public final Provider d;

    public Te(Provider<Ya> provider) {
        this.d = provider;
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(PluginErrorDetails pluginErrorDetails, String str) {
        We we = this.f706a;
        we.f743a.a(pluginErrorDetails);
        if (we.c.a((Collection<Object>) (pluginErrorDetails != null ? pluginErrorDetails.getStacktrace() : null)).f1120a) {
            this.b.getClass();
            this.c.execute(new Re(this, pluginErrorDetails, str));
        }
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
        this.f706a.f743a.a(pluginErrorDetails);
        this.b.getClass();
        this.c.execute(new Qe(this, pluginErrorDetails));
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.f706a.b.a(str);
        this.b.getClass();
        this.c.execute(new Se(this, str, str2, pluginErrorDetails));
    }
}
