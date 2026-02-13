package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.IReporter;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
/* loaded from: classes5.dex */
public final class E5 {

    /* renamed from: a  reason: collision with root package name */
    public final C0463o f561a;
    public final IReporter b;
    public Context c;
    public final D5 d;

    public E5(C0463o c0463o) {
        this(c0463o, 0);
    }

    public final synchronized void a(Context context) {
        if (this.c == null) {
            Context applicationContext = context.getApplicationContext();
            this.f561a.a(applicationContext);
            this.f561a.registerListener(this.d, ActivityEvent.RESUMED, ActivityEvent.PAUSED);
            this.c = applicationContext;
        }
    }

    public E5(C0463o c0463o, IReporter iReporter) {
        this.f561a = c0463o;
        this.b = iReporter;
        this.d = new D5(this);
    }

    public /* synthetic */ E5(C0463o c0463o, int i) {
        this(c0463o, AbstractC0689x1.a());
    }

    public final synchronized Context a() {
        return this.c;
    }
}
