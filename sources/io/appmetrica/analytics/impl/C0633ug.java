package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import io.appmetrica.analytics.DeferredDeeplinkListener;
import io.appmetrica.analytics.DeferredDeeplinkParametersListener;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.Set;
/* renamed from: io.appmetrica.analytics.impl.ug  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0633ug implements InterfaceC0534qg {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1077a;
    public final Gi b;
    public final C0309hf c;
    public final C0176c8 d;
    public final Cg e;
    public final Handler f;

    public C0633ug(Gi gi, C0309hf c0309hf, Handler handler) {
        this(gi, c0309hf, handler, c0309hf.s());
    }

    public final void a() {
        if (this.f1077a) {
            return;
        }
        Gi gi = this.b;
        Eg eg = new Eg(this.f, this);
        gi.getClass();
        Bundle bundle = new Bundle();
        bundle.putParcelable("io.appmetrica.analytics.impl.referrer.common.ReferrerResultReceiver", eg);
        PublicLogger anonymousInstance = PublicLogger.getAnonymousInstance();
        Set set = O9.f565a;
        EnumC0628ub enumC0628ub = EnumC0628ub.EVENT_TYPE_UNDEFINED;
        C0323i4 c0323i4 = new C0323i4("", "", InputDeviceCompat.SOURCE_TOUCHSCREEN, 0, anonymousInstance);
        c0323i4.m = bundle;
        C0121a5 c0121a5 = gi.f447a;
        gi.a(Gi.a(c0323i4, c0121a5), c0121a5, 1, null);
    }

    public C0633ug(Gi gi, C0309hf c0309hf, Handler handler, boolean z) {
        this(gi, c0309hf, handler, z, new C0176c8(z), new Cg());
    }

    public C0633ug(Gi gi, C0309hf c0309hf, Handler handler, boolean z, C0176c8 c0176c8, Cg cg) {
        this.b = gi;
        this.c = c0309hf;
        this.f1077a = z;
        this.d = c0176c8;
        this.e = cg;
        this.f = handler;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0534qg
    public final void a(C0733yg c0733yg) {
        String str = c0733yg == null ? null : c0733yg.f1147a;
        if (this.f1077a) {
            return;
        }
        synchronized (this) {
            C0176c8 c0176c8 = this.d;
            this.e.getClass();
            c0176c8.d = Cg.a(str);
            c0176c8.a();
        }
    }

    public final synchronized void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        C0176c8 c0176c8 = this.d;
        c0176c8.c = deferredDeeplinkParametersListener;
        if (c0176c8.f782a) {
            c0176c8.a(1);
        } else {
            c0176c8.a();
        }
        this.c.u();
    }

    public final synchronized void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        C0176c8 c0176c8 = this.d;
        c0176c8.b = deferredDeeplinkListener;
        if (c0176c8.f782a) {
            c0176c8.a(1);
        } else {
            c0176c8.a();
        }
        this.c.u();
    }
}
