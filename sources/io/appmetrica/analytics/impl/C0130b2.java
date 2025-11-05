package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import java.util.ArrayList;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.b2  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0130b2 implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f810a = new ArrayList();
    public volatile G7 b = null;

    public final void a(G7 g7) {
        ArrayList a2;
        synchronized (this) {
            this.b = g7;
            a2 = a();
        }
        Iterator it = a2.iterator();
        while (it.hasNext()) {
            ((InterfaceC0297he) it.next()).consume(g7);
        }
    }

    public final void b() {
        C0338j4.l().e.registerListener(this, ActivityEvent.CREATED);
    }

    public final void c() {
        C0338j4.l().e.unregisterListener(this, ActivityEvent.CREATED);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        Intent intent = (Intent) SystemServiceUtils.accessSystemServiceSafely(activity, "getting intent", "activity", new Z1());
        String dataString = intent == null ? null : intent.getDataString();
        if (TextUtils.isEmpty(dataString)) {
            return;
        }
        C0104a2 c0104a2 = new C0104a2(dataString);
        synchronized (this) {
            G7 g7 = this.b;
            if (g7 == null) {
                this.f810a.add(c0104a2);
            } else {
                ((G9) C0338j4.l().c.a()).b.post(new Y1(c0104a2, g7));
            }
        }
    }

    public final synchronized ArrayList a() {
        ArrayList arrayList;
        arrayList = new ArrayList(this.f810a);
        this.f810a.clear();
        return arrayList;
    }
}
