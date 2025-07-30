package io.appmetrica.analytics.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* loaded from: classes4.dex */
public final class Xk {

    /* renamed from: a  reason: collision with root package name */
    public final C0444n f723a;
    public final H5 b;
    public final ActivityLifecycleListener c;
    public final ActivityLifecycleListener d;
    public final C0494p e;
    public final C0394l f;
    public boolean g;

    public Xk(C0444n c0444n, C0394l c0394l) {
        this(c0444n, c0394l, new H5(), new C0494p());
    }

    public final void a(final Activity activity, ActivityEvent activityEvent) {
        synchronized (this) {
            if (this.g) {
                H5 h5 = this.b;
                InterfaceC0509pe interfaceC0509pe = new InterfaceC0509pe() { // from class: io.appmetrica.analytics.impl.Xk$$ExternalSyntheticLambda3
                    @Override // io.appmetrica.analytics.impl.InterfaceC0509pe
                    public final void consume(Object obj) {
                        Xk.this.a(activity, (Cc) obj);
                    }
                };
                h5.getClass();
                C0698x4.l().c.a().execute(new G5(h5, interfaceC0509pe));
            }
        }
    }

    public final void b(final Activity activity, ActivityEvent activityEvent) {
        synchronized (this) {
            if (this.g) {
                H5 h5 = this.b;
                InterfaceC0509pe interfaceC0509pe = new InterfaceC0509pe() { // from class: io.appmetrica.analytics.impl.Xk$$ExternalSyntheticLambda0
                    @Override // io.appmetrica.analytics.impl.InterfaceC0509pe
                    public final void consume(Object obj) {
                        Xk.this.b(activity, (Cc) obj);
                    }
                };
                h5.getClass();
                C0698x4.l().c.a().execute(new G5(h5, interfaceC0509pe));
            }
        }
    }

    public Xk(C0444n c0444n, C0394l c0394l, H5 h5, C0494p c0494p) {
        this.g = false;
        this.f723a = c0444n;
        this.f = c0394l;
        this.b = h5;
        this.e = c0494p;
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
        if (this.e.a(activity, EnumC0469o.PAUSED)) {
            cc.b(activity);
        }
    }

    public final synchronized EnumC0419m a() {
        if (!this.g) {
            this.f723a.registerListener(this.c, ActivityEvent.RESUMED);
            this.f723a.registerListener(this.d, ActivityEvent.PAUSED);
            this.g = true;
        }
        return this.f723a.b;
    }

    public final void a(Activity activity, Cc cc) {
        if (this.e.a(activity, EnumC0469o.RESUMED)) {
            cc.a(activity);
        }
    }
}
