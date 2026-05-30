package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Provider;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.plugins.IPluginReporter;
import io.appmetrica.analytics.plugins.PluginErrorDetails;
import java.util.Collection;
/* renamed from: io.appmetrica.analytics.impl.pf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0510pf implements IPluginReporter {

    /* renamed from: a  reason: collision with root package name */
    public final C0587sf f1147a = new C0587sf();
    public final C0613tf b = new C0613tf();
    public final IHandlerExecutor c = C0576s4.l().g().a();
    public final Provider d;

    public C0510pf(Provider<InterfaceC0506pb> provider) {
        this.d = provider;
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(PluginErrorDetails pluginErrorDetails, String str) {
        C0587sf c0587sf = this.f1147a;
        c0587sf.f1198a.a(pluginErrorDetails);
        if (c0587sf.c.a((Collection<Object>) (pluginErrorDetails != null ? pluginErrorDetails.getStacktrace() : null)).f782a) {
            this.b.getClass();
            this.c.execute(new RunnableC0458nf(this, pluginErrorDetails, str));
        }
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
        this.f1147a.f1198a.a(pluginErrorDetails);
        this.b.getClass();
        this.c.execute(new RunnableC0432mf(this, pluginErrorDetails));
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.f1147a.b.a(str);
        this.b.getClass();
        this.c.execute(new RunnableC0484of(this, str, str2, pluginErrorDetails));
    }
}
