package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.a4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0110a4 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f898a;
    public final C0189d5 b;
    public final HashMap c;
    public final C0499pa d;
    public final Context e;
    public final C0317i4 f;

    public C0110a4(Context context, C0189d5 c0189d5) {
        this(context, c0189d5, new C0317i4());
    }

    public final InterfaceC0239f4 a(P3 p3, C0493p4 c0493p4) {
        InterfaceC0239f4 interfaceC0239f4;
        synchronized (this.f898a) {
            interfaceC0239f4 = (InterfaceC0239f4) this.c.get(p3);
            if (interfaceC0239f4 == null) {
                this.f.getClass();
                interfaceC0239f4 = C0317i4.a(p3).a(this.e, this.b, p3, c0493p4);
                this.c.put(p3, interfaceC0239f4);
                this.d.a(new Z3(p3.b, p3.c, p3.d), p3);
            }
        }
        return interfaceC0239f4;
    }

    public C0110a4(Context context, C0189d5 c0189d5, C0317i4 c0317i4) {
        this.f898a = new Object();
        this.c = new HashMap();
        this.d = new C0499pa();
        this.e = context.getApplicationContext();
        this.b = c0189d5;
        this.f = c0317i4;
    }

    public final void a(String str, Integer num, String str2) {
        synchronized (this.f898a) {
            C0499pa c0499pa = this.d;
            Collection<P3> collection = (Collection) c0499pa.f1173a.remove(new Z3(str, num, str2));
            if (!lo.a(collection)) {
                collection.size();
                ArrayList arrayList = new ArrayList(collection.size());
                for (P3 p3 : collection) {
                    arrayList.add((InterfaceC0239f4) this.c.remove(p3));
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0239f4) it.next()).a();
                }
            }
        }
    }
}
