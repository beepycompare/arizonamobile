package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* renamed from: io.appmetrica.analytics.impl.fh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0262fh implements InterfaceC0750z6 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f848a;
    public final C0673w4 b;
    public final IHandlerExecutor c = Ia.j().w().e();

    public C0262fh(Context context, C0673w4 c0673w4) {
        this.f848a = context;
        this.b = c0673w4;
    }

    public final void a(C0401l6 c0401l6, Bundle bundle) {
        if (c0401l6.m()) {
            return;
        }
        this.c.execute(new RunnableC0736yh(this.f848a, c0401l6, bundle, this.b));
    }

    public final void a(C0399l4 c0399l4, C0401l6 c0401l6, K4 k4) {
        this.b.a(c0399l4, k4).a(c0401l6, k4);
        this.b.a(c0399l4.b, c0399l4.c, c0399l4.d);
    }
}
