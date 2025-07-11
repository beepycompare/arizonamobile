package io.appmetrica.analytics.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
import java.util.HashSet;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.l  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0392l implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f914a = new HashSet();

    public C0392l(C0442n c0442n) {
        c0442n.registerListener(this, new ActivityEvent[0]);
    }

    public final synchronized void a(InterfaceC0367k interfaceC0367k) {
        this.f914a.add(interfaceC0367k);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        C0696x4.l().c.a().execute(new RunnableC0342j(this, activity));
    }

    public final void a(Activity activity) {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f914a);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((C0412lj) ((InterfaceC0367k) it.next())).a(activity);
        }
    }
}
