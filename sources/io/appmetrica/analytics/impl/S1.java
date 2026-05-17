package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public final class S1 implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f779a = new ArrayList();
    public volatile C0719y7 b = null;

    public final void a(C0719y7 c0719y7) {
        ArrayList a2;
        synchronized (this) {
            this.b = c0719y7;
            a2 = a();
        }
        Iterator it = a2.iterator();
        while (it.hasNext()) {
            ((InterfaceC0119ae) it.next()).consume(c0719y7);
        }
    }

    public final void b() {
        C0135b4.l().e.registerListener(this, ActivityEvent.CREATED);
    }

    public final void c() {
        C0135b4.l().e.unregisterListener(this, ActivityEvent.CREATED);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        Intent intent = (Intent) SystemServiceUtils.accessSystemServiceSafely(activity, "getting intent", "activity", new Q1());
        String dataString = intent == null ? null : intent.getDataString();
        if (TextUtils.isEmpty(dataString)) {
            return;
        }
        R1 r1 = new R1(dataString);
        synchronized (this) {
            C0719y7 c0719y7 = this.b;
            if (c0719y7 == null) {
                this.f779a.add(r1);
            } else {
                ((C0746z9) C0135b4.l().c.a()).b.post(new P1(r1, c0719y7));
            }
        }
    }

    public final synchronized ArrayList a() {
        ArrayList arrayList;
        arrayList = new ArrayList(this.f779a);
        this.f779a.clear();
        return arrayList;
    }
}
