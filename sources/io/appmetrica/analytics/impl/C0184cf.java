package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Provider;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.plugins.IPluginReporter;
import io.appmetrica.analytics.plugins.PluginErrorDetails;
import java.util.Collection;
/* renamed from: io.appmetrica.analytics.impl.cf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0184cf implements IPluginReporter {

    /* renamed from: a  reason: collision with root package name */
    public final C0261ff f797a = new C0261ff();
    public final C0287gf b = new C0287gf();
    public final IHandlerExecutor c = C0699x4.l().g().a();
    public final Provider d;

    public C0184cf(Provider<InterfaceC0432mb> provider) {
        this.d = provider;
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(PluginErrorDetails pluginErrorDetails, String str) {
        C0261ff c0261ff = this.f797a;
        c0261ff.f847a.a(pluginErrorDetails);
        if (c0261ff.c.a((Collection<Object>) (pluginErrorDetails != null ? pluginErrorDetails.getStacktrace() : null)).f975a) {
            this.b.getClass();
            this.c.execute(new RunnableC0132af(this, pluginErrorDetails, str));
        }
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
        this.f797a.f847a.a(pluginErrorDetails);
        this.b.getClass();
        this.c.execute(new Ze(this, pluginErrorDetails));
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.f797a.b.a(str);
        this.b.getClass();
        this.c.execute(new RunnableC0158bf(this, str, str2, pluginErrorDetails));
    }
}
