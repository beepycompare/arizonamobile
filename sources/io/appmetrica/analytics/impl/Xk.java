package io.appmetrica.analytics.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* loaded from: classes5.dex */
public final class Xk {

    /* renamed from: a  reason: collision with root package name */
    public final C0459o f851a;
    public final C0440n5 b;
    public final ActivityLifecycleListener c;
    public final ActivityLifecycleListener d;
    public final C0509q e;
    public final C0409m f;
    public boolean g;

    public Xk(C0459o c0459o, C0409m c0409m) {
        this(c0459o, c0409m, new C0440n5(), new C0509q());
    }

    public final void a(final Activity activity, ActivityEvent activityEvent) {
        synchronized (this) {
            C0440n5 c0440n5 = this.b;
            InterfaceC0141be interfaceC0141be = new InterfaceC0141be() { // from class: io.appmetrica.analytics.impl.Xk$$ExternalSyntheticLambda3
                @Override // io.appmetrica.analytics.impl.InterfaceC0141be
                public final void consume(Object obj) {
                    Xk.this.a(activity, (C0320ic) obj);
                }
            };
            c0440n5.getClass();
            C0157c4.l().c.a().execute(new RunnableC0415m5(c0440n5, interfaceC0141be));
        }
    }

    public final void b(final Activity activity, ActivityEvent activityEvent) {
        synchronized (this) {
            C0440n5 c0440n5 = this.b;
            InterfaceC0141be interfaceC0141be = new InterfaceC0141be() { // from class: io.appmetrica.analytics.impl.Xk$$ExternalSyntheticLambda0
                @Override // io.appmetrica.analytics.impl.InterfaceC0141be
                public final void consume(Object obj) {
                    Xk.this.b(activity, (C0320ic) obj);
                }
            };
            c0440n5.getClass();
            C0157c4.l().c.a().execute(new RunnableC0415m5(c0440n5, interfaceC0141be));
        }
    }

    public Xk(C0459o c0459o, C0409m c0409m, C0440n5 c0440n5, C0509q c0509q) {
        this.g = false;
        this.f851a = c0459o;
        this.f = c0409m;
        this.b = c0440n5;
        this.e = c0509q;
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

    public final void b(Activity activity, C0320ic c0320ic) {
        if (this.g && this.e.a(activity, EnumC0484p.PAUSED)) {
            c0320ic.b(activity);
        }
    }

    public final void a(Activity activity, C0320ic c0320ic) {
        if (this.g && this.e.a(activity, EnumC0484p.RESUMED)) {
            c0320ic.a(activity);
        }
    }

    public final synchronized EnumC0434n a() {
        if (!this.g) {
            this.f851a.registerListener(this.c, ActivityEvent.RESUMED);
            this.f851a.registerListener(this.d, ActivityEvent.PAUSED);
            this.g = true;
        }
        return this.f851a.b;
    }
}
