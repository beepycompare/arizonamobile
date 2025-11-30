package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.b4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0132b4 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f810a;
    public final C0210e5 b;
    public final HashMap c;
    public final C0521qa d;
    public final Context e;
    public final C0338j4 f;

    public C0132b4(Context context, C0210e5 c0210e5) {
        this(context, c0210e5, new C0338j4());
    }

    public final InterfaceC0261g4 a(Q3 q3, C0515q4 c0515q4) {
        InterfaceC0261g4 interfaceC0261g4;
        synchronized (this.f810a) {
            interfaceC0261g4 = (InterfaceC0261g4) this.c.get(q3);
            if (interfaceC0261g4 == null) {
                this.f.getClass();
                interfaceC0261g4 = C0338j4.a(q3).a(this.e, this.b, q3, c0515q4);
                this.c.put(q3, interfaceC0261g4);
                this.d.a(new C0106a4(q3.b, q3.c, q3.d), q3);
            }
        }
        return interfaceC0261g4;
    }

    public C0132b4(Context context, C0210e5 c0210e5, C0338j4 c0338j4) {
        this.f810a = new Object();
        this.c = new HashMap();
        this.d = new C0521qa();
        this.e = context.getApplicationContext();
        this.b = c0210e5;
        this.f = c0338j4;
    }

    public final void a(String str, Integer num, String str2) {
        synchronized (this.f810a) {
            C0521qa c0521qa = this.d;
            Collection<Q3> collection = (Collection) c0521qa.f1085a.remove(new C0106a4(str, num, str2));
            if (!mo.a(collection)) {
                collection.size();
                ArrayList arrayList = new ArrayList(collection.size());
                for (Q3 q3 : collection) {
                    arrayList.add((InterfaceC0261g4) this.c.remove(q3));
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0261g4) it.next()).a();
                }
            }
        }
    }
}
