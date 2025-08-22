package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.kh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0384kh implements InterfaceC0748z6 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f939a;
    public final C0671w4 b;
    public final IHandlerExecutor c = Ka.j().w().e();

    public C0384kh(Context context, C0671w4 c0671w4) {
        this.f939a = context;
        this.b = c0671w4;
    }

    public final void a(C0399l6 c0399l6, Bundle bundle) {
        if (c0399l6.m()) {
            return;
        }
        this.c.execute(new Dh(this.f939a, c0399l6, bundle, this.b));
    }

    public final void a(C0397l4 c0397l4, C0399l6 c0399l6, K4 k4) {
        this.b.a(c0397l4, k4).a(c0399l6, k4);
        this.b.a(c0397l4.b, c0397l4.c, c0397l4.d);
    }
}
