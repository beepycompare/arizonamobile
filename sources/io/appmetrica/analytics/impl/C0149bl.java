package io.appmetrica.analytics.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* renamed from: io.appmetrica.analytics.impl.bl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0149bl {

    /* renamed from: a  reason: collision with root package name */
    public final C0460o f819a;
    public final C0590t5 b;
    public final ActivityLifecycleListener c;
    public final ActivityLifecycleListener d;
    public final C0510q e;
    public final C0410m f;
    public boolean g;

    public C0149bl(C0460o c0460o, C0410m c0410m) {
        this(c0460o, c0410m, new C0590t5(), new C0510q());
    }

    public final void a(final Activity activity, ActivityEvent activityEvent) {
        synchronized (this) {
            if (this.g) {
                C0590t5 c0590t5 = this.b;
                InterfaceC0297he interfaceC0297he = new InterfaceC0297he() { // from class: io.appmetrica.analytics.impl.bl$$ExternalSyntheticLambda0
                    @Override // io.appmetrica.analytics.impl.InterfaceC0297he
                    public final void consume(Object obj) {
                        C0149bl.this.a(activity, (C0473oc) obj);
                    }
                };
                c0590t5.getClass();
                C0338j4.l().c.a().execute(new RunnableC0565s5(c0590t5, interfaceC0297he));
            }
        }
    }

    public final void b(final Activity activity, ActivityEvent activityEvent) {
        synchronized (this) {
            if (this.g) {
                C0590t5 c0590t5 = this.b;
                InterfaceC0297he interfaceC0297he = new InterfaceC0297he() { // from class: io.appmetrica.analytics.impl.bl$$ExternalSyntheticLambda1
                    @Override // io.appmetrica.analytics.impl.InterfaceC0297he
                    public final void consume(Object obj) {
                        C0149bl.this.b(activity, (C0473oc) obj);
                    }
                };
                c0590t5.getClass();
                C0338j4.l().c.a().execute(new RunnableC0565s5(c0590t5, interfaceC0297he));
            }
        }
    }

    public C0149bl(C0460o c0460o, C0410m c0410m, C0590t5 c0590t5, C0510q c0510q) {
        this.g = false;
        this.f819a = c0460o;
        this.f = c0410m;
        this.b = c0590t5;
        this.e = c0510q;
        this.c = new ActivityLifecycleListener() { // from class: io.appmetrica.analytics.impl.bl$$ExternalSyntheticLambda2
            @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
            public final void onEvent(Activity activity, ActivityEvent activityEvent) {
                C0149bl.this.a(activity, activityEvent);
            }
        };
        this.d = new ActivityLifecycleListener() { // from class: io.appmetrica.analytics.impl.bl$$ExternalSyntheticLambda3
            @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
            public final void onEvent(Activity activity, ActivityEvent activityEvent) {
                C0149bl.this.b(activity, activityEvent);
            }
        };
    }

    public final void b(Activity activity, C0473oc c0473oc) {
        if (this.e.a(activity, EnumC0485p.PAUSED)) {
            c0473oc.b(activity);
        }
    }

    public final synchronized EnumC0435n a() {
        if (!this.g) {
            this.f819a.registerListener(this.c, ActivityEvent.RESUMED);
            this.f819a.registerListener(this.d, ActivityEvent.PAUSED);
            this.g = true;
        }
        return this.f819a.b;
    }

    public final void a(Activity activity, C0473oc c0473oc) {
        if (this.e.a(activity, EnumC0485p.RESUMED)) {
            c0473oc.a(activity);
        }
    }
}
