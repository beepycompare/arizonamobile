package io.appmetrica.analytics.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* loaded from: classes4.dex */
public final class Uk {

    /* renamed from: a  reason: collision with root package name */
    public final C0442n f663a;
    public final F5 b;
    public final ActivityLifecycleListener c;
    public final ActivityLifecycleListener d;
    public final C0492p e;
    public final C0392l f;
    public boolean g;

    public Uk(C0442n c0442n, C0392l c0392l) {
        this(c0442n, c0392l, new F5(), new C0492p());
    }

    public final void a(final Activity activity, ActivityEvent activityEvent) {
        synchronized (this) {
            if (this.g) {
                F5 f5 = this.b;
                InterfaceC0457ne interfaceC0457ne = new InterfaceC0457ne() { // from class: io.appmetrica.analytics.impl.Uk$$ExternalSyntheticLambda1
                    @Override // io.appmetrica.analytics.impl.InterfaceC0457ne
                    public final void consume(Object obj) {
                        Uk.this.a(activity, (Ac) obj);
                    }
                };
                f5.getClass();
                C0696x4.l().c.a().execute(new E5(f5, interfaceC0457ne));
            }
        }
    }

    public final void b(final Activity activity, ActivityEvent activityEvent) {
        synchronized (this) {
            if (this.g) {
                F5 f5 = this.b;
                InterfaceC0457ne interfaceC0457ne = new InterfaceC0457ne() { // from class: io.appmetrica.analytics.impl.Uk$$ExternalSyntheticLambda0
                    @Override // io.appmetrica.analytics.impl.InterfaceC0457ne
                    public final void consume(Object obj) {
                        Uk.this.b(activity, (Ac) obj);
                    }
                };
                f5.getClass();
                C0696x4.l().c.a().execute(new E5(f5, interfaceC0457ne));
            }
        }
    }

    public Uk(C0442n c0442n, C0392l c0392l, F5 f5, C0492p c0492p) {
        this.g = false;
        this.f663a = c0442n;
        this.f = c0392l;
        this.b = f5;
        this.e = c0492p;
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
        if (this.e.a(activity, EnumC0467o.PAUSED)) {
            ac.b(activity);
        }
    }

    public final synchronized EnumC0417m a() {
        if (!this.g) {
            this.f663a.registerListener(this.c, ActivityEvent.RESUMED);
            this.f663a.registerListener(this.d, ActivityEvent.PAUSED);
            this.g = true;
        }
        return this.f663a.b;
    }

    public final void a(Activity activity, Ac ac) {
        if (this.e.a(activity, EnumC0467o.RESUMED)) {
            ac.a(activity);
        }
    }
}
