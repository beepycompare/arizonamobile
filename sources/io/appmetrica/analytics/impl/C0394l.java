package io.appmetrica.analytics.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
import java.util.HashSet;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.l  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0394l implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f931a = new HashSet();

    public C0394l(C0444n c0444n) {
        c0444n.registerListener(this, new ActivityEvent[0]);
    }

    public final synchronized void a(InterfaceC0369k interfaceC0369k) {
        this.f931a.add(interfaceC0369k);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        C0698x4.l().c.a().execute(new RunnableC0344j(this, activity));
    }

    public final void a(Activity activity) {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f931a);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((C0489oj) ((InterfaceC0369k) it.next())).a(activity);
        }
    }
}
