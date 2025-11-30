package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.plugins.PluginErrorDetails;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class L0 {

    /* renamed from: a  reason: collision with root package name */
    public final IHandlerExecutor f562a = C0158c4.l().g().a();
    public final C0735z0 b;
    public final Re c;
    public final Ue d;

    public L0() {
        C0735z0 c0735z0 = new C0735z0();
        this.b = c0735z0;
        this.c = new Re(c0735z0);
        this.d = new Ue();
    }

    public final void a(final PluginErrorDetails pluginErrorDetails) {
        Re re = this.c;
        re.f662a.a(null);
        re.b.a(pluginErrorDetails);
        Ue ue = this.d;
        Intrinsics.checkNotNull(pluginErrorDetails);
        ue.getClass();
        this.f562a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.L0$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                L0.a(L0.this, pluginErrorDetails);
            }
        });
    }

    public final void a(final PluginErrorDetails pluginErrorDetails, final String str) {
        Re re = this.c;
        re.f662a.a(null);
        re.b.a(pluginErrorDetails);
        if (re.d.a((Collection<Object>) (pluginErrorDetails != null ? pluginErrorDetails.getStacktrace() : null)).f1107a) {
            Ue ue = this.d;
            Intrinsics.checkNotNull(pluginErrorDetails);
            ue.getClass();
            this.f562a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.L0$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    L0.a(L0.this, pluginErrorDetails, str);
                }
            });
        }
    }

    public final void a(final String str, final String str2, final PluginErrorDetails pluginErrorDetails) {
        Re re = this.c;
        re.f662a.a(null);
        re.c.a(str);
        Ue ue = this.d;
        Intrinsics.checkNotNull(str);
        ue.getClass();
        this.f562a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.L0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                L0.a(L0.this, str, str2, pluginErrorDetails);
            }
        });
    }

    public static final void a(L0 l0, PluginErrorDetails pluginErrorDetails, String str) {
        l0.b.getClass();
        C0710y0 c0710y0 = C0710y0.e;
        Intrinsics.checkNotNull(c0710y0);
        C0372kc i = c0710y0.f().i();
        Intrinsics.checkNotNull(i);
        i.f975a.getPluginExtension().reportError(pluginErrorDetails, str);
    }

    public static final void a(L0 l0, String str, String str2, PluginErrorDetails pluginErrorDetails) {
        l0.b.getClass();
        C0710y0 c0710y0 = C0710y0.e;
        Intrinsics.checkNotNull(c0710y0);
        C0372kc i = c0710y0.f().i();
        Intrinsics.checkNotNull(i);
        i.f975a.getPluginExtension().reportError(str, str2, pluginErrorDetails);
    }

    public static final void a(L0 l0, PluginErrorDetails pluginErrorDetails) {
        l0.b.getClass();
        C0710y0 c0710y0 = C0710y0.e;
        Intrinsics.checkNotNull(c0710y0);
        C0372kc i = c0710y0.f().i();
        Intrinsics.checkNotNull(i);
        i.f975a.getPluginExtension().reportUnhandledException(pluginErrorDetails);
    }
}
