package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public final class Y1 implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f715a = new ArrayList();
    public volatile R7 b = null;

    public final void a(R7 r7) {
        ArrayList a2;
        synchronized (this) {
            this.b = r7;
            a2 = a();
        }
        Iterator it = a2.iterator();
        while (it.hasNext()) {
            ((InterfaceC0457ne) it.next()).consume(r7);
        }
    }

    public final void b() {
        C0696x4.l().e.registerListener(this, ActivityEvent.CREATED);
    }

    public final void c() {
        C0696x4.l().e.unregisterListener(this, ActivityEvent.CREATED);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        Intent intent = (Intent) SystemServiceUtils.accessSystemServiceSafely(activity, "getting intent", "activity", new W1());
        String dataString = intent == null ? null : intent.getDataString();
        if (TextUtils.isEmpty(dataString)) {
            return;
        }
        X1 x1 = new X1(dataString);
        synchronized (this) {
            R7 r7 = this.b;
            if (r7 == null) {
                this.f715a.add(x1);
            } else {
                ((S9) C0696x4.l().c.a()).b.post(new V1(x1, r7));
            }
        }
    }

    public final synchronized ArrayList a() {
        ArrayList arrayList;
        arrayList = new ArrayList(this.f715a);
        this.f715a.clear();
        return arrayList;
    }
}
