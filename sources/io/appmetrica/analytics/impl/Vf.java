package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.data.Converter;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.List;
/* loaded from: classes4.dex */
public final class Vf implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public final Ma f687a;

    public Vf() {
        this(new Ma(20, 100));
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final Qi fromModel(List<String> list) {
        Jn a2 = this.f687a.a((List<Object>) list);
        List list2 = (List) a2.f512a;
        I8[] i8Arr = new I8[0];
        if (list2 != null) {
            i8Arr = new I8[list2.size()];
            for (int i = 0; i < list2.size(); i++) {
                I8 i8 = new I8();
                i8Arr[i] = i8;
                i8.f488a = StringUtils.getUTF8Bytes((String) list2.get(i));
            }
        }
        a2.b.getBytesTruncated();
        return new Qi(i8Arr, a2.b);
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        Qi qi = (Qi) obj;
        throw new UnsupportedOperationException();
    }

    public Vf(Ma ma) {
        this.f687a = ma;
    }

    public final List<String> a(Qi qi) {
        throw new UnsupportedOperationException();
    }
}
