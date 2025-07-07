package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.w4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0679w4 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f1098a;
    public final C0730y5 b;
    public final HashMap c;
    public final Ia d;
    public final Context e;
    public final D4 f;

    public C0679w4(Context context, C0730y5 c0730y5) {
        this(context, c0730y5, new D4());
    }

    public final A4 a(C0405l4 c0405l4, K4 k4) {
        A4 a4;
        synchronized (this.f1098a) {
            a4 = (A4) this.c.get(c0405l4);
            if (a4 == null) {
                this.f.getClass();
                a4 = D4.a(c0405l4).a(this.e, this.b, c0405l4, k4);
                this.c.put(c0405l4, a4);
                this.d.a(new C0654v4(c0405l4.b, c0405l4.c, c0405l4.d), c0405l4);
            }
        }
        return a4;
    }

    public C0679w4(Context context, C0730y5 c0730y5, D4 d4) {
        this.f1098a = new Object();
        this.c = new HashMap();
        this.d = new Ia();
        this.e = context.getApplicationContext();
        this.b = c0730y5;
        this.f = d4;
    }

    public final void a(String str, Integer num, String str2) {
        synchronized (this.f1098a) {
            Ia ia = this.d;
            Collection<C0405l4> collection = (Collection) ia.f473a.remove(new C0654v4(str, num, str2));
            if (!fo.a(collection)) {
                collection.size();
                ArrayList arrayList = new ArrayList(collection.size());
                for (C0405l4 c0405l4 : collection) {
                    arrayList.add((A4) this.c.remove(c0405l4));
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((A4) it.next()).a();
                }
            }
        }
    }
}
