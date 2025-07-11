package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.dh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0211dh implements InterfaceC0673w6 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f806a;
    public final C0671w4 b;
    public final IHandlerExecutor c = Ga.j().w().e();

    public C0211dh(Context context, C0671w4 c0671w4) {
        this.f806a = context;
        this.b = c0671w4;
    }

    public final void a(C0325i6 c0325i6, Bundle bundle) {
        if (c0325i6.m()) {
            return;
        }
        this.c.execute(new RunnableC0684wh(this.f806a, c0325i6, bundle, this.b));
    }

    public final void a(C0397l4 c0397l4, C0325i6 c0325i6, K4 k4) {
        this.b.a(c0397l4, k4).a(c0325i6, k4);
        this.b.a(c0397l4.b, c0397l4.c, c0397l4.d);
    }
}
