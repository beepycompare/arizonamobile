package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import io.appmetrica.analytics.DeferredDeeplinkListener;
import io.appmetrica.analytics.DeferredDeeplinkParametersListener;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.Map;
import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.zg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0770zg {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1318a;
    public final Qi b;
    public final C0665vf c;
    public final C0193d8 d;
    public final Gg e;
    public final Handler f;

    public C0770zg(Qi qi, C0665vf c0665vf, Handler handler) {
        this(qi, c0665vf, handler, c0665vf.s());
    }

    public final void a() {
        if (this.f1318a) {
            return;
        }
        Qi qi = this.b;
        Mg mg = new Mg(this.f, this);
        qi.getClass();
        Bundle bundle = new Bundle();
        bundle.putParcelable("io.appmetrica.analytics.impl.referrer.common.ReferrerResultReceiver", mg);
        PublicLogger anonymousInstance = PublicLogger.getAnonymousInstance();
        Set set = Q9.f730a;
        Db db = Db.EVENT_TYPE_UNDEFINED;
        C0189d4 c0189d4 = new C0189d4("", "", (int) InputDeviceCompat.SOURCE_TOUCHSCREEN, 0, anonymousInstance);
        c0189d4.m = bundle;
        V4 v4 = qi.f736a;
        qi.a(Qi.a(c0189d4, v4), v4, 1, (Map) null);
    }

    public C0770zg(Qi qi, C0665vf c0665vf, Handler handler, boolean z) {
        this(qi, c0665vf, handler, z, new C0193d8(z), new Gg());
    }

    public C0770zg(Qi qi, C0665vf c0665vf, Handler handler, boolean z, C0193d8 c0193d8, Gg gg) {
        this.b = qi;
        this.c = c0665vf;
        this.f1318a = z;
        this.d = c0193d8;
        this.e = gg;
        this.f = handler;
    }

    public final void a(Bg bg) {
        String str = bg == null ? null : bg.f480a;
        if (this.f1318a) {
            return;
        }
        synchronized (this) {
            C0193d8 c0193d8 = this.d;
            this.e.getClass();
            c0193d8.d = Gg.a(str);
            c0193d8.a();
        }
    }

    public final synchronized void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        C0193d8 c0193d8 = this.d;
        c0193d8.c = deferredDeeplinkParametersListener;
        if (c0193d8.f943a) {
            c0193d8.a(1);
        } else {
            c0193d8.a();
        }
        this.c.u();
    }

    public final synchronized void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        C0193d8 c0193d8 = this.d;
        c0193d8.b = deferredDeeplinkListener;
        if (c0193d8.f943a) {
            c0193d8.a(1);
        } else {
            c0193d8.a();
        }
        this.c.u();
    }
}
