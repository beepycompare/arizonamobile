package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
/* loaded from: classes5.dex */
public final class Jf implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0569sa f623a;

    public Jf() {
        this(new C0569sa(20, 100));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ei fromModel(List<String> list) {
        Nn a2 = this.f623a.a((List<Object>) list);
        List list2 = (List) a2.f694a;
        C0493p8[] c0493p8Arr = new C0493p8[0];
        if (list2 != null) {
            c0493p8Arr = new C0493p8[list2.size()];
            for (int i = 0; i < list2.size(); i++) {
                C0493p8 c0493p8 = new C0493p8();
                c0493p8Arr[i] = c0493p8;
                c0493p8.f1145a = StringUtils.getUTF8Bytes((String) list2.get(i));
            }
        }
        a2.b.getBytesTruncated();
        return new Ei(c0493p8Arr, a2.b);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ei ei = (Ei) obj;
        throw new UnsupportedOperationException();
    }

    public Jf(C0569sa c0569sa) {
        this.f623a = c0569sa;
    }

    public final List<String> a(Ei ei) {
        throw new UnsupportedOperationException();
    }
}
