package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import io.appmetrica.analytics.DeferredDeeplinkListener;
import io.appmetrica.analytics.DeferredDeeplinkParametersListener;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.Map;
import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.jg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0353jg implements InterfaceC0250fg {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1065a;
    public final C0680wi b;
    public final Ve c;
    public final L7 d;
    public final C0553rg e;
    public final Handler f;

    public C0353jg(C0680wi c0680wi, Ve ve, Handler handler) {
        this(c0680wi, ve, handler, ve.s());
    }

    public final void a() {
        if (this.f1065a) {
            return;
        }
        C0680wi c0680wi = this.b;
        ResultReceiverC0603tg resultReceiverC0603tg = new ResultReceiverC0603tg(this.f, this);
        c0680wi.getClass();
        Bundle bundle = new Bundle();
        bundle.putParcelable("io.appmetrica.analytics.impl.referrer.common.ReferrerResultReceiver", resultReceiverC0603tg);
        PublicLogger anonymousInstance = PublicLogger.getAnonymousInstance();
        Set set = AbstractC0671w9.f1284a;
        EnumC0142bb enumC0142bb = EnumC0142bb.EVENT_TYPE_UNDEFINED;
        M3 m3 = new M3("", "", InputDeviceCompat.SOURCE_TOUCHSCREEN, 0, anonymousInstance);
        m3.m = bundle;
        F4 f4 = c0680wi.f1288a;
        c0680wi.a(C0680wi.a(m3, f4), f4, 1, (Map) null);
    }

    public C0353jg(C0680wi c0680wi, Ve ve, Handler handler, boolean z) {
        this(c0680wi, ve, handler, z, new L7(z), new C0553rg());
    }

    public C0353jg(C0680wi c0680wi, Ve ve, Handler handler, boolean z, L7 l7, C0553rg c0553rg) {
        this.b = c0680wi;
        this.c = ve;
        this.f1065a = z;
        this.d = l7;
        this.e = c0553rg;
        this.f = handler;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0250fg
    public final void a(C0454ng c0454ng) {
        String str = c0454ng == null ? null : c0454ng.f1137a;
        if (this.f1065a) {
            return;
        }
        synchronized (this) {
            L7 l7 = this.d;
            this.e.getClass();
            l7.d = C0553rg.a(str);
            l7.a();
        }
    }

    public final synchronized void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        L7 l7 = this.d;
        l7.c = deferredDeeplinkParametersListener;
        if (l7.f673a) {
            l7.a(1);
        } else {
            l7.a();
        }
        this.c.u();
    }

    public final synchronized void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        L7 l7 = this.d;
        l7.b = deferredDeeplinkListener;
        if (l7.f673a) {
            l7.a(1);
        } else {
            l7.a();
        }
        this.c.u();
    }
}
