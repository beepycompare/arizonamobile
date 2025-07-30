package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleRegistry;
import java.util.ArrayList;
import java.util.Collection;
/* renamed from: io.appmetrica.analytics.impl.n  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0444n extends V7 implements ActivityLifecycleRegistry {

    /* renamed from: a  reason: collision with root package name */
    public Application f961a;
    public volatile EnumC0419m b = EnumC0419m.d;
    public final Ka c = new Ka(true);

    public final synchronized void a(Context context) {
        if (this.f961a == null) {
            try {
                this.f961a = (Application) context.getApplicationContext();
            } catch (Throwable unused) {
            }
        }
        b();
    }

    public final synchronized void b() {
        EnumC0419m enumC0419m = this.b;
        EnumC0419m enumC0419m2 = EnumC0419m.b;
        if (enumC0419m != enumC0419m2 && !this.c.f520a.isEmpty()) {
            if (this.f961a == null) {
                this.b = EnumC0419m.c;
                return;
            }
            this.b = enumC0419m2;
            this.f961a.registerActivityLifecycleCallbacks(this);
        }
    }

    public final synchronized void c() {
        if (this.b == EnumC0419m.b && this.c.f520a.isEmpty()) {
            this.b = EnumC0419m.d;
            Application application = this.f961a;
            if (application != null) {
                application.unregisterActivityLifecycleCallbacks(this);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        a(activity, ActivityEvent.CREATED);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        a(activity, ActivityEvent.DESTROYED);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(activity, ActivityEvent.PAUSED);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        a(activity, ActivityEvent.RESUMED);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a(activity, ActivityEvent.STARTED);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        a(activity, ActivityEvent.STOPPED);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0004, code lost:
        if (r6.length == 0) goto L3;
     */
    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleRegistry
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void registerListener(ActivityLifecycleListener activityLifecycleListener, ActivityEvent... activityEventArr) {
        if (activityEventArr != null) {
        }
        activityEventArr = ActivityEvent.values();
        for (ActivityEvent activityEvent : activityEventArr) {
            this.c.a(activityEvent, activityLifecycleListener);
        }
        b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0004, code lost:
        if (r8.length == 0) goto L3;
     */
    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleRegistry
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void unregisterListener(ActivityLifecycleListener activityLifecycleListener, ActivityEvent... activityEventArr) {
        if (activityEventArr != null) {
        }
        activityEventArr = ActivityEvent.values();
        for (ActivityEvent activityEvent : activityEventArr) {
            Ka ka = this.c;
            Collection collection = (Collection) ka.f520a.get(activityEvent);
            if (collection != null && collection.remove(activityLifecycleListener)) {
                if (collection.isEmpty() && ka.b) {
                    ka.f520a.remove(activityEvent);
                }
                new ArrayList(collection);
            }
        }
        c();
    }

    public final synchronized void a(Application application) {
        if (this.f961a == null) {
            this.f961a = application;
        }
        b();
    }

    public final EnumC0419m a() {
        return this.b;
    }

    public final void a(Activity activity, ActivityEvent activityEvent) {
        Collection<ActivityLifecycleListener> collection;
        synchronized (this) {
            collection = (Collection) this.c.f520a.get(activityEvent);
        }
        if (collection != null) {
            for (ActivityLifecycleListener activityLifecycleListener : collection) {
                activityLifecycleListener.onEvent(activity, activityEvent);
            }
        }
    }
}
