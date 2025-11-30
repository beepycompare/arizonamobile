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
public final class C0376kg implements InterfaceC0273gg {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f978a;
    public final C0703xi b;
    public final We c;
    public final M7 d;
    public final C0576sg e;
    public final Handler f;

    public C0376kg(C0703xi c0703xi, We we, Handler handler) {
        this(c0703xi, we, handler, we.s());
    }

    public final void a() {
        if (this.f978a) {
            return;
        }
        C0703xi c0703xi = this.b;
        ResultReceiverC0626ug resultReceiverC0626ug = new ResultReceiverC0626ug(this.f, this);
        c0703xi.getClass();
        Bundle bundle = new Bundle();
        bundle.putParcelable("io.appmetrica.analytics.impl.referrer.common.ReferrerResultReceiver", resultReceiverC0626ug);
        PublicLogger anonymousInstance = PublicLogger.getAnonymousInstance();
        Set set = AbstractC0694x9.f1197a;
        EnumC0165cb enumC0165cb = EnumC0165cb.EVENT_TYPE_UNDEFINED;
        N3 n3 = new N3("", "", InputDeviceCompat.SOURCE_TOUCHSCREEN, 0, anonymousInstance);
        n3.m = bundle;
        G4 g4 = c0703xi.f1201a;
        c0703xi.a(C0703xi.a(n3, g4), g4, 1, (Map) null);
    }

    public C0376kg(C0703xi c0703xi, We we, Handler handler, boolean z) {
        this(c0703xi, we, handler, z, new M7(z), new C0576sg());
    }

    public C0376kg(C0703xi c0703xi, We we, Handler handler, boolean z, M7 m7, C0576sg c0576sg) {
        this.b = c0703xi;
        this.c = we;
        this.f978a = z;
        this.d = m7;
        this.e = c0576sg;
        this.f = handler;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0273gg
    public final void a(C0477og c0477og) {
        String str = c0477og == null ? null : c0477og.f1050a;
        if (this.f978a) {
            return;
        }
        synchronized (this) {
            M7 m7 = this.d;
            this.e.getClass();
            m7.d = C0576sg.a(str);
            m7.a();
        }
    }

    public final synchronized void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        M7 m7 = this.d;
        m7.c = deferredDeeplinkParametersListener;
        if (m7.f585a) {
            m7.a(1);
        } else {
            m7.a();
        }
        this.c.u();
    }

    public final synchronized void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        M7 m7 = this.d;
        m7.b = deferredDeeplinkListener;
        if (m7.f585a) {
            m7.a(1);
        } else {
            m7.a();
        }
        this.c.u();
    }
}
