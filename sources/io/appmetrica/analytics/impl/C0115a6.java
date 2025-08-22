package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.IReporter;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
/* renamed from: io.appmetrica.analytics.impl.a6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0115a6 {

    /* renamed from: a  reason: collision with root package name */
    public final C0442n f771a;
    public final IReporter b;
    public Context c;
    public final Z5 d;

    public C0115a6(C0442n c0442n) {
        this(c0442n, 0);
    }

    public final synchronized void a(Context context) {
        if (this.c == null) {
            Context applicationContext = context.getApplicationContext();
            this.f771a.a(applicationContext);
            this.f771a.registerListener(this.d, ActivityEvent.RESUMED, ActivityEvent.PAUSED);
            this.c = applicationContext;
        }
    }

    public C0115a6(C0442n c0442n, IReporter iReporter) {
        this.f771a = c0442n;
        this.b = iReporter;
        this.d = new Z5(this);
    }

    public /* synthetic */ C0115a6(C0442n c0442n, int i) {
        this(c0442n, AbstractC0593t1.a());
    }

    public final synchronized Context a() {
        return this.c;
    }
}
