package io.appmetrica.analytics.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* loaded from: classes5.dex */
public final class Bl {

    /* renamed from: a  reason: collision with root package name */
    public final C0468o f480a;
    public final C5 b;
    public final ActivityLifecycleListener c;
    public final ActivityLifecycleListener d;
    public final C0520q e;
    public final C0416m f;
    public boolean g;

    public Bl(C0468o c0468o, C0416m c0416m) {
        this(c0468o, c0416m, new C5(), new C0520q());
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
            C0576s4.l().c.a().execute(new B5(c5, be));
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
            C0576s4.l().c.a().execute(new B5(c5, be));
        }
    }

    public Bl(C0468o c0468o, C0416m c0416m, C5 c5, C0520q c0520q) {
        this.g = false;
        this.f480a = c0468o;
        this.f = c0416m;
        this.b = c5;
        this.e = c0520q;
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
        if (this.g && this.e.a(activity, EnumC0494p.PAUSED)) {
            jc.b(activity);
        }
    }

    public final void a(Activity activity, Jc jc) {
        if (this.g && this.e.a(activity, EnumC0494p.RESUMED)) {
            jc.a(activity);
        }
    }

    public final synchronized EnumC0442n a() {
        if (!this.g) {
            this.f480a.registerListener(this.c, ActivityEvent.RESUMED);
            this.f480a.registerListener(this.d, ActivityEvent.PAUSED);
            this.g = true;
        }
        return this.f480a.b;
    }
}
