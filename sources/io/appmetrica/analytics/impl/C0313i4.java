package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.i4  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0313i4 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f924a;
    public final C0365k5 b;
    public final HashMap c;
    public final C0670wa d;
    public final Context e;
    public final C0490p4 f;

    public C0313i4(Context context, C0365k5 c0365k5) {
        this(context, c0365k5, new C0490p4());
    }

    public final InterfaceC0415m4 a(X3 x3, C0664w4 c0664w4) {
        InterfaceC0415m4 interfaceC0415m4;
        synchronized (this.f924a) {
            interfaceC0415m4 = (InterfaceC0415m4) this.c.get(x3);
            if (interfaceC0415m4 == null) {
                this.f.getClass();
                interfaceC0415m4 = C0490p4.a(x3).a(this.e, this.b, x3, c0664w4);
                this.c.put(x3, interfaceC0415m4);
                this.d.a(new C0287h4(x3.b, x3.c, x3.d), x3);
            }
        }
        return interfaceC0415m4;
    }

    public C0313i4(Context context, C0365k5 c0365k5, C0490p4 c0490p4) {
        this.f924a = new Object();
        this.c = new HashMap();
        this.d = new C0670wa();
        this.e = context.getApplicationContext();
        this.b = c0365k5;
        this.f = c0490p4;
    }

    public final void a(String str, Integer num, String str2) {
        synchronized (this.f924a) {
            C0670wa c0670wa = this.d;
            Collection<X3> collection = (Collection) c0670wa.f1183a.remove(new C0287h4(str, num, str2));
            if (!no.a(collection)) {
                collection.size();
                ArrayList arrayList = new ArrayList(collection.size());
                for (X3 x3 : collection) {
                    arrayList.add((InterfaceC0415m4) this.c.remove(x3));
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0415m4) it.next()).a();
                }
            }
        }
    }
}
