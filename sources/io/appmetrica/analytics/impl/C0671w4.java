package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.w4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0671w4 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f1099a;
    public final C0722y5 b;
    public final HashMap c;
    public final Ia d;
    public final Context e;
    public final D4 f;

    public C0671w4(Context context, C0722y5 c0722y5) {
        this(context, c0722y5, new D4());
    }

    public final A4 a(C0397l4 c0397l4, K4 k4) {
        A4 a4;
        synchronized (this.f1099a) {
            a4 = (A4) this.c.get(c0397l4);
            if (a4 == null) {
                this.f.getClass();
                a4 = D4.a(c0397l4).a(this.e, this.b, c0397l4, k4);
                this.c.put(c0397l4, a4);
                this.d.a(new C0646v4(c0397l4.b, c0397l4.c, c0397l4.d), c0397l4);
            }
        }
        return a4;
    }

    public C0671w4(Context context, C0722y5 c0722y5, D4 d4) {
        this.f1099a = new Object();
        this.c = new HashMap();
        this.d = new Ia();
        this.e = context.getApplicationContext();
        this.b = c0722y5;
        this.f = d4;
    }

    public final void a(String str, Integer num, String str2) {
        synchronized (this.f1099a) {
            Ia ia = this.d;
            Collection<C0397l4> collection = (Collection) ia.f474a.remove(new C0646v4(str, num, str2));
            if (!fo.a(collection)) {
                collection.size();
                ArrayList arrayList = new ArrayList(collection.size());
                for (C0397l4 c0397l4 : collection) {
                    arrayList.add((A4) this.c.remove(c0397l4));
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((A4) it.next()).a();
                }
            }
        }
    }
}
