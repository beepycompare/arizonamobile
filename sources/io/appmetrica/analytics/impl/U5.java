package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.IReporter;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
/* loaded from: classes5.dex */
public final class U5 {

    /* renamed from: a  reason: collision with root package name */
    public final C0468o f785a;
    public final IReporter b;
    public Context c;
    public final T5 d;

    public U5(C0468o c0468o) {
        this(c0468o, 0);
    }

    public final synchronized void a(Context context) {
        if (this.c == null) {
            Context applicationContext = context.getApplicationContext();
            this.f785a.a(applicationContext);
            this.f785a.registerListener(this.d, ActivityEvent.RESUMED, ActivityEvent.PAUSED);
            this.c = applicationContext;
        }
    }

    public U5(C0468o c0468o, IReporter iReporter) {
        this.f785a = c0468o;
        this.b = iReporter;
        this.d = new T5(this);
    }

    public /* synthetic */ U5(C0468o c0468o, int i) {
        this(c0468o, AbstractC0755z1.a());
    }

    public final synchronized Context a() {
        return this.c;
    }
}
