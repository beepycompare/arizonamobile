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
public final class C0354jg implements InterfaceC0251fg {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1066a;
    public final C0681wi b;
    public final Ve c;
    public final L7 d;
    public final C0554rg e;
    public final Handler f;

    public C0354jg(C0681wi c0681wi, Ve ve, Handler handler) {
        this(c0681wi, ve, handler, ve.s());
    }

    public final void a() {
        if (this.f1066a) {
            return;
        }
        C0681wi c0681wi = this.b;
        ResultReceiverC0604tg resultReceiverC0604tg = new ResultReceiverC0604tg(this.f, this);
        c0681wi.getClass();
        Bundle bundle = new Bundle();
        bundle.putParcelable("io.appmetrica.analytics.impl.referrer.common.ReferrerResultReceiver", resultReceiverC0604tg);
        PublicLogger anonymousInstance = PublicLogger.getAnonymousInstance();
        Set set = AbstractC0672w9.f1285a;
        EnumC0143bb enumC0143bb = EnumC0143bb.EVENT_TYPE_UNDEFINED;
        M3 m3 = new M3("", "", InputDeviceCompat.SOURCE_TOUCHSCREEN, 0, anonymousInstance);
        m3.m = bundle;
        F4 f4 = c0681wi.f1289a;
        c0681wi.a(C0681wi.a(m3, f4), f4, 1, (Map) null);
    }

    public C0354jg(C0681wi c0681wi, Ve ve, Handler handler, boolean z) {
        this(c0681wi, ve, handler, z, new L7(z), new C0554rg());
    }

    public C0354jg(C0681wi c0681wi, Ve ve, Handler handler, boolean z, L7 l7, C0554rg c0554rg) {
        this.b = c0681wi;
        this.c = ve;
        this.f1066a = z;
        this.d = l7;
        this.e = c0554rg;
        this.f = handler;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0251fg
    public final void a(C0455ng c0455ng) {
        String str = c0455ng == null ? null : c0455ng.f1138a;
        if (this.f1066a) {
            return;
        }
        synchronized (this) {
            L7 l7 = this.d;
            this.e.getClass();
            l7.d = C0554rg.a(str);
            l7.a();
        }
    }

    public final synchronized void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        L7 l7 = this.d;
        l7.c = deferredDeeplinkParametersListener;
        if (l7.f674a) {
            l7.a(1);
        } else {
            l7.a();
        }
        this.c.u();
    }

    public final synchronized void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        L7 l7 = this.d;
        l7.b = deferredDeeplinkListener;
        if (l7.f674a) {
            l7.a(1);
        } else {
            l7.a();
        }
        this.c.u();
    }
}
