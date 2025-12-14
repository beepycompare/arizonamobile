package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import io.appmetrica.analytics.DeferredDeeplinkListener;
import io.appmetrica.analytics.DeferredDeeplinkParametersListener;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.Map;
import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.kg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0375kg implements InterfaceC0272gg {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1075a;
    public final C0702xi b;
    public final We c;
    public final M7 d;
    public final C0575sg e;
    public final Handler f;

    public C0375kg(C0702xi c0702xi, We we, Handler handler) {
        this(c0702xi, we, handler, we.s());
    }

    public final void a() {
        if (this.f1075a) {
            return;
        }
        C0702xi c0702xi = this.b;
        ResultReceiverC0625ug resultReceiverC0625ug = new ResultReceiverC0625ug(this.f, this);
        c0702xi.getClass();
        Bundle bundle = new Bundle();
        bundle.putParcelable("io.appmetrica.analytics.impl.referrer.common.ReferrerResultReceiver", resultReceiverC0625ug);
        PublicLogger anonymousInstance = PublicLogger.getAnonymousInstance();
        Set set = AbstractC0693x9.f1294a;
        EnumC0164cb enumC0164cb = EnumC0164cb.EVENT_TYPE_UNDEFINED;
        N3 n3 = new N3("", "", InputDeviceCompat.SOURCE_TOUCHSCREEN, 0, anonymousInstance);
        n3.m = bundle;
        G4 g4 = c0702xi.f1298a;
        c0702xi.a(C0702xi.a(n3, g4), g4, 1, (Map) null);
    }

    public C0375kg(C0702xi c0702xi, We we, Handler handler, boolean z) {
        this(c0702xi, we, handler, z, new M7(z), new C0575sg());
    }

    public C0375kg(C0702xi c0702xi, We we, Handler handler, boolean z, M7 m7, C0575sg c0575sg) {
        this.b = c0702xi;
        this.c = we;
        this.f1075a = z;
        this.d = m7;
        this.e = c0575sg;
        this.f = handler;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0272gg
    public final void a(C0476og c0476og) {
        String str = c0476og == null ? null : c0476og.f1147a;
        if (this.f1075a) {
            return;
        }
        synchronized (this) {
            M7 m7 = this.d;
            this.e.getClass();
            m7.d = C0575sg.a(str);
            m7.a();
        }
    }

    public final synchronized void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        M7 m7 = this.d;
        m7.c = deferredDeeplinkParametersListener;
        if (m7.f682a) {
            m7.a(1);
        } else {
            m7.a();
        }
        this.c.u();
    }

    public final synchronized void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        M7 m7 = this.d;
        m7.b = deferredDeeplinkListener;
        if (m7.f682a) {
            m7.a(1);
        } else {
            m7.a();
        }
        this.c.u();
    }
}
