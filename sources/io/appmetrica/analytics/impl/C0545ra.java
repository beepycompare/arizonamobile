package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.ra  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0545ra extends D2 {
    public final InterfaceC0620ua b;

    public C0545ra(int i) {
        this(i, null);
    }

    public int b(Object obj) {
        return 0;
    }

    public C0545ra(int i, InterfaceC0620ua interfaceC0620ua) {
        super(i);
        this.b = interfaceC0620ua;
    }

    @Override // io.appmetrica.analytics.impl.D2, io.appmetrica.analytics.impl.InterfaceC0620ua
    public final Nn a(List<Object> list) {
        int i;
        int i2 = 0;
        if (list == null || (list.size() <= this.f439a && this.b == null)) {
            i = 0;
        } else {
            ArrayList arrayList = new ArrayList();
            i = 0;
            int i3 = 0;
            for (Object obj : list) {
                if (i3 < this.f439a) {
                    InterfaceC0620ua interfaceC0620ua = this.b;
                    if (interfaceC0620ua != null) {
                        Nn a2 = interfaceC0620ua.a(obj);
                        Object obj2 = a2.f611a;
                        i += a2.b.getBytesTruncated();
                        mo.a(obj, a2.f611a);
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
        return new Nn(list, new C0465o4(i2, i));
    }

    public final InterfaceC0620ua b() {
        return this.b;
    }
}
