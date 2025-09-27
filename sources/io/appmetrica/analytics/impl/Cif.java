package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Provider;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.plugins.IPluginReporter;
import io.appmetrica.analytics.plugins.PluginErrorDetails;
import java.util.Collection;
/* renamed from: io.appmetrica.analytics.impl.if  reason: invalid class name */
/* loaded from: classes4.dex */
public final class Cif implements IPluginReporter {

    /* renamed from: a  reason: collision with root package name */
    public final C0408lf f923a = new C0408lf();
    public final C0434mf b = new C0434mf();
    public final IHandlerExecutor c = A4.l().g().a();
    public final Provider d;

    public Cif(Provider<InterfaceC0557rb> provider) {
        this.d = provider;
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(PluginErrorDetails pluginErrorDetails, String str) {
        C0408lf c0408lf = this.f923a;
        c0408lf.f973a.a(pluginErrorDetails);
        if (c0408lf.c.a((Collection<Object>) (pluginErrorDetails != null ? pluginErrorDetails.getStacktrace() : null)).f1146a) {
            this.b.getClass();
            this.c.execute(new RunnableC0279gf(this, pluginErrorDetails, str));
        }
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
        this.f923a.f973a.a(pluginErrorDetails);
        this.b.getClass();
        this.c.execute(new RunnableC0253ff(this, pluginErrorDetails));
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.f923a.b.a(str);
        this.b.getClass();
        this.c.execute(new RunnableC0305hf(this, str, str2, pluginErrorDetails));
    }
}
