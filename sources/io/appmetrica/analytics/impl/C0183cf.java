package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Provider;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.plugins.IPluginReporter;
import io.appmetrica.analytics.plugins.PluginErrorDetails;
import java.util.Collection;
/* renamed from: io.appmetrica.analytics.impl.cf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0183cf implements IPluginReporter {

    /* renamed from: a  reason: collision with root package name */
    public final C0260ff f798a = new C0260ff();
    public final C0286gf b = new C0286gf();
    public final IHandlerExecutor c = C0698x4.l().g().a();
    public final Provider d;

    public C0183cf(Provider<InterfaceC0431mb> provider) {
        this.d = provider;
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(PluginErrorDetails pluginErrorDetails, String str) {
        C0260ff c0260ff = this.f798a;
        c0260ff.f848a.a(pluginErrorDetails);
        if (c0260ff.c.a((Collection<Object>) (pluginErrorDetails != null ? pluginErrorDetails.getStacktrace() : null)).f976a) {
            this.b.getClass();
            this.c.execute(new RunnableC0131af(this, pluginErrorDetails, str));
        }
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
        this.f798a.f848a.a(pluginErrorDetails);
        this.b.getClass();
        this.c.execute(new Ze(this, pluginErrorDetails));
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.f798a.b.a(str);
        this.b.getClass();
        this.c.execute(new RunnableC0157bf(this, str, str2, pluginErrorDetails));
    }
}
