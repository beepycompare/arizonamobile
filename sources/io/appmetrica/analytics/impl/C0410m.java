package io.appmetrica.analytics.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
import java.util.HashSet;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.m  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0410m implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f998a = new HashSet();

    public C0410m(C0460o c0460o) {
        c0460o.registerListener(this, new ActivityEvent[0]);
    }

    public final synchronized void a(InterfaceC0385l interfaceC0385l) {
        this.f998a.add(interfaceC0385l);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        C0158c4.l().c.a().execute(new RunnableC0359k(this, activity));
    }

    public final void a(Activity activity) {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f998a);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((C0173cj) ((InterfaceC0385l) it.next())).a(activity);
        }
    }
}
