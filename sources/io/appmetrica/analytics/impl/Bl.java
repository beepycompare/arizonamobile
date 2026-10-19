package io.appmetrica.analytics.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* loaded from: classes5.dex */
public final class Bl {

    /* renamed from: a  reason: collision with root package name */
    public final C0461o f486a;
    public final C5 b;
    public final ActivityLifecycleListener c;
    public final ActivityLifecycleListener d;
    public final C0513q e;
    public final C0409m f;
    public boolean g;

    public Bl(C0461o c0461o, C0409m c0409m) {
        this(c0461o, c0409m, new C5(), new C0513q());
    }

    public final void a(final Activity activity, ActivityEvent activityEvent) {
        synchronized (this) {
            C5 c5 = this.b;
            Be be = new Be() { // from class: io.appmetrica.analytics.impl.Bl$$ExternalSyntheticLambda2
                @Override // io.appmetrica.analytics.impl.Be
                public final void consume(Object obj) {
                    Bl.this.a(activity, (Jc) obj);
                }
            };
            c5.getClass();
            C0569s4.l().c.a().execute(new B5(c5, be));
        }
    }

    public final void b(final Activity activity, ActivityEvent activityEvent) {
        synchronized (this) {
            C5 c5 = this.b;
            Be be = new Be() { // from class: io.appmetrica.analytics.impl.Bl$$ExternalSyntheticLambda3
                @Override // io.appmetrica.analytics.impl.Be
                public final void consume(Object obj) {
                    Bl.this.b(activity, (Jc) obj);
                }
            };
            c5.getClass();
            C0569s4.l().c.a().execute(new B5(c5, be));
        }
    }

    public Bl(C0461o c0461o, C0409m c0409m, C5 c5, C0513q c0513q) {
        this.g = false;
        this.f486a = c0461o;
        this.f = c0409m;
        this.b = c5;
        this.e = c0513q;
        this.c = new ActivityLifecycleListener() { // from class: io.appmetrica.analytics.impl.Bl$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
            public final void onEvent(Activity activity, ActivityEvent activityEvent) {
                Bl.this.a(activity, activityEvent);
            }
        };
        this.d = new ActivityLifecycleListener() { // from class: io.appmetrica.analytics.impl.Bl$$ExternalSyntheticLambda1
            @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
            public final void onEvent(Activity activity, ActivityEvent activityEvent) {
                Bl.this.b(activity, activityEvent);
            }
        };
    }

    public final void b(Activity activity, Jc jc) {
        if (this.g && this.e.a(activity, EnumC0487p.PAUSED)) {
            jc.b(activity);
        }
    }

    public final void a(Activity activity, Jc jc) {
        if (this.g && this.e.a(activity, EnumC0487p.RESUMED)) {
            jc.a(activity);
        }
    }

    public final synchronized EnumC0435n a() {
        if (!this.g) {
            this.f486a.registerListener(this.c, ActivityEvent.RESUMED);
            this.f486a.registerListener(this.d, ActivityEvent.PAUSED);
            this.g = true;
        }
        return this.f486a.b;
    }
}
