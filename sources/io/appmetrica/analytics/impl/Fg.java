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
    public final boolean f448a;
    public final Si b;
    public final C0513pf c;
    public final C0350j8 d;
    public final Ng e;
    public final Handler f;

    public Fg(Si si, C0513pf c0513pf, Handler handler) {
        this(si, c0513pf, handler, c0513pf.s());
    }

    public final void a() {
        if (this.f448a) {
            return;
        }
        Si si = this.b;
        Pg pg = new Pg(this.f, this);
        si.getClass();
        Bundle bundle = new Bundle();
        bundle.putParcelable("io.appmetrica.analytics.impl.referrer.common.ReferrerResultReceiver", pg);
        PublicLogger anonymousInstance = PublicLogger.getAnonymousInstance();
        Set set = W9.f726a;
        Bb bb = Bb.EVENT_TYPE_UNDEFINED;
        C0398l4 c0398l4 = new C0398l4("", "", InputDeviceCompat.SOURCE_TOUCHSCREEN, 0, anonymousInstance);
        c0398l4.m = bundle;
        C0193d5 c0193d5 = si.f673a;
        si.a(Si.a(c0398l4, c0193d5), c0193d5, 1, null);
    }

    public Fg(Si si, C0513pf c0513pf, Handler handler, boolean z) {
        this(si, c0513pf, handler, z, new C0350j8(z), new Ng());
    }

    public Fg(Si si, C0513pf c0513pf, Handler handler, boolean z, C0350j8 c0350j8, Ng ng) {
        this.b = si;
        this.c = c0513pf;
        this.f448a = z;
        this.d = c0350j8;
        this.e = ng;
        this.f = handler;
    }

    @Override // io.appmetrica.analytics.impl.Bg
    public final void a(Jg jg) {
        String str = jg == null ? null : jg.f520a;
        if (this.f448a) {
            return;
        }
        synchronized (this) {
            C0350j8 c0350j8 = this.d;
            this.e.getClass();
            c0350j8.d = Ng.a(str);
            c0350j8.a();
        }
    }

    public final synchronized void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        C0350j8 c0350j8 = this.d;
        c0350j8.c = deferredDeeplinkParametersListener;
        if (c0350j8.f937a) {
            c0350j8.a(1);
        } else {
            c0350j8.a();
        }
        this.c.u();
    }

    public final synchronized void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        C0350j8 c0350j8 = this.d;
        c0350j8.b = deferredDeeplinkListener;
        if (c0350j8.f937a) {
            c0350j8.a(1);
        } else {
            c0350j8.a();
        }
        this.c.u();
    }
}
