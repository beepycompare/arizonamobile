package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.plugins.PluginErrorDetails;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class L0 {

    /* renamed from: a  reason: collision with root package name */
    public final IHandlerExecutor f660a = C0157c4.l().g().a();
    public final C0734z0 b;
    public final Re c;
    public final Ue d;

    public L0() {
        C0734z0 c0734z0 = new C0734z0();
        this.b = c0734z0;
        this.c = new Re(c0734z0);
        this.d = new Ue();
    }

    public final void a(final PluginErrorDetails pluginErrorDetails) {
        Re re = this.c;
        re.f760a.a(null);
        re.b.a(pluginErrorDetails);
        Ue ue = this.d;
        Intrinsics.checkNotNull(pluginErrorDetails);
        ue.getClass();
        this.f660a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.L0$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                L0.a(L0.this, pluginErrorDetails);
            }
        });
    }

    public final void a(final PluginErrorDetails pluginErrorDetails, final String str) {
        Re re = this.c;
        re.f760a.a(null);
        re.b.a(pluginErrorDetails);
        if (re.d.a((Collection<Object>) (pluginErrorDetails != null ? pluginErrorDetails.getStacktrace() : null)).f1205a) {
            Ue ue = this.d;
            Intrinsics.checkNotNull(pluginErrorDetails);
            ue.getClass();
            this.f660a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.L0$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    L0.a(L0.this, pluginErrorDetails, str);
                }
            });
        }
    }

    public final void a(final String str, final String str2, final PluginErrorDetails pluginErrorDetails) {
        Re re = this.c;
        re.f760a.a(null);
        re.c.a(str);
        Ue ue = this.d;
        Intrinsics.checkNotNull(str);
        ue.getClass();
        this.f660a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.L0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                L0.a(L0.this, str, str2, pluginErrorDetails);
            }
        });
    }

    public static final void a(L0 l0, PluginErrorDetails pluginErrorDetails, String str) {
        l0.b.getClass();
        C0709y0 c0709y0 = C0709y0.e;
        Intrinsics.checkNotNull(c0709y0);
        C0371kc i = c0709y0.f().i();
        Intrinsics.checkNotNull(i);
        i.f1073a.getPluginExtension().reportError(pluginErrorDetails, str);
    }

    public static final void a(L0 l0, String str, String str2, PluginErrorDetails pluginErrorDetails) {
        l0.b.getClass();
        C0709y0 c0709y0 = C0709y0.e;
        Intrinsics.checkNotNull(c0709y0);
        C0371kc i = c0709y0.f().i();
        Intrinsics.checkNotNull(i);
        i.f1073a.getPluginExtension().reportError(str, str2, pluginErrorDetails);
    }

    public static final void a(L0 l0, PluginErrorDetails pluginErrorDetails) {
        l0.b.getClass();
        C0709y0 c0709y0 = C0709y0.e;
        Intrinsics.checkNotNull(c0709y0);
        C0371kc i = c0709y0.f().i();
        Intrinsics.checkNotNull(i);
        i.f1073a.getPluginExtension().reportUnhandledException(pluginErrorDetails);
    }
}
