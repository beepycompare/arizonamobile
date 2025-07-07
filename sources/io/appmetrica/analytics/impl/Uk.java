package io.appmetrica.analytics.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* loaded from: classes4.dex */
public final class Uk {

    /* renamed from: a  reason: collision with root package name */
    public final C0450n f662a;
    public final F5 b;
    public final ActivityLifecycleListener c;
    public final ActivityLifecycleListener d;
    public final C0500p e;
    public final C0400l f;
    public boolean g;

    public Uk(C0450n c0450n, C0400l c0400l) {
        this(c0450n, c0400l, new F5(), new C0500p());
    }

    public final void a(final Activity activity, ActivityEvent activityEvent) {
        synchronized (this) {
            if (this.g) {
                F5 f5 = this.b;
                InterfaceC0465ne interfaceC0465ne = new InterfaceC0465ne() { // from class: io.appmetrica.analytics.impl.Uk$$ExternalSyntheticLambda1
                    @Override // io.appmetrica.analytics.impl.InterfaceC0465ne
                    public final void consume(Object obj) {
                        Uk.this.a(activity, (Ac) obj);
                    }
                };
                f5.getClass();
                C0704x4.l().c.a().execute(new E5(f5, interfaceC0465ne));
            }
        }
    }

    public final void b(final Activity activity, ActivityEvent activityEvent) {
        synchronized (this) {
            if (this.g) {
                F5 f5 = this.b;
                InterfaceC0465ne interfaceC0465ne = new InterfaceC0465ne() { // from class: io.appmetrica.analytics.impl.Uk$$ExternalSyntheticLambda0
                    @Override // io.appmetrica.analytics.impl.InterfaceC0465ne
                    public final void consume(Object obj) {
                        Uk.this.b(activity, (Ac) obj);
                    }
                };
                f5.getClass();
                C0704x4.l().c.a().execute(new E5(f5, interfaceC0465ne));
            }
        }
    }

    public Uk(C0450n c0450n, C0400l c0400l, F5 f5, C0500p c0500p) {
        this.g = false;
        this.f662a = c0450n;
        this.f = c0400l;
        this.b = f5;
        this.e = c0500p;
        this.c = new ActivityLifecycleListener() { // from class: io.appmetrica.analytics.impl.Uk$$ExternalSyntheticLambda2
            @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
            public final void onEvent(Activity activity, ActivityEvent activityEvent) {
                Uk.this.a(activity, activityEvent);
            }
        };
        this.d = new ActivityLifecycleListener() { // from class: io.appmetrica.analytics.impl.Uk$$ExternalSyntheticLambda3
            @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
            public final void onEvent(Activity activity, ActivityEvent activityEvent) {
                Uk.this.b(activity, activityEvent);
            }
        };
    }

    public final void b(Activity activity, Ac ac) {
        if (this.e.a(activity, EnumC0475o.PAUSED)) {
            ac.b(activity);
        }
    }

    public final synchronized EnumC0425m a() {
        if (!this.g) {
            this.f662a.registerListener(this.c, ActivityEvent.RESUMED);
            this.f662a.registerListener(this.d, ActivityEvent.PAUSED);
            this.g = true;
        }
        return this.f662a.b;
    }

    public final void a(Activity activity, Ac ac) {
        if (this.e.a(activity, EnumC0475o.RESUMED)) {
            ac.a(activity);
        }
    }
}
