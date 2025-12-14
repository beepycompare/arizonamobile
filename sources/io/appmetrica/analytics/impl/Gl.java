package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes5.dex */
public final class Gl {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Il f593a;

    public Gl(Il il) {
        this.f593a = il;
    }

    public final void a(String str, Kl kl, C0278gm c0278gm) {
        ArrayList arrayList;
        synchronized (this.f593a.b) {
            Collection collection = (Collection) this.f593a.f626a.f1182a.get(str);
            if (collection == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = new ArrayList(collection);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Rl) it.next()).a(kl, c0278gm);
        }
    }
}
