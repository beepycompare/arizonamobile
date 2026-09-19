package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.r4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0548r4 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f1178a;
    public final C0601t5 b;
    public final HashMap c;
    public final Sa d;
    public final Context e;
    public final C0756z4 f;

    public C0548r4(Context context, C0601t5 c0601t5) {
        this(context, c0601t5, new C0756z4());
    }

    public final InterfaceC0678w4 a(C0264g4 c0264g4, G4 g4) {
        InterfaceC0678w4 interfaceC0678w4;
        synchronized (this.f1178a) {
            interfaceC0678w4 = (InterfaceC0678w4) this.c.get(c0264g4);
            if (interfaceC0678w4 == null) {
                this.f.getClass();
                interfaceC0678w4 = C0756z4.a(c0264g4).a(this.e, this.b, c0264g4, g4);
                this.c.put(c0264g4, interfaceC0678w4);
                this.d.a(new C0523q4(c0264g4.b, c0264g4.c, c0264g4.d), c0264g4);
            }
        }
        return interfaceC0678w4;
    }

    public C0548r4(Context context, C0601t5 c0601t5, C0756z4 c0756z4) {
        this.f1178a = new Object();
        this.c = new HashMap();
        this.d = new Sa();
        this.e = context.getApplicationContext();
        this.b = c0601t5;
        this.f = c0756z4;
    }

    public final void a(String str, Integer num, String str2) {
        synchronized (this.f1178a) {
            Sa sa = this.d;
            Collection<C0264g4> collection = (Collection) sa.f765a.remove(new C0523q4(str, num, str2));
            if (!Oo.a(collection)) {
                collection.size();
                ArrayList arrayList = new ArrayList(collection.size());
                for (C0264g4 c0264g4 : collection) {
                    arrayList.add((InterfaceC0678w4) this.c.remove(c0264g4));
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0678w4) it.next()).a();
                }
            }
        }
    }
}
