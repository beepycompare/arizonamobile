package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.plugins.PluginErrorDetails;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class I0 {

    /* renamed from: a  reason: collision with root package name */
    public final IHandlerExecutor f485a = A4.l().g().a();
    public final C0671w0 b;
    public final C0382kf c;
    public final C0460nf d;

    public I0() {
        C0671w0 c0671w0 = new C0671w0();
        this.b = c0671w0;
        this.c = new C0382kf(c0671w0);
        this.d = new C0460nf();
    }

    public final void a(final PluginErrorDetails pluginErrorDetails) {
        C0382kf c0382kf = this.c;
        c0382kf.f955a.a(null);
        c0382kf.b.a(pluginErrorDetails);
        C0460nf c0460nf = this.d;
        Intrinsics.checkNotNull(pluginErrorDetails);
        c0460nf.getClass();
        this.f485a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.I0$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                I0.a(I0.this, pluginErrorDetails);
            }
        });
    }

    public final void a(final PluginErrorDetails pluginErrorDetails, final String str) {
        C0382kf c0382kf = this.c;
        c0382kf.f955a.a(null);
        c0382kf.b.a(pluginErrorDetails);
        if (c0382kf.d.a((Collection<Object>) (pluginErrorDetails != null ? pluginErrorDetails.getStacktrace() : null)).f1146a) {
            C0460nf c0460nf = this.d;
            Intrinsics.checkNotNull(pluginErrorDetails);
            c0460nf.getClass();
            this.f485a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.I0$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    I0.a(I0.this, pluginErrorDetails, str);
                }
            });
        }
    }

    public final void a(final String str, final String str2, final PluginErrorDetails pluginErrorDetails) {
        C0382kf c0382kf = this.c;
        c0382kf.f955a.a(null);
        c0382kf.c.a(str);
        C0460nf c0460nf = this.d;
        Intrinsics.checkNotNull(str);
        c0460nf.getClass();
        this.f485a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.I0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                I0.a(I0.this, str, str2, pluginErrorDetails);
            }
        });
    }

    public static final void a(I0 i0, PluginErrorDetails pluginErrorDetails, String str) {
        i0.b.getClass();
        C0646v0 c0646v0 = C0646v0.e;
        Intrinsics.checkNotNull(c0646v0);
        Jc i = c0646v0.f().i();
        Intrinsics.checkNotNull(i);
        i.f517a.getPluginExtension().reportError(pluginErrorDetails, str);
    }

    public static final void a(I0 i0, String str, String str2, PluginErrorDetails pluginErrorDetails) {
        i0.b.getClass();
        C0646v0 c0646v0 = C0646v0.e;
        Intrinsics.checkNotNull(c0646v0);
        Jc i = c0646v0.f().i();
        Intrinsics.checkNotNull(i);
        i.f517a.getPluginExtension().reportError(str, str2, pluginErrorDetails);
    }

    public static final void a(I0 i0, PluginErrorDetails pluginErrorDetails) {
        i0.b.getClass();
        C0646v0 c0646v0 = C0646v0.e;
        Intrinsics.checkNotNull(c0646v0);
        Jc i = c0646v0.f().i();
        Intrinsics.checkNotNull(i);
        i.f517a.getPluginExtension().reportUnhandledException(pluginErrorDetails);
    }
}
