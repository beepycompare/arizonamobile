package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
/* loaded from: classes4.dex */
public final class Tf implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Ka f642a;

    public Tf() {
        this(new Ka(20, 100));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Ni fromModel(List<String> list) {
        Gn a2 = this.f642a.a((List<Object>) list);
        List list2 = (List) a2.f450a;
        F8[] f8Arr = new F8[0];
        if (list2 != null) {
            f8Arr = new F8[list2.size()];
            for (int i = 0; i < list2.size(); i++) {
                F8 f8 = new F8();
                f8Arr[i] = f8;
                f8.f427a = StringUtils.getUTF8Bytes((String) list2.get(i));
            }
        }
        a2.b.getBytesTruncated();
        return new Ni(f8Arr, a2.b);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Ni ni = (Ni) obj;
        throw new UnsupportedOperationException();
    }

    public Tf(Ka ka) {
        this.f642a = ka;
    }

    public final List<String> a(Ni ni) {
        throw new UnsupportedOperationException();
    }
}
