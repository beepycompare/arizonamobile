package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import io.appmetrica.analytics.DeferredDeeplinkListener;
import io.appmetrica.analytics.DeferredDeeplinkParametersListener;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.Set;
/* loaded from: classes4.dex */
public final class Bg implements InterfaceC0708xg {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f365a;
    public final Oi b;
    public final C0408lf c;
    public final C0272g8 d;
    public final Jg e;
    public final Handler f;

    public Bg(Oi oi, C0408lf c0408lf, Handler handler) {
        this(oi, c0408lf, handler, c0408lf.s());
    }

    public final void a() {
        if (this.f365a) {
            return;
        }
        Oi oi = this.b;
        Lg lg = new Lg(this.f, this);
        oi.getClass();
        Bundle bundle = new Bundle();
        bundle.putParcelable("io.appmetrica.analytics.impl.referrer.common.ReferrerResultReceiver", lg);
        PublicLogger anonymousInstance = PublicLogger.getAnonymousInstance();
        Set set = T9.f659a;
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        C0320i4 c0320i4 = new C0320i4("", "", InputDeviceCompat.SOURCE_TOUCHSCREEN, 0, anonymousInstance);
        c0320i4.m = bundle;
        C0114a5 c0114a5 = oi.f591a;
        oi.a(Oi.a(c0320i4, c0114a5), c0114a5, 1, null);
    }

    public Bg(Oi oi, C0408lf c0408lf, Handler handler, boolean z) {
        this(oi, c0408lf, handler, z, new C0272g8(z), new Jg());
    }

    public Bg(Oi oi, C0408lf c0408lf, Handler handler, boolean z, C0272g8 c0272g8, Jg jg) {
        this.b = oi;
        this.c = c0408lf;
        this.f365a = z;
        this.d = c0272g8;
        this.e = jg;
        this.f = handler;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0708xg
    public final void a(Fg fg) {
        String str = fg == null ? null : fg.f436a;
        if (this.f365a) {
            return;
        }
        synchronized (this) {
            C0272g8 c0272g8 = this.d;
            this.e.getClass();
            c0272g8.d = Jg.a(str);
            c0272g8.a();
        }
    }

    public final synchronized void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        C0272g8 c0272g8 = this.d;
        c0272g8.c = deferredDeeplinkParametersListener;
        if (c0272g8.f869a) {
            c0272g8.a(1);
        } else {
            c0272g8.a();
        }
        this.c.u();
    }

    public final synchronized void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        C0272g8 c0272g8 = this.d;
        c0272g8.b = deferredDeeplinkListener;
        if (c0272g8.f869a) {
            c0272g8.a(1);
        } else {
            c0272g8.a();
        }
        this.c.u();
    }
}
