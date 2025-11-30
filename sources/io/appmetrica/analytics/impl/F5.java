package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.IReporter;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
/* loaded from: classes5.dex */
public final class F5 {

    /* renamed from: a  reason: collision with root package name */
    public final C0460o f473a;
    public final IReporter b;
    public Context c;
    public final E5 d;

    public F5(C0460o c0460o) {
        this(c0460o, 0);
    }

    public final synchronized void a(Context context) {
        if (this.c == null) {
            Context applicationContext = context.getApplicationContext();
            this.f473a.a(applicationContext);
            this.f473a.registerListener(this.d, ActivityEvent.RESUMED, ActivityEvent.PAUSED);
            this.c = applicationContext;
        }
    }

    public F5(C0460o c0460o, IReporter iReporter) {
        this.f473a = c0460o;
        this.b = iReporter;
        this.d = new E5(this);
    }

    public /* synthetic */ F5(C0460o c0460o, int i) {
        this(c0460o, AbstractC0711y1.a());
    }

    public final synchronized Context a() {
        return this.c;
    }
}
