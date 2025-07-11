package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.plugins.PluginErrorDetails;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class G0 {

    /* renamed from: a  reason: collision with root package name */
    public final IHandlerExecutor f434a = C0696x4.l().g().a();
    public final C0617u0 b;
    public final C0183cf c;
    public final C0259ff d;

    public G0() {
        C0617u0 c0617u0 = new C0617u0();
        this.b = c0617u0;
        this.c = new C0183cf(c0617u0);
        this.d = new C0259ff();
    }

    public final void a(final PluginErrorDetails pluginErrorDetails) {
        C0183cf c0183cf = this.c;
        c0183cf.f785a.a(null);
        c0183cf.b.a(pluginErrorDetails);
        C0259ff c0259ff = this.d;
        Intrinsics.checkNotNull(pluginErrorDetails);
        c0259ff.getClass();
        this.f434a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.G0$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                G0.a(G0.this, pluginErrorDetails);
            }
        });
    }

    public final void a(final PluginErrorDetails pluginErrorDetails, final String str) {
        C0183cf c0183cf = this.c;
        c0183cf.f785a.a(null);
        c0183cf.b.a(pluginErrorDetails);
        if (c0183cf.d.a((Collection<Object>) (pluginErrorDetails != null ? pluginErrorDetails.getStacktrace() : null)).f913a) {
            C0259ff c0259ff = this.d;
            Intrinsics.checkNotNull(pluginErrorDetails);
            c0259ff.getClass();
            this.f434a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.G0$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    G0.a(G0.this, pluginErrorDetails, str);
                }
            });
        }
    }

    public final void a(final String str, final String str2, final PluginErrorDetails pluginErrorDetails) {
        C0183cf c0183cf = this.c;
        c0183cf.f785a.a(null);
        c0183cf.c.a(str);
        C0259ff c0259ff = this.d;
        Intrinsics.checkNotNull(str);
        c0259ff.getClass();
        this.f434a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.G0$$ExternalSyntheticLambda2
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
        Cc i = c0592t0.f().i();
        Intrinsics.checkNotNull(i);
        i.f373a.getPluginExtension().reportError(pluginErrorDetails, str);
    }

    public static final void a(G0 g0, String str, String str2, PluginErrorDetails pluginErrorDetails) {
        g0.b.getClass();
        C0592t0 c0592t0 = C0592t0.e;
        Intrinsics.checkNotNull(c0592t0);
        Cc i = c0592t0.f().i();
        Intrinsics.checkNotNull(i);
        i.f373a.getPluginExtension().reportError(str, str2, pluginErrorDetails);
    }

    public static final void a(G0 g0, PluginErrorDetails pluginErrorDetails) {
        g0.b.getClass();
        C0592t0 c0592t0 = C0592t0.e;
        Intrinsics.checkNotNull(c0592t0);
        Cc i = c0592t0.f().i();
        Intrinsics.checkNotNull(i);
        i.f373a.getPluginExtension().reportUnhandledException(pluginErrorDetails);
    }
}
