package io.appmetrica.analytics.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* loaded from: classes5.dex */
public final class Wk {

    /* renamed from: a  reason: collision with root package name */
    public final C0462o f842a;
    public final C0418m5 b;
    public final ActivityLifecycleListener c;
    public final ActivityLifecycleListener d;
    public final C0512q e;
    public final C0412m f;
    public boolean g;

    public Wk(C0462o c0462o, C0412m c0412m) {
        this(c0462o, c0412m, new C0418m5(), new C0512q());
    }

    public final void a(final Activity activity, ActivityEvent activityEvent) {
        synchronized (this) {
            C0418m5 c0418m5 = this.b;
            InterfaceC0119ae interfaceC0119ae = new InterfaceC0119ae() { // from class: io.appmetrica.analytics.impl.Wk$$ExternalSyntheticLambda2
                @Override // io.appmetrica.analytics.impl.InterfaceC0119ae
                public final void consume(Object obj) {
                    Wk.this.a(activity, (C0298hc) obj);
                }
            };
            c0418m5.getClass();
            C0135b4.l().c.a().execute(new RunnableC0393l5(c0418m5, interfaceC0119ae));
        }
    }

    public final void b(final Activity activity, ActivityEvent activityEvent) {
        synchronized (this) {
            C0418m5 c0418m5 = this.b;
            InterfaceC0119ae interfaceC0119ae = new InterfaceC0119ae() { // from class: io.appmetrica.analytics.impl.Wk$$ExternalSyntheticLambda3
                @Override // io.appmetrica.analytics.impl.InterfaceC0119ae
                public final void consume(Object obj) {
                    Wk.this.b(activity, (C0298hc) obj);
                }
            };
            c0418m5.getClass();
            C0135b4.l().c.a().execute(new RunnableC0393l5(c0418m5, interfaceC0119ae));
        }
    }

    public Wk(C0462o c0462o, C0412m c0412m, C0418m5 c0418m5, C0512q c0512q) {
        this.g = false;
        this.f842a = c0462o;
        this.f = c0412m;
        this.b = c0418m5;
        this.e = c0512q;
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

    public final void b(Activity activity, C0298hc c0298hc) {
        if (this.g && this.e.a(activity, EnumC0487p.PAUSED)) {
            c0298hc.b(activity);
        }
    }

    public final void a(Activity activity, C0298hc c0298hc) {
        if (this.g && this.e.a(activity, EnumC0487p.RESUMED)) {
            c0298hc.a(activity);
        }
    }

    public final synchronized EnumC0437n a() {
        if (!this.g) {
            this.f842a.registerListener(this.c, ActivityEvent.RESUMED);
            this.f842a.registerListener(this.d, ActivityEvent.PAUSED);
            this.g = true;
        }
        return this.f842a.b;
    }
}
