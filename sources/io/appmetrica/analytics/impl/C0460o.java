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
/* renamed from: io.appmetrica.analytics.impl.o  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0460o extends A7 implements ActivityLifecycleRegistry {

    /* renamed from: a  reason: collision with root package name */
    public Application f1038a;
    public volatile EnumC0435n b = EnumC0435n.d;
    public final C0521qa c = new C0521qa(true);

    public final synchronized void a(Context context) {
        if (this.f1038a == null) {
            try {
                this.f1038a = (Application) context.getApplicationContext();
            } catch (Throwable unused) {
            }
        }
        b();
    }

    public final synchronized void b() {
        EnumC0435n enumC0435n = this.b;
        EnumC0435n enumC0435n2 = EnumC0435n.b;
        if (enumC0435n != enumC0435n2 && !this.c.f1085a.isEmpty()) {
            if (this.f1038a == null) {
                this.b = EnumC0435n.c;
                return;
            }
            this.b = enumC0435n2;
            this.f1038a.registerActivityLifecycleCallbacks(this);
        }
    }

    public final synchronized void c() {
        if (this.b == EnumC0435n.b && this.c.f1085a.isEmpty()) {
            this.b = EnumC0435n.d;
            Application application = this.f1038a;
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
            C0521qa c0521qa = this.c;
            Collection collection = (Collection) c0521qa.f1085a.get(activityEvent);
            if (collection != null && collection.remove(activityLifecycleListener)) {
                if (collection.isEmpty() && c0521qa.b) {
                    c0521qa.f1085a.remove(activityEvent);
                }
                new ArrayList(collection);
            }
        }
        c();
    }

    public final synchronized void a(Application application) {
        if (this.f1038a == null) {
            this.f1038a = application;
        }
        b();
    }

    public final EnumC0435n a() {
        return this.b;
    }

    public final void a(Activity activity, ActivityEvent activityEvent) {
        Collection<ActivityLifecycleListener> collection;
        synchronized (this) {
            collection = (Collection) this.c.f1085a.get(activityEvent);
        }
        if (collection != null) {
            for (ActivityLifecycleListener activityLifecycleListener : collection) {
                activityLifecycleListener.onEvent(activity, activityEvent);
            }
        }
    }
}
