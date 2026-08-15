package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class Ta extends P2 {
    public final Wa b;

    public Ta(int i) {
        this(i, null);
    }

    public int b(Object obj) {
        return 0;
    }

    public Ta(int i, Wa wa) {
        super(i);
        this.b = wa;
    }

    @Override // io.appmetrica.analytics.impl.P2, io.appmetrica.analytics.impl.Wa
    public final C0518po a(List<Object> list) {
        int i;
        int i2 = 0;
        if (list == null || (list.size() <= this.f713a && this.b == null)) {
            i = 0;
        } else {
            ArrayList arrayList = new ArrayList();
            i = 0;
            int i3 = 0;
            for (Object obj : list) {
                if (i3 < this.f713a) {
                    Wa wa = this.b;
                    if (wa != null) {
                        C0518po a2 = wa.a(obj);
                        Object obj2 = a2.f1155a;
                        i += a2.b.getBytesTruncated();
                        Oo.a(obj, a2.f1155a);
                        obj = obj2;
                    }
                    arrayList.add(obj);
                } else {
                    i2++;
                    i += b(obj);
                }
                i3++;
            }
            list = arrayList;
        }
        return new C0518po(list, new E4(i2, i));
    }

    public final Wa b() {
        return this.b;
    }
}
