package io.appmetrica.analytics.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* loaded from: classes5.dex */
public final class Bl {

    /* renamed from: a  reason: collision with root package name */
    public final C0466o f483a;
    public final C5 b;
    public final ActivityLifecycleListener c;
    public final ActivityLifecycleListener d;
    public final C0518q e;
    public final C0414m f;
    public boolean g;

    public Bl(C0466o c0466o, C0414m c0414m) {
        this(c0466o, c0414m, new C5(), new C0518q());
    }

    public final void a(final Activity activity, ActivityEvent activityEvent) {
        synchronized (this) {
            C5 c5 = this.b;
            Be be = new Be() { // from class: io.appmetrica.analytics.impl.Bl$$ExternalSyntheticLambda2
                @Override // io.appmetrica.analytics.impl.Be
                public final void consume(Object obj) {
                    Bl.this.a(activity, (Jc) obj);
                }
            };
            c5.getClass();
            C0574s4.l().c.a().execute(new B5(c5, be));
        }
    }

    public final void b(final Activity activity, ActivityEvent activityEvent) {
        synchronized (this) {
            C5 c5 = this.b;
            Be be = new Be() { // from class: io.appmetrica.analytics.impl.Bl$$ExternalSyntheticLambda3
                @Override // io.appmetrica.analytics.impl.Be
                public final void consume(Object obj) {
                    Bl.this.b(activity, (Jc) obj);
                }
            };
            c5.getClass();
            C0574s4.l().c.a().execute(new B5(c5, be));
        }
    }

    public Bl(C0466o c0466o, C0414m c0414m, C5 c5, C0518q c0518q) {
        this.g = false;
        this.f483a = c0466o;
        this.f = c0414m;
        this.b = c5;
        this.e = c0518q;
        this.c = new ActivityLifecycleListener() { // from class: io.appmetrica.analytics.impl.Bl$$ExternalSyntheticLambda0
            @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
            public final void onEvent(Activity activity, ActivityEvent activityEvent) {
                Bl.this.a(activity, activityEvent);
            }
        };
        this.d = new ActivityLifecycleListener() { // from class: io.appmetrica.analytics.impl.Bl$$ExternalSyntheticLambda1
            @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
            public final void onEvent(Activity activity, ActivityEvent activityEvent) {
                Bl.this.b(activity, activityEvent);
            }
        };
    }

    public final void b(Activity activity, Jc jc) {
        if (this.g && this.e.a(activity, EnumC0492p.PAUSED)) {
            jc.b(activity);
        }
    }

    public final void a(Activity activity, Jc jc) {
        if (this.g && this.e.a(activity, EnumC0492p.RESUMED)) {
            jc.a(activity);
        }
    }

    public final synchronized EnumC0440n a() {
        if (!this.g) {
            this.f483a.registerListener(this.c, ActivityEvent.RESUMED);
            this.f483a.registerListener(this.d, ActivityEvent.PAUSED);
            this.g = true;
        }
        return this.f483a.b;
    }
}
