package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Provider;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.plugins.IPluginReporter;
import io.appmetrica.analytics.plugins.PluginErrorDetails;
import java.util.Collection;
/* renamed from: io.appmetrica.analytics.impl.af  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0131af implements IPluginReporter {

    /* renamed from: a  reason: collision with root package name */
    public final C0209df f754a = new C0209df();
    public final C0234ef b = new C0234ef();
    public final IHandlerExecutor c = C0696x4.l().g().a();
    public final Provider d;

    public C0131af(Provider<InterfaceC0379kb> provider) {
        this.d = provider;
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(PluginErrorDetails pluginErrorDetails, String str) {
        C0209df c0209df = this.f754a;
        c0209df.f805a.a(pluginErrorDetails);
        if (c0209df.c.a((Collection<Object>) (pluginErrorDetails != null ? pluginErrorDetails.getStacktrace() : null)).f913a) {
            this.b.getClass();
            this.c.execute(new Ye(this, pluginErrorDetails, str));
        }
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
        this.f754a.f805a.a(pluginErrorDetails);
        this.b.getClass();
        this.c.execute(new Xe(this, pluginErrorDetails));
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.f754a.b.a(str);
        this.b.getClass();
        this.c.execute(new Ze(this, str, str2, pluginErrorDetails));
    }
}
