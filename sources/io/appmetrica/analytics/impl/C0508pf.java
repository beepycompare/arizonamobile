package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Provider;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.plugins.IPluginReporter;
import io.appmetrica.analytics.plugins.PluginErrorDetails;
import java.util.Collection;
/* renamed from: io.appmetrica.analytics.impl.pf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0508pf implements IPluginReporter {

    /* renamed from: a  reason: collision with root package name */
    public final C0585sf f1149a = new C0585sf();
    public final C0611tf b = new C0611tf();
    public final IHandlerExecutor c = C0574s4.l().g().a();
    public final Provider d;

    public C0508pf(Provider<InterfaceC0504pb> provider) {
        this.d = provider;
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(PluginErrorDetails pluginErrorDetails, String str) {
        C0585sf c0585sf = this.f1149a;
        c0585sf.f1200a.a(pluginErrorDetails);
        if (c0585sf.c.a((Collection<Object>) (pluginErrorDetails != null ? pluginErrorDetails.getStacktrace() : null)).f784a) {
            this.b.getClass();
            this.c.execute(new RunnableC0456nf(this, pluginErrorDetails, str));
        }
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
        this.f1149a.f1200a.a(pluginErrorDetails);
        this.b.getClass();
        this.c.execute(new RunnableC0430mf(this, pluginErrorDetails));
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.f1149a.b.a(str);
        this.b.getClass();
        this.c.execute(new RunnableC0482of(this, str, str2, pluginErrorDetails));
    }
}
