package io.appmetrica.analytics.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
import java.util.HashSet;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.m  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0412m implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f1109a = new HashSet();

    public C0412m(C0462o c0462o) {
        c0462o.registerListener(this, new ActivityEvent[0]);
    }

    public final synchronized void a(InterfaceC0387l interfaceC0387l) {
        this.f1109a.add(interfaceC0387l);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        C0135b4.l().c.a().execute(new RunnableC0362k(this, activity));
    }

    public final void a(Activity activity) {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f1109a);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((C0150bj) ((InterfaceC0387l) it.next())).a(activity);
        }
    }
}
