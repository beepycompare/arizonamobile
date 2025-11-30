package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes5.dex */
public final class Gl {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Il f496a;

    public Gl(Il il) {
        this.f496a = il;
    }

    public final void a(String str, Kl kl, C0279gm c0279gm) {
        ArrayList arrayList;
        synchronized (this.f496a.b) {
            Collection collection = (Collection) this.f496a.f529a.f1085a.get(str);
            if (collection == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = new ArrayList(collection);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Rl) it.next()).a(kl, c0279gm);
        }
    }
}
