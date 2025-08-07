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
public final class C0686wg implements InterfaceC0586sg {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1122a;
    public final Ji b;
    public final C0361jf c;
    public final C0254f8 d;
    public final Eg e;
    public final Handler f;

    public C0686wg(Ji ji, C0361jf c0361jf, Handler handler) {
        this(ji, c0361jf, handler, c0361jf.s());
    }

    public final void a() {
        if (this.f1122a) {
            return;
        }
        Ji ji = this.b;
        Gg gg = new Gg(this.f, this);
        ji.getClass();
        Bundle bundle = new Bundle();
        bundle.putParcelable("io.appmetrica.analytics.impl.referrer.common.ReferrerResultReceiver", gg);
        PublicLogger anonymousInstance = PublicLogger.getAnonymousInstance();
        Set set = R9.f620a;
        EnumC0681wb enumC0681wb = EnumC0681wb.EVENT_TYPE_UNDEFINED;
        C0326i4 c0326i4 = new C0326i4("", "", InputDeviceCompat.SOURCE_TOUCHSCREEN, 0, anonymousInstance);
        c0326i4.m = bundle;
        C0122a5 c0122a5 = ji.f508a;
        ji.a(Ji.a(c0326i4, c0122a5), c0122a5, 1, null);
    }

    public C0686wg(Ji ji, C0361jf c0361jf, Handler handler, boolean z) {
        this(ji, c0361jf, handler, z, new C0254f8(z), new Eg());
    }

    public C0686wg(Ji ji, C0361jf c0361jf, Handler handler, boolean z, C0254f8 c0254f8, Eg eg) {
        this.b = ji;
        this.c = c0361jf;
        this.f1122a = z;
        this.d = c0254f8;
        this.e = eg;
        this.f = handler;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0586sg
    public final void a(Ag ag) {
        String str = ag == null ? null : ag.f339a;
        if (this.f1122a) {
            return;
        }
        synchronized (this) {
            C0254f8 c0254f8 = this.d;
            this.e.getClass();
            c0254f8.d = Eg.a(str);
            c0254f8.a();
        }
    }

    public final synchronized void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        C0254f8 c0254f8 = this.d;
        c0254f8.c = deferredDeeplinkParametersListener;
        if (c0254f8.f843a) {
            c0254f8.a(1);
        } else {
            c0254f8.a();
        }
        this.c.u();
    }

    public final synchronized void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        C0254f8 c0254f8 = this.d;
        c0254f8.b = deferredDeeplinkListener;
        if (c0254f8.f843a) {
            c0254f8.a(1);
        } else {
            c0254f8.a();
        }
        this.c.u();
    }
}
