package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import io.appmetrica.analytics.DeferredDeeplinkListener;
import io.appmetrica.analytics.DeferredDeeplinkParametersListener;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.wg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0685wg implements InterfaceC0585sg {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1123a;
    public final Ji b;
    public final C0360jf c;
    public final C0253f8 d;
    public final Eg e;
    public final Handler f;

    public C0685wg(Ji ji, C0360jf c0360jf, Handler handler) {
        this(ji, c0360jf, handler, c0360jf.s());
    }

    public final void a() {
        if (this.f1123a) {
            return;
        }
        Ji ji = this.b;
        Gg gg = new Gg(this.f, this);
        ji.getClass();
        Bundle bundle = new Bundle();
        bundle.putParcelable("io.appmetrica.analytics.impl.referrer.common.ReferrerResultReceiver", gg);
        PublicLogger anonymousInstance = PublicLogger.getAnonymousInstance();
        Set set = R9.f621a;
        EnumC0680wb enumC0680wb = EnumC0680wb.EVENT_TYPE_UNDEFINED;
        C0325i4 c0325i4 = new C0325i4("", "", InputDeviceCompat.SOURCE_TOUCHSCREEN, 0, anonymousInstance);
        c0325i4.m = bundle;
        C0121a5 c0121a5 = ji.f509a;
        ji.a(Ji.a(c0325i4, c0121a5), c0121a5, 1, null);
    }

    public C0685wg(Ji ji, C0360jf c0360jf, Handler handler, boolean z) {
        this(ji, c0360jf, handler, z, new C0253f8(z), new Eg());
    }

    public C0685wg(Ji ji, C0360jf c0360jf, Handler handler, boolean z, C0253f8 c0253f8, Eg eg) {
        this.b = ji;
        this.c = c0360jf;
        this.f1123a = z;
        this.d = c0253f8;
        this.e = eg;
        this.f = handler;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0585sg
    public final void a(Ag ag) {
        String str = ag == null ? null : ag.f340a;
        if (this.f1123a) {
            return;
        }
        synchronized (this) {
            C0253f8 c0253f8 = this.d;
            this.e.getClass();
            c0253f8.d = Eg.a(str);
            c0253f8.a();
        }
    }

    public final synchronized void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        C0253f8 c0253f8 = this.d;
        c0253f8.c = deferredDeeplinkParametersListener;
        if (c0253f8.f844a) {
            c0253f8.a(1);
        } else {
            c0253f8.a();
        }
        this.c.u();
    }

    public final synchronized void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        C0253f8 c0253f8 = this.d;
        c0253f8.b = deferredDeeplinkListener;
        if (c0253f8.f844a) {
            c0253f8.a(1);
        } else {
            c0253f8.a();
        }
        this.c.u();
    }
}
