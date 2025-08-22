package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class Na extends O2 {
    public final Qa b;

    public Na(int i) {
        this(i, null);
    }

    public int b(Object obj) {
        return 0;
    }

    public Na(int i, Qa qa) {
        super(i);
        this.b = qa;
    }

    @Override // io.appmetrica.analytics.impl.O2, io.appmetrica.analytics.impl.Qa
    public final On a(List<Object> list) {
        int i;
        int i2 = 0;
        if (list == null || (list.size() <= this.f584a && this.b == null)) {
            i = 0;
        } else {
            ArrayList arrayList = new ArrayList();
            i = 0;
            int i3 = 0;
            for (Object obj : list) {
                if (i3 < this.f584a) {
                    Qa qa = this.b;
                    if (qa != null) {
                        On a2 = qa.a(obj);
                        Object obj2 = a2.f594a;
                        i += a2.b.getBytesTruncated();
                        no.a(obj, a2.f594a);
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
        return new On(list, new I4(i2, i));
    }

    public final Qa b() {
        return this.b;
    }
}
