package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
/* loaded from: classes5.dex */
public final class Tg implements InterfaceC0210e6 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f791a;
    public final C0131b4 b;
    public final IHandlerExecutor c = C0470oa.k().w().d();

    public Tg(Context context, C0131b4 c0131b4) {
        this.f791a = context;
        this.b = c0131b4;
    }

    public final void a(Q5 q5, Bundle bundle) {
        if (q5.m()) {
            return;
        }
        this.c.execute(new RunnableC0427mh(this.f791a, q5, bundle, this.b));
    }

    public final void a(Q3 q3, Q5 q5, C0514q4 c0514q4) {
        this.b.a(q3, c0514q4).a(q5, c0514q4);
        this.b.a(q3.b, q3.c, q3.d);
    }
}
