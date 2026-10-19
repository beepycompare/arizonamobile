package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.r4  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0543r4 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f1181a;
    public final C0596t5 b;
    public final HashMap c;
    public final Sa d;
    public final Context e;
    public final C0751z4 f;

    public C0543r4(Context context, C0596t5 c0596t5) {
        this(context, c0596t5, new C0751z4());
    }

    public final InterfaceC0673w4 a(C0259g4 c0259g4, G4 g4) {
        InterfaceC0673w4 interfaceC0673w4;
        synchronized (this.f1181a) {
            interfaceC0673w4 = (InterfaceC0673w4) this.c.get(c0259g4);
            if (interfaceC0673w4 == null) {
                this.f.getClass();
                interfaceC0673w4 = C0751z4.a(c0259g4).a(this.e, this.b, c0259g4, g4);
                this.c.put(c0259g4, interfaceC0673w4);
                this.d.a(new C0518q4(c0259g4.b, c0259g4.c, c0259g4.d), c0259g4);
            }
        }
        return interfaceC0673w4;
    }

    public C0543r4(Context context, C0596t5 c0596t5, C0751z4 c0751z4) {
        this.f1181a = new Object();
        this.c = new HashMap();
        this.d = new Sa();
        this.e = context.getApplicationContext();
        this.b = c0596t5;
        this.f = c0751z4;
    }

    public final void a(String str, Integer num, String str2) {
        synchronized (this.f1181a) {
            Sa sa = this.d;
            Collection<C0259g4> collection = (Collection) sa.f768a.remove(new C0518q4(str, num, str2));
            if (!Oo.a(collection)) {
                collection.size();
                ArrayList arrayList = new ArrayList(collection.size());
                for (C0259g4 c0259g4 : collection) {
                    arrayList.add((InterfaceC0673w4) this.c.remove(c0259g4));
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0673w4) it.next()).a();
                }
            }
        }
    }
}
