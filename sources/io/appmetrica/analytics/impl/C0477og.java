package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import io.appmetrica.analytics.DeferredDeeplinkListener;
import io.appmetrica.analytics.DeferredDeeplinkParametersListener;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.Map;
import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.og  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0477og implements InterfaceC0376kg {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1041a;
    public final Bi b;
    public final C0117af c;
    public final R7 d;
    public final C0676wg e;
    public final Handler f;

    public C0477og(Bi bi, C0117af c0117af, Handler handler) {
        this(bi, c0117af, handler, c0117af.s());
    }

    public final void a() {
        if (this.f1041a) {
            return;
        }
        Bi bi = this.b;
        ResultReceiverC0726yg resultReceiverC0726yg = new ResultReceiverC0726yg(this.f, this);
        bi.getClass();
        Bundle bundle = new Bundle();
        bundle.putParcelable("io.appmetrica.analytics.impl.referrer.common.ReferrerResultReceiver", resultReceiverC0726yg);
        PublicLogger anonymousInstance = PublicLogger.getAnonymousInstance();
        Set set = D9.f438a;
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        U3 u3 = new U3("", "", InputDeviceCompat.SOURCE_TOUCHSCREEN, 0, anonymousInstance);
        u3.m = bundle;
        M4 m4 = bi.f414a;
        bi.a(Bi.a(u3, m4), m4, 1, (Map) null);
    }

    public C0477og(Bi bi, C0117af c0117af, Handler handler, boolean z) {
        this(bi, c0117af, handler, z, new R7(z), new C0676wg());
    }

    public C0477og(Bi bi, C0117af c0117af, Handler handler, boolean z, R7 r7, C0676wg c0676wg) {
        this.b = bi;
        this.c = c0117af;
        this.f1041a = z;
        this.d = r7;
        this.e = c0676wg;
        this.f = handler;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0376kg
    public final void a(C0576sg c0576sg) {
        String str = c0576sg == null ? null : c0576sg.f1114a;
        if (this.f1041a) {
            return;
        }
        synchronized (this) {
            R7 r7 = this.d;
            this.e.getClass();
            r7.d = C0676wg.a(str);
            r7.a();
        }
    }

    public final synchronized void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        R7 r7 = this.d;
        r7.c = deferredDeeplinkParametersListener;
        if (r7.f662a) {
            r7.a(1);
        } else {
            r7.a();
        }
        this.c.u();
    }

    public final synchronized void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        R7 r7 = this.d;
        r7.b = deferredDeeplinkListener;
        if (r7.f662a) {
            r7.a(1);
        } else {
            r7.a();
        }
        this.c.u();
    }
}
