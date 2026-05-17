package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* loaded from: classes5.dex */
public final class Sg implements InterfaceC0189d6 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f787a;
    public final C0109a4 b;
    public final IHandlerExecutor c = C0448na.k().w().d();

    public Sg(Context context, C0109a4 c0109a4) {
        this.f787a = context;
        this.b = c0109a4;
    }

    public final void a(P5 p5, Bundle bundle) {
        if (p5.m()) {
            return;
        }
        this.c.execute(new RunnableC0405lh(this.f787a, p5, bundle, this.b));
    }

    public final void a(P3 p3, P5 p5, C0492p4 c0492p4) {
        this.b.a(p3, c0492p4).a(p5, c0492p4);
        this.b.a(p3.b, p3.c, p3.d);
    }
}
