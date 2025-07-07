package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class Ja extends O2 {
    public final Ma b;

    public Ja(int i) {
        this(i, null);
    }

    public int b(Object obj) {
        return 0;
    }

    public Ja(int i, Ma ma) {
        super(i);
        this.b = ma;
    }

    @Override // io.appmetrica.analytics.impl.O2, io.appmetrica.analytics.impl.Ma
    public final Gn a(List<Object> list) {
        int i;
        int i2 = 0;
        if (list == null || (list.size() <= this.f561a && this.b == null)) {
            i = 0;
        } else {
            ArrayList arrayList = new ArrayList();
            i = 0;
            int i3 = 0;
            for (Object obj : list) {
                if (i3 < this.f561a) {
                    Ma ma = this.b;
                    if (ma != null) {
                        Gn a2 = ma.a(obj);
                        Object obj2 = a2.f449a;
                        i += a2.b.getBytesTruncated();
                        fo.a(obj, a2.f449a);
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
        return new Gn(list, new I4(i2, i));
    }

    public final Ma b() {
        return this.b;
    }
}
