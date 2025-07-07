package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Provider;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.plugins.IPluginReporter;
import io.appmetrica.analytics.plugins.PluginErrorDetails;
import java.util.Collection;
/* renamed from: io.appmetrica.analytics.impl.af  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0139af implements IPluginReporter {

    /* renamed from: a  reason: collision with root package name */
    public final C0217df f753a = new C0217df();
    public final C0242ef b = new C0242ef();
    public final IHandlerExecutor c = C0704x4.l().g().a();
    public final Provider d;

    public C0139af(Provider<InterfaceC0387kb> provider) {
        this.d = provider;
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(PluginErrorDetails pluginErrorDetails, String str) {
        C0217df c0217df = this.f753a;
        c0217df.f804a.a(pluginErrorDetails);
        if (c0217df.c.a((Collection<Object>) (pluginErrorDetails != null ? pluginErrorDetails.getStacktrace() : null)).f912a) {
            this.b.getClass();
            this.c.execute(new Ye(this, pluginErrorDetails, str));
        }
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
        this.f753a.f804a.a(pluginErrorDetails);
        this.b.getClass();
        this.c.execute(new Xe(this, pluginErrorDetails));
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.f753a.b.a(str);
        this.b.getClass();
        this.c.execute(new Ze(this, str, str2, pluginErrorDetails));
    }
}
