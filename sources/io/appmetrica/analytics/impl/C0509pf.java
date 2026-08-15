package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Provider;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.plugins.IPluginReporter;
import io.appmetrica.analytics.plugins.PluginErrorDetails;
import java.util.Collection;
/* renamed from: io.appmetrica.analytics.impl.pf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0509pf implements IPluginReporter {

    /* renamed from: a  reason: collision with root package name */
    public final C0586sf f1149a = new C0586sf();
    public final C0612tf b = new C0612tf();
    public final IHandlerExecutor c = C0575s4.l().g().a();
    public final Provider d;

    public C0509pf(Provider<InterfaceC0505pb> provider) {
        this.d = provider;
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(PluginErrorDetails pluginErrorDetails, String str) {
        C0586sf c0586sf = this.f1149a;
        c0586sf.f1200a.a(pluginErrorDetails);
        if (c0586sf.c.a((Collection<Object>) (pluginErrorDetails != null ? pluginErrorDetails.getStacktrace() : null)).f784a) {
            this.b.getClass();
            this.c.execute(new RunnableC0457nf(this, pluginErrorDetails, str));
        }
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
        this.f1149a.f1200a.a(pluginErrorDetails);
        this.b.getClass();
        this.c.execute(new RunnableC0431mf(this, pluginErrorDetails));
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.f1149a.b.a(str);
        this.b.getClass();
        this.c.execute(new RunnableC0483of(this, str, str2, pluginErrorDetails));
    }
}
