package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
/* loaded from: classes5.dex */
public final class Jf implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final C0570sa f540a;

    public Jf() {
        this(new C0570sa(20, 100));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ei fromModel(List<String> list) {
        Nn a2 = this.f540a.a((List<Object>) list);
        List list2 = (List) a2.f611a;
        C0494p8[] c0494p8Arr = new C0494p8[0];
        if (list2 != null) {
            c0494p8Arr = new C0494p8[list2.size()];
            for (int i = 0; i < list2.size(); i++) {
                C0494p8 c0494p8 = new C0494p8();
                c0494p8Arr[i] = c0494p8;
                c0494p8.f1062a = StringUtils.getUTF8Bytes((String) list2.get(i));
            }
        }
        a2.b.getBytesTruncated();
        return new Ei(c0494p8Arr, a2.b);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ei ei = (Ei) obj;
        throw new UnsupportedOperationException();
    }

    public Jf(C0570sa c0570sa) {
        this.f540a = c0570sa;
    }

    public final List<String> a(Ei ei) {
        throw new UnsupportedOperationException();
    }
}
