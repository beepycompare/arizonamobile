package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.plugins.PluginErrorDetails;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class G0 {

    /* renamed from: a  reason: collision with root package name */
    public final IHandlerExecutor f443a = C0698x4.l().g().a();
    public final C0619u0 b;
    public final C0234ef c;
    public final C0311hf d;

    public G0() {
        C0619u0 c0619u0 = new C0619u0();
        this.b = c0619u0;
        this.c = new C0234ef(c0619u0);
        this.d = new C0311hf();
    }

    public final void a(final PluginErrorDetails pluginErrorDetails) {
        C0234ef c0234ef = this.c;
        c0234ef.f831a.a(null);
        c0234ef.b.a(pluginErrorDetails);
        C0311hf c0311hf = this.d;
        Intrinsics.checkNotNull(pluginErrorDetails);
        c0311hf.getClass();
        this.f443a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.G0$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                G0.a(G0.this, pluginErrorDetails);
            }
        });
    }

    public final void a(final PluginErrorDetails pluginErrorDetails, final String str) {
        C0234ef c0234ef = this.c;
        c0234ef.f831a.a(null);
        c0234ef.b.a(pluginErrorDetails);
        if (c0234ef.d.a((Collection<Object>) (pluginErrorDetails != null ? pluginErrorDetails.getStacktrace() : null)).f976a) {
            C0311hf c0311hf = this.d;
            Intrinsics.checkNotNull(pluginErrorDetails);
            c0311hf.getClass();
            this.f443a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.G0$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    G0.a(G0.this, pluginErrorDetails, str);
                }
            });
        }
    }

    public final void a(final String str, final String str2, final PluginErrorDetails pluginErrorDetails) {
        C0234ef c0234ef = this.c;
        c0234ef.f831a.a(null);
        c0234ef.c.a(str);
        C0311hf c0311hf = this.d;
        Intrinsics.checkNotNull(str);
        c0311hf.getClass();
        this.f443a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.G0$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                G0.a(G0.this, str, str2, pluginErrorDetails);
            }
        });
    }

    public static final void a(G0 g0, PluginErrorDetails pluginErrorDetails, String str) {
        g0.b.getClass();
        C0594t0 c0594t0 = C0594t0.e;
        Intrinsics.checkNotNull(c0594t0);
        Ec i = c0594t0.f().i();
        Intrinsics.checkNotNull(i);
        i.f417a.getPluginExtension().reportError(pluginErrorDetails, str);
    }

    public static final void a(G0 g0, String str, String str2, PluginErrorDetails pluginErrorDetails) {
        g0.b.getClass();
        C0594t0 c0594t0 = C0594t0.e;
        Intrinsics.checkNotNull(c0594t0);
        Ec i = c0594t0.f().i();
        Intrinsics.checkNotNull(i);
        i.f417a.getPluginExtension().reportError(str, str2, pluginErrorDetails);
    }

    public static final void a(G0 g0, PluginErrorDetails pluginErrorDetails) {
        g0.b.getClass();
        C0594t0 c0594t0 = C0594t0.e;
        Intrinsics.checkNotNull(c0594t0);
        Ec i = c0594t0.f().i();
        Intrinsics.checkNotNull(i);
        i.f417a.getPluginExtension().reportUnhandledException(pluginErrorDetails);
    }
}
