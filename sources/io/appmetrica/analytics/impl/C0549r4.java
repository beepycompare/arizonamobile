package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.r4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0549r4 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f1178a;
    public final C0602t5 b;
    public final HashMap c;
    public final Sa d;
    public final Context e;
    public final C0757z4 f;

    public C0549r4(Context context, C0602t5 c0602t5) {
        this(context, c0602t5, new C0757z4());
    }

    public final InterfaceC0679w4 a(C0265g4 c0265g4, G4 g4) {
        InterfaceC0679w4 interfaceC0679w4;
        synchronized (this.f1178a) {
            interfaceC0679w4 = (InterfaceC0679w4) this.c.get(c0265g4);
            if (interfaceC0679w4 == null) {
                this.f.getClass();
                interfaceC0679w4 = C0757z4.a(c0265g4).a(this.e, this.b, c0265g4, g4);
                this.c.put(c0265g4, interfaceC0679w4);
                this.d.a(new C0524q4(c0265g4.b, c0265g4.c, c0265g4.d), c0265g4);
            }
        }
        return interfaceC0679w4;
    }

    public C0549r4(Context context, C0602t5 c0602t5, C0757z4 c0757z4) {
        this.f1178a = new Object();
        this.c = new HashMap();
        this.d = new Sa();
        this.e = context.getApplicationContext();
        this.b = c0602t5;
        this.f = c0757z4;
    }

    public final void a(String str, Integer num, String str2) {
        synchronized (this.f1178a) {
            Sa sa = this.d;
            Collection<C0265g4> collection = (Collection) sa.f765a.remove(new C0524q4(str, num, str2));
            if (!Oo.a(collection)) {
                collection.size();
                ArrayList arrayList = new ArrayList(collection.size());
                for (C0265g4 c0265g4 : collection) {
                    arrayList.add((InterfaceC0679w4) this.c.remove(c0265g4));
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0679w4) it.next()).a();
                }
            }
        }
    }
}
