package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.IReporter;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
/* loaded from: classes4.dex */
public final class X5 {

    /* renamed from: a  reason: collision with root package name */
    public final C0450n f699a;
    public final IReporter b;
    public Context c;
    public final W5 d;

    public X5(C0450n c0450n) {
        this(c0450n, 0);
    }

    public final synchronized void a(Context context) {
        if (this.c == null) {
            Context applicationContext = context.getApplicationContext();
            this.f699a.a(applicationContext);
            this.f699a.registerListener(this.d, ActivityEvent.RESUMED, ActivityEvent.PAUSED);
            this.c = applicationContext;
        }
    }

    public X5(C0450n c0450n, IReporter iReporter) {
        this.f699a = c0450n;
        this.b = iReporter;
        this.d = new W5(this);
    }

    public /* synthetic */ X5(C0450n c0450n, int i) {
        this(c0450n, AbstractC0601t1.a());
    }

    public final synchronized Context a() {
        return this.c;
    }
}
