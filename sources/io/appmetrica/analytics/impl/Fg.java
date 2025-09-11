package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import io.appmetrica.analytics.DeferredDeeplinkListener;
import io.appmetrica.analytics.DeferredDeeplinkParametersListener;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.Set;
/* loaded from: classes4.dex */
public final class Fg implements Bg {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f447a;
    public final Si b;
    public final C0512pf c;
    public final C0349j8 d;
    public final Ng e;
    public final Handler f;

    public Fg(Si si, C0512pf c0512pf, Handler handler) {
        this(si, c0512pf, handler, c0512pf.s());
    }

    public final void a() {
        if (this.f447a) {
            return;
        }
        Si si = this.b;
        Pg pg = new Pg(this.f, this);
        si.getClass();
        Bundle bundle = new Bundle();
        bundle.putParcelable("io.appmetrica.analytics.impl.referrer.common.ReferrerResultReceiver", pg);
        PublicLogger anonymousInstance = PublicLogger.getAnonymousInstance();
        Set set = W9.f725a;
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        C0397l4 c0397l4 = new C0397l4("", "", InputDeviceCompat.SOURCE_TOUCHSCREEN, 0, anonymousInstance);
        c0397l4.m = bundle;
        C0192d5 c0192d5 = si.f672a;
        si.a(Si.a(c0397l4, c0192d5), c0192d5, 1, null);
    }

    public Fg(Si si, C0512pf c0512pf, Handler handler, boolean z) {
        this(si, c0512pf, handler, z, new C0349j8(z), new Ng());
    }

    public Fg(Si si, C0512pf c0512pf, Handler handler, boolean z, C0349j8 c0349j8, Ng ng) {
        this.b = si;
        this.c = c0512pf;
        this.f447a = z;
        this.d = c0349j8;
        this.e = ng;
        this.f = handler;
    }

    @Override // io.appmetrica.analytics.impl.Bg
    public final void a(Jg jg) {
        String str = jg == null ? null : jg.f519a;
        if (this.f447a) {
            return;
        }
        synchronized (this) {
            C0349j8 c0349j8 = this.d;
            this.e.getClass();
            c0349j8.d = Ng.a(str);
            c0349j8.a();
        }
    }

    public final synchronized void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        C0349j8 c0349j8 = this.d;
        c0349j8.c = deferredDeeplinkParametersListener;
        if (c0349j8.f936a) {
            c0349j8.a(1);
        } else {
            c0349j8.a();
        }
        this.c.u();
    }

    public final synchronized void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        C0349j8 c0349j8 = this.d;
        c0349j8.b = deferredDeeplinkListener;
        if (c0349j8.f936a) {
            c0349j8.a(1);
        } else {
            c0349j8.a();
        }
        this.c.u();
    }
}
