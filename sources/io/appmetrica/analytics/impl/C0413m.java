package io.appmetrica.analytics.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
import java.util.HashSet;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.m  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0413m implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f1105a = new HashSet();

    public C0413m(C0463o c0463o) {
        c0463o.registerListener(this, new ActivityEvent[0]);
    }

    public final synchronized void a(InterfaceC0388l interfaceC0388l) {
        this.f1105a.add(interfaceC0388l);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        C0136b4.l().c.a().execute(new RunnableC0363k(this, activity));
    }

    public final void a(Activity activity) {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f1105a);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((C0151bj) ((InterfaceC0388l) it.next())).a(activity);
        }
    }
}
