package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.plugins.PluginErrorDetails;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class N0 {

    /* renamed from: a  reason: collision with root package name */
    public final IHandlerExecutor f678a = C0569s4.l().g().a();
    public final B0 b;
    public final C0554rf c;
    public final C0632uf d;

    public N0() {
        B0 b0 = new B0();
        this.b = b0;
        this.c = new C0554rf(b0);
        this.d = new C0632uf();
    }

    public final void a(final PluginErrorDetails pluginErrorDetails) {
        C0554rf c0554rf = this.c;
        c0554rf.f1187a.a(null);
        c0554rf.b.a(pluginErrorDetails);
        C0632uf c0632uf = this.d;
        Intrinsics.checkNotNull(pluginErrorDetails);
        c0632uf.getClass();
        this.f678a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.N0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                N0.a(N0.this, pluginErrorDetails);
            }
        });
    }

    public final void a(final PluginErrorDetails pluginErrorDetails, final String str) {
        C0554rf c0554rf = this.c;
        c0554rf.f1187a.a(null);
        c0554rf.b.a(pluginErrorDetails);
        if (c0554rf.d.a((Collection<Object>) (pluginErrorDetails != null ? pluginErrorDetails.getStacktrace() : null)).f787a) {
            C0632uf c0632uf = this.d;
            Intrinsics.checkNotNull(pluginErrorDetails);
            c0632uf.getClass();
            this.f678a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.N0$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    N0.a(N0.this, pluginErrorDetails, str);
                }
            });
        }
    }

    public final void a(final String str, final String str2, final PluginErrorDetails pluginErrorDetails) {
        C0554rf c0554rf = this.c;
        c0554rf.f1187a.a(null);
        c0554rf.c.a(str);
        C0632uf c0632uf = this.d;
        Intrinsics.checkNotNull(str);
        c0632uf.getClass();
        this.f678a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.N0$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                N0.a(N0.this, str, str2, pluginErrorDetails);
            }
        });
    }

    public static final void a(N0 n0, PluginErrorDetails pluginErrorDetails, String str) {
        n0.b.getClass();
        A0 a0 = A0.e;
        Intrinsics.checkNotNull(a0);
        Lc i = a0.f().i();
        Intrinsics.checkNotNull(i);
        i.f650a.getPluginExtension().reportError(pluginErrorDetails, str);
    }

    public static final void a(N0 n0, String str, String str2, PluginErrorDetails pluginErrorDetails) {
        n0.b.getClass();
        A0 a0 = A0.e;
        Intrinsics.checkNotNull(a0);
        Lc i = a0.f().i();
        Intrinsics.checkNotNull(i);
        i.f650a.getPluginExtension().reportError(str, str2, pluginErrorDetails);
    }

    public static final void a(N0 n0, PluginErrorDetails pluginErrorDetails) {
        n0.b.getClass();
        A0 a0 = A0.e;
        Intrinsics.checkNotNull(a0);
        Lc i = a0.f().i();
        Intrinsics.checkNotNull(i);
        i.f650a.getPluginExtension().reportUnhandledException(pluginErrorDetails);
    }
}
