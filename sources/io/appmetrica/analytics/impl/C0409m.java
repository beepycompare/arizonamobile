package io.appmetrica.analytics.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
import java.util.HashSet;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.m  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0409m implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f1096a = new HashSet();

    public C0409m(C0459o c0459o) {
        c0459o.registerListener(this, new ActivityEvent[0]);
    }

    public final synchronized void a(InterfaceC0384l interfaceC0384l) {
        this.f1096a.add(interfaceC0384l);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        C0157c4.l().c.a().execute(new RunnableC0358k(this, activity));
    }

    public final void a(Activity activity) {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f1096a);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((C0172cj) ((InterfaceC0384l) it.next())).a(activity);
        }
    }
}
