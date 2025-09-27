package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class Qa extends R2 {
    public final Ta b;

    public Qa(int i) {
        this(i, null);
    }

    public int b(Object obj) {
        return 0;
    }

    public Qa(int i, Ta ta) {
        super(i);
        this.b = ta;
    }

    @Override // io.appmetrica.analytics.impl.R2, io.appmetrica.analytics.impl.Ta
    public final Sn a(List<Object> list) {
        int i;
        int i2 = 0;
        if (list == null || (list.size() <= this.f649a && this.b == null)) {
            i = 0;
        } else {
            ArrayList arrayList = new ArrayList();
            i = 0;
            int i3 = 0;
            for (Object obj : list) {
                if (i3 < this.f649a) {
                    Ta ta = this.b;
                    if (ta != null) {
                        Sn a2 = ta.a(obj);
                        Object obj2 = a2.f676a;
                        i += a2.b.getBytesTruncated();
                        ro.a(obj, a2.f676a);
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
        return new Sn(list, new L4(i2, i));
    }

    public final Ta b() {
        return this.b;
    }
}
