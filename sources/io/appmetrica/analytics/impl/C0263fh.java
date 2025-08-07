package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.fh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0263fh implements InterfaceC0751z6 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f848a;
    public final C0674w4 b;
    public final IHandlerExecutor c = Ia.j().w().e();

    public C0263fh(Context context, C0674w4 c0674w4) {
        this.f848a = context;
        this.b = c0674w4;
    }

    public final void a(C0402l6 c0402l6, Bundle bundle) {
        if (c0402l6.m()) {
            return;
        }
        this.c.execute(new RunnableC0737yh(this.f848a, c0402l6, bundle, this.b));
    }

    public final void a(C0400l4 c0400l4, C0402l6 c0402l6, K4 k4) {
        this.b.a(c0400l4, k4).a(c0402l6, k4);
        this.b.a(c0400l4.b, c0400l4.c, c0400l4.d);
    }
}
