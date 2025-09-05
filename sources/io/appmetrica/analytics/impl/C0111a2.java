package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityEvent;
import io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener;
import io.appmetrica.analytics.coreutils.internal.system.SystemServiceUtils;
import java.util.ArrayList;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.a2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0111a2 implements ActivityLifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f779a = new ArrayList();
    public volatile Y7 b = null;

    public final void a(Y7 y7) {
        ArrayList a2;
        synchronized (this) {
            this.b = y7;
            a2 = a();
        }
        Iterator it = a2.iterator();
        while (it.hasNext()) {
            ((InterfaceC0660ve) it.next()).consume(y7);
        }
    }

    public final void b() {
        A4.l().e.registerListener(this, ActivityEvent.CREATED);
    }

    public final void c() {
        A4.l().e.unregisterListener(this, ActivityEvent.CREATED);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.lifecycle.ActivityLifecycleListener
    public final void onEvent(Activity activity, ActivityEvent activityEvent) {
        Intent intent = (Intent) SystemServiceUtils.accessSystemServiceSafely(activity, "getting intent", "activity", new Y1());
        String dataString = intent == null ? null : intent.getDataString();
        if (TextUtils.isEmpty(dataString)) {
            return;
        }
        Z1 z1 = new Z1(dataString);
        synchronized (this) {
            Y7 y7 = this.b;
            if (y7 == null) {
                this.f779a.add(z1);
            } else {
                ((Z9) A4.l().c.a()).b.post(new X1(z1, y7));
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
