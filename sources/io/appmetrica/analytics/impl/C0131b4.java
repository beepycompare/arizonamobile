package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.b4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0131b4 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f907a;
    public final C0209e5 b;
    public final HashMap c;
    public final C0520qa d;
    public final Context e;
    public final C0337j4 f;

    public C0131b4(Context context, C0209e5 c0209e5) {
        this(context, c0209e5, new C0337j4());
    }

    public final InterfaceC0260g4 a(Q3 q3, C0514q4 c0514q4) {
        InterfaceC0260g4 interfaceC0260g4;
        synchronized (this.f907a) {
            interfaceC0260g4 = (InterfaceC0260g4) this.c.get(q3);
            if (interfaceC0260g4 == null) {
                this.f.getClass();
                interfaceC0260g4 = C0337j4.a(q3).a(this.e, this.b, q3, c0514q4);
                this.c.put(q3, interfaceC0260g4);
                this.d.a(new C0105a4(q3.b, q3.c, q3.d), q3);
            }
        }
        return interfaceC0260g4;
    }

    public C0131b4(Context context, C0209e5 c0209e5, C0337j4 c0337j4) {
        this.f907a = new Object();
        this.c = new HashMap();
        this.d = new C0520qa();
        this.e = context.getApplicationContext();
        this.b = c0209e5;
        this.f = c0337j4;
    }

    public final void a(String str, Integer num, String str2) {
        synchronized (this.f907a) {
            C0520qa c0520qa = this.d;
            Collection<Q3> collection = (Collection) c0520qa.f1182a.remove(new C0105a4(str, num, str2));
            if (!mo.a(collection)) {
                collection.size();
                ArrayList arrayList = new ArrayList(collection.size());
                for (Q3 q3 : collection) {
                    arrayList.add((InterfaceC0260g4) this.c.remove(q3));
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0260g4) it.next()).a();
                }
            }
        }
    }
}
