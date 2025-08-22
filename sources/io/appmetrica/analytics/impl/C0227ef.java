package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Provider;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.plugins.IPluginReporter;
import io.appmetrica.analytics.plugins.PluginErrorDetails;
import java.util.Collection;
/* renamed from: io.appmetrica.analytics.impl.ef  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0227ef implements IPluginReporter {

    /* renamed from: a  reason: collision with root package name */
    public final C0305hf f841a = new C0305hf();
    public final Cif b = new Cif();
    public final IHandlerExecutor c = C0696x4.l().g().a();
    public final Provider d;

    public C0227ef(Provider<InterfaceC0479ob> provider) {
        this.d = provider;
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(PluginErrorDetails pluginErrorDetails, String str) {
        C0305hf c0305hf = this.f841a;
        c0305hf.f888a.a(pluginErrorDetails);
        if (c0305hf.c.a((Collection<Object>) (pluginErrorDetails != null ? pluginErrorDetails.getStacktrace() : null)).f1067a) {
            this.b.getClass();
            this.c.execute(new RunnableC0176cf(this, pluginErrorDetails, str));
        }
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
        this.f841a.f888a.a(pluginErrorDetails);
        this.b.getClass();
        this.c.execute(new RunnableC0150bf(this, pluginErrorDetails));
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.f841a.b.a(str);
        this.b.getClass();
        this.c.execute(new RunnableC0202df(this, str, str2, pluginErrorDetails));
    }
}
