package io.appmetrica.analytics.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* loaded from: classes4.dex */
public final class Xk {

    /* renamed from: a  reason: collision with root package name */
    public final C0445n f722a;
    public final H5 b;
    public final ActivityLifecycleListener c;
    public final ActivityLifecycleListener d;
    public final C0495p e;
    public final C0395l f;
    public boolean g;

    public Xk(C0445n c0445n, C0395l c0395l) {
        this(c0445n, c0395l, new H5(), new C0495p());
    }

    public final void a(final Activity activity, ActivityEvent activityEvent) {
        synchronized (this) {
            if (this.g) {
                H5 h5 = this.b;
                InterfaceC0510pe interfaceC0510pe = new InterfaceC0510pe() { // from class: io.appmetrica.analytics.impl.Xk$$ExternalSyntheticLambda3
                    @Override // io.appmetrica.analytics.impl.InterfaceC0510pe
                    public final void consume(Object obj) {
                        Xk.this.a(activity, (Cc) obj);
                    }
                };
                h5.getClass();
                C0699x4.l().c.a().execute(new G5(h5, interfaceC0510pe));
            }
        }
    }

    public final void b(final Activity activity, ActivityEvent activityEvent) {
        synchronized (this) {
            if (this.g) {
                H5 h5 = this.b;
                InterfaceC0510pe interfaceC0510pe = new InterfaceC0510pe() { // from class: io.appmetrica.analytics.impl.Xk$$ExternalSyntheticLambda0
                    @Override // io.appmetrica.analytics.impl.InterfaceC0510pe
                    public final void consume(Object obj) {
                        Xk.this.b(activity, (Cc) obj);
                    }
                };
                h5.getClass();
                C0699x4.l().c.a().execute(new G5(h5, interfaceC0510pe));
            }
        }
    }

    public Xk(C0445n c0445n, C0395l c0395l, H5 h5, C0495p c0495p) {
        this.g = false;
        this.f722a = c0445n;
        this.f = c0395l;
        this.b = h5;
        this.e = c0495p;
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

    public final void b(Activity activity, Cc cc) {
        if (this.e.a(activity, EnumC0470o.PAUSED)) {
            cc.b(activity);
        }
    }

    public final synchronized EnumC0420m a() {
        if (!this.g) {
            this.f722a.registerListener(this.c, ActivityEvent.RESUMED);
            this.f722a.registerListener(this.d, ActivityEvent.PAUSED);
            this.g = true;
        }
        return this.f722a.b;
    }

    public final void a(Activity activity, Cc cc) {
        if (this.e.a(activity, EnumC0470o.RESUMED)) {
            cc.a(activity);
        }
    }
}
