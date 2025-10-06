package io.appmetrica.analytics.impl;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.z4  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0751z4 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f1183a;
    public final B5 b;
    public final HashMap c;
    public final Pa d;
    public final Context e;
    public final G4 f;

    public C0751z4(Context context, B5 b5) {
        this(context, b5, new G4());
    }

    public final D4 a(C0476o4 c0476o4, N4 n4) {
        D4 d4;
        synchronized (this.f1183a) {
            d4 = (D4) this.c.get(c0476o4);
            if (d4 == null) {
                this.f.getClass();
                d4 = G4.a(c0476o4).a(this.e, this.b, c0476o4, n4);
                this.c.put(c0476o4, d4);
                this.d.a(new C0726y4(c0476o4.b, c0476o4.c, c0476o4.d), c0476o4);
            }
        }
        return d4;
    }

    public C0751z4(Context context, B5 b5, G4 g4) {
        this.f1183a = new Object();
        this.c = new HashMap();
        this.d = new Pa();
        this.e = context.getApplicationContext();
        this.b = b5;
        this.f = g4;
    }

    public final void a(String str, Integer num, String str2) {
        synchronized (this.f1183a) {
            Pa pa = this.d;
            Collection<C0476o4> collection = (Collection) pa.f624a.remove(new C0726y4(str, num, str2));
            if (!ro.a(collection)) {
                collection.size();
                ArrayList arrayList = new ArrayList(collection.size());
                for (C0476o4 c0476o4 : collection) {
                    arrayList.add((D4) this.c.remove(c0476o4));
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((D4) it.next()).a();
                }
            }
        }
    }
}
