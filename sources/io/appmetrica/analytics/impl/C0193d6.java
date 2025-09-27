package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.IReporter;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
/* renamed from: io.appmetrica.analytics.impl.d6  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0193d6 {

    /* renamed from: a  reason: collision with root package name */
    public final C0444n f838a;
    public final IReporter b;
    public Context c;
    public final C0167c6 d;

    public C0193d6(C0444n c0444n) {
        this(c0444n, 0);
    }

    public final synchronized void a(Context context) {
        if (this.c == null) {
            Context applicationContext = context.getApplicationContext();
            this.f838a.a(applicationContext);
            this.f838a.registerListener(this.d, ActivityEvent.RESUMED, ActivityEvent.PAUSED);
            this.c = applicationContext;
        }
    }

    public C0193d6(C0444n c0444n, IReporter iReporter) {
        this.f838a = c0444n;
        this.b = iReporter;
        this.d = new C0167c6(this);
    }

    public /* synthetic */ C0193d6(C0444n c0444n, int i) {
        this(c0444n, AbstractC0647v1.a());
    }

    public final synchronized Context a() {
        return this.c;
    }
}
