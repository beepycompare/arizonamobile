package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class La extends O2 {
    public final Oa b;

    public La(int i) {
        this(i, null);
    }

    public int b(Object obj) {
        return 0;
    }

    public La(int i, Oa oa) {
        super(i);
        this.b = oa;
    }

    @Override // io.appmetrica.analytics.impl.O2, io.appmetrica.analytics.impl.Oa
    public final Jn a(List<Object> list) {
        int i;
        int i2 = 0;
        if (list == null || (list.size() <= this.f570a && this.b == null)) {
            i = 0;
        } else {
            ArrayList arrayList = new ArrayList();
            i = 0;
            int i3 = 0;
            for (Object obj : list) {
                if (i3 < this.f570a) {
                    Oa oa = this.b;
                    if (oa != null) {
                        Jn a2 = oa.a(obj);
                        Object obj2 = a2.f511a;
                        i += a2.b.getBytesTruncated();
                        io.a(obj, a2.f511a);
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
        return new Jn(list, new I4(i2, i));
    }

    public final Oa b() {
        return this.b;
    }
}
