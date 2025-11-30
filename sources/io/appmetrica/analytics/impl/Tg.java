package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* loaded from: classes5.dex */
public final class Tg implements InterfaceC0211e6 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f694a;
    public final C0132b4 b;
    public final IHandlerExecutor c = C0471oa.k().w().d();

    public Tg(Context context, C0132b4 c0132b4) {
        this.f694a = context;
        this.b = c0132b4;
    }

    public final void a(Q5 q5, Bundle bundle) {
        if (q5.m()) {
            return;
        }
        this.c.execute(new RunnableC0428mh(this.f694a, q5, bundle, this.b));
    }

    public final void a(Q3 q3, Q5 q5, C0515q4 c0515q4) {
        this.b.a(q3, c0515q4).a(q5, c0515q4);
        this.b.a(q3.b, q3.c, q3.d);
    }
}
