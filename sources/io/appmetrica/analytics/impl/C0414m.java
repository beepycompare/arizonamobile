package io.appmetrica.analytics.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
import java.util.HashSet;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.m  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0414m implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f1088a = new HashSet();

    public C0414m(C0466o c0466o) {
        c0466o.registerListener(this, new ActivityEvent[0]);
    }

    public final synchronized void a(InterfaceC0388l interfaceC0388l) {
        this.f1088a.add(interfaceC0388l);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        C0574s4.l().c.a().execute(new RunnableC0362k(this, activity));
    }

    public final void a(Activity activity) {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f1088a);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((Cj) ((InterfaceC0388l) it.next())).a(activity);
        }
    }
}
