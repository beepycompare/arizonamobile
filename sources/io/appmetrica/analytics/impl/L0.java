package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.plugins.PluginErrorDetails;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class L0 {

    /* renamed from: a  reason: collision with root package name */
    public final IHandlerExecutor f671a = C0135b4.l().g().a();
    public final C0737z0 b;
    public final Qe c;
    public final Te d;

    public L0() {
        C0737z0 c0737z0 = new C0737z0();
        this.b = c0737z0;
        this.c = new Qe(c0737z0);
        this.d = new Te();
    }

    public final void a(final PluginErrorDetails pluginErrorDetails) {
        Qe qe = this.c;
        qe.f756a.a(null);
        qe.b.a(pluginErrorDetails);
        Te te = this.d;
        Intrinsics.checkNotNull(pluginErrorDetails);
        te.getClass();
        this.f671a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.L0$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                L0.a(L0.this, pluginErrorDetails);
            }
        });
    }

    public final void a(final PluginErrorDetails pluginErrorDetails, final String str) {
        Qe qe = this.c;
        qe.f756a.a(null);
        qe.b.a(pluginErrorDetails);
        if (qe.d.a((Collection<Object>) (pluginErrorDetails != null ? pluginErrorDetails.getStacktrace() : null)).f1199a) {
            Te te = this.d;
            Intrinsics.checkNotNull(pluginErrorDetails);
            te.getClass();
            this.f671a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.L0$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    L0.a(L0.this, pluginErrorDetails, str);
                }
            });
        }
    }

    public final void a(final String str, final String str2, final PluginErrorDetails pluginErrorDetails) {
        Qe qe = this.c;
        qe.f756a.a(null);
        qe.c.a(str);
        Te te = this.d;
        Intrinsics.checkNotNull(str);
        te.getClass();
        this.f671a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.L0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                L0.a(L0.this, str, str2, pluginErrorDetails);
            }
        });
    }

    public static final void a(L0 l0, PluginErrorDetails pluginErrorDetails, String str) {
        l0.b.getClass();
        C0712y0 c0712y0 = C0712y0.e;
        Intrinsics.checkNotNull(c0712y0);
        C0349jc i = c0712y0.f().i();
        Intrinsics.checkNotNull(i);
        i.f1067a.getPluginExtension().reportError(pluginErrorDetails, str);
    }

    public static final void a(L0 l0, String str, String str2, PluginErrorDetails pluginErrorDetails) {
        l0.b.getClass();
        C0712y0 c0712y0 = C0712y0.e;
        Intrinsics.checkNotNull(c0712y0);
        C0349jc i = c0712y0.f().i();
        Intrinsics.checkNotNull(i);
        i.f1067a.getPluginExtension().reportError(str, str2, pluginErrorDetails);
    }

    public static final void a(L0 l0, PluginErrorDetails pluginErrorDetails) {
        l0.b.getClass();
        C0712y0 c0712y0 = C0712y0.e;
        Intrinsics.checkNotNull(c0712y0);
        C0349jc i = c0712y0.f().i();
        Intrinsics.checkNotNull(i);
        i.f1067a.getPluginExtension().reportUnhandledException(pluginErrorDetails);
    }
}
