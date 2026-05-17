package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
/* loaded from: classes5.dex */
public final class If implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0547ra f633a;

    public If() {
        this(new C0547ra(20, 100));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Di fromModel(List<String> list) {
        Mn a2 = this.f633a.a((List<Object>) list);
        List list2 = (List) a2.f704a;
        C0471o8[] c0471o8Arr = new C0471o8[0];
        if (list2 != null) {
            c0471o8Arr = new C0471o8[list2.size()];
            for (int i = 0; i < list2.size(); i++) {
                C0471o8 c0471o8 = new C0471o8();
                c0471o8Arr[i] = c0471o8;
                c0471o8.f1154a = StringUtils.getUTF8Bytes((String) list2.get(i));
            }
        }
        a2.b.getBytesTruncated();
        return new Di(c0471o8Arr, a2.b);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Di di = (Di) obj;
        throw new UnsupportedOperationException();
    }

    public If(C0547ra c0547ra) {
        this.f633a = c0547ra;
    }

    public final List<String> a(Di di) {
        throw new UnsupportedOperationException();
    }
}
