package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.plugins.PluginErrorDetails;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class G0 {

    /* renamed from: a  reason: collision with root package name */
    public final IHandlerExecutor f433a = C0704x4.l().g().a();
    public final C0625u0 b;
    public final C0191cf c;
    public final C0267ff d;

    public G0() {
        C0625u0 c0625u0 = new C0625u0();
        this.b = c0625u0;
        this.c = new C0191cf(c0625u0);
        this.d = new C0267ff();
    }

    public final void a(final PluginErrorDetails pluginErrorDetails) {
        C0191cf c0191cf = this.c;
        c0191cf.f784a.a(null);
        c0191cf.b.a(pluginErrorDetails);
        C0267ff c0267ff = this.d;
        Intrinsics.checkNotNull(pluginErrorDetails);
        c0267ff.getClass();
        this.f433a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.G0$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                G0.a(G0.this, pluginErrorDetails);
            }
        });
    }

    public final void a(final PluginErrorDetails pluginErrorDetails, final String str) {
        C0191cf c0191cf = this.c;
        c0191cf.f784a.a(null);
        c0191cf.b.a(pluginErrorDetails);
        if (c0191cf.d.a((Collection<Object>) (pluginErrorDetails != null ? pluginErrorDetails.getStacktrace() : null)).f912a) {
            C0267ff c0267ff = this.d;
            Intrinsics.checkNotNull(pluginErrorDetails);
            c0267ff.getClass();
            this.f433a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.G0$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    G0.a(G0.this, pluginErrorDetails, str);
                }
            });
        }
    }

    public final void a(final String str, final String str2, final PluginErrorDetails pluginErrorDetails) {
        C0191cf c0191cf = this.c;
        c0191cf.f784a.a(null);
        c0191cf.c.a(str);
        C0267ff c0267ff = this.d;
        Intrinsics.checkNotNull(str);
        c0267ff.getClass();
        this.f433a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.G0$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                G0.a(G0.this, str, str2, pluginErrorDetails);
            }
        });
    }

    public static final void a(G0 g0, PluginErrorDetails pluginErrorDetails, String str) {
        g0.b.getClass();
        C0600t0 c0600t0 = C0600t0.e;
        Intrinsics.checkNotNull(c0600t0);
        Cc i = c0600t0.f().i();
        Intrinsics.checkNotNull(i);
        i.f372a.getPluginExtension().reportError(pluginErrorDetails, str);
    }

    public static final void a(G0 g0, String str, String str2, PluginErrorDetails pluginErrorDetails) {
        g0.b.getClass();
        C0600t0 c0600t0 = C0600t0.e;
        Intrinsics.checkNotNull(c0600t0);
        Cc i = c0600t0.f().i();
        Intrinsics.checkNotNull(i);
        i.f372a.getPluginExtension().reportError(str, str2, pluginErrorDetails);
    }

    public static final void a(G0 g0, PluginErrorDetails pluginErrorDetails) {
        g0.b.getClass();
        C0600t0 c0600t0 = C0600t0.e;
        Intrinsics.checkNotNull(c0600t0);
        Cc i = c0600t0.f().i();
        Intrinsics.checkNotNull(i);
        i.f372a.getPluginExtension().reportUnhandledException(pluginErrorDetails);
    }
}
