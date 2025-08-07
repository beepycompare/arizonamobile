package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.w4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0674w4 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f1112a;
    public final C0725y5 b;
    public final HashMap c;
    public final Ka d;
    public final Context e;
    public final D4 f;

    public C0674w4(Context context, C0725y5 c0725y5) {
        this(context, c0725y5, new D4());
    }

    public final A4 a(C0400l4 c0400l4, K4 k4) {
        A4 a4;
        synchronized (this.f1112a) {
            a4 = (A4) this.c.get(c0400l4);
            if (a4 == null) {
                this.f.getClass();
                a4 = D4.a(c0400l4).a(this.e, this.b, c0400l4, k4);
                this.c.put(c0400l4, a4);
                this.d.a(new C0649v4(c0400l4.b, c0400l4.c, c0400l4.d), c0400l4);
            }
        }
        return a4;
    }

    public C0674w4(Context context, C0725y5 c0725y5, D4 d4) {
        this.f1112a = new Object();
        this.c = new HashMap();
        this.d = new Ka();
        this.e = context.getApplicationContext();
        this.b = c0725y5;
        this.f = d4;
    }

    public final void a(String str, Integer num, String str2) {
        synchronized (this.f1112a) {
            Ka ka = this.d;
            Collection<C0400l4> collection = (Collection) ka.f519a.remove(new C0649v4(str, num, str2));
            if (!io.a(collection)) {
                collection.size();
                ArrayList arrayList = new ArrayList(collection.size());
                for (C0400l4 c0400l4 : collection) {
                    arrayList.add((A4) this.c.remove(c0400l4));
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((A4) it.next()).a();
                }
            }
        }
    }
}
