package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.IReporter;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
/* renamed from: io.appmetrica.analytics.impl.a6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0123a6 {

    /* renamed from: a  reason: collision with root package name */
    public final C0445n f762a;
    public final IReporter b;
    public Context c;
    public final Z5 d;

    public C0123a6(C0445n c0445n) {
        this(c0445n, 0);
    }

    public final synchronized void a(Context context) {
        if (this.c == null) {
            Context applicationContext = context.getApplicationContext();
            this.f762a.a(applicationContext);
            this.f762a.registerListener(this.d, ActivityEvent.RESUMED, ActivityEvent.PAUSED);
            this.c = applicationContext;
        }
    }

    public C0123a6(C0445n c0445n, IReporter iReporter) {
        this.f762a = c0445n;
        this.b = iReporter;
        this.d = new Z5(this);
    }

    public /* synthetic */ C0123a6(C0445n c0445n, int i) {
        this(c0445n, AbstractC0596t1.a());
    }

    public final synchronized Context a() {
        return this.c;
    }
}
