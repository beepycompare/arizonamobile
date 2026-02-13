package io.appmetrica.analytics.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* loaded from: classes5.dex */
public final class Wk {

    /* renamed from: a  reason: collision with root package name */
    public final C0463o f842a;
    public final C0419m5 b;
    public final ActivityLifecycleListener c;
    public final ActivityLifecycleListener d;
    public final C0513q e;
    public final C0413m f;
    public boolean g;

    public Wk(C0463o c0463o, C0413m c0413m) {
        this(c0463o, c0413m, new C0419m5(), new C0513q());
    }

    public final void a(final Activity activity, ActivityEvent activityEvent) {
        synchronized (this) {
            C0419m5 c0419m5 = this.b;
            InterfaceC0120ae interfaceC0120ae = new InterfaceC0120ae() { // from class: io.appmetrica.analytics.impl.Wk$$ExternalSyntheticLambda2
                @Override // io.appmetrica.analytics.impl.InterfaceC0120ae
                public final void consume(Object obj) {
                    Wk.this.a(activity, (C0299hc) obj);
                }
            };
            c0419m5.getClass();
            C0136b4.l().c.a().execute(new RunnableC0394l5(c0419m5, interfaceC0120ae));
        }
    }

    public final void b(final Activity activity, ActivityEvent activityEvent) {
        synchronized (this) {
            C0419m5 c0419m5 = this.b;
            InterfaceC0120ae interfaceC0120ae = new InterfaceC0120ae() { // from class: io.appmetrica.analytics.impl.Wk$$ExternalSyntheticLambda3
                @Override // io.appmetrica.analytics.impl.InterfaceC0120ae
                public final void consume(Object obj) {
                    Wk.this.b(activity, (C0299hc) obj);
                }
            };
            c0419m5.getClass();
            C0136b4.l().c.a().execute(new RunnableC0394l5(c0419m5, interfaceC0120ae));
        }
    }

    public Wk(C0463o c0463o, C0413m c0413m, C0419m5 c0419m5, C0513q c0513q) {
        this.g = false;
        this.f842a = c0463o;
        this.f = c0413m;
        this.b = c0419m5;
        this.e = c0513q;
        this.c = new ActivityLifecycleListener() { // from class: io.appmetrica.analytics.impl.Wk$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
            public final void onEvent(Activity activity, ActivityEvent activityEvent) {
                Wk.this.a(activity, activityEvent);
            }
        };
        this.d = new ActivityLifecycleListener() { // from class: io.appmetrica.analytics.impl.Wk$$ExternalSyntheticLambda1
            @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
            public final void onEvent(Activity activity, ActivityEvent activityEvent) {
                Wk.this.b(activity, activityEvent);
            }
        };
    }

    public final void b(Activity activity, C0299hc c0299hc) {
        if (this.g && this.e.a(activity, EnumC0488p.PAUSED)) {
            c0299hc.b(activity);
        }
    }

    public final void a(Activity activity, C0299hc c0299hc) {
        if (this.g && this.e.a(activity, EnumC0488p.RESUMED)) {
            c0299hc.a(activity);
        }
    }

    public final synchronized EnumC0438n a() {
        if (!this.g) {
            this.f842a.registerListener(this.c, ActivityEvent.RESUMED);
            this.f842a.registerListener(this.d, ActivityEvent.PAUSED);
            this.g = true;
        }
        return this.f842a.b;
    }
}
