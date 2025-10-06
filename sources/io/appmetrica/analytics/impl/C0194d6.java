package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.IReporter;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
/* renamed from: io.appmetrica.analytics.impl.d6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0194d6 {

    /* renamed from: a  reason: collision with root package name */
    public final C0445n f838a;
    public final IReporter b;
    public Context c;
    public final C0168c6 d;

    public C0194d6(C0445n c0445n) {
        this(c0445n, 0);
    }

    public final synchronized void a(Context context) {
        if (this.c == null) {
            Context applicationContext = context.getApplicationContext();
            this.f838a.a(applicationContext);
            this.f838a.registerListener(this.d, ActivityEvent.RESUMED, ActivityEvent.PAUSED);
            this.c = applicationContext;
        }
    }

    public C0194d6(C0445n c0445n, IReporter iReporter) {
        this.f838a = c0445n;
        this.b = iReporter;
        this.d = new C0168c6(this);
    }

    public /* synthetic */ C0194d6(C0445n c0445n, int i) {
        this(c0445n, AbstractC0648v1.a());
    }

    public final synchronized Context a() {
        return this.c;
    }
}
