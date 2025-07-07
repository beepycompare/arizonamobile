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
public final class C0641ug implements InterfaceC0542qg {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1076a;
    public final Gi b;
    public final C0317hf c;
    public final C0184c8 d;
    public final Cg e;
    public final Handler f;

    public C0641ug(Gi gi, C0317hf c0317hf, Handler handler) {
        this(gi, c0317hf, handler, c0317hf.s());
    }

    public final void a() {
        if (this.f1076a) {
            return;
        }
        Gi gi = this.b;
        Eg eg = new Eg(this.f, this);
        gi.getClass();
        Bundle bundle = new Bundle();
        bundle.putParcelable("io.appmetrica.analytics.impl.referrer.common.ReferrerResultReceiver", eg);
        PublicLogger anonymousInstance = PublicLogger.getAnonymousInstance();
        Set set = O9.f564a;
        EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_UNDEFINED;
        C0331i4 c0331i4 = new C0331i4("", "", InputDeviceCompat.SOURCE_TOUCHSCREEN, 0, anonymousInstance);
        c0331i4.m = bundle;
        C0129a5 c0129a5 = gi.f446a;
        gi.a(Gi.a(c0331i4, c0129a5), c0129a5, 1, null);
    }

    public C0641ug(Gi gi, C0317hf c0317hf, Handler handler, boolean z) {
        this(gi, c0317hf, handler, z, new C0184c8(z), new Cg());
    }

    public C0641ug(Gi gi, C0317hf c0317hf, Handler handler, boolean z, C0184c8 c0184c8, Cg cg) {
        this.b = gi;
        this.c = c0317hf;
        this.f1076a = z;
        this.d = c0184c8;
        this.e = cg;
        this.f = handler;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0542qg
    public final void a(C0741yg c0741yg) {
        String str = c0741yg == null ? null : c0741yg.f1146a;
        if (this.f1076a) {
            return;
        }
        synchronized (this) {
            C0184c8 c0184c8 = this.d;
            this.e.getClass();
            c0184c8.d = Cg.a(str);
            c0184c8.a();
        }
    }

    public final synchronized void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        C0184c8 c0184c8 = this.d;
        c0184c8.c = deferredDeeplinkParametersListener;
        if (c0184c8.f781a) {
            c0184c8.a(1);
        } else {
            c0184c8.a();
        }
        this.c.u();
    }

    public final synchronized void a(DeferredDeeplinkListener deferredDeeplinkListener) {
        C0184c8 c0184c8 = this.d;
        c0184c8.b = deferredDeeplinkListener;
        if (c0184c8.f781a) {
            c0184c8.a(1);
        } else {
            c0184c8.a();
        }
        this.c.u();
    }
}
