package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.plugins.PluginErrorDetails;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class G0 {

    /* renamed from: a  reason: collision with root package name */
    public final IHandlerExecutor f442a = C0699x4.l().g().a();
    public final C0620u0 b;
    public final C0235ef c;
    public final C0312hf d;

    public G0() {
        C0620u0 c0620u0 = new C0620u0();
        this.b = c0620u0;
        this.c = new C0235ef(c0620u0);
        this.d = new C0312hf();
    }

    public final void a(final PluginErrorDetails pluginErrorDetails) {
        C0235ef c0235ef = this.c;
        c0235ef.f830a.a(null);
        c0235ef.b.a(pluginErrorDetails);
        C0312hf c0312hf = this.d;
        Intrinsics.checkNotNull(pluginErrorDetails);
        c0312hf.getClass();
        this.f442a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.G0$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                G0.a(G0.this, pluginErrorDetails);
            }
        });
    }

    public final void a(final PluginErrorDetails pluginErrorDetails, final String str) {
        C0235ef c0235ef = this.c;
        c0235ef.f830a.a(null);
        c0235ef.b.a(pluginErrorDetails);
        if (c0235ef.d.a((Collection<Object>) (pluginErrorDetails != null ? pluginErrorDetails.getStacktrace() : null)).f975a) {
            C0312hf c0312hf = this.d;
            Intrinsics.checkNotNull(pluginErrorDetails);
            c0312hf.getClass();
            this.f442a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.G0$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    G0.a(G0.this, pluginErrorDetails, str);
                }
            });
        }
    }

    public final void a(final String str, final String str2, final PluginErrorDetails pluginErrorDetails) {
        C0235ef c0235ef = this.c;
        c0235ef.f830a.a(null);
        c0235ef.c.a(str);
        C0312hf c0312hf = this.d;
        Intrinsics.checkNotNull(str);
        c0312hf.getClass();
        this.f442a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.G0$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                G0.a(G0.this, str, str2, pluginErrorDetails);
            }
        });
    }

    public static final void a(G0 g0, PluginErrorDetails pluginErrorDetails, String str) {
        g0.b.getClass();
        C0595t0 c0595t0 = C0595t0.e;
        Intrinsics.checkNotNull(c0595t0);
        Ec i = c0595t0.f().i();
        Intrinsics.checkNotNull(i);
        i.f416a.getPluginExtension().reportError(pluginErrorDetails, str);
    }

    public static final void a(G0 g0, String str, String str2, PluginErrorDetails pluginErrorDetails) {
        g0.b.getClass();
        C0595t0 c0595t0 = C0595t0.e;
        Intrinsics.checkNotNull(c0595t0);
        Ec i = c0595t0.f().i();
        Intrinsics.checkNotNull(i);
        i.f416a.getPluginExtension().reportError(str, str2, pluginErrorDetails);
    }

    public static final void a(G0 g0, PluginErrorDetails pluginErrorDetails) {
        g0.b.getClass();
        C0595t0 c0595t0 = C0595t0.e;
        Intrinsics.checkNotNull(c0595t0);
        Ec i = c0595t0.f().i();
        Intrinsics.checkNotNull(i);
        i.f416a.getPluginExtension().reportUnhandledException(pluginErrorDetails);
    }
}
