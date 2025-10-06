package io.appmetrica.analytics.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* renamed from: io.appmetrica.analytics.impl.gl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0286gl {

    /* renamed from: a  reason: collision with root package name */
    public final C0445n f901a;
    public final K5 b;
    public final ActivityLifecycleListener c;
    public final ActivityLifecycleListener d;
    public final C0497p e;
    public final C0393l f;
    public boolean g;

    public C0286gl(C0445n c0445n, C0393l c0393l) {
        this(c0445n, c0393l, new K5(), new C0497p());
    }

    public final void a(final Activity activity, ActivityEvent activityEvent) {
        synchronized (this) {
            if (this.g) {
                K5 k5 = this.b;
                InterfaceC0661ve interfaceC0661ve = new InterfaceC0661ve() { // from class: io.appmetrica.analytics.impl.gl$$ExternalSyntheticLambda3
                    @Override // io.appmetrica.analytics.impl.InterfaceC0661ve
                    public final void consume(Object obj) {
                        C0286gl.this.a(activity, (Hc) obj);
                    }
                };
                k5.getClass();
                A4.l().c.a().execute(new J5(k5, interfaceC0661ve));
            }
        }
    }

    public final void b(final Activity activity, ActivityEvent activityEvent) {
        synchronized (this) {
            if (this.g) {
                K5 k5 = this.b;
                InterfaceC0661ve interfaceC0661ve = new InterfaceC0661ve() { // from class: io.appmetrica.analytics.impl.gl$$ExternalSyntheticLambda0
                    @Override // io.appmetrica.analytics.impl.InterfaceC0661ve
                    public final void consume(Object obj) {
                        C0286gl.this.b(activity, (Hc) obj);
                    }
                };
                k5.getClass();
                A4.l().c.a().execute(new J5(k5, interfaceC0661ve));
            }
        }
    }

    public C0286gl(C0445n c0445n, C0393l c0393l, K5 k5, C0497p c0497p) {
        this.g = false;
        this.f901a = c0445n;
        this.f = c0393l;
        this.b = k5;
        this.e = c0497p;
        this.c = new ActivityLifecycleListener() { // from class: io.appmetrica.analytics.impl.gl$$ExternalSyntheticLambda1
            @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
            public final void onEvent(Activity activity, ActivityEvent activityEvent) {
                C0286gl.this.a(activity, activityEvent);
            }
        };
        this.d = new ActivityLifecycleListener() { // from class: io.appmetrica.analytics.impl.gl$$ExternalSyntheticLambda2
            @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
            public final void onEvent(Activity activity, ActivityEvent activityEvent) {
                C0286gl.this.b(activity, activityEvent);
            }
        };
    }

    public final void b(Activity activity, Hc hc) {
        if (this.e.a(activity, EnumC0471o.PAUSED)) {
            hc.b(activity);
        }
    }

    public final synchronized EnumC0419m a() {
        if (!this.g) {
            this.f901a.registerListener(this.c, ActivityEvent.RESUMED);
            this.f901a.registerListener(this.d, ActivityEvent.PAUSED);
            this.g = true;
        }
        return this.f901a.b;
    }

    public final void a(Activity activity, Hc hc) {
        if (this.e.a(activity, EnumC0471o.RESUMED)) {
            hc.a(activity);
        }
    }
}
