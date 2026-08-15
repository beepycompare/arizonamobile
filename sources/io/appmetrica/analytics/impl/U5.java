package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.IReporter;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
/* loaded from: classes5.dex */
public final class U5 {

    /* renamed from: a  reason: collision with root package name */
    public final C0467o f788a;
    public final IReporter b;
    public Context c;
    public final T5 d;

    public U5(C0467o c0467o) {
        this(c0467o, 0);
    }

    public final synchronized void a(Context context) {
        if (this.c == null) {
            Context applicationContext = context.getApplicationContext();
            this.f788a.a(applicationContext);
            this.f788a.registerListener(this.d, ActivityEvent.RESUMED, ActivityEvent.PAUSED);
            this.c = applicationContext;
        }
    }

    public U5(C0467o c0467o, IReporter iReporter) {
        this.f788a = c0467o;
        this.b = iReporter;
        this.d = new T5(this);
    }

    public /* synthetic */ U5(C0467o c0467o, int i) {
        this(c0467o, AbstractC0754z1.a());
    }

    public final synchronized Context a() {
        return this.c;
    }
}
