package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* loaded from: classes3.dex */
public final class Xg implements InterfaceC0366k6 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f756a;
    public final C0313i4 b;
    public final IHandlerExecutor c = C0620ua.k().x().e();

    public Xg(Context context, C0313i4 c0313i4) {
        this.f756a = context;
        this.b = c0313i4;
    }

    public final void a(W5 w5, Bundle bundle) {
        if (w5.m()) {
            return;
        }
        this.c.execute(new RunnableC0528qh(this.f756a, w5, bundle, this.b));
    }

    public final void a(X3 x3, W5 w5, C0664w4 c0664w4) {
        this.b.a(x3, c0664w4).a(w5, c0664w4);
        this.b.a(x3.b, x3.c, x3.d);
    }
}
