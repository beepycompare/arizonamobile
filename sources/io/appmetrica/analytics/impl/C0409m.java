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
    public final HashSet f1091a = new HashSet();

    public C0409m(C0461o c0461o) {
        c0461o.registerListener(this, new ActivityEvent[0]);
    }

    public final synchronized void a(InterfaceC0383l interfaceC0383l) {
        this.f1091a.add(interfaceC0383l);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        C0569s4.l().c.a().execute(new RunnableC0357k(this, activity));
    }

    public final void a(Activity activity) {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.f1091a);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((Cj) ((InterfaceC0383l) it.next())).a(activity);
        }
    }
}
