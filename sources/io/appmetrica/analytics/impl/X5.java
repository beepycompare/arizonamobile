package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.IReporter;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
/* loaded from: classes4.dex */
public final class X5 {

    /* renamed from: a  reason: collision with root package name */
    public final C0442n f700a;
    public final IReporter b;
    public Context c;
    public final W5 d;

    public X5(C0442n c0442n) {
        this(c0442n, 0);
    }

    public final synchronized void a(Context context) {
        if (this.c == null) {
            Context applicationContext = context.getApplicationContext();
            this.f700a.a(applicationContext);
            this.f700a.registerListener(this.d, ActivityEvent.RESUMED, ActivityEvent.PAUSED);
            this.c = applicationContext;
        }
    }

    public X5(C0442n c0442n, IReporter iReporter) {
        this.f700a = c0442n;
        this.b = iReporter;
        this.d = new W5(this);
    }

    public /* synthetic */ X5(C0442n c0442n, int i) {
        this(c0442n, AbstractC0593t1.a());
    }

    public final synchronized Context a() {
        return this.c;
    }
}
