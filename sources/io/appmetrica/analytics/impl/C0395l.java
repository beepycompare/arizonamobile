package io.appmetrica.analytics.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
import java.util.HashSet;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.l  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0395l implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f930a = new HashSet();

    public C0395l(C0445n c0445n) {
        c0445n.registerListener(this, new ActivityEvent[0]);
    }

    public final synchronized void a(InterfaceC0370k interfaceC0370k) {
        this.f930a.add(interfaceC0370k);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        C0699x4.l().c.a().execute(new RunnableC0345j(this, activity));
    }

    public final void a(Activity activity) {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f930a);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((C0490oj) ((InterfaceC0370k) it.next())).a(activity);
        }
    }
}
