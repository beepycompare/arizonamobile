package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
/* loaded from: classes5.dex */
public final class If implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0548ra f628a;

    public If() {
        this(new C0548ra(20, 100));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Di fromModel(List<String> list) {
        Mn a2 = this.f628a.a((List<Object>) list);
        List list2 = (List) a2.f699a;
        C0472o8[] c0472o8Arr = new C0472o8[0];
        if (list2 != null) {
            c0472o8Arr = new C0472o8[list2.size()];
            for (int i = 0; i < list2.size(); i++) {
                C0472o8 c0472o8 = new C0472o8();
                c0472o8Arr[i] = c0472o8;
                c0472o8.f1149a = StringUtils.getUTF8Bytes((String) list2.get(i));
            }
        }
        a2.b.getBytesTruncated();
        return new Di(c0472o8Arr, a2.b);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Di di = (Di) obj;
        throw new UnsupportedOperationException();
    }

    public If(C0548ra c0548ra) {
        this.f628a = c0548ra;
    }

    public final List<String> a(Di di) {
        throw new UnsupportedOperationException();
    }
}
