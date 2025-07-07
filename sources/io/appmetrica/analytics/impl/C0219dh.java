package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.dh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0219dh implements InterfaceC0681w6 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f805a;
    public final C0679w4 b;
    public final IHandlerExecutor c = Ga.j().w().e();

    public C0219dh(Context context, C0679w4 c0679w4) {
        this.f805a = context;
        this.b = c0679w4;
    }

    public final void a(C0333i6 c0333i6, Bundle bundle) {
        if (c0333i6.m()) {
            return;
        }
        this.c.execute(new RunnableC0692wh(this.f805a, c0333i6, bundle, this.b));
    }

    public final void a(C0405l4 c0405l4, C0333i6 c0333i6, K4 k4) {
        this.b.a(c0405l4, k4).a(c0333i6, k4);
        this.b.a(c0405l4.b, c0405l4.c, c0405l4.d);
    }
}
