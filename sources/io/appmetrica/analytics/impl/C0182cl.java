package io.appmetrica.analytics.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* renamed from: io.appmetrica.analytics.impl.cl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0182cl {

    /* renamed from: a  reason: collision with root package name */
    public final C0442n f816a;
    public final H5 b;
    public final ActivityLifecycleListener c;
    public final ActivityLifecycleListener d;
    public final C0492p e;
    public final C0392l f;
    public boolean g;

    public C0182cl(C0442n c0442n, C0392l c0392l) {
        this(c0442n, c0392l, new H5(), new C0492p());
    }

    public final void a(final Activity activity, ActivityEvent activityEvent) {
        synchronized (this) {
            if (this.g) {
                H5 h5 = this.b;
                InterfaceC0556re interfaceC0556re = new InterfaceC0556re() { // from class: io.appmetrica.analytics.impl.cl$$ExternalSyntheticLambda3
                    @Override // io.appmetrica.analytics.impl.InterfaceC0556re
                    public final void consume(Object obj) {
                        C0182cl.this.a(activity, (Ec) obj);
                    }
                };
                h5.getClass();
                C0696x4.l().c.a().execute(new G5(h5, interfaceC0556re));
            }
        }
    }

    public final void b(final Activity activity, ActivityEvent activityEvent) {
        synchronized (this) {
            if (this.g) {
                H5 h5 = this.b;
                InterfaceC0556re interfaceC0556re = new InterfaceC0556re() { // from class: io.appmetrica.analytics.impl.cl$$ExternalSyntheticLambda2
                    @Override // io.appmetrica.analytics.impl.InterfaceC0556re
                    public final void consume(Object obj) {
                        C0182cl.this.b(activity, (Ec) obj);
                    }
                };
                h5.getClass();
                C0696x4.l().c.a().execute(new G5(h5, interfaceC0556re));
            }
        }
    }

    public C0182cl(C0442n c0442n, C0392l c0392l, H5 h5, C0492p c0492p) {
        this.g = false;
        this.f816a = c0442n;
        this.f = c0392l;
        this.b = h5;
        this.e = c0492p;
        this.c = new ActivityLifecycleListener() { // from class: io.appmetrica.analytics.impl.cl$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
            public final void onEvent(Activity activity, ActivityEvent activityEvent) {
                C0182cl.this.a(activity, activityEvent);
            }
        };
        this.d = new ActivityLifecycleListener() { // from class: io.appmetrica.analytics.impl.cl$$ExternalSyntheticLambda1
            @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
            public final void onEvent(Activity activity, ActivityEvent activityEvent) {
                C0182cl.this.b(activity, activityEvent);
            }
        };
    }

    public final void b(Activity activity, Ec ec) {
        if (this.e.a(activity, EnumC0467o.PAUSED)) {
            ec.b(activity);
        }
    }

    public final synchronized EnumC0417m a() {
        if (!this.g) {
            this.f816a.registerListener(this.c, ActivityEvent.RESUMED);
            this.f816a.registerListener(this.d, ActivityEvent.PAUSED);
            this.g = true;
        }
        return this.f816a.b;
    }

    public final void a(Activity activity, Ec ec) {
        if (this.e.a(activity, EnumC0467o.RESUMED)) {
            ec.a(activity);
        }
    }
}
