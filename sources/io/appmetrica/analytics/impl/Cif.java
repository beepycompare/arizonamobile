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
    public final C0409lf f923a = new C0409lf();
    public final C0435mf b = new C0435mf();
    public final IHandlerExecutor c = A4.l().g().a();
    public final Provider d;

    public Cif(Provider<InterfaceC0558rb> provider) {
        this.d = provider;
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(PluginErrorDetails pluginErrorDetails, String str) {
        C0409lf c0409lf = this.f923a;
        c0409lf.f973a.a(pluginErrorDetails);
        if (c0409lf.c.a((Collection<Object>) (pluginErrorDetails != null ? pluginErrorDetails.getStacktrace() : null)).f1146a) {
            this.b.getClass();
            this.c.execute(new RunnableC0280gf(this, pluginErrorDetails, str));
        }
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
        this.f923a.f973a.a(pluginErrorDetails);
        this.b.getClass();
        this.c.execute(new RunnableC0254ff(this, pluginErrorDetails));
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.f923a.b.a(str);
        this.b.getClass();
        this.c.execute(new RunnableC0306hf(this, str, str2, pluginErrorDetails));
    }
}
