package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.IReporter;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
/* loaded from: classes5.dex */
public final class E5 {

    /* renamed from: a  reason: collision with root package name */
    public final C0462o f566a;
    public final IReporter b;
    public Context c;
    public final D5 d;

    public E5(C0462o c0462o) {
        this(c0462o, 0);
    }

    public final synchronized void a(Context context) {
        if (this.c == null) {
            Context applicationContext = context.getApplicationContext();
            this.f566a.a(applicationContext);
            this.f566a.registerListener(this.d, ActivityEvent.RESUMED, ActivityEvent.PAUSED);
            this.c = applicationContext;
        }
    }

    public E5(C0462o c0462o, IReporter iReporter) {
        this.f566a = c0462o;
        this.b = iReporter;
        this.d = new D5(this);
    }

    public /* synthetic */ E5(C0462o c0462o, int i) {
        this(c0462o, AbstractC0688x1.a());
    }

    public final synchronized Context a() {
        return this.c;
    }
}
