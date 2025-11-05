package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.xa  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0695xa extends K2 {
    public final Aa b;

    public C0695xa(int i) {
        this(i, null);
    }

    public int b(Object obj) {
        return 0;
    }

    public C0695xa(int i, Aa aa) {
        super(i);
        this.b = aa;
    }

    @Override // io.appmetrica.analytics.impl.K2, io.appmetrica.analytics.impl.Aa
    public final On a(List<Object> list) {
        int i;
        int i2 = 0;
        if (list == null || (list.size() <= this.f554a && this.b == null)) {
            i = 0;
        } else {
            ArrayList arrayList = new ArrayList();
            i = 0;
            int i3 = 0;
            for (Object obj : list) {
                if (i3 < this.f554a) {
                    Aa aa = this.b;
                    if (aa != null) {
                        On a2 = aa.a(obj);
                        Object obj2 = a2.f625a;
                        i += a2.b.getBytesTruncated();
                        no.a(obj, a2.f625a);
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
        return new On(list, new C0614u4(i2, i));
    }

    public final Aa b() {
        return this.b;
    }
}
