package io.appmetrica.analytics.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
/* renamed from: io.appmetrica.analytics.impl.gl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0285gl {

    /* renamed from: a  reason: collision with root package name */
    public final C0444n f901a;
    public final K5 b;
    public final ActivityLifecycleListener c;
    public final ActivityLifecycleListener d;
    public final C0496p e;
    public final C0392l f;
    public boolean g;

    public C0285gl(C0444n c0444n, C0392l c0392l) {
        this(c0444n, c0392l, new K5(), new C0496p());
    }

    public final void a(final Activity activity, ActivityEvent activityEvent) {
        synchronized (this) {
            if (this.g) {
                K5 k5 = this.b;
                InterfaceC0660ve interfaceC0660ve = new InterfaceC0660ve() { // from class: io.appmetrica.analytics.impl.gl$$ExternalSyntheticLambda3
                    @Override // io.appmetrica.analytics.impl.InterfaceC0660ve
                    public final void consume(Object obj) {
                        C0285gl.this.a(activity, (Hc) obj);
                    }
                };
                k5.getClass();
                A4.l().c.a().execute(new J5(k5, interfaceC0660ve));
            }
        }
    }

    public final void b(final Activity activity, ActivityEvent activityEvent) {
        synchronized (this) {
            if (this.g) {
                K5 k5 = this.b;
                InterfaceC0660ve interfaceC0660ve = new InterfaceC0660ve() { // from class: io.appmetrica.analytics.impl.gl$$ExternalSyntheticLambda0
                    @Override // io.appmetrica.analytics.impl.InterfaceC0660ve
                    public final void consume(Object obj) {
                        C0285gl.this.b(activity, (Hc) obj);
                    }
                };
                k5.getClass();
                A4.l().c.a().execute(new J5(k5, interfaceC0660ve));
            }
        }
    }

    public C0285gl(C0444n c0444n, C0392l c0392l, K5 k5, C0496p c0496p) {
        this.g = false;
        this.f901a = c0444n;
        this.f = c0392l;
        this.b = k5;
        this.e = c0496p;
        this.c = new ActivityLifecycleListener() { // from class: io.appmetrica.analytics.impl.gl$$ExternalSyntheticLambda1
            @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
            public final void onEvent(Activity activity, ActivityEvent activityEvent) {
                C0285gl.this.a(activity, activityEvent);
            }
        };
        this.d = new ActivityLifecycleListener() { // from class: io.appmetrica.analytics.impl.gl$$ExternalSyntheticLambda2
            @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
            public final void onEvent(Activity activity, ActivityEvent activityEvent) {
                C0285gl.this.b(activity, activityEvent);
            }
        };
    }

    public final void b(Activity activity, Hc hc) {
        if (this.e.a(activity, EnumC0470o.PAUSED)) {
            hc.b(activity);
        }
    }

    public final synchronized EnumC0418m a() {
        if (!this.g) {
            this.f901a.registerListener(this.c, ActivityEvent.RESUMED);
            this.f901a.registerListener(this.d, ActivityEvent.PAUSED);
            this.g = true;
        }
        return this.f901a.b;
    }

    public final void a(Activity activity, Hc hc) {
        if (this.e.a(activity, EnumC0470o.RESUMED)) {
            hc.a(activity);
        }
    }
}
