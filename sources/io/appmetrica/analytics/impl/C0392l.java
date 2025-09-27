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
    public final HashSet f960a = new HashSet();

    public C0392l(C0444n c0444n) {
        c0444n.registerListener(this, new ActivityEvent[0]);
    }

    public final synchronized void a(InterfaceC0366k interfaceC0366k) {
        this.f960a.add(interfaceC0366k);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        A4.l().c.a().execute(new RunnableC0340j(this, activity));
    }

    public final void a(Activity activity) {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f960a);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((C0715xj) ((InterfaceC0366k) it.next())).a(activity);
        }
    }
}
