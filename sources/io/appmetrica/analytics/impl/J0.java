package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.plugins.PluginErrorDetails;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class J0 {

    /* renamed from: a  reason: collision with root package name */
    public final IHandlerExecutor f537a = C0338j4.l().g().a();
    public final C0685x0 b;
    public final Ve c;
    public final Ye d;

    public J0() {
        C0685x0 c0685x0 = new C0685x0();
        this.b = c0685x0;
        this.c = new Ve(c0685x0);
        this.d = new Ye();
    }

    public final void a(final PluginErrorDetails pluginErrorDetails) {
        Ve ve = this.c;
        ve.f733a.a(null);
        ve.b.a(pluginErrorDetails);
        Ye ye = this.d;
        Intrinsics.checkNotNull(pluginErrorDetails);
        ye.getClass();
        this.f537a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.J0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                J0.a(J0.this, pluginErrorDetails);
            }
        });
    }

    public final void a(final PluginErrorDetails pluginErrorDetails, final String str) {
        Ve ve = this.c;
        ve.f733a.a(null);
        ve.b.a(pluginErrorDetails);
        if (ve.d.a((Collection<Object>) (pluginErrorDetails != null ? pluginErrorDetails.getStacktrace() : null)).f1120a) {
            Ye ye = this.d;
            Intrinsics.checkNotNull(pluginErrorDetails);
            ye.getClass();
            this.f537a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.J0$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    J0.a(J0.this, pluginErrorDetails, str);
                }
            });
        }
    }

    public final void a(final String str, final String str2, final PluginErrorDetails pluginErrorDetails) {
        Ve ve = this.c;
        ve.f733a.a(null);
        ve.c.a(str);
        Ye ye = this.d;
        Intrinsics.checkNotNull(str);
        ye.getClass();
        this.f537a.execute(new Runnable() { // from class: io.appmetrica.analytics.impl.J0$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                J0.a(J0.this, str, str2, pluginErrorDetails);
            }
        });
    }

    public static final void a(J0 j0, PluginErrorDetails pluginErrorDetails, String str) {
        j0.b.getClass();
        C0660w0 c0660w0 = C0660w0.e;
        Intrinsics.checkNotNull(c0660w0);
        C0523qc i = c0660w0.f().i();
        Intrinsics.checkNotNull(i);
        i.f1072a.getPluginExtension().reportError(pluginErrorDetails, str);
    }

    public static final void a(J0 j0, String str, String str2, PluginErrorDetails pluginErrorDetails) {
        j0.b.getClass();
        C0660w0 c0660w0 = C0660w0.e;
        Intrinsics.checkNotNull(c0660w0);
        C0523qc i = c0660w0.f().i();
        Intrinsics.checkNotNull(i);
        i.f1072a.getPluginExtension().reportError(str, str2, pluginErrorDetails);
    }

    public static final void a(J0 j0, PluginErrorDetails pluginErrorDetails) {
        j0.b.getClass();
        C0660w0 c0660w0 = C0660w0.e;
        Intrinsics.checkNotNull(c0660w0);
        C0523qc i = c0660w0.f().i();
        Intrinsics.checkNotNull(i);
        i.f1072a.getPluginExtension().reportUnhandledException(pluginErrorDetails);
    }
}
