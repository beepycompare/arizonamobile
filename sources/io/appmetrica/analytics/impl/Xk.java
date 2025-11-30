package io.appmetrica.analytics.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* loaded from: classes5.dex */
public final class Xk {

    /* renamed from: a  reason: collision with root package name */
    public final C0460o f753a;
    public final C0441n5 b;
    public final ActivityLifecycleListener c;
    public final ActivityLifecycleListener d;
    public final C0510q e;
    public final C0410m f;
    public boolean g;

    public Xk(C0460o c0460o, C0410m c0410m) {
        this(c0460o, c0410m, new C0441n5(), new C0510q());
    }

    public final void a(final Activity activity, ActivityEvent activityEvent) {
        synchronized (this) {
            C0441n5 c0441n5 = this.b;
            InterfaceC0142be interfaceC0142be = new InterfaceC0142be() { // from class: io.appmetrica.analytics.impl.Xk$$ExternalSyntheticLambda3
                @Override // io.appmetrica.analytics.impl.InterfaceC0142be
                public final void consume(Object obj) {
                    Xk.this.a(activity, (C0321ic) obj);
                }
            };
            c0441n5.getClass();
            C0158c4.l().c.a().execute(new RunnableC0416m5(c0441n5, interfaceC0142be));
        }
    }

    public final void b(final Activity activity, ActivityEvent activityEvent) {
        synchronized (this) {
            C0441n5 c0441n5 = this.b;
            InterfaceC0142be interfaceC0142be = new InterfaceC0142be() { // from class: io.appmetrica.analytics.impl.Xk$$ExternalSyntheticLambda0
                @Override // io.appmetrica.analytics.impl.InterfaceC0142be
                public final void consume(Object obj) {
                    Xk.this.b(activity, (C0321ic) obj);
                }
            };
            c0441n5.getClass();
            C0158c4.l().c.a().execute(new RunnableC0416m5(c0441n5, interfaceC0142be));
        }
    }

    public Xk(C0460o c0460o, C0410m c0410m, C0441n5 c0441n5, C0510q c0510q) {
        this.g = false;
        this.f753a = c0460o;
        this.f = c0410m;
        this.b = c0441n5;
        this.e = c0510q;
        this.c = new ActivityLifecycleListener() { // from class: io.appmetrica.analytics.impl.Xk$$ExternalSyntheticLambda1
            @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
            public final void onEvent(Activity activity, ActivityEvent activityEvent) {
                Xk.this.a(activity, activityEvent);
            }
        };
        this.d = new ActivityLifecycleListener() { // from class: io.appmetrica.analytics.impl.Xk$$ExternalSyntheticLambda2
            @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
            public final void onEvent(Activity activity, ActivityEvent activityEvent) {
                Xk.this.b(activity, activityEvent);
            }
        };
    }

    public final void b(Activity activity, C0321ic c0321ic) {
        if (this.g && this.e.a(activity, EnumC0485p.PAUSED)) {
            c0321ic.b(activity);
        }
    }

    public final void a(Activity activity, C0321ic c0321ic) {
        if (this.g && this.e.a(activity, EnumC0485p.RESUMED)) {
            c0321ic.a(activity);
        }
    }

    public final synchronized EnumC0435n a() {
        if (!this.g) {
            this.f753a.registerListener(this.c, ActivityEvent.RESUMED);
            this.f753a.registerListener(this.d, ActivityEvent.PAUSED);
            this.g = true;
        }
        return this.f753a.b;
    }
}
