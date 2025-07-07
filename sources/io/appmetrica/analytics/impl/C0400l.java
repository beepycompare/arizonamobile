package io.appmetrica.analytics.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
import java.util.HashSet;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.l  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0400l implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f913a = new HashSet();

    public C0400l(C0450n c0450n) {
        c0450n.registerListener(this, new ActivityEvent[0]);
    }

    public final synchronized void a(InterfaceC0375k interfaceC0375k) {
        this.f913a.add(interfaceC0375k);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        C0704x4.l().c.a().execute(new RunnableC0350j(this, activity));
    }

    public final void a(Activity activity) {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f913a);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((C0420lj) ((InterfaceC0375k) it.next())).a(activity);
        }
    }
}
