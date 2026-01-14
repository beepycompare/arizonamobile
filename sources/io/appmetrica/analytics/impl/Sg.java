package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* loaded from: classes5.dex */
public final class Sg implements InterfaceC0190d6 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f783a;
    public final C0110a4 b;
    public final IHandlerExecutor c = C0449na.k().w().d();

    public Sg(Context context, C0110a4 c0110a4) {
        this.f783a = context;
        this.b = c0110a4;
    }

    public final void a(P5 p5, Bundle bundle) {
        if (p5.m()) {
            return;
        }
        this.c.execute(new RunnableC0406lh(this.f783a, p5, bundle, this.b));
    }

    public final void a(P3 p3, P5 p5, C0493p4 c0493p4) {
        this.b.a(p3, c0493p4).a(p5, c0493p4);
        this.b.a(p3.b, p3.c, p3.d);
    }
}
