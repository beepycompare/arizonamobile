package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Intent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import java.util.ArrayList;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.f2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0238f2 implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f975a = new ArrayList();
    public volatile Q7 b = null;

    public final void a(Q7 q7) {
        ArrayList a2;
        synchronized (this) {
            this.b = q7;
            a2 = a();
        }
        Iterator it = a2.iterator();
        while (it.hasNext()) {
            ((Be) it.next()).consume(q7);
        }
    }

    public final void b() {
        C0576s4.l().e.registerListener(this, ActivityEvent.CREATED);
    }

    public final void c() {
        C0576s4.l().e.unregisterListener(this, ActivityEvent.CREATED);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        Intent intent = (Intent) SystemServiceUtils.accessSystemServiceSafely(activity, "getting intent", "activity", new C0187d2());
        String dataString = intent == null ? null : intent.getDataString();
        if (StringUtils.isNullOrEmpty(dataString)) {
            return;
        }
        C0212e2 c0212e2 = new C0212e2(dataString);
        synchronized (this) {
            Q7 q7 = this.b;
            if (q7 == null) {
                this.f975a.add(c0212e2);
            } else {
                ((U9) C0576s4.l().c.a()).b.post(new RunnableC0161c2(c0212e2, q7));
            }
        }
    }

    public final synchronized ArrayList a() {
        ArrayList arrayList;
        arrayList = new ArrayList(this.f975a);
        this.f975a.clear();
        return arrayList;
    }
}
