package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.r4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0550r4 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f1178a;
    public final C0603t5 b;
    public final HashMap c;
    public final Sa d;
    public final Context e;
    public final C0758z4 f;

    public C0550r4(Context context, C0603t5 c0603t5) {
        this(context, c0603t5, new C0758z4());
    }

    public final InterfaceC0680w4 a(C0266g4 c0266g4, G4 g4) {
        InterfaceC0680w4 interfaceC0680w4;
        synchronized (this.f1178a) {
            interfaceC0680w4 = (InterfaceC0680w4) this.c.get(c0266g4);
            if (interfaceC0680w4 == null) {
                this.f.getClass();
                interfaceC0680w4 = C0758z4.a(c0266g4).a(this.e, this.b, c0266g4, g4);
                this.c.put(c0266g4, interfaceC0680w4);
                this.d.a(new C0525q4(c0266g4.b, c0266g4.c, c0266g4.d), c0266g4);
            }
        }
        return interfaceC0680w4;
    }

    public C0550r4(Context context, C0603t5 c0603t5, C0758z4 c0758z4) {
        this.f1178a = new Object();
        this.c = new HashMap();
        this.d = new Sa();
        this.e = context.getApplicationContext();
        this.b = c0603t5;
        this.f = c0758z4;
    }

    public final void a(String str, Integer num, String str2) {
        synchronized (this.f1178a) {
            Sa sa = this.d;
            Collection<C0266g4> collection = (Collection) sa.f765a.remove(new C0525q4(str, num, str2));
            if (!Oo.a(collection)) {
                collection.size();
                ArrayList arrayList = new ArrayList(collection.size());
                for (C0266g4 c0266g4 : collection) {
                    arrayList.add((InterfaceC0680w4) this.c.remove(c0266g4));
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0680w4) it.next()).a();
                }
            }
        }
    }
}
