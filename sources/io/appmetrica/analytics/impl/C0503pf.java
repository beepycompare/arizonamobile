package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Provider;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.plugins.IPluginReporter;
import io.appmetrica.analytics.plugins.PluginErrorDetails;
import java.util.Collection;
/* renamed from: io.appmetrica.analytics.impl.pf  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0503pf implements IPluginReporter {

    /* renamed from: a  reason: collision with root package name */
    public final C0580sf f1152a = new C0580sf();
    public final C0606tf b = new C0606tf();
    public final IHandlerExecutor c = C0569s4.l().g().a();
    public final Provider d;

    public C0503pf(Provider<InterfaceC0499pb> provider) {
        this.d = provider;
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(PluginErrorDetails pluginErrorDetails, String str) {
        C0580sf c0580sf = this.f1152a;
        c0580sf.f1203a.a(pluginErrorDetails);
        if (c0580sf.c.a((Collection<Object>) (pluginErrorDetails != null ? pluginErrorDetails.getStacktrace() : null)).f787a) {
            this.b.getClass();
            this.c.execute(new RunnableC0451nf(this, pluginErrorDetails, str));
        }
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
        this.f1152a.f1203a.a(pluginErrorDetails);
        this.b.getClass();
        this.c.execute(new RunnableC0425mf(this, pluginErrorDetails));
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.f1152a.b.a(str);
        this.b.getClass();
        this.c.execute(new RunnableC0477of(this, str, str2, pluginErrorDetails));
    }
}
