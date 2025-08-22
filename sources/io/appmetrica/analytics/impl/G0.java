package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.plugins.PluginErrorDetails;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class G0 {

    /* renamed from: a  reason: collision with root package name */
    public final IHandlerExecutor f444a = C0696x4.l().g().a();
    public final C0617u0 b;
    public final C0279gf c;
    public final C0356jf d;

    public G0() {
        C0617u0 c0617u0 = new C0617u0();
        this.b = c0617u0;
        this.c = new C0279gf(c0617u0);
        this.d = new C0356jf();
    }

    public final void a(final PluginErrorDetails pluginErrorDetails) {
        C0279gf c0279gf = this.c;
        c0279gf.f872a.a(null);
        c0279gf.b.a(pluginErrorDetails);
        C0356jf c0356jf = this.d;
        Intrinsics.checkNotNull(pluginErrorDetails);
        c0356jf.getClass();
        this.f444a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.G0$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                G0.a(G0.this, pluginErrorDetails);
            }
        });
    }

    public final void a(final PluginErrorDetails pluginErrorDetails, final String str) {
        C0279gf c0279gf = this.c;
        c0279gf.f872a.a(null);
        c0279gf.b.a(pluginErrorDetails);
        if (c0279gf.d.a((Collection<Object>) (pluginErrorDetails != null ? pluginErrorDetails.getStacktrace() : null)).f1067a) {
            C0356jf c0356jf = this.d;
            Intrinsics.checkNotNull(pluginErrorDetails);
            c0356jf.getClass();
            this.f444a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.G0$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    G0.a(G0.this, pluginErrorDetails, str);
                }
            });
        }
    }

    public final void a(final String str, final String str2, final PluginErrorDetails pluginErrorDetails) {
        C0279gf c0279gf = this.c;
        c0279gf.f872a.a(null);
        c0279gf.c.a(str);
        C0356jf c0356jf = this.d;
        Intrinsics.checkNotNull(str);
        c0356jf.getClass();
        this.f444a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.G0$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                G0.a(G0.this, str, str2, pluginErrorDetails);
            }
        });
    }

    public static final void a(G0 g0, PluginErrorDetails pluginErrorDetails, String str) {
        g0.b.getClass();
        C0592t0 c0592t0 = C0592t0.e;
        Intrinsics.checkNotNull(c0592t0);
        Gc i = c0592t0.f().i();
        Intrinsics.checkNotNull(i);
        i.f455a.getPluginExtension().reportError(pluginErrorDetails, str);
    }

    public static final void a(G0 g0, String str, String str2, PluginErrorDetails pluginErrorDetails) {
        g0.b.getClass();
        C0592t0 c0592t0 = C0592t0.e;
        Intrinsics.checkNotNull(c0592t0);
        Gc i = c0592t0.f().i();
        Intrinsics.checkNotNull(i);
        i.f455a.getPluginExtension().reportError(str, str2, pluginErrorDetails);
    }

    public static final void a(G0 g0, PluginErrorDetails pluginErrorDetails) {
        g0.b.getClass();
        C0592t0 c0592t0 = C0592t0.e;
        Intrinsics.checkNotNull(c0592t0);
        Gc i = c0592t0.f().i();
        Intrinsics.checkNotNull(i);
        i.f455a.getPluginExtension().reportUnhandledException(pluginErrorDetails);
    }
}
