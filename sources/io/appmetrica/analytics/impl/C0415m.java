package io.appmetrica.analytics.impl;

import android.app.Activity;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
import java.util.HashSet;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.m  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0415m implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final HashSet f1088a = new HashSet();

    public C0415m(C0467o c0467o) {
        c0467o.registerListener(this, new ActivityEvent[0]);
    }

    public final synchronized void a(InterfaceC0389l interfaceC0389l) {
        this.f1088a.add(interfaceC0389l);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        C0575s4.l().c.a().execute(new RunnableC0363k(this, activity));
    }

    public final void a(Activity activity) {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f1088a);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((Cj) ((InterfaceC0389l) it.next())).a(activity);
        }
    }
}
