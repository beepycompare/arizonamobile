package io.appmetrica.analytics.impl;

import java.util.ArrayList;
import java.util.List;
/* renamed from: io.appmetrica.analytics.impl.qa  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0524qa extends C2 {
    public final InterfaceC0598ta b;

    public C0524qa(int i) {
        this(i, null);
    }

    public int b(Object obj) {
        return 0;
    }

    public C0524qa(int i, InterfaceC0598ta interfaceC0598ta) {
        super(i);
        this.b = interfaceC0598ta;
    }

    @Override // io.appmetrica.analytics.impl.C2, io.appmetrica.analytics.impl.InterfaceC0598ta
    public final Mn a(List<Object> list) {
        int i;
        int i2 = 0;
        if (list == null || (list.size() <= this.f529a && this.b == null)) {
            i = 0;
        } else {
            ArrayList arrayList = new ArrayList();
            i = 0;
            int i3 = 0;
            for (Object obj : list) {
                if (i3 < this.f529a) {
                    InterfaceC0598ta interfaceC0598ta = this.b;
                    if (interfaceC0598ta != null) {
                        Mn a2 = interfaceC0598ta.a(obj);
                        Object obj2 = a2.f700a;
                        i += a2.b.getBytesTruncated();
                        lo.a(obj, a2.f700a);
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
        return new Mn(list, new C0443n4(i2, i));
    }

    public final InterfaceC0598ta b() {
        return this.b;
    }
}
